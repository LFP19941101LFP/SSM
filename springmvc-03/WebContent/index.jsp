<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>

</head>
<body>

	<!-- 文件上传
		1.文件上传 enctype="multipart/form-data"
		2.导包:commons-fileupload-1.2.1.jar  commons-io-2.0.jar
		3.在springmvc配置文件中配置文件上传解析器multipartResolver
		4.文件上传请求处理
			在处理方法上写一个 @RequestParam("headerimg") MultipartFile file封装了当前文件的信息,可以直接保存
	 -->
	 ${msg}
	 <form action="${ctp}/upload" method="post" enctype="multipart/form-data">
	 	用户头像:<input name="headerimg" type="file"/><br>
	 	用户名:<input type="text" name="username"/><br>
	 	<input type="submit"/><br>
	 
	 </form>
	 <br><hr>
	 
	 
	 
	  ${msg}
	 <form action="${ctp}/uploadmore" method="post" enctype="multipart/form-data">
	 	用户头像:<input name="headerimg" type="file"/><br>
	 	用户头像:<input name="headerimg" type="file"/><br>
	 	用户头像:<input name="headerimg" type="file"/><br>
	 	用户头像:<input name="headerimg" type="file"/><br>
	 	用户名:<input type="text" name="username"/><br>
	 	<input type="submit"/><br>
	 </form>
</body>
</html>