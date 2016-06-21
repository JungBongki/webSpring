<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이미지목록</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/view/join/httpRequest.js"></script>
<script type="text/javascript">
	var loginId = "";
	function writeRep(f, num, writer) {
		loginId = writer;
		var param = "imgNum=" + num + "&content=" + f.content.value + 
					"&writer=" + writer;
		f.content.value="";
		sendRequest("${pageContext.request.contextPath}/imgBoard/writeRep.do",
				param, writeRepResult, "POST");
	}
	function writeRepResult() {
		if (httpRequest.readyState == 4) { // ajax에 데이터를 정상적으로 보냈을 때 (일종의 signal)
			if (httpRequest.status == 200) { // 웹서버의 응답이 정상일때 ()
				var str = httpRequest.responseText;
				var reps = eval("(" + str + ")");
				var imgNum = reps[0].imgNum;
				var myDiv = document.getElementById("div_"+imgNum);
				var html = "";
				for(i=0; i<reps.length; i++){
					html += reps[i].content + 
					"(작성자:" + reps[i].writer + ")";
					if(loginId==reps[i].writer){
						html += "<input type='button' value='X' onclick ='delRep(" + reps[i].num + ",\"${sessionScope.id}\")'>";
					}
					html += "<br>";
				}
				myDiv.innerHTML = html;
			}
		}
	}
	
	function delRep(num, writer) {
		loginId = writer;
		var param = "num=" + num;
		sendRequest("${pageContext.request.contextPath}/imgBoard/delRep.do",
				param, writeRepResult, "POST");
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
				<form action = "">
					<input type="text" name="content">
					<input type="button" value="댓글작성" 
					onclick="writeRep(this.form,${i.num},'${sessionScope.id }')">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="div_${i.num }">
					<c:forEach var="r" items="${i.reps }">
							${r.content }(작성자:${r.writer })
						<%-- <c:if test = "${sessionScope.id==r.writer }">
							<input type="button" value="X" onclick = "delRep(${r.num}, '${sessionScope.id }')"> 
						</c:if> --%>
						<br>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</c:forEach>
</body>
</html>