package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Order {
    private String oid;
    private Date ordertime;
    private double total;
    private Integer state;
    private String address;
    private String name;
    private String telephone;

    //当前订单属于的用户
    private User user;

    //当前订单包含的订单项
    private List<OrderItem> items = new ArrayList<>();


    public Order() {
    }

    public Order(String oid, Date ordertime, double total, Integer state, String address, String name, String telephone, User user, List<OrderItem> items) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.address = address;
        this.name = name;
        this.telephone = telephone;
        this.user = user;
        this.items = items;
    }

    /**
     * 获取
     * @return oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * 设置
     * @param oid
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * 获取
     * @return ordertime
     */
    public Date getOrdertime() {
        return ordertime;
    }

    /**
     * 设置
     * @param ordertime
     */
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    /**
     * 获取
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * 获取
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取
     * @return items
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * 设置
     * @param items
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * 获取
     * @return uid
     */
    public String getUid() {
        return user.getUid();
    }

    @Override
    public String toString() {
        System.out.println();
        return "Order{oid = " + oid + ", ordertime = " + ordertime + ", total = " + total + ", state = " + state + ", address = " + address + ", name = " + name + ", telephone = " + telephone + ", user = " + user + ", items = " + items + "}";
    }
}
