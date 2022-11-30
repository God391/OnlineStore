package service.impl;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import service.UserService;
import utils.MailUtils;
import utils.SqlSessionFactoryUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServiceImpl implements UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 用户注册
     */
    @Override
    public void register(User user) throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User login(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(username, password);
        sqlSession.close();
        return user;
    }

}
