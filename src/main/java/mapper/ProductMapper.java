package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.PageBean;
import pojo.Product;
import pojo.User;

import java.util.List;

@Mapper
public interface ProductMapper {
    /**
     * 查询所有
     */
    List<Product> selectAll();

    /**
     * 模糊查询商品
     *
     * @param p 要查询的字段
     */
    List<Product> selectByProductNameLikes(String p);

    /**
     * 查询热门的九个商品
     */
    List<Product> selectHot(@Param("is_hot") Integer is_hot, @Param("pflag") Integer pflag);

    /**
     * 查询最新的九个商品
     */
    List<Product> selectNew(@Param("pflag") Integer pflag);

    /**
     * 根据id查询商品
     */
    Product selectById(String pid);

    /**
     * 查询当前页数据
     */
    List<Product> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("cid") String cid, @Param("pflag") int pflag);

    /**
     * 获取总记录数
     */
    int selectTotalRecord(@Param("cid") String cid, @Param("pflag") int pflag);

    /**
     * 查询搜索结果当前页数据
     */
    List<Product> searchSelectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("p") String p, @Param("pflag") int pflag);

    /**
     * 获取搜索结果总记录数
     */
    int searchResultTotalRecord(@Param("p") String p, @Param("pflag") int pflag);
}
