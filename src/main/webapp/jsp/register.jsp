<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head></head>
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
        color: #3164af;
        font-size: 18px;
        font-weight: normal;
        padding: 0 10px;
    }
</style>
</head>
<body>

<%--静态包含导入head.jsp--%>
<%@include file="/jsp/head.jsp"%>

<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
    <div class="row">

        <div class="col-md-2"></div>


        <div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
            <font>会员注册</font>USER REGISTER
            <form class="form-horizontal" style="margin-top:5px;" method="post"
                  action="${pageContext.request.contextPath }/user">
                <input type="hidden" name="method" value="register">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" required="required" class="form-control" id="username" placeholder="请输入用户名" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" required="required" class="form-control" id="inputPassword3" placeholder="请输入密码"
                               name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input type="password" required="required" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-6">
                        <input type="email" required="required" class="form-control" id="inputEmail3" placeholder="Email" name="email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" required="required" class="form-control" id="usercaption" placeholder="请输入姓名" name="name">
                    </div>
                </div>
                <div class="form-group opt">
                    <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">
                        <label class="radio-inline">
                            <input type="radio" checked="checked" name="sex" id="inlineRadio1" value="1"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio2" value="0"> 女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <%--@declare id="date"--%><label for="date" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-6">
                        <input type="date" class="form-control" name="birthday" value="2000-01-01">
                    </div>
                </div>

                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">验证码</label>
                    <label class="col-sm-6">
                        <input type="text" required="required"  name="checkCode" class="form-control" >
                    </label>
                    <img  id="checkCodeImg" style="height: 34px" src="${pageContext.request.contextPath }/checkCodeServlet" alt="验证码">
                    <a href="#" id="changeImg">看不清？</a>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" width="100" value="注册" name="submit" border="0"
                                   style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                                           height:35px;width:100px;color:white;">
                            <span style="color: red;font-size: 20px">${register_msg}</span>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-2"></div>

    </div>
</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp" %>
<script>
    //更换验证码
    document.getElementById("changeImg").onclick = function () {
        //url一致时浏览器会调用本地缓存数据导致刷新失败，加上一个随机数来规避
        document.getElementById("checkCodeImg").src = "checkCodeServlet?"+new Date().getMilliseconds();
    };
    document.getElementById("checkCodeImg").onclick = function () {
        //url一致时浏览器会调用本地缓存数据导致刷新失败，加上一个随机数来规避
        document.getElementById("checkCodeImg").src = "checkCodeServlet?"+new Date().getMilliseconds();
    };
</script>
</body>
</html>




