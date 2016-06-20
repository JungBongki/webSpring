<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}">
<title>리포트제출FORM</title>
</head>
<body>
<h3>커맨드 객체 사용</h3>
<form action ="${pageContext.request.contextPath }/report/submitReport3.do"
method="post" enctype = "multipart/form-data">
	학번 : <input type = "text" name ="studentNumber"/><br>
	리포트파일 : <input type = "file" name ="report"/><br>
	<input type = "submit"/> 
</form>
</body>
</html>