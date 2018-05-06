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
                         <#list 1..orderDTOPage.getTotalPages() as num>
                             <#if currentPage == num>
                               <li class="disabled"><a href="/seller/order/list?page=${num}&size=${size}">${num}</a></li>
                             <#else>
                              <li><a href="/seller/order/list?page=${num}&size=${size}">${num}</a></li>
                             </#if>

                         </#list>
                         <#if currentPage gte orderDTOPage.getTotalPages()>
                         <li><a href="#">下一页</a></li>
                         <#else>
                              <li><a href="/seller/order/list?page=${num + 1}&size=${size}">${num}</a></li>
                         </#if>
                             </ul>
                         </div>
                         <table class="table table-bordered">
                             <thead>
                             <tr>
                                 <th>订单id</th>
                                 <th>姓名</th>
                                 <th>手机号</th>
                                 <th>地址</th>
                                 <th>金额</th>
                                 <th>订单状态</th>
                                 <th>支付状态</th>
                                 <th>创建时间</th>
                                 <th colspan="2"> 操作</th>
                             </tr>
                             </thead>
                             <tbody>
                     <#list orderDTOPage.content as orderDTO>
                     <tr>
                         <td>${orderDTO.orderId}</td>
                         <td>${orderDTO.buyerName}</td>
                         <td>${orderDTO.buyerPhone}</td>
                         <td>${orderDTO.buyerAddress}</td>
                         <td>${orderDTO.orderAmount}</td>
                         <td>${orderDTO.getOrderStatusEnum().msg}</td>
                         <td>${orderDTO.getPayStatusEnum().msg}</td>
                         <td>${orderDTO.createTime}</td>
                         <td>
                             <a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                         </td>
                         <td>
                         <#if orderDTO.getOrderStatusEnum().msg != "已取消">
                             <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                         </#if>
                         </td>
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