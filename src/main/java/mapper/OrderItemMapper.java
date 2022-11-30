package mapper;


import org.apache.ibatis.annotations.Mapper;
import pojo.OrderItem;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    void add (OrderItem orderItem);

    List<OrderItem> selectByOid(String oid);

}
