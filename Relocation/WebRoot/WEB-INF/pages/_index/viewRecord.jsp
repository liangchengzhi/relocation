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
.detailGroup{
	vertical-align: middle !important;
	text-align: center !important;
	font-weight: bold;
}
#recordDetails td{
	vertical-align: middle !important;
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
				拆迁记录详情 <small>查看指定的拆迁记录</small>
				<button class="btn pull-right goBackBtn"><i class="icon icon-share-alt"></i> 返回</button>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">拆迁管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">拆迁记录详情</a></li>
			</ul>
		</div>
	</div>
	
	<div class="row-fluid">
		<div class="span12">
			<div class="portlet box grey" style="border-top:1px solid #9d9c9c">
				<div class="portlet-body form" style="overflow: hidden;">
					<div class="form-horizontal">
						<div class="row-fluid"><div class="span12">
						<table id="recordDetails" class="table">
							<tr>
								<td rowspan="3" class="detailGroup">被拆迁人信息</td>
								<td class="nowrap">姓名</td>
								<td>
									${entity.username }
									<span class="gray">
										（手机号：${empty entity.usercontact?'未填写':entity.usercontact } &nbsp;
										身份证：${empty entity.useridcard?'未填写':entity.useridcard }）
									</span>
								</td>
							</tr>
							<tr>
								<td class="nowrap">银行账户</td>
								<td>${empty entity.bankAccount?'(未填写)':entity.bankAccount }</td>
							</tr>
							<tr>
								<td class="nowrap">村、组</td>
								<td>${empty entity.useraddress?'(未填写)':entity.useraddress }</td>
							</tr>
							
							<tr class="odd">
								<td rowspan="4" class="detailGroup">项目合同</td>
								<td class="nowrap">合同编号</td>
								<td>${entity.contractNumber }</td>
							</tr>
							<tr class="odd">
								<td class="nowrap">备案编号</td>
								<td>${entity.recordNumber }</td>
							</tr>
							<tr class="odd">
								<td class="nowrap">项目名称</td>
								<td>${entity.projectName }</td>
							</tr>
							<tr class="odd">
								<td class="nowrap">填报单位</td>
								<td>${entity.cuser.nickname }</td>
							</tr>
							<tr>
								<td rowspan="3" class="detailGroup">
									原房信息
									<div class="gray" style="margin-top:10px">合计 <span class="blue">${empty entity.coveredArea?0:entity.coveredArea }</span> ㎡</div>
								</td>
								<td class="nowrap">住宅房面积</td>
								<td>
									<c:if test="${not empty entity.houseArea }">
									${entity.houseArea} ㎡
									</c:if>
									<c:if test="${empty entity.houseArea }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">营业房面积</td>
								<td>
									<c:if test="${not empty entity.businessArea }">
									${entity.businessArea} ㎡
									</c:if>
									<c:if test="${empty entity.businessArea }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">生产房面积</td>
								<td>
									<c:if test="${not empty entity.productionArea }">
									${entity.productionArea}
									</c:if>
									<c:if test="${empty entity.productionArea }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr class="odd">
								<td rowspan="4" class="detailGroup">还房与补偿</td>
								<td class="nowrap">住宅房</td>
								<td>
									<c:if test="${not empty entity.houseAreaBack }">
									${entity.houseAreaBack} ㎡ （${entity.houseAreaBackRoom }）
									</c:if>
									<c:if test="${empty entity.houseAreaBack }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr class="odd">
								<td class="nowrap">营业房</td>
								<td>
									<c:if test="${not empty entity.businessAreaBack }">
									${entity.businessAreaBack} ㎡ （${entity.businessAreaBackRoom }）
									</c:if>
									<c:if test="${empty entity.businessAreaBack }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr class="odd">
								<td class="nowrap">安置补偿</td>
								<td>
									<c:if test="${not empty entity.balance1 and entity.balance1 gt 0 }">
									${entity.balance1} 元
									</c:if>
									<c:if test="${empty entity.balance1 or entity.balance1 le 0}">
									(无)
									</c:if>
								</td>
							</tr>
							<tr class="odd">
								<td class="nowrap">被拆迁人补偿</td>
								<td>
									<c:if test="${not empty entity.balance2 and entity.balance2 gt 0 }">
									${0 - entity.balance2} 元
									</c:if>
									<c:if test="${empty entity.balance2 or entity.balance2 le 0}">
									(无)
									</c:if>
								</td>
							</tr>
							
							<tr>
								<td rowspan="3" class="detailGroup">其他</td>
								<td class="nowrap">自拆面积</td>
								<td>
									<c:if test="${not empty entity.selfRemoveArea}">
									${entity.selfRemoveArea} ㎡
									</c:if>
									<c:if test="${empty entity.selfRemoveArea}">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">自拆金额</td>
								<td>
									<c:if test="${not empty entity.selfRemoveAmount}">
									${entity.selfRemoveAmount} 元
									</c:if>
									<c:if test="${empty entity.selfRemoveAmount}">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">备注</td>
								<td>${empty entity.remark?'无':entity.remark }</td>
							</tr>
						</table>
						</div></div>
						<div class="row-fluid"><div class="span12">
						<strong>还房情况</strong> （合同还房截止日期: <fmt:formatDate value="${entity.endTime.getTime()}" pattern="yyyy-MM-dd"/>）
						</div></div>
						<div class="row-fluid"><div class="span12">
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<tr>
								<th class="nowrap">序号</th>
								<th class="center">住宅房面积（㎡）</th>
								<th class="center">营业房面积（㎡）</th>
								<th class="center">生产房面积（㎡）</th>
								<th class="center">还房时间</th>
								<th class="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${returnList }" var="vo" varStatus="i">
								<tr class="${i.count%2 eq 0?'even':'odd'}">
								<td class="nowrap">${i.count}</td>
								<td class="center">${empty vo.houseArea?"":vo.houseArea }</td>
								<td class="center">${empty vo.businessArea?"":vo.businessArea }</td>
								<td class="center">${empty vo.productionArea?"":vo.productionArea }</td>
								<td class="center"><fmt:formatDate value="${vo.returnTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								</tr>
							</c:forEach>
							<c:if test="${empty returnList }">
								<tr>
									<td colspan="10" class="center">暂无还房记录</td>
								</tr>
							</c:if>
							</tbody>
						</table>
						</div></div>
						
						<div class="row-fluid"><div class="span12">
						<strong>过渡费发放情况</strong> （合同起止日期: <fmt:formatDate value="${entity.startTime.getTime()}" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${entity.endTime.getTime()}" pattern="yyyy-MM-dd"/>）
						</div></div>
						<div class="row-fluid"><div class="span12">
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<tr>
								<th class="nowrap">序号</th>
								<th class="center">状态</th>
								<th class="center">类型</th>
								<th class="center">首次起始日期</th>
								<th class="center">首次截止日期</th>
								<th class="center">起始日期</th>
								<th class="center">截止日期</th>
								<th class="center">首次过渡费</th>
								<th class="center">正常过渡费</th>
								<th class="center">逾期补偿</th>
								<th class="center">补发3个月</th>
								<th class="center">本次过渡费和</th>
								<th class="center nowrap">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${transitionfeeList }" var="vo" varStatus="i">
								<tr class="${i.count%2 eq 0?'even':'odd'}">
								<td class="nowrap">${i.count}</td>
								<td class="center">
									<c:if test="${vo.isDealed != null and vo.isDealed==true }">
										<label class="isdealed label">已付款</label>
									</c:if>
									<c:if test="${vo.isDealed == null or vo.isDealed==false }">
										<label class="isdealed label label-success">未付款</label>
									</c:if>
								</td>
								<td class="center">${vo.type}</td>
								<td class="center"><fmt:formatDate value="${vo.firstStartTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center"><fmt:formatDate value="${vo.firstEndTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center"><fmt:formatDate value="${vo.startTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center"><fmt:formatDate value="${vo.endTime.getTime()}" pattern="yyyy-MM-dd"/></td>
								<td class="center">￥ ${empty vo.firstFee?0:vo.firstFee }</td>
								<td class="center money">￥ ${empty vo.fee?0:vo.fee }</td>
								<td class="center money">￥ ${empty vo.overdueFee?0:vo.overdueFee }</td>
								<td class="center">￥ ${empty vo.threeMonthFee?0:vo.threeMonthFee }</td>
								<td class="center">￥ ${empty vo.quarterFee?0:vo.quarterFee }</td>
								<td class="center nowrap">
									<input type="hidden" name="id" value="${vo.id }"/>
									<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('过渡费计算与结算')}">
									<c:if test="${vo.isDealed != null and vo.isDealed==true }">
										<button disabled class="btn mini green disabled"><i class="icon-ok"></i> 付款</button>
									</c:if>
									<c:if test="${vo.isDealed == null or vo.isDealed==false }">
										<button  class="btn mini green toDealBtn"><i class="icon-ok"></i> 付款</button>
									</c:if>
									</c:if>
								</td>
								</tr>
							</c:forEach>
							<c:if test="${empty transitionfeeList }">
								<tr>
									<td colspan="10" class="center">暂无过渡费发放记录</td>
								</tr>
							</c:if>
							</tbody>
						</table>
						</div></div>
					</div>
					<div class="">
						<button type="button" class="btn pull-right goBackBtn">返回</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$('#recordDetails td').addclass4text('(未填写)','gray');
	$('#recordDetails td').addclass4text('(无)','gray');
	
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
					
					tr.find('label.isdealed').removeClass('label-success');
					tr.find('.toDealBtn').removeClass('toDealBtn')
						.addClass('disabled')
						.attr('disabled','');
				});
			}
		});
	});
});
</script>
</body>
</html>