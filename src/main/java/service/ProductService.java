package service;

import pojo.PageBean;
import pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询热门
     */
    List<Product> selectHot();

    /**
     * 查询最新
     */
    List<Product> selectNew();

    /**
     * 根据id查询
     */
    Product selectById(String pid);

    /**
     *分页展示商品
     */
    PageBean<Product> selectByPage(int pageNumber, int pageSize, String cid);

    /**
     *分页展示搜索结果
     */
    PageBean<Product> searchSelectByPage(int pageNumber, int pageSize, String p);
}
