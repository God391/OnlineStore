package service;

import pojo.Order;
import pojo.PageBean;

import java.util.List;

public interface OrderService {
    void save(Order order);

    PageBean<Order> selectMyOrdersByPage(int pageNumber, int pageSize, String uid);
}
