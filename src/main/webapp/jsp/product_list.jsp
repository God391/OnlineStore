<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>分类商品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
            width: 100%;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>

<body>
<%--			静态包含导入head.jsp--%>
<%@include file="/jsp/head.jsp" %>

<div class="row" style="width:1210px;margin:0 auto;">
    <div class="col-md-12">
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
        </ol>
    </div>
    <c:forEach items="${pb.data}" var="p">
        <div class="col-md-2">
            <a href="${pageContext.request.contextPath}/product?method=getById&pid=${p.pid}">
                <img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170"
                     style="display: inline-block;">
            </a>
            <p><a href="${pageContext.request.contextPath}/product?method=getById&pid=${p.pid}"
                  style='color:green'>${fn:substring(p.pname,0,12)}...</a></p>
            <p><font color="#FF0000">商城价：&yen;${p.shop_price}</font></p>
        </div>
    </c:forEach>
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
                <a href="${pageContext.request.contextPath}/product?method=selectByPage&pageNumber=${pb.pageNumber - 1}&p=${p}&cid=${param.cid}"
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
                    <a href="${pageContext.request.contextPath}/product?method=selectByPage&pageNumber=${n}&p=${p}&cid=${param.cid}">${n}</a>
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
                <a href="${pageContext.request.contextPath}/product?method=selectByPage&pageNumber=${pb.pageNumber + 1}&p=${p}&cid=${param.cid}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</div>
<!-- 分页结束=======================        -->

<!--
       商品浏览记录:
-->
<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

    <h4 style="width: 50%;float: left">浏览记录</h4>
    <div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
    <div style="clear: both;"></div>

    <div style="overflow: hidden;">

        <ul style="list-style: none;">
            <li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
                <img src="${pageContext.request.contextPath}/products/1/cs10001.jpg" width="130px" height="130px"/></li>
        </ul>

    </div>
</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp" %>

</body>

</html>