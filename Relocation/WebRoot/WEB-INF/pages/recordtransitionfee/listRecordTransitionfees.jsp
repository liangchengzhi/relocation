<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.recordtransitionfee-resources"/>
<html>
<head>
<title>List <fmt:message key="recordtransitionfee.title"/>s</title>
</head>
<body>
<div id="contentarea" >
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1>Manage <fmt:message key="recordtransitionfee.title"/>s</h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecordTransitionfee"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="recordtransitionfee.title"/></span></a></div>
		<div id="tablewrapper">
		<table id="listTable" cellpadding="0" cellspacing="0">
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
				<c:forEach items="${recordtransitionfees}" var="current" varStatus="i">
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
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectRecordTransitionfee?idKey=${current.id}&"><img src="images/icons/view.gif" /></a>
						<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editRecordTransitionfee?idKey=${current.id}&"><img src="images/icons/edit.gif" /></a>
						<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteRecordTransitionfee?idKey=${current.id}&"><img src="images/icons/delete.gif" /></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.id}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.type}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.firstStartTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.firstEndTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.firstFee}
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
						
							${current.year}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.quarter}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.fee}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.bankAccount}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.remark}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.createdTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.dealedTime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.isDealed}
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