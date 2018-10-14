<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>View <fmt:message key="project.title"/> <fmt:message key="record.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="record.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectProject?idKey=${project_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.id.title"/>:
						</td>
						<td>
							${record.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.projectname.title"/>:
						</td>
						<td>
							${record.projectName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.username.title"/>:
						</td>
						<td>
							${record.username}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.usercontact.title"/>:
						</td>
						<td>
							${record.usercontact}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.useraddress.title"/>:
						</td>
						<td>
							${record.useraddress}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.useridcard.title"/>:
						</td>
						<td>
							${record.useridcard}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.contractnumber.title"/>:
						</td>
						<td>
							${record.contractNumber}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.recordnumber.title"/>:
						</td>
						<td>
							${record.recordNumber}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.coveredarea.title"/>:
						</td>
						<td>
							${record.coveredArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.coveredareaback.title"/>:
						</td>
						<td>
							${record.coveredAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.housearea.title"/>:
						</td>
						<td>
							${record.houseArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.houseareaback.title"/>:
						</td>
						<td>
							${record.houseAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.houseareabackreturn.title"/>:
						</td>
						<td>
							${record.houseAreaBackReturn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.houseareabackroom.title"/>:
						</td>
						<td>
							${record.houseAreaBackRoom}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.businessarea.title"/>:
						</td>
						<td>
							${record.businessArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.businessareaback.title"/>:
						</td>
						<td>
							${record.businessAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.businessareabackreturn.title"/>:
						</td>
						<td>
							${record.businessAreaBackReturn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.businessareabackroom.title"/>:
						</td>
						<td>
							${record.businessAreaBackRoom}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.productionarea.title"/>:
						</td>
						<td>
							${record.productionArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.productionareaback.title"/>:
						</td>
						<td>
							${record.productionAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.productionareabackreturn.title"/>:
						</td>
						<td>
							${record.productionAreaBackReturn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.productionareabackroom.title"/>:
						</td>
						<td>
							${record.productionAreaBackRoom}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.balance1.title"/>:
						</td>
						<td>
							${record.balance1}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.balance2.title"/>:
						</td>
						<td>
							${record.balance2}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.balancedeal.title"/>:
						</td>
						<td>
							${record.balanceDeal}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.bankaccount.title"/>:
						</td>
						<td>
							${record.bankAccount}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.selfremovearea.title"/>:
						</td>
						<td>
							${record.selfRemoveArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.selfsimplyarea.title"/>:
						</td>
						<td>
							${record.selfSimplyArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.selfremoveamount.title"/>:
						</td>
						<td>
							${record.selfRemoveAmount}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.startdealtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.startDealTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.lastdealtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.lastDealTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.isdealed.title"/>:
						</td>
						<td>
							${record.isDealed}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.remark.title"/>:
						</td>
						<td>
							${record.remark}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.starttime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.startTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.endtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.endTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.isstart.title"/>:
						</td>
						<td>
							${record.isStart}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.isend.title"/>:
						</td>
						<td>
							${record.isEnd}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.createdTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.lastedittime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.lastEditTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.deletedtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.deletedTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.isdeleted.title"/>:
						</td>
						<td>
							${record.isDeleted}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.facilityfee.title"/>:
						</td>
						<td>
							${record.facilityFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.transportfee.title"/>:
						</td>
						<td>
							${record.transportFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.transitionfee.title"/>:
						</td>
						<td>
							${record.transitionFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.movingfee.title"/>:
						</td>
						<td>
							${record.movingFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.awardfee.title"/>:
						</td>
						<td>
							${record.awardFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.discontinuedfee.title"/>:
						</td>
						<td>
							${record.discontinuedFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.selfdemolitionfee.title"/>:
						</td>
						<td>
							${record.selfdemolitionFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.otherfee.title"/>:
						</td>
						<td>
							${record.otherFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.total.title"/>:
						</td>
						<td>
							${record.total}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.perfee.title"/>:
						</td>
						<td>
							${record.perFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="record.lastcomputetime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.lastComputeTime.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
