package web.servlet;

import pojo.Cart;
import pojo.CartItem;
import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends BaseServlet {

    /**
     * 添加商品到购物车
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 获取商品 id 和数量
        String pid = request.getParameter("pid");
        Integer count = Integer.parseInt(request.getParameter("count"));

        // 2. 获取商品
        ProductService service = new ProductServiceImpl();
        Product product = service.selectById(pid);

        // 3. 创建购物项
        CartItem cartItem = new CartItem(product, count);

        // 4. 添加到购物车
        Cart cart = getCart(request);
        cart.addToCart(cartItem);

        // 5. 重定向
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");

        return null;

    }

    /**
     * 获取或创建购物车
     *
     * @param request
     * @return
     */
    private Cart getCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            // 没有则创建
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    /**
     * 删除指定商品
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 获取商品
        String pid = request.getParameter("pid");

        // 2. 移除商品
        getCart(request).removeFromCart(pid);

        // 3. 重定向
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");

        return null;
    }

    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String clear(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 获取购物车
        Cart cart = getCart(request);

        // 2. 清空购物车
        cart.clearCart();

        // 3. 重定向
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");

        return null;
    }

}

