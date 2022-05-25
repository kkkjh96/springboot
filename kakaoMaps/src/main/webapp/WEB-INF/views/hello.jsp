<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>

<html xmlns:th="http://www.thymeleaf.org">
<head>
<script src="${contextPath}/js/scriptTest.js" type="text/javascript"></script>
<meta charset="utf-8">
<title>hello.JSP 페이지</title>
</head>
<body>
	안녕하세요
	<br>
	<h2>${message}</h2>
	<div th:text="${message}"></div>
	<img width=200 height=200 src="${contextPath}/image/duke3.png" />
	<br />
	<input type="button" name="테스트" value="테스트" onClick="test();">
	<div id="map" style="width: 500px; height: 400px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94ada9b1e453568c29f533e3378ecbbb"></script>
<!-- 	<script type="text/javascript" -->
<!-- 		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script> -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94ada9b1e453568c29f533e3378ecbbb&libraries=services"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94ada9b1e453568c29f533e3378ecbbb&libraries=services,clusterer,drawing"></script>

	<script>
		var container = document.getElementById("map");
		var options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667),
			level : 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>
