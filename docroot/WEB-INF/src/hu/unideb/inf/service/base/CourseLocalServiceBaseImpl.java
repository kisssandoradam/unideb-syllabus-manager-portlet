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

package hu.unideb.inf.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.service.CourseLocalService;
import hu.unideb.inf.service.persistence.CoursePersistence;
import hu.unideb.inf.service.persistence.CourseTypePersistence;
import hu.unideb.inf.service.persistence.CurriculumPersistence;
import hu.unideb.inf.service.persistence.LecturerPersistence;
import hu.unideb.inf.service.persistence.SemesterPersistence;
import hu.unideb.inf.service.persistence.SubjectPersistence;
import hu.unideb.inf.service.persistence.TimetableCoursePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the course local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.unideb.inf.service.impl.CourseLocalServiceImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.impl.CourseLocalServiceImpl
 * @see hu.unideb.inf.service.CourseLocalServiceUtil
 * @generated
 */
public abstract class CourseLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CourseLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.unideb.inf.service.CourseLocalServiceUtil} to access the course local service.
	 */

	/**
	 * Adds the course to the database. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Course addCourse(Course course) throws SystemException {
		course.setNew(true);

		return coursePersistence.update(course);
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public Course createCourse(long courseId) {
		return coursePersistence.create(courseId);
	}

	/**
	 * Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws PortalException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Course deleteCourse(long courseId)
		throws PortalException, SystemException {
		return coursePersistence.remove(courseId);
	}

	/**
	 * Deletes the course from the database. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Course deleteCourse(Course course) throws SystemException {
		return coursePersistence.remove(course);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Course.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return coursePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return coursePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return coursePersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return coursePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return coursePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Course fetchCourse(long courseId) throws SystemException {
		return coursePersistence.fetchByPrimaryKey(courseId);
	}

	/**
	 * Returns the course with the primary key.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws PortalException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course getCourse(long courseId)
		throws PortalException, SystemException {
		return coursePersistence.findByPrimaryKey(courseId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return coursePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Course> getCourses(int start, int end)
		throws SystemException {
		return coursePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCoursesCount() throws SystemException {
		return coursePersistence.countAll();
	}

	/**
	 * Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Course updateCourse(Course course) throws SystemException {
		return coursePersistence.update(course);
	}

	/**
	 * Returns the course local service.
	 *
	 * @return the course local service
	 */
	public hu.unideb.inf.service.CourseLocalService getCourseLocalService() {
		return courseLocalService;
	}

	/**
	 * Sets the course local service.
	 *
	 * @param courseLocalService the course local service
	 */
	public void setCourseLocalService(
		hu.unideb.inf.service.CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	/**
	 * Returns the course remote service.
	 *
	 * @return the course remote service
	 */
	public hu.unideb.inf.service.CourseService getCourseService() {
		return courseService;
	}

	/**
	 * Sets the course remote service.
	 *
	 * @param courseService the course remote service
	 */
	public void setCourseService(
		hu.unideb.inf.service.CourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * Returns the course persistence.
	 *
	 * @return the course persistence
	 */
	public CoursePersistence getCoursePersistence() {
		return coursePersistence;
	}

	/**
	 * Sets the course persistence.
	 *
	 * @param coursePersistence the course persistence
	 */
	public void setCoursePersistence(CoursePersistence coursePersistence) {
		this.coursePersistence = coursePersistence;
	}

	/**
	 * Returns the course type local service.
	 *
	 * @return the course type local service
	 */
	public hu.unideb.inf.service.CourseTypeLocalService getCourseTypeLocalService() {
		return courseTypeLocalService;
	}

	/**
	 * Sets the course type local service.
	 *
	 * @param courseTypeLocalService the course type local service
	 */
	public void setCourseTypeLocalService(
		hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService) {
		this.courseTypeLocalService = courseTypeLocalService;
	}

	/**
	 * Returns the course type remote service.
	 *
	 * @return the course type remote service
	 */
	public hu.unideb.inf.service.CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}

	/**
	 * Sets the course type remote service.
	 *
	 * @param courseTypeService the course type remote service
	 */
	public void setCourseTypeService(
		hu.unideb.inf.service.CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}

	/**
	 * Returns the course type persistence.
	 *
	 * @return the course type persistence
	 */
	public CourseTypePersistence getCourseTypePersistence() {
		return courseTypePersistence;
	}

	/**
	 * Sets the course type persistence.
	 *
	 * @param courseTypePersistence the course type persistence
	 */
	public void setCourseTypePersistence(
		CourseTypePersistence courseTypePersistence) {
		this.courseTypePersistence = courseTypePersistence;
	}

	/**
	 * Returns the curriculum local service.
	 *
	 * @return the curriculum local service
	 */
	public hu.unideb.inf.service.CurriculumLocalService getCurriculumLocalService() {
		return curriculumLocalService;
	}

	/**
	 * Sets the curriculum local service.
	 *
	 * @param curriculumLocalService the curriculum local service
	 */
	public void setCurriculumLocalService(
		hu.unideb.inf.service.CurriculumLocalService curriculumLocalService) {
		this.curriculumLocalService = curriculumLocalService;
	}

	/**
	 * Returns the curriculum remote service.
	 *
	 * @return the curriculum remote service
	 */
	public hu.unideb.inf.service.CurriculumService getCurriculumService() {
		return curriculumService;
	}

	/**
	 * Sets the curriculum remote service.
	 *
	 * @param curriculumService the curriculum remote service
	 */
	public void setCurriculumService(
		hu.unideb.inf.service.CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}

	/**
	 * Returns the curriculum persistence.
	 *
	 * @return the curriculum persistence
	 */
	public CurriculumPersistence getCurriculumPersistence() {
		return curriculumPersistence;
	}

	/**
	 * Sets the curriculum persistence.
	 *
	 * @param curriculumPersistence the curriculum persistence
	 */
	public void setCurriculumPersistence(
		CurriculumPersistence curriculumPersistence) {
		this.curriculumPersistence = curriculumPersistence;
	}

	/**
	 * Returns the lecturer local service.
	 *
	 * @return the lecturer local service
	 */
	public hu.unideb.inf.service.LecturerLocalService getLecturerLocalService() {
		return lecturerLocalService;
	}

	/**
	 * Sets the lecturer local service.
	 *
	 * @param lecturerLocalService the lecturer local service
	 */
	public void setLecturerLocalService(
		hu.unideb.inf.service.LecturerLocalService lecturerLocalService) {
		this.lecturerLocalService = lecturerLocalService;
	}

	/**
	 * Returns the lecturer remote service.
	 *
	 * @return the lecturer remote service
	 */
	public hu.unideb.inf.service.LecturerService getLecturerService() {
		return lecturerService;
	}

	/**
	 * Sets the lecturer remote service.
	 *
	 * @param lecturerService the lecturer remote service
	 */
	public void setLecturerService(
		hu.unideb.inf.service.LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	/**
	 * Returns the lecturer persistence.
	 *
	 * @return the lecturer persistence
	 */
	public LecturerPersistence getLecturerPersistence() {
		return lecturerPersistence;
	}

	/**
	 * Sets the lecturer persistence.
	 *
	 * @param lecturerPersistence the lecturer persistence
	 */
	public void setLecturerPersistence(LecturerPersistence lecturerPersistence) {
		this.lecturerPersistence = lecturerPersistence;
	}

	/**
	 * Returns the semester local service.
	 *
	 * @return the semester local service
	 */
	public hu.unideb.inf.service.SemesterLocalService getSemesterLocalService() {
		return semesterLocalService;
	}

	/**
	 * Sets the semester local service.
	 *
	 * @param semesterLocalService the semester local service
	 */
	public void setSemesterLocalService(
		hu.unideb.inf.service.SemesterLocalService semesterLocalService) {
		this.semesterLocalService = semesterLocalService;
	}

	/**
	 * Returns the semester remote service.
	 *
	 * @return the semester remote service
	 */
	public hu.unideb.inf.service.SemesterService getSemesterService() {
		return semesterService;
	}

	/**
	 * Sets the semester remote service.
	 *
	 * @param semesterService the semester remote service
	 */
	public void setSemesterService(
		hu.unideb.inf.service.SemesterService semesterService) {
		this.semesterService = semesterService;
	}

	/**
	 * Returns the semester persistence.
	 *
	 * @return the semester persistence
	 */
	public SemesterPersistence getSemesterPersistence() {
		return semesterPersistence;
	}

	/**
	 * Sets the semester persistence.
	 *
	 * @param semesterPersistence the semester persistence
	 */
	public void setSemesterPersistence(SemesterPersistence semesterPersistence) {
		this.semesterPersistence = semesterPersistence;
	}

	/**
	 * Returns the subject local service.
	 *
	 * @return the subject local service
	 */
	public hu.unideb.inf.service.SubjectLocalService getSubjectLocalService() {
		return subjectLocalService;
	}

	/**
	 * Sets the subject local service.
	 *
	 * @param subjectLocalService the subject local service
	 */
	public void setSubjectLocalService(
		hu.unideb.inf.service.SubjectLocalService subjectLocalService) {
		this.subjectLocalService = subjectLocalService;
	}

	/**
	 * Returns the subject remote service.
	 *
	 * @return the subject remote service
	 */
	public hu.unideb.inf.service.SubjectService getSubjectService() {
		return subjectService;
	}

	/**
	 * Sets the subject remote service.
	 *
	 * @param subjectService the subject remote service
	 */
	public void setSubjectService(
		hu.unideb.inf.service.SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * Returns the subject persistence.
	 *
	 * @return the subject persistence
	 */
	public SubjectPersistence getSubjectPersistence() {
		return subjectPersistence;
	}

	/**
	 * Sets the subject persistence.
	 *
	 * @param subjectPersistence the subject persistence
	 */
	public void setSubjectPersistence(SubjectPersistence subjectPersistence) {
		this.subjectPersistence = subjectPersistence;
	}

	/**
	 * Returns the timetable course local service.
	 *
	 * @return the timetable course local service
	 */
	public hu.unideb.inf.service.TimetableCourseLocalService getTimetableCourseLocalService() {
		return timetableCourseLocalService;
	}

	/**
	 * Sets the timetable course local service.
	 *
	 * @param timetableCourseLocalService the timetable course local service
	 */
	public void setTimetableCourseLocalService(
		hu.unideb.inf.service.TimetableCourseLocalService timetableCourseLocalService) {
		this.timetableCourseLocalService = timetableCourseLocalService;
	}

	/**
	 * Returns the timetable course remote service.
	 *
	 * @return the timetable course remote service
	 */
	public hu.unideb.inf.service.TimetableCourseService getTimetableCourseService() {
		return timetableCourseService;
	}

	/**
	 * Sets the timetable course remote service.
	 *
	 * @param timetableCourseService the timetable course remote service
	 */
	public void setTimetableCourseService(
		hu.unideb.inf.service.TimetableCourseService timetableCourseService) {
		this.timetableCourseService = timetableCourseService;
	}

	/**
	 * Returns the timetable course persistence.
	 *
	 * @return the timetable course persistence
	 */
	public TimetableCoursePersistence getTimetableCoursePersistence() {
		return timetableCoursePersistence;
	}

	/**
	 * Sets the timetable course persistence.
	 *
	 * @param timetableCoursePersistence the timetable course persistence
	 */
	public void setTimetableCoursePersistence(
		TimetableCoursePersistence timetableCoursePersistence) {
		this.timetableCoursePersistence = timetableCoursePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("hu.unideb.inf.model.Course",
			courseLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"hu.unideb.inf.model.Course");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Course.class;
	}

	protected String getModelClassName() {
		return Course.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = coursePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = hu.unideb.inf.service.CourseLocalService.class)
	protected hu.unideb.inf.service.CourseLocalService courseLocalService;
	@BeanReference(type = hu.unideb.inf.service.CourseService.class)
	protected hu.unideb.inf.service.CourseService courseService;
	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeLocalService.class)
	protected hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeService.class)
	protected hu.unideb.inf.service.CourseTypeService courseTypeService;
	@BeanReference(type = CourseTypePersistence.class)
	protected CourseTypePersistence courseTypePersistence;
	@BeanReference(type = hu.unideb.inf.service.CurriculumLocalService.class)
	protected hu.unideb.inf.service.CurriculumLocalService curriculumLocalService;
	@BeanReference(type = hu.unideb.inf.service.CurriculumService.class)
	protected hu.unideb.inf.service.CurriculumService curriculumService;
	@BeanReference(type = CurriculumPersistence.class)
	protected CurriculumPersistence curriculumPersistence;
	@BeanReference(type = hu.unideb.inf.service.LecturerLocalService.class)
	protected hu.unideb.inf.service.LecturerLocalService lecturerLocalService;
	@BeanReference(type = hu.unideb.inf.service.LecturerService.class)
	protected hu.unideb.inf.service.LecturerService lecturerService;
	@BeanReference(type = LecturerPersistence.class)
	protected LecturerPersistence lecturerPersistence;
	@BeanReference(type = hu.unideb.inf.service.SemesterLocalService.class)
	protected hu.unideb.inf.service.SemesterLocalService semesterLocalService;
	@BeanReference(type = hu.unideb.inf.service.SemesterService.class)
	protected hu.unideb.inf.service.SemesterService semesterService;
	@BeanReference(type = SemesterPersistence.class)
	protected SemesterPersistence semesterPersistence;
	@BeanReference(type = hu.unideb.inf.service.SubjectLocalService.class)
	protected hu.unideb.inf.service.SubjectLocalService subjectLocalService;
	@BeanReference(type = hu.unideb.inf.service.SubjectService.class)
	protected hu.unideb.inf.service.SubjectService subjectService;
	@BeanReference(type = SubjectPersistence.class)
	protected SubjectPersistence subjectPersistence;
	@BeanReference(type = hu.unideb.inf.service.TimetableCourseLocalService.class)
	protected hu.unideb.inf.service.TimetableCourseLocalService timetableCourseLocalService;
	@BeanReference(type = hu.unideb.inf.service.TimetableCourseService.class)
	protected hu.unideb.inf.service.TimetableCourseService timetableCourseService;
	@BeanReference(type = TimetableCoursePersistence.class)
	protected TimetableCoursePersistence timetableCoursePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CourseLocalServiceClpInvoker _clpInvoker = new CourseLocalServiceClpInvoker();
}