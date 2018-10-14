<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.module.sitemesh.tapestry.Title"%>
<%@page import="com.sun.xml.txw2.Document"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String Title = "";
Title = request.getHeader(Title);
String referer = request.getHeader("Referer");
if(referer==null) referer="";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<head>
	<title> <decorator:title default="拆迁管理系统"/></title>
	<meta http-equiv="X-UA-Compatible" content="IE=9" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta charset="utf-8" />
	<meta http-equiv="Cache-Control" content="no-transform" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	
  	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<link rel="shortcut icon" href="<%=path%>/images/favicon.ico" />

  	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="<%=path%>/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="<%=path%>/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/css/common.css" rel="stylesheet" type="text/css"/>
	
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="<%=path%>/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="<%=path%>/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="<%=path%>/media/css/bootstrap-toggle-buttons.css"  rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL STYLES -->
	
	<link href="<%=path%>/css/gritter.css" rel="stylesheet" type="text/css"/>
	<!--[if IE 7]>
	<script src="<%=path%>/js/IESupport/IE7.js"></script>
	<![endif]-->
	<!--[if IE 8]>
	<script src="<%=path%>/js/IESupport/IE8.js"></script>
	<![endif]-->
	<!--[if IE 9]>
	<script src="<%=path%>/js/IESupport/IE9.js"></script>
	<![endif]-->
	<!--[if lt IE 9]>
	<script src="<%=path%>/js/IESupport/base.js"></script>
	<script src="<%=path%>/js/IESupport/respond.min.js"></script>
	<![endif]-->
	
	<!-- BEGIN CORE PLUGINS -->
	<script src="<%=path%>/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="<%=path%>/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="<%=path%>/media/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="<%=path%>/media/js/excanvas.min.js"></script>
	<script src="<%=path%>/media/js/respond.min.js"></script>  
	<![endif]-->   
	<script src="<%=path%>/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="<%=path%>/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<script src="<%=path%>/media/js/jquery.toggle.buttons.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->

	<script src="<%=path%>/js/lhq_form_validate.js"></script>
	<script src="<%=path%>/js/highlight.js"></script>
	<script src="<%=path%>/js/bootbox.js"></script>
	<script src="<%=path%>/js/common.js"></script>
	
	<script src="<%=path%>/js/qrcode/jquery.qrcode.min.js"></script>
	<script src="<%=path%>/js/ajaxfileupload.js"></script>
	<link rel="stylesheet" type="text/css" href="media/css/datepicker.css" />
	<script src="media/js/bootstrap-datepicker.js"></script>
	<decorator:head />
	<script>
	/* var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?b6afac8e0c43b9cbd6a6b1efe0631ed3";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})(); */
	</script>
	<style>
	@media (max-width: 768px) {
		.welcome-title{
			font-size:14px;
		}
		.page-title{
			font-size:18px;
		}
	}
	
	.header .navbar-inner, .footer{
		background-color: #069B51 !important;
	}
	@media (min-width: 768px) {
		ul.page-sidebar-menu > li > ul.sub-menu > li{
			margin: 10px 20px;
			height: 50px;
			line-height: 50px;
			border: 1px solid;
			text-align: center;
			box-shadow: 0 0 20px rgba(100,100,100,.8);
		}
		ul.page-sidebar-menu > li > ul.sub-menu > li > a{
			padding-left: 0;
			padding-left: 0 !important;
		}
	}
	</style>
