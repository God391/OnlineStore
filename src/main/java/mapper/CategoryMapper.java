package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     *  查询所有
     */
    List<Category> selectAll();

    /**
     *  按类别查询
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
}
