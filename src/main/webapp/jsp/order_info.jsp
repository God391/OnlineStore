<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

        <div style="margin:0 auto;margin-top:10px;width:950px;">
            <strong>订单详情</strong>
            <table class="table table-bordered">
                <tbody>
                <tr class="warning">
                    <th colspan="2">订单编号:${order.oid}</th>
                    <th colspan="1">
                        <c:if test="${order.state == 0}">去付款</c:if>
                        <c:if test="${order.state == 1}">已付款</c:if>
                        <c:if test="${order.state == 2}">确认收获</c:if>
                        <c:if test="${order.state == 3}">已完成</c:if>
                    </th>
                    <th colspan="2">时间:<fmt:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
                </tr>
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
                            <img src="${pageContext.request.contextPath}/${oi.product.pimage}" width="70" height="60">
                        </td>
                        <td width="30%">
                            <a target="_blank">${oi.product.pname}</a>
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
            </table>
        </div>

        <div style="text-align:right;margin-right:120px;">
            商品金额: <strong style="color:#ff6600;">￥${order.total}</strong>
        </div>

    </div>

    <div>
        <hr/>
        <form action="${pageContext.request.contextPath}/order" id="orderForm" method="post" class="form-horizontal"
              style="margin-top:5px;margin-left:150px;">
            <!-- 提交的方法 -->
            <input type="hidden" name="method" value="pay">
            <!-- 订单号 -->
            <input type="hidden" name="oid" value="${order.oid}">
            <div class="form-group">
                <label for="username" class="col-sm-1 control-label">地址</label>
                <div class="col-sm-5">
                    <input type="text" name=="address" class="form-control" id="username" placeholder="请输入收货地址">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
                <div class="col-sm-5">
                    <input type="text" name="name" class="form-control" id="inputPassword3" placeholder="请输收货人">
                </div>
            </div>
            <div class="form-group">
                <label for="confirmpwd" class="col-sm-1 control-label">电话</label>
                <div class="col-sm-5">
                    <input type="text" name="telephone" class="form-control" id="confirmpwd"
                           placeholder="请输入联系方式">
                </div>
            </div>


            <hr/>

            <div style="margin-top:5px;margin-left:150px;">
                <strong>选择银行：</strong>
                <p>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
                    <img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
                    <img src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
                    <img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle"/>
                    <br/>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
                    <img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
                    <img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
                    <img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle"/>
                    <br/>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
                    <img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
                    <img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle"/>
                <div>
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>
                    <img src="${pageContext.request.contextPath}/bank_img/WechatPay.png" style="height: 70px"
                         align="middle"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>
                    <img src="${pageContext.request.contextPath}/bank_img/AliPay.png" style="height: 70px"
                         align="middle"/>
                </div>
                </p>
                <hr/>
                <p style="text-align:right;margin-right:100px;">
                    <a href="javascript:document.getElementById('orderForm').submit();">
                        <img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51"
                             border="0"/>
                    </a>
                </p>
                <hr/>

            </div>
        </form>
    </div>


</div>

<%--静态包含导入foot.jsp--%>
<%@include file="/jsp/foot.jsp" %>

</body>

</html>