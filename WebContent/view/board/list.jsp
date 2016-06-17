<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset =EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> </h3>
<a href="${pageContext.request.contextPath }/board/writeboard.do">게시물작성</a>
<table border="1">
<tr><th>num</th><th>w_date</th><th>writer</th><th>title</th><th>content</th></tr>
<c:forEach var ="board" items = "${list }">
<tr><td>${board.num }</td><td>${board.w_date }</td><td>${board.writer }</td><td><a href="${pageContext.request.contextPath }/board/read.do?num=${board.num }">${board.title }</a></td><td>${board.content }</td></tr>
</c:forEach>
</table>
</body>
</html>