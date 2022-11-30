package pojo;

/**
 * 订单项
 */
public class OrderItem {
    private String itemid;
    private Integer count;
    private double subtotal;
    private String pid;

    //包含的商品
    private Product product;

    //属于的订单
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String itemid, Integer count, double subtotal, Product product, Order order) {
        this.itemid = itemid;
        this.count = count;
        this.subtotal = subtotal;
        this.product = product;
        this.order = order;
    }

    public OrderItem(String itemid, Integer count, double subtotal, String pid, Product product, Order order) {
        this.itemid = itemid;
        this.count = count;
        this.subtotal = subtotal;
        this.pid = pid;
        this.product = product;
        this.order = order;
    }

    /**
     * 获取
     * @return itemid
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * 设置
     * @param itemid
     */
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    /**
     * 获取
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取
     * @return subtotal
     */
    public double getSubtotal() {
        return product.getShop_price() * count;
    }

    /**
     * 设置
     * @param subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * 获取
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 设置
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * 获取
     * @return order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * 设置
     * @param order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPid(){
        return pid;
    }

    public String getOid(){
        return order.getOid();
    }

    @Override
    public String toString() {
        return "OrderItem{itemid = " + itemid + ", count = " + count + ", subtotal = " + subtotal + ", product = " + product + ", order = " + order + "}";
    }

    /**
     * 设置
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }
}
