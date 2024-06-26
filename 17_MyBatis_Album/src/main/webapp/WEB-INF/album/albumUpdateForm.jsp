<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>

<%@include file="../common/common.jsp" %>
albumUpdateForm.jsp<br>
<h3>앨범 수정 화면</h3>

<style type="text/css">
	.err {
		color: red;
		font-size: 12px;
		font-weight: bold;
	}
</style>

<form:form action="update.ab" method="post" commandName="album">
    <table border="1">
 <tr>
			<th>노래제목</th>
			<td>
				<input type="hidden" name="num" value="${album.num }">
				<input type="text" name="title" value="${album.title }">
				<form:errors path="title" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<th>가수명</th>
			<td>
				<input type="text" name="singer" value="${album.singer }">
				<form:errors path="singer" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>
				<input type="text" name="price" value="${album.price }">
				<form:errors path="price" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<th>발매일</th>
			<td>
				<fmt:parseDate value="${album.day}" var="dayFmt" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="day" value="${dayFmt}" pattern="yyyy-MM-dd"/>
			
				<input type="date" name="day" value="${day }">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기">&nbsp;&nbsp;
				<a href="list.ab">목록가기</a>
			</td>
		</tr>
	</table>
</form:form>
