<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.record-resources"/>
<html>
<head>
<title>List <fmt:message key="record.title"/>s</title>
</head>
<body>
<div id="contentarea" >
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1>Manage <fmt:message key="record.title"/>s</h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecord"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="record.title"/></span></a></div>
		<div id="tablewrapper">
		<table id="listTable" cellpadding="0" cellspacing="0">
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
				<c:forEach items="${records}" var="current" varStatus="i">
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
					<td nowrap="nowrap" class="tabletd">
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectRecord?idKey=${current.id}&"><img src="images/icons/view.gif" /></a>
						<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editRecord?idKey=${current.id}&"><img src="images/icons/edit.gif" /></a>
						<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteRecord?idKey=${current.id}&"><img src="images/icons/delete.gif" /></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.id}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.projectName}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.username}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.usercontact}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.useraddress}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.useridcard}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.contractNumber}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.recordNumber}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.coveredArea}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.coveredAreaBack}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.houseArea}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.houseAreaBack}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.houseAreaBackReturn}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.houseAreaBackRoom}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.businessArea}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.businessAreaBack}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.businessAreaBackReturn}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.businessAreaBackRoom}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.productionArea}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.productionAreaBack}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.productionAreaBackReturn}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.productionAreaBackRoom}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.balance1}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.balance2}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.balanceDeal}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.bankAccount}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.selfRemoveArea}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.selfSimplyArea}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.selfRemoveAmount}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.startDealTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.lastDealTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.isDealed}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.remark}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.startTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.endTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.isStart}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.isEnd}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.createdTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.lastEditTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.deletedTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.isDeleted}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.facilityFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.transportFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.transitionFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.movingFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.awardFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.discontinuedFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.selfdemolitionFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.otherFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.total}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.perFee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.lastComputeTime.time}"/>
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>