</head>
<body class="page-header-fixed">

	<div class="header navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<input type="hidden" name="referer" value="<%=referer %>"/>
				<!-- BEGIN LOGO -->
				<a class="brand" href="./" target="_blank" style="padding-top:0">
				<img src="images/logo.png" a:lt="logo" />
				</a>
				<div class="pending" style="float:right;padding-top: 10px;color: white;"><a href="/Relocation/ListRecord?ps=10&p=1&pendingState=1">待处理10条</a></div>
				<!-- END LOGO -->
				<ul class="nav pull-right">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="media/image/avatar1_small.jpg">
						<span class="username">${cuser.nickname }</span>
						<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="./Admin?page=profile"><i class="icon-user"></i> 用户资料</a></li>
							<li><a href="./Admin?page=pwd"><i class="icon-lock"></i> 修改密码</a></li>
							<li><a href="./Logout"><i class="icon-key"></i> 安全退出</a></li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="media/image/menu-toggler.png" alt="" />
				</a>
				<!-- END RESPONSIVE MENU TOGGLER -->
			</div>
		</div>
	</div>
	
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<jsp:include page="/WEB-INF/sitemesh-decorators/menu.jsp" />
		</div>
		<!-- END SIDEBAR -->
		
		<div class="page-content">
			<decorator:body/>
		</div>
	</div>

	<div class="footer">
		<div class="footer-inner">
			2016 &copy; 贵州网众信息科技有限公司版权所有.
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>
	
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="<%=path%>/media/js/jquery.vmap.js" type="text/javascript"></script>   
	<script src="<%=path%>/media/js/jquery.vmap.russia.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.europe.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.germany.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.usa.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  
	<script src="<%=path%>/media/js/jquery.flot.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.flot.resize.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.pulsate.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/date.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/daterangepicker.js" type="text/javascript"></script>     
	<script src="<%=path%>/media/js/jquery.gritter.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/fullcalendar.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery.sparkline.min.js" type="text/javascript"></script>  
	<script src="<%=path%>/media/js/dateutil.js" type="text/javascript"></script>  
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=path%>/media/js/app.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/index.js" type="text/javascript"></script>        
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script>
	jQuery(document).ready(function() {    
		App.init(); // initlayout and core plugins
		
		var sidebar = getCookie('sidebar-closed');
		if(sidebar!=null&&sidebar=='yes'){
			$('body').addClass('page-sidebar-closed');
		}else{
			$('body').removeClass('page-sidebar-closed');
		}
		
		$(window).bind('beforeunload',function(){
			if($('body.page-sidebar-closed').length==1){
				setCookie('sidebar-closed','yes',24*30*60); //24*30个小时后失效
			}else{
				delCookie('sidebar-closed');
			}
		});
		
		if('${error}'!=''){
			shakeMsg('${error}');
		}
		
		if (!jQuery().toggleButtons) {
        }else{
	        $('.start-toggle-button').toggleButtons({
	            width: 70,
	            style: {
	                enabled: "info",
	                disabled: ""
	            },
	            label: {
	                enabled: "未交",
	                disabled: "已交"
	            }
	        });
	        $('.end-toggle-button').toggleButtons({
	            width: 70,
	            style: {
	                enabled: "success",
	                disabled: ""
	            },
	            label: {
	                enabled: "未还",
	                disabled: "已还"
	            }
	        });
        }
		$.post("pendingRecordCount", function(resp) {
			   var str = "";
				if(!resp || resp == ''){
					
				}else{
					 str = "待处理：" + resp + "条";
				}
			$(".pending a").text(str);
		});
	});
	</script>
	<!-- END JAVASCRIPTS -->
	
	<!--[if lt IE 10]>
	<script>
	function placeholder(nodes,pcolor) {
		nodes.each(function(){
			var str = $(this).attr('placeholder');
			var color = $(this).css('color');
			var type = $(this).attr('type');
			$(this).focus(function(){
				if($(this).val()==str){
					$(this).val('').css('color',color);
					if(type=='password') $(this).attr('type','password');
				}
			});
			$(this).blur(function(){
				if($(this).val()==''){
					$(this).val(str).css('color',pcolor);
					if(type=='password') $(this).attr('type','text');
				}
			});
			if($(this).val()==''){
				$(this).val(str).css('color',pcolor);
				if(type=='password') $(this).attr('type','text');
			}
		});
	}
	$(function(){
		placeholder($('[placeholder]'),'#ccc');
	});
	</script>
	<![endif]-->
</body>
</html>

