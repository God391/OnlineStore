package service.impl;

import com.alibaba.fastjson.JSON;
import mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Category;
import service.CategoryService;
import utils.SqlSessionFactoryUtils;

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
}
