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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Lecturer}.
 * </p>
 *
 * @author Adam Kiss
 * @see Lecturer
 * @generated
 */
public class LecturerWrapper implements Lecturer, ModelWrapper<Lecturer> {
	public LecturerWrapper(Lecturer lecturer) {
		_lecturer = lecturer;
	}

	@Override
	public Class<?> getModelClass() {
		return Lecturer.class;
	}

	@Override
	public String getModelClassName() {
		return Lecturer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lecturerId", getLecturerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lecturerName", getLecturerName());
		attributes.put("lecturerUserId", getLecturerUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lecturerId = (Long)attributes.get("lecturerId");

		if (lecturerId != null) {
			setLecturerId(lecturerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String lecturerName = (String)attributes.get("lecturerName");

		if (lecturerName != null) {
			setLecturerName(lecturerName);
		}

		Long lecturerUserId = (Long)attributes.get("lecturerUserId");

		if (lecturerUserId != null) {
			setLecturerUserId(lecturerUserId);
		}
	}

	/**
	* Returns the primary key of this lecturer.
	*
	* @return the primary key of this lecturer
	*/
	@Override
	public long getPrimaryKey() {
		return _lecturer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lecturer.
	*
	* @param primaryKey the primary key of this lecturer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lecturer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lecturer ID of this lecturer.
	*
	* @return the lecturer ID of this lecturer
	*/
	@Override
	public long getLecturerId() {
		return _lecturer.getLecturerId();
	}

	/**
	* Sets the lecturer ID of this lecturer.
	*
	* @param lecturerId the lecturer ID of this lecturer
	*/
	@Override
	public void setLecturerId(long lecturerId) {
		_lecturer.setLecturerId(lecturerId);
	}

	/**
	* Returns the group ID of this lecturer.
	*
	* @return the group ID of this lecturer
	*/
	@Override
	public long getGroupId() {
		return _lecturer.getGroupId();
	}

	/**
	* Sets the group ID of this lecturer.
	*
	* @param groupId the group ID of this lecturer
	*/
	@Override
	public void setGroupId(long groupId) {
		_lecturer.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this lecturer.
	*
	* @return the company ID of this lecturer
	*/
	@Override
	public long getCompanyId() {
		return _lecturer.getCompanyId();
	}

	/**
	* Sets the company ID of this lecturer.
	*
	* @param companyId the company ID of this lecturer
	*/
	@Override
	public void setCompanyId(long companyId) {
		_lecturer.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this lecturer.
	*
	* @return the user ID of this lecturer
	*/
	@Override
	public long getUserId() {
		return _lecturer.getUserId();
	}

	/**
	* Sets the user ID of this lecturer.
	*
	* @param userId the user ID of this lecturer
	*/
	@Override
	public void setUserId(long userId) {
		_lecturer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this lecturer.
	*
	* @return the user uuid of this lecturer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturer.getUserUuid();
	}

	/**
	* Sets the user uuid of this lecturer.
	*
	* @param userUuid the user uuid of this lecturer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_lecturer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this lecturer.
	*
	* @return the user name of this lecturer
	*/
	@Override
	public java.lang.String getUserName() {
		return _lecturer.getUserName();
	}

	/**
	* Sets the user name of this lecturer.
	*
	* @param userName the user name of this lecturer
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_lecturer.setUserName(userName);
	}

	/**
	* Returns the create date of this lecturer.
	*
	* @return the create date of this lecturer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _lecturer.getCreateDate();
	}

	/**
	* Sets the create date of this lecturer.
	*
	* @param createDate the create date of this lecturer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_lecturer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this lecturer.
	*
	* @return the modified date of this lecturer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _lecturer.getModifiedDate();
	}

	/**
	* Sets the modified date of this lecturer.
	*
	* @param modifiedDate the modified date of this lecturer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_lecturer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the lecturer name of this lecturer.
	*
	* @return the lecturer name of this lecturer
	*/
	@Override
	public java.lang.String getLecturerName() {
		return _lecturer.getLecturerName();
	}

	/**
	* Sets the lecturer name of this lecturer.
	*
	* @param lecturerName the lecturer name of this lecturer
	*/
	@Override
	public void setLecturerName(java.lang.String lecturerName) {
		_lecturer.setLecturerName(lecturerName);
	}

	/**
	* Returns the lecturer user ID of this lecturer.
	*
	* @return the lecturer user ID of this lecturer
	*/
	@Override
	public long getLecturerUserId() {
		return _lecturer.getLecturerUserId();
	}

	/**
	* Sets the lecturer user ID of this lecturer.
	*
	* @param lecturerUserId the lecturer user ID of this lecturer
	*/
	@Override
	public void setLecturerUserId(long lecturerUserId) {
		_lecturer.setLecturerUserId(lecturerUserId);
	}

	/**
	* Returns the lecturer user uuid of this lecturer.
	*
	* @return the lecturer user uuid of this lecturer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getLecturerUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturer.getLecturerUserUuid();
	}

	/**
	* Sets the lecturer user uuid of this lecturer.
	*
	* @param lecturerUserUuid the lecturer user uuid of this lecturer
	*/
	@Override
	public void setLecturerUserUuid(java.lang.String lecturerUserUuid) {
		_lecturer.setLecturerUserUuid(lecturerUserUuid);
	}

	@Override
	public boolean isNew() {
		return _lecturer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lecturer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lecturer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lecturer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lecturer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lecturer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lecturer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lecturer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lecturer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lecturer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lecturer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LecturerWrapper((Lecturer)_lecturer.clone());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.Lecturer lecturer) {
		return _lecturer.compareTo(lecturer);
	}

	@Override
	public int hashCode() {
		return _lecturer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.unideb.inf.model.Lecturer> toCacheModel() {
		return _lecturer.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.Lecturer toEscapedModel() {
		return new LecturerWrapper(_lecturer.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.Lecturer toUnescapedModel() {
		return new LecturerWrapper(_lecturer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lecturer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lecturer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lecturer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LecturerWrapper)) {
			return false;
		}

		LecturerWrapper lecturerWrapper = (LecturerWrapper)obj;

		if (Validator.equals(_lecturer, lecturerWrapper._lecturer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Lecturer getWrappedLecturer() {
		return _lecturer;
	}

	@Override
	public Lecturer getWrappedModel() {
		return _lecturer;
	}

	@Override
	public void resetOriginalValues() {
		_lecturer.resetOriginalValues();
	}

	private Lecturer _lecturer;
}