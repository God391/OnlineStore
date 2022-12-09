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
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        Category category = mapper.queryById("1");
        System.out.println(category);

    }
}
