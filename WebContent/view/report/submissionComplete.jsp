<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����Ʈ ���� ����������</title>
</head>
<body>
����Ʈ����Ϸ�
<h3>�̹��� ����Ʈ</h3>
<a href="${pageContext.request.contextPath }/view/report/submissionForm.jsp">�̹����ø���</a>
<c:forEach var="i" items="${files }">
<img src = "/img/${i }" style = "width:100px;height:100px"><br>
</c:forEach>
</body>
</html>