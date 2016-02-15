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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import hu.unideb.inf.DuplicateSubjectException;
import hu.unideb.inf.NoSuchCurriculumException;
import hu.unideb.inf.NoSuchSubjectException;
import hu.unideb.inf.SubjectCodeException;
import hu.unideb.inf.SubjectCreditException;
import hu.unideb.inf.SubjectNameException;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.base.SubjectLocalServiceBaseImpl;

/**
 * The implementation of the subject local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.SubjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.base.SubjectLocalServiceBaseImpl
 * @see hu.unideb.inf.service.SubjectLocalServiceUtil
 */
public class SubjectLocalServiceImpl extends SubjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.unideb.inf.service.SubjectLocalServiceUtil} to
	 * access the subject local service.
	 */

	public List<Subject> getSubjects() throws SystemException {
		return subjectPersistence.findAll();
	}

	public Subject getSubjectByC_S(long curriculumId, String subjectCode)
			throws SystemException, NoSuchSubjectException {
		return subjectPersistence.findByC_S(curriculumId, subjectCode);
	}

	public Subject fetchSubjectByC_S(long curriculumId, String subjectCode) throws SystemException {
		return subjectPersistence.fetchByC_S(curriculumId, subjectCode);
	}

	public List<Subject> getSubjectsByCurriculumId(long curriculumId) throws SystemException {
		return subjectPersistence.findByCurriculum(curriculumId);
	}

	public List<Subject> getSubjectsByCurriculumId(long curriculumId, int start, int end) throws SystemException {
		return subjectPersistence.findByCurriculum(curriculumId, start, end);
	}

	public int getSubjectsCountByCurriculumId(long curriculumId) throws SystemException {
		return subjectPersistence.countByCurriculum(curriculumId);
	}

	public Subject addSubject(String subjectCode, String subjectName, int credit, long curriculumId,
			ServiceContext serviceContext) throws SystemException, PortalException {
		Date now = new Date();

		long subjectId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(subjectId, subjectCode, subjectName, credit, curriculumId);

		Subject subject = subjectPersistence.create(subjectId);

		subject.setGroupId(groupId);
		subject.setCompanyId(companyId);
		subject.setUserId(userId);
		subject.setUserName(userName);
		subject.setCreateDate(serviceContext.getCreateDate(now));
		subject.setModifiedDate(serviceContext.getModifiedDate(now));
		subject.setSubjectCode(subjectCode);
		subject.setSubjectName(subjectName);
		subject.setCredit(credit);
		subject.setCurriculumId(curriculumId);

		subjectPersistence.update(subject);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Subject.class.getName(), subjectId,
				false, true, true);

		return subject;
	}

	public Subject deleteSubject(long subjectId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);

		List<Course> coursesToDelete = CourseLocalServiceUtil.getCoursesBySubjectId(subjectId);
		for (Course course : coursesToDelete) {
			CourseLocalServiceUtil.deleteCourse(course.getCourseId(), serviceContext);
		}

		resourceLocalService.deleteResource(subject.getCompanyId(), subject.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, subjectId);

		return deleteSubject(subject);
	}

	public Subject updateSubject(long userId, long subjectId, String subjectCode, String subjectName, int credit,
			long curriculumId, ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(subjectId, subjectCode, subjectName, credit, curriculumId);

		Subject subject = getSubject(subjectId);

		subject.setUserId(userId);
		subject.setUserName(user.getFullName());
		subject.setModifiedDate(serviceContext.getModifiedDate(now));
		subject.setSubjectCode(subjectCode);
		subject.setSubjectName(subjectName);
		subject.setCredit(credit);
		subject.setCurriculumId(curriculumId);

		subjectPersistence.update(subject);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Subject.class.getName(), subjectId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return subject;
	}

	protected void validate(long subjectId, String subjectCode, String subjectName, int credit, long curriculumId)
			throws PortalException, SystemException {
		if (Validator.isNull(subjectCode)) {
			throw new SubjectCodeException();
		}

		if (Validator.isNull(subjectName)) {
			throw new SubjectNameException();
		}

		if (credit < 0) {
			throw new SubjectCreditException();
		}

		try {
			CurriculumLocalServiceUtil.getCurriculum(curriculumId);
		} catch (PortalException e) {
			throw new NoSuchCurriculumException();
		}

		Subject subject = SubjectLocalServiceUtil.fetchSubjectByC_S(curriculumId, subjectCode);
		if (Validator.isNotNull(subject)) {
			if (!Validator.equals(subject.getSubjectId(), subjectId)) {
				throw new DuplicateSubjectException();
			}
		}
	}

}