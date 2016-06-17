<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- <script type="text/javascript">
	var form = document.f;
	
	function back(){
		location.href = "list.do";
	}
	function remove(){
		form.action = "${pageContext.request.contextPath }/board/delBoard.do";
		form.submit();
	} 
	function revise(){
		form.action = "${pageContext.request.contextPath }/board/revise.do";
		form.submit();
	}

</script> -->
<meta charset = "EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name = "f" method = "POST">
글번호 : <input type = "text" name = "num" value = "${a.num }"readonly><br>
작성시간 : <input type = "text" name = "num" value = "${a.w_date }"readonly><br>
타이틀 : <input type = "text" name = "title" value = "${a.title }"readonly><br>
내용   : <input type = "text" name = "content" value = "${a.content }"readonly  height = "80%" width = "50%"><br>
작성자 : <input type = "text" name = "writer" value = "${a.writer }" readonly><br>
<%-- 작성시간 : <input type = "text" name = "w_date" value = "${a.w_date }" readonly><br> --%>
<c:if test="${sessionScope.id eq a.writer}">
	<input type = "button" value = "삭제" onclick = 'location.href="${pageContext.request.contextPath}/board/delBoard.do?num=${a.num}"'/><br>
	<input type = "button" value = "수정" onclick = 'location.href="${pageContext.request.contextPath}/board/revise.do?num=${a.num}"'/><br>
</c:if>
</form>
<input type = "button" value = "뒤로가기" onclick = 'location.href = "${pageContext.request.contextPath}/board/list.do"' /><br>
</body>
</html>