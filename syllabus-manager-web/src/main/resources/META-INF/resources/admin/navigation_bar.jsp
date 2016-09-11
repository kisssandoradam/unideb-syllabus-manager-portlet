<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- 
	https://docs.liferay.com/portal/6.2/taglibs/liferay-ui/icon.html
	
	http://marcoceppi.github.io/bootstrap-glyphicons/
-->

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="/admin/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumsURL">
	<portlet:param name="mvcPath" value="/admin/curriculums/view_curriculums.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="/admin/course_types/view_course_types.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSemestersURL">
	<portlet:param name="mvcPath" value="/admin/semesters/view_semesters.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewLecturersURL">
	<portlet:param name="mvcPath" value="/admin/lecturers/view_lecturers.jsp" />
</portlet:renderURL>

<aui:nav-bar>
    <aui:nav>
    	<aui:nav-item cssClass="removeCheckedItemsButton" iconCssClass="icon-remove" label="delete" selected='false' style="display: none;" />
    	
        <aui:nav-item href="<%=viewHomeURL.toString()%>" iconCssClass="icon-home" label="home" selected='false' />
        
        <aui:nav-item dropdown="true" iconCssClass="icon-list" label="view" selected='false'>
        	<aui:nav-item href="<%=viewCurriculumsURL.toString()%>" label="curriculums" />
			<aui:nav-item href="<%=viewCourseTypesURL.toString()%>" label="course-types" />
			<aui:nav-item href="<%=viewSemestersURL.toString()%>" label="semesters" />
			<aui:nav-item href="<%=viewLecturersURL.toString()%>" label="lecturers" />
		</aui:nav-item>
        
        <aui:nav-item dropdown="true" iconCssClass="icon-plus" label="add" selected='false'>
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_CURRICULUM)%>'>
				<portlet:renderURL var="addCurriculumURL">
					<portlet:param name="mvcPath" value="/admin/curriculums/edit_curriculum.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addCurriculumURL.toString()%>" label="curriculum" />
			</c:if>
            
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_SUBJECT)%>'>
            	<portlet:renderURL var="addSubjectURL">
					<portlet:param name="mvcPath" value="/admin/subjects/edit_subject.jsp" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addSubjectURL.toString()%>" label="subject" />
			</c:if>
			
			<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_COURSE)%>'>
				<portlet:renderURL var="addCourseURL">
					<portlet:param name="mvcPath" value="/admin/courses/edit_course.jsp" />
					<portlet:param name="subjectId" value="${subjectId}" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addCourseURL.toString()%>" label="course" />
           	</c:if>
            
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_COURSE_TYPE)%>'>
            	<portlet:renderURL var="addCourseTypeURL">
					<portlet:param name="mvcPath" value="/admin/course_types/edit_course_type.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addCourseTypeURL.toString() %>" label="course-type" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_SEMESTER)%>'>
            	<portlet:renderURL var="addSemesterURL">
					<portlet:param name="mvcPath" value="/admin/semesters/edit_semester.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addSemesterURL.toString() %>" label="semester" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_LECTURER)%>'>
           		<portlet:renderURL var="addLecturerURL">
					<portlet:param name="mvcPath" value="/admin/lecturers/edit_lecturer.jsp" />
					<portlet:param name="lecturerId" value="${lecturerId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addLecturerURL.toString() %>" label="lecturer" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_TIMETABLE_COURSE)%>'>
           		<portlet:renderURL var="addTimetableCourseURL">
					<portlet:param name="mvcPath" value="/admin/timetablecourses/edit_timetable_course.jsp" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
					<portlet:param name="subjectId" value="${subjectId}" />
					<portlet:param name="courseId" value="${courseId}" />
					<portlet:param name="semesterId" value="${semesterId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addTimetableCourseURL.toString() %>" label="timetable-course" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.ADD_SYLLABUS)%>'>
           		<portlet:renderURL var="addSyllabusURL">
					<portlet:param name="mvcPath" value="/admin/syllabuses/edit_syllabus.jsp" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
					<portlet:param name="subjectId" value="${subjectId}" />
					<portlet:param name="courseId" value="${courseId}" />
					<portlet:param name="semesterId" value="${semesterId}" />
					<portlet:param name="timetableCourseId" value="${timetableCourseId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item state="disabled" href="<%= addSyllabusURL.toString() %>" label="syllabus" />
           	</c:if>
        </aui:nav-item>
        
        <%--
        dialogos megoldashoz: https://www.liferay.com/community/forums/-/message_boards/message/41261810
        --%>
        <aui:nav-item dropdown="true" iconCssClass="icon-upload" label="import" selected='false'>
        	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.IMPORT_SYLLABUS)%>'>
        		<portlet:renderURL var="importSyllabusURL">
					<portlet:param name="mvcPath" value="/admin/import_syllabus.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=importSyllabusURL.toString()%>" label="ik_syllabus_ws.csv" />
			</c:if>
			
			<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.IMPORT_TIMETABLE)%>'>
				<portlet:renderURL var="importTimetableURL">
					<portlet:param name="mvcPath" value="/admin/import_timetable.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=importTimetableURL.toString()%>" label="ik_orarend_ws.csv" />
           	</c:if>
        </aui:nav-item>
    </aui:nav>
</aui:nav-bar>

<aui:script use="aui-base">
A.all('input[name=<portlet:namespace />rowIds]').on(
	'click',
	function(event) {
		var rowsChecked = A.all('input[name=<portlet:namespace />rowIds]:checked');
		
		toggleViewIfRequired(rowsChecked);
	}
);

A.all('input[name=<portlet:namespace />allRowIds]').on(
	'click',
	function(event) {
		var rowsChecked = A.all('input[name=<portlet:namespace />allRowIds]:checked');
		
		toggleViewIfRequired(rowsChecked);
	}
);

function toggleViewIfRequired(rowsChecked) {
	var deleteButton = A.one('.removeCheckedItemsButton');
	
	if (rowsChecked.size() > 0) {
		deleteButton.show();
	} else {
		deleteButton.hide();
	}
}
</aui:script>