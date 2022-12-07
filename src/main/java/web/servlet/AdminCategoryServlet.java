package web.servlet;

import pojo.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import utils.UUIDUtils;
import web.servlet.base.BaseServlet;

import javax.management.MBeanServerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台分类管理模块
 */
@WebServlet("/admin")
public class AdminCategoryServlet extends BaseServlet {
    private static final long serivalVersionUID = 1L;

    /**
     * 展示所有分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            try {
            //1.调用所有service 获取所有的分类
            CategoryServiceImpl service = new CategoryServiceImpl();
            List<Category> list = service.findAll2();


            //2.将返回值放入request域中请求转发
            request.setAttribute("list", list);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return "/admin/category/list.jsp";
    }

    /**
     * 跳转到添加页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String addUI(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/admin/category/add.jsp";
    }

    /**
     * 添加分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.封装Category对象
        Category c = new Category();
        c.setCid(UUIDUtils.getId());
        c.setCname(request.getParameter("cname"));

        //2.调用mybatis完成添加操作
        CategoryServiceImpl service = new CategoryServiceImpl();
        service.addUI(c.getCname(),c.getCid());

        //3.重定向
//        response.sendRedirect(request.getContextPath()+"/addUI");
        findAll(request,response);
        return null;
}

    /**
     * 删除分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.封装Category对象
        Category c = new Category();
//        c.setCid(UUIDUtils.getId());
        c.setCid(request.getParameter("cid"));

        //2.调用mybatis完成添加操作
        CategoryServiceImpl service = new CategoryServiceImpl();
        service.delete(c.getCid());
        findAll(request,response);
        return null;
    }
}
