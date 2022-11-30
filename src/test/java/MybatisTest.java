import mapper.*;
import constant.Contant;
import org.apache.ibatis.session.SqlSession;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.junit.Test;
import pojo.*;
import service.OrderService;
import service.impl.CategoryServiceImpl;
import service.impl.OrderServiceImpl;
import utils.SqlSessionFactoryUtils;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void testFactory() throws Exception {
/*        User user = new User("3ca76a75e4f64db2bacd0974acc7c897", "admin", "123", "admin", "bbb@store.com", "15723689921", "1990-02-01", "男", 1);
        Order order = new Order();
        order.setOid("111ccc");
        order.setOrdertime(new Date());
        order.setTotal(11.23);
        order.setState(1);
        order.setAddress("china");
        order.setName(user.getName());
        order.setTelephone(user.getTelephone());
        order.setUser(user);
        Category category = new Category("1","手机数码");
        Product product = new Product("1","小米 4c 标准版",1399.0,1299.0,"products/1/c_0001.jpg",new Date(),1,"小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待",1,category);
        OrderService service = new OrderServiceImpl();
        List<Order> orders = service.selectMyOrdersByPage(1, 4, "62145f6e66ea4f5cbe7b6f6b954917d3");
        for (Order order1 : orders) {
            System.out.println(order1.toString());
        }*/
    }
}
