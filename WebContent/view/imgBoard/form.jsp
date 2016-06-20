<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이미지 업로드</title>
</head>
<body>
<h3>이미지 업로드</h3>
<form action ="${pageContext.request.contextPath }/imgBoard/add.do"
method="post" enctype = "multipart/form-data">
	제목 : <input type = "text" name ="title"/><br>
	작성자 : <input type = "text" name ="writer" 
	value =${sessionScope.id } readonly/><br/>
	파일 : <input type = "file" name ="file"/><br>
	<input type = "submit" value = "파일업로드"/> 
</form>
</body>
</html>
