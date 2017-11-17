<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<form action="/login">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input id="username" name="username" type="text"></td>

        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="password" name="password" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
