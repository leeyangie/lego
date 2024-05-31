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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <jsp:include page="../head.jsp"></jsp:include>
    
<style>
#page1 { height: 600px;}
</style>
</head>
<body>
<div class="content_wrap">
<header id="header">
    <jsp:include page="../header.jsp"></jsp:include>
</header>
<main id="contents" class="contents">
        <div id="breadcrumb">
            <nav class="breadcrumb" aria-label="breadcrumbs">
              <ul>
                <li><a href="${path1 }">Home</a></li>
                <li><a href="${path1 }">Member</a></li>
                <li class="is-active"><a href="#" aria-current="page">Log In</a></li>
              </ul>
            </nav>
        </div>
        <section class="page" id="page1">
            <h2 class="page-title">로그인</h2>
            <hr>
            <div class="page-wrap">
                <c:if test="${not empty flash.msg}">
                    <p>${flash.msg}</p>
                </c:if>
                <form action="${path1 }/member/loginPro.do" method="post" name="loginForm">
                    <div class="table_form_wrap">
                        <table class="table_form">
                            <tbody>
                            <tr>
                                <th><label for="id">아이디</label></th>
                                <td><input type="text" name="id" id="id" size="100" class="input" placeholder="아이디 입력" required></td>
                            </tr>
                            <tr>
                                <th><label for="pw">비밀번호</label></th>
                                <td><input type="password" name="pw" id="pw" class="input" placeholder="비밀번호 입력" required></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="buttons">
                                        <input type="submit" class="button is-danger" value="로그인">
                                        <input type="reset" class="button is-info" value="취소">
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </section>
    </main>
    
<footer id="footer">
    <jsp:include page="../footer.jsp"></jsp:include>
</footer>

</div>

</body>
</html>