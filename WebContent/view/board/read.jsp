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
�۹�ȣ : <input type = "text" name = "num" value = "${a.num }"readonly><br>
�ۼ��ð� : <input type = "text" name = "num" value = "${a.w_date }"readonly><br>
Ÿ��Ʋ : <input type = "text" name = "title" value = "${a.title }"readonly><br>
����   : <input type = "text" name = "content" value = "${a.content }"readonly  height = "80%" width = "50%"><br>
�ۼ��� : <input type = "text" name = "writer" value = "${a.writer }" readonly><br>
<%-- �ۼ��ð� : <input type = "text" name = "w_date" value = "${a.w_date }" readonly><br> --%>
<c:if test="${sessionScope.id eq a.writer}">
	<input type = "button" value = "����" onclick = 'location.href="${pageContext.request.contextPath}/board/delBoard.do?num=${a.num}"'/><br>
	<input type = "button" value = "����" onclick = 'location.href="${pageContext.request.contextPath}/board/revise.do?num=${a.num}"'/><br>
</c:if>
</form>
<form action = "${pageContext.request.contextPath }/board/write.do" method = "POST">
<input type="text" name = "content">
<input type="hidden" name ="parent" value="${a.num }">
<input type="hidden" name ="writer" value="${sessionScope.id }">
<input type="hidden" name ="title" value=" ->>${a.title }">
<input type="submit" value ="��� �ޱ�">
</form>
<h3>��۸��</h3>
<table border="1">
<tr><th>�ۼ���</th><th>����</th></tr>
<c:forEach var="rep" items="${reps }">
<tr><td>${rep.writer }</td><td>
<a href="${pageContext.request.contextPath }/board/read.do?num=
${rep.num}">${rep.content }</a></td></tr>
</c:forEach>
</table>
<input type = "button" value = "�ڷΰ���" onclick = 'location.href = "${pageContext.request.contextPath}/board/list.do"' /><br>
</body>
</html>