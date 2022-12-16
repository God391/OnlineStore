package service.impl;

import com.alibaba.fastjson.JSON;
import mapper.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Comment;
import service.CommentService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @author f5gua
 */
public class CommentServiceImpl implements CommentService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 添加评论
     *
     * @param comment
     */
    @Override
    public void addComment(Comment comment) {
        //1.调用 mapper 获取对象
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper mapper = session.getMapper(CommentMapper.class);
        mapper.addComment(comment);
        session.commit();
        session.close();
    }

    /**
     * @return
     */
    @Override
    public String queryByPid(String pid) {

        //1.调用mapper查询
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper mapper = session.getMapper(CommentMapper.class);
        List<Comment> comments = mapper.queryByPid(pid);
        session.close();

        //2.将 comments 转换成json字符串
        if (comments != null && comments.size() > 0) {
            return JSON.toJSONString(comments);
        }
        return null;

    }

    /**
     * @param commentId
     * @return
     */
    @Override
    public Comment queryBycommentId(String commentId) {

        //1.调用 mapper 查询
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper mapper = session.getMapper(CommentMapper.class);
        Comment comment = mapper.queryByCommentId(commentId);
        session.close();

        return comment;
    }

    /**
     * @param commentId
     */
    @Override
    public void deleteBycommentId(String commentId) {
        //1.调用 mapper 删除
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper mapper = session.getMapper(CommentMapper.class);
        mapper.deleteBycommentId(commentId);
        session.commit();
        session.close();
    }

    /**
     * @param comment
     */
    @Override
    public void updateComment(Comment comment) {
        //1.调用 mapper 获取对象
        SqlSession session = sqlSessionFactory.openSession();
        CommentMapper mapper = session.getMapper(CommentMapper.class);
        mapper.updateComment(comment);
        session.commit();
        session.close();
    }
}
