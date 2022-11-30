<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
</head>
<body>
<div class="container-fluid">
    <div class="col-md-4">
        <img src="${pageContext.request.contextPath}/img/logo2.png" />
    </div>
    <div class="col-md-5">
        <img src="${pageContext.request.contextPath}/img/header.png" />
    </div>
    <div class="col-md-3" style="padding-top:20px">
        <ol class="list-inline">
            <c:if test="${empty username}">
                <li><a href="${pageContext.request.contextPath}/user?method=loginUi">登录</a></li>
                <li><a href="${pageContext.request.contextPath}/user?method=registerUi">注册</a></li>
            </c:if>
            <c:if test="${not empty username}">
                <li><a href="#">我的订单</a></li>
                <li><a href="${pageContext.request.contextPath}/user?method=logout">退出</a></li>
                <li>欢迎您${username}</li>
            </c:if>
        </ol>
    </div>
</div>
</body>
</html>

