/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hu.unideb.inf.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TimetableCourse service. Represents a row in the &quot;syllabus_manager_TimetableCourse&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link hu.unideb.inf.model.impl.TimetableCourseImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCourse
 * @see hu.unideb.inf.model.impl.TimetableCourseImpl
 * @see hu.unideb.inf.model.impl.TimetableCourseModelImpl
 * @generated
 */
@ProviderType
public interface TimetableCourseModel extends BaseModel<TimetableCourse>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a timetable course model instance should use the {@link TimetableCourse} interface instead.
	 */

	/**
	 * Returns the primary key of this timetable course.
	 *
	 * @return the primary key of this timetable course
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this timetable course.
	 *
	 * @param primaryKey the primary key of this timetable course
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the timetable course ID of this timetable course.
	 *
	 * @return the timetable course ID of this timetable course
	 */
	public long getTimetableCourseId();

	/**
	 * Sets the timetable course ID of this timetable course.
	 *
	 * @param timetableCourseId the timetable course ID of this timetable course
	 */
	public void setTimetableCourseId(long timetableCourseId);

	/**
	 * Returns the group ID of this timetable course.
	 *
	 * @return the group ID of this timetable course
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this timetable course.
	 *
	 * @param groupId the group ID of this timetable course
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this timetable course.
	 *
	 * @return the company ID of this timetable course
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this timetable course.
	 *
	 * @param companyId the company ID of this timetable course
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this timetable course.
	 *
	 * @return the user ID of this timetable course
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this timetable course.
	 *
	 * @param userId the user ID of this timetable course
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this timetable course.
	 *
	 * @return the user uuid of this timetable course
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this timetable course.
	 *
	 * @param userUuid the user uuid of this timetable course
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this timetable course.
	 *
	 * @return the user name of this timetable course
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this timetable course.
	 *
	 * @param userName the user name of this timetable course
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this timetable course.
	 *
	 * @return the create date of this timetable course
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this timetable course.
	 *
	 * @param createDate the create date of this timetable course
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this timetable course.
	 *
	 * @return the modified date of this timetable course
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this timetable course.
	 *
	 * @param modifiedDate the modified date of this timetable course
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the course ID of this timetable course.
	 *
	 * @return the course ID of this timetable course
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this timetable course.
	 *
	 * @param courseId the course ID of this timetable course
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the semester ID of this timetable course.
	 *
	 * @return the semester ID of this timetable course
	 */
	public long getSemesterId();

	/**
	 * Sets the semester ID of this timetable course.
	 *
	 * @param semesterId the semester ID of this timetable course
	 */
	public void setSemesterId(long semesterId);

	/**
	 * Returns the timetable course code of this timetable course.
	 *
	 * @return the timetable course code of this timetable course
	 */
	@AutoEscape
	public String getTimetableCourseCode();

	/**
	 * Sets the timetable course code of this timetable course.
	 *
	 * @param timetableCourseCode the timetable course code of this timetable course
	 */
	public void setTimetableCourseCode(String timetableCourseCode);

	/**
	 * Returns the subject type of this timetable course.
	 *
	 * @return the subject type of this timetable course
	 */
	@AutoEscape
	public String getSubjectType();

	/**
	 * Sets the subject type of this timetable course.
	 *
	 * @param subjectType the subject type of this timetable course
	 */
	public void setSubjectType(String subjectType);

	/**
	 * Returns the recommended term of this timetable course.
	 *
	 * @return the recommended term of this timetable course
	 */
	public int getRecommendedTerm();

	/**
	 * Sets the recommended term of this timetable course.
	 *
	 * @param recommendedTerm the recommended term of this timetable course
	 */
	public void setRecommendedTerm(int recommendedTerm);

	/**
	 * Returns the limit of this timetable course.
	 *
	 * @return the limit of this timetable course
	 */
	public int getLimit();

	/**
	 * Sets the limit of this timetable course.
	 *
	 * @param limit the limit of this timetable course
	 */
	public void setLimit(int limit);

	/**
	 * Returns the class schedule info of this timetable course.
	 *
	 * @return the class schedule info of this timetable course
	 */
	@AutoEscape
	public String getClassScheduleInfo();

	/**
	 * Sets the class schedule info of this timetable course.
	 *
	 * @param classScheduleInfo the class schedule info of this timetable course
	 */
	public void setClassScheduleInfo(String classScheduleInfo);

	/**
	 * Returns the description of this timetable course.
	 *
	 * @return the description of this timetable course
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this timetable course.
	 *
	 * @param description the description of this timetable course
	 */
	public void setDescription(String description);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(hu.unideb.inf.model.TimetableCourse timetableCourse);

	@Override
	public int hashCode();

	@Override
	public CacheModel<hu.unideb.inf.model.TimetableCourse> toCacheModel();

	@Override
	public hu.unideb.inf.model.TimetableCourse toEscapedModel();

	@Override
	public hu.unideb.inf.model.TimetableCourse toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}