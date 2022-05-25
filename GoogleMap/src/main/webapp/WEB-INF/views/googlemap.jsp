<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Simple Map</title>
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css" />
<script type="module" src="/js/index.js"></script>
</head>
<body>
	<div id="map"></div>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAExKhXYAkBdMNh0tdkuv9lkeYOYbYqUMU&callback=initMap&region=kr">
	</script>
</body>
</html>