<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!-- 헤더 내용 기술 -->
    
<div id="header_wrap">
<div id="sidemenu_bar"><i class="fa-solid fa-bars"></i></div>
<div id="logo_wrap"><a href="${path1 }/#"><img class="logoimg" alt="logo" src="${path1 }/resources/images/images.png"></a></div>
	<nav id="gnb">
	    <ul class="menu">
	        <li class="item"><a href="">ABOUT</a></li>
	        <li class="item"><a href="">BRAND STORY</a></li>
	        <li class="item"><a href="${path1}/product/listAll.do">SHOP</a></li>
	        <li class="item"><a href="${path1}/help">HELP</a></li>
	    </ul>
	</nav>
	<nav id="tnb">
	<c:if test="${!empty cus.id}">
		<div><a href="${path1 }/member/logout.do">로그아웃</a></div>
		<div><a href="${path1 }/member/mypage.do">마이페이지</a></div>
	</c:if>
	<c:if test="${empty cus.id}">
		<div><a href="${path1 }/member/login.do">로그인</a></div>
		<div><a href="${path1 }/member/join.do">회원가입</a></div>
	</c:if>
	<c:if test="${sid.equals('admin')}">
        <a href="${path1}/member/list.do">MemberList</a>
    </c:if>
	</nav>
	
	<script>
		const sidemenu_bar = document.getElementById('sidemenu_bar');
		const gnb = document.getElementById('gnb')
		
	</script>
	
</div>