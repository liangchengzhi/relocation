<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.record-resources"/>
<html>
<head>
<title>View <fmt:message key="record.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="record.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexRecord"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
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
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="cuser.title"/></h1>
					
						<c:if test='${record.cuser != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.id.title"/>:
						</td>
						<td>
							${record.cuser.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.username.title"/>:
						</td>
						<td>
							${record.cuser.username}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.password.title"/>:
						</td>
						<td>
							${record.cuser.password}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.salt.title"/>:
						</td>
						<td>
							${record.cuser.salt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.phone.title"/>:
						</td>
						<td>
							${record.cuser.phone}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.email.title"/>:
						</td>
						<td>
							${record.cuser.email}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.usertype.title"/>:
						</td>
						<td>
							${record.cuser.usertype}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.gender.title"/>:
						</td>
						<td>
							${record.cuser.gender}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.nickname.title"/>:
						</td>
						<td>
							${record.cuser.nickname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.address.title"/>:
						</td>
						<td>
							${record.cuser.address}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.photo.title"/>:
						</td>
						<td>
							${record.cuser.photo}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.qxdm.title"/>:
						</td>
						<td>
							${record.cuser.qxdm}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.qxmc.title"/>:
						</td>
						<td>
							${record.cuser.qxmc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.department.title"/>:
						</td>
						<td>
							${record.cuser.department}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.logintime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.cuser.logintime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.loginip.title"/>:
						</td>
						<td>
							${record.cuser.loginip}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.logintoken.title"/>:
						</td>
						<td>
							${record.cuser.logintoken}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.checkstatus.title"/>:
						</td>
						<td>
							${record.cuser.checkStatus}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.regip.title"/>:
						</td>
						<td>
							${record.cuser.regip}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${record.cuser.createdtime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.isdeleted.title"/>:
						</td>
						<td>
							${record.cuser.isDeleted}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editRecordCuser?record_id=${record.id}&cuser_id=${record.cuser.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteRecordCuser?record_id=${record.id}&related_cuser_id=${record.cuser.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${record.cuser == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecordCuser?record_id=${record.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="cuser.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="project.title"/></h1>
					
						<c:if test='${record.project != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="project.id.title"/>:
						</td>
						<td>
							${record.project.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="project.name.title"/>:
						</td>
						<td>
							${record.project.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="project.isdeleted.title"/>:
						</td>
						<td>
							${record.project.isDeleted}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editRecordProject?record_id=${record.id}&project_id=${record.project.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteRecordProject?record_id=${record.id}&related_project_id=${record.project.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${record.project == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecordProject?record_id=${record.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="project.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="recordtransitionfee.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecordRecordTransitionfees?record_id=${record.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="recordtransitionfee.title"/></span></a></div>
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
					<c:forEach items="${record.recordTransitionfees}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectRecordRecordTransitionfees?record_id=${record.id}&recordtransitionfees_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editRecordRecordTransitionfees?record_id=${record.id}&recordtransitionfees_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteRecordRecordTransitionfees?record_id=${record.id}&related_recordtransitionfees_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
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
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>