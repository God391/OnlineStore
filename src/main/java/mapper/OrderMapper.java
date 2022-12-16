package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 添加订单
     *
     * @param order 订单
     */
    void add(Order order);

    /**
     * 获取订单总数
     *
     * @param uid 用户ID
     * @return 订单总数
     */
    int getTotalRecord(String uid);

    /**
     * 获取当前页的订单
     *
     * @param pageSize   每页显示的条数
     * @param startIndex 页面开始的索引
     * @param uid        用户ID
     * @return 订单集合
     */
    List<Order> selectMyOrdersByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("uid") String uid);

    /**
     * 获取当前页的订单的同时查询每个订单项
     *
     * @param startIndex 页面开始的索引
     * @param pageSize   每页显示的条数
     * @param uid        用户ID
     * @return 订单集合
     */
    List<Order> getOrderByStep(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("uid") String uid);

    List<Order> queryAllByState(@Param("start") int start, @Param("pageSize") int pageSize, @Param("state") String state);

    List<Order> queryAll(@Param("start") int start, @Param("pageSize") int pageSize);

    Order getByOid(String oid);

    int selectTotalRecord();

    int selectTotalRecordByState(String state);

    void updateState(Order order);
}
