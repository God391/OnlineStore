package service.impl;

import mapper.CategoryMapper;
import mapper.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Category;
import pojo.Comment;
import service.CommentService;
import utils.SqlSessionFactoryUtils;

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
}
