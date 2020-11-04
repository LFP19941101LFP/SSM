<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/8/21
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>图书的怎删改查请求</title>
  </head>
  <body>
  <%--
    TEST风格的请求方式
  --%>
  <a href="book/1">查询图书</a><br>

  <form action="book" method="post">
    <input type="submit" value="添加1号图书"/>
  </form><br>

  <form action="book/1" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <input type="submit" value="删除1号图书"/>
  </form><br>

  <form action="book/1" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="submit" value="更新1号图书"/>
  </form><br>


  </body>
</html>
