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
인기 키워드 :
<c:forEach var = "popularQuery" items = "${popularQueryList }">
${popularQuery }
</c:forEach>
<br/>
<select name = "type">
	<c:forEach var= "searchType" items="${searchTypeList }">
	<option value = "${searchType.code }">
	${searchType.text }
	</option>
	</c:forEach>
</select>
</body>
</html>