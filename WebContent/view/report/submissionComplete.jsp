<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>리포트 제출 성공페이지</title>
</head>
<body>
리포트제출완료
<h3>이미지 리스트</h3>
<a href="${pageContext.request.contextPath }/view/report/submissionForm.jsp">이미지올리기</a>
<c:forEach var="i" items="${files }">
<img src = "/img/${i }" style = "width:100px;height:100px"><br>
</c:forEach>
</body>
</html>