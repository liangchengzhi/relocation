<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.recordtransitionfee-resources"/>
<html>
<head>
<title>View <fmt:message key="recordtransitionfee.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="recordtransitionfee.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexRecordTransitionfee"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
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
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="record.title"/></h1>
					
						<c:if test='${recordtransitionfee.record != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="record.id.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.projectname.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.projectName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.username.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.username}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.usercontact.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.usercontact}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.useraddress.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.useraddress}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.useridcard.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.useridcard}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.contractnumber.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.contractNumber}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.recordnumber.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.recordNumber}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.coveredarea.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.coveredArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.coveredareaback.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.coveredAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.housearea.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.houseArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.houseareaback.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.houseAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.houseareabackreturn.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.houseAreaBackReturn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.houseareabackroom.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.houseAreaBackRoom}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.businessarea.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.businessArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.businessareaback.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.businessAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.businessareabackreturn.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.businessAreaBackReturn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.businessareabackroom.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.businessAreaBackRoom}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.productionarea.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.productionArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.productionareaback.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.productionAreaBack}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.productionareabackreturn.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.productionAreaBackReturn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.productionareabackroom.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.productionAreaBackRoom}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.balance1.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.balance1}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.balance2.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.balance2}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.balancedeal.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.balanceDeal}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.bankaccount.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.bankAccount}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.selfremovearea.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.selfRemoveArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.selfsimplyarea.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.selfSimplyArea}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.selfremoveamount.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.selfRemoveAmount}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.startdealtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.startDealTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.lastdealtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.lastDealTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.isdealed.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.isDealed}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.remark.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.remark}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.starttime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.startTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.endtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.endTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.isstart.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.isStart}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.isend.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.isEnd}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.createdTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.lastedittime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.lastEditTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.deletedtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.deletedTime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.isdeleted.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.isDeleted}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.facilityfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.facilityFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.transportfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.transportFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.transitionfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.transitionFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.movingfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.movingFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.awardfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.awardFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.discontinuedfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.discontinuedFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.selfdemolitionfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.selfdemolitionFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.otherfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.otherFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.total.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.total}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.perfee.title"/>:
						</td>
						<td>
							${recordtransitionfee.record.perFee}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="record.lastcomputetime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.record.lastComputeTime.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editRecordTransitionfeeRecord?recordtransitionfee_id=${recordtransitionfee.id}&record_id=${recordtransitionfee.record.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteRecordTransitionfeeRecord?recordtransitionfee_id=${recordtransitionfee.id}&related_record_id=${recordtransitionfee.record.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${recordtransitionfee.record == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecordTransitionfeeRecord?recordtransitionfee_id=${recordtransitionfee.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="record.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="cuser.title"/></h1>
					
						<c:if test='${recordtransitionfee.cuser != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.id.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.username.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.username}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.password.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.password}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.salt.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.salt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.phone.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.phone}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.email.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.email}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.usertype.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.usertype}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.gender.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.gender}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.nickname.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.nickname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.address.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.address}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.photo.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.photo}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.qxdm.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.qxdm}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.qxmc.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.qxmc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.department.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.department}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.logintime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.cuser.logintime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.loginip.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.loginip}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.logintoken.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.logintoken}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.checkstatus.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.checkStatus}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.regip.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.regip}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.createdtime.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${recordtransitionfee.cuser.createdtime.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="cuser.isdeleted.title"/>:
						</td>
						<td>
							${recordtransitionfee.cuser.isDeleted}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editRecordTransitionfeeCuser?recordtransitionfee_id=${recordtransitionfee.id}&cuser_id=${recordtransitionfee.cuser.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteRecordTransitionfeeCuser?recordtransitionfee_id=${recordtransitionfee.id}&related_cuser_id=${recordtransitionfee.cuser.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${recordtransitionfee.cuser == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecordTransitionfeeCuser?recordtransitionfee_id=${recordtransitionfee.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="cuser.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>