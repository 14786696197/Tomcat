<%--
  Created by IntelliJ IDEA.
  User: 渡劫
  Date: 2020/6/4
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>

</head>

<style>


    #bigDiv {
        width: 400px;
        height: 120px;
        border: 1px solid blue;
        text-align: center;
        margin: auto;
    }

    .smalldiv {
        width: 80px;
        height: 80px;
        border: 1px solid red;
        float: left;
        margin-left: 15px;
        margin-top: 10px;
    }

    .goodspic {
        width: 60px;
        height: 50px;

    }

</style>
<body>
<div id="bigDiv">
    <c:forEach items="${map.list}" var="goods">
        <div class="smalldiv">
                ${goods.goodsid}${goods.goodsname}
            <a href="goods.do?p=findbyid&goodsid=${goods.goodsid}" title="查看详情"><img class="goodspic" src="image/${goods.goodspic}"></a>
        </div>
    </c:forEach>
</div>


</body>
</html>
