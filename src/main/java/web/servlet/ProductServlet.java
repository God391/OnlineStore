package web.servlet;

import pojo.PageBean;
import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends BaseServlet {
    /**
     * 规定版本序列化id，提高版本兼容性
     */
    private static final long serialVersionUID = 1L;

    public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取pid
        String pid = request.getParameter("pid");
        // 2.调用service
        ProductService service = new ProductServiceImpl();
        Product product = service.selectById(pid);
        // 3.返回结果
        if (product != null) {
            request.setAttribute("product", product);
        } else {
            request.setAttribute("msg", "查询失败");
        }

        return "/jsp/product_info.jsp";
    }

    /**
     *分类商品分页展示
     */
    public String selectByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取pageNumber cid 设置pageSize
        int pageNumber = 1;
        try {
        pageNumber = Integer.parseInt(request.getParameter( "pageNumber"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //一页12个
        int pageSize = 12;
        String cid = request.getParameter("cid");
        //cid为空就转发给搜索分页
        if(cid==null || "".equals(cid)){
            return searchSelectByPage(request, response);
        }
        //2.调用service 分页查询商品
        ProductService service = new ProductServiceImpl();
        PageBean<Product> pb = service.selectByPage(pageNumber, pageSize, cid);
        //3.将pageProducts放入request中
        request.setAttribute("pb", pb);
        // 4.返回结果
        return "/admin/product/list.jsp";
    }

    /**
     *搜索结果分页展示
     */
    public String searchSelectByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取pageNumber p 设置pageSize
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(request.getParameter( "pageNumber"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //一页12个
        int pageSize = 12;
        String p = request.getParameter("p");
        request.setAttribute("p", p);
        //2.调用service 分页查询商品
        ProductService service = new ProductServiceImpl();
        PageBean<Product> pb = service.searchSelectByPage(pageNumber, pageSize, p);
        //3.将pageProducts放入request中
        request.setAttribute("pb", pb);
        // 4.返回结果
        return "/jsp/product_list.jsp";
    }
}
