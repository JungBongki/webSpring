<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action = "${pageContext.request.contextPath }/board/write.do" method = "post">
타이틀 : <input type = "text" name = "title"><br>
내용   : <input type = "text" name = "content"><br>
작성자   : <input type = "text" name = "writer" value = "${sessionScope.id }" readonly><br>
<input type = "submit" value = "작성">
</form>
</body>
</html>