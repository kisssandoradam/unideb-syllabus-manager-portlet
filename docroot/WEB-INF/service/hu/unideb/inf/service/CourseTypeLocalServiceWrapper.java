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

package hu.unideb.inf.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseTypeLocalService}.
 *
 * @author Adam Kiss
 * @see CourseTypeLocalService
 * @generated
 */
public class CourseTypeLocalServiceWrapper implements CourseTypeLocalService,
	ServiceWrapper<CourseTypeLocalService> {
	public CourseTypeLocalServiceWrapper(
		CourseTypeLocalService courseTypeLocalService) {
		_courseTypeLocalService = courseTypeLocalService;
	}

	/**
	* Adds the course type to the database. Also notifies the appropriate model listeners.
	*
	* @param courseType the course type
	* @return the course type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.CourseType addCourseType(
		hu.unideb.inf.model.CourseType courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.addCourseType(courseType);
	}

	/**
	* Creates a new course type with the primary key. Does not add the course type to the database.
	*
	* @param courseTypeId the primary key for the new course type
	* @return the new course type
	*/
	@Override
	public hu.unideb.inf.model.CourseType createCourseType(long courseTypeId) {
		return _courseTypeLocalService.createCourseType(courseTypeId);
	}

	/**
	* Deletes the course type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseTypeId the primary key of the course type
	* @return the course type that was removed
	* @throws PortalException if a course type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.CourseType deleteCourseType(long courseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.deleteCourseType(courseTypeId);
	}

	/**
	* Deletes the course type from the database. Also notifies the appropriate model listeners.
	*
	* @param courseType the course type
	* @return the course type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.CourseType deleteCourseType(
		hu.unideb.inf.model.CourseType courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.deleteCourseType(courseType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseTypeLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public hu.unideb.inf.model.CourseType fetchCourseType(long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.fetchCourseType(courseTypeId);
	}

	/**
	* Returns the course type with the primary key.
	*
	* @param courseTypeId the primary key of the course type
	* @return the course type
	* @throws PortalException if a course type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.CourseType getCourseType(long courseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.getCourseType(courseTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the course types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course types
	* @param end the upper bound of the range of course types (not inclusive)
	* @return the range of course types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.CourseType> getCourseTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.getCourseTypes(start, end);
	}

	/**
	* Returns the number of course types.
	*
	* @return the number of course types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.getCourseTypesCount();
	}

	/**
	* Updates the course type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseType the course type
	* @return the course type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.unideb.inf.model.CourseType updateCourseType(
		hu.unideb.inf.model.CourseType courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.updateCourseType(courseType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.CourseType> getCourseTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.getCourseTypes();
	}

	@Override
	public hu.unideb.inf.model.CourseType getCourseTypeByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseTypeException {
		return _courseTypeLocalService.getCourseTypeByType(type);
	}

	@Override
	public hu.unideb.inf.model.CourseType fetchCourseTypeByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.fetchCourseTypeByType(type);
	}

	@Override
	public boolean isCourseExistsWithType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.isCourseExistsWithType(type);
	}

	@Override
	public hu.unideb.inf.model.CourseType addCourseType(java.lang.String type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.addCourseType(type, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.CourseType deleteCourseType(long courseTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.deleteCourseType(courseTypeId,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.CourseType updateCourseType(long userId,
		long courseTypeId, java.lang.String type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseTypeLocalService.updateCourseType(userId, courseTypeId,
			type, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseTypeLocalService getWrappedCourseTypeLocalService() {
		return _courseTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseTypeLocalService(
		CourseTypeLocalService courseTypeLocalService) {
		_courseTypeLocalService = courseTypeLocalService;
	}

	@Override
	public CourseTypeLocalService getWrappedService() {
		return _courseTypeLocalService;
	}

	@Override
	public void setWrappedService(CourseTypeLocalService courseTypeLocalService) {
		_courseTypeLocalService = courseTypeLocalService;
	}

	private CourseTypeLocalService _courseTypeLocalService;
}