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
<form name = "editForm" method = "POST" action = "${pageContext.request.contextPath }/board/revise_OK.do">
Ÿ��Ʋ : <input type = "text" name = "title" value = "${a.title }"><br>
����   : <input type = "text" name = "content" value = "${a.content }"><br>
<input type = "hidden" name = "num" value = "${a.num }"/>
<input type = "hidden" name = "parent" value = "${a.parent }"/>
<input type = "hidden" name = "writer" value = "${a.writer }"/>
<%-- <input type = "hidden" name = "w_date" value = "${a.w_date }"/> --%>
<input type = "submit" value = "����"><br>
</form>
<input type = "button" value = "�ڷΰ���" onclick = 'location.href = "${pageContext.request.contextPath}/board/list.do"'/><br>
</body>
</html>
