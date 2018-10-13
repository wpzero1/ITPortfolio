<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@page import="marketing.marketingDTO"%>
<%@page import="marketingDAO.strategyDAO"%>
<%@page import="marketingDAO.marketingDAO2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Analysis Dashboard - Strategy</title>

<!-- ================= Favicon ================== -->
<!-- Standard -->
<link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
<!-- Retina iPad Touch Icon-->
<link rel="apple-touch-icon" sizes="144x144"
   href="http://placehold.it/144.png/000/fff">
<!-- Retina iPhone Touch Icon-->
<link rel="apple-touch-icon" sizes="114x114"
   href="http://placehold.it/114.png/000/fff">
<!-- Standard iPad Touch Icon-->
<link rel="apple-touch-icon" sizes="72x72"
   href="http://placehold.it/72.png/000/fff">
<!-- Standard iPhone Touch Icon-->
<link rel="apple-touch-icon" sizes="57x57"
   href="http://placehold.it/57.png/000/fff">

<!-- Styles -->
<link href="assets/css/lib/owl.theme.default.min.css" rel="stylesheet" />
<link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
<link href="assets/css/lib/themify-icons.css" rel="stylesheet">
<link href="assets/css/lib/menubar/sidebar.css" rel="stylesheet">
<link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">

<link href="assets/css/lib/helper.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/paneltab.css" rel="stylesheet">

<!-- am 파이차트 -->
<!-- Styles -->
<style>
#chartdiv {
   width: 100%;
   height: 500px;
}
</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/pie.js"></script>
<script
   src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet"
   href="https://www.amcharts.com/lib/3/plugins/export/export.css"
   type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>


<!-- am 파이차트 끝 -->


<!-- am 막대 꺾은선 -->
<style>
#chartdiv3 {
   width: 80%;
   height: 500px;
}
</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script
   src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet"
   href="https://www.amcharts.com/lib/3/plugins/export/export.css"
   type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<!-- Chart code -->
<script>
var chart = AmCharts.makeChart("chartdiv3", {
    "type": "serial",
    "theme": "light",
    "legend": {
        "equalWidths": false,
        "useGraphSettings": true,
        "valueAlign": "left",
        "valueWidth": 120
    },
    
    <%marketingDAO2 dao = new marketingDAO2();%>
    "dataProvider": [
       {"platform":""},
       {"platform": "facebook",
        "cost": <%=dao.total_face("Cost")%>,
        "click": <%=dao.total_face("Click")%>,
        "install": <%=dao.total_face("Install")%>,
        "retain": <%=dao.FileInput2()[0]%>},
        {"platform":""}, 
        {"platform": "google",
        "cost": <%=dao.total_google("Cost")%>,
        "click": <%=dao.total_google("Click")%>,
        "install": <%=dao.total_google("Install")%>,
        "retain":<%=dao.FileInput2()[1]%>},
        {"platform":""},
        {"platform": "naver",
        "cost": <%=dao.total_naver("Cost")%>,
        "click": <%=dao.total_naver("Click")%>,
        "install": <%=dao.total_naver("Install")%>,
        "retain":<%=dao.FileInput2()[2]%>},
        {"platform":""}
        ],
       "valueAxes": [{
        "id": "costAxis",
        "axisAlpha": 0,
        "gridAlpha": 0,
        "position": "left",
        "title": "cost"
    }, {
        "id": "installAxis",
        "axisAlpha": 0,
        "gridAlpha": 0,
        "labelsEnabled": false,
        "position": "right"
    }, {
        "id": "clickAxis",
        "click": "회",
        "axisAlpha": 0,
        "gridAlpha": 0,
        "inside": true,
        "position": "right",
        "title": "click"
    }],
    "graphs": [{
        "alphaField": "alpha",
        "balloonText": "[[value]] won",
        "dashLengthField": "dashLength",
        "fillAlphas": 0.7,
/*         "legendPeriodValueText": "total: [[value.sum]] won",
 */        "legendValueText": "[[value]] won",
        "title": "cost",
        "type": "column",
        "valueField": "cost",
        "valueAxis": "costAxis"
    }, {
        "balloonText": "click:[[value]]",
        "bullet": "round",
        "bulletBorderAlpha": 1,
        "useLineColorForBulletBorder": true,
        "bulletColor": "#FFFFFF",
        "bulletSizeField": "townSize",
        "dashLengthField": "dashLength",
        "labelPosition": "right",
        "labelText": "[[townName2]]",
        "legendValueText": "[[value]] 회",
        "title": "click",
        "fillAlphas": 0,
        "valueField": "click",
        "valueAxis": "clickAxis"
    }, {
        "bullet": "round",
        "bulletBorderAlpha": 1,
        "bulletBorderThickness": 1,
        "dashLengthField": "dashLength",
        "labelPosition": "right",
        "legendValueText": "[[value]] 회",
        "title": "install",
        "fillAlphas": 0,
        "valueField": "install",
        "valueAxis": "clickAxis"
    },
    {
        "bullet": "round",
        "bulletBorderAlpha": 1,
        "bulletBorderThickness": 1,
        "dashLengthField": "dashLength",
        "labelPosition": "right",
        "legendValueText": "[[value]] 회",
        "title": "retain",
        "fillAlphas": 0,
        "valueField": "retain",
    }],
    "chartCursor": {
        "categoryBalloonDateFormat": "DD",
        "cursorAlpha": 0.1,
        "cursorColor":"#000000",
         "fullWidth":false,
        "valueBalloonsEnabled": false,
        "zoomable": false
    },
   /*  "dataDateFormat": "YYYY-MM-DD", */
    "categoryField": "platform",
    "categoryAxis": {
       /* "dateFormats": [{
            "period": "DD",
            "format": "DD"
        }, {
            "period": "WW",
            "format": "MMM DD"
        }, {
            "period": "MM",
            "format": "MMM"
        }, {
            "period": "YYYY",
            "format": "YYYY"
        }],
        "parseDates": true,
        "autoGridCount": false, */
        "axisColor": "#555555",
        "gridAlpha": 0.1,
        "gridColor": "#FFFFFF",
        "gridCount": 50
    },
    "export": {
       "enabled": true
     }});
