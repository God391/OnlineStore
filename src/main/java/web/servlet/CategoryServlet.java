package web.servlet;

import pojo.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
    /**
     * 规定版本序列化id，提高版本兼容性
     */
    private static final long serialVersionUID = 1L;

    /**
     *查询所有分类
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //0.设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //1.调用service，查询所有分类，返回值json字符串
        CategoryService service = new CategoryServiceImpl();
        String value = service.findAll();
        //2.将字符串写回浏览器
        response.getWriter().println(value);
        return null;
    }
}
