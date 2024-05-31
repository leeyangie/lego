<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Board Form</title>
</head>
<body>
    <h1>Board Form</h1>
    <form action="${pageContext.request.contextPath}/board/addBoard.do" method="post" enctype="multipart/form-data">
        <p>Title: <input type="text" name="title" value="${board.title}" /></p>
        <p>Content: <textarea name="content">${board.content}</textarea></p>
        <p>Author: <input type="text" name="author" value="${board.author}" /></p>
        <p>파일 선택 : <input type="file" name="file"></p>
		<p><input type="submit" value="Save" /></p>
    </form>
    <a href="${pageContext.request.contextPath}/board/boardList.do">Back to List</a>
</body>
</html>