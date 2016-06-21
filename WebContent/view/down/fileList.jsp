<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>파일다운로드</h3>
<c:forEach var="f" items="${list }">
<a href="${pageContext.request.contextPath }/file.do?name=${f.name}">${f.name}</a>
</c:forEach>
</body>
</html>