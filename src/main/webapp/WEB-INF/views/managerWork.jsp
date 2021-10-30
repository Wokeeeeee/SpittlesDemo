<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Title</title>
</head>
<body>
manager working place
<div class="spittleList">
    <h1>待审核内容</h1>
    <ul class="spittleList">
        <c:forEach items="${spittleList}" var="spittle" >
            <c:choose>
                <c:when test="${spittle.ischecked}">
                    已审核<br>
                </c:when>
                <c:otherwise>
                    <li id="spittle_<c:out value="${spittle.id}"/>">
                        <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
                        <div class="spittleTime">
                            <fmt:formatDate value="${spittle.postedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            by <c:out value="${spittle.spitter.userName }" />
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </ul>
</div>
</body>
</html>
