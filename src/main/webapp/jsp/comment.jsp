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
    <title>发表评论</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/rating.css" type="text/css"/>

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
<div style="width:950px;margin:0 auto;">

    <div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
        <strong>发表评论</strong>
    </div>

    <div style="margin-top:10px;width:930px;">
        <form method="post" action="${pageContext.request.contextPath}/comment?method=addComment&pid=${pid}">
            <input type="hidden" name="method" value="addComment">
            <table class="table table-bordered" style="width: 930px">
                <tbody>
                <tr class="active">
                    <th>星级评价</th>
                </tr>
                <tr>
                    <td>
                        <div class="star_evaluate">
                            <input type="radio" id="scoreId_1" class="score score_1" name="score" value="1"/>
                            <label for="scoreId_1" class="star star_1"></label>
                            <input type="radio" id="scoreId_2" class="score score_2" name="score" value="2"/>
                            <label for="scoreId_2" class="star star_2"></label>
                            <input type="radio" id="scoreId_3" class="score score_3" name="score" value="3"/>
                            <label for="scoreId_3" class="star star_3"></label>
                            <input type="radio" id="scoreId_4" class="score score_4" name="score" value="4"/>
                            <label for="scoreId_4" class="star star_4"></label>
                            <input type="radio" id="scoreId_5" class="score score_5" name="score" value="5"/>
                            <label for="scoreId_5" class="star star_5"></label>
                        </div>
                    </td>
                </tr>
            </table>
            <table class="table table-bordered" style="width: 930px">
                <tbody>
                <tr class="active">
                    <th>编辑评论</th>
                </tr>
                <tr>
                    <td>
                    <textarea id='memo' style="min-height:200px;min-width:910px;max-height:200px;max-width:910px;"
                              name="memo">
                    </textarea>
                    </td>
                </tr>
                </tbody>
            </table>
            <input type="submit" width="100" value="发表" name="submit">
        </form>
    </div>

</div>
</body>
</html>
