<%@page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String Title = "";
Title = request.getHeader(Title);
String referer = request.getHeader("Referer");
if(referer==null) referer="";
%>
<html>
<head>
	<link href="<%=path%>/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="<%=path%>/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/css/common.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="<%=path%>/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<script src="<%=path%>/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="<%=path%>/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="<%=path%>/media/js/bootstrap.min.js" type="text/javascript"></script>

	<script src="<%=path%>/js/lhq_form_validate.js"></script>
	<script src="<%=path%>/js/highlight.js"></script>
	<script src="<%=path%>/js/bootbox.js"></script>
	<script src="<%=path%>/js/common.js"></script>
</head>
<body>
<script>
$(function(){
	var cb = null;
	<c:if test="${not empty page}">
	cb = function(){window.history.go(${page})};
	</c:if>
	<c:if test="${not empty url}">
	cb = function(){window.location.href="${url}"};
	</c:if>
	<c:if test="${empty message}">
		if(cb!=null) cb();
	</c:if>
	<c:if test="${not empty message and fn:contains(message,'未登录')}">
	bootbox.alert('<h4>提示：</h4>未登录，请先登录后访问。','确定',function(){
		window.location.href="./Login";
	});
	</c:if>
	<c:if test="${not empty message and not fn:contains(message,'未登录')}">
	bootbox.alert('<h4>提示：</h4>${message}','确定',function(){
		if(cb!=null) cb();
	});
	</c:if>
});
</script>
</body>
</html>