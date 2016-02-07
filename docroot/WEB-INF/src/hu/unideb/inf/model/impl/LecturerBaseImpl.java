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

import com.liferay.portal.kernel.exception.SystemException;

import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.service.LecturerLocalServiceUtil;

/**
 * The extended model base implementation for the Lecturer service. Represents a row in the &quot;unideb_syllabus_manager_Lecturer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LecturerImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerImpl
 * @see hu.unideb.inf.model.Lecturer
 * @generated
 */
public abstract class LecturerBaseImpl extends LecturerModelImpl
	implements Lecturer {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lecturer model instance should use the {@link Lecturer} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LecturerLocalServiceUtil.addLecturer(this);
		}
		else {
			LecturerLocalServiceUtil.updateLecturer(this);
		}
	}
}