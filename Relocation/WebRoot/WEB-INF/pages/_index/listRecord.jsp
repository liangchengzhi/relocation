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
.highLight .btn-edit{
	color: white;
	background-color:red !important;
}
</style>

</head>
<body>

<div class="container-fluid" nav-menu="recordList">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
			<c:if test="${cuser.usertype eq 8 }">
				拆迁记录 <small>以下列出了我登记的拆迁记录</small>
			</c:if>
			<c:if test="${cuser.usertype gt 8 }">
				拆迁记录 <small>以下列出了我可见的所有用户登记的拆迁记录</small>
			</c:if>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">拆迁管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">${empty all?'我登记的':'所有' }拆迁记录</a></li>
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
									<label><input type="text" name="keyword" placeholder="姓名/合同/备案" value="${keyword }" class="m-wrap small"></label>
									<label>
										<select class="m-wrap samll" name="pid" style="width:170px">
											<option value="">所有项目</option>
											<c:forEach items="${projectList }" var="vo">
											<option value="${vo.id }" ${vo.id==pid?'selected':'' }>${vo.name }</option>
											</c:forEach>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="started" style="width:100px">
											<option value="">交房状态</option>
											<option value="false" ${started!=null && started==false?'selected':'' }>未交房</option>
											<option value="true" ${started!=null && started==true?'selected':'' }>已交房</option>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="ended" style="width:100px">
											<option value="">还房状态</option>
											<option value="false" ${ended!=null && ended==false?'selected':'' }>未还房</option>
											<option value="true" ${ended!=null && ended==true?'selected':'' }>已还房</option>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="status" style="width:100px">
											<option value="">合同状态</option>
											<option value="1" ${status==1?'selected':'' }>未开始</option>
											<option value="2" ${status==2?'selected':'' }>进行中</option>
											<option value="3" ${status==3?'selected':'' }>已到期</option>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="replaceFlag" style="width:100px">
											<option value="">置换门面</option>
											<option value="0" ${replaceFlag==0?'selected':'' }>否</option>
											<option value="1" ${replaceFlag==1?'selected':'' }>是</option>
										</select>
									</label>
									<label>
										<select class="m-wrap samll" name="pauseCalculateFee" style="width:130px">
											<option value="">暂停/恢复计算</option>
											<option value="0" ${pauseCalculateFee==true?'selected':'' }>否</option>
											<option value="1" ${pauseCalculateFee==false?'selected':'' }>是</option>
										</select>
									</label>
									<button type="submit" class="btn"><i class="icon-search"></i> 搜索</button>
								</form>
								<div class="widget-toolbar action-buttons pull-right">
									<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">
					           		<a class="pink2 batchDeleteBtn" tooltip-title="批量删除" >
										<i class="icon-remove-circle"></i>
					           		</a>
					           		</c:if>
					           		<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('交房还房操作')}">
					           		<a class="info2 batchStartBtn" tooltip-title="批量交房" >
										<i class="icon-signout"></i>
					           		</a>
					           		<!-- <a class="success2 batchEndBtn" tooltip-title="批量还房" >
										<i class="icon-signin"></i>
					           		</a> -->
					           		</c:if>
					           		<label class="success2 pointer" tooltip-title="导入还房信息" >
										<i class="icon-circle-arrow-up"></i> 
					           			<input id="importReturnArea" type="file" class="hidden"/>
					           		</label>
					           		<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">
									<label class="success2 pointer" tooltip-title="从Excel导入拆迁记录" >
										<i class="icon-circle-arrow-up"></i> 
					           			<input id="importExcelFile" type="file" class="hidden"/>
					           		</label>
					           		</c:if>
					           		<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('补偿费用录入')}">
					           		<label class="success2 pointer" tooltip-title="从Excel导入过渡费信息" >
										<i class="icon-upload"></i> 
					           			<input id="importExcelFile2" type="file" class="hidden"/>
					           		</label>
					           		</c:if>
					           		<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">
					           		<a class="info2 exportExcelBtn" tooltip-title="导出拆迁记录到Excel" >
										<i class="icon-circle-arrow-down"></i> 
					           		</a>
					           		</c:if>
					           		<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('补偿费用录入')}">
					           		<a class="info2 exportExcelBtn2" tooltip-title="导出过渡费信息到Excel" >
										<i class="icon-download"></i> 
					           		</a>
					           		</c:if>
					           		<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">
									<a href="./EditRecord" class="blue2" tooltip-title="新增"><i class="icon-plus"></i></a>
									</c:if>
				           		</div>
								</div>
							</div>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<tr>
								<th class="nowrap"><input type="checkbox" class="checkAll"/></th>
								<th class="nowrap">序号</th>
								<th class="center nowrap" width="80">合同号</th>
								<th class="center nowrap" width="80">编号</th>
								<th class="center">姓名</th>
								<th class="hidden-tablet hidden-phone">项目名称</th>
								<th class="center hidden-phone" width="80">置换面积</th>
								<th class="center hidden-phone nowrap"  width="80">补偿费</th>
								<th class="center hidden-phone nowrap"  width="80">被补偿费</th>
								<th class="center nowrap">合同状态</th>
								<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('交房/还房操作')}">
								<th class="center" width="80">交房/还房</th>
								</c:if>
								<th class="center" width="80">暂停/恢复计算</th>
								<th class="center nowrap"><c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('补偿费用录入')}">过渡费/</c:if><c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">编辑</c:if></th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${list }" var="vo" varStatus="i">
								<tr class="${vo.pendingState eq 1?'highLight':'default'} ${i.count%2 eq 0?'even':'odd'}">
								<td><input type="checkbox" name="checkAll" value="${vo.id }"></td>
								<td class="nowrap">${i.count+pager.offset}</td>
								<td class="center nowrap hlight"><a href="RecordDetails?id=${vo.id }">${vo.contractNumber }</a></td>
								<td class="center nowrap hlight"><a href="RecordDetails?id=${vo.id }">${vo.recordNumber }</a></td>
								<td class="center hlight"> ${vo.username } </td>
								<td class=" hidden-tablet hidden-phone hlight">${vo.projectName }</td>
								<td class="center">${vo.replaceAreaTotal }</td>
								<td class="center hidden-phone money nowrap">￥ ${empty vo.balance1?0:vo.balance1 }</td>
								<td class="center hidden-phone money nowrap">￥ ${empty vo.balance2?0:vo.balance2 }</td>
								<td class="center">
									<c:if test="${vo.endTime eq null or vo.endTime.time.time lt today }">
										<span class="label">已到期</span>
									</c:if>
									<c:if test="${vo.endTime != null and vo.endTime.time.time gt today }">
										<c:if test="${vo.startTime != null and vo.startTime.time.time lt today }">
										<span class="label label-success">进行中</span>
										</c:if>
										<c:if test="${vo.startTime == null or vo.startTime.time.time gt today }">
										<span class="label label-warning">未开始</span>
										</c:if>
									</c:if>
								</td>
								<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('交房/还房操作')}">
								<td class="center" style="padding-left:14px;padding-right:14px;">
									<c:if test="${vo.isStart!=true }">
									<a class="btn mini pull-left blue startBtn" title="交房"><i class="icon-signout"></i></a>
									</c:if>
									<c:if test="${vo.isEnd!=true }">
									<a class="btn mini pull-right green endBtn" title="还房"><i class="icon-signin"></i></a>
									</c:if>
								</td>
								</c:if>
								<td class="center" style="padding-left:14px;padding-right:14px;">
									<c:if test="${vo.pauseCalculateFee!=true }">
									<a class="btn mini pull-left blue doPauseCalculateFeeBtn" title="暂停"><i class="icon-signout"></i></a>
									</c:if>
									<c:if test="${vo.pauseCalculateFee==true }">
									<a class="btn mini pull-right green doNotPauseCalculateFeeBtn" title="恢复"><i class="icon-signin"></i></a>
									</c:if>
								</td>
								<td class="center">
									<input type="hidden" name="id" value="${vo.id }"/>
									<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('补偿费用录入')}">
									<a href="./EditTransitionfee?id=${vo.id }" class="btn mini ${empty vo.total?'blue':'' }" title="过渡费"><i class="icon-yen"></i></a>
									</c:if>
									<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">
									<a href="./EditRecord?id=${vo.id }" class="btn mini btn-edit" title="编辑"><i class="icon-pencil"></i></a>
									<!-- <a href="javascript:void(0)" class="btn mini black deleteBtn" title="删除"><i class="icon-remove"></i></a> -->
									</c:if>
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

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button>
        <h4 class="modal-title" id="editModalLabel">本次还房信息：</h4>
      </div>
      <div class="modal-body form-horizontal">
        <div class="control-group">
			<label class="control-label">住宅房面积<span class="required"></span></label>
			<div class="controls">
				<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" name="houseArea" value="0.0" placeholder="住宅房面积（㎡）" type="text" class="m-wrap medium">
				<span class="help-inline">剩余 <span id="houseAreaRemain">0</span> ㎡</span>
			</div>
		</div>
		<div class="control-group" style="margin-top:30px;margin-bottom:30px">
			<label class="control-label">营业房面积<span class="required"></span></label>
			<div class="controls">
				<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" name="businessArea" value="0.0" placeholder="营业房面积（㎡）" type="text" class="m-wrap medium">
				<span class="help-inline">剩余 <span id="businessAreaRemain">0</span> ㎡</span>
			</div>
		</div>
		<!-- <div class="control-group">
			<label class="control-label">生产用房面积<span class="required"></span></label>
			<div class="controls">
				<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" name="productionArea" value="" placeholder="生产用房面积（㎡）" type="text" class="m-wrap medium">
				<span class="help-inline">剩余 <span id="productionAreaRemain">0</span> ㎡</span>
			</div>
		</div> -->
		<div class="control-group returnTime">
			<label class="control-label">还房时间<span class="required">*</span></label>
			<div class="controls">
				<input lhq-validate="[{required:true,msg:'还房时间涉及到后续过渡费计算，不能为空'}]" 
					 type="text" name="returnTime" placeholder="还房时间" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>" class="m-wrap medium"/>
			</div>
		</div>
      </div>
      <div class="modal-footer" style="margin-top:0;">
          <input type="hidden" id="recordId"/>
        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary btn-sm okBtn"><i class="icon icon-ok"></i> 确定</button>
      </div>
    </div>
  </div>
