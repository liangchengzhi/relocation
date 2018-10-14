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
<script src="js/qrcode/jquery.qrcode.min.js"></script>
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

<div class="container-fluid" nav-menu="transitionfeeList">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
			<c:if test="${cuser.usertype eq 8 }">
				过渡费记录 <small>以下列出了我登记的拆迁用户的过渡费记录</small>
			</c:if>
			<c:if test="${cuser.usertype gt 8 }">
				过渡费记录 <small>以下列出了我可见的所有用户登记的过渡费记录</small>
			</c:if>
			<button onclick="computeTransitionfee()" class="pull-right btn btn-primary"><i class="icon icon-magic"></i> 计算过渡费</button>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">过渡费管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">过渡费记录</a></li>
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
									<label><input type="text" name="keyword" placeholder="姓名/合同号" value="${keyword }" class="m-wrap small"></label>
									<label>
										<select class="m-wrap samll" name="pname">
											<option value="">所有项目</option>
											<c:forEach items="${projectList }" var="vo">
											<option value="${vo.name }" ${vo.name==pname?'selected':'' }>${vo.name }</option>
											</c:forEach>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="dealed" style="width:90px">
											<option value="">付款状态</option>
											<option value="false" ${dealed!=null && dealed==false?'selected':'' }>未付款</option>
											<option value="true" ${dealed!=null && dealed==true?'selected':'' }>已付款</option>
										</select>
									</label>
									
									<label>
										<select class="m-wrap samll" name="serviceDepartment" style="width:90px">
											<option value="">办事处</option>
											<option value="01" >新蒲办</option>
											<option value="02" >新中办</option>
											<option value="03" >指挥部</option>
										</select>
									</label>
									
									<label>
										<select class="m-wrap samll" name="type" style="width:125px">
											<option value="">过渡费类型</option>
											<option value="正常过渡" ${type=='正常过渡'?'selected':'' }>正常过渡</option>
											<option value="搬迁超期罚款" ${type=='搬迁超期罚款'?'selected':'' }>搬迁超期罚款</option>
											<option value="逾期还房补偿" ${type=='逾期还房补偿'?'selected':'' }>逾期还房补偿</option>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="year" style="width:90px">
											<option value="">年份</option>
											<c:forEach begin="${thisyear -9 }" end="${thisyear}" step="1" varStatus="k">
											<option value="${thisyear + 1 - k.count }" ${year==thisyear + 1 - k.count?'selected':'' }>${thisyear + 1 - k.count }年</option>
											</c:forEach>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="quarter" style="width:90px">
										    <option value="">季度</option>
											<option value="1" ${quarter==1?'selected':'' }>一季度</option>
											<option value="2" ${quarter==2?'selected':'' }>二季度</option>
											<option value="3" ${quarter==3?'selected':'' }>三季度</option>
											<option value="4" ${quarter==4?'selected':'' }>四季度</option>
										</select>
									</label>
									<button type="submit" class="btn"><i class="icon-search"></i> 搜索</button>
								</form>
								<!-- 导出过渡费是否按项目分组来导
									如果true，那么将使用异步的方式来导出，导出到指定目录中
									如果false，则使用同步导出，导出符合参数的文件，并返回
								-->
								异步按项目
								<input type="checkbox" name="is_export_async_and_group_by_project" checked="true" />
								<label class="label label-info pointer pull-right exportExcelBtn" style="line-height:30px !important;padding:2px 8px">
									<i class="icon-circle-arrow-down"></i>导出
				           		</label>
				           		<label class="label label-success pointer pull-right batchDeleteBtn" style="line-height:30px !important;margin-right:5px;padding:2px 8px">
									<i class="icon-ok-circle"></i>付款
				           		</label>
								</div>
							</div>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<tr>
								<th class="nowrap"><input type="checkbox" class="checkAll"/></th>
								<th class="nowrap">序号</th>
								<th class="center nowrap">状态</th>
								<th class="center" width="80">姓名</th>
								<th class="center nowrap hidden-tablet hidden-phone" width="80">合同号</th>
								<th class="center nowrap hidden-tablet hidden-phone" width="50">备案号</th>
						<!-- 		<th class="center nowrap">类型</th> -->
								<th class="hidden-tablet hidden-phone">项目名称</th>
								<th class="center nowrap">起始日期</th>
								<th class="center nowrap">截止日期</th>
								<th class="center nowrap">正常</th>
								<th class="center nowrap">逾期</th>
								<th class="center nowrap">三月补偿</th>
								<th class="center nowrap">过渡费和</th>
								<th class="center nowrap">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${list }" var="vo" varStatus="i">
								<tr class="${i.count%2 eq 0?'even':'odd'}">
								<td><input type="checkbox" name="checkAll" value="${vo.id }" ${vo.isDealed != null and vo.isDealed==true?'disabled':'' }/></td>
								<td class="nowrap">${i.count+pager.offset}</td>
								<td class="center nowrap">
									<c:if test="${vo.isDealed != null and vo.isDealed==true }">
										<label class="isdealed label">已付款</label>
									</c:if>
									<c:if test="${vo.isDealed == null or vo.isDealed==false }">
										<label class="isdealed label label-success">未付款</label>
									</c:if>
								</td>
								<td class="center nowrap hidden-tablet hidden-phone hlight">
									<a href="RecordDetails?id=${vo.record.id }">
									${vo.record.username }
									</a>
								</td>
								<td class="center nowrap hidden-tablet hidden-phone">${vo.record.contractNumber }</td>
								<td class="center hlight">
									${vo.record.recordNumber }	
								</td>
								<%-- <td class="center nowrap">
									${vo.type }	
								</td> --%>
								<td class="hidden-tablet hidden-phone">${vo.record.projectName }</td>
								<td class="center nowrap"><fmt:formatDate value="${vo.startTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center nowrap"><fmt:formatDate value="${vo.endTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center nowrap money">￥ ${empty vo.fee?0:vo.fee }</td>
								<td class="center nowrap money">￥ ${empty vo.overdueFee?0:vo.overdueFee }</td>
								<td class="center nowrap money">￥ ${empty vo.threeMonthFee?0:vo.threeMonthFee }</td>
								<td class="center nowrap money">￥ ${empty vo.quarterFee?0:vo.quarterFee }</td>
								<td class="center nowrap">
									<input type="hidden" name="id" value="${vo.id }"/>
									<c:if test="${vo.isDealed != null and vo.isDealed==true }">
										<button disabled class="btn mini green disabled"><i class="icon-ok"></i> 付款</button>
									</c:if>
									<c:if test="${vo.isDealed == null or vo.isDealed==false }">
										<button  class="btn mini green toDealBtn"><i class="icon-ok"></i> 付款</button>
									</c:if>
									<!-- <button class="btn mini black deleteBtn"><i class="icon-remove"></i> 删除</button> -->
								</td>
								</tr>
							</c:forEach>
							<c:if test="${empty list }">
								<tr>
									<td colspan="12" class="center">暂无记录</td>
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
		bootbox.confirm("<h4>提示：</h4>删除后不可恢复，确定要删除吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('请求正在被处理……');
				$.post("deleteTransitionfee2?ajaxtag=1",{id:id},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return ;
					
					showMsg('删除成功！');
					tr.remove();
				});
			}
		});
	});
	
	$('.toDealBtn').click(function(){
		var tr = $(this).parents('tr');
		var id = tr.find('input[name="id"]').val();
		bootbox.confirm("<h4>提示：</h4>确定已付款吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('请求正在被处理……');
				$.post("dealTransitionfee?ajaxtag=1",{id:id},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return ;
					
					showMsg('标记已付款成功！');
					
					tr.find('label.isdealed').removeClass('label-success').text('已付款');
					tr.find('.toDealBtn').removeClass('toDealBtn')
						.addClass('disabled')
						.attr('disabled','');
					tr.find('[name="checkAll"]').attr('disabled','');
				});
			}
		});
	});
	
	$('.batchDeleteBtn').click(function(){
		var ids = '';
		if($('input[name="checkAll"]:not(:disabled)').length<1){
			showMsg('暂无记录可付款!');
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
		bootbox.confirm("<h4>提示：</h4>您确定要设置所选记录为已付款吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('服务响应中，请稍等....');
				$.post("dealTransitionfee2?ajaxtag=1",{ids: ids},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>'+(resp.message||'操作成功！'),"确定", function(){
						location.reload();
					})
				});
			}
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
						if($('input[name="checkAll"]:not(:disabled)').length<1){
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

function computeTransitionfee(){
	loadingModal('请求正在被处理，请耐心等待……', 6000);
	$.post("computeTransitionfee?ajaxtag=1",function(resp){
		loadingModal();
		/*
		if(checkResponse(resp)==false) return ;
		
		bootbox.alert('<h4>提示：</h4>'+(resp.message||'计算完毕！'), function(){
			window.location.reload();
		});
		*/
		alert(resp.message);
		location.reload();
	});
}

function exportData(type, ids){
	ids = ids || '';
	var url = "./Export3?type="+type+"&ids="+ids;
	var p = $('.searchForm input[name="p"]').val();
	var ps = $('.searchForm input[name="ps"]').val();
	var keyword = $('.searchForm input[name="keyword"]').val().trim();
	var uid = $('.searchForm input[name="uid"]').val();
	var pname = $('.searchForm [name="pname"]').val();
	var dealed = $('.searchForm [name="dealed"]').val();
	var year = $('.searchForm [name="year"]').val();
	var quarter = $('.searchForm [name="quarter"]').val();
	var feetype = $('.searchForm [name="type"]').val();
	var is_export_async_and_group_by_project = $('[name="is_export_async_and_group_by_project"]').attr("checked");
	if(!is_export_async_and_group_by_project){
		is_export_async_and_group_by_project = false;
	}else{
		is_export_async_and_group_by_project = true;
	}
	url += "&is_export_async_and_group_by_project=" + is_export_async_and_group_by_project;
	if(p && p!='') url += "&p="+p;
	if(ps && ps!='') url += "&ps="+ps;
	if(dealed!='') url += "&dealed="+dealed;
	if(year!='') url += "&year="+year;
	if(quarter!='') url += "&quarter="+quarter;
	if(uid && uid!='') url += "&uid="+uid;
	if(feetype && feetype!='') url += "&feetype="+encodeURIComponent(feetype);
	if(pname && pname!='') url += "&pname="+encodeURIComponent(pname);
	if(keyword!='') url += "&keyword="+encodeURIComponent(keyword);
	if(is_export_async_and_group_by_project == false){
		window.open(url);	
	}else{
		loadingModal('请求正在被处理，请耐心等待……', 6000);
		$.post(url,function(resp){
			loadingModal();
			alert(resp.message);
			location.reload();
		});
	}
	
}
</script>
</body>
</html>