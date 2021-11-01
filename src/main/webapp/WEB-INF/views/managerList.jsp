<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2021/10/31
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>管理员人员管理</title>
</head>
<c:if test = "${not empty sessionScope.manager }">
    <a href="home">返回管理员首页</a>
</c:if>
<body>
<h1>管理员${manager.userName}</h1>
<h2><a href="register">1.添加管理员</a><br></h2>
<h2>2.管理员名单<br></h2>
第${McurPage}页共${MmaxPage}页
<form action="list" method="post">
    每页显示个数：<input type="number" name="Mcount" min="2" max="50" value="${Mcount}"><br>
    跳转到第<input type="number" value="${McurPage}" name="McurPage" min="1"
               max="${MmaxPage}">页 <input type="submit" value="跳转">
</form>
<ul>
    <c:forEach items="${managerList}" var="manager_">
        <li id="manager_<c:out value="${manager_.id}"/>">
            <h3>${manager_.userName}</h3>
            fullname:${manager_.fullname}<br>
            phoneNo:${manager_.phoneNo}<br>
            email:${manager_.email}<br>
            <c:choose>
                <c:when test="${manager_.delete==0}">
                    任职中
                    <form action="delete/${manager_.id}" method="post">
                        <input type="submit" value="删除">
                    </form>
                </c:when>
                <c:otherwise>
                    已删除
                </c:otherwise>
            </c:choose>
            <hr>
        </li>
    </c:forEach>
</ul>
</body>
</html>
