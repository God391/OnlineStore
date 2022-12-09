package web.servlet.base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 通用servlet
 */
@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {

    /**
     * service 不再转发给 doPost 或 doGet,而是直接执行方法
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取方法名称
        String methodName = request.getParameter("method");
        // 1.1 判断方法参数是否为空,为空执行默认方法
        if(methodName==null || methodName.trim().length() == 0){
            methodName = "index";
        }
        // 2. 获取方法对象
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 3. 执行方法，获取返回值
            String path = (String) method.invoke(this, request, response);
            // 4. 判断返回值是否为空,不为空则请求转发
            if(path != null){
                request.getRequestDispatcher(path).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 默认方法
     */
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("方法不存在！！！");
        return null;
    }
}
