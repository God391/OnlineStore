<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WEB01</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<div class="container-fluid">

    <div class="container-fluid">
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/img/logo2.png"/>
        </div>
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/img/header.png"/>
        </div>
        <div class="col-md-3" style="padding-top:20px">
            <ol class="list-inline">
                <li><a href="">登录</a></li>
                <li><a href="">注册</a></li>
                <li><a href="">购物车</a></li>
            </ol>
        </div>
    </div>
    <div class="container-fluid">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">手机数码<span class="sr-only">(current)</span></a></li>
                        <li><a href="#">电脑办公</a></li>
                        <li><a href="#">电脑办公</a></li>
                        <li><a href="#">电脑办公</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>

                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>

    <div class="container-fluid">
        <div class="main_con">
            <h2>公司简介</h2>
            <hr/>
            <div>
                <p></p>
            </div>
        </div>
    </div>

</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp" %>
</body>

</html>