<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String Title = "";
Title = request.getHeader(Title);
%>
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

<div class="container-fluid" nav-menu="userEdit">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				<c:if test="${empty entity.id }">
				新增用户 <small>可以添加拆迁单位</small>
				</c:if>
				<c:if test="${not empty entity.id }">
				编辑${entity.usertype==9?'平台管理员':(entity.usertype==8?'拆迁单位':'普通用户') } <small>可以修改用户手机号码和用户的单位名称等信息</small>
				</c:if>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">用户管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">${empty entity.id?'新增':'编辑'}${entity.usertype==9?'平台管理员':(entity.usertype==8?'拆迁单位':'普通用户') }</a></li>
			</ul>
		</div>
	</div>
	
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c">
				<div class="portlet-body form" style="overflow: hidden;">
					<form class="form-horizontal editF span8">
						<input type="hidden" name="id" value="${entity.id }"/>
						<input type="hidden" name="usertype" value="${entity.usertype }"/>
						<div class="control-group">
							<label class="control-label">用户名<span class="required">*</span></label>
							<div class="controls">
								<input lhq-validate="[{required:true,minLen:4,maxLen:10},{reg:'/^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9])*$/',msg:'用户名只能包括中文、字母和数字字符'}]" 
									name="username" value="${entity.username }" ${empty entity.id?'':'disabled="disabled"' } placeholder="用户名" type="text" class="m-wrap medium" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">初始密码<span class="required">*</span></label>
							<div class="controls">
								<input lhq-validate="[{required:true,msg:'初始密码不能为空。'},{minLen:4,msg:'密码不能少于6位。'},{maxLen:20,msg:'密码不要多于20位。'}]" 
									name="password" value="${empty entity.id?'':'123456' }" ${empty entity.id?'':'disabled="disabled"' } placeholder="建议初始为123456" type="password" class="m-wrap medium" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">手机号<span class="required">*</span></label>
							<div class="controls">
								<input lhq-validate="[{required:true,msg:'手机号不能为空。'},{reg:'/^((13[0-9])|(15[^4,\\D])|((19|18|17|16)[0-9]))\\d{8}$/',msg:'请输入有效的手机号。'}]" 
									name="phone" value="${entity.phone}" placeholder="手机号" type="text" class="m-wrap medium" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">名称<span class="required"> </span></label>
							<div class="controls">
								<input lhq-validate="[{maxLen:80}]" 
									name="nickname" value="${entity.nickname}" placeholder="单位名称" type="text" class="m-wrap medium" />
							</div>
						</div>
					</form>
					<div class="span4" id="authList">
						<h4>角色权限</h4>
						<c:forEach items="${authList }" var="vo">
							<p><label><input type="checkbox" class="checkAll" ${not empty entity.authorityGroup and entity.authorityGroup.contains(vo.name)?'checked':'' } value="${vo.id }"/> ${vo.name }</label></p>
						</c:forEach>
					</div>
					<div class="form-actions span12">
						<button type="button" class="btn blue okBtn"><i class="icon-ok"></i> 保存</button>
						<button type="button" class="btn goBackBtn">返回</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$('.okBtn').click(function(){
		preventDefault(arguments[0]);
		if(validateForm('.editF')==false){
			shake('.editF .validateErr');return false;
		}
    	var param = $('.editF').serializeObject();
    	var authIds = '';
    	$('#authList input[type="checkbox"]:checked').each(function(){
    		if(authIds!='') authIds += ',';
    		authIds += $(this).val();
    	});
    	param['auths'] = authIds;
    	loadingModal('正在处理中……');
		$.post("saveUser?ajaxtag=1",param,function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			bootbox.alert('<h4>提示：</h4>保存成功。','确定',function(){
				var referer = $('input[name="referer"]');
				if(referer.length>0&&referer.val()!='')	window.location.href = referer.val();
			});
		});
	});
	<c:if test="${empty entity.id}">
	$('.editF input[name="username"]').on('blur',function(){
		var _this = this;
		if($(_this).hasClass(validateErrCls)==false && validateInput(_this)==true){
			$.post("checkUsername?ajaxtag=1",{username:$(_this).val()},function(resp){
				if(checkResponse(resp)==false) return ;
				if(resp.data==true){
					$(_this).parent().children('.forMsg').html('该账户已被使用。').show();
					$(_this).addClass(validateErrCls);
				}else{
					$(_this).parent().children('.forMsg').hide();
				}
			});
		}
	});
    $('.editF input[name="phone"]').on('blur',function(){
		var _this = this;
		if($(_this).hasClass(validateErrCls)==false && validateInput(_this)==true){
			$.post("checkPhone?ajaxtag=1",{phone:$(_this).val()},function(resp){
				if(checkResponse(resp)==false) return ;
				if(resp.data==true){
					$(_this).parent().children('.forMsg').html('该手机号已被绑定。').show();
					$(_this).addClass(validateErrCls);
				}else{
					$(_this).parent().children('.forMsg').hide();
				}
			});
		}
	});
	</c:if>
});
</script>
</body>
</html>