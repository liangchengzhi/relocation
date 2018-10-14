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
#recordDetails .nowrap{
	text-align: right !important;
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

<div class="container-fluid" nav-menu=recordtransitionfeeList>
	<div class="row-fluid">
		<div class="span12">
			<h3 class="page-title">
				过渡费详情 <small>查看指定的过渡费记录</small>
				<button class="btn pull-right goBackBtn"><i class="icon icon-share-alt"></i> 返回</button>
			</h3>
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i> <a href="./Admin">首页</a> <i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="javascript:void(0)">拆迁管理</a> <i class="icon-angle-right"></i>
				</li>
				<li><a href="javascript:void(0)">过渡费详情</a></li>
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
										（身份证：${empty record.useridcard?'未填写':record.useridcard }）
									</span>
								</td>
							</tr>
							<tr>
								<td class="nowrap">手机号</td>
								<td>${empty entity.contact?'(未填写)':entity.contact }</td>
							</tr>
							<tr>
								<td class="nowrap">村、组</td>
								<td>${empty entity.address?'(未填写)':entity.address }</td>
							</tr>
							
							<tr class="odd">
								<td rowspan="5" class="detailGroup">项目合同</td>
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
							<tr class="odd">
								<td class="nowrap">起止时间</td>
								<td>
									<fmt:formatDate value="${entity.startTime.getTime()}" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${entity.endTime.getTime()}" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							<tr>
								<td rowspan="8" class="detailGroup">
									安置补偿、过渡费
									<div class="gray" style="margin-top:10px">合计 <span class="blue">${empty entity.total?0:entity.total }</span> 元</div>
								</td>
								<td class="nowrap">附属设施补偿费</td>
								<td>
									<c:if test="${not empty entity.facilityFee and entity.facilityFee gt 0 }">
									${entity.facilityFee} 元
									</c:if>
									<c:if test="${empty entity.facilityFee or entity.facilityFee lt 0.1}">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">交通费</td>
								<td>
									<c:if test="${not empty entity.transportFee and entity.transportFee gt 0 }">
									${entity.transportFee} 元
									</c:if>
									<c:if test="${empty entity.transportFee or entity.transportFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">过渡费</td>
								<td>
									<c:if test="${not empty entity.transitionFee and entity.transitionFee gt 0 }">
									${entity.transitionFee} 元
									</c:if>
									<c:if test="${empty entity.transitionFee or entity.transitionFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">搬家费</td>
								<td>
									<c:if test="${not empty entity.movingFee and entity.movingFee gt 0 }">
									${entity.movingFee} 元
									</c:if>
									<c:if test="${empty entity.movingFee or entity.movingFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">奖金</td>
								<td>
									<c:if test="${not empty entity.awardFee and entity.awardFee gt 0 }">
									${entity.awardFee} 元
									</c:if>
									<c:if test="${empty entity.awardFee or entity.awardFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">停产停业补助</td>
								<td>
									<c:if test="${not empty entity.discontinuedFee and entity.discontinuedFee gt 0 }">
									${entity.discontinuedFee} 元
									</c:if>
									<c:if test="${empty entity.discontinuedFee or entity.discontinuedFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">自拆费用</td>
								<td>
									<c:if test="${not empty entity.selfdemolitionFee and entity.selfdemolitionFee gt 0 }">
									${entity.selfdemolitionFee} 元
									</c:if>
									<c:if test="${empty entity.selfdemolitionFee or entity.selfdemolitionFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="nowrap">其他费用</td>
								<td>
									<c:if test="${not empty entity.otherFee and entity.otherFee gt 0 }">
									${entity.otherFee} 元
									</c:if>
									<c:if test="${empty entity.otherFee or entity.otherFee lt 0.1 }">
									(无)
									</c:if>
								</td>
							</tr>
							
							<tr>
								<td class="detailGroup">其他</td>
								<td class="nowrap">备注</td>
								<td>
									<c:if test="${not empty entity.remark}">
									${entity.remark}
									</c:if>
									<c:if test="${empty entity.remark}">
									(无)
									</c:if>
								</td>
							</tr>
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