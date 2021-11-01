<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>吐槽吧</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>管理员个人信息</h1>
用户名：<c:out value="${manager.userName}" /><br/><br/>
　姓名：<c:out value="${manager.fullname}" /> <br/><br/>
　邮箱：<c:out value="${manager.email}" /><br/><br/>
联系方式：<c:out value="${manager.phoneNo}" /><br/><br/>
是否删除：<c:out value="${manager.delete}" /><br/><br/>
<form method="get" action="update">
    <input type="submit" value="更新个人信息">
</form>
<c:if test = "${not empty sessionScope.manager }">
    <a href="home">返回管理员首页</a>
</c:if>
</body>
</html>
