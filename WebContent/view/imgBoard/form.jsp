<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�̹��� ���ε�</title>
</head>
<body>
<h3>�̹��� ���ε�</h3>
<form action ="${pageContext.request.contextPath }/imgBoard/add.do"
method="post" enctype = "multipart/form-data">
	���� : <input type = "text" name ="title"/><br>
	�ۼ��� : <input type = "text" name ="writer" 
	value =${sessionScope.id } readonly/><br/>
	���� : <input type = "file" name ="file"/><br>
	<input type = "submit" value = "���Ͼ��ε�"/> 
</form>
</body>
</html>
