<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 渡劫
  Date: 2020/6/5
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${map}" var="m">
    ${m.key.goodsid}|${m.key.goodsname}|<a href="">-</a>${m.value}<a href="goods.do?p=addcarnum&goodsid=${m.key.goodsid}">+</a><a href="goods.do?p=delfromcar&goodsid=${m.key.goodsid}">删除</a><br>
</c:forEach>

</body>
</html>
