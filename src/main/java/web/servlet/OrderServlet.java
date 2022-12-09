package web.servlet;

import constant.Contant;
import pojo.*;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.UUIDUtils;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {

    /**
     * 保存订单
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //0.获取用户
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //未登录
            request.setAttribute("msg", "请先登录");
            return "/jsp/msg.jsp";
        }

        //1.封装订单
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Order order = new Order();
        order.setOid(UUIDUtils.getId());
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setState(Contant.ORDER_NON_PAYMENT);
        order.setUser(user);
        for (CartItem cartItem : cart.getCartItems()) {
            //封装成订单项
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setCount(cartItem.getCount());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);
            //将订单项放入订单中
            order.getItems().add(orderItem);
        }

        //2.调用service保存
        OrderService service = new OrderServiceImpl();
        service.save(order);

        //3.请求转发
        request.setAttribute("order", order);

        return "/jsp/order_info.jsp";

    }

    /**
     * 分页展示我的订单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String selectMyOrdersByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 获取参数
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            // 未登录
            request.setAttribute("msg", "请先登录");
            return "/jsp/msg.jsp";
        }
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = 3;
        PageBean<Order> orderPageBean = null;
        try {
            // 2. 调用 service 获取当前页的所有数据 pageBean
            OrderService service = new OrderServiceImpl();
            orderPageBean = service.selectMyOrdersByPage(pageNumber, pageSize, user.getUid());
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "获取我的订单失败");
            return "/jsp/msg.jsp";
        }

        // 3. 将 pageBean 放入 request 域中，请求转发到 order list
        request.setAttribute("pb", orderPageBean);

        return "/jsp/order_list.jsp";

    }

    /**
     * 在线支付
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     *//*
    public String pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 获取收货人信息，获取oid，获取银行

        // 2. 调用 service 获取订单，修改收货人信息，更新订单

        // 3. 拼接给第三方的 url

        // 4. 重定向
        //接受参数
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String oid = request.getParameter("oid");

        //通过id获取order

        OrderService service = new OrderServiceImpl();


        order.setAddress(address);
        order.setName(name);
        order.setTelephone(telephone);

        //更新order
        s.updateOrder(order);

        respone.sendRedirect(sb);

        return null;
        //
    }*/

}
