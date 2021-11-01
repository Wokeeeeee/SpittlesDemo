<%--
  Created by IntelliJ IDEA.
  User: lxy
  Date: 2021/10/30
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>管理员${manager.userName}，您好</h1>
<b>您可以执行以下操作</b>
<br>
<h3><a href="${manager.userName}">个人信息</a></h3>
<br>
（您可以查看或更新个人信息）
<br>
<h3><a href="list">管理员人员管理</a></h3>
<br>
（您可以查看当前管理员名单，添加新的管理员和删除其他管理员）

<br>
<h3><a href="../checking">审核吐槽贴</a></h3>
<br>
（审核吐槽贴，可以选择通过或删除某吐槽贴，只有通过的吐槽贴才会被显示在用户的吐槽列表中）

<br>
<h3><a href="../spitter/list">用户列表</a></h3>
<br>

<br>
<h3><a href="../spitter/logout">退出登录</a></h3>
<br>
<br>
<h3><a href="springmvc_exec4_war_exploded/">返回首页</a></h3>
<br>
</body>
</html>
