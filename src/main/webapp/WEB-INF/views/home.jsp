<%@ page language="java" contentType="text/html charset=UTF8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Home</title>
<jsp:include page="head.jsp"></jsp:include>
<style>
* {cursor: url('resources/images/cursor35.png'), auto; /* 커스텀 커서 이미지 사용 */}
.color_group { display: flex; height: 60px; }
#page1 { display: flex; justify-content: center; align-items: center; height: 900px; background-color: #FCCE23}
#page2 { height: 120px;}
#color1 { background-color: #fff }
#color2 { background-color: #E4E4E4 }
#color3 { background-color: #ED2025 }
#color4 { background-color: #fff }
#color5 { background-color: #000 }
#color6 { background-color: #1F66DE }
#color7 { background-color: #ED2025 }
#color8 { background-color: #1F66DE }
#color9 { background-color: #000 }
#color10 { background-color: #1F66DE }
#color11 { background-color: #FCCE23 }
#color12 { background-color: #ED2025 }
#color13 { background-color: #FCCE23 }
#color14 { background-color: #E4E4E4 }

#page3 { background-color: #04125B; height: 800px;}

#icon_wrap {
	width: 100vw;
    padding-top: 100px;
    display: flex;
    justify-content: center;
    margin-bottom: 80px;
}

.icon_menu { 
	width: 1060px;
    display: flex;
    justify-content: space-around;
}

.icon { 
	width: 120px; 
}

.icon img { width: 100%;}

#image3_wrap { 
	width: 1260px; 
	display: flex;
	justify-content: space-around;
    margin: 0 auto;
	
}

.imagebox3 {
	width: 400px;
}

.imagebox3 img {
	width: 100%;
}

@media (min-width: 769px) and (max-width: 985px) {
    .icon_menu { 
        width: 900px; /* 중간 화면 너비 조정 */
    }
    .icon { 
        width: 100px; /* 중간 화면 아이콘 너비 */
    }
}

/* 큰 화면 */
@media (min-width: 986px) and (max-width: 1199px) {
    .icon_menu { 
        width: 900px; /* 큰 화면 너비 조정 */
    }
    .icon { 
        width: 100px; /* 큰 화면 아이콘 너비 */
    }
}

/* 더 큰 화면 */
@media (min-width: 1200px) {
    .icon_menu { 
        width: 1060px; /* 더 큰 화면 너비 조정 */
    }
    .icon { 
        width: 120px; /* 더 큰 화면 아이콘 너비 */
    }
}

/* 작은 화면 */
@media (max-width: 768px) {
    .icon_menu { 
        width: 600px; /* 작은 화면 너비 조정 */
    }

    .icon { 
        width: 70px; /* 작은 화면 아이콘 너비 */
    }

}

</style>
</head>
<body>
<div class="content_wrap">
<header id="header">
	<jsp:include page="header.jsp"></jsp:include>
</header>

<div class="contents" id="page1">
<div id="main_img"><img alt="lego" src="resources/images/LE_GO.png"></div>
</div>
<div class="contents" id="page2">
	<div class="color_group">
	<div id="color1" style= width:10%;  ></div>
	<div id="color2" style= width:21%; ></div>
	<div id="color3" style= width:10%></div>
	<div id="color4" style= width:12%></div>
	<div id="color5" style= width:18%></div>
	<div id="color6" style= width:29%></div>
	</div>
	<div class="color_group">
	<div id="color7" style= width:7%;></div>
	<div id="color8" style= width:7%;></div>
	<div id="color9" style= width:17%;></div>
	<div id="color10" style= width:19%;></div>
	<div id="color11" style= width:15%;></div>
	<div id="color12" style= width:12%;></div>
	<div id="color13" style= width:9%;></div>
	<div id="color14" style= width:14%;></div>
	</div>
</div>

<div class="contents" id="page3">

	<div id="icon_wrap">
	    <ul class="icon_menu">
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon8.png" alt="아이콘0">
	                    <h3>신제품</h3>
	                </div>
	            </a>
	        </li>
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon9.png" alt="아이콘1">
	                    <h3>혜택</h3>
	                </div>
	            </a>
	        </li>
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon10.png" alt="아이콘2">
	                    <h3>시티</h3>
	                </div>
	            </a>
	        </li>
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon11.png" alt="아이콘3">
	                    <h3>우주</h3>
	                </div>
	            </a>
	        </li>
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon12.png" alt="아이콘4">
	                    <h3>레고이야기</h3>
	                </div>
	            </a>
	        </li>
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon13.png" alt="아이콘5">
	                    <h3>독점제품</h3>
	                </div>
	            </a>
	        </li>
	        <li>
	            <a href="">
	                <div class="icon">
	                    <img src="${path2 }/resources/images/icon/icon14.png" alt="아이콘6">
	                    <h3>레고드림즈</h3>
	                </div>
	            </a>
	        </li>
	    </ul>
	</div>
	<div id="image3_wrap">
		<div class="imagebox3"><img src="${path2 }/resources/images/image3-1.png" alt="이미지1"></div>
		<div class="imagebox3"><img src="${path2 }/resources/images/image3-2.png" alt="이미지2"></div>
		<div class="imagebox3"><img src="${path2 }/resources/images/image3-3.png" alt="이미지3"></div>
	</div>
</div>
<footer id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>
</body>
</html>
