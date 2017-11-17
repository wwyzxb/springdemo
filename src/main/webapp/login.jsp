<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<form action="login">
    用户名：<input id="username" name="username" type="text"></br>
    密码：<input id="password" name="password" type="password"></br>
    <input type="submit">
</form>
<span>当前ip:<%= request.getRemoteAddr()%></span>
</body>
</html>
