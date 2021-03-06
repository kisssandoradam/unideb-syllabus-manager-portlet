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

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.SyllabusModel;
import hu.unideb.inf.model.SyllabusSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Syllabus service. Represents a row in the &quot;syllabus_manager_Syllabus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SyllabusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SyllabusImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see SyllabusImpl
 * @see Syllabus
 * @see SyllabusModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SyllabusModelImpl extends BaseModelImpl<Syllabus>
	implements SyllabusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a syllabus model instance should use the {@link Syllabus} interface instead.
	 */
	public static final String TABLE_NAME = "syllabus_manager_Syllabus";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "syllabusId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "timetableCourseId", Types.BIGINT },
			{ "competence", Types.VARCHAR },
			{ "ethicalStandards", Types.VARCHAR },
			{ "topics", Types.VARCHAR },
			{ "educationalMaterials", Types.VARCHAR },
			{ "recommendedLiterature", Types.VARCHAR },
			{ "weeklyTasks", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("syllabusId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("timetableCourseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("competence", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ethicalStandards", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("topics", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("educationalMaterials", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("recommendedLiterature", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("weeklyTasks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table syllabus_manager_Syllabus (uuid_ VARCHAR(75) null,syllabusId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,timetableCourseId LONG,competence TEXT null,ethicalStandards TEXT null,topics TEXT null,educationalMaterials TEXT null,recommendedLiterature TEXT null,weeklyTasks TEXT null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table syllabus_manager_Syllabus";
	public static final String ORDER_BY_JPQL = " ORDER BY syllabus.syllabusId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY syllabus_manager_Syllabus.syllabusId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(hu.unideb.inf.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.hu.unideb.inf.model.Syllabus"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(hu.unideb.inf.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.hu.unideb.inf.model.Syllabus"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(hu.unideb.inf.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.hu.unideb.inf.model.Syllabus"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long TIMETABLECOURSEID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long SYLLABUSID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Syllabus toModel(SyllabusSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Syllabus model = new SyllabusImpl();

		model.setUuid(soapModel.getUuid());
		model.setSyllabusId(soapModel.getSyllabusId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTimetableCourseId(soapModel.getTimetableCourseId());
		model.setCompetence(soapModel.getCompetence());
		model.setEthicalStandards(soapModel.getEthicalStandards());
		model.setTopics(soapModel.getTopics());
		model.setEducationalMaterials(soapModel.getEducationalMaterials());
		model.setRecommendedLiterature(soapModel.getRecommendedLiterature());
		model.setWeeklyTasks(soapModel.getWeeklyTasks());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Syllabus> toModels(SyllabusSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Syllabus> models = new ArrayList<Syllabus>(soapModels.length);

		for (SyllabusSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(hu.unideb.inf.service.util.PropsUtil.get(
				"lock.expiration.time.hu.unideb.inf.model.Syllabus"));

	public SyllabusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _syllabusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSyllabusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _syllabusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Syllabus.class;
	}

	@Override
	public String getModelClassName() {
		return Syllabus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("syllabusId", getSyllabusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("timetableCourseId", getTimetableCourseId());
		attributes.put("competence", getCompetence());
		attributes.put("ethicalStandards", getEthicalStandards());
		attributes.put("topics", getTopics());
		attributes.put("educationalMaterials", getEducationalMaterials());
		attributes.put("recommendedLiterature", getRecommendedLiterature());
		attributes.put("weeklyTasks", getWeeklyTasks());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long syllabusId = (Long)attributes.get("syllabusId");

		if (syllabusId != null) {
			setSyllabusId(syllabusId);
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

		Long timetableCourseId = (Long)attributes.get("timetableCourseId");

		if (timetableCourseId != null) {
			setTimetableCourseId(timetableCourseId);
		}

		String competence = (String)attributes.get("competence");

		if (competence != null) {
			setCompetence(competence);
		}

		String ethicalStandards = (String)attributes.get("ethicalStandards");

		if (ethicalStandards != null) {
			setEthicalStandards(ethicalStandards);
		}

		String topics = (String)attributes.get("topics");

		if (topics != null) {
			setTopics(topics);
		}

		String educationalMaterials = (String)attributes.get(
				"educationalMaterials");

		if (educationalMaterials != null) {
			setEducationalMaterials(educationalMaterials);
		}

		String recommendedLiterature = (String)attributes.get(
				"recommendedLiterature");

		if (recommendedLiterature != null) {
			setRecommendedLiterature(recommendedLiterature);
		}

		String weeklyTasks = (String)attributes.get("weeklyTasks");

		if (weeklyTasks != null) {
			setWeeklyTasks(weeklyTasks);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getSyllabusId() {
		return _syllabusId;
	}

	@Override
	public void setSyllabusId(long syllabusId) {
		_syllabusId = syllabusId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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
	public long getTimetableCourseId() {
		return _timetableCourseId;
	}

	@Override
	public void setTimetableCourseId(long timetableCourseId) {
		_columnBitmask |= TIMETABLECOURSEID_COLUMN_BITMASK;

		if (!_setOriginalTimetableCourseId) {
			_setOriginalTimetableCourseId = true;

			_originalTimetableCourseId = _timetableCourseId;
		}

		_timetableCourseId = timetableCourseId;
	}

	public long getOriginalTimetableCourseId() {
		return _originalTimetableCourseId;
	}

	@JSON
	@Override
	public String getCompetence() {
		if (_competence == null) {
			return StringPool.BLANK;
		}
		else {
			return _competence;
		}
	}

	@Override
	public void setCompetence(String competence) {
		_competence = competence;
	}

	@JSON
	@Override
	public String getEthicalStandards() {
		if (_ethicalStandards == null) {
			return StringPool.BLANK;
		}
		else {
			return _ethicalStandards;
		}
	}

	@Override
	public void setEthicalStandards(String ethicalStandards) {
		_ethicalStandards = ethicalStandards;
	}

	@JSON
	@Override
	public String getTopics() {
		if (_topics == null) {
			return StringPool.BLANK;
		}
		else {
			return _topics;
		}
	}

	@Override
	public void setTopics(String topics) {
		_topics = topics;
	}

	@JSON
	@Override
	public String getEducationalMaterials() {
		if (_educationalMaterials == null) {
			return StringPool.BLANK;
		}
		else {
			return _educationalMaterials;
		}
	}

	@Override
	public void setEducationalMaterials(String educationalMaterials) {
		_educationalMaterials = educationalMaterials;
	}

	@JSON
	@Override
	public String getRecommendedLiterature() {
		if (_recommendedLiterature == null) {
			return StringPool.BLANK;
		}
		else {
			return _recommendedLiterature;
		}
	}

	@Override
	public void setRecommendedLiterature(String recommendedLiterature) {
		_recommendedLiterature = recommendedLiterature;
	}

	@JSON
	@Override
	public String getWeeklyTasks() {
		if (_weeklyTasks == null) {
			return StringPool.BLANK;
		}
		else {
			return _weeklyTasks;
		}
	}

	@Override
	public void setWeeklyTasks(String weeklyTasks) {
		_weeklyTasks = weeklyTasks;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Syllabus.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Syllabus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Syllabus toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Syllabus)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SyllabusImpl syllabusImpl = new SyllabusImpl();

		syllabusImpl.setUuid(getUuid());
		syllabusImpl.setSyllabusId(getSyllabusId());
		syllabusImpl.setGroupId(getGroupId());
		syllabusImpl.setCompanyId(getCompanyId());
		syllabusImpl.setUserId(getUserId());
		syllabusImpl.setUserName(getUserName());
		syllabusImpl.setCreateDate(getCreateDate());
		syllabusImpl.setModifiedDate(getModifiedDate());
		syllabusImpl.setTimetableCourseId(getTimetableCourseId());
		syllabusImpl.setCompetence(getCompetence());
		syllabusImpl.setEthicalStandards(getEthicalStandards());
		syllabusImpl.setTopics(getTopics());
		syllabusImpl.setEducationalMaterials(getEducationalMaterials());
		syllabusImpl.setRecommendedLiterature(getRecommendedLiterature());
		syllabusImpl.setWeeklyTasks(getWeeklyTasks());
		syllabusImpl.setStatus(getStatus());
		syllabusImpl.setStatusByUserId(getStatusByUserId());
		syllabusImpl.setStatusByUserName(getStatusByUserName());
		syllabusImpl.setStatusDate(getStatusDate());

		syllabusImpl.resetOriginalValues();

		return syllabusImpl;
	}

	@Override
	public int compareTo(Syllabus syllabus) {
		long primaryKey = syllabus.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Syllabus)) {
			return false;
		}

		Syllabus syllabus = (Syllabus)obj;

		long primaryKey = syllabus.getPrimaryKey();

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
		SyllabusModelImpl syllabusModelImpl = this;

		syllabusModelImpl._originalUuid = syllabusModelImpl._uuid;

		syllabusModelImpl._originalGroupId = syllabusModelImpl._groupId;

		syllabusModelImpl._setOriginalGroupId = false;

		syllabusModelImpl._originalCompanyId = syllabusModelImpl._companyId;

		syllabusModelImpl._setOriginalCompanyId = false;

		syllabusModelImpl._setModifiedDate = false;

		syllabusModelImpl._originalTimetableCourseId = syllabusModelImpl._timetableCourseId;

		syllabusModelImpl._setOriginalTimetableCourseId = false;

		syllabusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Syllabus> toCacheModel() {
		SyllabusCacheModel syllabusCacheModel = new SyllabusCacheModel();

		syllabusCacheModel.uuid = getUuid();

		String uuid = syllabusCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			syllabusCacheModel.uuid = null;
		}

		syllabusCacheModel.syllabusId = getSyllabusId();

		syllabusCacheModel.groupId = getGroupId();

		syllabusCacheModel.companyId = getCompanyId();

		syllabusCacheModel.userId = getUserId();

		syllabusCacheModel.userName = getUserName();

		String userName = syllabusCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			syllabusCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			syllabusCacheModel.createDate = createDate.getTime();
		}
		else {
			syllabusCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			syllabusCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			syllabusCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		syllabusCacheModel.timetableCourseId = getTimetableCourseId();

		syllabusCacheModel.competence = getCompetence();

		String competence = syllabusCacheModel.competence;

		if ((competence != null) && (competence.length() == 0)) {
			syllabusCacheModel.competence = null;
		}

		syllabusCacheModel.ethicalStandards = getEthicalStandards();

		String ethicalStandards = syllabusCacheModel.ethicalStandards;

		if ((ethicalStandards != null) && (ethicalStandards.length() == 0)) {
			syllabusCacheModel.ethicalStandards = null;
		}

		syllabusCacheModel.topics = getTopics();

		String topics = syllabusCacheModel.topics;

		if ((topics != null) && (topics.length() == 0)) {
			syllabusCacheModel.topics = null;
		}

		syllabusCacheModel.educationalMaterials = getEducationalMaterials();

		String educationalMaterials = syllabusCacheModel.educationalMaterials;

		if ((educationalMaterials != null) &&
				(educationalMaterials.length() == 0)) {
			syllabusCacheModel.educationalMaterials = null;
		}

		syllabusCacheModel.recommendedLiterature = getRecommendedLiterature();

		String recommendedLiterature = syllabusCacheModel.recommendedLiterature;

		if ((recommendedLiterature != null) &&
				(recommendedLiterature.length() == 0)) {
			syllabusCacheModel.recommendedLiterature = null;
		}

		syllabusCacheModel.weeklyTasks = getWeeklyTasks();

		String weeklyTasks = syllabusCacheModel.weeklyTasks;

		if ((weeklyTasks != null) && (weeklyTasks.length() == 0)) {
			syllabusCacheModel.weeklyTasks = null;
		}

		syllabusCacheModel.status = getStatus();

		syllabusCacheModel.statusByUserId = getStatusByUserId();

		syllabusCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = syllabusCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			syllabusCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			syllabusCacheModel.statusDate = statusDate.getTime();
		}
		else {
			syllabusCacheModel.statusDate = Long.MIN_VALUE;
		}

		return syllabusCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", syllabusId=");
		sb.append(getSyllabusId());
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
		sb.append(", timetableCourseId=");
		sb.append(getTimetableCourseId());
		sb.append(", competence=");
		sb.append(getCompetence());
		sb.append(", ethicalStandards=");
		sb.append(getEthicalStandards());
		sb.append(", topics=");
		sb.append(getTopics());
		sb.append(", educationalMaterials=");
		sb.append(getEducationalMaterials());
		sb.append(", recommendedLiterature=");
		sb.append(getRecommendedLiterature());
		sb.append(", weeklyTasks=");
		sb.append(getWeeklyTasks());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Syllabus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syllabusId</column-name><column-value><![CDATA[");
		sb.append(getSyllabusId());
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
			"<column><column-name>timetableCourseId</column-name><column-value><![CDATA[");
		sb.append(getTimetableCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competence</column-name><column-value><![CDATA[");
		sb.append(getCompetence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ethicalStandards</column-name><column-value><![CDATA[");
		sb.append(getEthicalStandards());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topics</column-name><column-value><![CDATA[");
		sb.append(getTopics());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>educationalMaterials</column-name><column-value><![CDATA[");
		sb.append(getEducationalMaterials());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommendedLiterature</column-name><column-value><![CDATA[");
		sb.append(getRecommendedLiterature());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weeklyTasks</column-name><column-value><![CDATA[");
		sb.append(getWeeklyTasks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Syllabus.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Syllabus.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _syllabusId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _timetableCourseId;
	private long _originalTimetableCourseId;
	private boolean _setOriginalTimetableCourseId;
	private String _competence;
	private String _ethicalStandards;
	private String _topics;
	private String _educationalMaterials;
	private String _recommendedLiterature;
	private String _weeklyTasks;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private Syllabus _escapedModel;
}