package web.servlet;

import pojo.Comment;
import pojo.User;
import service.CategoryService;
import service.CommentService;
import service.impl.CategoryServiceImpl;
import service.impl.CommentServiceImpl;
import utils.UUIDUtils;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 评论模块
 *
 * @author f5gua
 */
@WebServlet("/comment")
public class CommentServlet extends BaseServlet {

    public String addCommentUi(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        request.setAttribute("pid", pid);
        return "/jsp/comment.jsp";
    }

    public String addComment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 获取 user, product
        User user = (User) request.getSession().getAttribute("user");

        // 1. 获取数据
        String content = request.getParameter("memo");
        String pid = request.getParameter("pid");
        Integer rating = Integer.valueOf(request.getParameter("score"));

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date d = new Date();
        System.out.println("现在时间：" + sdf.format(d));
        String date = sdf.format(d);



        // 2. 封装评论
        Comment comment = new Comment();
        comment.setCommentId(UUIDUtils.getId());
        comment.setUserId(user.getUid());
        comment.setContent(content);
        comment.setPid(pid);
        comment.setUserName(user.getUsername());
        comment.setRating(rating);
        comment.setState(0);
        comment.setCreateTime(date);
        comment.setUpdateTime(date);

        System.out.println();

        System.out.println("===========================================");
        System.out.println(comment);

        // 3. 调用service保存
        CommentService cs = new CommentServiceImpl();
        cs.addComment(comment);

        response.sendRedirect(request.getContextPath() + "product?method=getById&pid=" + pid);

        return null;
    }

    public String queryByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String pid = request.getParameter("pid");

        // 0. 设置响应编码
        response.setContentType("text/html;charset=utf-8");

        // 1. 调用 service，查询所有分类，返回值 json 字符串
        CommentService cs = new CommentServiceImpl();
        String value = cs.queryByPid(pid);

        // 2. 将字符串写回浏览器
        response.getWriter().println(value);

        /*request.setAttribute("length", value.length());
        request.getRequestDispatcher("/jsp/product_info.jsp").forward(request, response);*/

        return null;

    }
}
