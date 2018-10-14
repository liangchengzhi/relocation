<%@page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<html>
<head>
<link rel="stylesheet" type="text/css" href="media/css/bootstrap-fileupload.css" />
<script src="js/ajaxfileupload.js"></script>
</head>
<body>
<div class="container-fluid" nav-menu="changeProfile">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				用户资料  <small>以下是您的用户资料信息</small>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">账户信息</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">用户资料</a></li>
			</ul>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c">
				<div class="portlet-body form">
					<form class="form-horizontal editF">
						<input type="hidden" name="gender" value="${cuser.gender }" />
						<div class="row-fluid" style="margin-bottom:20px;margin-top:20px">
						<div class="span8" style="border-right:1px solid #ccc;">
							<div class="control-group">
								<label class="control-label">用户名<span class="required"> </span></label>
								<div class="controls">
									<input value="${cuser.username }" disabled="disabled" type="text" class="m-wrap large" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">手机号<span class="required"> </span></label>
								<div class="controls">
									<input id="phone" value="${cuser.phone }" type="text" class="m-wrap medium" disabled="disabled"/>
                           			<span onclick="$('#myModalBtn2').click()" style="line-height:34px;" class="my-alter">&nbsp;<a href="javascript:void(0)">更改手机号</a> </span>
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label">单位名称<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true},{minLen:2,maxLen:40}]"
									 name="nickname" value="${cuser.nickname }" placeholder="单位名称" type="text" class="m-wrap large"/>
								</div>
							</div>
						</div>
						
						<div class="span4"> </div>
					   </div>
						
						<div class="form-actions">
							<button type="button" class="btn blue okBtn"><i class="icon-ok"></i> 保存</button>
							<button type="button" class="btn goBackBtn">返回</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<a id="myModalBtn2" href="#myModal2" role="button" class="btn" data-toggle="modal" style="position:absolute;left:-10000px;"></a>
<div id="myModal2" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel2">更改手机号</h3>
  </div>
  <div class="modal-body" style="padding-bottom:0;overflow: hidden">
    <form class="form-horizontal editPhoneF" style="margin:0">
		<div class="row-fluid">
		<div class="span12">
			<div class="control-group">
				<label class="control-label">手机号<span class="required">*</span></label>
				<div class="controls">
					<input lhq-validate="[{required:true,msg:'手机号不能为空。'},{reg:'/^((13[0-9])|(15[^4,\\D])|((19|18|17|16)[0-9]))\\d{8}$/',msg:'请输入有效的手机号。'}]" 
	                    type="text" id="newphone" placeholder="手机号" class="m-wrap medium" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">验证码<span class="required">*</span></label>
				<div class="controls">
					<div class="float2left">
					<input lhq-validate="[{required:true,msg:'验证码不能为空。'},{reg:'/^([0-9]){6}$/',msg:'请输入6位验证码。'}]" 
	                    type="text" id="randcode" placeholder="验证码" class="m-wrap small" style="width:100px !important"/>
	                </div>
	                <div id="getRandcode" class="float2left btn green" style="margin-left: 5px;">获取验证码</div>
				</div>
			</div>
		</div>
		</div>
	</form>
  </div>
  <div class="modal-footer">
    <button class="btn closeBtn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-primary" onclick="changePhone()">修改</button>
  </div>
</div>
<script>
function timeToResend(m,obj){
	if(m==0){
		$(obj).html('重新获取验证码').removeAttr('disabled');
	}else{
		$(obj).html('获取验证码('+m+'s)');
		setTimeout(function(){
			timeToResend(m-1, obj);
		},1000);
	}
}

function changePhone(){
	if(validateForm('.editPhoneF')==false){
		shake('editPhoneF .validateErr'); return false;
	}
	$.post("./rebindPhone?ajaxtag=1",{phone:$('#newphone').val(),code:$('#randcode').val()},function(resp){
		if(checkSmsResult(resp)==false) return false;
		
		showMsg('更改成功！');
		$('#myModal2 .closeBtn').click();
		$('#phone').val($('#newphone').val());
	});
}

$(function(){
	$('#getRandcode').click(function(){
		if($('#getRandcode[disabled]').length>0) return false;
		var _this = $(this);
		var phone = $('#newphone');
		if(phone.hasClass(validateErrCls)==false && validateInput(phone,true)==true){
			_this.text('请求已发送').attr('disabled','');
    		$.post("phoneRandcode?ajaxtag=1",{phone:phone.val(),type:'rebind'},function(resp){
    			if(checkSmsResult(resp)==false){
    				timeToResend(2, _this);
    			}else{
    				showMsg('验证码已发送，请在20分内进行验证。')
    				timeToResend(59, _this);
    			}
    		});
    	}else{
    		shake(phone); return false;
    	}
	});
	
	$('.okBtn').click(function(){
		if(validateForm('.editF')==false){
			shake('.editF .validateErr'); return false;
		}
		
		if($('input[name="qxdm"]').length>0){
			$('input[name="qxdm"]').val($('.deliverQxdm3').val());
		}
		
		var param = $('.editF').serializeObject();
		$.post("./changeProfile?ajaxtag=1",param,function(resp){
			if(checkResponse(resp)==false) return ;
			
			bootbox.alert('<h4>提示：</h4>保存成功。','确定',function(){
				var referer = $('input[name="referer"]');
				if(referer.length>0&&referer.val()!='')	window.location.href = referer.val();
			});
		});
	});
});
</script>
</body>
</html>