</script>


<!-- am 막대 꺾은선 끝 -->





</head>
<body>
   <!-- Side bar -->
   <div
      class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
      <div class="nano">
         <div class="nano-content">
            <ul>
               <li class="label">Main</li>
               <li><a href="index.html"><i class="ti-home"></i> 메인 페이지 </a></li>
               <li class="label">데이터 분석</li>
               <li><a class="sidebar-sub-toggle"><i
                     class="ti-bar-chart-alt"></i> 기존 데이터 분석 <span
                     class="sidebar-collapse-icon ti-angle-down"></span></a>
                  <ul>
                     <li><a href="dashboard2.jsp">분석 메인페이지</a></li>
                     <li><a href="#">유저 특성 그래프</a></li>
                     <li><a href="#">영향력 Top10</a></li>
                  </ul></li>
               <li><a class="sidebar-sub-toggle"><i class="ti-pie-chart"></i>
                     신규 데이터 분석<span class="sidebar-collapse-icon ti-angle-down"></span></a>
                  <ul>
                     <li><a href="dashboard-newdata.jsp">분석 메인페이지</a></li>
                     <li><a href="#">잔존율 분석</a></li>
                     <li><a href="#">광고지표 분석</a></li>
                  </ul></li>

               <li><a href="app-profile.html"><i class="ti-user"></i> 정보
                     열람</a></li>


               <li class="label">전략 컨설팅</li>
               <li><a class="sidebar-sub-toggle"><i class="ti-target"></i>
                     경영전략 페이지 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                  <ul>
                     <li><a href="dashboard-strategy.jsp">전략 메인페이지</a></li>
                     <li><a href="#">컨설팅</a></li>
                     <li><a href="#">마케팅 전략</a></li>
                  </ul>
               <li><a href="#"><i class="ti-email"></i> 이메일</a></li>
               <li><a><i class="ti-close"></i> 로그아웃</a></li>
            </ul>
         </div>
      </div>
   </div>

   <!-- /# sidebar -->
   <div class="header">
      <div class="container-fluid">
         <div class="row">
            <div class="col-lg-12">
               <div class="float-left">
                  <div class="hamburger sidebar-toggle">
                     <span class="line"></span> <span class="line"></span> <span
                        class="line"></span>
                  </div>
               </div>
               <div class="float-right">

                  <li class="header-icon dib"><span class="user-avatar">사용자
                        <i class="ti-angle-down f-s-10"></i>
                  </span>
                     <div class="drop-down dropdown-profile">
                        <div class="dropdown-content-heading">
                           <span class="text-left">환영합니다.</span>
                           <p class="trial-day">현재 등급 : VIP</p>
                        </div>
                        <div class="dropdown-content-body">
                           <ul>
                              <li><a href="#"><i class="ti-user"></i> <span>Profile</span></a></li>
                              <li><a href="#"><i class="ti-email"></i> <span>Inbox</span></a></li>
                              <li><a href="#"><i class="ti-settings"></i> <span>Setting</span></a></li>
                              <li><a href="#"><i class="ti-power-off"></i> <span>Logout</span></a></li>
                           </ul>
                        </div>
                     </div></li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </div>


	<div class="content-wrap">
		<div class="main">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-8 p-r-0 title-margin-right">
						<div class="page-header">
							<div class="page-title">
								<h3>
									<span>안녕하세요 경영전략 페이지입니다.</span>
								</h3>
							</div>
						</div>
					</div>
					<!-- /# column -->
					<div class="col-lg-4 p-l-0 title-margin-left">
						<div class="page-header">
							<div class="page-title">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
									<li class="breadcrumb-item active">Home</li>
								</ol>
							</div>
						</div>
					</div>
					<!-- /# column -->
				</div>
				<!-- /# row -->
				<%
               marketingDAO2 m = new marketingDAO2();
            %>




				<div class="mainbody">
					<h3 style="background-color: rgba(96, 208, 241, 0.7);"
						align="center">KPI</h3>
					<section id="main-content">
					<div class="row">
						<div class="col-lg-3">
							<div class="card">
								<div class="stat-widget-two">
									<div class="stat-content">
										<div class="stat-text">총 잔존률</div>
										<div class="stat-digit">5%</div>
										<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="card">
								<div class="stat-widget-two">
									<div class="stat-content">
										<div class="stat-text">신규 설치수</div>
										<div class="stat-digit">800</div>
										<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="card">
								<div class="stat-widget-two">
									<div class="stat-content">
										<div class="stat-text">총 CPI(단위 : 원)</div>
										<div class="stat-digit">1000</div>
										<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="card">
								<div class="stat-widget-two">
									<div class="stat-content">
										<div class="stat-text">마케팅예산</div>
										<div class="stat-digit">1,000,000 원</div>
										<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
									</div>
								</div>
							</div>
							<!-- /# card -->
						</div>
						<!-- /# column -->
					</div>
					<!-- /# row --> <!-- 설치, 잔존율, CPI 관련 차트 --> <!-- 설치, 잔존율, CPI 관련 차트 -->
					<div class="container" style="width: 100%" align="center">
						<div class="card">
							<div class="card-title">
								<h3>목표 달성률</h3>
							</div>
							<div class="progress-content">
								<div class="row">
									<div class="col-lg-4">
										<div class="progress-text">신규설치수</div>
									</div>
									<div class="col-lg-8">
										<div class="current-progressbar">
											<div class="progress">
												<div class="progress-bar bg-primary" style="width: 100%">1000,
													+25%</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="progress-content">
								<div class="row">
									<div class="col-lg-4">
										<div class="progress-text">총 잔존률</div>
									</div>
									<div class="col-lg-8">
										<div class="current-progressbar">
											<div class="progress">
												<div class="progress-bar bg-danger" style="width: 24%">1.2%,
													12.3%</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="progress-content">
								<div class="row">
									<div class="col-lg-4">
										<div class="progress-text">총 CPI</div>
									</div>
									<div class="col-lg-8">
										<div class="current-progressbar">
											<div class="progress">
												<div class="progress-bar bg-danger" style="width: 12.3%">8109,
													12.3%</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="container">
					<div class="card">
						<div class="card-title"></div>
						<div class="cardbody">
						<h5 class="card-title" align="center">잔존유저 유입경로 세부사항</h5>
						<div id="chartdiv"></div>
						<!-- Chart code -->
						<script>
   var chart;
   var legend;
   var selected;
