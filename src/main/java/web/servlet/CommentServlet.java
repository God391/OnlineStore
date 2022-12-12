package web.servlet;

import pojo.Comment;
import pojo.User;
import service.CommentService;
import service.impl.CommentServiceImpl;
import utils.UUIDUtils;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        //
        String content = request.getParameter("memo");
        String pid = request.getParameter("pid");
        Integer rating = Integer.valueOf(request.getParameter("score"));
        long date = System.currentTimeMillis();

        // 1. 获取 user, product
        User user = (User) request.getSession().getAttribute("user");

        // 2. 封装评论
        Comment comment = new Comment();
        comment.setCommentId(UUIDUtils.getId());
        comment.setUserId(user.getUid());
        comment.setContent(content);
        comment.setPid(pid);
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
}
