package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Product;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 查询所有商品
     *
     * @return 商品集合
     */
    List<Product> selectAll();

    /**
     * 模糊查询商品
     *
     * @param p 要查询的字段
     * @return 商品集合
     */
    List<Product> selectByProductNameLikes(String p);

    /**
     * 查询热门的九个商品
     *
     * @param is_hot 是否热门   1:热门    0:不热门
     * @param pflag  是否下架     1:下架	0:未下架
     * @return 商品集合
     */
    List<Product> selectHot(@Param("is_hot") Integer is_hot, @Param("pflag") Integer pflag);

    /**
     * 查询最新的九个商品
     *
     * @param pflag 是否下架     1:下架	0:未下架
     * @return 商品集合
     */
    List<Product> selectNew(@Param("pflag") Integer pflag);

    /**
     * 根据id查询商品
     *
     * @param pid 商品ID
     * @return 商品
     */
    Product selectById(String pid);

    /**
     * 查询当前页数据
     *
     * @param pflag    是否下架     1:下架	0:未下架
     * @param pageSize 每页显示的条数
     * @param cid      分类ID
     * @param start    起始页
     * @return 商品集合
     */
    List<Product> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("cid") String cid, @Param("pflag") int pflag);

    /**
     * 获取总记录数
     *
     * @param cid   分类ID
     * @param pflag 是否下架     1:下架	0:未下架
     * @return 总记录数
     */
    int selectTotalRecord(@Param("cid") String cid, @Param("pflag") int pflag);

    /**
     * 查询搜索结果当前页数据
     *
     * @param pflag    是否下架     1:下架	0:未下架
     * @param start    起始页
     * @param pageSize 每页显示的条数
     * @param p        要查询的字段
     * @return 商品集合
     */
    List<Product> searchSelectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("p") String p, @Param("pflag") int pflag);

    /**
     * 获取搜索结果总记录数
     *
     * @param p     要查询的字段
     * @param pflag 是否下架     1:下架	0:未下架
     * @return 搜索结果总记录数
     */
    int searchResultTotalRecord(@Param("p") String p, @Param("pflag") int pflag);

}
