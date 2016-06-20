<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이미지목록</title>
<script type="text/javascript">
	function delete_rep(){
		
	}

</script>
</head>
<body>
<a href="${pageContext.request.contextPath }
/view/imgBoard/form.jsp">사진올리기</a><br>
<c:forEach var="i" items="${list }">
	<table border="1" cellspacing="0">
		<tr>
			<th>title</th><td>${i.title }</td>
		</tr>
		<tr>
			<th>writer</th><td>${i.writer }</td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="${i.path }" style="width:200px;height:200px">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<form name="f" action = "${pageContext.request.contextPath }/imgBoard/addrep.do">
					<input type="text" name="content">
					<input type="hidden" name ="imgNum" value="${i.num }">
					<input type="hidden" name ="writer" value="${sessionScope.id }">
					<input type="submit" value="댓글작성">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="div_${i.num }">
					<c:forEach var="r" items="${i.reps }">
						${r.content }(작성자:${r.writer })
						<input type="button" value="삭제" onclick = 'location.href="${pageContext.request.contextPath}/imgBoard/delete_rep.do?num=${r.num}"'> 
						<br>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</c:forEach>
</body>
</html>