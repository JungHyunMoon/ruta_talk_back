
function responsivePage() {
	var windowWidth = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;
	
    if (windowWidth > 1024) {
      //피시 메뉴
      $("header").removeClass("mo").addClass("pc");

    } else{
      //모바일
    $("header").removeClass("pc").addClass("mo");

    }
}


$(function () {
  responsivePage();
  $(window).resize(function () {
    if($("#cart1").outerWidth()>=$("#cart1").parent().outerWidth()){
      $("#cart1,#cart1 *,#cart2,#cart2 *").css({width:"100%"});
    }
    $("#cart1,#cart1 *,#cart2,#cart2 *").css({height:$("#cart1").outerWidth()+"px"});
    responsivePage();
  });

  $('.chart2').easyPieChart({
    barColor: '#00FF47',
      trackColor: '#2b2b4b',
      scaleColor: '#fff0',
      lineCap: 'round',
      lineWidth: 13,
      size: 120,
      animate: 1000,
      onStart: $.noop,
      onStop: $.noop
}); 

$(".dig").click(function(){
  if($(this).hasClass("on")){
    $(this).removeClass("on").addClass("off")
  }else{
    $(this).removeClass("off").addClass("on")
  }
});

$(window).load(function(){
  if($("main .box3 .left").width()<=500){
    $("#cart1,#cart1 *,#cart2,#cart2 *").css({
      width: $("main .box3 .left").width()+"px",
      height: $("main .box3 .left").width()+"px"
    })
  }

  if($("#cart1").outerWidth()>=$("#cart1").parent().outerWidth()){
    $("#cart1,#cart1 *,#cart2,#cart2 *").css({width:"100%"});
  }
  $("#cart1,#cart1 *,#cart2,#cart2 *").css({height:$("#cart1").outerWidth()+"px"});
});




});