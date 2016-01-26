<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>

<%@page import="hu.unideb.inf.service.CurriculumLocalServiceUtil"%>

<%@page import="hu.unideb.inf.model.Curriculum"%>

<%@page import="hu.unideb.inf.util.WebKeys"%>

<%@page import="hu.unideb.inf.service.permission.ModelPermission"%>
<%@page import="hu.unideb.inf.service.permission.CurriculumPermission"%>

<%@page import="hu.unideb.inf.DuplicateCurriculumException"%>

<portlet:defineObjects />
<theme:defineObjects />