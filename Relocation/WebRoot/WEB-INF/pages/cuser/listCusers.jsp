<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.cuser-resources"/>
<html>
<head>
<title>List <fmt:message key="cuser.title"/>s</title>
</head>
<body>
<div id="contentarea" >
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1>Manage <fmt:message key="cuser.title"/>s</h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newCuser"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="cuser.title"/></span></a></div>
		<div id="tablewrapper">
		<table id="listTable" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th class="thead">&nbsp;</th>
					<th class="thead"><fmt:message key="cuser.id.title"/></th>
					<th class="thead"><fmt:message key="cuser.username.title"/></th>
					<th class="thead"><fmt:message key="cuser.password.title"/></th>
					<th class="thead"><fmt:message key="cuser.salt.title"/></th>
					<th class="thead"><fmt:message key="cuser.phone.title"/></th>
					<th class="thead"><fmt:message key="cuser.email.title"/></th>
					<th class="thead"><fmt:message key="cuser.usertype.title"/></th>
					<th class="thead"><fmt:message key="cuser.gender.title"/></th>
					<th class="thead"><fmt:message key="cuser.nickname.title"/></th>
					<th class="thead"><fmt:message key="cuser.address.title"/></th>
					<th class="thead"><fmt:message key="cuser.photo.title"/></th>
					<th class="thead"><fmt:message key="cuser.qxdm.title"/></th>
					<th class="thead"><fmt:message key="cuser.qxmc.title"/></th>
					<th class="thead"><fmt:message key="cuser.department.title"/></th>
					<th class="thead"><fmt:message key="cuser.logintime.title"/></th>
					<th class="thead"><fmt:message key="cuser.loginip.title"/></th>
					<th class="thead"><fmt:message key="cuser.logintoken.title"/></th>
					<th class="thead"><fmt:message key="cuser.checkstatus.title"/></th>
					<th class="thead"><fmt:message key="cuser.regip.title"/></th>
					<th class="thead"><fmt:message key="cuser.createdtime.title"/></th>
					<th class="thead"><fmt:message key="cuser.isdeleted.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cusers}" var="current" varStatus="i">
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
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectCuser?idKey=${current.id}&"><img src="images/icons/view.gif" /></a>
						<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editCuser?idKey=${current.id}&"><img src="images/icons/edit.gif" /></a>
						<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteCuser?idKey=${current.id}&"><img src="images/icons/delete.gif" /></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.id}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.username}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.password}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.salt}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.phone}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.email}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.usertype}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.gender}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.nickname}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.address}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.photo}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.qxdm}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.qxmc}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.department}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.logintime.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.loginip}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.logintoken}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.checkStatus}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.regip}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.createdtime.time}"/>
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