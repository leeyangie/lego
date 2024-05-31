<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>lego instruction</title>
<jsp:include page="/WEB-INF/views/head.jsp"></jsp:include>
<style>
#page1 {width: 100vw; height: 300px; background-color: #FCCE23; 
display: flex; justify-content: center; align-items: center; 
color: #fff; font-size: 40px; font-weight: 700;}
#page2 {width: 100vw; height: 800px}
</style>
</head>

<body>
<div class="content_wrap">
	<header id="header">
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
    <div class="contents" id="page1">
	레고 조립설명서
	</div>
	<div class="contents" id="page2">
	<c:if test="${sid eq 'admin' }">
    <a href="${path1}/board/createForm.do">Create New</a>
    </c:if>
    <table>
        <tr>
            <th>Bno</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${board.bno}</td>
                <td><a href="${path1}/board/view?bno=${board.bno}">${board.title}</a></td>
                <td>${board.author}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
	<footer id="footer">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>