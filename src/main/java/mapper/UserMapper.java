package mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.User;

@Mapper
public interface UserMapper {

    /**
     * 添加用户
     *
     * @param user 用户
     */
    void add(User user);

    /**
     * 根据 ID 查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User selectById(@Param("username") String username, @Param("password") String password);

}
