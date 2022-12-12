<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Head</title>
    <style>
        /*.col-md-3 {*/
        /*    box-sizing: border-box;*/
        /*    line-height: 50px;*/
        /*    height: 50px;*/
        /*}*/
        .newOl {
            display: flex;
            line-height: 50px;
            height: 50px;
            box-sizing: border-box;
        }
        .newOl li {
            padding-left: 5px;
        }
        .newOl li  a{
            color: #9d9d9d;
        }
        .newOl li  a:hover{
            color: white;
        }
        #fixnav {
            width: 96.4%;
            height: 60px;
            position: fixed;
            top:0;
            left: 50%;
            transform: translateX(-50%);
            z-index: 1;
            background-color: rgba(0,0,0,0.8);
        }
        .container-fluid {
            position: relative;
        }
        .newOl {
            list-style-type: none;
            position: absolute;
            height: 50px;
            width: 312px;
            right: 30%;
            top: 0;
        }
        .top-block{
            height: 60px;
        }
    </style>
</head>
<body>

<%--导航栏--%>
<div class="container-fluid">
    <div class="top-block"></div>
    <nav class="navbar navbar-inverse" id="fixnav">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">首页</a>
            </div>


                <%--<ol class="list-inline">--%>
                <%--登录 注册 我的购物车--%>
                <ol class="newOl">
                    <c:if test="${empty user}">
                        <li><a href="${pageContext.request.contextPath}/user?method=loginUi"> 登 录 </a></li>
                        <li><a href="${pageContext.request.contextPath}/user?method=registerUi"> 注 册 </a></li>
                    </c:if>
                    <c:if test="${not empty user}">
                        <li>${user.username}：你 好！</li>
                        <li>
                            <a href="${pageContext.request.contextPath}/order?method=selectMyOrdersByPage&pageNumber=1">我的订单</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/user?method=logout"> 登出 </a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/jsp/cart.jsp"> 我的购物车 </a></li>
                </ol>


            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="c_ul">
                    <%--                    使用ajax异步请求--%>
                </ul>
                <form action="${pageContext.request.contextPath}/product" method="post" class="navbar-form navbar-right"
                      role="search">
                    <div class="form-group">
                        <input type="hidden" name="method" value="searchSelectByPage">
                        <input type="hidden" name="pageNumber" value="1">
                        <input type="text" name="p" value="${p}" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>

            </div>
        </div>

    </nav>
</div>
<script src="${pageContext.request.contextPath}/js/axios-0.18.0.js"></script>
<script type="text/javascript">
    //发送ajax查询所有分类
    axios({
        method: "post",
        url: "${pageContext.request.contextPath}/category",
        data: "method=findAll"
    }).then(function (resp) {
        //遍历json列表，获取每一个分类，包装成li标签，插入到ul内部
        let categories = resp.data;
        for (let i = 0; i < categories.length; i++) {
            let category = categories[i];
            let cname = category.cname;
            $("#c_ul").append("<li><a href='${pageContext.request.contextPath}/product?method=selectByPage&pageNumber=1&cid=" + category.cid + "'>" + cname + "</a></li>");
        }
    });
</script>
</body>
</html>
