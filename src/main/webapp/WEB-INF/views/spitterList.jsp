<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2021/11/1
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>spitterList</title>
</head>
<body>
<h2>spittleList</h2>
<c:choose>
    <c:when test="${empty spitterList}">
        there is no spitters.
    </c:when>
    <c:otherwise>
        第1页共${SmaxPage}页
        <form id="spitter_sub" method="post">
            每页显示个数：<input type="number" name="Scount" min="2" max="50" value="${Scount}">
            <input type="submit" value="跳转">到第<input type="number" value="${ScurPage}" name="ScurPage" min="1"
                                                     max="${SmaxPage}">页
        </form>

        <ul class="spittleList">
            <div class="spittleList">
                <ul class="spittleList">
                    <c:forEach items="${spitterList}" var="spitter">
                        <li id="spitter<c:out value="${spitter.id}"/>">
                            userName:${spitter.userName}<br>
                            email:${spitter.email}<br>
                            fullname:${spitter.firstName} ${spitter.lastName}<br>
                        </li>
                        <br>
                        <hr>
                    </c:forEach>
                </ul>
            </div>
        </ul>
    </c:otherwise>
</c:choose>

</body>
</html>
