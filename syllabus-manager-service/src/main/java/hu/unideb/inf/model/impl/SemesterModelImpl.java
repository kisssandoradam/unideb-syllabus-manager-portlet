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

package hu.unideb.inf.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.SemesterModel;
import hu.unideb.inf.model.SemesterSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Semester service. Represents a row in the &quot;syllabus_manager_Semester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SemesterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SemesterImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see SemesterImpl
 * @see Semester
 * @see SemesterModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SemesterModelImpl extends BaseModelImpl<Semester>
	implements SemesterModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a semester model instance should use the {@link Semester} interface instead.
	 */
	public static final String TABLE_NAME = "syllabus_manager_Semester";
	public static final Object[][] TABLE_COLUMNS = {
			{ "semesterId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "beginYear", Types.INTEGER },
			{ "endYear", Types.INTEGER },
			{ "division", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("semesterId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("beginYear", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("endYear", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("division", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table syllabus_manager_Semester (semesterId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,beginYear INTEGER,endYear INTEGER,division INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table syllabus_manager_Semester";
	public static final String ORDER_BY_JPQL = " ORDER BY semester.beginYear DESC, semester.endYear DESC, semester.division DESC";
	public static final String ORDER_BY_SQL = " ORDER BY syllabus_manager_Semester.beginYear DESC, syllabus_manager_Semester.endYear DESC, syllabus_manager_Semester.division DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(hu.unideb.inf.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.hu.unideb.inf.model.Semester"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(hu.unideb.inf.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.hu.unideb.inf.model.Semester"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(hu.unideb.inf.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.hu.unideb.inf.model.Semester"),
			true);
	public static final long BEGINYEAR_COLUMN_BITMASK = 1L;
	public static final long DIVISION_COLUMN_BITMASK = 2L;
	public static final long ENDYEAR_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Semester toModel(SemesterSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Semester model = new SemesterImpl();

		model.setSemesterId(soapModel.getSemesterId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setBeginYear(soapModel.getBeginYear());
		model.setEndYear(soapModel.getEndYear());
		model.setDivision(soapModel.getDivision());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Semester> toModels(SemesterSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Semester> models = new ArrayList<Semester>(soapModels.length);

		for (SemesterSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(hu.unideb.inf.service.util.PropsUtil.get(
				"lock.expiration.time.hu.unideb.inf.model.Semester"));

	public SemesterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _semesterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSemesterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _semesterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Semester.class;
	}

	@Override
	public String getModelClassName() {
		return Semester.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("semesterId", getSemesterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("beginYear", getBeginYear());
		attributes.put("endYear", getEndYear());
		attributes.put("division", getDivision());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long semesterId = (Long)attributes.get("semesterId");

		if (semesterId != null) {
			setSemesterId(semesterId);
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

		Integer beginYear = (Integer)attributes.get("beginYear");

		if (beginYear != null) {
			setBeginYear(beginYear);
		}

		Integer endYear = (Integer)attributes.get("endYear");

		if (endYear != null) {
			setEndYear(endYear);
		}

		Integer division = (Integer)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}
	}

	@JSON
	@Override
	public long getSemesterId() {
		return _semesterId;
	}

	@Override
	public void setSemesterId(long semesterId) {
		_semesterId = semesterId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getBeginYear() {
		return _beginYear;
	}

	@Override
	public void setBeginYear(int beginYear) {
		_columnBitmask = -1L;

		if (!_setOriginalBeginYear) {
			_setOriginalBeginYear = true;

			_originalBeginYear = _beginYear;
		}

		_beginYear = beginYear;
	}

	public int getOriginalBeginYear() {
		return _originalBeginYear;
	}

	@JSON
	@Override
	public int getEndYear() {
		return _endYear;
	}

	@Override
	public void setEndYear(int endYear) {
		_columnBitmask = -1L;

		if (!_setOriginalEndYear) {
			_setOriginalEndYear = true;

			_originalEndYear = _endYear;
		}

		_endYear = endYear;
	}

	public int getOriginalEndYear() {
		return _originalEndYear;
	}

	@JSON
	@Override
	public int getDivision() {
		return _division;
	}

	@Override
	public void setDivision(int division) {
		_columnBitmask = -1L;

		if (!_setOriginalDivision) {
			_setOriginalDivision = true;

			_originalDivision = _division;
		}

		_division = division;
	}

	public int getOriginalDivision() {
		return _originalDivision;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Semester.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Semester toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Semester)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SemesterImpl semesterImpl = new SemesterImpl();

		semesterImpl.setSemesterId(getSemesterId());
		semesterImpl.setGroupId(getGroupId());
		semesterImpl.setCompanyId(getCompanyId());
		semesterImpl.setUserId(getUserId());
		semesterImpl.setUserName(getUserName());
		semesterImpl.setCreateDate(getCreateDate());
		semesterImpl.setModifiedDate(getModifiedDate());
		semesterImpl.setBeginYear(getBeginYear());
		semesterImpl.setEndYear(getEndYear());
		semesterImpl.setDivision(getDivision());

		semesterImpl.resetOriginalValues();

		return semesterImpl;
	}

	@Override
	public int compareTo(Semester semester) {
		int value = 0;

		if (getBeginYear() < semester.getBeginYear()) {
			value = -1;
		}
		else if (getBeginYear() > semester.getBeginYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getEndYear() < semester.getEndYear()) {
			value = -1;
		}
		else if (getEndYear() > semester.getEndYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getDivision() < semester.getDivision()) {
			value = -1;
		}
		else if (getDivision() > semester.getDivision()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Semester)) {
			return false;
		}

		Semester semester = (Semester)obj;

		long primaryKey = semester.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SemesterModelImpl semesterModelImpl = this;

		semesterModelImpl._setModifiedDate = false;

		semesterModelImpl._originalBeginYear = semesterModelImpl._beginYear;

		semesterModelImpl._setOriginalBeginYear = false;

		semesterModelImpl._originalEndYear = semesterModelImpl._endYear;

		semesterModelImpl._setOriginalEndYear = false;

		semesterModelImpl._originalDivision = semesterModelImpl._division;

		semesterModelImpl._setOriginalDivision = false;

		semesterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Semester> toCacheModel() {
		SemesterCacheModel semesterCacheModel = new SemesterCacheModel();

		semesterCacheModel.semesterId = getSemesterId();

		semesterCacheModel.groupId = getGroupId();

		semesterCacheModel.companyId = getCompanyId();

		semesterCacheModel.userId = getUserId();

		semesterCacheModel.userName = getUserName();

		String userName = semesterCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			semesterCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			semesterCacheModel.createDate = createDate.getTime();
		}
		else {
			semesterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			semesterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			semesterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		semesterCacheModel.beginYear = getBeginYear();

		semesterCacheModel.endYear = getEndYear();

		semesterCacheModel.division = getDivision();

		return semesterCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{semesterId=");
		sb.append(getSemesterId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", beginYear=");
		sb.append(getBeginYear());
		sb.append(", endYear=");
		sb.append(getEndYear());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Semester");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>semesterId</column-name><column-value><![CDATA[");
		sb.append(getSemesterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginYear</column-name><column-value><![CDATA[");
		sb.append(getBeginYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endYear</column-name><column-value><![CDATA[");
		sb.append(getEndYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>division</column-name><column-value><![CDATA[");
		sb.append(getDivision());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Semester.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Semester.class
		};
	private long _semesterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _beginYear;
	private int _originalBeginYear;
	private boolean _setOriginalBeginYear;
	private int _endYear;
	private int _originalEndYear;
	private boolean _setOriginalEndYear;
	private int _division;
	private int _originalDivision;
	private boolean _setOriginalDivision;
	private long _columnBitmask;
	private Semester _escapedModel;
}