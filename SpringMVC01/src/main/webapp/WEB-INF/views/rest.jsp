<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/rest/delete/1">
    <input hidden="hidden" type="text" name="_method" value="delete">
    <input type="submit" value="DELETE">
</form>
<hr/>
<hr/>
<form method="post" action="${pageContext.request.contextPath}/rest/put">
    <input hidden="hidden" type="text" name="_method" value="put">
    <input type="submit" value="PUT">
</form>
</body>
</html>
