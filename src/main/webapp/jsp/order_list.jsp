<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>

<body>

<%--静态包含导入head.jsp--%>
<%@include file="/jsp/head.jsp"%>

<div class="container">
    <div class="row">
        <div style="margin:0 auto; margin-top:10px;width:950px;">
            <strong>我的订单</strong>
            <table class="table table-bordered">
                <c:forEach items="${pb.data}" var="order">
                    <tbody>
                    <tr class="success">
                        <th colspan="5">订单编号:${order.oid}</th>
                    </tr>
                    <th colspan="1">
                        <c:if test="${order.state == 0}"><a href="#">去付款</a></c:if>
                        <c:if test="${order.state == 1}"><a href="#">已付款</a></c:if>
                        <c:if test="${order.state == 2}"><a href="#">确认收货</a></c:if>
                        <c:if test="${order.state == 3}"><a href="#">已完成</a></c:if>
                    </th>
                    <th colspan="2">总金额：${order.total}</th>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <c:forEach items="${order.items}" var="oi">
                        <tr class="active">
                            <td width="60" width="40%">
                                <input type="hidden" name="id" value="22">
                                <a href="${pageContext.request.contextPath}/product?method=getById&pid=${oi.product.pid}">
                                    <img src="${pageContext.request.contextPath}/${oi.product.pimage}" width="70" height="60"
                                </a>
                            </td>
                            <td width="30%">
                                <a href="${pageContext.request.contextPath}/product?method=getById&pid=${oi.product.pid}">${oi.product.pname}</a>
                            </td>
                            <td width="20%">
                                ￥${oi.product.shop_price}
                            </td>
                            <td width="10%">
                                ${oi.count}
                            </td>
                            <td width="15%">
                                <span class="subtotal">￥${oi.subtotal}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    <!--分页 -->
    <div style="width:380px;margin:0 auto;margin-top:50px;">
        <ul class="pagination" style="text-align:center; margin-top:10px;">
            <%--是第一页，不能后退--%>
            <c:if test="${pb.pageNumber == 1}">
                <li class="disabled">
                    <a href="javascript:void(0)" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>

            <%--不是第一页--%>
            <c:if test="${pb.pageNumber != 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/order?method=selectMyOrdersByPage&pageNumber=${pb.pageNumber - 1}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>

            <%--展示所有页码--%>
            <c:forEach begin="1" end="${pb.totalPage}" step="1" var="n">
                <%--是当前页--%>
                <c:if test="${pb.pageNumber == n}">
                    <li class="active"><a href="javascript:void(0)">${n}</a></li>
                </c:if>

                <%--不是当前页--%>
                <c:if test="${pb.pageNumber != n}">
                    <li>
                        <a href="${pageContext.request.contextPath}/order?method=selectMyOrdersByPage&pageNumber=${n}">${n}</a>
                    </li>
                </c:if>
            </c:forEach>

            <%--是最后一页，不能前进--%>
            <c:if test="${pb.pageNumber == pb.totalPage}">
                <li class="disabled">
                    <a href="javascript:void(0)" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

            <%--不是最后一页--%>
            <c:if test="${pb.pageNumber != pb.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/order?method=selectMyOrdersByPage&pageNumber=${pb.pageNumber + 1}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>
    <!-- 分页结束=======================        -->
</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp" %>
</body>

</html>