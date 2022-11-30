package service.impl;

import mapper.OrderItemMapper;
import mapper.OrderMapper;
import mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import pojo.OrderItem;
import pojo.PageBean;
import pojo.Product;
import service.OrderService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 保存订单
     * @param order
     */
    @Override
    public void save(Order order) {
        //1.获取mapper
        SqlSession session = factory.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        OrderItemMapper orderItemMapper = session.getMapper(OrderItemMapper.class);
        try {
            //2.开启事务
            //3.向orders中插入一条
            orderMapper.add(order);
            //4.向orderitem中插入n条
            for (OrderItem orderItem : order.getItems()) {
                orderItemMapper.add(orderItem);
            }
            //5.提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("订单添加失败！！！");
            //5.1回滚事务
            session.rollback();
        }
    }

    /**
     * 我的订单
     * @param pageNumber
     * @param pageSize
     * @param uid
     */
    @Override
    public PageBean<Order> selectMyOrdersByPage(int pageNumber, int pageSize, String uid) {
        //1.创建pageBean
        PageBean<Order> orderPageBean = new PageBean<>(pageNumber, pageSize);
        //2.查询并设置总条数
        SqlSession session = factory.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        OrderItemMapper orderItemMapper = session.getMapper(OrderItemMapper.class);
        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        int totalRecord = orderMapper.getTotalRecord(uid);
        orderPageBean.setTotalRecord(totalRecord);
        //3.查询order数据
        List<Order> orders = orderMapper.getOrderByStep(orderPageBean.getStartIndex(), pageSize, uid);
        for (Order order : orders) {
            List<OrderItem> orderItems = order.getItems();
            for (OrderItem orderItem : orderItems) {
                Product product = productMapper.selectById(orderItem.getPid());
                orderItem.setProduct(product);
            }
        }
        orderPageBean.setData(orders);
        return orderPageBean;
    }
}
