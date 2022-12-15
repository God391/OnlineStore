package web.servlet;

import pojo.Comment;
import pojo.User;
import service.CommentService;
import service.impl.CommentServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addCommentUiServlet")
public class AddCommentUiServlet extends BaseServlet {

    public String addCommentUi(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String pid = request.getParameter("pid");
        request.setAttribute("pid", pid);
        return "/jsp/comment_add.jsp";

    }

    public String deleteComment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 获取 user
        User user = (User) request.getSession().getAttribute("user");

        String pid = request.getParameter("pid");
        String commentId = request.getParameter("commentId");

        CommentService cs = new CommentServiceImpl();
        Comment comment = cs.queryBycommentId(commentId);

        if (comment.getUser_id().equals(user.getUid())) {
            cs.deleteBycommentId(commentId);
            response.sendRedirect(request.getContextPath() + "product?method=getById&pid=" + pid);
        } else {
            request.setAttribute("msg", "只能删除自己的评论哦");
            return "/jsp/msg.jsp";
        }

        return null;

    }

    public String updateComment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 获取 user
        User user = (User) request.getSession().getAttribute("user");

        String pid = request.getParameter("pid");
        String commentId = request.getParameter("commentId");

        CommentService cs = new CommentServiceImpl();
        Comment comment = cs.queryBycommentId(commentId);

        if (comment.getUser_id().equals(user.getUid())) {
            request.setAttribute("comment", comment);
            request.getRequestDispatcher("/jsp/comment_update.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "只能修改自己的评论哦");
            return "/jsp/msg.jsp";
        }

        return null;

    }
}
