<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% pageContext.setAttribute("ctp", request.getContextPath()); %>

<title>测试其他</title>
	<script type="text/javascript" src="${ctp}/script/jquery-1.7.2.js">
    </script>
</head>
<body>
	<form action="${ctp}/testRequestBody" method="post" enctype="multipart/form-data">
		<input name="username" value="tomcat"/>
		<input name="password" value="123"/>
		<input type="file" name="file" />
		<input type="submit"/>
	</form>
	<h5>获取一个请求中的请求体</h5>
	
	<form action="${ctp}/test" method="post" enctype="multipart/form-data">
		<input name="username" value="tomcat"/>
		<input name="password" value="123"/>
		<input type="file" name="file" />
		<input type="submit"/>
	</form>
	
	
	
	<form action="${ctp}/test01" method="post" enctype="multipart/form-data">
		<input name="username" value="tomcat"/>
		<input name="password" value="123"/>
		<input type="file" name="file" />
		<input type="submit"/>
	</form>
	
</body>


</html>