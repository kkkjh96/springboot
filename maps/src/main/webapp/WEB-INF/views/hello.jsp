<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<script src="${contextPath}/js/scriptTest.js" type="text/javascript"></script>
<meta charset="utf-8">
<title>hello.JSP 페이지</title>
</head>
<body>
	안녕하세요
	<br>
	<h2>${message}</h2>
	<img width=200 height=200 src="${contextPath}/image/duke3.png" />
	<br />
	<input type="button" name="테스트" value="테스트" onClick="test();">
	<div id="map" style="width: 500px; height: 400px;"></div>
	<!-- <img
			src="https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap
					&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318
					&markers=color:red%7Clabel:C%7C40.718217,-73.998284
					&key=AIzaSyB6dBdKIXtJawwr2Kcz2u4q6nAswZRDBzk"> -->
	<div id="map2" style="width: 500px; height: 400px;"></div>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAExKhXYAkBdMNh0tdkuv9lkeYOYbYqUMU&callback=initMap&region=kr"></script>
	<script>
		function initMap() {
			var seoul = {
				lat : 37.5642135,
				lng : 127.0016985
			};
			var map2 = new google.maps.Map(document.getElementById('map2'), {
				zoom : 12,
				center : seoul
			});

		}
	</script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94ada9b1e453568c29f533e3378ecbbb">
		
	</script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667),
			level : 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>
