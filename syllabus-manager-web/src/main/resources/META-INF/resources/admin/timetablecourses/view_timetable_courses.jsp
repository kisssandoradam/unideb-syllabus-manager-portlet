<%@include file="/init.jsp"%>

<%
	String home = ParamUtil.getString(renderRequest, "home");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");
	long semesterId = ParamUtil.getLong(renderRequest, "semesterId");
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", WebKeys.VIEW_TIMETABLE_COURSES);
	iteratorURL.setParameter("home", home);
	iteratorURL.setParameter("semesterId", String.valueOf(semesterId));
	iteratorURL.setParameter("courseId", String.valueOf(courseId));
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
	
	int searchContainerTotal = 0;
	if (home.equalsIgnoreCase(WebKeys.ADMIN_HOME_CURRICULUMS)) {
		searchContainerTotal = TimetableCourseLocalServiceUtil.getTimetableCourseCountByCourseId(courseId);
	} else if (home.equalsIgnoreCase(WebKeys.ADMIN_HOME_SEMESTERS)) {
		searchContainerTotal = TimetableCourseLocalServiceUtil.getTimetableCoursesCountBySemesterId(semesterId);
	}
%>

<%@ include file="/notifications/success.jspf" %>

<%@ include file="/notifications/error.jspf" %>

<c:set var="home" value="<%=home%>" scope="request" />
<c:set var="curriculumId" value="<%=curriculumId%>" scope="request" />
<c:set var="subjectId" value="<%=subjectId%>" scope="request" />
<c:set var="courseId" value="<%=courseId%>" scope="request" />
<c:set var="semesterId" value="<%=semesterId%>" scope="request" />

<jsp:include page="/admin/navigation_bar.jsp" />

<jsp:include page="/admin/breadcrumb.jsp" />

<aui:form method="post" name="fmTimetableCourse">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="timetable-courses-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>" total="<%=searchContainerTotal%>">
		<aui:input name="courseId" type="hidden" value="<%= courseId %>" />
		
		<aui:input name="semesterId" type="hidden" value="<%= semesterId %>" />
		
		<aui:input name="deleteTimetableCourseIds" type="hidden" />
		
		<%
			List<TimetableCourse> searchContainerResults = Collections.emptyList();
			
			if (home.equalsIgnoreCase(WebKeys.ADMIN_HOME_CURRICULUMS)) {
				searchContainerResults = TimetableCourseLocalServiceUtil.getTimetableCoursesByCourseId(courseId, searchContainer.getStart(), searchContainer.getEnd());
			} else if (home.equalsIgnoreCase(WebKeys.ADMIN_HOME_SEMESTERS)) {
				searchContainerResults = TimetableCourseLocalServiceUtil.getTimetableCoursesBySemesterId(semesterId, searchContainer.getStart(), searchContainer.getEnd());
			}
		%>
		
		<liferay-ui:search-container-results results="<%=searchContainerResults%>" />
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.TimetableCourse" escapedModel="<%= true %>" modelVar="timetableCourse" keyProperty="timetableCourseId">
			<c:if test='<%=TimetableCoursePermission.contains(permissionChecker, timetableCourse.getTimetableCourseId(), "VIEW")%>'>
				<%
				Course course = CourseLocalServiceUtil.getCourse(timetableCourse.getCourseId());
				
				Semester semester = SemesterLocalServiceUtil.getSemester(timetableCourse.getSemesterId());
				
				CourseType courseType = CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId());
				
				Subject subject = SubjectLocalServiceUtil.getSubject(course.getSubjectId());
				
				Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(subject.getCurriculumId());
				%>
				
				<liferay-ui:search-container-column-text name="curriculum-code" value="<%=HtmlUtil.escapeAttribute(curriculum.getCurriculumCode())%>" />
				<liferay-ui:search-container-column-text name="curriculum-name" value="<%=HtmlUtil.escapeAttribute(curriculum.getCurriculumName())%>" />
				
				<liferay-ui:search-container-column-text name="subject-code" value="<%=HtmlUtil.escapeAttribute(subject.getSubjectCode())%>" />
				<liferay-ui:search-container-column-text name="subject-name" value="<%=HtmlUtil.escapeAttribute(subject.getSubjectName())%>" />
				<liferay-ui:search-container-column-text name="credit" value="<%=String.valueOf(subject.getCredit())%>" />
			
				<liferay-ui:search-container-column-text name="semester" value="<%=HtmlUtil.escapeAttribute(semester.toString())%>" />
			
				<liferay-ui:search-container-column-text name="course-type" value="<%=HtmlUtil.escapeAttribute(courseType.getTypeName())%>" />
				
				<liferay-ui:search-container-column-text name="hours-per-semester" value="<%=String.valueOf(course.getHoursPerSemester())%>" />
				<liferay-ui:search-container-column-text name="hours-per-week" value="<%=String.valueOf(course.getHoursPerWeek())%>" />
				
				<liferay-ui:search-container-column-text name="timetable-course-code" property="timetableCourseCode" />
				<liferay-ui:search-container-column-text name="subject-type" property="subjectType" />
				<liferay-ui:search-container-column-text name="recommended-term" property="recommendedTerm" />
				<liferay-ui:search-container-column-text name="limit" property="limit" />
				
				<%
				List<Lecturer> lecturers = LecturerLocalServiceUtil.getTimetableCourseLecturers(timetableCourse.getTimetableCourseId());
				
				StringBuilder lecturerNames = new StringBuilder();
				
				for (int i = 0; i < lecturers.size(); i++) {
					if (i > 0) {
						lecturerNames.append(", ");
					}
					lecturerNames.append(lecturers.get(i).getLecturerName());
				}
				%>
				<liferay-ui:search-container-column-text name="lecturers" value="<%=lecturerNames.toString()%>" />
				
				<liferay-ui:search-container-column-text name="class-schedule-info" property="classScheduleInfo" />
				<liferay-ui:search-container-column-text name="description" property="description" />
				
				<liferay-ui:search-container-column-jsp path="/admin/timetablecourses/timetable_course_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>	
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.DELETE_TIMETABLE_COURSES)%>'>
	<portlet:actionURL name="deleteTimetableCourses" var="deleteTimetableCoursesURL">
		<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		<portlet:param name="home" value="<%=home%>" />
	</portlet:actionURL>
	
	<aui:script use="aui-base">
		A.one('.removeCheckedItemsButton').on(
			'click',
			function(event) {
				<portlet:namespace />deleteTimetableCourses();
			}
		);
		
	    Liferay.provide(
	        window,
	        '<portlet:namespace />deleteTimetableCourses',
	        function() {
	            if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
					document.<portlet:namespace />fmTimetableCourse.method = "post";
					document.<portlet:namespace />fmTimetableCourse.<portlet:namespace />deleteTimetableCourseIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmTimetableCourse, '<portlet:namespace />allRowIds');
					submitForm(document.<portlet:namespace />fmTimetableCourse, "<%=deleteTimetableCoursesURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>