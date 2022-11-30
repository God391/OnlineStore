package web.servlet;

import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 首页模块
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet {
    /**
     * 规定版本序列化id，提高版本兼容性
     */
    private static final long serialVersionUID = 1L;

    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.查询最新和热门商品
        ProductService ps = new ProductServiceImpl();
        List<Product> hotList = ps.selectHot();
        List<Product> newList = ps.selectNew();
        //2.将两个list都放入request域中
        request.setAttribute("hotList", hotList);
        request.setAttribute("newList", newList);
        return "/jsp/index.jsp";
    }
}
