<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@ include file="../common/common.jsp" %>
    
   
    <style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	} 
</style>

     albumInsertForm.jsp<br>
    
<h2>앨범 추가 화면</h2>
    
   <form:form commandName="album" action="insert.ab" method="post"> <!-- insert.ab를 post방식으로(form은 get방식) -->
	<p>            
		노래제목 <input type="text" name="title" value="${album.title}">
		<form:errors path="title" cssClass="err"/> <br><br>
	</p>
	
	<p>
		가수명 <input type="text" name="singer" value="${album.singer}">
		<form:errors path="singer" cssClass="err"/> <br><br>
	</p>
	
	<p>
		가격 <input type="text" name="price" value="${album.price}">
		<form:errors path="price" cssClass="err"/> <br><br>
	</p>
	
	<p>
		발매일 <input type="text" name="day" value="${album.day}"> <br><br>
	</p>
	
	<input type="submit" value="추가하기">
</form:form>