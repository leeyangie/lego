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
<title>Product Insert</title>
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
	<div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px;">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="${path1 }">Home</a></li>
			    <li><a href="${path1 }/product/productList.do">제품</a></li>
			    <li class="is-active"><a href="#" aria-current="page">상품 등록</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">상품 등록</h2>
    		<div class="page-wrap">
	    		<div class="clr-fix">
	    			<br>
					<form action="${path1 }/product/insertPro.do" method="post" enctype="multipart/form-data">
						<table class="table">
							<tbody>
								<tr>
									<th><label for="productid">상품코드</label></th>
									<td>
										<input type="text" name="productid" id="productid" class="input" maxlength="100" required>
									</td>
									<th><label for="cate">카테고리</label></th>
									<td>
										<select name="productcategory" id="productcategory" required>
											<option value="">선택 안함</option>
											<option value="building">건물</option>
											<option value="superhero">슈퍼히어로</option>
											<option value="entertainment">엔터테인먼트</option>
											<option value="car">자동차</option>
											<option value="fantasy">판타지</option>
										</select>
									</td>
								</tr>
								<tr>
									<th><label for="productname">상품명</label></th>
									<td>
										<input type="text" name="productname" id="productname" class="input" maxlength="100" required>
									</td>
								</tr>
								<tr>
									<th><label for="description">상품 설명</label></th>
									<td>
										<textarea name="description" id="description" rows="8" cols="80" maxlength="980" class="textarea"></textarea>
									</td>
								</tr>
								<tr>
									<th><label for="price">가격</label></th>
									<td>
										<input type="number" min="0" step="100" value="500" name="price" id="price" class="input" />
									</td>
								</tr>
								<tr>
									<th><label for="img">상품 메인이미지</label></th>
									<td>
										<input type="file" name="img1" id="img1" accept="image/*" required/>
									</td>
								</tr>
								<tr>
									<th><label for="img">상품 상세 이미지</label></th>
									<td>
										<input type="file" name="img2" id="img2" accept="image/*" required/>
									</td>
								</tr>
								<tr>
									<th><label for="img">상품 썸네일 이미지</label></th>
									<td>
										<input type="file" name="img3" id="img3" accept="image/*" required/>
									</td>
								</tr>
							</tbody>
						</table>
						<hr>
						<div class="buttons">
						  <button type="submit" class="button is-danger">상품 등록</button>
						  <a href="${path2 }/product/productList.do" class="button is-primary">상품 목록</a>
						</div>
					</form>
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