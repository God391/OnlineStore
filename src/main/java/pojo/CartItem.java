package pojo;

public class CartItem {
    //商品
    private Product product;
    //小计
    private Double subTotal;
    //数量
    private Integer count;

    public CartItem(Product product, Integer count) {
        this.product = product;
        this.count = count;
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
     * @return subTotal
     */
    public Double getSubTotal() {
        return product.getShop_price()*count;
    }

    /**
     * 设置
     * @param subTotal
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
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



    @Override
    public String toString() {
        return "CartItem{product = " + product + ", subTotal = " + subTotal + ", count = " + count + "}";
    }
}
