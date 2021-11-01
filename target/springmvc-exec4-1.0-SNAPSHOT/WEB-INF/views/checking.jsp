<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2021/10/30
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>manager check</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<c:if test = "${not empty sessionScope.manager }">
    <a href="/springmvc_exec4_war_exploded/manager/home">返回管理员首页</a>
</c:if>
<div class="spittleList">
    <h1>待审核内容</h1>
    <c:choose>
        <c:when test="${empty spittleList}">
            there is no spittles to check.
        </c:when>
        <c:otherwise>
            第1页共${maxPage}页
            <form action="checking" method="post">
                每页显示个数：<input type="number" name="count" min="2" max="50" value="${count}">
                <input type="submit" value="跳转">到第<input type="number" value="${curPage}" name="curPage" min="1"
                                                         max="${maxPage}">页
            </form>
        </c:otherwise>
    </c:choose>


    <ul class="spittleList">
        <div class="spittleList">
            <ul class="spittleList">
                <c:forEach items="${spittleList}" var="spittle">
                    <li id="spittle_<c:out value="${spittle.id}"/>">
                        <div class="spittleMessage">
                                ${spittle.id}<br><c:out value="${spittle.message}"/></div>
                        <div class="spittleTime">
                            <fmt:formatDate value="${spittle.postedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            by <c:out value="${spittle.spitter.userName }"/>
                        </div>
                    </li>
                    <form action="checking/check/${spittle.id}" method="post">
                        <input name="check" type="checkbox" value="pass" checked="checked">通过
                        <input name="check" type="checkbox" value="delete">删除
                        <input type="submit" value="提交" name="submit">
                    </form>
                    <br>
                    <hr>
                </c:forEach>
            </ul>
        </div>
    </ul>
</div>
</body>
</html>
