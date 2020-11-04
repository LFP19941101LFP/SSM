<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
<title>Insert title here</title>
<script type="text/javascript" src="${ctp}/script/jquery-1.7.2.js">
    </script>
</head>
<body>

	<form action="${ctp}/testRequestBody" method="post">
	</form>
	<a href="${ctp}/requestBody">ajax发送json请求</a>
	<br>
	<hr>
	
	<a href="${ctp}/haha">将数据写出去</a><br><hr>
	
	<a href="${ctp}/getajax">ajax请求获取所有员工</a>
	<hr> 
	
</body>


<script type="text/javascript">
    //requestBody请求,封装自定义对象
	 $("a:first").click(function(){
		var emp = {
			lastName:"李四",
			email:"2215@qq.com",
			gender:0
		};
		//alert(typeof emp);
		//js对象
		var empStr = JSON.stringify(emp);
		//alert(typeof empStr);
		$.ajax({
			url:"${ctp}/requestBody",
			type:"POST",
			data:empStr,
			contentType:"application/json",
			success:function(data) {
				alert(data);
			}
		});
		return false;
	}); 
</script>
</html>