<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<form enctype="multipart/form-data" method="post"
		action="addTopic">
		文件上传：<input type="file" name="myUpload" /><br> 
		phone：<input type="text" name="phone" /><br>
		subjectId：<input type="text" name="subjectId" /><br>
		content：<input type="text" name="content" /><br>
		 <input type="submit" value="提交" />
	</form>
</body>
</html>