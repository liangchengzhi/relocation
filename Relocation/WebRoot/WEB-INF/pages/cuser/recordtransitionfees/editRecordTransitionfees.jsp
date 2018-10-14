<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.cuser-resources"/>
<html>
<head>
<title>Edit <fmt:message key="cuser.title"/> <fmt:message key="recordtransitionfee.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="recordtransitionfee.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectCuser?idKey=${cuser_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveCuserRecordTransitionfees" method="POST" modelAttribute="recordtransitionfee">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="recordtransitionfee_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${recordtransitionfee.id}
						&nbsp;
									<form:hidden id="recordtransitionfee_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.type.title"/>:
						</td>
						<td>
							<form:input id="recordtransitionfee_type" path="type" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_type",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.type.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.firststarttime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_firstStartTime" name="firstStartTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.firstStartTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_firstStartTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.firstendtime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_firstEndTime" name="firstEndTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.firstEndTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_firstEndTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.firstfee.title"/>:
						</td>
						<td>
							<form:input id="recordtransitionfee_firstFee" path="firstFee" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_firstFee",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.firstfee.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.starttime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_startTime" name="startTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.startTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_startTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.endtime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_endTime" name="endTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.endTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_endTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.year.title"/>:
						</td>
						<td>
							<form:input id="recordtransitionfee_year" path="year" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_year",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.year.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.quarter.title"/>:
						</td>
						<td>
							<form:input id="recordtransitionfee_quarter" path="quarter" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_quarter",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.quarter.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.fee.title"/>:
						</td>
						<td>
							<form:input id="recordtransitionfee_fee" path="fee" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_fee",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.fee.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.bankaccount.title"/>:
						</td>
						<td>
							<form:input id="recordtransitionfee_bankAccount" path="bankAccount" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_bankAccount",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="recordtransitionfee.bankaccount.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.remark.title"/>:
						</td>
						<td>
							<form:textarea id="recordtransitionfee_remark" path="remark" cssStyle="width:300px; height:100px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_remark",widgetType : "dijit.form.SimpleTextarea",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.createdtime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_createdTime" name="createdTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.createdTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_createdTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.dealedtime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_dealedTime" name="dealedTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.dealedTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_dealedTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.isdealed.title"/>:
						</td>
						<td>
							<form:checkbox id="recordtransitionfee_isDealed" path="isDealed" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_isDealed",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.deletedtime.title"/>:
						</td>
						<td>
							<input id="recordtransitionfee_deletedTime" name="deletedTime" type="text" value="<fmt:formatDate value="${recordtransitionfee.deletedTime.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_deletedTime",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recordtransitionfee.isdeleted.title"/>:
						</td>
						<td>
							<form:checkbox id="recordtransitionfee_isDeleted" path="isDeleted" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "recordtransitionfee_isDeleted",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="cuser_id" value="${cuser_id}" >
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
