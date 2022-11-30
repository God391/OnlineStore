package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Order;
import pojo.PageBean;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 添加订单
     * @param order
     */
    void add(Order order);

    /**
     * 获取订单总数
     * @return
     */
    int getTotalRecord(String uid);

    /**
     * 获取当前页的订单
     * @param uid
     * @return
     */
    List<Order> selectMyOrdersByPage(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize, @Param("uid") String uid);

    /**
     * 获取当前页的订单的同时查询每个订单项
     * @param startIndex
     * @param pageSize
     * @param uid
     * @return
     */
    List<Order> getOrderByStep(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize, @Param("uid") String uid);

}
