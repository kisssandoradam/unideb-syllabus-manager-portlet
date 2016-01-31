<%@include file="/html/init.jsp"%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />
<liferay-ui:success key="curriculumDeleted" message="curriculum-has-been-successfully-deleted" />
<liferay-ui:success key="everyCurriculumDeleted" message="every-curriculum-has-been-successfully-deleted" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<liferay-ui:header title="curriculums" />

<liferay-ui:search-container emptyResultsMessage="curriculums-not-found">
	<liferay-ui:search-container-results
		results="<%=CurriculumLocalServiceUtil.getCurriculums(searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=CurriculumLocalServiceUtil.getCurriculumsCount()%>"
	/>
	
	<liferay-ui:search-container-row className="hu.unideb.inf.model.Curriculum" modelVar="curriculum" keyProperty="curriculumId">
		<c:if test='<%=CurriculumPermission.contains(permissionChecker, curriculum.getCurriculumId(), "VIEW")%>'>
			<portlet:renderURL var="viewCurriculumURL">
				<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculum.jsp" />
				<portlet:param name="curriculumId" value="<%=String.valueOf(curriculum.getCurriculumId())%>" />
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="curriculum-code" property="curriculumCode" href="<%=viewCurriculumURL.toString()%>" />
			<liferay-ui:search-container-column-text name="curriculum-name" property="curriculumName" />
			<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/curriculum_actions.jsp" align="right" />
		</c:if>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
