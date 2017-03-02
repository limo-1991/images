<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link href="<%=path%>/css/reset.css" rel="stylesheet">
  <link href="<%=path%>/css/css.css">
  <style>

  </style>
</head>
<body>
<a href="<%=path%>/image">旋转的图片</a><br>
<br>
<a href="<%=path%>/controller">后台管理</a><br>
<br>
<form action="<%=path%>/upload" method="post" enctype="multipart/form-data">
  <input type="file" name="file" /> <input type="submit" value="Submit" /></form>
</body>

</body>
</html>
