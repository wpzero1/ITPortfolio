<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@page import="FileIO.fileio"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Analysis Dashboard</title>

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

<!-- Chart -->
<!-- Styles -->
<style>


#chartdiv1 {
   width: 100%;
   height: 500px;
   font-size: 11px;
}

#chartdiv2 {
   width: 100%;
   height: 500px;
   font-size: 11px;
}

#chartdiv3 {
   width: 100%;
   height: 500px;
   font-size: 11px;
}

#chartdiv4 {
   width: 100%;
   height: 500px;
   font-size: 11px;
}
</style>


<!-- Chart -->
<!-- Resources -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
 
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script
   src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet"
   href="https://www.amcharts.com/lib/3/plugins/export/export.css"
   type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

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
               <li><a class="sidebar-sub-toggle"><i class="ti-file"></i>
                     신규 데이터 분석<span class="sidebar-collapse-icon ti-angle-down"></span></a>
                  <ul>
                     <li><a href="dashboard-newdata.jsp">분석 메인페이지</a></li>
                     <li><a href="#">잔존율 분석</a></li>
                     <li><a href="#">광고지표 분석</a></li>
                  </ul></li>

               <li><a href="app-profile.html"><i class="ti-user"></i> 정보 열람</a></li>


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
                            <span>안녕하세요  기존 데이터 분석 페이지 입니다.</span>
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




                 <div class="container">
               <h4>기존 데이터 이탈율 분석</h4>
            </div>

            <div id="exTab2" class="container">
               <ul class="nav nav-tabs">
                  <li class="active"><a href="#1" data-toggle="tab">Week</a></li>
                  <li><a href="#2" data-toggle="tab">Month</a></li>
                  <li><a href="#3" data-toggle="tab">2Month</a></li>
                  <li><a href="#4" data-toggle="tab">Retained</a></li>
               </ul>

               <div class="tab-content ">
                  <div class="tab-pane active" id="1">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="card">
                              <div class="cardbody">
                                 <h4 class="card-title">Week : 1주 후에 이탈한 유저에 대한 분석</h4>

                                 <%
                                    fileio f = new fileio();
                                 %>
                                 <!-- Chart code -->
                                 <div id="chartdiv1"></div>
                                 <script>
                                    var chart = AmCharts
                                          .makeChart(
                                                "chartdiv1",
                                                {
                                                   "type" : "serial",
                                                   "theme" : "light",
                                                   "dataProvider" : [
                                 <%=f.FileInput("week.csv")%>
                                    ],
                                                   "valueAxes" : [ {
                                                      "gridColor" : "#FFFFFF",
                                                       "axisAlpha": 0,
                                                      "gridAlpha" : 0.2,
                                                      "dashLength" : 0
                                                   } ],
                                                   "gridAboveGraphs" : true,
                                                   "startDuration" : 0.5,
                                                   "graphs" : [ {
                                                      "balloonText" : "[[category]]: <b>[[value]]</b>",
                                                      "fillAlphas" : 0.8,
                                                      "lineAlpha" : 0.2,
                                                      "type" : "column",
                                                      "fillColorsField": "color",
                                                      "valueField" : "visits"
                                                   } ],
                                                   "chartCursor" : {
                                                      "categoryBalloonEnabled" : false,
                                                      "cursorAlpha" : 0,
                                                      "zoomable" : false
                                                   },
                                                   "categoryField" : "country",
                                                   "categoryAxis" : {
                                                      "gridPosition" : "start",
                                                      "gridAlpha" : 0,
                                                      "tickPosition" : "start",
                                                      "tickLength" : 20,
                                                      "labelRotation" : 45
                                                   },
                                                   "export" : {
                                                      "enabled" : true
                                                   }

                                                }, 0);
                                 </script>

                              </div>
                           </div>
                        </div>
                     </div>


                     <div class="row">
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 높은 요인 Top10</h4>
									
									<table class="table">
												<tr>
													<th>순위</th>
													<th>변수명</th>
													<th>변수중요도</th>
												</tr>
												<tr>
													<td>1</td>
													<td>해당 주에 한번 이상 접속한 일수</td>
													<td>33</td>
												</tr>
												<tr>
													<td>2</td>
													<td>퀘스트 홍문 경험치</td>
													<td>30</td>
												</tr>
												<tr>
													<td>3</td>
													<td>아이템 홍문 경험치</td>
													<td>28</td>
												</tr>
												<tr>
													<td>4</td>
													<td>귓속말 채팅 횟수</td>
													<td>27</td>
												</tr>
												<tr>
													<td>5</td>
													<td>문파 채팅 횟수</td>
													<td>26</td>
												</tr>
												<tr>
													<td>6</td>
													<td>재화 획득량</td>
													<td>23</td>
												</tr>
												<tr>
													<td>7</td>
													<td>플레이 시간</td>
													<td>22.6</td>
												</tr>
												<tr>
													<td>8</td>
													<td>버프아이템 사용 횟수</td>
													<td>22.3</td>
												</tr>
												<tr>
													<td>9</td>
													<td>퀘스트 일반 경험치</td>
													<td>21.6</td>
												</tr>
												<tr>
													<td>10</td>
													<td>전투 시간</td>
													<td>21.2</td>
												</tr>
											</table>
											
                              </div>
                           </div>
                        </div>
                        <!-- /# column -->
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 없는 요인 Top10</h4>

								<table class="table">
												<tr>
													<th>순위</th>
													<th>변수명</th>
													<th>변수중요도</th>
												</tr>
												<tr>
													<td>1</td>
													<td>솔로 인던 입장 횟수</td>
													<td>10.8</td>
												</tr>
												<tr>
													<td>2</td>
													<td>라이트 인던 입장 횟수</td>
													<td>11</td>
												</tr>
												<tr>
													<td>3</td>
													<td>솔로인던 완료 횟수</td>
													<td>11.4</td>
												</tr>
												<tr>
													<td>4</td>
													<td>귓속말 채팅 횟수</td>
													<td>27</td>
												</tr>
												<tr>
													<td>5</td>
													<td>라이트/숙련 인던 입장횟수</td>
													<td>12.6</td>
												</tr>
												<tr>
													<td>6</td>
													<td>라이트/숙련 인던 완료횟수</td>
													<td>12.7</td>
												</tr>
												<tr>
													<td>7</td>
													<td>일반채팅 횟수</td>
													<td>13.7</td>
												</tr>
												<tr>
													<td>8</td>
													<td>제작 횟수</td>
													<td>15.3</td>
												</tr>
												<tr>
													<td>9</td>
													<td>NPC 사냥 일반 경험치</td>
													<td>15.4</td>
												</tr>
												<tr>
													<td>10</td>
													<td>NPC 사냥 홍문 경험치</td>
													<td>17.4</td>
												</tr>
											</table>
											
                              </div>
                           </div>
                        </div>
                     </div>
                     
                     <!-- 여기까지 -->

                  </div>


                  <div class="tab-pane" id="2">

                     <div class="row">
                        <div class="col-lg-12">
                           <div class="card">
                              <div class="cardbody">
                                 <h4 class="card-title">Month : 1달 후에 이탈한 유저에 대한 분석</h4>


                                 <!-- Chart code -->
                                 <div id="chartdiv2"></div>
                                 <script>
                                    var chart = AmCharts
                                          .makeChart(
                                                "chartdiv2",
                                                {
                                                   "type" : "serial",
                                                   "theme" : "light",
                                                   "dataProvider" : [
                                 <%=f.FileInput("month.csv")%>
                                    ],
                                                   "valueAxes" : [ {
                                                      "gridColor" : "#FFFFFF",
                                                      "gridAlpha" : 0.2,
                                                      "dashLength" : 0
                                                   } ],
                                                   "gridAboveGraphs" : true,
                                                   "startDuration" : 0.5,
                                                   "graphs" : [ {
                                                      "balloonText" : "[[category]]: <b>[[value]]</b>",
                                                      "fillAlphas" : 0.8,
                                                      "lineAlpha" : 0.2,
                                                      "type" : "column",
                                                      "fillColorsField": "color",
                                                      "valueField" : "visits"
                                                   } ],
                                                   "chartCursor" : {
                                                      "categoryBalloonEnabled" : false,
                                                      "cursorAlpha" : 0,
                                                      "zoomable" : false
                                                   },
                                                   "categoryField" : "country",
                                                   "categoryAxis" : {
                                                      "gridPosition" : "start",
                                                      "gridAlpha" : 0,
                                                      "tickPosition" : "start",
                                                      "tickLength" : 20,
                                                      "labelRotation" : 45
                                                   },
                                                   "export" : {
                                                      "enabled" : true
                                                   }

                                                }, 0);
                                 </script>

                              </div>
                           </div>
                        </div>
                     </div>


                     <div class="row">
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 높은 요인 Top10</h4>

											
							  </div>
                           </div>
                        </div>
                        <!-- /# column -->
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 없는 요인 Top10</h4>


                              </div>
                           </div>
                        </div>
                     </div>


                  </div>

                  <div class="tab-pane" id="3">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="card">
                              <div class="cardbody">
                                 <h4 class="card-title">2Month : 2달 후에 이탈한 유저에 대한 분석</h4>


                                 <!-- Chart code -->
                                 <div id="chartdiv3"></div>
                                 <script>
                                    var chart = AmCharts
                                          .makeChart(
                                                "chartdiv3",
                                                {
                                                   "type" : "serial",
                                                   "theme" : "light",
                                                   "dataProvider" : [
                                 <%=f.FileInput("2month.csv")%>
                                    ],
                                                   "valueAxes" : [ {
                                                      "gridColor" : "#FFFFFF",
                                                      "gridAlpha" : 0.2,
                                                      "dashLength" : 0
                                                   } ],
                                                   "gridAboveGraphs" : true,
                                                   "startDuration" : 0.5,
                                                   "graphs" : [ {
                                                      "balloonText" : "[[category]]: <b>[[value]]</b>",
                                                      "fillAlphas" : 0.8,
                                                      "lineAlpha" : 0.2,
                                                      "type" : "column",
                                                      "fillColorsField": "color",
                                                      "valueField" : "visits"
                                                   } ],
                                                   "chartCursor" : {
                                                      "categoryBalloonEnabled" : false,
                                                      "cursorAlpha" : 0,
                                                      "zoomable" : false
                                                   },
                                                   "categoryField" : "country",
                                                   "categoryAxis" : {
                                                      "gridPosition" : "start",
                                                      "gridAlpha" : 0,
                                                      "tickPosition" : "start",
                                                      "tickLength" : 20,
                                                      "labelRotation" : 45
                                                   },
                                                   "export" : {
                                                      "enabled" : true
                                                   }

                                                }, 0);
                                 </script>

                              </div>
                           </div>
                        </div>
                     </div>


                     <div class="row">
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 높은 요인 Top10</h4>
                                 <h4>여기다가 넣으면 될듯</h4>

                              </div>
                           </div>
                        </div>
                        <!-- /# column -->
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 없는 요인 Top10</h4>


                              </div>
                           </div>
                        </div>
                     </div>
                  </div>


                  <div class="tab-pane" id="4">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="card">
                              <div class="cardbody">
                                 <h4 class="card-title">Retained : 이탈하지 않고 잔존한 유저에 대한 분석</h4>


                                 <!-- Chart code -->
                                 <div id="chartdiv4"></div>
                                 <script>
                                    var chart = AmCharts
                                          .makeChart(
                                                "chartdiv4",
                                                {
                                                   "type" : "serial",
                                                   "theme" : "light",
                                                   "dataProvider" : [
                                 <%=f.FileInput("retained.csv")%>
                                    ],
                                                   "valueAxes" : [ {
                                                      "gridColor" : "#FFFFFF",
                                                      "gridAlpha" : 0.2,
                                                      "dashLength" : 0
                                                   } ],
                                                   "gridAboveGraphs" : true,
                                                   "startDuration" : 0.5,
                                                   "graphs" : [ {
                                                      "balloonText" : "[[category]]: <b>[[value]]</b>",
                                                      "fillAlphas" : 0.8,
                                                      "lineAlpha" : 0.2,
                                                      "type" : "column",
                                                      "fillColorsField": "color",
                                                      "valueField" : "visits"
                                                   } ],
                                                   "chartCursor" : {
                                                      "categoryBalloonEnabled" : false,
                                                      "cursorAlpha" : 0,
                                                      "zoomable" : false
                                                   },
                                                   "categoryField" : "country",
                                                   "categoryAxis" : {
                                                      "gridPosition" : "start",
                                                      "gridAlpha" : 0,
                                                      "tickPosition" : "start",
                                                      "tickLength" : 20,
                                                      "labelRotation" : 45
                                                   },
                                                   "export" : {
                                                      "enabled" : true
                                                   }

                                                }, 0);
                                 </script>

                              </div>
                           </div>
                        </div>
                     </div>


                     <div class="row">
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">변수 영향력</h4>
                                 <div id="table_div"></div>
                                 <script type="text/javascript">
                                    google.charts.load('current', {
                                       'packages' : [ 'table' ]
                                    });
                                    google.charts
                                          .setOnLoadCallback(drawTable);

                                    function drawTable() {
                                       var data = new google.visualization.DataTable();
                                       data.addColumn('string',
                                             '변수');
                                       data.addColumn('number',
                                             '변수 중요도');
                                       data
                                             .addColumn(
                                                   'boolean',
                                                   'Full Time Employee');
                                       data.addRows([
                                              ['Mike',  {v: 10000, f: '$10,000'},true],
          ['Jim',   {v:8000,   f: '$8,000'},true],
          ['Alice', {v: 12500, f: '$12,500'},true],
          ['Bob',   {v: 7000,  f: '$7,000'},true]
                                            ]);

                                       var table = new google.visualization.Table(
                                             document
                                                   .getElementById('table_div'));

                                       table.draw(data, {
                                          showRowNumber : true,
                                          width : '100%',
                                          height : '100%'
                                       });
                                    }
                                 </script>

                              </div>
                           </div>
                        </div>
                        <!-- /# column -->
                        <div class="col-lg-6">
                           <div class="card">
                              <div class="card-body">
                                 <h4 class="card-title">가장 영향력이 없는 요인 Top10</h4>


                              </div>
                           </div>
                        </div>
                     </div>
                     
                     
                     

                  </div>

               </div>
            </div>


            <hr>
            <div class="row">
               <div class="col-lg-6">
                  <div class="card">
                     <div class="card-body">
                        <h4>최근 중요 업데이트 사항</h4>
                        <h6>길드 시스템 개편(18.08.17)</h6>
                        <br>
                        <h4>지난 중요 업데이트 사항</h4>
                        <h6>경험치 시스템 개편(18.06.27)</h6>

                     </div>
                  </div>
               </div>
               <!-- /# column -->
               <div class="col-lg-6">
                  <div class="card">
                     <div class="card-body">
                        <h4 class="card-title">크롤링 결과</h4>
							<center><button onclick="window.open('NewFile2.html','window_name','width=550,height=550,location=no,status=no');">결과보기</button></center>
                     </div>
                  </div>
               </div>
            </div>

