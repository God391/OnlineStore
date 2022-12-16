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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 评论模块
 *
 * @author f5gua
 */
@WebServlet("/comment")
public class CommentServlet extends BaseServlet {

    public String addComment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 获取 user, product
        User user = (User) request.getSession().getAttribute("user");

        // 1. 获取数据
        String content = request.getParameter("memo");
        String pid = request.getParameter("pid");
        Integer rating = Integer.valueOf(request.getParameter("score"));

        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        // 获取当前时间
        Date d = new Date();
        // 输出已经格式化的现在时间（24小时制）
        String date = sdf.format(d);

        // 2. 封装评论
        Comment comment = new Comment();
        comment.setComment_id(UUIDUtils.getId());
        comment.setUser_id(user.getUid());
        comment.setContent(content);
        comment.setPid(pid);
        comment.setUsername(user.getUsername());
        comment.setRating(rating);
        comment.setState(0);
        comment.setCreatetime(date);
        comment.setUpdatetime(date);

        System.out.println(comment);

        // 3. 调用service保存
        CommentService cs = new CommentServiceImpl();
        cs.addComment(comment);

        response.sendRedirect(request.getContextPath() + "product?method=getById&pid=" + pid);

        return null;
    }

    public String updateComment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 获取 user, product
        User user = (User) request.getSession().getAttribute("user");

        // 1. 获取数据
        String content = request.getParameter("memo");
        String commentId = request.getParameter("commentId");
        String pid = request.getParameter("pid");
        Integer rating = Integer.valueOf(request.getParameter("score"));

        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        // 获取当前时间
        Date d = new Date();
        // 输出已经格式化的现在时间（24小时制）
        String date = sdf.format(d);

        // 2. 封装评论
        Comment comment = new Comment();
        comment.setComment_id(commentId);
        comment.setUser_id(user.getUid());
        comment.setContent(content);
        comment.setPid(pid);
        comment.setUsername(user.getUsername());
        comment.setRating(rating);
        comment.setState(0);
        comment.setCreatetime(date);
        comment.setUpdatetime(date);

        // 3. 调用service保存
        CommentService cs = new CommentServiceImpl();
        cs.updateComment(comment);

        response.sendRedirect(request.getContextPath() + "product?method=getById&pid=" + pid);

        return null;
    }

    public String queryByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 0. 获取 pid
        String pid = request.getParameter("pid");

        // 1. 设置响应编码
        response.setContentType("text/json;charset=utf-8");

        // 2. 调用 service，查询所有分类，返回值 json 字符串
        CommentService cs = new CommentServiceImpl();
        String value = cs.queryByPid(pid);

        // 3. 将字符串写回浏览器
        response.getWriter().println(value);

        return null;
    }

}
