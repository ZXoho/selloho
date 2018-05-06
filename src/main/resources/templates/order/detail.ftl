<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">

    <!--边栏-->
        <#include  "../common/nav.ftl">

    <!--主要内容-->
    <div id="page-content-wrapper">
        <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>订单Id</th>
                        <th>订单金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.orderAmount}</td>
                    </tbody>
                </table>
            </div>

            <!--订单详情-->
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>商品Id</th
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>金额</th>
                        </tr>
                        </thead>
                        <tbody>
                       <#list orderDTO.orderDetailList as orderDetail>
                       <th>${orderDetail.productId}</th>
                       <th>${orderDetail.productName}</th>
                       <th>${orderDetail.productPrice}</th>
                       <th>${orderDetail.productQuantity}</th>
                       <th>${orderDetail.productQuantity * orderDetail.productPrice}</th>
                       </#list>
                        </tbody>
                    </table>
                </div>
<#if orderDTO.getOrderStatusEnum().getMsg() == "新订单">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                    </div>
                </div>
            </div>
</#if>


            </div>
        </div>
        </div>

    </div>
</body>
</html>