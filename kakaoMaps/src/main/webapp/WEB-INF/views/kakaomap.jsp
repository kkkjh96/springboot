<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>카카오 지도</title>
</head>
<body>
	<div id="map" style="height: 400px; width: 70%;"></div>
	<p>
		<button onclick="setCenter()">지도 중심좌표 이동시키기</button>
		<button onclick="panTo()">지도 중심좌표 부드럽게 이동시키기</button>
		<button onclick="setOverlayMapTypeId('traffic')">교통정보 보기</button>
		<button onclick="setOverlayMapTypeId('roadview')">로드뷰 도로정보 보기</button>
		<button onclick="setOverlayMapTypeId('terrain')">지형정보 보기</button>
		<button onclick="setOverlayMapTypeId('use_district')">지적편집도
			보기</button>

	</p>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94ada9b1e453568c29f533e3378ecbbb">
		
	</script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 5
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
		// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

		function setCenter() {
			// 이동할 위도 경도 위치를 생성합니다 
			var moveLatLon = new kakao.maps.LatLng(33.452613, 126.570888);

			// 지도 중심을 이동 시킵니다
			map.setCenter(moveLatLon);
		}

		function panTo() {
			// 이동할 위도 경도 위치를 생성합니다 
			var moveLatLon = new kakao.maps.LatLng(33.450580, 126.574942);

			// 지도 중심을 부드럽게 이동시킵니다
			// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
			map.panTo(moveLatLon);
		}
		// 지도에 추가된 지도타입정보를 가지고 있을 변수입니다
		var currentTypeId;

		// 버튼이 클릭되면 호출되는 함수입니다
		function setOverlayMapTypeId(maptype) {
			var changeMaptype;

			// maptype에 따라 지도에 추가할 지도타입을 결정합니다
			if (maptype === 'traffic') {

				// 교통정보 지도타입
				changeMaptype = kakao.maps.MapTypeId.TRAFFIC;

			} else if (maptype === 'roadview') {

				// 로드뷰 도로정보 지도타입
				changeMaptype = kakao.maps.MapTypeId.ROADVIEW;

			} else if (maptype === 'terrain') {

				// 지형정보 지도타입
				changeMaptype = kakao.maps.MapTypeId.TERRAIN;

			} else if (maptype === 'use_district') {

				// 지적편집도 지도타입
				changeMaptype = kakao.maps.MapTypeId.USE_DISTRICT;
			}

			// 이미 등록된 지도 타입이 있으면 제거합니다
			if (currentTypeId) {
				map.removeOverlayMapTypeId(currentTypeId);
			}

			// maptype에 해당하는 지도타입을 지도에 추가합니다
			map.addOverlayMapTypeId(changeMaptype);

			// 지도에 추가된 타입정보를 갱신합니다
			currentTypeId = changeMaptype;
		}
	</script>
</body>
</html>