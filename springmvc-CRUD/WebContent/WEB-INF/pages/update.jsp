<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工添加</title>
</head>
<body>

	<!-- SpringMVC的表单标签
		1.导图SpringMVC的表单标签库
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		2.path:是原生的jsp的那么选项,使用path代替,自动回显隐含模型中某个对象对应的这个属性的值
		3.modelAttribute="employee":取出employee对象中的值
	 -->
	 <% pageContext.setAttribute("ctp", request.getContextPath()); %>
	 
	<form:form action="${ctp}/emp/${employee.id}" modelAttribute="employee" method="post"><br>
		<input type="hidden" name="_method" value="put"/>
		<input type="hidden" name="id" value="${employee.id}"/>
		<%-- 姓名:<form:input path="lastName"/><br> --%>
		邮箱:<form:input path="email" /><br>
		性别:<br><br>
			男:<form:radiobutton path="gender" value="1"/>
			女:<form:radiobutton path="gender" value="0"/><br>
		部门:
			<!--
			items="":指定要遍历的集合,自动遍历,遍历出的每一个元素时一个department对象
			itemLabel="属性名":指定遍历出这个对象的那个属性是作为option标签体的值
			itemValue="属性名":指定刚才遍历出来的这个对象的那个属性作为要提交的vlaue的值
			表单标签会报错:object for bean name 'command' available as request attribute	
			  -->
			<form:select path="department.id" items="${depts}"
				itemLabel="departmentName" itemValue="id"><br>
			</form:select><br>
			<input type="submit" value="修改"/><br>
	</form:form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


</body>
</html>