<div class="col-lg-12">

    <script src="https://d3js.org/d3.v3.min.js"></script>
    <script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js" type="text/JavaScript"></script>
    <script>
        var width = 200,
            height = 300

        var svg = d3.select("body").append("svg")
            .attr("width", width)
            .attr("height", height);
        d3.csv("11.csv", function (data) {
            showCloud(data)
            setInterval(function(){
                 showCloud(data)
            },5000) 
        });
        //scale.linear: 선형적인 스케일로 표준화를 시킨다. 
        //domain: 데이터의 범위, 입력 크기
        //range: 표시할 범위, 출력 크기 
        //clamp: domain의 범위를 넘어간 값에 대하여 domain의 최대값으로 고정시킨다.
        wordScale = d3.scale.linear().domain([0, 100]).range([0, 150]).clamp(true);
        var keywords = ["권사", "역사", "투사","기공사","주술사","소환사"]
        var svg = d3.select("svg")
                    .append("g")
                    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")")

        function showCloud(data) {
            d3.layout.cloud().size([width, height])
                //클라우드 레이아웃에 데이터 전달
                .words(data)
                .rotate(function (d) {
                    return d.text.length > 3 ? 0 : 90;
                })
                //스케일로 각 단어의 크기를 설정
                .fontSize(function (d) {
                    return wordScale(d.frequency);
                })
                //클라우드 레이아웃을 초기화 > end이벤트 발생 > 연결된 함수 작동  
                .on("end", draw)
                .start();

            function draw(words) { 
                var cloud = svg.selectAll("text").data(words)
                //Entering words
                cloud.enter()
                    .append("text")
                    .style("font-family", "overwatch")
                    .style("fill", function (d) {
                        return (keywords.indexOf(d.text) > -1 ? "#fbc280" : "#405275");
                    })
                    .style("fill-opacity", .5)
                    .attr("text-anchor", "middle") 
                    .attr('font-size', 1)
                    .text(function (d) {
                        return d.text;
                    }); 
                cloud
                    .transition()
                    .duration(600)
                    .style("font-size", function (d) {
                        return d.size + "px";
                    })
                    .attr("transform", function (d) {
                        return "translate(" + [d.x, d.y] + ")";
                    })
                    .style("fill-opacity", 1); 
            }
        }
        
    </script>
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

</html>