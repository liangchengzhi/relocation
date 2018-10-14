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
.item.colorLbl,.item.sizeLbl{
	margin-bottom: 0;
}
.exportModal .modal-header>.close{
	background-image: none !important;
}
.exportModal .modal-footer{
	text-align: center;
}
</style>

</head>
<body>

<div class="container-fluid" nav-menu="recordtransitionfeeList">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
			<c:if test="${cuser.usertype eq 8 }">
				过渡费记录 <small>以下列出了我登记的过渡费记录</small>
			</c:if>
			<c:if test="${cuser.usertype gt 8 }">
				过渡费记录 <small>以下列出了我可见的所有用户登记的过渡费记录</small>
			</c:if>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">拆迁管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">${empty all?'我登记的':'所有' }过渡费记录</a></li>
			</ul>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c">
				<div class="portlet-body">
					<div class="dataTables_wrapper form-inline" role="grid">
						<div class="row-fluid">
							<div class="span12">
								<div class="dataTables_filter">
								<form class="searchForm" style="display:inline">
									<input type="hidden" name="ps" value="${empty pager.ps?'':pager.ps }"/>
									<input type="hidden" name="p" value="${empty pager.p?'':pager.p }"/>
									<c:if test="${not empty userid }">
									<input type="hidden" name="uid" value="${userid }"/>
									</c:if>
									<label><span class="hidden-tablet hidden-phone">姓名/合同/备案: </span><input type="text" name="keyword" placeholder="关键字" value="${keyword }" class="m-wrap small"></label>
									<label>
										<span class="hidden-tablet hidden-phone">&nbsp;&nbsp;项目:</span>
										<select class="m-wrap samll" name="pname">
											<option value="">所有项目</option>
											<c:forEach items="${projectList }" var="vo">
											<option value="${vo.name }" ${vo.name==pname?'selected':'' }>${vo.name }</option>
											</c:forEach>
										</select>
									</label>
									<button type="submit" class="btn"><i class="icon-search"></i> 搜索</button>
								</form>
								<a href="./EditTransitionfee" class="btn blue pull-right"><i class="icon-plus"></i> 新增</a>
								<label class="label label-info pointer pull-right exportExcelBtn" style="line-height:30px !important;margin-right:5px;padding:2px 8px">
									<i class="icon-circle-arrow-down"></i> 导出到Excel
				           		</label>
								<label class="label label-success pointer pull-right" style="line-height:30px !important;margin-right:5px;padding:2px 8px">
									<i class="icon-circle-arrow-up"></i> 从Excel导入
				           			<input id="importExcelFile" type="file" class="hidden"/>
				           		</label>
				           		<label class="label label-warning pointer pull-right batchDeleteBtn" style="line-height:30px !important;margin-right:5px;padding:2px 8px">
									<i class="icon-remove-circle"></i> 批量删除
				           		</label>
								</div>
							</div>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<tr>
								<th class="nowrap"><input type="checkbox" class="checkAll"/></th>
								<th class="nowrap">序号</th>
								<th class="center nowrap" width="80">合同号</th>
								<th class="center nowrap hidden-tablet hidden-phone" width="50">备案号</th>
								<th class="center">姓名</th>
								<th class="center hidden-tablet hidden-phone" width="80">手机号</th>
								<th class=" hidden-tablet hidden-phone">项目名称</th>
								<th class="center hidden-phone nowrap"  width="80">总金额</th>
								<th class="center" width="140">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${list }" var="vo" varStatus="i">
								<tr class="${i.count%2 eq 0?'even':'odd'}">
								<td><input type="checkbox" name="checkAll" value="${vo.id }"></td>
								<td class="nowrap">${i.count+pager.offset}</td>
								<td class="center nowrap hlight">${vo.contractNumber }</td>
								<td class="center nowrap hidden-tablet hidden-phone hlight">${vo.recordNumber }</td>
								<td class="center hlight">
									<a href="RecordTransitionfeeDetails?id=${vo.id }">
										${vo.username }
									</a>
								</td>
								<td class="center hidden-tablet hidden-phone">${vo.contact }</td>
								<td class=" hidden-tablet hidden-phone hlight">${vo.projectName }</td>
								<td class="center hidden-phone money nowrap">￥ ${empty vo.total?0:vo.total }</td>
								<td class="center">
									<input type="hidden" name="id" value="${vo.id }"/>
									<a href="./EditTransitionfee?id=${vo.id }" class="btn mini green"><i class="icon-pencil"></i> 编辑</a>
									<a href="javascript:void(0)" class="btn mini black deleteBtn"><i class="icon-remove"></i> 删除</a>
								</td>
								</tr>
							</c:forEach>
							<c:if test="${empty list }">
								<tr>
									<td colspan="10" class="center">暂无记录</td>
								</tr>
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
		bootbox.confirm("<h4>警告：</h4>删除后不可恢复，确定要删除吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('请求正在被处理……');
				$.post("deleteRecordTransitionfee2?ajaxtag=1",{id:id},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return ;
					
					showMsg('删除成功！');
					tr.remove();
				});
			}
		});
	});
	$('.batchDeleteBtn').click(function(){
		var ids = '';
		if($('input[name="checkAll"]:not(:disabled)').length<1){
			showMsg('暂无记录可删除!');
			return false;
		}
		$('input[name="checkAll"]:checked:not(:disabled)').each(function(){
			if($(this).val()=='') return ;
			if(ids!='') ids += ',';
			ids += $(this).val();
		});
		if(ids==''){
			flash($('input[name="checkAll"]:not(:disabled)').parent('span'));
			shakeMsg('请至少选择一条记录!');
			return false;
		}
		bootbox.confirm("<h4>警告：</h4>删除后不可恢复，您确定删除所选记录吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('服务响应中，请稍等....');
				$.post("deleteRecordTransitionfee3?ajaxtag=1",{ids: ids},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>'+(resp.message||'删除成功！'),"确定", function(){
						location.reload();
					})
				});
			}
		});
	});
	$('#importExcelFile').on('change',function(){
		loadingModal('导入中，请稍等....',600000);
		ajaxUploadFile("./upload?type=import&ajaxtag=1", this, function(resp){
			if(resp.indexOf('.xls')==-1||resp.indexOf('.xlsx')!=-1){
				loadingModal();
				shakeMsg('仅支持.xls文件导入！');return;
			}
			$.post("./importFile2?ajaxtag=1",{path: "/"+resp},function(resp){
				loadingModal();
				if(checkResponse(resp)==false) return;
				
				bootbox.alert("<h4>提示：</h4>"+resp.message,"确定", function(){
					location.reload();
				});
			});
		});
	});
	$('.exportExcelBtn').click(function(){
		var dialog = bootbox.dialog('<strong>提示：</strong>选择全部记录可能会需要很长时间，以至导出失败，请慎重！', 
				[{
					'label': "<i class='icon icon-th-large white'></i> 全部记录", 
					'class': "btn-primary",
					'callback': function(){
						exportData(3);
						return true;
					}
				},{
					'label': "<i class='icon icon-th-list white'></i> 本页所有", 
					'class': "btn-primary",
					'callback': function(){
						exportData(2);
						return true;
					}
				},{
					'label': "<i class='icon icon-th white'></i> 所选记录", 
					'class': "btn-primary",
					'callback': function(){
						var ids = '';
						if($('input[name="checkAll"]:not(:disabled)').length<2){
							showMsg('暂无记录可导出!');
							return true;
						}
						$('input[name="checkAll"]:checked:not(:disabled)').each(function(){
							if($(this).val()=='') return true;
							if(ids!='') ids += ',';
							ids += $(this).val();
						});
						if(ids==''){
							flash($('input[name="checkAll"]:not(:disabled)').parent('span'));
							shakeMsg('请至少选择一条记录!');
							return true;
						}
						exportData(1, ids);
						return true;
					}
				}],
				{header:'请选择导出模式'}
		).addClass('exportModal');
	})
});
function exportData(type, ids){
	ids = ids || '';
	var url = "./Export2?type="+type+"&ids="+ids;
	var p = $('.searchForm input[name="p"]').val();
	var ps = $('.searchForm input[name="ps"]').val();
	var keyword = $('.searchForm input[name="keyword"]').val().trim();
	var uid = $('.searchForm input[name="uid"]').val();
	var pname = $('.searchForm [name="pname"]').val();
	if(p!='') url += "&p="+p;
	if(ps!='') url += "&ps="+ps;
	if(uid && uid!='') url += "&uid="+uid;
	if(pname && pname!='') url += "&pname="+encodeURIComponent(pname);
	if(keyword!='') url += "&keyword="+encodeURIComponent(keyword);
	window.open(url);
}
</script>
</body>
</html>