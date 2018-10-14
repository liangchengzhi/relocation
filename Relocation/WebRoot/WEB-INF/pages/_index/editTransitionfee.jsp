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
@media (min-width: 768px) {
	.totalArea{
		color: #d85030;
		font-size:20px; 
		height:150px; 
		line-height:150px;
		margin-left: 180px;
	}
}
@media (max-width: 768px) {
	.totalArea{
		color: #d85030;
		font-size:20px; 
		margin-left: 180px;
	}
}
@media (max-width: 480px){
	.totalArea{
		margin-left: 0;
	}
}
.open>.dropdown-menu{
	padding-right: 10px;
}
</style>
</head>
<body>

<div class="container-fluid" nav-menu="recordList">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				<c:if test="${empty entity.id }">
				新增过渡费信息 <small>可以添加新的过渡费信息</small>
				</c:if>
				<c:if test="${not empty entity.id }">
				编辑过渡费信息 <small>可以修改已添加的过渡费信息</small>
				</c:if>
				<label class="green btn pointer pull-right" style="line-height:30px;">
					<i class="icon-circle-arrow-up"></i> Excel导入
           			<input id="importExcelFile" type="file" class="hidden"/>
           		</label>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">拆迁管理</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="./ListRecord">过渡费记录</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">${empty entity.id?'新增':'编辑'}过渡费信息</a></li>
			</ul>
		</div>
	</div>
	
	<div class="row-fluid">
		<div class="span12">
			<div class="alert alert-info" style="margin-bottom: 0;margin-top:10px"><strong>提示：</strong>必须先添加对应合同编号的拆迁记录。</div>
		</div>
	</div>
	
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c">
				<div class="portlet-body form" style="overflow: hidden;">
					<form class="form-horizontal editF">
						<input type="hidden" name="id" value="${entity.id }"/>
						<input type="hidden" name="total" value="${empty entity.total?0:entity.total }"/>
						<h4 class="form-section">
							基本信息
							<div class="pull-right" style="font-weight: bold;font-size: 20px;">填报单位：${entity.cuser.nickname }</div>
						</h4>
						<div class="row-fluid"><div class="span6">
							<div class="control-group">
								<label class="control-label">合同编号<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										name="contractNumber" value="${entity.contractNumber }" readonly  placeholder="合同编号" type="text" class="m-wrap medium" />
								</div>
							</div>
						</div><div class="span6">
							<div class="control-group">
								<label class="control-label">备案编号<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										name="recordNumber" value="${entity.recordNumber }"   placeholder="备案编号" type="text" class="m-wrap medium" />
								</div>
							</div>
						</div></div>					
						
						<div class="row-fluid"><div class="span6">
							<div class="control-group">
								<label class="control-label">项目名称<span class="required">*</span></label>
								<div class="controls dropdown">
									<input id="projectName" lhq-validate="[{required:true, msg:'',msg:''}]" 
										name="projectName" value="${entity.projectName }"   placeholder="项目名称" type="text" class="m-wrap medium" 
										data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
									<ul id="projectNameList" class="dropdown-menu" aria-labelledby="projectName"></ul>
								</div>
							</div>
						</div><div class="span6">
							<div class="control-group">
								<label class="control-label">姓名<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										name="username" value="${entity.username }"   placeholder="姓名" type="text" class="m-wrap medium" />
								</div>
							</div>
						</div></div>
						<div class="row-fluid"><div class="span6">
							<div class="control-group">
								<label class="control-label">联系方式<span class="required"> </span></label>
								<div class="controls">
									<input lhq-validate="[]" 
										name="usercontact" value="${entity.usercontact }"   placeholder="联系方式" type="text" class="m-wrap medium" />
								</div>
							</div>
						</div><div class="span6">
							<div class="control-group">
								<label class="control-label">村、组<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
									name="useraddress" value="${entity.useraddress }"   placeholder="详细地址" type="text" class="m-wrap medium" />
								</div>
							</div>
						</div></div>
						<div id="timeRangeSection" class="row-fluid"><div class="span6">
							<div class="control-group">
								<label class="control-label">交房截止时间<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										readonly type="text" placeholder="交房截止时间" value="<fmt:formatDate value="${entity.startTime.getTime()}" pattern="yyyy-MM-dd"/>" class="m-wrap medium"/>
								</div>
							</div>
						</div><div class="span6">
							<div class="control-group">
								<label class="control-label">还房截止时间<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										readonly type="text" placeholder="还房截止时间" value="<fmt:formatDate value="${entity.endTime.getTime()}" pattern="yyyy-MM-dd"/>" class="m-wrap medium"/>
								</div>
							</div>
						</div></div>
						
						<h4 class="form-section">安置补偿、过渡费(元)</h4>
						<div id="timeRangeSection" class="row-fluid"><div class="span6">
							<div class="control-group">
								<label class="control-label">首次过渡费开始<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										readonly type="text" id="firstStartTime" name="firstStartTime" placeholder="首次过渡开始" value="<fmt:formatDate value="${entity.firstStartTime.getTime()}" pattern="yyyy-MM-dd"/>" class="m-wrap medium"/>
								</div>
							</div>
						</div><div class="span6">
							<div class="control-group">
								<label class="control-label">首次过渡费日期<span class="required">*</span></label>
								<div class="controls">
									<input lhq-validate="[{required:true, msg:''}]" 
										readonly type="text" id="firstEndTime" name="firstEndTime" placeholder="过渡结束日期" value="<fmt:formatDate value="${entity.firstEndTime.getTime()}" pattern="yyyy-MM-dd"/>" class="m-wrap medium"/>
								</div>
							</div>
						</div></div>
						<div class="row-fluid"><div class="span6" id="feeList">
							<div class="control-group">
								<label class="control-label">附属设施补偿费<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="facilityFee" value="${entity.facilityFee }"   placeholder="附属设施补偿费（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">交通费<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="transportFee" value="${entity.transportFee }"   placeholder="交通费（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">过渡费<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="transitionFee" value="${entity.transitionFee }"   placeholder="过渡费（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">搬家费<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="movingFee" value="${entity.movingFee }"   placeholder="过渡费（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">奖金<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="awardFee" value="${entity.awardFee }"   placeholder="奖金（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">停产停业补助<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="discontinuedFee" value="${entity.discontinuedFee }"   placeholder="停产停业补助（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">自拆费用<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="selfdemolitionFee" value="${entity.selfdemolitionFee }"   placeholder="自拆费用（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">其他费用<span class="required"></span></label>
								<div class="controls">
									<input lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]" 
										name="otherFee" value="${entity.otherFee }"   placeholder="其他费用（元）" type="text" class="m-wrap medium" />
								</div>
							</div>
						</div><div class="span6">
							<div class="totalArea">
								金额合计： <span id="areaSum" style="color:blue">${empty entity.total?0:entity.total }</span> 元
							</div>
						</div></div>
						
						<h4 class="form-section">其他信息</h4>
						<div class="row-fluid"><div class="span12">
							<div class="control-group">
								<label class="control-label">备注<span class="required"></span></label>
								<div class="controls">
									<textarea rows="4" name="remark"   placeholder="备注" class="m-wrap large">${entity.remark }</textarea>
								</div>
							</div>
						</div></div>
					</form>
					<div class="form-actions">
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
	$('#importExcelFile').on('change',function(){
		loadingModal('导入中，请稍等....',600000);
		ajaxUploadFile("./upload?type=import&ajaxtag=1", this, function(resp){
			if(resp.indexOf('.xls')==-1||resp.indexOf('.xlsx')!=-1){
				loadingModal();
				shakeMsg('仅支持.xls文件导入！');return;
			}
			$.post("./importFile2?ajaxtag=1",{path: resp},function(resp){
				loadingModal();
				if(checkResponse(resp)==false) return;
				
				bootbox.alert("<h4>提示：</h4>"+resp.message,"确定", function(){
					location.reload();
				});
			});
		});
	});
	
	$('.okBtn').click(function(){
		preventDefault(arguments[0]);
		if(validateForm('.editF')==false){
			flash('.editF .validateErr');
			return false;
		}
		
		if($('input[name="total"]').val()*1==0){
			shakeMsg('安置补偿、过渡费金额合计为零！');
			
			var ind = location.href.indexOf('#');
			location.href = location.href.substring(0, ind==-1?location.href.length:ind) + '#timeRangeSection';
			$('input[name="facilityFee').focus();
			flash('input[name$="Fee"]');
			return false;
		}
		
    	var param = $('.editF').serializeObject();
    	loadingModal('正在处理中……');
		$.post("saveTransitionfee2?ajaxtag=1",param,function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			bootbox.alert('<h4>提示：</h4>保存成功。','确定',function(){
				var referer = $('input[name="referer"]');
				if(referer.length>0&&referer.val()!='')	window.location.href = referer.val();
			});
		});
	});
	var searchRecord = function(){
		var keyword = $(this).val().trim();
		if(keyword=='') return ;
		
		$.post("searchRecord?ajaxtag=1",{keyword: keyword},function(resp){
			if(checkResponse(resp)==false) return false;
			
			if(resp.data==null||resp.data.id==null) return false;
			
			$('input[name="sid"]').val(resp.data.id);
			$('input[name="recordNumber"]').val(resp.data.recordNumber);
			$('input[name="projectName"]').val(resp.data.projectName);
			$('input[name="username"]').val(resp.data.username);
			$('input[name="contact"]').val(resp.data.usercontact);
			$('input[name="address"]').val(resp.data.useraddress);
			$('input[name="startTime"]').val(new Date(resp.data.startTime).format('yyyy-MM-dd'));
			$('input[name="endTime"]').val(new Date(resp.data.endTime).format('yyyy-MM-dd'));
		});
	};
	$('input[name="contractNumber"]').on('input',searchRecord).on('change',searchRecord).on('blur',searchRecord);
	
	$('input[name$="Fee"]').on('input',function(){
		computeSumArea();
	}).on('change',function(){
		computeSumArea();
	}).on('blur',function(){
		computeSumArea();
	});
	$('input[name$="Fee"]').each(function(){
		$(this).val(formatCurrency($(this).val()*1).replace(/(,| )/g, ''));
	});
	computeSumArea();
	
	$('input[name="projectName"]').on('input',searchProject).on('change',searchProject).on('click',searchProject);
	
	$.fn.datepicker.dates['en'] = {
	    days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
	    daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
	    monthsShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
	    today: "今天",
    	months: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
    	daysMin: ['日','一','二','三','四','五','六']
	};
	$('#firstStartTime, #firstEndTime').datepicker({
		format: 'yyyy-mm-dd',
		weekStart: 1,
		autoclose: true
	}).on('changeDate',function(ev){});
	
});

function searchProject(){
	var pname = $('input[name="projectName"]').val().trim();
	$.post("searchProject?ajaxtag=1",{pname: pname},function(resp){
		$('#projectNameList').html('');
		for(var i=0; i<resp.data.length; i++){
			var d = resp.data[i];
			$('<li><a href="javascrip:void(0)"></a></li>').appendTo('#projectNameList')
				.find('a').attr('title',d.name).text('@ '+d.name).attr('pid',d.id)
				.click(function(){
					$('input[name="projectName"]').val($(this).attr('title'));
					validateInput('input[name="projectName"]');
				});
		}
		if($('.open>.dropdown-menu').length==0) $('#projectNameList').dropdown('toggle');
	});
}

function computeSumArea(){
	if(validateForm('#feeList', false)){
		var sum = 0;
		$('input[name$="Fee"]').each(function(){
			var v = $(this).val().trim();
			sum += 1.0*(v==''?0:v);
		});
		$('#areaSum').text(formatCurrency(sum));
		$('input[name="total"]').val(sum);
	}else{
		$('#areaSum').text('?');
		$('input[name="total"]').val(0);
	}
}
</script>
</body>
</html>