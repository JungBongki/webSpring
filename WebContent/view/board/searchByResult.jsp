<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
[
<c:forEach var = "a" items = "${list }" varStatus = "status">
<c:if test="${not status.first }">,</c:if>
{num:${a.num }, writer:'${a.writer }', w_date:${a.w_date }', 
title:'${a.title }', content:'${a.content }'}

</c:forEach>

]