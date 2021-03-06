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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the CourseType service. Represents a row in the &quot;syllabus_manager_CourseType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Adam Kiss
 * @see CourseTypeModel
 * @see hu.unideb.inf.model.impl.CourseTypeImpl
 * @see hu.unideb.inf.model.impl.CourseTypeModelImpl
 * @generated
 */
@ImplementationClassName("hu.unideb.inf.model.impl.CourseTypeImpl")
@ProviderType
public interface CourseType extends CourseTypeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link hu.unideb.inf.model.impl.CourseTypeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CourseType, Long> COURSE_TYPE_ID_ACCESSOR = new Accessor<CourseType, Long>() {
			@Override
			public Long get(CourseType courseType) {
				return courseType.getCourseTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CourseType> getTypeClass() {
				return CourseType.class;
			}
		};
}