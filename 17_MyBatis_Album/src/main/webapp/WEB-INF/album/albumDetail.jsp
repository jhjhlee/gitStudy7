<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<%@include file="../common/common.jsp" %>
<!-- 복사붙여넣기 하고싶으면 include 지시어 사용하기! -->

albumDetail.jsp<br>

<h2>상품 상세 화면</h2>

<table border="1">
<tr>
<td>번호</td>
<td>${album.num }</td>
</tr>

<tr>
<td>노래 제목</td>
<td>${album.title }</td>
</tr>

<tr>
<td>가수명</td>
<td>${album.singer }</td>
</tr>

<tr>
<td>가격</td>
<td><fmt:formatNumber value="${album.price}" pattern="#,###"/>원</td>
</tr>
<tr>
<td>발매일</td>
 <td>
<fmt:parseDate var="day" value="${ album.day }" pattern="yyyy-MM-dd" />
<fmt:formatDate value="${ day }" pattern="yyyy-MM-dd" />
      </td>
      </tr>

<td colspan="2">
<a href="list.ab">앨범 리스트화면으로 돌아가기</a>
</td>


</table>