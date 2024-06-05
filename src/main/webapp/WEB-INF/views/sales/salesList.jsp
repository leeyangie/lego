<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>구매목록</title>
<jsp:include page="/WEB-INF/views/head.jsp"></jsp:include>
<style>
#contents {height: 800px;}
</style>
</head>
<body>
<div class="content_wrap">
	<header id="header">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<main id="contents" class="contents">
	<div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px; line-height:60px;">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="${path2 }">Home</a></li>
			    <li><a href="${path2 }/sales/salesList.do">구매</a></li>
			    <li class="is-active"><a href="#" aria-current="page">목록</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">구매 목록</h2>
    		<div class="page-wrap">
	    		<div class="clr-fix">
	    			<br>
					<table class="table" id="tb1">
						<thead>
							<tr>
								<th class="item1">번호</th>
								<th class="item2">상품내역</th>
								<th class="item3">거래일시</th>
								<th class="item4">결제내역</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty list }">
								<c:forEach var="dto" items="${list }" varStatus="status">
								<tr>
									<td>${fn:length(list) - status.index }</td>
									<td>
										<a href="${path1 }/sales/sales.do?sno=${dto.sno }" title="">
											<strong>${dto.productid }</strong>
										</a><br>
										<img src="${path1 }/resources/upload/${dto.img3 }" alt="${dto.productid }" width="120" />
									</td>
									<td>${dto.resdate }</td>
									<td>
										<strong>구매 수량 : ${dto.amount }</strong><br>
										<strong>결제 금액 : ${dto.tot }</strong><br>
										<strong>결제 내용 : ${dto.paynum }</strong><br>
									</td>
								</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty list }">
								<tr>
									<td colspan="4"><strong>구매내역이 존재하지 않습니다.</strong></td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<script>
					$(document).ready(function(){
						$("#tb1").DataTable({
							order:[[0,"desc"]]
						});
					});
					</script>
					<hr>
					<c:if test="${cus.id.equals('admin') }">
					<div class="buttons">
					  <a href="${path2 }/board/insertBoard.do" class="button is-danger">글 등록</a>
					</div>
					</c:if>
				</div>
    		</div>
    	</section>
	
	</main>
	<footer id="footer">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
</div>

</body>
</html>