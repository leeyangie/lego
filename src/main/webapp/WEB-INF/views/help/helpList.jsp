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
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/head.jsp"></jsp:include>
<style>
#page1 {width: 100vw; height: 300px; background-color: #FCCE23; 
display: flex; justify-content: center; align-items: center; 
color: #fff; font-size: 40px; font-weight: 700;}
#page2 {width: 100vw; height: 800px}
#helpbox_cardwrap {
	display: grid; 
	grid-template-columns: 300px 300px 300px;
	margin: 0 auto;
}

.helpbox { width: 300px; height: 150px; border: 1px solid #333;}
</style>

</head>
<body>
<div class="content_wrap">
	<header id="header">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<div class="contents" id="page1">
		어떻게 도와드릴까요?
	</div>
	<div class="contents" id="page2">
		<div id="helpbox_cardwrap">
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
			<div class="helpbox" id="helpbox1">
				<a href="${path1}/board/boardList.do">자주 묻는 질문</a>
			</div>
		</div>
	</div>
	<footer id="footer">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>