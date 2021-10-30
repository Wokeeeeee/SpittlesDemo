<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
<div class="spittleList">
    <h1>待审核内容</h1>
    <ul class="spittleList">
        <div class="spittleList">
            <h1>最近吐槽</h1>
            <ul class="spittleList">
                <c:forEach items="${spittleList}" var="spittle" >
                    <li id="spittle_<c:out value="${spittle.id}"/>">
                        <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
                        <div class="spittleTime">
                            <fmt:formatDate value="${spittle.postedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            by <c:out value="${spittle.spitter.userName }" />
                        </div>
                    </li>
                    <form action="checking/${spittle.id}" method="post">
                        <input name="check" type="checkbox" value="pass" checked="checked">通过
                        <input name="check" type="checkbox" value="delete">删除
                        <input type="submit" value="提交" name="submit">
                    </form>
                    <br><hr>
                </c:forEach>
            </ul>
        </div>
    </ul>
</div>
</body>
</html>
