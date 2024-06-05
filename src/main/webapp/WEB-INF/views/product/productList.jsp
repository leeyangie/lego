<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<%boolean isLoggedIn = session.getAttribute("cus") != null;%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>product</title>
<jsp:include page="/WEB-INF/views/head.jsp"></jsp:include>
<style>
#contents {height: 2500px;}
#page2 { height: 900px; }
#list1 { 
	display: grid; 
	grid-template-columns: repeat(4 , 25%);
	
}

@media (max-width: 1200px) {
            #list1 {
            grid-template-columns: repeat(3 , 33%);
            }
        }

@media (max-width: 960px) {
            #list1 {
            grid-template-columns: repeat(2 , 50%);
            }
        }
        @media (max-width: 640px) {
            #list1 {
            grid-template-columns: repeat(1 , 100%);
            }
        }

.img_wrap {
	width: 100%;
	height: 300px;
	margin-top: 20px; 
	margin-bottom: 30px;
}
.column {
	background-color: #F7F1EE;
	display: flex;
	flex-direction: column;
	margin: 3px;
}

.column:hover {background-color: #fff; }

.img_wrap img { width: 100%;}

.itme_wrap { 
	width:100%;
}

.column_inner { 
	width: 200px; 
	height: 500px; 
	overflow: hidden;
	margin: 30px auto;
	
}

.column > i { 
    align-self: flex-end;
    margin-top: 20px;
    margin-right: 20px;
}


.list_descpt {

    display: -webkit-box;
    -webkit-line-clamp: 2; /* 최대 표시할 줄 수 */
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis; /* 줄임말 표시 */
}

.list_title { text-align: center; line-height: 2em;}
.list_cate { text-align: center; font-size: 13px; line-height: 2em;}
.list_descpt { text-align: center; font-size: 13px; line-height: 1,5em;}
.list_price { text-align: center; line-height: 2em;}

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
			    <li><a href="${path1 }/product/list.do">제품</a></li>
			    <li class="is-active"><a href="#" aria-current="page">목록</a></li>
			  </ul>
			</nav>
			<section class="page" id="page1">
    		<h2 class="page-title">제품 목록</h2>
    		
    		<div class="tab_box">
	    		<div class="tabs">
				  <ul>
                        <li><a href="${path1 }/product/listAll.do" class="navbar-item" title="전체">
                            전체 제품
                        </a></li>
                        <li><a href="${path1 }/product/list.do?productcategory=building" class="navbar-item" title="건물">
                            건물
                        </a></li>
                        <li><a href="${path1 }/product/list.do?productcategory=superhero" class="navbar-item" title="슈퍼히어로">
                            슈퍼히어로
                        </a></li>
                        <li><a href="${path1 }/product/list.do?productcategory=entertainment" class="navbar-item" title="엔터테인먼트">
                            엔터테인먼트
                        </a></li>
                        <li><a href="${path1 }/product/list.do?productcategory=car" class="navbar-item" title="자동차">
                            자동차
                        </a></li>
                        <li><a href="${path1 }/product/list.do?productcategory=fantasy" class="navbar-item" title="판타지">
                            판타지
                        </a></li>   
				  </ul>
				</div>
    		</div>
    		
    		<div class="page-wrap">
	    		<div class="clr-fix">
	    			<br>
					<ul class="columns list" id="list1">
						<c:if test="${not empty list }">
							<c:forEach var="dto" items="${list }">
							<li class="column">
								<i class="fa-regular fa-heart" onclick="toggleHeart(this)"></i>
								<div class="column_inner">
									<a href="${path1 }/product/detail.do?productid=${dto.productid }" class="item_wrap">
										<div class="item_box">
											<div class="img_wrap"><img src="${path1}/resources/upload/${dto.img1 }" class="item_pic"/></div>
											<h4 class="list_cate">${dto.productcategory}</h4>
											<h3 class="list_title">${dto.productname }</h3>
											<p class="list_descpt">${dto.description }</p>
											<p class="list_price"><strong>${dto.price }</strong></p>
										</div>
									</a>
								</div>
							</li>
							</c:forEach>
						</c:if>
						<c:if test="${empty list }">
							<li>
								<p><strong>상품이 존재하지 않습니다.</strong></p>
							</li>
						</c:if>
					</ul>
					<script>
					$(document).ready(function(){
						/* $("#list1").DataTable({
							order:[[0,"desc"]]
						}); */
					});
					
					var isLoggedIn = <%= isLoggedIn %>;

					function toggleHeart(element) {
						if (!isLoggedIn) {
							alert("로그인이 필요합니다.");
							window.location.href = "${path1}/member/login.do"; // 로그인 페이지 URL로 리디렉션
							return;
						}

						if (element.classList.contains('fa-regular')) {
							element.classList.remove('fa-regular');
							element.classList.add('fa-solid');
						} else {
							element.classList.remove('fa-solid');
							element.classList.add('fa-regular');
						}
					}
					</script>
					<hr>
					<c:if test="${sid.equals('admin') }">
					<div class="buttons">
					  <a href="${path1 }/product/insert.do" class="button">글 등록</a>
					</div>
					</c:if>
				</div>
    		</div>
    	</section>
    	
		</div>
	</main>
	
	<footer id="footer">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>