package mapper;


import org.apache.ibatis.annotations.Mapper;
import pojo.OrderItem;
import pojo.OrderItemNoOrder;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    /**
     * 插入订单项
     * @param orderItem 订单项
     */
    void add(OrderItem orderItem);

    /**
     * 按订单编号查询订单项
     * @param oid 订单编号
     * @return 订单项集合
     */
    List<OrderItem> selectByOid(String oid);

    List<OrderItemNoOrder> selectByOId(String oid);


}
