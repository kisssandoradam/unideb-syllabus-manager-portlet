<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page import="com.liferay.portal.kernel.model.User" %>

<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="hu.unideb.inf.service.CurriculumLocalServiceUtil" %>
<%@ page import="hu.unideb.inf.service.SubjectLocalServiceUtil" %>
<%@ page import="hu.unideb.inf.service.CourseLocalServiceUtil" %>
<%@ page import="hu.unideb.inf.service.CourseTypeLocalServiceUtil" %>
<%@ page import="hu.unideb.inf.service.SemesterLocalServiceUtil" %>
<%@ page import="hu.unideb.inf.service.TimetableCourseLocalServiceUtil" %>
<%@ page import="hu.unideb.inf.service.LecturerLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>

<%@ page import="hu.unideb.inf.model.Curriculum" %>
<%@ page import="hu.unideb.inf.model.Subject" %>
<%@ page import="hu.unideb.inf.model.Course" %>
<%@ page import="hu.unideb.inf.model.CourseType" %>
<%@ page import="hu.unideb.inf.model.Semester" %>
<%@ page import="hu.unideb.inf.model.TimetableCourse" %>
<%@ page import="hu.unideb.inf.model.Lecturer" %>

<%@ page import="hu.unideb.inf.util.WebKeys" %>
<%@ page import="hu.unideb.inf.util.ActionKeys" %>
<%@ page import="hu.unideb.inf.service.util.SemesterHelper" %>

<%@ page import="hu.unideb.inf.service.permission.*" %>

<%@ page import="hu.unideb.inf.exception.*" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />