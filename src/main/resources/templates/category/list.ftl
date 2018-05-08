<html>
     <#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">

    <!--边栏-->
        <#include  "../common/nav.ftl">

    <!--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                <#-- 分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right" >


                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>种类id</th>
                            <th>名称</th>
                            <th>类型</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                     <#list categoryList as category>
                       <tr>
                         <td>${category.categoryId}</td>
                         <td>${category.categoryName}</td>
                         <td>${category.categoryType}</td>
                         <td>${category.createTime}</td>
                         <td>${category.updateTime}</td>
                         <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                     </#list>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>