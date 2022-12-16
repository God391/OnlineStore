package service;

import pojo.Order;
import pojo.OrderItem;
import pojo.PageBean;

import java.util.List;

public interface OrderService {
    void save(Order order);

    PageBean<Order> selectMyOrdersByPage(int pageNumber, int pageSize, String uid);

    PageBean<Order> queryAllByState(int pageNumber, int pageSize, String state);

    Order getById(String oid);

    void updateState(Order order);
}
