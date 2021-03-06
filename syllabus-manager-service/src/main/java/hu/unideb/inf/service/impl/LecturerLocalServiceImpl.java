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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.exception.DeleteTimetableCoursesFirstException;
import hu.unideb.inf.exception.DuplicateLecturerException;
import hu.unideb.inf.exception.LecturerNameException;
import hu.unideb.inf.exception.NoSuchLecturerException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.service.base.LecturerLocalServiceBaseImpl;

/**
 * The implementation of the lecturer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.LecturerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerLocalServiceBaseImpl
 * @see hu.unideb.inf.service.LecturerLocalServiceUtil
 */
@ProviderType
public class LecturerLocalServiceImpl extends LecturerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.LecturerLocalServiceUtil} to access
	 * the lecturer local service.
	 */

	public List<Lecturer> getLecturers() throws SystemException {
		return lecturerPersistence.findAll();
	}

	public List<Lecturer> getLecturersByIds(long[] lecturerIds) throws NoSuchLecturerException, SystemException {
		List<Lecturer> lecturers = new ArrayList<>();

		for (long lecturerId : lecturerIds) {
			lecturers.add(lecturerPersistence.findByPrimaryKey(lecturerId));
		}

		return lecturers;
	}

	public Lecturer getLecturerByN_U(String lecturerName, long lecturerUserId) throws NoSuchLecturerException {
		return lecturerPersistence.findByN_U(lecturerName, lecturerUserId);
	}

	public Lecturer fetchLecturerByN_U(String lecturerName, long lecturerUserId) {
		return lecturerPersistence.fetchByN_U(lecturerName, lecturerUserId);
	}

	// public Lecturer getLecturerByName(String lecturerName) throws NoSuchLecturerException, SystemException {
	// return lecturerPersistence.findByLecturerName(lecturerName);
	// }
	//
	// public Lecturer fetchLecturerByName(String lecturerName) throws SystemException {
	// return lecturerPersistence.fetchByLecturerName(lecturerName);
	// }

	public Lecturer addLecturer(String lecturerName, long lecturerUserId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();

		long lecturerId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(lecturerId, lecturerName, lecturerUserId);

		Lecturer lecturer = lecturerPersistence.create(lecturerId);
		lecturer.setGroupId(groupId);
		lecturer.setCompanyId(companyId);
		lecturer.setUserId(userId);
		lecturer.setUserName(userName);
		lecturer.setCreateDate(serviceContext.getCreateDate(now));
		lecturer.setModifiedDate(serviceContext.getModifiedDate(now));
		lecturer.setLecturerName(lecturerName);
		lecturer.setLecturerUserId(lecturerUserId);

		lecturerPersistence.update(lecturer);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Lecturer.class.getName(), lecturerId,
				false, true, true);

		return lecturer;
	}

	public Lecturer deleteLecturer(long lecturerId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		if (!timetableCourseLocalService.getLecturerTimetableCourses(lecturerId).isEmpty()) {
			throw new DeleteTimetableCoursesFirstException();
		}

		lecturerPersistence.clearTimetableCourses(lecturerId);

		Lecturer lecturer = lecturerLocalService.getLecturer(lecturerId);

		resourceLocalService.deleteResource(lecturer.getCompanyId(), lecturer.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, lecturerId);

		return deleteLecturer(lecturer);
	}

	public Lecturer updateLecturer(long userId, long lecturerId, String lecturerName, long lecturerUserId,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(lecturerId, lecturerName, lecturerUserId);

		Lecturer lecturer = lecturerLocalService.getLecturer(lecturerId);
		lecturer.setUserId(userId);
		lecturer.setUserName(user.getFullName());
		lecturer.setModifiedDate(serviceContext.getModifiedDate(now));
		lecturer.setLecturerName(lecturerName);
		lecturer.setLecturerUserId(lecturerUserId);

		lecturerPersistence.update(lecturer);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Lecturer.class.getName(), lecturerId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return lecturer;
	}

	private void validate(long lecturerId, String lecturerName, long lecturerUserId)
			throws PortalException, SystemException {
		if (Validator.isNull(lecturerName)) {
			throw new LecturerNameException();
		}

		Lecturer lecturer = lecturerLocalService.fetchLecturerByN_U(lecturerName, lecturerUserId);
		if (Validator.isNotNull(lecturer)) {
			if (lecturer.getLecturerId() != lecturerId) {
				throw new DuplicateLecturerException();
			}
		}
	}

}