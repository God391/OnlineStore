package pojo;

public class OrderItemNoOrder {

    private String itemid;
    private Integer count;
    private double subtotal;
    private String pid;

    //包含的商品
    private Product product;

    //属于的订单
    private Order order;

    public OrderItemNoOrder() {
    }

    public OrderItemNoOrder(String itemid, Integer count, double subtotal, String pid, Product product, Order order) {
        this.itemid = itemid;
        this.count = count;
        this.subtotal = subtotal;
        this.pid = pid;
        this.product = product;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItemNoOrder{" + "itemid='" + itemid + '\'' + ", count=" + count + ", subtotal=" + subtotal + ", pid='" + pid + '\'' + ", product=" + product + ", order=" + order + '}';
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