<%strategyDAO stg = new strategyDAO();%>

   var types = [
<%=stg.FileInput()%>
   ];

   function generateChartData() {
      var chartData = [];
      for (var i = 0; i < types.length; i++) {
         if (i == selected) {
            for (var x = 0; x < types[i].subs.length; x++) {
               chartData.push({
                  type : types[i].subs[x].type,
                  percent : types[i].subs[x].percent,
                  color : types[i].color,
                  pulled : true
               });
            }
         } else {
            chartData.push({
               type : types[i].type,
               percent : types[i].percent,
               color : types[i].color,
               id : i
            });
         }
      }
      return chartData;
   }

   AmCharts.makeChart("chartdiv", {
      "type" : "pie",
      "theme" : "light",

      "dataProvider" : generateChartData(),
      "labelText" : "[[title]]: [[value]]",
      "balloonText" : "[[title]]: [[value]]",
      "titleField" : "type",
      "valueField" : "percent",
      "outlineColor" : "#FFFFFF",
      "outlineAlpha" : 0.8,
      "outlineThickness" : 2,
      "colorField" : "color",
      "pulledField" : "pulled",
      "titles" : [ {
         "text" : "클릭하면 자세한 광고 내용을 확인할 수 있습니다."
      } ],
      "listeners" : [ {
         "event" : "clickSlice",
         "method" : function(event) {
            var chart = event.chart;
            if (event.dataItem.dataContext.id != undefined) {
               selected = event.dataItem.dataContext.id;
            } else {
               selected = undefined;
            }
            chart.dataProvider = generateChartData();
            chart.validateData();
         }
      } ],
      "export" : {
         "enabled" : true
      }
   });
</script>

					</div>
				</div>
				</div>
				</div>
				

	<div class="container">
               <div class="card">
                  <div class="card-title">채널별 Funnel 분석 결과</div>
                  <div id="chartdiv3"></div>
               </div>
            </div>

   <div class="row">
      <div class="col-lg-8">
         <div class="footer">
            <p>
               2018 © Admin Board. <a href="#"></a>
            </p>
         </div>
      </div>
   </div>
   </section>
   </div>
   </div>

   <!-- jquery vendor -->
   <script src="assets/js/lib/jquery.min.js"></script>
   <script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
   <!-- nano scroller -->
   <script src="assets/js/lib/menubar/sidebar.js"></script>
   <script src="assets/js/lib/preloader/pace.min.js"></script>
   <!-- sidebar -->
   <script src="assets/js/lib/bootstrap.min.js"></script>
   <script src="assets/js/scripts.js"></script>

</body>
</html>\