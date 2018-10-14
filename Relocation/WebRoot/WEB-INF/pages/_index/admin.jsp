<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<html>
<body>
	<div class="container-fluid" nav-menu="adminMain">
		<div class="row-fluid">
			<div class="span12">
				<h3 class="page-title">
					管理首页 <small>当前时间是：<span id="nowtime">0000-00-00
							00:00:00</span></small>
				</h3>
			</div>
		</div>
		
		<div class="row-fluid" id="removalRecord">
			<div class="span612">
				<div class="portlet box grey"
					style="border: 0; border-top: 1px solid #9d9c9c">
					<div class="portlet-body">
						<div class="row-fluid">
							<div class="dataTables_wrapper form-inline welcome-title"
								style="text-align: center; color: #666; font-size: 20px; padding-top: 40px">
								运行情况概览<br />
								<br />
								<br />
							</div>
							<div class="row-fluid">
								<div class="span6 span6-offset-6">
									<h3>已拆迁情况</h3>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span3">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">已拆迁户数： <span
										id="removalUserCount" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span3">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">已拆住房面积： <span
										id="removalHouseAreaSum" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span3">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">已拆营业房面积： <span
										id="removalBusinessAreaSum" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span3">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">其他： <span
										id="removalOtherAreaSum" style="color: #ee5f5b"></span></label>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span6 span6-offset-6">
									<h3>费用情况</h3>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span4">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">交通费： <span
										id="transportFreeSum" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span4">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">过渡费： <span
										id="transtitionFreeSum" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span4">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">搬家费： <span
										id="movingFreeSum" style="color: #ee5f5b"></span></label>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span4">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">停产停业补助： <span
										id="discontinuedFreeSum" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span4">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">奖金： <span
										id="awardFreeSum" style="color: #ee5f5b"></span></label>
								</div>
								<div class="span4">
									<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">其他费用： <span
										id="otherFreeSum" style="color: #ee5f5b"></span></label>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 span6-offset-6">
								<h3>还房情况</h3>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4">
								<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">已还房户数： <span
									id="removalBackUserCount" style="color: #ee5f5b"></span></label>
							</div>
							<div class="span4">
								<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">已还住房面积： <span
									id="removalHouseAreaBackSum" style="color: #ee5f5b"></span></label>
							</div>
							<div class="span4">
								<img src="./images/ic.png" class="icon-image">
									<label class="control-label bgb h30 lh30 pl40">已还营业房面积： <span
									id="removalBusinessAreaBackSum" style="color: #ee5f5b"></span></label>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	<script>
		$(function() {
			$.post("initRemovalRecord", function(resp) {

				if (resp == "" || resp == undefined) {
					//用户无权限，或者未登录，需隐藏运行情况概览
					$("#removalRecord").hide();

				} else if (resp == "error") {
					//查询数据出错
					$("#removalRecord").hide();
				} else {
					//以获取数据，展示数据
					var obj = eval("(" + resp + ")");
					for ( var key in obj) {
						$('#' + key).text(obj[key]);
					}
				}

			});
			setInterval(function() {
				$('#nowtime').text((new Date()).format('yyyy-MM-dd hh:mm:ss'));
			}, 1000);

		});
	</script>
</body>
</html>