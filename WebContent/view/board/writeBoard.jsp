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
Ÿ��Ʋ : <input type = "text" name = "title"><br>
����   : <input type = "text" name = "content"><br>
�ۼ���   : <input type = "text" name = "writer" value = "${sessionScope.id }" readonly><br>
<input type = "submit" value = "�ۼ�">
</form>
</body>
</html>