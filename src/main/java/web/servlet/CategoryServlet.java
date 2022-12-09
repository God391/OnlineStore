package web.servlet;

import service.CategoryService;
import service.impl.CategoryServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {

    /**
     * 查询所有分类
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 设置响应编码
        response.setContentType("text/html;charset=utf-8");

        // 1. 调用 service，查询所有分类，返回值 json 字符串
        CategoryService service = new CategoryServiceImpl();
        String value = service.findAll();

        // 2. 将字符串写回浏览器
        response.getWriter().println(value);

        return null;
    }
}
