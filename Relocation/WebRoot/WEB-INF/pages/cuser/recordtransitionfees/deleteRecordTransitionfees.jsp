<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.cuser-resources"/>
<html>
<head>
<title>View <fmt:message key="cuser.title"/> <fmt:message key="recordtransitionfee.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="recordtransitionfee.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectCuser?idKey=${cuser_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.id.title"/>:
						</td>
						<td>
							${recordtransitionfee.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.type.title"/>:
						</td>
						<td>
							${recordtransitionfee.type}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.firststarttime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.firstStartTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.firstendtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.firstEndTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.firstfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.firstFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.starttime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.startTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.endtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.endTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.year.title"/>:
						</td>
						<td>
							${recordtransitionfee.year}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.quarter.title"/>:
						</td>
						<td>
							${recordtransitionfee.quarter}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.fee.title"/>:
						</td>
						<td>
							${recordtransitionfee.fee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.bankaccount.title"/>:
						</td>
						<td>
							${recordtransitionfee.bankAccount}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.remark.title"/>:
						</td>
						<td>
							${recordtransitionfee.remark}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.createdTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.dealedtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.dealedTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.isdealed.title"/>:
						</td>
						<td>
							${recordtransitionfee.isDealed}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.deletedtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.deletedTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.isdeleted.title"/>:
						</td>
						<td>
							${recordtransitionfee.isDeleted}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteCuserRecordTransitionfees?cuser_id=${cuser_id}&related_recordtransitionfees_id=${recordtransitionfee.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
