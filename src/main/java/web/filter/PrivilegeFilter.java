package web.filter;

import pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author f5gua
 */
public class PrivilegeFilter implements Filter {

    /**
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @param req
     * @param resp
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        // 1. 强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 2. 逻辑
        // 从 session 中获取用户
        User user = (User) request.getSession().getAttribute("user");

        // 判断 user 是否存在
        if (user == null) {
            // 未登录
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
            return;
        }

        // 3. 放行
        chain.doFilter(request, response);

    }

    /**
     *
     */
    @Override
    public void destroy() {

    }

}
