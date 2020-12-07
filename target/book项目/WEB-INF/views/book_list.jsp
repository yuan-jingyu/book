<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书列表</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/dist/css/bootstrap.css" rel="stylesheet">
    <style type="${pageContext.request.contextPath}/text/css">
        #login{
            height: 40px;
            display: flex;
            flex-wrap: nowrap;
            flex-direction: row;
            justify-content: center;
            align-items: center;
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
<div class="container" style="margin-top: 10px;">
    <h1 class="text-center">图书列表</h1>
</div>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>图书ID</th>
            <th>图书名称</th>
            <th>图书作者</th>
            <th>图书分类</th>
            <th>图书价格</th>
            <th colspan="2" class="text-center">操作</th>
        </tr>
        </thead>
        <tbody id="tbody"></tbody>

    </table>
</div>
<div class="container">
    <a href="${pageContext.request.contextPath}/jumpAddBook">添加图书</a>
</div>
<div class="container">
    <nav aria-label="Page navigation" class="text-right">
        <ul class="pagination" id="page">

        </ul>
    </nav>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/dist/js/bootstrap.js"></script>



<script>
    $(function(){
        getBookList();
    })
    var pageNo=1;
    var pageSize=2;
    var pageCount=0;
    function getBookList() {
        $.getJSON("getBookPage",{pageNo:pageNo,pageSize:pageSize},function (d) {
            pageCount=d.pageCount;
            var data= d.page;
            var str="";
            for(var i=0;i<data.length;i++){
                str+="<tr>\n" +
                    "            <td>"+data[i].bookId+"</td>\n" +
                    "            <td>"+data[i].bookName+"</td>\n" +
                    "            <td>"+data[i].authorName+"</td>\n" +
                    "            <td>"+data[i].price+"</td>\n" +
                    "            <td>"+data[i].category.categoryName+"</td>\n"+
                    "            <td>\n" +
                    "                <a onclick=\"if(confirm('是否删除?')){return true;}else{return false;}\" href=\"${pageContext.request.contextPath}/deleteBook/"+data[i].bookId+"\">&nbsp;删除 >></a>\n" +
                    "                <a href=\"${pageContext.request.contextPath}/jumpUpdateBook?bookId="+data[i].bookId+"\">&nbsp;&nbsp;更新 >></a>\n" +
                    "            </td>\n" ;
            }
            $("#tbody").html(str);
            joinPage(pageNo,pageCount);
            bindEven();
            showCurrentCss(pageNo,".currentPage");
        });
        /*事件绑定*/
        function bindEven() {

            //绑定上一页
            $("#pre").click(function () {

                if(pageNo<=1){
                    alert("当前已经是第一页");
                }else{
                    pageNo=pageNo-1;
                    //调用后台获取分页数据接口
                    $.getJSON("getBookPage",{pageNo:pageNo,pageSize:pageSize},function (d) {
                        console.log("================",d);
                        //更新总页数
                        pageCount=d.pageCount;
                        var data= d.page;
                        console.log(data);
                        var str="";
                        for(var i=0;i<data.length;i++){
                            str+="<tr>\n" +
                                "            <td>"+data[i].bookId+"</td>\n" +
                                "            <td>"+data[i].bookName+"</td>\n" +
                                "            <td>"+data[i].authorName+"</td>\n" +
                                "            <td>"+data[i].price+"</td>\n" +
                                "            <td>"+data[i].category.categoryName+"</td>\n"+
                                "            <td>\n" +
                                "                <a onclick=\"if(confirm('是否删除?')){return true;}else{return false;}\" href=\"${pageContext.request.contextPath}/deleteBook/"+data[i].bookId+"\">&nbsp;删除 >></a>\n" +
                                "                <a href=\"${pageContext.request.contextPath}/jumpUpdateBook?bookId="+data[i].bookId+"\">&nbsp;&nbsp;更新 >></a>\n" +
                                "            </td>\n" ;
                        }
                        //将拼接好的str设置到tbody下
                        $("#tbody").html(str);

                        joinPage(pageNo,pageCount);
                        bindEven();
                        showCurrentCss(pageNo,".currentPage");
                    });
                }

            });
            //绑定下一页
            $("#next").click(function () {
                if(pageNo>=pageCount){
                    alert("已经是最后一页");
                }else{
                    pageNo=pageNo+1;
                    $.getJSON("getBookPage",{pageNo:pageNo,pageSize:pageSize},function (d) {
                        console.log("================",d);
                        //更新总页数
                        pageCount=d.pageCount;
                        var data= d.page;
                        console.log(data);
                        var str="";
                        for(var i=0;i<data.length;i++){
                            str+="<tr>\n" +
                                "            <td>"+data[i].bookId+"</td>\n" +
                                "            <td>"+data[i].bookName+"</td>\n" +
                                "            <td>"+data[i].authorName+"</td>\n" +
                                "            <td>"+data[i].price+"</td>\n" +
                                "            <td>"+data[i].category.categoryName+"</td>\n"+
                                "            <td>\n" +
                                "                <a onclick=\"if(confirm('是否删除?')){return true;}else{return false;}\" href=\"${pageContext.request.contextPath}/deleteBook/"+data[i].bookId+"\">&nbsp;删除 >></a>\n" +
                                "                <a href=\"${pageContext.request.contextPath}/jumpUpdateBook?bookId="+data[i].bookId+"\">&nbsp;&nbsp;更新 >></a>\n" +
                                "            </td>\n" ;
                        }
                        //将拼接好的str设置到tbody下
                        $("#tbody").html(str);

                        joinPage(pageNo,pageCount);
                        bindEven();
                        showCurrentCss(pageNo,".currentPage");
                    });
                }
            });

            //绑定中间页
            var cps = $(".currentPage");
            for(var i=0;i<cps.length;i++){
                $(cps[i]).click(function () {

                    console.log(parseInt(this.innerHTML));
                    //更新pageNo
                    pageNo=parseInt(this.innerHTML);
                    //获取当前页数据


                    $.getJSON("getBookPage",{pageNo:pageNo,pageSize:pageSize},function (d) {
                        console.log("================",d);
                        //更新总页数
                        pageCount=d.pageCount;
                        var data= d.page;
                        console.log(data);
                        var str="";
                        for(var i=0;i<data.length;i++){
                            str+="<tr>\n" +
                                "            <td>"+data[i].bookId+"</td>\n" +
                                "            <td>"+data[i].bookName+"</td>\n" +
                                "            <td>"+data[i].authorName+"</td>\n" +
                                "            <td>"+data[i].price+"</td>\n" +
                                "            <td>"+data[i].category.categoryName+"</td>\n"+
                                "            <td>\n" +
                                "                <a onclick=\"if(confirm('是否删除?')){return true;}else{return false;}\" href=\"${pageContext.request.contextPath}/deleteBook/"+data[i].bookId+"\">&nbsp;删除 >></a>\n" +
                                "                <a href=\"${pageContext.request.contextPath}/jumpUpdateBook?bookId="+data[i].bookId+"\">&nbsp;&nbsp;更新 >></a>\n" +
                                "            </td>\n" ;
                        }
                        //将拼接好的str设置到tbody下
                        $("#tbody").html(str);

                        joinPage(pageNo,pageCount);
                        bindEven();
                        showCurrentCss(pageNo,".currentPage");
                    });

                });
            }



        }

        /*给当前页添加样式*/
        function showCurrentCss(pageNo,currentPage) {
            console.log("-------->>>>>>>>>>>",pageNo,currentPage);
            var cps = $(currentPage);
            for(var i=0;i<cps.length;i++){
                if(cps[i].innerHTML==pageNo){
                    $(cps[i]).css({
                        "color":"red"
                    })
                }
            }
        }

        /*生成动态分页的方法 中间页码最多展示三个  */
        function joinPage(pageNo,pageCount) {

            var str="<li><a id='pre' href=\"#\">上一页</a></li>";

            //中间页面的生成
            if(pageCount<=3){
                for(var i=1;i<=pageCount;i++){
                    str+="<li><a class='currentPage' href=\"#\">"+i+"</a></li>";
                }
            }else{
                //总页数比3大
                if(pageNo<=3){  // 1,2,3
                    for(var i=1;i<=3;i++){
                        str+="<li><a class='currentPage' href=\"#\">"+i+"</a></li>";
                    }
                }else {  //    4,5,6
                    for(var i=pageNo-2;i<=pageNo;i++){
                        str+="<li><a class='currentPage' href=\"#\">"+i+"</a></li>";
                    }
                }
            }
            str+="<li><a id='next' href=\"#\">下一页</a></li>";
            //设置到指定的位置
            $("#page").html(str);
        }
    }
</script>

</body>
</html>