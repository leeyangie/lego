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
<title>mypage</title>
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
		<div id="breadcrumb" class="container breadcrumb-wrap clr-fix">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="#">Home</a></li>
			    <li><a href="${path2 }">Member</a></li>
			    <li class="is-active"><a href="#" aria-current="page">My Page</a></li>
			  </ul>
			</nav>
		</div>
		<section class="page" id="page1">
    		<h2 class="page-title">마이페이지</h2>
    		<hr>
    		<div class="page-wrap">
	    		<div class="clr-fix">
	                <table class="table">
	                    <tbody>
		                    <tr>
		                        <th>아이디</th>
		                        <td>${cus.id }</td>
		                    </tr>
		                    <tr>
		                        <th>비밀번호</th>
		                        <td>********
		                    </tr>
		                    <tr>
		                        <th>이름</th>
		                        <td>${cus.name }</td>
		                    </tr>
		                    <tr>
		                        <th>이메일</th>
		                        <td>${cus.email }</td>
		                    </tr>
		                    <tr>
		                        <th>전화번호</th>
		                        <td>${cus.tel }</td>
		                    </tr>
		                    <tr>
		                        <th>주소</th>
		                        <td>
		                            기본 주소 : ${cus.address1 } <br>
		                            상세 주소 : ${cus.address2 }
		                        </td>
		                    </tr>
		                    <tr>
		                        <td colspan="2">
		                        	<div class="buttons">
			                            <c:if test="${cus.id=='admin' }">
			                                <a href="${path1 }/member/memberDelete.do?id=${id }" class="button2">직권 강퇴</a>
			                            </c:if>
			                            <c:if test="${!empty cus.id }">
			                            	<a href="${path1 }/member/myUpdate.do" class="button1">회원 정보수정</a>
			                                <a href="${path1 }/member/memberDelete.do?id=${cus.id }" class="button3">회원 탈퇴</a>
			                            </c:if>
			                            <c:if test="${cus.id=='admin' }">
			                                <a href="${path1 }/admin/list.do" class="button1">회원 목록</a>
			                            </c:if>
			                        </div>    
		                        </td>
		                    </tr>
	                    </tbody>
	                </table>
	            	<div class="buttons">
	            		<a href="${path1 }/sales/salesList.do" class="button1">구매 내역</a>
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