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

        .container .row div {
            /* position:relative;
            float:left; */
        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
    </style>
</head>
<body>

<%--静态包含导入head.jsp--%>
<%@include file="/jsp/head.jsp"%>

<div class="container"
     style="width:100%;height:460px;background:#FF2C4C url('${pageContext.request.contextPath}/images/loginbg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-7">
            <!--<img src="${pageContext.request.contextPath}/image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
        </div>

        <div class="col-md-5">
            <div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
                <font>会员登录</font>USER LOGIN &nbsp;<span style="color: red">${login_msg }</span>

                <div>&nbsp;</div>
                <form class="form-horizontal" action="${pageContext.request.contextPath }/user" method="post">
                    <input type="hidden" name="method" value="login">

                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password" placeholder="请输入密码"
                                   name="password" value="${cookie.password.value}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 自动登录
                                </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>
                                    <input type="checkbox" id="remember" name="remember" value="1"> 记住用户名
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" width="100" value="登录" name="submit" border="0"
                                   style="background: url('${pageContext.request.contextPath}/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                                           height:35px;width:100px;color:white;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp"%>

<script>
    // 判断用户之前是否选择了记住密码，选择过了就勾选
    if ("${cookie.username.value}".length > 0) {
        document.getElementById("remember").checked = true;
    }

    //解码coolie中的username
    let val = "${cookie.username.value}";
    document.getElementById("username").value = decodeURI(val);
</script>
</body>
</html>