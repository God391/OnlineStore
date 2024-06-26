package service;

import pojo.Comment;

/**
 * @author f5gua
 */
public interface CommentService {

    /**
     * 添加评论
     * @param comment
     */
    void addComment(Comment comment) throws Exception;

    String queryByPid(String pid);

    Comment queryBycommentId(String commentId);

    void deleteBycommentId(String commentId);

    void updateComment(Comment comment);
}
