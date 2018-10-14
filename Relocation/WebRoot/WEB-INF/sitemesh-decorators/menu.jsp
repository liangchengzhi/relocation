<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<ul class="page-sidebar-menu">
	<li>
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		<div class="sidebar-toggler hidden-phone"></div>
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	</li>
	<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('用户管理')}">
	<li>
		<a href="javascript:void(0)">
		<i class="icon-user"></i> 
		<span class="title">用户管理</span>
		<span class="arrow "></span>
		</a>
		<ul class="sub-menu">
			<li class="userEdit">
				<a href="./EditUser">新增用户</a>
			</li>
			<li class="userList">
				<a href="./ListUser">用户列表</a>
			</li>
			<li class="userList">
				<a href="./listUserOperatorLog">操作日志查询</a>
			</li>
		</ul>
	</li>
	</c:if>
	<li class="">
		<a href="javascript:;">
		<i class="icon-cog"></i> 
		<span class="title">拆迁管理</span>
		<span class="arrow "></span>
		</a>
		<ul class="sub-menu">
			<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('参数配置')}">
			<li class="sysconfig">
				<a href="./RecordConfig">参数配置</a>
			</li>
			</c:if>
			<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('基本信息录入')}">
			<li class="recordEdit">
				<a href="./EditRecord">拆迁备案</a>
			</li>
			</c:if>
			<li class="recordList">
				<a href="./ListRecord">拆迁记录</a>
			</li>
<!-- 			<li class="transitionfeeEdit">
				<a href="./EditTransitionfee">过渡费登记</a>
			</li>
			<li class="recordtransitionfeeList">
				<a href="./ListRecordTransitionfee">过渡费记录</a>
			</li> -->
			<c:if test="${cuser.usertype eq 10  or cuser.authorityGroup.contains('过渡费计算与结算')}">
			<li class="transitionfeeList">
				<a href="./ListTransitionfee">季度过渡费</a>
			</li>
			</c:if>
		</ul>
	</li>
	<li class="">
		<a href="javascript:;">
		<i class="icon-lock"></i> 
		<span class="title">账户信息</span>
		<span class="arrow "></span>
		</a>
		<ul class="sub-menu">
			<li class="changeProfile">
				<a href="./Admin?page=profile">用户资料</a>
			</li>
			<li class="changePwd">
				<a href="./Admin?page=pwd">密码修改</a>
			</li>
			<li >
				<a href="./Logout">安全退出</a>
			</li>
		</ul>
	</li>
</ul>