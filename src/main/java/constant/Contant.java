package constant;

public interface Contant {

    /**
     * 用户未激活
     */
    int USER_IS_NOT_ACTIVE = 0;

    /**
     * 用户已激活
     */
    int USER_IS_ACTIVE = 1;

    /**
     * 选择了保存密码
     */
    String IS_REMEMBER = "1";

    /**
     * 热门商品
     */
    int PRODUCT_IS_HOT = 1;

    /**
     * 上架的商品
     */
    int PRODUCT_IS_UP = 1;

    /**
     * 下架的商品
     */
    int PRODUCT_IS_DOWN = 0;

    /**
     * 订单未支付
     */
    int ORDER_NON_PAYMENT = 0;

    /**
     * 订单已支付
     */
    int ORDER_PAYED = 1;

    /**
     * 订单已发货
     */
    int ORDER_SHIPPED = 2;

    /**
     * 订单已完成
     */
    int ORDER_COMPLETE = 3;

}
