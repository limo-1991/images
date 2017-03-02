<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int n = 0;
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="<%=path%>/css/reset.css" rel="stylesheet">
    <link href="<%=path%>/css/css.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
<h1>旋转的照片</h1>
<div class="content">

    <c:forEach items="${images}" var="image">
        <img class="<%="pic"+(++n)%>" src="${image.uri}">
    </c:forEach>

</div>
</body>
</html>
