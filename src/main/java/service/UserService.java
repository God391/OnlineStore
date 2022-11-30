package service;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService {
    /**
     *
     * @param user 用户信息
     */
    void register (User user) throws Exception;

    User login(String username, String password);

}
