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

package hu.unideb.inf.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.exception.CourseTypeException;
import hu.unideb.inf.exception.DeleteCoursesFirstException;
import hu.unideb.inf.exception.DuplicateCourseTypeException;
import hu.unideb.inf.exception.NoSuchCourseTypeException;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.base.CourseTypeLocalServiceBaseImpl;

/**
 * The implementation of the course type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.service.CourseTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseTypeLocalServiceBaseImpl
 * @see hu.unideb.inf.service.CourseTypeLocalServiceUtil
 */
@ProviderType
public class CourseTypeLocalServiceImpl extends CourseTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.CourseTypeLocalServiceUtil} to access the course type local service.
	 */

	public List<CourseType> getCourseTypes() throws SystemException {
		return courseTypePersistence.findAll();
	}

	public CourseType getCourseTypeByTypeName(String typeName) throws NoSuchCourseTypeException, SystemException {
		return courseTypePersistence.findByTypeName(typeName);
	}

	public CourseType fetchCourseTypeByTypeName(String typeName) throws SystemException {
		return courseTypePersistence.fetchByTypeName(typeName);
	}

	public CourseType addCourseType(String typeName, ServiceContext serviceContext)
			throws SystemException, PortalException {
		Date now = new Date();

		long courseTypeId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(courseTypeId, typeName);

		CourseType courseType = courseTypePersistence.create(courseTypeId);

		courseType.setGroupId(groupId);
		courseType.setCompanyId(companyId);
		courseType.setUserId(userId);
		courseType.setUserName(userName);
		courseType.setCreateDate(serviceContext.getCreateDate(now));
		courseType.setModifiedDate(serviceContext.getModifiedDate(now));
		courseType.setTypeName(typeName);

		courseTypePersistence.update(courseType);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, CourseType.class.getName(),
				courseTypeId, false, true, true);

		return courseType;
	}

	public CourseType deleteCourseType(long courseTypeId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		if (!courseLocalService.getCoursesByCourseTypeId(courseTypeId).isEmpty()) {
			throw new DeleteCoursesFirstException();
		}

		CourseType courseType = courseTypeLocalService.getCourseType(courseTypeId);

		resourceLocalService.deleteResource(courseType.getCompanyId(), courseType.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, courseTypeId);

		return deleteCourseType(courseType);
	}

	public CourseType updateCourseType(long userId, long courseTypeId, String typeName, ServiceContext serviceContext)
			throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(courseTypeId, typeName);

		CourseType courseType = getCourseType(courseTypeId);

		courseType.setUserId(userId);
		courseType.setUserName(user.getFullName());
		courseType.setModifiedDate(serviceContext.getModifiedDate(now));
		courseType.setTypeName(typeName);

		courseTypePersistence.update(courseType);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, CourseType.class.getName(), courseTypeId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return courseType;
	}

	protected void validate(long courseTypeId, String typeName) throws PortalException, SystemException {
		if (Validator.isNull(typeName)) {
			throw new CourseTypeException();
		}

		CourseType courseType = courseTypeLocalService.fetchCourseTypeByTypeName(typeName);
		if (Validator.isNotNull(courseType)) {
			if (courseType.getCourseTypeId() != courseTypeId) {
				throw new DuplicateCourseTypeException();
			}
		}
	}
	
}