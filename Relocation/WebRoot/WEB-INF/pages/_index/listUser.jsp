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
.form-horizontal .control-group{
	margin-bottom: 5px;
}
.form-horizontal .control-group .control-label{
	font-weight: 500;
}
</style>
</head>
<body>

<div class="container-fluid" nav-menu="userList">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				拆迁单位 <small>以下列出了本平台录入的拆迁单位</small>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">用户管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">拆迁单位列表</a></li>
			</ul>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span612">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c">
				<div class="portlet-body">
					<div class="dataTables_wrapper form-inline" role="grid">
						<div class="row-fluid">
							<div class="span6">
								<form style="margin-bottom:0">
								<div class="dataTables_filter">
									<input type="hidden" name="pS" value="${empty pager.ps?'':pager.ps }"/>
									<label><span class="hidden-tablet hidden-phone">用户名/手机号/单位名称: </span><input type="text" name="keyword" placeholder="关键字" value="${keyword }" class="m-wrap small"></label>
									<button type="submit" class="btn"><i class="icon-search"></i> 搜索</button>
								</div>
								</form>
							</div>
							<div class="span6 text-right">
								<a href="./EditUser" class="btn blue"><i class="icon-plus"></i> 新增</a>
							</div>
						</div>
				
						<table class="table table-bordered form-horizontal">
							<thead>
							<tr>
								<!-- <th class="nowrap"><input type="checkbox" class="checkAll"/></th> -->
								<th class="nowrap">序号</th>
								<th class="center" width="50">状态</th>
								<th class="center" width="100">用户名</th>
								<th class="center hidden-tablet hidden-phone" width="100">手机号</th>
								<th class="hidden-phone">单位名称</th>
								<th class="center" width="280">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="vo" varStatus="i">
							<tr class="${i.count%2 eq 0?'even':'odd'}">
								<%-- <td><input type="checkbox" name="checkAll" value="${vo.id }"></td> --%>
								<td class="nowrap">${i.count+pager.offset}</td>
								<td class="center">
									<span class="label label-success enableLbl ${vo.checkStatus==true?'':'hidden' }">有效</span>
									<span class="label label-inverse disableLbl ${vo.checkStatus==true?'hidden':'' }">无效</span>
								</td>
								<td class="center hlight"><a href="javascript:void(0)">${vo.username }</a></td>
								<td class="center hidden-tablet hidden-phone hlight">${vo.phone }</td>
								<td class="hidden-phone hlight">
									<span tooltip-title="最后登陆时间：<my:florid time="${vo.logintime }"></my:florid>" data-original-title="" title="">
										<c:if test="${empty vo.nickname }"><span style="color:#bbb">(未填写)</span></c:if>
										<c:if test="${not empty vo.nickname }"><span>${vo.nickname }</span></c:if>
										<c:if test="${not empty vo.photo }"><img src="${vo.photo }" style="width:72px;height:25px"/></c:if>
									</span>
								</td>
								<td class="center">
									<input type="hidden" name="id" value="${vo.id }"/>
									<a href="javascript:void(0)" class="btn mini blue repwdBtn" tooltip-title="重置密码为123456"><i class="icon-lock"></i> 重置密码</a>
									<a href="./EditUser?id=${vo.id }" class="btn mini green"><i class="icon-pencil"></i> 编辑</a>
									<a href="javascript:void(0)" class="btn mini yellow disableBtn ${vo.checkStatus==true?'':'hidden' }"><i class="icon-ban-circle"></i> 禁用</a>
									<a href="javascript:void(0)" class="btn mini green enableBtn ${vo.checkStatus==true?'hidden':'' }"><i class="icon-ok-circle"></i> 启用</a>
									<a href="javascript:void(0)" class="btn mini black deleteBtn"><i class="icon-remove"></i> 删除</a>
								</td>
							</tr>
							</c:forEach>
							<c:if test="${list.size()==0 }">
							<tr><td colspan="7" class="center">暂无记录</td></tr>
							</c:if>
							</tbody>
						</table>
						<jsp:include page="/WEB-INF/pages/_common/pager.jsp"/>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$('.deleteBtn').click(function(){
		var tr = $(this).parents('tr');
		var id = tr.find('input[name="id"]').val();
		bootbox.confirm("<h4>提示：</h4>删除后不可恢复，确定要删除吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('请求正在被处理……');
				$.post("deleteUser?ajaxtag=1",{id:id},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return ;
					
					showMsg('删除用户成功！');
					tr.remove();
				});
			}
		});
	});
	$('.disableBtn').click(function(){
		var tr = $(this).parents('tr');
		var id = tr.find('input[name="id"]').val();
		loadingModal('请求正在被处理……');
		$.post("enableUser?ajaxtag=1",{id:id,flag:false},function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			
			showMsg('禁用用户成功！');
			tr.find('.disableBtn,.enableLbl').addClass('hidden');
			tr.find('.enableBtn,.disableLbl').removeClass('hidden');
		});
	});
	$('.enableBtn').click(function(){
		var tr = $(this).parents('tr');
		var id = tr.find('input[name="id"]').val();
		loadingModal('请求正在被处理……');
		$.post("enableUser?ajaxtag=1",{id:id,flag:true},function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			
			showMsg('启用用户成功！');
			tr.find('.enableBtn,.disableLbl').addClass('hidden');
			tr.find('.disableBtn,.enableLbl').removeClass('hidden');
		});
	});
	$('.repwdBtn').click(function(){
		var id = $(this).parents('tr').find('input[name="id"]').val();
		bootbox.confirm("<h4>提示：</h4>确定要将用户密码重置为<span style='color:red'><em>123456</em></span> 吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('请求正在被处理……');
				$.post("repwdUser?ajaxtag=1",{id:id,flag:true},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return ;
					
					showMsg('成功重置密码为123456！');
				});
			}
		});
	});
});
</script>
</body>
</html>