<html>
<#--引入头文件-->
<#include "../common/header.ftl">

<body>
<#--div start-->
<div id="wrapper" class="toggled">
<#-- 边栏sidebar -->
<#include "../common/nav.ftl">

<#-- 主要内容content start -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>商品类目名</label>
                            <input name="categoryName" type="text" class="form-control" value="${(category.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control" value="${(category.categoryType)!''}"/>
                        </div>
                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<#-- 主要内容content end -->
</div>
<#--div end-->
</body>
</html>
