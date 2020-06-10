<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 渡劫
  Date: 2020/6/4
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
${goods.goodsid}
${goods.goodsname}
${goods.goodsprice}
${goods.goodscount}
<img src="image/${goods.goodspic}">

<c:forEach items="${goods.set}" var="pic">
    <img src="image/${pic.pname}">
</c:forEach>
<input type="text" value="1" id="num">
<a href="javascript:void(0)" onclick="addCar()">加入购物车</a>
<a href="user.do?p=addcollection&goodsid=${goods.goodsid}">收藏</a>

</body>
</html>
<script>
    function addCar() {
        var  num = document.getElementById("num").value;
        location = "goods.do?p=addCar&num="+num+"&goodsid=${goods.goodsid}";
    }
</script>