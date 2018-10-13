<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@page import="FileIO.fileio"%>
<%@page import="marketing.marketingDTO"%>
<%@page import="marketingDAO.marketingDAO"%>
<%@page import="rjava.rjava_con" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Analysis Dashboard - New Data</title>

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

	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    
<!-- 구글 컬럼 여러개 -->
<script type="text/javascript"
   src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        <%marketingDAO dao = new marketingDAO();%>
        var data = google.visualization.arrayToDataTable([
         <%=dao.marketing_chart()[0]%>
      ]);

    var options = {
      title : '각 매체별 CPC 데이터',
      vAxis: {title: 'Cost', format: 'decimal'},
      hAxis: {title: 'Platform'},
      seriesType: 'bars',
      series: {3: {type: 'line'}}
    };

    var chart = new google.charts.Bar(document.getElementById('chart_div1'));
    chart.draw(data, google.charts.Bar.convertOptions(options));
  }
    </script>

<script type="text/javascript">
		google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          <%=dao.marketing_chart()[1]%>
      ]);

    var options = {
    		title : '각 매체별 CPI 데이터',
    		vAxis: {title: 'Cost', format: 'decimal'},
    	      hAxis: {title: 'Platform'},
    	      seriesType: 'bars',
    	      series: {3: {type: 'line'}}
    	    };

    var chart = new google.charts.Bar(document.getElementById('chart_div2'));
    chart.draw(data, google.charts.Bar.convertOptions(options));
  }
    </script>

<script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
            <%=dao.marketing_chart()[2]%>
      ]);

    var options = {
      title : '각 매체별 CPM 데이터',
      vAxis: {title: 'Cost', format: 'decimal'},
      hAxis: {title: 'Platform'},
      seriesType: 'bars',
      series: {3: {type: 'line'}}
    };

    var chart = new google.charts.Bar(document.getElementById('chart_div3'));
    chart.draw(data, google.charts.Bar.convertOptions(options));
  }
    </script>
<!-- 구글 파이차트 -->

<script type="text/javascript"	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
           <%fileio i = new fileio();%>
<%--       		<%rjava_con con = new rjava_con(); con.returnRImg();%> --%>
           <%=i.FileInput_google("NewFile_clustering.csv")%>
        ]);

        var options = {
//           title: '유저 이탈율 분포',
          is3D: true,
          chartArea:{left:10, top:20, width:"100%", height:"100%"}
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      
      //tooltip 관련 js
      
      $(document).ready(function(){
    	    $('[data-toggle="tooltip"]').tooltip(); 
    	});
      
    </script>
<!-- 구글 파이차트 끝 -->



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
                           <span>안녕하세요 신규데이터 분석 페이지입니다.</span>
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
         marketingDAO m = new marketingDAO();
      %>
            
            
            <div class="mainbody">
               <section id="main-content">
               <div class="row">
                  <div class="col-lg-3">
                     <div class="card">
                        <div class="stat-widget-two">
                           <div class="stat-content">
                              <div class="stat-text">총 마케팅 비용</div>
                              <div class="stat-digit">
                                 <i class="fa fa-krw"></i><%=m.Value()[0] %>
                              </div>
<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-3">
                     <div class="card">
                        <div class="stat-widget-two">
                           <div class="stat-content">
                              <div class="stat-text">당기 CPC</div>
                              <div class="stat-digit">
                                 <i class="fa fa-krw"></i><%=m.Value()[1] %>
                              </div>
<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-3">
                     <div class="card">
                        <div class="stat-widget-two">
                           <div class="stat-content">
                              <div class="stat-text">당기 CPI</div>
                              <div class="stat-digit">
                                 <i class="fa fa-krw"></i> <%=m.Value()[2] %>
                              </div>
<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-3">
                     <div class="card">
                        <div class="stat-widget-two">
                           <div class="stat-content">
                              <div class="stat-text">당기 CPM</div>
                              <div class="stat-digit">
                                 <i class="fa fa-krw"></i><%=m.Value()[3] %>
                              </div>
<!--                               <font size=-2>KPI를 입력하면 현재 진행상황을 알 수 있습니다.</font> -->
                           </div>
                        </div>
                     </div>
                     <!-- /# card -->
                  </div>
                  <!-- /# column -->
               </div>
               <!-- /# row -->

					<div class="row">
						<div class="col-lg-6">
							<div class="card">
								<!-- 원형 차트 들어가는 부분 -->
								<center>
									<h4>신규 데이터 유저 이탈율 분포 그래프</h4>
								</center>
								<div id="piechart_3d" style="width: 100%; height: 100%;"
									align="center"></div>
							</div>
						</div>

						<div class="col-lg-6">
							<div class="card" style="width: 100%; height: 94%;"
								align="center">
								<div class="card-title">
									<h4>클릭당 인스톨, 잔존율</h4>
								</div>
								<div class="current-progress">
									<div class="progress-content">
										<div class="row">
											<div class="col-lg-4">
												<div class="progress-text">Click</div>
											</div>
											<div class="col-lg-8">
												<div class="current-progressbar">
													<div class="progress">
														<div class="progress-bar progress-bar-primary w-100"
															role="progressbar" aria-valuenow="100" aria-valuemin="0"
															aria-valuemax="100">100%</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

									<div class="progress-content">
										<div class="row">
											<div class="col-lg-4">
												<div class="progress-text">Install</div>
											</div>
											<div class="col-lg-8">
												<div class="current-progressbar">
													<div class="progress">
														<div class="progress-bar progress-bar-primary w-30"
															role="progressbar" aria-valuenow="30" aria-valuemin="0"
															aria-valuemax="100">22%</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="progress-content">
										<div class="row">
											<div class="col-lg-4">
												<div class="progress-text">Retained</div>
											</div>
											<div class="col-lg-8">
												<div class="current-progressbar">
													<div class="progress">
														<div class="progress-bar progress-bar-primary w-10"
															role="progressbar" aria-valuenow="10" aria-valuemin="0"
															aria-valuemax="100">1.2%</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="progress-content">
										<div class="row">
											<div class="col-lg-4">
												<div class="progress-text">잔존 비중</div>
											</div>
											<div class="col-lg-8">
												<div class="current-progressbar">
													<div class="progress">
														<div class="progress-bar progress-bar-primary w-60"
															role="progressbar" aria-valuenow="55" aria-valuemin="0"
															aria-valuemax="100" data-toggle="tooltip"
															data-placement="bottom" title="Paid 유입 유저">53%</div>
														<div class="progress-bar bg-warning" style="width: 45%"
															data-toggle="tooltip" data-placement="bottom"
															title="Organic 유입 유저">47%</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>



					<div class="row">
						<div class="col-lg-4">
							<div class="card" style="width: 100%; height: 100%;">
								  <div id="chart_div1" >

								</div>
							</div>
						</div>

						<div class="col-lg-4">
							<div class="card" style="width: 100%; height: 100%; align:center;">
								<div id="chart_div2" >

								</div>
							</div>
						</div>
	
						<div class="col-lg-4">
							<div class="card" style="width: 100%; height: 100%;">
								<div id="chart_div3">

								</div>
							</div>
						</div>
					</div>
				</div>
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
      

   <!-- jquery vendor -->
   <script src="assets/js/lib/jquery.min.js"></script>
   <script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
   <!-- nano scroller -->
   <script src="assets/js/lib/menubar/sidebar.js"></script>
   <script src="assets/js/lib/preloader/pace.min.js"></script>
   <!-- sidebar -->
   <script src="assets/js/lib/bootstrap.min.js"></script>
   <script src="assets/js/scripts.js"></script>
   <!-- scripit init-->

</body>
</html>