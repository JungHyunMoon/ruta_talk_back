<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<!-- 카카오맵 API -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=본인 카카오API KEY"></script>
<script type="text/javascript"
	src="/static/cdnjs/proj4js-combined.min.js"></script>
<body>
	<div id="map" style="width: 100%; height: 1000px;"></div>
	<script type="text/javascript">
		Proj4js.reportError = function(msg) {
			alert(msg);
		}
		Proj4js.defs['WGS84경위도'] = '+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs';
		Proj4js.defs['BESSEL경위도'] = '+proj=longlat +ellps=bessel +towgs84=-146.43,507.89,681.46 +no_defs';

		var wgs84 = new Proj4js.Proj('WGS84경위도');
		var bessel = new Proj4js.Proj('BESSEL경위도');

		var p = new Proj4js.Point('좌표값1', '좌표값2');

		var result = Proj4js.transform(wgs84, bessel, p);

		var mapContainer = document.getElementById('map'); // 지도를 표시할 div
		var mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 9, // 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption);
		var customOverlay = new kakao.maps.CustomOverlay({});
		var infowindow = new kakao.maps.InfoWindow({
			removable : true
		});
		
		
		$.getJSON("/static/geojson/sido.json", function(geojson) {
			var data = geojson.features;

			console.log(data);
			console.log(data.length)
			
/* 			var polygonPath = [];
			var region = data[0].geometry.coordinates[0];
			region.forEach(function(region) {
				polygonPath.push(new kakao.maps.LatLng(region[1], region[0]));
		    });
			
			var polygon = new kakao.maps.Polygon({
			    path:polygonPath, // 그려질 다각형의 좌표 배열입니다
			    strokeWeight: 3, // 선의 두께입니다
			    strokeColor: '#39DE2A', // 선의 색깔입니다
			    strokeOpacity: 0.8, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			    strokeStyle: 'longdash', // 선의 스타일입니다
			    fillColor: '#A2FF99', // 채우기 색깔입니다
			    fillOpacity: 0.7 // 채우기 불투명도 입니다
			});
			polygon.setMap(map); */
			
			for (var i = 0; i < data.length; i++) {
				
				var polygonPath = [];
				var region = data[i].geometry.coordinates[0];
				region.forEach(function(region) {
					polygonPath.push(new kakao.maps.LatLng(region[1], region[0]));
			    });
				
				var randomColor = "#" + Math.floor(Math.random() * 16777215).toString(16);
				var polygon = new kakao.maps.Polygon({
				    path:polygonPath, // 그려질 다각형의 좌표 배열입니다
				    strokeWeight: 3, // 선의 두께입니다
				    strokeColor: randomColor, // 선의 색깔입니다
				    strokeOpacity: 0.8, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				    strokeStyle: 'longdash', // 선의 스타일입니다
				    fillColor: randomColor, // 채우기 색깔입니다
				    fillOpacity: 0.7 // 채우기 불투명도 입니다
				});
				polygon.setMap(map);
			}
			
		});
	</script>
</body>
</html>