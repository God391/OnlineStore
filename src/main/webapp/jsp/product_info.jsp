<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
<%@include file="/jsp/head.jsp" %>

<div class="container">
    <div class="row">
        <div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
            <a href="${pageContext.request.contextPath}/index">首页&nbsp;&nbsp;&gt;</a>
            <a href="${pageContext.request.contextPath}/product?method=selectByPage&pageNumber=1&cid=${product.category.cid}">${product.category.cname}</a>
        </div>

        <div style="margin:0 auto;width:950px;">
            <div class="col-md-6">
                <img style="opacity: 1;" title="" class="medium"
                     src="${pageContext.request.contextPath}/${product.pimage}">
            </div>

            <div class="col-md-6">
                <div><strong>${product.pname}</strong></div>
                <div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
                    <div>${product.pid}</div>
                </div>

                <div style="margin:10px 0 10px 0;">商城价: <strong
                        style="color:#ef0101;">￥：${product.shop_price}元</strong>
                    市场价：
                    <del>￥${product.market_price}元</del>
                </div>

                <div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
                                                            style="background-color: #f07373;">限时抢购</a></div>

                <div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
                    <div style="margin:5px 0 10px 0;">白色</div>

                    <form action="${pageContext.request.contextPath}/cart" id="cartForm" method="post">
                        <!--提交的方法-->
                        <input type="hidden" name="method" value="addToCart">
                        <input type="hidden" name="pid" value="${product.pid}">
                        <div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
                            <input type="text" id="quantity" name="count" value="1" maxlength="4" size="10">
                        </div>
                    </form>

                    <div style="margin:20px 0 10px 0;;text-align: center;">
                        <a href="javascript:void(0)" onclick="subForm()">
                            <input style="background: url('${pageContext.request.contextPath}/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;"
                                   value="加入购物车" type="button">
                        </a> &nbsp;收藏商品
                    </div>

                </div>
            </div>
        </div>
        <div class="clear"></div>
        <div style="width:950px;margin:0 auto;">
            <div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
                <strong>商品介绍</strong>
            </div>

            <div>
                <img src="${pageContext.request.contextPath}/${product.pimage}">
                <p>${product.pdesc}</p>
            </div>

            <div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
                <strong>商品参数</strong>
            </div>
            <div style="margin-top:10px;width:900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr class="active">
                        <th colspan="2">基本参数</th>
                    </tr>
                    <tr>
                        <th width="10%">处理器</th>
                        <td width="30%">Apple A16 Bionic</td>
                    </tr>
                    <tr>
                        <th width="10%">RAM</th>
                        <td>12GB</td>
                    </tr>
                    <tr>
                        <th width="10%">ROM</th>
                        <td>256GB</td>
                    </tr>
                    <tr>
                        <th width="10%">网络</th>
                        <td>双模5G(NSA+SA), Wi-Fi 6 (802.11)</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div style="background-color:#d3d3d3;width:900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr class="active">
                        <th><strong>商品评论</strong></th>
                    </tr>
                    <tr class="warning">
                        <th>暂无商品评论信息
                            <a href="${pageContext.request.contextPath}/comment?method=addCommentUi&pid=${product.pid}">[发表商品评论]</a>
                        </th>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div style="background-color:#d3d3d3;width:900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr class="active">
                        <th><strong>商品咨询</strong></th>
                    </tr>
                    <tr class="warning">
                        <th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp" %>
<script type="text/javascript">
    //添加购物车
    function subForm() {
        //提交表单
        document.getElementById("cartForm").submit();
    }
</script>
</body>

</html>