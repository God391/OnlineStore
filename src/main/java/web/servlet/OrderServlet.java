package web.servlet;

import constant.Contant;
import pojo.*;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.UUIDUtils;
import web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {
    /**
     * 规定版本序列化id，提高版本兼容性
     */
    private static final long serialVersionUID = 1L;

    /**
     * 保存订单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //0.获取用户
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
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

    public String selectMyOrdersByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取参数
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = 3;
        User user = (User) request.getSession().getAttribute("user");
        PageBean<Order> orderPageBean = null;
        if (user == null) {
            // 未登录
            request.setAttribute("msg", "请先登录");
            return "/jsp/msg.jsp";
        }
        try {
            //2.调用service获取当前页的所有数据pageBean
            OrderService service = new OrderServiceImpl();
            orderPageBean = service.selectMyOrdersByPage(pageNumber, pageSize, user.getUid());
        }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "获取我的订单失败");
            return "/jsp/msg.jsp";
        }
        //3.将pageBean放入request域中，请求转发到order list
        request.setAttribute("pb", orderPageBean);
        return "/jsp/order_list.jsp";
    }
}
