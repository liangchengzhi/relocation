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
</style>
<script src="./js/json2.js"></script>
</head>
<body>

	<div class="container-fluid" nav-menu="sysconfig">
		<div class="row-fluid">
			<div class="span12">
				<h3 class="page-title">
					参数配置 <small>管理员对系统参数进行配置</small>
				</h3>
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="./Admin">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="javascript:void(0)">拆迁管理</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="javascript:void(0)">参数配置</a></li>
				</ul>
			</div>
		</div>

		<div class="row-fluid">
			<div class="span12">
				<div class="portlet box grey" style="border-top: 1px solid #9d9c9c">
					<div class="portlet-body form" style="overflow: hidden;">
						<form class="form-horizontal editF">
							<h4 class="form-section">
								还房过渡费单价（单位：元/㎡/月） <small class="hidden">该价格仅作为比例计算剩余过渡费，实际费用按照合同上的过渡费.</small>
							</h4>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">住宅房<span class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="per_house" placeholder="住宅房单价（元/㎡/月）" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">营业房<span class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="per_business" placeholder="营业房单价（元/㎡/月）" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>
							
							<h4 class="form-section">
								过渡费计算
							</h4>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group usera">
										<label class="control-label">下一次过渡费计算截止日</label>
										<div class="controls">
											<input onchange="on_next_quarter_fee_calc_due_date_change()"  type="text" lhq-validate="[{required:false, msg:''}]"
												id="next_quarter_fee_calc_due_date" name="next_quarter_fee_calc_due_date" placeholder="下一次过渡费计算截止日"
												<%--  value="<fmt:formatDate value='<%=new Date() %>' pattern='yyyy-MM-dd'/>"  --%>
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>

							<h4 class="form-section">
								门面置换比例（原房面积/置换面积） <small></small>
							</h4>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">住宅房置换比例<span class="required">*</span></label>
										<div class="controls">
											<div class="span3">
												<input
													lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
													name="replaceHouseRatio" value="" placeholder=""
													type="text" class="m-wrap xsmall" />
											</div>
											<div class="span2" style="line-height: 36px;">：1</div>
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">营业房置换比例<span class="required">*</span></label>
										<div class="controls">
											<div class="span3">
												<input
													lhq-validate="[{reg:'/^[\\d]{0,10}(\\.)?[\\d]{0,2}$/', msg:'无效数值！'}]"
													name="replaceBusinessRatio" value="" placeholder=""
													type="text" class="m-wrap xsmall" />
											</div>
											<div class="span2" style="line-height: 36px;">：1</div>
										</div>
									</div>
								</div>
							</div>



							<h4 class="form-section">交房违约金(单位：元)</h4>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">每日金额<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="per_day_account" placeholder="每日金额(元)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6"></div>
							</div>

							<h4 class="form-section">还房涨幅(单位：%)</h4>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">逾期起始月<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="after_month_num" placeholder="[即超出多少月开始算逾期]"
												type="text" class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">最高涨幅<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="max_increment" placeholder="最高涨幅(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">超期≤1半年<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="increment1" placeholder="超期≤1半年(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">超期≤2半年<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="increment2" placeholder="超期≤2半年(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">超期≤3半年<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="increment3" placeholder="超期≤3半年(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">超期≤4半年<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="increment4" placeholder="超期≤4半年(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">超期≤5半年<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="increment5" placeholder="超期≤5半年(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">超期≤6半年<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]"
												name="increment6" placeholder="超期≤6半年(%)" type="text"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>

							<h4 class="form-section">
								季度过渡费计算时间节点 <small>忽略年份</small>
							</h4>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">第一季度<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]" readonly
												type="text" name="quarter1" placeholder="第一季度"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">第二季度<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]" readonly
												type="text" name="quarter2" placeholder="第二季度"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<label class="control-label">第三季度<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]" readonly
												type="text" name="quarter3" placeholder="第三季度"
												class="m-wrap medium" />
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">第四季度<span
											class="required">*</span></label>
										<div class="controls">
											<input lhq-validate="[{required:true, msg:''}]" readonly
												type="text" name="quarter4" placeholder="第四季度"
												class="m-wrap medium" />
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
			$('.okBtn').click(function() {
				preventDefault(arguments[0]);
				if (validateForm('.editF') == false) {
					flash('.editF .validateErr');
					return false;
				}
				var param = $('.editF').serializeObject();
				$.post("setSysConfig?ajaxtag=1", {
					id : 'admin_record_config',
					value : JSON.stringify(param),
					description : '拆迁记录相关参数配置'
				}, function(resp) {
					if (checkResponse(resp) == false)
						return;
					bootbox.alert('<h4>提示：</h4>保存成功。', '确定', function() {
						var referer = $('input[name="referer"]');
						if (referer.length > 0 && referer.val() != '')
							window.location.href = referer.val();
					});
				});
			});

			$.post("getSysConfig?ajaxtag=1", {
				id : "admin_record_config"
			}, function(resp) {
				if (resp.status == 0) {
					if (resp.data == '')
						return;
					resp.data = eval("(" + resp.data + ")");
					for (key in resp.data) {
						$('.editF').find('input[name="' + key + '"]').val(
								resp.data[key]);
					}
				}
			});

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
			$('input[name^="quarter"]').datepicker({
				format : 'yyyy-mm-dd',
				weekStart : 1,
				autoclose : true
			}).on('changeDate', function(ev) {
			});
			$('input[name="next_quarter_fee_calc_due_date"]').datepicker({
				format : 'yyyy-mm-dd',
				weekStart : 1,
				autoclose : true
			}).on('changeDate', function(ev) {
			});
			

			$('input[name*="increment"],input[name="per_day_account"]').each(
					function() {
						$(this).val(
								formatCurrency($(this).val() * 1).replace(
										/(,| )/g, ''));
					});
		});
		function on_next_quarter_fee_calc_due_date_change(){
			var date = $("input[name='next_quarter_fee_calc_due_date']").val();
			if(!date){
				return;
			}
			var reg = new RegExp('^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$');
		    if(!reg.test(date)){
				date.val('');
				return;
		    }
		}
	</script>
</body>
</html>