<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  --%>

<%@include file="../common/common.jsp" %>
album/albumlist.jsp<br>
<script type="text/javascript">
	function insert(){
		location.href="insert.ab";
	}
	
	function goUpdate(num){
		location.href="update.ab?num=" +num;
	}
</script>
<center>
<form action="list.ab" method="get">
<select name ="whatColumn">
<option value="all"> 전체 검색
<option value="title"> 노래제목
<option value="singer"> 가수명
</select>
<input type="text" name="keyword" value="">
<input type="submit" value="검색">
</form>
</center>


<table border=1 width="500" align="center">
	<tr>
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>가수</th>
		<th>가격</th>
		<th>발매일</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
	<c:forEach var="album" items="${albumLists}">
		<tr>
			<td>${album.num}</td>
			<td>
			<a href="detail.ab?num=${album.num}">${album.title}</a><!-- 제목 클릭하면 상세보기 -->
</td>
<td>${album.singer}</td>
			<td>
			<%-- <td>${album.price}</td> --%>
		<fmt:formatNumber value="${album.price}" type="number" groupingUsed="true"/>
		<%-- 	<fmt:formatNumber value="${album.price}" pattern="#,###"/>원 </td>--%>
			</td>
			
			<td>
			<fmt:parseDate  value="${album.day }" var="day" pattern="yyyy-MM-dd" />
			<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>
			</td>
			
			<!-- 발매일에 날짜만 나오게 설정하기-->
			
<td><input type ="button" value="수정" onClick="goUpdate(${album.num})"></td>
			
			<td><a href="delete.ab?num=${album.num}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<center>
${pageInfo.pagingHtml }
</center>




<hr>
<br><br><br><br><br>
<table border=1 width="500" align="center">
	<tr>
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>가수</th>
		<th>가격</th>
		<th>발매일</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
	<c:forEach var="i" begin="0" end="${fn:length(albumLists)-1}">
		<tr>
			<td>${albumLists.get(i).getNum()}</td>
			<td>${albumLists[i].title}</td>
			<td>${albumLists.get(i).getSinger()}</td>
			<td>${albumLists[i].price}</td>
			<td>${albumLists[i].day}</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
	</c:forEach>
</table>
