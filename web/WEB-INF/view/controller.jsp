<%--
  Created by IntelliJ IDEA.
  User: limo
  Date: 2017/3/2
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图片管理</title>
    <link href="<%=path%>/css/reset.css" rel="stylesheet">
    <link href="<%=path%>/css/css.css" rel="stylesheet">

</head>
<body>
<div id="img">
    <ul class="ing-a">

        <c:forEach items="${images}" var="image">
            <li class="ing-b">
                <img src="${image.uri}">
                <a href="<%=path%>/delete/${image.id}.html">删除</a>
            </li>
        </c:forEach>

    </ul>


    <div class="input-a">
        <form action="<%=path%>/controller" method="post" enctype="multipart/form-data">
            <input type="file" name="file" /> <input type="submit" value="Submit" /></form>
    </div>
</div>

</body>
</html>
