<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<div class="row-fluid">
	<div class="span12">
		<div class="paging_bootstrap pagination text-right">
<span class="hidden-phone hidden-tablet pull-left" style="line-height:30px;">
		当前
		${pager.offset+1<pager.totalcount?pager.offset+1:pager.totalcount }
		至
		${pager.offset+pager.ps<pager.totalcount?pager.offset+pager.ps:pager.totalcount }
		条，
		总共
		${pager.totalcount }
		条记录&nbsp;&nbsp;
</span>
			<ul>
<!-- ==================================== -->
<li class="${pager.p==1?'disabled':''}">
	<a href="${pager.p==1?'javascript:void(0)':pager.url.concat('&p=1')}" tooltip-title="第一页">
		<i class="icon-step-backward"></i>
	</a>
</li>
<!-- ==================================== -->
<c:choose>
<c:when test="${pager.totalpage<=10}">
<c:forEach begin="1" end="${pager.totalpage}" var="i">
<li class="${pager.p==i?'active':''}">
	${pager.p==i?'<span>':'<a href="'.concat(pager.url).concat('&p=').concat(i).concat('">')}
	${i }
	${pager.p==i?'</span>':'</a>'}
</li>
</c:forEach>
</c:when>
<c:otherwise>
<c:forEach begin="1" end="2" var="i">
<li class="${pager.p==i?'active':''}">
	${pager.p==i?'<span>':'<a href="'.concat(pager.url).concat('&p=').concat(i).concat('">')}
	${i }
	${pager.p==i?'</span>':'</a>'}
</li>
</c:forEach>
<c:if test="${pager.p>5}">
<li class="">
	<a href="${pager.url.concat('&p=').concat(pager.p-3)}">...</a>
</li>
</c:if>
<c:forEach begin="${pager.p-2>3?pager.p-2:3}" end="${pager.p+2<pager.totalpage-2?pager.p+2:pager.totalpage-2}" var="i">
<li class="${pager.p==i?'active':''}">
	${pager.p==i?'<span>':'<a href="'.concat(pager.url).concat('&p=').concat(i).concat('">')}
	${i }
	${pager.p==i?'</span>':'</a>'}
</li>
</c:forEach>
<c:if test="${pager.p<pager.totalpage-4}">
<li class="">
	<a href="${pager.url.concat('&p=').concat(pager.p+3)}">...</a>
</li>
</c:if>

<c:forEach begin="${pager.totalpage-1}" end="${pager.totalpage}" var="i">
<li class="${pager.p==i?'active':''}">
	${pager.p==i?'<span>':'<a href="'.concat(pager.url).concat('&p=').concat(i).concat('">')}
	${i }
	${pager.p==i?'</span>':'</a>'}
</li>
</c:forEach>

</c:otherwise>
</c:choose>
<!-- ==================================== -->
<li class="${pager.p==pager.totalpage?'disabled':''}">
	<a href="${pager.p==pager.totalpage?'javascript:void(0)':pager.url.concat('&p=').concat(pager.totalpage)}" tooltip-title="最后页">
		<i class="icon-step-forward"></i>
	</a>
</li>
<!-- ==================================== -->
			</ul>
		</div>
	</div>
</div>
