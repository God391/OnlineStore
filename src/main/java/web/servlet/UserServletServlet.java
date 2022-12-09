package web.servlet;

import constant.Contant;
import org.apache.commons.beanutils.BeanUtils;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.UUIDUtils;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/user")
public class UserServletServlet extends BaseServlet {

    /**
     * 跳转到注册页面
     */
    public String registerUi(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/register.jsp";
    }

    /**
     * 用户注册
     */
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 0. 判断验证码输入是否正确
        String checkCode = request.getParameter("checkCode");
        String checkCodeGen = (String) request.getSession().getAttribute("checkCodeGen");
        if (checkCode == null || "".equals(checkCode) || !(checkCode.equalsIgnoreCase(checkCodeGen))) {
            request.setAttribute("register_msg", "验证码错误");
            return "/jsp/register.jsp";
        }

        // 1. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            // 1.1 手动封装参数
            // 生成用户 id
            user.setUid(UUIDUtils.getId());
            // 激活状态
            user.setState(Contant.USER_IS_ACTIVE);
            // 调用 service 完成注册
            UserService service = new UserServiceImpl();
            service.register(user);
            request.setAttribute("msg", "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "用户注册失败!");
            return "/jsp/msg.jsp";
        }
        return "/jsp/msg.jsp";
    }

    /**
     * 跳转到登录页面
     */
    public String loginUi(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/login.jsp";
    }

    /**
     * 用户登录
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 获取用户名和密码
        String username = request.getParameter("username");
        // 把用户名编码再存放在 cookie 中
        String encodeUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
        String password = request.getParameter("password");

        // 2. 调用 service 完成登录
        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        // 3. 判断是否登录成功
        if (user != null) {
            if (user.getState() == 0) {
                String login_msg = "账户已停用，请联系管理员";
                request.setAttribute("login_msg", login_msg);
                return "/jsp/login.jsp";
            } else {
                // 登录成功
//                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("user", user);
                String isRemember = request.getParameter("remember");
                // 是否保存密码
                if (Contant.IS_REMEMBER.equals(isRemember)) {
                    // 创建 cookie
                    Cookie cu = new Cookie("username", encodeUsername);
                    cu.setMaxAge(60 * 60 * 24 * 7);
                    Cookie cp = new Cookie("password", password);
                    cp.setMaxAge(60 * 60 * 24 * 7);
                    // 发送 cookie 到客户端
                    response.addCookie(cu);
                    response.addCookie(cp);
                }
                response.sendRedirect(request.getContextPath());

                return null;
            }
        } else { // 登录失败

            String login_msg = "用户名或密码错误";
            request.setAttribute("login_msg", login_msg);

            return "/jsp/login.jsp";
        }
    }

    /**
     * 登出
     */
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());

        return null;
    }

    /**
     * 跳转到我的订单
     */
    public String orderListUi(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/order_list.jsp";
    }

    /**
     * 跳转到我的购物车
     */
    public String cartUi(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/cart.jsp";
    }

}
