<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.cuser-resources"/>
<html>
<head>
<title>View <fmt:message key="cuser.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="cuser.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexCuser"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.id.title"/>:
						</td>
						<td>
							${cuser.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.username.title"/>:
						</td>
						<td>
							${cuser.username}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.password.title"/>:
						</td>
						<td>
							${cuser.password}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.salt.title"/>:
						</td>
						<td>
							${cuser.salt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.phone.title"/>:
						</td>
						<td>
							${cuser.phone}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.email.title"/>:
						</td>
						<td>
							${cuser.email}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.usertype.title"/>:
						</td>
						<td>
							${cuser.usertype}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.gender.title"/>:
						</td>
						<td>
							${cuser.gender}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.nickname.title"/>:
						</td>
						<td>
							${cuser.nickname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.address.title"/>:
						</td>
						<td>
							${cuser.address}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.photo.title"/>:
						</td>
						<td>
							${cuser.photo}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.qxdm.title"/>:
						</td>
						<td>
							${cuser.qxdm}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.qxmc.title"/>:
						</td>
						<td>
							${cuser.qxmc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.department.title"/>:
						</td>
						<td>
							${cuser.department}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.logintime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${cuser.logintime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.loginip.title"/>:
						</td>
						<td>
							${cuser.loginip}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.logintoken.title"/>:
						</td>
						<td>
							${cuser.logintoken}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.checkstatus.title"/>:
						</td>
						<td>
							${cuser.checkStatus}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.regip.title"/>:
						</td>
						<td>
							${cuser.regip}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${cuser.createdtime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="cuser.isdeleted.title"/>:
						</td>
						<td>
							${cuser.isDeleted}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="recordtransitionfee.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newCuserRecordTransitionfees?cuser_id=${cuser.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="recordtransitionfee.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="recordtransitionfee.id.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.type.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.firststarttime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.firstendtime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.firstfee.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.starttime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.endtime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.year.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.quarter.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.fee.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.bankaccount.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.remark.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.createdtime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.dealedtime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.isdealed.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.deletedtime.title"/></th>
						<th class="thead"><fmt:message key="recordtransitionfee.isdeleted.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cuser.recordTransitionfees}" var="current"  varStatus="i">	
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
					    		<c:set var="rowclass" value="rowtwo"/>
							</c:when>
							<c:otherwise>
					    		<c:set var="rowclass" value="rowone"/>
							</c:otherwise>
						</c:choose>
					<tr class="${rowclass}">
						<td nowrap="nowrap">
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectCuserRecordTransitionfees?cuser_id=${cuser.id}&recordtransitionfees_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editCuserRecordTransitionfees?cuser_id=${cuser.id}&recordtransitionfees_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteCuserRecordTransitionfees?cuser_id=${cuser.id}&related_recordtransitionfees_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.type}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.firstStartTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.firstEndTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.firstFee}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.startTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.endTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.year}
						&nbsp;
						</td>
						<td>
							${current.quarter}
						&nbsp;
						</td>
						<td>
							${current.fee}
						&nbsp;
						</td>
						<td>
							${current.bankAccount}
						&nbsp;
						</td>
						<td>
							${current.remark}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.createdTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.dealedTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isDealed}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.deletedTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isDeleted}
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="record.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newCuserRecords?cuser_id=${cuser.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="record.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="record.id.title"/></th>
						<th class="thead"><fmt:message key="record.projectname.title"/></th>
						<th class="thead"><fmt:message key="record.username.title"/></th>
						<th class="thead"><fmt:message key="record.usercontact.title"/></th>
						<th class="thead"><fmt:message key="record.useraddress.title"/></th>
						<th class="thead"><fmt:message key="record.useridcard.title"/></th>
						<th class="thead"><fmt:message key="record.contractnumber.title"/></th>
						<th class="thead"><fmt:message key="record.recordnumber.title"/></th>
						<th class="thead"><fmt:message key="record.coveredarea.title"/></th>
						<th class="thead"><fmt:message key="record.coveredareaback.title"/></th>
						<th class="thead"><fmt:message key="record.housearea.title"/></th>
						<th class="thead"><fmt:message key="record.houseareaback.title"/></th>
						<th class="thead"><fmt:message key="record.houseareabackreturn.title"/></th>
						<th class="thead"><fmt:message key="record.houseareabackroom.title"/></th>
						<th class="thead"><fmt:message key="record.businessarea.title"/></th>
						<th class="thead"><fmt:message key="record.businessareaback.title"/></th>
						<th class="thead"><fmt:message key="record.businessareabackreturn.title"/></th>
						<th class="thead"><fmt:message key="record.businessareabackroom.title"/></th>
						<th class="thead"><fmt:message key="record.productionarea.title"/></th>
						<th class="thead"><fmt:message key="record.productionareaback.title"/></th>
						<th class="thead"><fmt:message key="record.productionareabackreturn.title"/></th>
						<th class="thead"><fmt:message key="record.productionareabackroom.title"/></th>
						<th class="thead"><fmt:message key="record.balance1.title"/></th>
						<th class="thead"><fmt:message key="record.balance2.title"/></th>
						<th class="thead"><fmt:message key="record.balancedeal.title"/></th>
						<th class="thead"><fmt:message key="record.bankaccount.title"/></th>
						<th class="thead"><fmt:message key="record.selfremovearea.title"/></th>
						<th class="thead"><fmt:message key="record.selfsimplyarea.title"/></th>
						<th class="thead"><fmt:message key="record.selfremoveamount.title"/></th>
						<th class="thead"><fmt:message key="record.startdealtime.title"/></th>
						<th class="thead"><fmt:message key="record.lastdealtime.title"/></th>
						<th class="thead"><fmt:message key="record.isdealed.title"/></th>
						<th class="thead"><fmt:message key="record.remark.title"/></th>
						<th class="thead"><fmt:message key="record.starttime.title"/></th>
						<th class="thead"><fmt:message key="record.endtime.title"/></th>
						<th class="thead"><fmt:message key="record.isstart.title"/></th>
						<th class="thead"><fmt:message key="record.isend.title"/></th>
						<th class="thead"><fmt:message key="record.createdtime.title"/></th>
						<th class="thead"><fmt:message key="record.lastedittime.title"/></th>
						<th class="thead"><fmt:message key="record.deletedtime.title"/></th>
						<th class="thead"><fmt:message key="record.isdeleted.title"/></th>
						<th class="thead"><fmt:message key="record.facilityfee.title"/></th>
						<th class="thead"><fmt:message key="record.transportfee.title"/></th>
						<th class="thead"><fmt:message key="record.transitionfee.title"/></th>
						<th class="thead"><fmt:message key="record.movingfee.title"/></th>
						<th class="thead"><fmt:message key="record.awardfee.title"/></th>
						<th class="thead"><fmt:message key="record.discontinuedfee.title"/></th>
						<th class="thead"><fmt:message key="record.selfdemolitionfee.title"/></th>
						<th class="thead"><fmt:message key="record.otherfee.title"/></th>
						<th class="thead"><fmt:message key="record.total.title"/></th>
						<th class="thead"><fmt:message key="record.perfee.title"/></th>
						<th class="thead"><fmt:message key="record.lastcomputetime.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cuser.records}" var="current"  varStatus="i">	
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
					    		<c:set var="rowclass" value="rowtwo"/>
							</c:when>
							<c:otherwise>
					    		<c:set var="rowclass" value="rowone"/>
							</c:otherwise>
						</c:choose>
					<tr class="${rowclass}">
						<td nowrap="nowrap">
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectCuserRecords?cuser_id=${cuser.id}&records_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editCuserRecords?cuser_id=${cuser.id}&records_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteCuserRecords?cuser_id=${cuser.id}&related_records_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.projectName}
						&nbsp;
						</td>
						<td>
							${current.username}
						&nbsp;
						</td>
						<td>
							${current.usercontact}
						&nbsp;
						</td>
						<td>
							${current.useraddress}
						&nbsp;
						</td>
						<td>
							${current.useridcard}
						&nbsp;
						</td>
						<td>
							${current.contractNumber}
						&nbsp;
						</td>
						<td>
							${current.recordNumber}
						&nbsp;
						</td>
						<td>
							${current.coveredArea}
						&nbsp;
						</td>
						<td>
							${current.coveredAreaBack}
						&nbsp;
						</td>
						<td>
							${current.houseArea}
						&nbsp;
						</td>
						<td>
							${current.houseAreaBack}
						&nbsp;
						</td>
						<td>
							${current.houseAreaBackReturn}
						&nbsp;
						</td>
						<td>
							${current.houseAreaBackRoom}
						&nbsp;
						</td>
						<td>
							${current.businessArea}
						&nbsp;
						</td>
						<td>
							${current.businessAreaBack}
						&nbsp;
						</td>
						<td>
							${current.businessAreaBackReturn}
						&nbsp;
						</td>
						<td>
							${current.businessAreaBackRoom}
						&nbsp;
						</td>
						<td>
							${current.productionArea}
						&nbsp;
						</td>
						<td>
							${current.productionAreaBack}
						&nbsp;
						</td>
						<td>
							${current.productionAreaBackReturn}
						&nbsp;
						</td>
						<td>
							${current.productionAreaBackRoom}
						&nbsp;
						</td>
						<td>
							${current.balance1}
						&nbsp;
						</td>
						<td>
							${current.balance2}
						&nbsp;
						</td>
						<td>
							${current.balanceDeal}
						&nbsp;
						</td>
						<td>
							${current.bankAccount}
						&nbsp;
						</td>
						<td>
							${current.selfRemoveArea}
						&nbsp;
						</td>
						<td>
							${current.selfSimplyArea}
						&nbsp;
						</td>
						<td>
							${current.selfRemoveAmount}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.startDealTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.lastDealTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isDealed}
						&nbsp;
						</td>
						<td>
							${current.remark}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.startTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.endTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isStart}
						&nbsp;
						</td>
						<td>
							${current.isEnd}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.createdTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.lastEditTime.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.deletedTime.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isDeleted}
						&nbsp;
						</td>
						<td>
							${current.facilityFee}
						&nbsp;
						</td>
						<td>
							${current.transportFee}
						&nbsp;
						</td>
						<td>
							${current.transitionFee}
						&nbsp;
						</td>
						<td>
							${current.movingFee}
						&nbsp;
						</td>
						<td>
							${current.awardFee}
						&nbsp;
						</td>
						<td>
							${current.discontinuedFee}
						&nbsp;
						</td>
						<td>
							${current.selfdemolitionFee}
						&nbsp;
						</td>
						<td>
							${current.otherFee}
						&nbsp;
						</td>
						<td>
							${current.total}
						&nbsp;
						</td>
						<td>
							${current.perFee}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${current.lastComputeTime.time}"/>
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>