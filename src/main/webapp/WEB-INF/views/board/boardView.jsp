<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Board View</title>
</head>
<body>
<div class="content_wrap">
	<header id="header">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
    <h1>Board View</h1>
    <p>Bno: ${board.bno}</p>
    <p>Title: ${board.title}</p>
    <p>Content: ${board.content}</p>
    <p>Author: ${board.author}</p>
    <p>View Count: ${board.vcnt}</p>
    <p>Resdate: ${board.resdate}</p>
    <c:if test="${not empty board.url}">
        <p>Uploaded File: <a href="${path2}/resources/upload/${board.url }" download="">${board.url }</a></p>
    </c:if>
    
    <a href="${pageContext.request.contextPath}/board/boardList.do">Back to List</a>
    
    <c:if test="${sid eq 'admin' }">
    <a href="${path1}/board/editBoard.do?bno=${board.bno}">Edit</a>
    <a href="${path1}/board/delBoard.do?bno=${board.bno}">Delete</a>
    </c:if>
    <footer id="footer">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>