package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 查询所有
     *
     * @return 分类集合
     */
    List<Category> selectAll();

    /**
     * 按类别查询
     *
     * @param cid 分类编号
     * @return 类别
     */
    Category selectById(String cid);

    /**
     * 添加分类
     */

    void addUI(@Param("cname")String cname, @Param("cid")String cid);
    /**
     * 删除分类
     */
    void deleteByid(String cid);
    /**
     * 根据 id 查询类别对象
     * @param cid
     *@return
     */
    Category queryById(String cid);
}
