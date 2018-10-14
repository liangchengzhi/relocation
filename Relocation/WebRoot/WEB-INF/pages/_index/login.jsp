<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String Title = "";
Title = request.getHeader(Title);
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="zh"> <!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<title>拆迁管理系统|管理登陆</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/animate-3.4.css" rel="stylesheet" type="text/css"/>
	<link href="css/common.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/login.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/css/gritter.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="images/favicon.ico" />
	<style>
	.login {
	  background-color: #0F8951 !important;
	}
	</style>
</head>

<body class="login">

	<div class="logo" style="padding:0;margin-bottom:10px">
		<img src="images/logo.png"/> 
	</div>
	<div class="content">

		<form class="form-vertical login-form">
			<input type="hidden" id="referer" value="${referer }"/>
			<h3 class="form-title">登录到您的帐户</h3>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">账号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input lhq-validate="[{required:true,msg:'账号不能为空。'},{
                		reg:'/^(\\s)*((([a-zA-Z0-9_-]|\.)+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2}))|(([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9]){2,10})|([1][3-8]\\d{9}))(\\s)*$/',
                		msg:'请输入有效的账号、邮箱或手机号。'
                	}]" class="m-wrap placeholder-no-fix" type="text" placeholder="用户名/手机/邮箱" name="username"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input lhq-validate="[{required:true,msg:'密码不能为空。'},{minLen:6,msg:'密码太不能少于6位。'},{maxLen:20,msg:'密码不能多于20位。'}]" class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password" onkeyup="if(arguments[0].keyCode==13)$('#loginBtn').click()"/>
					</div>
				</div>
			</div>

			<div class="form-actions">
				<span class="pull-left">
					<label class="checkbox">
					<input type="checkbox" name="remember" value="1" style="margin-left:0"/> 保持登陆
					</label>
					<a href="javascript:void(0)" style="color:#999" id="forget-password"><small>忘记密码？</small></a>
				</span>
				<a href="javascript:void(0)" id="loginBtn" class="btn green pull-right">
				登陆 <i class="m-icon-swapright m-icon-white"></i>
				</a>            

			</div>
			<!-- <div class="forget-password" style="height:40px;margin-top:0">
				<a href="javascript:;" class="pull-left" id="forget-password"><h4>忘记密码？</h4></a>
				<a href="javascript:;" id="register-btn" class="pull-right"><h4>注册账户</h4></a>
			</div> -->
		</form>

		<form class="form-vertical forget-form">
			<h3 class="">找回密码</h3>
			<p>通过手机短信验证找回密码。</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">手机号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input lhq-validate="[{required:true,msg:'手机号不能为空。'},{reg:'/^((13[0-9])|(15[^4,\\D])|((19|18|17|16)[0-9]))\\d{8}$/',msg:'请输入有效的手机号。'}]" class="m-wrap placeholder-no-fix" type="text" placeholder="手机号" name="phone" />
					</div>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">验证码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input lhq-validate="[{required:true,msg:'验证码不能为空。'},{reg:'/^([0-9]){6}$/',msg:'请输入6位验证码。'}]" class="m-wrap placeholder-no-fix" type="text" placeholder="验证码" name="code"/>
						<a href="javascript:void(0)" id="randcodeBtn4FindPwd" class="btn blue pull-right" style="position: relative;top: -34px;">获取验证码</a>
					</div>
				</div>
			</div>

			<div class="form-actions">
				<button type="button" id="back-btn" class="btn">
				<i class="m-icon-swapleft"></i> 返回登陆
				</button>
				<a href="javascript:void(0)" id="findPwdBtn" class="btn green pull-right">
				下一步 <i class="m-icon-swapright m-icon-white"></i>
				</a>            

			</div>

		</form>
		
		<form class="form-vertical forget-form2">
			<input type="hidden" placeholder="手机号" name="phone" />
			<h3 class="">重设密码</h3>
			<p>请设置新的密码。</p>
			
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">新密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input lhq-validate="[{required:true,msg:'新密码不能为空。'},{minLen:6,msg:'密码太短不安全(不能少于6位)。'},{maxLen:20,msg:'这么长的密码您记得住么(不能多于20位)?'}]" class="m-wrap placeholder-no-fix" id="newpwd" type="password" placeholder="新密码" name="password"/>
					</div>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">确认密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input lhq-validate="[{required:true,msg:'确认密码不能为空。'},{eqTo:'#newpwd',msg:'两次输入的密码不一致。'}]" class="m-wrap placeholder-no-fix" type="password" placeholder="新密码确认" id="password_confirm"/>
					</div>
				</div>
			</div>
			
			<div class="form-actions" style="margin-top:34px">
				<button type="button" id="back-btn2" class="btn">
				<i class="m-icon-swapleft"></i> 上一步
				</button>
				<a href="javascript:void(0)" id="resetPwdBtn" class="btn green pull-right">
				提交 <i class="m-icon-swapright m-icon-white"></i>
				</a>            

			</div>

		</form>

		<!-- <form class="form-vertical register-form">
			<h3 class="">注册</h3>
			<p>请输入账户信息：</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input lhq-validate="[{required:true,msg:'用户名不能为空。'},{minLen:4,maxLen:10},{reg:'/^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9])*$/',msg:'用户名只能包括中文、字母和数字字符。'}]" class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="username"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input lhq-validate="[{required:true,msg:'密码不能为空。'},{minLen:6,msg:'密码太短不安全(不能少于6位)。'},{maxLen:20,msg:'这么长的密码您记得住么(不能多于20位)?'}]" class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">手机号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-headphones"></i>
						<input lhq-validate="[{required:true,msg:'手机号不能为空。'},{reg:'/^((13[0-9])|(15[^4,\\D])|((19|18|17|16)[0-9]))\\d{8}$/',msg:'请输入有效的手机号。'}]" class="m-wrap placeholder-no-fix" type="text" placeholder="手机号" name="phone"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">验证码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input lhq-validate="[{required:true,msg:'验证码不能为空。'},{reg:'/^([0-9]){6}$/',msg:'请输入6位验证码。'}]" class="m-wrap placeholder-no-fix" type="text" placeholder="验证码" name="code"/>
						<a href="javascript:void(0)" id="randcodeBtn4Register" class="btn blue pull-right" style="position: relative;top: -34px;">获取验证码</a>
					</div>
				</div>
			</div>

			<div class="control-group">

				<div class="controls">
					<label class="checkbox">
					<input type="checkbox" name="tnc" style="margin-left:0"/> 我同意 <a href="#">服务条款</a> 和 <a href="#">隐私政策</a>
					</label>  
					<div id="register_tnc_error"></div>
				</div>

			</div>

			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn">
				<i class="m-icon-swapleft"></i>  返回登陆
				</button>
				<a href="javascript:void(0)" id="registerBtn" class="btn green pull-right">
				注册 <i class="m-icon-swapright m-icon-white"></i>
				</a>            

			</div>

		</form> -->

	</div>


	<div class="copyright">
		2015-2020 &copy; 贵州网众信息科技有限公司
	</div>

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->
	<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="media/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="media/js/bootstrap-notify.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="media/js/excanvas.min.js"></script>
	<script src="media/js/respond.min.js"></script>  
	<![endif]-->   
	<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<script src="media/js/jquery.gritter.js" type="text/javascript"></script>
	<script src="<%=path%>/js/lhq_form_validate.js"></script>
	<script src="<%=path%>/js/highlight.js"></script>
	<script src="<%=path%>/js/bootbox.js"></script>
	<script src="<%=path%>/js/common.js"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="media/js/app.js" type="text/javascript"></script>
	<script src="<%=path%>/js/login.js" type="text/javascript"></script>      
	<!-- END PAGE LEVEL SCRIPTS --> 
	<!-- END JAVASCRIPTS -->
<c:if test="${not empty register}">
<script>
	$('.login-form').hide();
	$('.register-form').show();
</script>
</c:if>
</body>
</html>