package pojo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    /**
     * 购物项Map
     */
    private Map<String, CartItem> itemMap = new HashMap<>();

    /**
     * 总金额
     */
    private Double total = 0.0;

    public Cart() {
    }

    public Cart(Map<String, CartItem> itemMap, Double total) {
        this.itemMap = itemMap;
        this.total = total;
    }

    /**
     * 添加商品到购物车
     *
     * @param cartItem 购物车项
     */
    public void addToCart(CartItem cartItem) {
        String pid = cartItem.getProduct().getPid();
        //判断是否已存在该商品
        if (itemMap.containsKey(pid)) {
            // 如果已存在该商品
            // 获取该商品的数量
            int newCount = itemMap.get(pid).getCount();
            // 增加数量
            newCount += cartItem.getCount();
            // 更新商品数量
            itemMap.get(pid).setCount(newCount);
        } else {
            itemMap.put(pid, cartItem);
        }
        // 更新总金额
        total += cartItem.getSubTotal();
    }

    /**
     * 从购物车删除商品
     *
     * @param pid 商品ID
     */
    public void removeFromCart(String pid) {
        CartItem item = itemMap.remove(pid);
        total -= item.getSubTotal();
    }

    /**
     * 清空购物车
     */
    public void clearCart() {
        itemMap.clear();
        total = 0.0;
    }

    /**
     * 获取所有的购物项
     *
     * @return
     */
    public Collection<CartItem> getCartItems() {
        return itemMap.values();
    }

    /**
     * 获取
     *
     * @return itemMap
     */
    public Map<String, CartItem> getItemMap() {
        return itemMap;
    }

    /**
     * 设置
     *
     * @param itemMap
     */
    public void setItemMap(Map<String, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    /**
     * 获取
     *
     * @return total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置
     *
     * @param total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cat{itemMap = " + itemMap + ", total = " + total + "}";
    }
}