</div>

<script>

$(function(){
	//获取当前登录用户，用来判断当前数据项是否可改
			$.post("getCurrentUser", function(resp) {
				if (resp == "admin3") {
					$(".returnTime").hide();
				} 
			});
	$('input[name="returnTime"]').datepicker({
		format: 'yyyy-mm-dd',
		weekStart: 1,
		autoclose: true
	}).on('changeDate',function(ev){});
	
	// 删除记录
	$('.deleteBtn').click(function(){
		var tr = $(this).parents('tr');
		var id = tr.find('input[name="id"]').val();
		bootbox.confirm("<h4>警告：</h4>删除后不可恢复，确定要删除吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('请求正在被处理……');
				$.post("deleteRecord2?ajaxtag=1",{id:id},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return ;
					
					showMsg('删除成功！');
					tr.remove();
				});
			}
		});
	});

	// 单个交房
	$('.startBtn').click(function(){
		var id = $(this).parents('tr').find('input[name="id"]').val();
		bootbox.confirm("<h4>提示：</h4>确定要设置该记录为已交房状态吗？","取消","确定", function(isOK){
			if(isOK){
				$.post("changeStatusRecord?ajaxtag=1",{id: id, status: true, start: true},function(resp){
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>设置为已交房状态成功！',"确定", function(){
						location.reload();
					})
				});
			}
		});
	});
	
	// 暂停计算过渡费
	$('.doPauseCalculateFeeBtn').click(function(){
		var id = $(this).parents('tr').find('input[name="id"]').val();
		bootbox.confirm("<h4>提示：</h4>确定要设置该记录暂停计算过渡费吗？","取消","确定", function(isOK){
			if(isOK){
				$.post("changeStatusRecord?ajaxtag=1",{id: id,pauseCalculateFee:true},function(resp){
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>设置为暂停状态成功！',"确定", function(){
						location.reload();
					})
				});
			}
		});
	});
	// 恢复计算过渡费
	$('.doNotPauseCalculateFeeBtn').click(function(){
		var id = $(this).parents('tr').find('input[name="id"]').val();
		bootbox.confirm("<h4>提示：</h4>确定要设置该记录恢复计算过渡费吗？","取消","确定", function(isOK){
			if(isOK){
				$.post("changeStatusRecord?ajaxtag=1",{id: id,pauseCalculateFee:false},function(resp){
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>设置为恢复状态成功！',"确定", function(){
						location.reload();
					})
				});
			}
		});
	});
	
	
	// 单个还房
	$('.endBtn').click(function(){
		//TODO
		var id = $(this).parents('tr').find('input[name="id"]').val();
		loadingModal('初始化中，请稍等...');
		$.post("./recordJson?ajaxtag=1", {id: id}, function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return false;
			
			var data = resp.data;
			$('#houseAreaRemain').text((data.houseArea || 0) - (data.actualBackHouseArea || 0));
			$('#businessAreaRemain').text((data.businessArea || 0) - (data.actualBackBusinessArea || 0));
			$('#editModal input[name="houseArea"]').val("");
			$('#editModal input[name="businessArea"]').val("");
			$('#recordId').val(id);
			$('#editModal').modal('show');
		});
	});
	$('.okBtn').click(function(){
		var id =$('#recordId').val();
		var returnTime = $('#editModal input[name="returnTime"]').val();
		var houseArea = $('#editModal input[name="houseArea"]').val();
		var businessArea = $('#editModal input[name="businessArea"]').val();
		if(validateForm('#editModal')==false){
			flash('.validateErr');return ;
		}
		if(+houseArea*1 + businessArea>0){}else{
			shakeMsg('请至少填写一种类型的房子面积.');
			flash('#editModal input[name="houseArea"],#editModal input[name="businessArea"]');
			return;
		}
		$.post("./saveRecordReturn2?ajaxtag=1", {sid: id, returnTime: returnTime, houseArea: houseArea, businessArea: businessArea}, function(resp){
			if(checkResponse(resp)==false) return false;
			
			$('#editModal').modal('hide');
			if(resp.data==true){
				showMsg('提交成功, 该拆迁记录已全部还房.');
				$('input[name="id"][value="'+id+'"]').parents('tr').find('.endBtn').remove();
				/*
				$.post("./threeMonthFee?ajaxtag=1", {sid: id}, function(resp){
					console.log(resp);
				});
				*/
			}else{
				showMsg('提交成功.');
			}
		});
	});
	
	// 批量删除
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
				$.post("deleteRecord3?ajaxtag=1",{ids: ids},function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>'+(resp.message||'删除成功！'),"确定", function(){
						location.reload();
					})
				});
			}
		});
	});
	
	// 批量交房
	$('.batchStartBtn').click(function(){
		var ids = '';
		if($('input[name="checkAll"]:not(:disabled)').length<1){
			showMsg('暂无记录需要交房!');
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
		bootbox.confirm("<h4>提示：</h4>确定要设置所选择记录为已交房状态吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('服务响应中，请稍等....');
				$.post("changeStatusRecord3?ajaxtag=1",{ids: ids, status: true, start: true },function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>设置为已交房状态成功！',"确定", function(){
						location.reload();
					})
				});
			}
		});
	});
	/*
	$('.batchEndBtn').click(function(){
		var ids = '';
		if($('input[name="checkAll"]:not(:disabled)').length<1){
			showMsg('暂无记录需要还房!');
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
		bootbox.confirm("<h4>提示：</h4>确定要设置所选择记录为已还房状态吗？","取消","确定", function(isOK){
			if(isOK){
				loadingModal('服务响应中，请稍等....');
				$.post("changeStatusRecord3?ajaxtag=1",{ids: ids, status: true, start: false },function(resp){
					loadingModal();
					if(checkResponse(resp)==false) return false;
					bootbox.alert('<h4>提示：</h4>设置为已还房状态成功！',"确定", function(){
						location.reload();
					})
				});
			}
		});
	});*/
	
	// 导入合同
	$('#importExcelFile').on('change',function(){
		loadingModal('导入中，请稍等....',600000);
		ajaxUploadFile("./upload?type=import&ajaxtag=1", this, function(resp){
			if(resp.indexOf('.xls')==-1 && resp.indexOf('.xlsx') ==-1){
				loadingModal();
				shakeMsg('仅支持.xls和.xlsx文件导入！');return;
			}
			$.post("./importFile?ajaxtag=1",{path: "/"+resp},function(resp){
				loadingModal();
				alert(resp.message);
				location.reload();
				// if(checkResponse(resp)==false) return;
				
				// bootbox.alert("<h4>提示：</h4>"+resp.message,"确定", function(){
					// location.reload();
				// });
			});
		});
	});
	
	
	// 导入还房信息
	$('#importReturnArea').on('change',function(){
		loadingModal('导入中，请稍等....',600000);
		ajaxUploadFile("./upload?type=import&ajaxtag=1", this, function(resp){
			if(resp.indexOf('.xls')==-1 && resp.indexOf('.xlsx') ==-1){
				loadingModal();
				shakeMsg('仅支持.xls和.xlsx文件导入！');return;
			}
			$.post("./importReturnArea?ajaxtag=1",{path: "/"+resp},function(resp){
				loadingModal();
				
				/*
				if(checkResponse(resp)==false) return;
				
				bootbox.alert("<h4>提示：</h4>"+resp.message,"确定", function(){
					location.reload();
				});
				*/				
				alert(resp.message);
				location.reload();
			});
		});
	});
	
	// 导入过渡费
	$('#importExcelFile2').on('change',function(){
		loadingModal('导入中，请稍等....',600000);
		ajaxUploadFile("./upload?type=import&ajaxtag=1", this, function(resp){
			if(resp.indexOf('.xls')==-1||resp.indexOf('.xlsx')!=-1){
				loadingModal();
				shakeMsg('仅支持.xls文件导入！');return;
			}
			$.post("./importFile2?ajaxtag=1",{path: "/"+resp},function(resp){
				loadingModal();
				if(checkResponse(resp)==false) return;
				
				bootbox.alert(resp.message,"确定", function(){
					location.reload();
				});
			});
		});
	});
	
	// 导出合同
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
	});
	
	// 导出过渡费
	$('.exportExcelBtn2').click(function(){
		var dialog = bootbox.dialog('<strong>提示：</strong>选择全部记录可能会需要很长时间，以至导出失败，请慎重！', 
				[{
					'label': "<i class='icon icon-th-large white'></i> 全部记录", 
					'class': "btn-primary",
					'callback': function(){
						exportData2(3);
						return true;
					}
				},{
					'label': "<i class='icon icon-th-list white'></i> 本页所有", 
					'class': "btn-primary",
					'callback': function(){
						exportData2(2);
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
						exportData2(1, ids);
						return true;
					}
				}],
				{header:'请选择导出模式'}
		).addClass('exportModal');
	});
});

