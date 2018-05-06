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

                         <#if currentPage lte 1>
                         <li><a href="#">上一页</a></li>
                         <#else>
                         <li><a href="/seller/order/list?page=${num - 1}&size=${size}">${num}</a></li>

                         </#if>
                         <#list 1..productInfoPage.getTotalPages() as num>
                             <#if currentPage == num>
                               <li class="disabled"><a href="/seller/order/list?page=${num}&size=${size}">${num}</a></li>
                             <#else>
                              <li><a href="/sell/seller/product/list?page=${num}&size=${size}">${num}</a></li>
                             </#if>

                         </#list>
                         <#if currentPage gte productInfoPage.getTotalPages()>
                         <li><a href="#">下一页</a></li>
                         <#else>
                              <li><a href="/sell/seller/product/list?page=${num + 1}&size=${size}">${num}</a></li>
                         </#if>
                        </ul>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类别</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2"> 操作</th>
                        </tr>
                        </thead>
                        <tbody>
                     <#list productInfoPage.content as productInfo>
                     <tr>
                         <td>${productInfo.productId}</td>
                         <td>${productInfo.productName}</td>
                         <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""> </td>
                         <td>${productInfo.productPrice}</td>
                         <td>${productInfo.productStock}</td>
                         <td>${productInfo.productDescription}</td>
                         <td>${productInfo.categoryType}</td>
                         <td>${productInfo.createTime}</td>
                         <td>${productInfo.updateTime}</td>
                         <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                         <#if productInfo.getProductStatusEnum().msg == "上架">
                            <td>
                                <a href="/sell/seller/product/offSale?productId=${productInfo.productId}">下架</a>
                            </td>
                         <#else>
                             <td>
                                 <a href="/sell/seller/product/onSale?productId=${productInfo.productId}">上架</a>
                             </td>
                         </#if>
                     </tr>

                     </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>