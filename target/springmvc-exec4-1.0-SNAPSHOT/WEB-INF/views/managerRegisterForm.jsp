<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>吐槽吧</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>管理员注册</h1>

<form method="POST">


    　姓名：<input name="fullname" type="text"/><br/><br/>
    　邮箱：<input name="email" type="email"/> <br/><br/>
    联系方式：<input name="phoneNo" type="text"/><br/><br/>
    用户名：<input name="userName" type="text"/><br/><br/>
    　密码：<input name="password"  type="password" />
    <br/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
