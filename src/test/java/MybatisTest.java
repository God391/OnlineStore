//import mapper.*;
//import constant.Contant;
//import org.apache.ibatis.session.SqlSession;
//        import org.apache.ibatis.session.SqlSessionFactory;
//        import org.junit.Test;
//import pojo.*;
//import service.OrderService;
//import service.impl.CategoryServiceImpl;
//import service.impl.OrderServiceImpl;
//import utils.SqlSessionFactoryUtils;
//
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class MybatisTest {
//    @Test
//    public void testFactory() throws Exception {
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession session = sqlSessionFactory.openSession();
//
//        //3.获取Mapper接口的代理对象
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//
//        //4.执行方法
//        mapper.deleteByid("08DA64E099414786929F71304AE01DFA");
//
//        //提交事务
//        session.commit();
//
//        //5.关闭方法
//        session.close();
//    }
//}
