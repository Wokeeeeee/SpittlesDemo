<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>吐槽吧</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>管理员注册</h1>

<sf:form method="POST" commandName="manager">
    <sf:errors path="*" cssClass="error"/><br/><br/>

    　姓名：<sf:input path="fullname" /><sf:errors path="fullname" cssClass="error"/><br/><br/>
    　邮箱：<sf:input path="email" /><sf:errors path="email" cssClass="error"/>  <br/><br/>
   联系方式：<sf:input path="phoneNo" /><sf:errors path="phoneNo" cssClass="error"/>  <br/><br/>
    用户名：<sf:input path="userName" /><sf:errors path="userName" cssClass="error"/><br/><br/>
    　密码：<sf:password  path="password" /><sf:errors path="password" cssClass="error"/><br/><br/>
    <input type="submit" value="注册" />
</sf:form>
</body>
</html>