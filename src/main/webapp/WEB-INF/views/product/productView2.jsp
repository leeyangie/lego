<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>제품상세보기</title>
	<jsp:include page="/WEB-INF/views/head.jsp"></jsp:include>
	<style>
	.table { al}
	</style>
</head>
<body>
<div class="content_wrap">
	<header id="header">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<main id="contents" class="contents">
		<div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px;">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="${path1 }">Home</a></li> 
			    <li><a href="${path1 }/product/productList.do">제품</a></li>
			    <li class="is-active"><a href="#" aria-current="page">상세보기</a></li>
			  </ul>
			</nav>
	   	</div>
	    <section class="page" id="page1">
    		<div class="page-wrap">
 				<div class="clr-fix">
					<table id="tb1" class="table" width="1200">
						<tbody>
							<tr>
								<th>제품 번호</th>
								<td>${product.productid }</td>
							</tr>
							<tr>
								<th>상품 카테고리</th>
								<td>
									<p>
										<strong title="${product.productcategory }">
										<c:if test="${product.productcategory.equals('building')}">
											건물
										</c:if>
										<c:if test="${product.productcategory.equals('superhero')}">
											슈퍼히어로
										</c:if>
										<c:if test="${product.productcategory.equals('entertainment')}">
											엔터테인먼트
										</c:if>
										<c:if test="${product.productcategory.equals('car')}">
											자동차
										</c:if>
										<c:if test="${product.productcategory.equals('fantasy')}">
											판타지
										</c:if>
										</strong>
									</p>
								</td>
							</tr>
							<tr>
								<th>제품 이름</th>
								<td>${product.productname }</td>
							</tr>
							<tr>
								<th>제품 가격</th>
								<td>${product.price }</td>
							</tr>
							<tr>
								<td colspan="2" class="img_wrap"><img src="${path1}/resources/upload/${product.img1 }" alt="${product.productname }"/></td>
							</tr>
							<tr>
								<th>상품 설명</th>		
								<td class="pre_wrap">${product.description }</td>
							</tr>
							<tr>
								<td colspan="2" class="img_wrap"><img src="${path1}/resources/upload/${product.img2 }" alt="${product.productname } 상품 설명 이미지"/></td>
							</tr>
						</tbody>
					</table>
					<hr>
					<div class="buttons">
					  <c:if test="${cus.id.equals('admin') }">					  
						  <a href="${path1 }/admin/insertProduct.do" class="button is-danger">상품 등록</a>
						  <a href="${path1}/admin/insertInventory.do" class="button is-light">상품 입고</a>
						  <a href="${path1 }/admin/updateProduct.do?productid=${product.productid }" class="button is-warning">상품 수정</a>
						  <a href="${path1 }/admin/delProduct.do?productid=${product.productid }&productcategory=${product.productcategory }" class="button is-danger is-dark">상품 삭제</a>
					  </c:if>
					 <a href="${path1 }/sales/insSales.do?productid=${product.productid }" class="button is-danger">구매</a>		
					 <a href="${path1 }/product/listAll.do" class="button is-primary">상품 목록</a>
					</div>
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