<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/8/24
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入绝对路径 -->
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="${ctp}/script/jquery-1.7.2.js">
    
    </script>
</head>
<body>

<h1>员工列表</h1>
    <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>生日</th>
                <th>性别</th>
                <th>部门名</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.birth}</td>
                <td>${emp.gender == 0 ? "女" : "男"}</td>
                <td>${emp.department.departmentName}</td>
                <td>
                	<a href="${ctp}/emp/${emp.id}">修改</a>
                </td>
                <td>
                	<a href="${ctp}/emp/${emp.id}" class="deleteBtn">删除</a>
                	
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${ctp}/toaddpage">添加员工</a>
</body>
</html>

<form id="deleteForm" action="${ctp}/emp/${emp.id}" method="post">
   <input type="hidden" name="_method" value="DELETE"/>
</form>
<!--解决员工列表删除是按钮的问题 --> 
<script>
	$(".deleteBtn").click(function(){
		// 改变表单的action指向
		$("#deleteForm").attr("action",this.href);
		// 提交表单
		$("#deleteForm").submit();
		return false;
	});
</script>
