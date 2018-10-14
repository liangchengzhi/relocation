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
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteCuser?idKey=${cuser.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>