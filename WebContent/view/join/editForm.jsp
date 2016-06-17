<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
</script>
<title>회원정보수정</title>
</head>
<body>
<form action = "${pageContext.request.contextPath }/join/edit_OK.do" method = "post">
패스워드 : <input type = "text" name = "pwd"><br>
이름     : <input type = "text" name = "name"><br>
이메일   : <input type = "text" name = "email" ><br>
<input type = "submit" value = "수정">
</form>
</body>
</html>