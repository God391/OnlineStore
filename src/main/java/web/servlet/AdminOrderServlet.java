package web.servlet;

import com.alibaba.fastjson.JSON;
import constant.Contant;
import pojo.Order;
import pojo.OrderItem;
import pojo.OrderItemNoOrder;
import pojo.PageBean;
import service.OrderService;
import service.impl.OrderServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/adminOrder")
public class AdminOrderServlet extends BaseServlet {

    /**
     * 后台按状态分页查询订单列表
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findAllByState(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 获取 pageNumber, cid; 设置 pageSize
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // 一页 12 个
        int pageSize = 4;

        // 1. 获取 state
        String state = request.getParameter("state");

        // 2. 调用 service 获取不同列表
        OrderService os = new OrderServiceImpl();
        // List<Order> orders = os.queryAllByState(state);
        PageBean<Order> pb = os.queryAllByState(pageNumber, pageSize, state);

        // 3. 将 list 放入 request 域中，请求转发
        request.setAttribute("pb", pb);

        return "/admin/order/list.jsp";

    }

    /**
     * 展示订单详情
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String showDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            // 0. 设置响应编码
            response.setContentType("text/json;charset=utf-8");

            // 1. 获取 oid
            String oid = request.getParameter("oid");

            // 2. 调用 service
            OrderService os = new OrderServiceImpl();
            //Order order = os.getById(oid);
            List<OrderItemNoOrder> items = os.getByOid(oid);
            String s = JSON.toJSONString(items);
            System.out.println("s: " + s);
            response.getWriter().println(s);

            // 3. 获取订单的订单项目列表，转成 json，写回浏览器
            /*if (order != null) {
                List<OrderItem> items = order.getItems();
                System.out.println("================items==================");
                System.out.println(items);
                System.out.println("=======================================");
                if (items != null || items.size() > 0) {
                    String s = (String) JSON.toJSONString(items);
                    System.out.println("s: " + s);
                    response.getWriter().println(s);
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 修改订单状态
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String updateState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 获取 oid
        String oid = request.getParameter("oid");

        // 2. 调用 service，获取订单
        OrderService os = new OrderServiceImpl();
        Order order = os.getById(oid);

        // 3. 设置订单状态，更新
        order.setState(Contant.ORDER_SHIPPED);
        os.updateState(order);

        // 4. 重定向
        response.sendRedirect(request.getContextPath() + "/adminOrder?method=findAllByState&state=1");
        return null;
    }
}
