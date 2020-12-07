<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加图书</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">

        .col-sm-10>input{
            width: 250px;
        }
        .col-sm-10>select{
            width: 250px;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6"></div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6"></div>
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-6"></div>
                        <div class="col-lg-6" style="height: 40px;">
                            <div class="dropdown" style="float: right;">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <shiro:authenticated>
                                        用户[<shiro:principal/>]已身份验证通过
                                    </shiro:authenticated>
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="min-width: 50px;">
                                    <li><a href="/logout">注销</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <h1 class="text-center">添加图书</h1>
    <form action="${pageContext.request.contextPath }/addBook" method="post" class="form-horizontal" style="margin-left:300px">
        <div class="form-group">
            <label for="bookName" class="col-sm-2 control-label">书名:</label>
            <div class="col-sm-10">
                <input type="text" name="bookName" class="form-control" id="bookName" placeholder="书名">
            </div>
        </div>
        <div class="form-group">
            <label for="authorName" class="col-sm-2 control-label">作者:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="authorName" id="authorName" placeholder="作者">
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">价格:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="price" id="price" placeholder="价格">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">分类:</label>
            <div class="col-sm-10">
                <select class="form-control" name="category.categoryId">
                    <c:forEach items="${category}" var="category">
                        <option value="${category.categoryId}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 text-center">
                <button type="submit" class="btn btn-default">添加图书</button>
            </div>
        </div>
    </form>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath }/dist/js/bootstrap.js"></script>
</body>
</html>

