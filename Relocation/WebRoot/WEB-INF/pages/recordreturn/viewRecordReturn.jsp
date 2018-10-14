<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.recordreturn-resources"/>
<html>
<head>
<title>View <fmt:message key="recordreturn.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="recordreturn.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexRecordReturn"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.id.title"/>:
						</td>
						<td>
							${recordreturn.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.sid.title"/>:
						</td>
						<td>
							${recordreturn.sid}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.housearea.title"/>:
						</td>
						<td>
							${recordreturn.houseArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.businessarea.title"/>:
						</td>
						<td>
							${recordreturn.businessArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.productionarea.title"/>:
						</td>
						<td>
							${recordreturn.productionArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.returntime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordreturn.returnTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordreturn.createdTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.isdeleted.title"/>:
						</td>
						<td>
							${recordreturn.isDeleted}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordreturn.deletedtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordreturn.deletedTime.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>