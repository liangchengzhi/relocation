<%@page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<html>
<head>
<style>
.editF .controls .forMsg{
	display: inline-block;
	padding-left: 5px;
	font-size: 14px;
	font-weight: normal;
	line-height: 20px;
	margin-top: 6px;
	margin-bottom: 0;
	vertical-align: middle;
	height: auto !important;
}
</style>
</head>
<body>
<div class="container-fluid" nav-menu="changePwd">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				修改密码  <small>您可以修改您的登陆密码</small>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">账户信息</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">修改密码</a></li>
			</ul>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c;">
				<div class="portlet-body form">
					<form class="form-horizontal editF">
						<div class="row-fluid" style="margin-top:20px;margin-bottom:20px">
						<div class="span12">
							<div class="control-group">
								<label class="control-label">原始密码<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true,msg:'密码不能为空。'},{minLen:6,msg:'密码太不能少于6位。'},{maxLen:20,msg:'密码不能多于20位。'}]"  
										type="password" id="oldpwd" placeholder="原始密码" class="m-wrap large" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">新密码<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true,msg:'新密码不能为空。'},{minLen:6,msg:'密码太短不安全(不能少于6位)。'},{maxLen:20,msg:'这么长的密码您记得住么(不能多于20位)?'}]"
                                       	 type="password" id="newpwd" placeholder="新密码" class="m-wrap large" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">确认新密码<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true,msg:'确认密码不能为空。'},{eqTo:'#newpwd',msg:'两次输入的密码不一致。'}]" 
                                       	type="password" id="newpwdconfirm" placeholder="新密码确认" class="m-wrap large" />
								</div>
							</div>
						</div>
						</div>
						<div class="form-actions">
							<button type="button" class="btn blue okBtn"><i class="icon-ok"></i> 修改</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$('.okBtn').click(function(){
		if(validateForm('.editF')==false){
			shake('.editF .validateErr'); return false;
		}
		$.post("./resetPassword?ajaxtag=1",{oldpassword:$('#oldpwd').val(),newpassword:$('#newpwd').val()},function(resp){
			if(checkResponse(resp)==false) return ;
			
			bootbox.alert('<h4>提示：</h4>修改成功，请牢记新密码！','确定',function(){
				$('#oldpwd').val('');
				$('#newpwd').val('');
				$('#newpwdconfirm').val('');
				var referer = $('input[name="referer"]');
				if(referer.length>0&&referer.val()!='')	window.location.href = referer.val();
			});
		});
	});
});
</script>
</body>
</html>