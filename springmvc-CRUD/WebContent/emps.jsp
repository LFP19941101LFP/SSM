<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<% pageContext.setAttribute("ctp", request.getContextPath()); %>

<title>ajax请求</title>
	<script type="text/javascript" src="${ctp}/script/jquery-1.7.2.js">
    </script>
</head>

<body>
	<%=new Date() %>
	<a href="${ctp}/getajax">ajax请求所有员工</a>
	<div>
		
	</div>
	<script type="text/javascript">
	
		$("a:first").click(function(){
			$.ajax({
				url:"${ctp}/getajax",
				type:"GET",
				success:function(data) {
					//console.log(data);
					//遍历
					$.each(data,function(){
						var empInfo = this.lastName+"==>"+this.birth+"==>"+this.gender;
						$("div").append(empInfo+"<br/>");
					});
				}
			});
			//禁用默认的a标签超链接方式请求
			return false;
		});
	</script>
</body>
</html>
