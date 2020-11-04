<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/8/21
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功!!!来自springmvc的请求</h1><br>

<hr>
<h1>成功!!!来自springmvc的带来的数据</h1><br>
pageContext.${pageScope.msg}<br>
request.${requestScope.msg}<br>
session.${sessionScope.msg}<br>
pageContext.${pageScope.msg}<br><hr>
<h5 style="color:red">来自配置文件中的请求</h5>




</body>
</html>
