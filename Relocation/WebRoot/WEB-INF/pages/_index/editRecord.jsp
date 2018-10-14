<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String Title = "";
	Title = request.getHeader(Title);
%>
<html>
<head>

	<style>
	.editF .controls .forMsg {
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
	
	@media ( min-width : 768px) {
		.totalArea {
			color: #d85030;
			font-size: 20px;
			height: 150px;
			line-height: 150px;
			margin-left: 120px;
		}
	}
	
	@media ( max-width : 768px) {
		.totalArea {
			color: #d85030;
			font-size: 20px;
			margin-left: 180px;
		}
	}
	
	@media ( max-width : 480px) {
		.totalArea {
			margin-left: 0;
		}
	}
	
	.open>.dropdown-menu {
		padding-right: 10px;
	}
	</style>
	<script src="<%=path%>/js/idCard-validate.js" type="text/javascript"></script>
	
</head>
<body>

	<div class="container-fluid" nav-menu="recordEdit">
		<div class="row-fluid">
			<div class="span12">
				<h3 class="page-title">
					<c:if test="${empty entity.id }">
				新增拆迁信息 <small>可以添加新的拆迁信息</small>
					</c:if>
					<c:if test="${not empty entity.id }">
				编辑拆迁信息 <small>可以修改已添加的拆迁信息记录</small>
					</c:if>
					<label class="green btn pointer pull-right"
						style="line-height: 30px;"> <i
						class="icon-circle-arrow-up"></i> Excel导入 <input
						id="importExcelFile" type="file" class="hidden" />
					</label>
				</h3>
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="./Admin">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="javascript:void(0)">拆迁管理</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="javascript:void(0)">${empty
							entity.id?'新增':'编辑'}拆迁信息</a></li>
				</ul>
			</div>
		</div>

		<div class="row-fluid">
			<div class="span12">
				<div class="portlet box grey" style="border-top: 1px solid #9d9c9c">
					<div class="portlet-body form" style="overflow: hidden;">
						<form class="form-horizontal editF">
							<input type="hidden" name="id" value="${entity.id }" /> <input
								type="hidden" name="coveredArea"
								value="${empty entity.coveredArea?0:entity.coveredArea }" /> <input
								type="hidden" name="total"
								value="${empty entity.total?0:entity.total }" /> <input
								type="hidden" name="replaceAreaTotal"
								value="${empty entity.replaceAreaTotal?0:entity.replaceAreaTotal }" />

							<div id="accordion">
								<h4 class="form-section useratitle">
									基本信息
									<div class="pull-right"
										style="font-weight: bold; font-size: 20px;">填报单位：${entity.cuser.nickname}</div>
								</h4>
								<div class="useracontent">
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">项目名称<span
													class="required">*</span></label>
												<div class="controls dropdown">
													<input id="projectName"
														lhq-validate="[{required:true, msg:''}]"
														name="projectName" value="${entity.projectName }"
														placeholder="项目名称" type="text" class="m-wrap medium"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false" />
													<ul id="projectNameList" class="dropdown-menu"
														aria-labelledby="projectName"></ul>
													 <c:if test="${not empty last.id }">
														<span id="span_projectName" class="help-inline green" tooltip-title="上一条记录项目名称">上一条：${last.projectName
														}</span>
													</c:if> 
												</div>
											</div>
										</div>
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label ">合同编号<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]" id="contractNumber"
														name="contractNumber" value="${entity.contractNumber }"
														placeholder="合同编号" type="text" class="m-wrap medium" />
													<c:if test="${not empty last.id }">
														<span class="help-inline green contractNumber" id="span_contractNumber"
															tooltip-title="上一条记录合同编号">上一条：${last.contractNumber
														}</span>
													</c:if>
												</div>
											</div>
										</div>

									</div>

									<div class="row-fluid">
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">备案编号<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]" id="recordNumber"
														name="recordNumber" value="${entity.recordNumber }"
														placeholder="备案编号" type="text" class="m-wrap medium" />
													<c:if test="${not empty last.id }">
														<span class="help-inline green recordNumber" id="span_recordNumber"
															tooltip-title="上一条记录备案编号">上一条：${last.recordNumber
														}</span>
													</c:if>
												</div>
											</div>
										</div>
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">交房截止日期<span
													class="required">*</span></label>
												<div class="controls">
													<input onchange="onStartTimeChange()" lhq-validate="[{required:true, msg:''}]" type="text"
														id="startTime" name="startTime" placeholder="交房截止日期"
														value="<fmt:formatDate value="${entity.startTime.getTime()}" pattern="yyyy-MM-dd"/>"
														class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">姓名<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]"
														name="username" value="${entity.username }"
														placeholder="姓名" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">还房截止日期<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]"  type="text" id="endTime"
														name="endTime" placeholder="还房截止日期"
														value="<fmt:formatDate value="${entity.endTime.getTime()}" pattern="yyyy-MM-dd"/>"
														class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">联系方式<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]"
														name="usercontact" value="${entity.usercontact }"
														placeholder="联系方式" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>

										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">所在地<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]"
														name="useraddress" value="${entity.useraddress }"
														placeholder="详细地址" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<hr/>
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">首次过渡开始<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]"  type="text" id="firstStartTime"
														name="firstStartTime" placeholder="首次过渡开始"
														value="<fmt:formatDate value="${entity.firstStartTime.getTime()}" pattern="yyyy-MM-dd"/>"
														class="m-wrap medium" />
												</div>
											</div>
										</div>

										<div class="span6">
											<div class="control-group usera">
												<label class="control-label">首次过渡结束<span
													class="required">*</span></label>
												<div class="controls">
													<input lhq-validate="[{required:true, msg:''}]"  type="text" id="firstEndTime"
														name="firstEndTime" placeholder="首次过渡结束"
														value="<fmt:formatDate value="${entity.firstEndTime.getTime()}" pattern="yyyy-MM-dd"/>"
														class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid " id="usera">
										<div class="span6" id="feeList">
											<div class="control-group usera">
												<label class="control-label ">首次过渡费</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="transitionFee" value="${entity.transitionFee }"
														placeholder="附属设施补偿费（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>
											<div class="control-group usera">
												<label class="control-label ">附属设施补偿费</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="facilityFee" value="${entity.facilityFee }"
														placeholder="附属设施补偿费（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>
											<div class="control-group usera">
												<label class="control-label">交通费</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="transportFee" value="${entity.transportFee }"
														placeholder="交通费（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>
											
											<div class="control-group usera">
												<label class="control-label">搬家费</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="movingFee" value="${entity.movingFee }"
														placeholder="交通费（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>
											<div class="control-group usera">
												<label class="control-label">奖金</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="awardFee" value="${entity.awardFee }"
														placeholder="奖金（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>
											<div class="control-group usera">
												<label class="control-label">停产停业补助</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="discontinuedFee" value="${entity.discontinuedFee }"
														placeholder="停产停业补助（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>
											<div class="control-group usera">
												<label class="control-label">自拆费用</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="selfdemolitionFee"
														value="${entity.selfdemolitionFee }" placeholder="自拆费用（元）"
														type="text" class="m-wrap medium balance" />
												</div>
											</div>
											<div class="control-group usera">
												<label class="control-label">其他费用</label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="otherFee" value="${entity.otherFee }"
														placeholder="其他（元）" type="text"
														class="m-wrap medium balance" />
												</div>
											</div>


										</div>
										<div class="span6">
											<div class="totalArea">
												金额合计： <span id="areaSumTotal" style="color: blue">${empty
												entity.total?0:entity.total }</span>
												元
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group usera">

												<label class="control-label">备注<span
													class="required"></span></label>
												<div class="controls">
													<input lhq-validate="[]" name="remark"
														value="${entity.remark }" placeholder="备注" type="text"
														class="m-wrap large" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<h4 class="form-section useratitle">拆迁备案</h4>
								<div class="useracontent">
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">原住宅房面积<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="houseArea" value="${entity.houseArea }"
														placeholder="住宅房面积（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group userb">
												<label class="control-label">原营业房面积<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="businessArea" value="${entity.businessArea }"
														placeholder="营业房面积（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group userb">
												<label class="control-label">原生产用房面积<span
													class="required"></span></label>
												<div class="controls">
													<input name="productionArea"
														value="${entity.productionArea }" placeholder="生产用房面积（㎡）"
														type="text" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group userb">
												<label class="control-label">其他<span
													class="required"></span></label>
												<div class="controls">
													<input name="otherArea" value="${entity.otherArea}"
														placeholder="其他（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group userb">
												<label class="control-label"><span
													class="required"></span></label>
												<div class="controls">
													<input name="" value=""
														placeholder="" type="hidden" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group totalArea userb">
												房屋建筑面积小计： <span id="areaSum" style="color: blue">${empty
													entity.coveredArea?0:entity.coveredArea }</span>
												㎡
											</div>
										</div>


										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">住宅置换房面积<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														id="replaceHouseAreaBefore" name="replaceHouseAreaBefore" value="${entity.replaceHouseAreaBefore }"
														placeholder="住宅置换房面积（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group userb">
												<label class="control-label"><!--营业房置换面积--><span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="replaceBusinessAreaBefore" value="${entity.replaceBusinessAreaBefore }"
														placeholder="营业房置换面积（㎡）" type="hidden" class="m-wrap medium" />
												</div>
											</div>
											

											<div class="control-group userb">
												<label class="control-label">住宅房置换门面<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="replaceHouseArea" id="replaceHouseArea"
														value="${entity.replaceHouseArea}"
														placeholder="住宅房置换面积（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group userb">
												<label class="control-label"><!--营业房置换门面--><span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="replaceBusinessArea"
														value="${entity.replaceBusinessArea }"
														placeholder="营业房置换面积（㎡）" type="hidden" class="m-wrap medium" />
												</div>
											</div>
											<div class="control-group totalArea userb">
												门面置换小计： <span id="replaceAreaTotal" style="color: blue">${empty
													entity.replaceAreaTotal?0:entity.replaceAreaTotal }</span>
												㎡
											</div>
										</div>
										</div>




									<div class="row-fluid">
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">拟还住宅房面积<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="houseAreaBack" value="${entity.houseAreaBack }"
														placeholder="还住宅房面积（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">还住宅房房号<span
													class="required"></span></label>
												<div class="controls">
													<input lhq-validate="[]" name="houseAreaBackRoom"
														value="${entity.houseAreaBackRoom }" placeholder="还住宅房房号"
														type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
										
									</div>
									
									<div class="row-fluid">
										
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">拟还营业房面积<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="businessAreaBack"
														value="${entity.businessAreaBack }"
														placeholder="还营业房面积（㎡）" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>

										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">还营业房房号<span
													class="required"></span></label>
												<div class="controls">
													<input lhq-validate="[]" name="businessAreaBackRoom"
														value="${entity.businessAreaBackRoom}"
														placeholder="还营业房房号" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									
									<!-- add by liangcz 添加实际还房信息 2016/10/11 begin  -->
									<div class="row-fluid">
										
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">实际还住宅房面积<span
													></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="actualBackHouseArea"
														value="${entity.actualBackHouseArea }"
														placeholder="实际还住宅房面积（㎡）" type="text" class="m-wrap medium" readonly />
												</div>
											</div>
										</div>

										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">实际还营业房面积<span
													></span></label>
												<div class="controls">
													<input lhq-validate="[]" name="actualBackBusinessArea"
														value="${entity.actualBackBusinessArea}"
														placeholder="实际还营业房面积（㎡）" type="text" class="m-wrap medium" readonly />
												</div>
											</div>
										</div>
									</div>
									<!-- add by liangcz 添加实际还房信息 2016/10/11 end  -->

									<div class="row-fluid">
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">100平米优惠 <span></span></label> <select
													class="m-wrap samll" id="areaBenefit100"
													name="areaBenefit100" style="width: 150px;">
													<option value=""></option>
													<option value="true"
														${areaBenefit100!=null && areaBenefit100==true?'selected':'' }>系统决定</option>
													<option value="false"
														${areaBenefit100!=null && areaBenefit100==false?'selected':'' }>不优惠</option>
												</select>
											</div>

										</div>
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">办事处管理 <span></span></label> 
												<select value="${entity.serviceDepartment }"
													class="m-wrap samll" id="serviceDepartment"
													name="serviceDepartment" style="width: 150px;">
													<option value=""></option>
													<option value="01" >新蒲办</option>
													<option value="02" >新中办</option>
													<option value="03" >指挥部</option>
												</select>
											</div>
										</div>
									</div>

									<div class="row-fluid">
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">住房超出面积<span
													class="required"></span></label>
												<div class="controls">
													<input lhq-validate="lhq-validate="
														[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}" 
											name="overArea"
														value="${entity.overArea}" placeholder="住房超出面积" type="text"
														class="m-wrap medium" />
												</div>
											</div>

											<div class="control-group userb">
												<label class="control-label">营业房超出面积<span
													class="required"></span></label>
												<div class="controls">
													<input lhq-validate="lhq-validate="
														[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}" 
											name="overAreaBusiness"
														value="${entity.overAreaBusiness }" placeholder="营业房超出面积" type="text"
														class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">

										
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">安置补偿金额<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="balance1" value="${entity.balance1 }"
														placeholder="安置补偿金额（元）" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">被拆迁人补偿金额<span
													class="required"></span></label>
												<div class="controls">
													<input
														lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
														name="balance2" value="${entity.balance2 }"
														placeholder="被拆迁人补偿金额（元）" type="text"
														class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">自拆面积<span
													class="required"></span></label>
												<div class="controls">
													<input lhq-validate="[]" name="selfRemoveArea"
														value="${entity.selfRemoveArea }" placeholder="自拆面积（㎡）"
														type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
										<div class="span6">
											<div class="control-group userb">
												<label class="control-label">自拆金额 </span></label>
												<div class="controls">
													<input lhq-validate="[]" name="selfRemoveAmount"
														value="${entity.selfRemoveAmount }" placeholder="自拆金额（元）"
														type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<h4 class="form-section useratitle">银行信息</h4>
								<div class="useracontent">
									<div class="row-fluid " id="userc">
										<div class="span6">
											<div class="control-group userc">
												<label class="control-label ">银行账户<span
													class="required"></span></label>
												<div class="controls">
													<input name="bankAccount" value="${entity.bankAccount }"
														placeholder="银行账户" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
										<div class="span6">
											<div class="control-group userc">
												<label class="control-label">身份证号<span
													class="required">*</span></label>
												<div class="controls">
													<input id="useridcard" onchange="on_useridcard_change(this.value)"
														name="useridcard" value="${entity.useridcard }"
														placeholder="身份证号" type="text" class="m-wrap medium" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</form>
						<div class="form-actions">
							<button type="button" class="btn blue okBtn">
								<i class="icon-ok"></i> 保存
							</button>
							<button type="button" class="btn goBackBtn">返回</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$(function() {
			
			$('#serviceDepartment').val("${entity.serviceDepartment }");
			
			//折叠菜单
			$("#accordion").accordion();
			var currentUser = null;
			var replaceBusinessRatio = null;
			var replaceHouseRatio = null;
			$.post("getSysConfig?ajaxtag=1", {
				id : "admin_record_config"
			}, function(resp) {
				if (resp.status == 0) {
					if (resp.data == '')
						return;
					resp.data = eval("(" + resp.data + ")");
					replaceBusinessRatio = resp.data["replaceBusinessRatio"];
					replaceHouseRatio = resp.data["replaceHouseRatio"];
				}
			});
			//获取当前登录用户，用来判断当前数据项是否可改
			$.post("getCurrentUser", function(resp) {
				currentUser = resp;
				if (resp == "admin") {
					$(".userb :input").attr("readonly", "readonly");
					$(".userc :input").attr("readonly", "readonly");
					$(".userbtitle").hide();
					$(".control-group").each(function(entityindex, entity) {
						if ($(this).hasClass("usera") == false) {
							$(this).hide();
						}
					})
				} else if (resp == "admin2") {
					$(".usera :input").attr("readonly", "readonly");
					$(".userc :input").attr("readonly", "readonly");
					$("#userc").hide();
					$("#accordion").accordion({
						active : 1
					});
				} else if (resp == "admin3") {
					$(".usera :input").attr("readonly", "readonly");
					$(".userb :input").attr("readonly", "readonly");
					$("#accordion").accordion({
						active : 2
					});

				}
			});

			$('#importExcelFile').on(
					'change',
					function() {
						loadingModal('导入中，请稍等....', 600000);
						ajaxUploadFile("./upload?type=import&ajaxtag=1", this,
								function(resp) {
									if (resp.indexOf('.xls') == -1
											&& resp.indexOf('.xlsx') == -1) {
										loadingModal();
										shakeMsg('仅支持.xls和.xlsx文件导入！');
										return;
									}
									$.post("./importFile?ajaxtag=1", {
										path : resp
									}, function(resp) {
										loadingModal();
										if (checkResponse(resp) == false)
											return;

										bootbox.alert("<h4>提示：</h4>"
												+ resp.message, "确定",
												function() {
													location.reload();
												});
									});
								});
					});

			$('input[name="contractNumber"]').on("blur", function() {
				var val = $(this).val().trim();
				if (val == '')
					return;
				$.post("./checkContractNumber?ajaxtag=1", {
					number : val,
					type : 1,
					id : $('input[name="id"]').val()
				}, function(resp) {
					if (resp.data == true) {
						flash('input[name="contractNumber"]');
						shakeMsg('合同编号已存在.');
					}
				});
			});

			$('.okBtn')
					.click(
							function() {
								console.log("ok...");
								preventDefault(arguments[0]);
								console.log("prevent...");
								if (validateForm('.editF') == false) {
									console.log("validate...");
									flash('.editF .validateErr');
									//return false;
								}

								var param = $('.editF').serializeObject();
								console.log("edit.....");
								loadingModal('正在处理中……');
								$
										.post(
												"./checkContractNumber?ajaxtag=1",
												{
													number : $(
															'input[name="contractNumber"]')
															.val().trim(),
													type : 1,
													id : $('input[name="id"]')
															.val()
												},
												function(resp) {
													console.log(resp);
													if ((currentUser != "admin2"
															|| currentUser != "admin3" || currentUser != "admin4")
															&& resp.data == true) {
														loadingModal();
														$(
																'input[name="contractNumber"]')
																.focus();
														flash('input[name="contractNumber"]');
														shakeMsg('合同编号已存在.');
														return;
													}
													console.log('000000');
													$
															.post(
																	"saveRecord2?ajaxtag=1",
																	param,
																	function(
																			resp) {
																		loadingModal();
																		if (checkResponse(resp) == false)
																			return;
																		bootbox
																				.alert(
																						'<h4>提示：</h4>保存成功。',
																						'确定',
																						function() {
																							var referer = $('input[name="referer"]');
																							if (referer.length > 0
																									&& referer
																											.val() != '')
																								window.location.href = referer
																										.val();
																						});
																	});
												});

							});
			$('input[name$="Fee"]').on('input', function() {
				computeSumTotal();
			}).on('change', function() {
				computeSumTotal();
			}).on('blur', function() {
				computeSumTotal();
			});

			$('input[name="houseArea"],input[name="businessArea"]').on('input',
					function() {
						computeSumArea();
					}).on('change', function() {
				computeSumArea();
			}).on('blur', function() {
				computeSumArea();
			});
			$('input[name="replaceHouseAreaBefore"],input[name="replaceBusinessAreaBefore"]').on('input',
					function() {
						computeBeforeArea();
					}).on('change', function() {
						computeBeforeArea();
			}).on('blur', function() {
				computeBeforeArea();
			});
			
			//住房营业房面积为空默认禁用置换面积
			$('input[name="replaceBusinessArea"]').attr("disabled", true);
			$('input[name="replaceHouseArea"]').attr("disabled", true);
			
			//置换面积
			$('input[name="replaceBusinessArea"]')
					.on('blur', function() {
						computeSumReplaceArea();
						computeOverAreaBusiness();
					});
			$('input[name="replaceHouseArea"]')
				.on('change', function() {
					computeSumReplaceArea();
					computeOverArea();
				});
			//还住宅面积
			$('input[name="houseAreaBack"]')
			.on('input', function() {
				computeOverArea();
			}).on('change', function() {
				computeOverArea();
			}).on('blur', function() {
				computeOverArea();
			});
			//还营业房面积
			$('input[name="businessAreaBack"]')
			.on('input', function() {
				computeOverAreaBusiness();
			}).on('change', function() {
				computeOverAreaBusiness();
			}).on('blur', function() {
				computeOverAreaBusiness();
			});
			
			$('input[name$="Fee"]').each(
					function() {
						$(this).val(
								formatCurrency($(this).val() * 1).replace(
										/(,| )/g, ''));
					});
			$(
					'input[name$="Area"],input[name$="AreaBack"],input[name^="balance1"],input[name^="balance2"]')
					.each(
							function() {
								$(this).val(
										formatCurrency($(this).val() * 1)
												.replace(/(,| )/g, ''));
							});
			computeSumTotal();
			computeSumArea();
			computeBeforeArea();
			computeSumReplaceArea();
			$('input[name="projectName"]').on('input', searchProject).on(
					'change', searchProject);

			$.fn.datepicker.dates['en'] = {
				days : [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" ],
				daysShort : [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
						"Sun" ],
				monthsShort : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				today : "今天",
				months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				daysMin : [ '日', '一', '二', '三', '四', '五', '六' ]
			};
			$('#startTime, #endTime, #firstStartTime, #firstEndTime').datepicker({
				format : 'yyyy-mm-dd',
				weekStart : 1,
				autoclose : true
			}).on('changeDate', function(ev) {
			});

		});

		function searchProject() {
			var pname = $('input[name="projectName"]').val().trim();
			$
					.post(
							"searchProject?ajaxtag=1",
							{
								pname : pname
							},
							function(resp) {
								$('#projectNameList').html('');
								for (var i = 0; i < resp.data.length; i++) {
									var d = resp.data[i];
									$(
											'<li id="projectlist"><a href="javascript:void(0)"></a></li>')
											.appendTo('#projectNameList')
											.find('a')
											.attr('title', d.name)
											.text('@ ' + d.name)
											.attr('pid', d.id)
											.click(function() {
														$('input[name="projectName"]').val($(this).attr('title'));
														validateInput('input[name="projectName"]');
														var pid = $(this).attr('pid');
														
														$.post("searchRecordByPid?ajaxtag=1",
																		{
																			keyword : pid
																		},
																		function(resp) {	
																			// alert(resp);
																			// var resp = $.parseJSON(resp);
																			var contractNumber = "";
																			var recordNumber = "";
																			var useraddress = "";
																			var remark = "";
																			var projectName = "";
																			if(resp && resp.data){
																				var data = resp.data;
																				projectName = "上一条：" + data.projectName;
																				contractNumber = "上一条：" + data.contractNumber;
																				recordNumber = "上一条：" + data.recordNumber;
																				useraddress = data.useraddress;
																				remark = data.remark;
																			}
																			
																			$("#span_projectName").text(projectName);
																			$("#span_contractNumber").text(contractNumber);
																			$("#span_recordNumber").text(recordNumber);
																			$("input[name='useraddress']").val(useraddress);
																			$("input[name='remark']").val(remark);
																			
																			
																		})
													});
								}
								
								if ($('.open>.dropdown-menu').length == 0)
									$('#projectNameList').dropdown('toggle');
								
							});
		}

		function computeSumTotal() {
			if (validateForm('#feeList', false)) {
				var sum = 0;
				$('input[name$="Fee"]').each(function() {
					var v = $(this).val().trim();
					sum += 1.0 * (v == '' ? 0 : v);
				});
				$('#areaSumTotal').text(formatCurrency(sum));
				$('input[name="total"]').val(sum);
			} else {
				$('#areaSumTotal').text('?');
				$('input[name="total"]').val(0);
			}
			computeOverAreaBusiness();
			computeOverArea();
		}
		var index = 0;
		function computeBeforeArea() {
			if (validateInput('input[name="replaceHouseAreaBefore"]')
					&& validateInput('input[name="replaceBusinessAreaBefore"]')) {
				var v1 = $('input[name="replaceHouseAreaBefore"]').val().trim();
				var v2 = $('input[name="replaceBusinessAreaBefore"]').val().trim();
				
				var v3 = $('input[name="houseArea"]').val().trim();
				var v4 = $('input[name="businessArea"]').val().trim();
				
				if(v1 != undefined && v1 > 0 && v3 != undefined){
					if(parseFloat(v1)>parseFloat(v3)){
						shakeMsg("置换面积大于原面积");
						return;
					}
				}
				if(v2 != undefined && v2 > 0 && v4 != undefined){
					if(parseFloat(v2)>parseFloat(v4)){
						shakeMsg("置换面积大于原面积");
						return;
					}
				}
				
				if(v1 != undefined && v1 > 0 && v2 != undefined && v2 > 0){
					index++;
					if(index>1){
						$('#replaceHouseAreaBefore').trigger("change");
					}
				}
				
				var val = $("#replaceHouseAreaBefore").val().trim();
				if(!val || val == 0){
					$("#replaceHouseAreaBefore").val(0);
					$("#replaceHouseArea").val(0);
					return;
				}
				$("#replaceHouseArea").val(val/2);
			} else {
			}
		}
		function computeSumArea() {
			if (validateInput('input[name="houseArea"]')
					&& validateInput('input[name="businessArea"]')) {
				var v1 = $('input[name="houseArea"]').val().trim();
				var v2 = $('input[name="businessArea"]').val().trim();
				var sum = 0 + (v1 == '' ? 0 : v1 * 1) + (v2 == '' ? 0 : v2 * 1);
				$('#areaSum').text(formatCurrency(sum));
				$('input[name="coveredArea"]').val(sum);
			} else {
				$('#areaSum').text('?');
				$('input[name="coveredArea"]').val(0);
			}
			computeOverAreaBusiness();
			computeOverArea();
		}
		function computeSumReplaceArea() {
			if (validateInput('input[name="replaceBusinessArea"]')
					&& validateInput('input[name="replaceHouseArea"]')) {
				var v1 = $('input[name="replaceBusinessArea"]').val().trim();
				var v2 = $('input[name="replaceHouseArea"]').val().trim();
				var sum = 0 + (v1 == '' ? 0 : v1 * 1) + (v2 == '' ? 0 : v2 * 1);
				$('#replaceAreaTotal').text(formatCurrency(sum));
				$('input[name="replaceAreaTotal"]').val(sum);
			} else {
				$('#replaceAreaTotal').text('?');
				$('input[name="replaceAreaTotal"]').val(0);
			}
			computeOverAreaBusiness();
			computeOverArea();
		}
		//超出面积（住房）
		function computeOverArea(){
			var houseArea = $('input[name="houseArea"]').val().trim();
			var replaceHouseAreaBefore = $('input[name="replaceHouseAreaBefore"]').val().trim();
			var houseAreaBack = $('input[name="houseAreaBack"]').val().trim();
			
			if(validateInput('input[name="houseArea"]') && validateInput('input[name="replaceHouseAreaBefore"]') && validateInput('input[name="houseAreaBack"]')){
				var overArea = houseAreaBack - (houseArea - replaceHouseAreaBefore);
				$('input[name="overArea"]').val(formatCurrency(overArea));
			}
		}
		//超出面积（营业房）
		function computeOverAreaBusiness(){
			var businessArea = $('input[name="businessArea"]').val().trim();
			var replaceBusinessAreaBefore = $('input[name="replaceBusinessAreaBefore"]').val().trim();
			var businessAreaBack = $('input[name="businessAreaBack"]').val().trim();
			
			if(validateInput('input[name="businessArea"]') && validateInput('input[name="replaceBusinessAreaBefore"]') && validateInput('input[name="businessAreaBack"]')){
				var overAreaBusiness = businessAreaBack - (businessArea - replaceBusinessAreaBefore);
				$('input[name="overAreaBusiness"]').val(formatCurrency(overAreaBusiness));
			}
		}
		//获取url参数
		function GetUrlParam(name){
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
		
		// 交房起始日期改变事件
		function onStartTimeChange(){
			var startTime = $("#startTime").val();
			var reg = new RegExp('^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$');
		    if(reg.test(startTime)){
		        var now = new Date(startTime);
		        $('#firstStartTime').val(now.Format("yyyy-MM-dd"));

		        now.addYears(2);
		        $('#endTime').val(now.Format("yyyy-MM-dd"));

		        var now = new Date(startTime); 
		        now.addMonths(6);
		        $('#firstEndTime').val(now.Format("yyyy-MM-dd"));
		    }
		}
		
		$('#firstStartTime').bind("change", function(){
		    var reg = new RegExp('^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$');
		    if(reg.test($(this).val())){
		        var now = new Date($(this).val());
		        $('#startTime').val(now.Format("yyyy-MM-dd"));

		        now.addYears(2);
		        $('#endTime').val(now.Format("yyyy-MM-dd"));

		        var now = new Date($(this).val()); 
		        now.addMonths(6);
		        $('#firstEndTime').val(now.Format("yyyy-MM-dd"));
		    }
		})
		
		
		// 校验身份证
		// 如果输入身份证正确，查看系统是否已经存在满足100平米优惠的拆迁记录，如果有，提示该户不再享受100平米优惠
		function on_useridcard_change(val){			
			var useridcard = val;
			if(!useridcard){
				shakeMsg("身份证不能为空");
				$(this).val('');
				return;
			}
			
			/*
			var clsIDCard = new clsIDCard(useridcard);
			if(!clsIDCard.IsValid()){
				shakeMsg("身份证输入非法");
				$(this).val('');
				return;
			}*/
			
			if(useridcard.length != 18 && useridcard.length != 15){
				shakeMsg("身份证输入非法");
				$(this).val('');
				return;
			}
			
			$.post("checkIfHadAreaBenefit100?ajaxtag=1",{useridcard : useridcard},
				function(resp) {
					if(resp.data > 0){
						$("#areaBenefit100").val('false');
						shakeMsg("该户已经有一拆迁记录符合100平米优惠，已把当前拆迁记录改为不优惠");
					}else{
						$("#areaBenefit100").val('true');
					}
				}
			);
			
		}
		
	</script>
</body>
</html>