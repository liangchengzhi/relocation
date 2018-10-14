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

<div class="container-fluid" nav-menu="listUserOperatorLog">
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
				<li><a href="javascript:void(0)">用户操作日志</a></li>
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
								<form class="searchForm" style="display:inline">
								<div class="dataTables_filter">
									<input type="hidden" name="pS" value="${empty pager.ps?'':pager.ps }"/>
									<label><span class="hidden-tablet hidden-phone">操作用户: </span><input type="text" id="username" name="username" class="m-wrap small"></label>
									<label><span class="hidden-tablet hidden-phone">交易名: </span><input type="text" id="tranName" name="tranName" class="m-wrap small"></label>
									<label>
										<select class="m-wrap samll" id="status" name="status" style="width:100px">
											<option value="">交易状态</option>
											<option value="false" ${status!=null && status==false?'selected':'' }>交易成功</option>
											<option value="true" ${status!=null && status==true?'selected':'' }>交易失败</option>
										</select>
									</label>
									<button id="search" type="submit" class="btn"><i class="icon-search"></i> 搜索</button>
								</div>
								</form>
							</div>
						</div>
				
						<table class="table table-bordered form-horizontal">
							<thead>
							<tr>
								<th class="nowrap">序号</th>
								<th class="center" width="100">用户名</th>
								<th class="center" width="100">交易名</th>
								<th class="center" width="100">交易状态</th>
								<th class="center" width="120">交易信息</th>
								<th class="center" width="120">交易日期</th>
								<th class="center" width="200">备注</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="vo" varStatus="i">
							<tr class="${i.count%2 eq 0?'even':'odd'}">
								<%-- <td><input type="checkbox" name="checkAll" value="${vo.id }"></td> --%>
								<td class="nowrap">${i.count+pager.offset}</td>
								<td class="center hlight"><a href="javascript:void(0)">${vo.username }</a></td>
								<td class="center hlight"><a href="javascript:void(0)">${vo.tranName }</a></td>
								<td class="center">
									<span class="label label-success enableLbl ${vo.status==true?'':'hidden' }">交易成功</span>
									<span class="label label-inverse disableLbl ${vo.status==true?'hidden':'' }">交易失败</span>
								</td>
								<td class="center hlight"><a href="javascript:void(0)">${vo.msg }</a></td>								
								<td class="center nowrap"><fmt:formatDate value="${vo.tranTime.getTime()}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td class="center hlight"><a href="javascript:void(0)">${vo.remark }</a></td>
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
	/*
	$('#search').click(function(){
		var username = $('input[id="username"]').val();
		var tranName = $('input[id="tranName"]').val();
		var status = $('input[id="status"]').val();
		var data = {username:username,tranName:tranName,status:status};
		
		
		loadingModal('正在查询……');		
		 $.post("listUserOperatorLog?ajaxtag=1",data,function(resp){
			loadingModal();
		});
	});
	*/
});
</script>
</body>
</html>