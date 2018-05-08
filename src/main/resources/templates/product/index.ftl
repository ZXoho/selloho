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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label >名称</label>
                            <input type="text" class="form-control" name="productName" value="${(product.productName)!''}" />
                        </div>
                        <div class="form-group">
                            <label >价格</label>
                            <input type="number" class="form-control" name="productPrice" value="${(product.productPrice)!''}" />
                        </div>
                        <div class="form-group">
                            <label >库存</label>
                            <input type="number" class="form-control" name="productStock" value="${(product.productStock)!''}" />
                        </div>
                        <div class="form-group">
                            <label >描述</label>
                            <input type="text" class="form-control" name="productDescription" value="${(product.productDescription)!''}" />
                        </div>
                        <div class="form-group">
                            <label >图片</label>
                            <img height="180" width="200" src="${(product.productIcon)!''}" alt="">
                            <input type="text" class="form-control" name="productIcon" value="${(product.productIcon)!''}" />
                        </div>
                        <div class="form-group">
                            <label >类目</label>
                            <select name="categoryType" class="form-control">
                                <#list productCategoryList  as category>
                                    <option value="${category.categoryType}"
                                    <#if (product.categoryType)?? && product.categoryType == category.categoryType>
                                        selected
                                    </#if>
                                        >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(product.productId)!''}">
                         <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>

        </div>
    </div>


</body>
</html>