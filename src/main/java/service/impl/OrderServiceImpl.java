package service.impl;

import com.alibaba.fastjson.JSON;
import constant.Contant;
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
import service.ProductService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 保存订单
     *
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("订单添加失败！！！");
            //5.1回滚事务
            session.rollback();
        }
    }

    /**
     * 我的订单
     *
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

    /**
     * 后台查询订单列表
     *
     * @param state
     * @return
     */
    @Override
    public PageBean<Order> queryAllByState(int pageNumber, int pageSize, String state) {
        //1.创建pageBean
        PageBean<Order> pb = new PageBean<Order>(pageNumber, pageSize);
        //2.设置当前页数据
        SqlSession session = factory.openSession();
        //查询当前页的订单
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        //判断 state
        List<Order> orders;
        if (null == state || state.trim().length() == 0) {
            orders = mapper.queryAll(pb.getStartIndex(), pageSize);
            pb.setData(orders);
            //3.设置总记录数
            int totalRecord = mapper.selectTotalRecord();
            session.close();
            pb.setTotalRecord(totalRecord);

        } else {
            orders = mapper.queryAllByState(pb.getStartIndex(), pageSize, state);
            pb.setData(orders);
            //3.设置总记录数
            int totalRecord = mapper.selectTotalRecordByState(state);
            session.close();
            pb.setTotalRecord(totalRecord);
        }
        pb.setTotalPage();
        return pb;

    }


    /**
     * 订单详情
     */
    @Override
    public Order getById(String oid) {
        // 1.获取 mapper
        SqlSession session = factory.openSession();
        OrderMapper om = session.getMapper(OrderMapper.class);
        OrderItemMapper oim = session.getMapper(OrderItemMapper.class);
        ProductMapper pm = session.getMapper(ProductMapper.class);
        Order order = om.getByOid(oid);
        List<OrderItem> items = oim.selectByOid(oid);
        for (OrderItem item : items) {
            String pid = item.getPid();
            //item.setOrder(order);
            Product product = pm.selectById(pid);
            item.setProduct(product);
        }
        order.setItems(items);

        session.close();

        return order;
    }

    /**
     * @param order
     */
    @Override
    public void updateState(Order order) {
        // 1.获取 mapper
        SqlSession session = factory.openSession();
        OrderMapper om = session.getMapper(OrderMapper.class);
        om.updateState(order);
        session.commit();
        session.close();
    }

}
