<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}">
<title>����Ʈ����FORM</title>
</head>
<body>
<h3>Ŀ�ǵ� ��ü ���</h3>
<form action ="${pageContext.request.contextPath }/report/submitReport3.do"
method="post" enctype = "multipart/form-data">
	�й� : <input type = "text" name ="studentNumber"/><br>
	����Ʈ���� : <input type = "file" name ="report"/><br>
	<input type = "submit"/> 
</form>
</body>
</html>