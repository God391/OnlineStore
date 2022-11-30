package mapper;


import org.apache.ibatis.annotations.Param;
import pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    User selectById(@Param("username")String username, @Param("password")String password);
}
