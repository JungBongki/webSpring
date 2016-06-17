<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>로그인</h3>
<form action = "${pageContext.request.contextPath }/join/login.do" method = "post">
<table border="1">
<tr><th>id</th><td><input type ="text" name ="id"></td></tr>
<tr><th>pwd</th><td><input type ="text" name ="pwd"></td></tr>
<tr><td colspan="2"><input type ="submit" value ="로그인"></td></tr>
</table>
<a href="${pageContext.request.contextPath }/view/join/joinForm.jsp">
회원가입
</a>
</form>
</body>
</html>