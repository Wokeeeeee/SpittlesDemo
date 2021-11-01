<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2021/10/31
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>修改管理员个人信息</title>
</head>
<body>
<h1>更新个人信息</h1>
<form method="post">
    姓名：<input type="text" name="fullname" value="${manager.fullname}"
              onfocus="if(value=='${manager.fullname}') {value=''}"
              onblur="if (value=='') {value=${manager.fullname}}"><br><br>
    　 邮箱：<input type="text" name="email" value="${manager.email}" onfocus="if(value=='${manager.email}') {value=''}"
                onblur="if (value=='') {value=${manager.email}}"><br><br>
    联系方式： <input type="text" name="phoneNo" value="${manager.phoneNo}"
                 onfocus="if(value=='${manager.phoneNo}') {value=''}"
                 onblur="if (value=='') {value=${manager.phoneNo}}"><br><br>
    用户名： <input type="text" name="userName" value="${manager.userName}"
                onfocus="if(value=='${manager.userName}') {value=''}"
                onblur="if (value=='') {value=${manager.userName}}"><br><br>
    密码： <input type="text" name="password" value="${manager.password}"
               onfocus="if(value=='${manager.password}') {value=''}"
               onblur="if (value=='') {value=${manager.password}}"><br><br>
    <input type="submit" value="更新">

</form>

</body>
</html>
