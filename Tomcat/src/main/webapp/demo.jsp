<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/19
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%--我的青春结束了，不再是 jsp/jstl 了 改成这个了。--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    h2 通过EL表达式直接获取存在域中的值，会按作用域从小到大依次查找 ${requestVar}<br>

    h2_1 直接获取request作用域中的值 ${pageContext.request.getAttribute("requestVar")}<br>

    h2_2 直接获取request作用域中的值 ${requestScope.requestVar}<br>
    jsp的版本和jstl的版本好像对不上，一直出错，不管了，反正不用jsp了。
    <hr>
</h2>
<h3>
    h3 ${pageScope.sessionVar}
</h3>
</body>
</html>
