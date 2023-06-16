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
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cd5499bc6375351b9551e54e9a124094&libraries=clusterer"></script>
<body>
	<div id="map" style="width: 100%; height: 1000px;"></div>
	<div><img alt="test" src="/static/image/test.png" width="100px"></div>
	<script type="text/javascript">
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(37.54699, 127.09598),
			level : 12
		};

		var map = new kakao.maps.Map(container, options);

		var positions = [
		    {
		        "lat": 37.27943075229118,
		        "lng": 127.01763998406159,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.55915668706214,
		        "lng": 126.92536526611102,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.13854258261161,
		        "lng": 129.1014781294671,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.55518388656961,
		        "lng": 126.92926237742505,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.20618517638034,
		        "lng": 129.07944301057026,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.561110808242056,
		        "lng": 126.9831268386891,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.86187129655063,
		        "lng": 127.7410250820423,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.47160156778542,
		        "lng": 126.62818064142286,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.10233410927457,
		        "lng": 129.02611815856181,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.10215562270429,
		        "lng": 129.02579793018205,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.475423012251106,
		        "lng": 128.76666923366042,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.93282824693927,
		        "lng": 126.95307628834287,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.33884892276137,
		        "lng": 127.393666019664,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.520412849636,
		        "lng": 126.9742764161581,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.155139675209675,
		        "lng": 129.06154773758374,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.816041994696576,
		        "lng": 127.11046706211324,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 38.20441110638504,
		        "lng": 128.59038671285234,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.586112739308916,
		        "lng": 127.02949148517999,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.50380641844987,
		        "lng": 127.02130716617751,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.55155704387368,
		        "lng": 126.92161115892036,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.55413060051369,
		        "lng": 126.92207472929526,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.362321615174835,
		        "lng": 127.35000483225389,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.55227862908755,
		        "lng": 126.92280546294998,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.490413948014606,
		        "lng": 127.02079678472444,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.172358507549596,
		        "lng": 126.90545394866643,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.15474103200252,
		        "lng": 129.11827889154455,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.516081250973485,
		        "lng": 127.02369057166361,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.80711722863776,
		        "lng": 127.14020346037576,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.28957415752673,
		        "lng": 127.00103752005424,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.83953896766896,
		        "lng": 128.7566880321854,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.51027412948879,
		        "lng": 127.08227718124704,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.493581783270294,
		        "lng": 126.72541955660554,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.135291862962795,
		        "lng": 129.10060911448775,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.174574933144065,
		        "lng": 126.91389980787773,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.795887691878654,
		        "lng": 127.10660416587146,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.59288687521181,
		        "lng": 126.96560524627377,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.45076411130452,
		        "lng": 127.14593003749792,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.86008337557079,
		        "lng": 127.1263912488061,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.23773491330953,
		        "lng": 129.08371037429578,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.524297321304886,
		        "lng": 127.05018281937049,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.33386658021849,
		        "lng": 127.4461721466889,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.72963747546802,
		        "lng": 128.27079056365005,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.02726828142973,
		        "lng": 129.37257233594056,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.0708030360945,
		        "lng": 129.0593185494088,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.86835862950247,
		        "lng": 128.59755089175871,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 33.51133264696746,
		        "lng": 126.51852347452322,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.61284289586752,
		        "lng": 127.03120547238589,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.851696038722466,
		        "lng": 128.59092937125666,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.59084695083232,
		        "lng": 127.01872773588882,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.52114874288784,
		        "lng": 129.33573629945764,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.362326407439845,
		        "lng": 127.33577420148076,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.28941189110747,
		        "lng": 127.00446132665141,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.32049801117398,
		        "lng": 129.1810343576788,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.53338631541601,
		        "lng": 127.00615481678061,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.413461468258156,
		        "lng": 126.67735680840826,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.920390371093205,
		        "lng": 128.54411720249956,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.65489374054824,
		        "lng": 127.48374816871991,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.49491987110441,
		        "lng": 127.01493134206048,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.64985695608336,
		        "lng": 127.14496345268074,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.55686770317417,
		        "lng": 127.16927880543041,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.37014007589146,
		        "lng": 127.10614330185591,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.5350236507627,
		        "lng": 126.96157681184789,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.40549630594667,
		        "lng": 126.8980581820004,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 34.867950544005744,
		        "lng": 128.69069690081176,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.16317059543225,
		        "lng": 128.98452978748048,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.607484825953186,
		        "lng": 127.48520451195111,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.651724785213986,
		        "lng": 126.58306748337554,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.86059690063427,
		        "lng": 128.59193087665244,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.25685847585025,
		        "lng": 128.59912605060455,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 33.509258155694496,
		        "lng": 126.5109451464813,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.64366155701157,
		        "lng": 126.63255039247507,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.82667262227336,
		        "lng": 127.1030670574823,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.82003554991111,
		        "lng": 127.14810974062483,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.097485195649455,
		        "lng": 128.99486181862338,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.32204249590605,
		        "lng": 127.95591893585816,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.50535127272031,
		        "lng": 127.1047465440526,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.99081407156533,
		        "lng": 127.09338324956647,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.323486640444834,
		        "lng": 127.12285239871076,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.78973089440451,
		        "lng": 127.13644319545601,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.641373953578196,
		        "lng": 129.35463220719618,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.47423127310911,
		        "lng": 126.97625029161996,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.84357192991226,
		        "lng": 128.61143720719716,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.180974984085736,
		        "lng": 128.20294526341132,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.57895718642583,
		        "lng": 126.9316897337244,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 33.49077253755052,
		        "lng": 126.49314817000993,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.42175925330255,
		        "lng": 128.67409133225766,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.46405540570109,
		        "lng": 126.7153544119173,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.594758776232126,
		        "lng": 127.10099917489818,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.7239966558994,
		        "lng": 127.0478671731854,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.86680171505329,
		        "lng": 128.5923738376741,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.560573727266785,
		        "lng": 126.81239107485251,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.78692224857484,
		        "lng": 126.98966010341789,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.10368644802913,
		        "lng": 129.0206862606022,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.063839948992644,
		        "lng": 127.06856523030079,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.34344643728643,
		        "lng": 127.94382181350932,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.512521267219064,
		        "lng": 127.40054805648133,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.15286653837983,
		        "lng": 126.90419903971498,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.173238445546296,
		        "lng": 129.176082844468,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.082394201323524,
		        "lng": 129.40330471725923,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.51043665598106,
		        "lng": 127.03974070036524,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.627816673285054,
		        "lng": 127.44969866021904,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.59194624756919,
		        "lng": 127.01817545576053,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.387147045560866,
		        "lng": 127.1253365438929,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.89948383848115,
		        "lng": 128.60809550730653,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.555316235235324,
		        "lng": 127.14038447894715,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.09622092762977,
		        "lng": 128.43314679004078,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.582855922985544,
		        "lng": 126.91907857008522,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.516000983841586,
		        "lng": 128.72798872032757,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.48429363675198,
		        "lng": 127.0379630203579,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.54502575965604,
		        "lng": 126.95429338245707,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.236247173046394,
		        "lng": 128.8677618015292,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.40157536691968,
		        "lng": 127.11717457214067,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.95191038001258,
		        "lng": 127.91064040877527,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.491526492971346,
		        "lng": 126.85463749525812,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 36.124356479753196,
		        "lng": 128.09517052346138,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.15715169307048,
		        "lng": 128.15853461363773,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.5808156608605,
		        "lng": 126.95109705510639,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.46931787249714,
		        "lng": 126.89904775044873,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.52195614910054,
		        "lng": 129.3209904841746,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.58625703195563,
		        "lng": 126.9496035206742,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.28463639199199,
		        "lng": 126.85984474757359,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.534169458631226,
		        "lng": 129.31169021536095,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.553341234194285,
		        "lng": 127.15481222237025,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 37.62293367990081,
		        "lng": 126.83445005122417,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.5272027005698,
		        "lng": 127.72953798950101,
		        "imageUrl" : "/static/image/test.png"
		      },
		      {
		        "lat": 35.180032285898854,
		        "lng": 128.06954509175367,
		        "imageUrl" : "/static/image/test.png"
		      }
		    ];
		
		var imageSrc = '/static/image/test.png', // 마커이미지의 주소입니다    
		    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
		    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	      
		// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

		var markers = positions.map(function(position) { // 마커를 배열 단위로 묶음
			return new kakao.maps.Marker({
				map: map, // 마커를 표시할 지도,
				position : new kakao.maps.LatLng(position.lat, position.lng)
				, image : markerImage  // 마커 이미지 
			});
		});
		
		var clusterer = new kakao.maps.MarkerClusterer({
			map : map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
			averageCenter : true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
			minLevel : 5, // 클러스터 할 최소 지도 레벨 
			markers : markers
		});

		// 클러스터에 마커 추가
		clusterer.addMarkers(markers);
	</script>
</body>
</html>