function exportData(type, ids){
	ids = ids || '';
	var url = "./Export1?type="+type+"&ids="+ids;
	var p = $('.searchForm input[name="p"]').val();
	var ps = $('.searchForm input[name="ps"]').val();
	var keyword = $('.searchForm input[name="keyword"]').val().trim();
	var uid = $('.searchForm input[name="uid"]').val();
	var pid = $('.searchForm [name="pid"]').val();
	var started = $('.searchForm [name="started"]').val();
	var ended = $('.searchForm [name="ended"]').val();
	var status = $('.searchForm [name="status"]').val();
	var replaceFlag = $('.searchForm [name="status"]').val();
	if(p!='') url += "&p="+p;
	if(ps!='') url += "&ps="+ps;
	if(started!='') url += "&started="+started;
	if(ended!='') url += "&ended="+ended;
	if(status!='') url += "&status="+status;
	if(replaceFlag!='') url += "&replaceFlag="+replaceFlag;
	if(uid && uid!='') url += "&uid="+uid;
	if(pid && pid!='') url += "&pid="+pid;
	if(keyword!='') url += "&keyword="+encodeURIComponent(keyword);
	window.open(url);
}
function exportData2(type, ids){
	ids = ids || '';
	var url = "./Export2?type="+type+"&ids="+ids;
	var p = $('.searchForm input[name="p"]').val();
	var ps = $('.searchForm input[name="ps"]').val();
	var keyword = $('.searchForm input[name="keyword"]').val().trim();
	var uid = $('.searchForm input[name="uid"]').val();
	var pid = $('.searchForm [name="pid"]').val();
	var replaceFlag = $('.searchForm [name="status"]').val();
	if(p!='') url += "&p="+p;
	if(ps!='') url += "&ps="+ps;
	if(uid && uid!='') url += "&uid="+uid;
	if(pid && pid!='') url += "&pid="+pid;
	if(keyword!='') url += "&keyword="+encodeURIComponent(keyword);
	if(replaceFlag!='') url += "&replaceFlag="+replaceFlag;
	window.open(url);
}
</script>


</body>
</html>