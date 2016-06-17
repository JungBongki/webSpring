<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/httpRequest.js"></script>
<script type="text/javascript">
	function over(num){
		var param = "num = " + num;
		alert("Qwerqweqerqr");
		sendRequest("${pageContext.request.contextPath}/board/preview.do", 
				param, previewResult, "POST");
	}
	function previewResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var o = eval("(" + str + ")");
				var myDiv = document.getElementById("searchDiv");
				var html = o.content;
				myDiv.innerHTML=html;
			}
		}
	}
 	function out(){
 		alert("Qwerqweqerqr");
 		var myDiv = document.getElementById("previewDiv");
		myDiv.innerHTML = ""; 
	} 
	function search(){
		alert("Qwerqweqerqr");
		var ch = document.f2.type;
		var x;
		for(i=0;i<ch.length;i++){
			if(ch[i].check==true){
				x=ch[i].value;
			}
		}
		var param = "";
		var url = "";
		if(x==1){
			param = "writer="+document.f2.keyword.value;
			url = "searchById.do";
		} else if(x==2){
			param = "ttler="+document.f2.keyword.value;
			url = "searchByTitle.do";
		}
		sendRequest("${pageContext.request.contextPath}/board/"+url, 
				param, searchResult, "POST");
	}
	function searchResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				alert("Qwerqweqerqr");
				var str = httpRequest.responseText;
				var o = eval("(" + str + ")");
				var myDiv = document.getElementById("searchDiv");
				var html = "<table border='1'><tr><th>num</th><th>w_date</th><th>writer</th><th>title</th></tr>";
				for(i=0;i<o.length;i++){
					html += "<tr>";
					html += "<td>"+o[i].num+"</td>";
					html += "<td>"+o[i].w_date+"</td>";
					html += "<td>"+o[i].writer+"</td>";
					html += "<td><a href='${pageContext.request.contextPath }/board/read.do?num=" + o[i].num "'>" + o[i].title + " </a></td>";
					html += "</tr>"
				}
				html += "</table>"
				myDiv.innerHTML = html;
			}
		}
	}
</script>

</head>
<body>
<h3> </h3>
<a href="${pageContext.request.contextPath }/board/writeboard.do">게시물작성</a>
<table border="1" cellspacing="0">
<tr><th>num</th><th>w_date</th><th>writer</th><th>title</th></tr>
<c:forEach var ="board" items = "${list }">
<tr><td>${board.num }</td><td>${board.w_date }</td><td>${board.writer }</td><td>
<a href="${pageContext.request.contextPath }/board/read.do?num=${board.num }" 
onmouseover="over(${board.num })" onmouseout="out()">${board.title }</a></td></tr>
</c:forEach>
</table>
<!-- 미리보기 창만들기 -->
<div id = "previewDiv" style="position:absolute;top:30px;left:500px;"></div>
<form name = "f2">
<input type="radio" name ="type" value ="1" checked> 작성자
<input type="radio" name ="type" value ="2"> 제목
<input type="text" name ="keyword">
<input type="button" value="검색" onclick="search()">
</form>
<div id="searchDiv">
</div> 
</body>
</html>
