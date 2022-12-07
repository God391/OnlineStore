package service.impl;

import constant.Contant;
import mapper.CategoryMapper;
import mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.Request;
import pojo.Category;
import pojo.PageBean;
import pojo.Product;
import service.ProductService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Product> selectHot() {
        SqlSession session = factory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectHot(Contant.PRODUCT_IS_HOT, Contant.PRODUCT_IS_UP);
        session.close();
        return products;
    }

    @Override
    public List<Product> selectNew() {
        SqlSession session = factory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectNew(Contant.PRODUCT_IS_UP);
        session.close();
        return products;
    }

    @Override
    public Product selectById(String pid) {
        SqlSession session = factory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        Product product = mapper.selectById(pid);
        session.close();
        return product;
    }

    @Override
    public PageBean<Product> selectByPage(int pageNumber, int pageSize, String cid) {
        //1.创建pageBean
        PageBean<Product> pb = new PageBean<Product>(pageNumber, pageSize);
        //2.设置当前页数据
        SqlSession sqlSession = factory.openSession();
        //查询当前页的商品
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectByPage(pb.getStartIndex(), pageSize, cid, Contant.PRODUCT_IS_UP);
        //查询分类
        CategoryMapper mapper1 = sqlSession.getMapper(CategoryMapper.class);
        Category category = mapper1.selectById(cid);
        for (Product product : products) {
            product.setCategory(category);
        }
        pb.setData(products);
        //3.设置总记录数
        int totalRecord = mapper.selectTotalRecord(cid, Contant.PRODUCT_IS_UP);
        pb.setTotalRecord(totalRecord);
        pb.setTotalPage();
        return pb;
    }

    @Override
    public PageBean<Product> searchSelectByPage(int pageNumber, int pageSize, String p) {
        //1.创建pageBean
        PageBean<Product> pb = new PageBean<Product>(pageNumber, pageSize);
        //2.设置当前页数据
        SqlSession sqlSession = factory.openSession();
        //查询当前页的商品
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = mapper.searchSelectByPage(pb.getStartIndex(), pageSize, p, Contant.PRODUCT_IS_UP);
        pb.setData(products);
        //3.设置总记录数
        int totalRecord = mapper.searchResultTotalRecord(p, Contant.PRODUCT_IS_UP);
        pb.setTotalRecord(totalRecord);
        return pb;
    }

    @Override
    public List<Product> selecAll() {
        //2.获取SqlSession对象
        SqlSession session = factory.openSession();

        //3.获取Mapper接口的代理对象
        ProductMapper mapper = session.getMapper(ProductMapper.class);

        //4.执行方法
        List<Product> products = mapper.selectAll();

        //5.关闭方法
        session.close();
        return products;
    }
}
