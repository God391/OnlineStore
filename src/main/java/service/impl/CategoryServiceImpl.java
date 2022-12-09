package service.impl;

import com.alibaba.fastjson.JSON;
import mapper.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;
import service.CategoryService;
import utils.SqlSessionFactoryUtils;

import javax.mail.Quota;
import java.io.InputStream;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有分类
     */
    @Override
    public String findAll() throws Exception {
        //1.调用mapper查询所有分类
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        List<Category> categories = mapper.selectAll();
        session.close();
        //2.将list转换成json字符串
        if (categories != null && categories.size() > 0) {
            return JSON.toJSONString(categories);
        }
        return null;
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public Category queryById(String cid) throws Exception {
        //1.调用 mapper 获取对象
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        Category category = mapper.queryById(cid);
        session.close();
        return category;
    }

    public List<Category> findAll2(){


        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);

        List<Category> categories = mapper.selectAll();
        session.close();
        return categories;
    }

    @Override
    public void addUI(String cname,String cid) throws Exception {
        //接收参数


        //封装对象
//        Category category = new Category();
//        category.setCname(canme);

        //1.获取SqlSessionFactory
//        String resources = "mybatis-config.xml";
//        InputStream inputStream= Resources.getResourceAsStream(resources);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);

        //4.执行方法
        mapper.addUI(cname,cid);

        //提交事务
        session.commit();

        //5.关闭方法
        session.close();
    }

    @Override
    public void delete(String cid) throws Exception {
        //2.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);

        //4.执行方法
        mapper.deleteByid(cid);

        //提交事务
        session.commit();

        //5.关闭方法
        session.close();
    }


}
