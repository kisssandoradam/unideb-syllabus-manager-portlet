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

import hu.unideb.inf.service.SubjectLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Adam Kiss
 * @generated
 */
public class SubjectLocalServiceClpInvoker {
	public SubjectLocalServiceClpInvoker() {
		_methodName0 = "addSubject";

		_methodParameterTypes0 = new String[] { "hu.unideb.inf.model.Subject" };

		_methodName1 = "createSubject";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSubject";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSubject";

		_methodParameterTypes3 = new String[] { "hu.unideb.inf.model.Subject" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSubject";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSubject";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSubjects";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSubjectsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSubject";

		_methodParameterTypes15 = new String[] { "hu.unideb.inf.model.Subject" };

		_methodName70 = "getBeanIdentifier";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "setBeanIdentifier";

		_methodParameterTypes71 = new String[] { "java.lang.String" };

		_methodName76 = "getSubjects";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "getSubjectByCode";

		_methodParameterTypes77 = new String[] { "java.lang.String" };

		_methodName78 = "fetchSubjectByCode";

		_methodParameterTypes78 = new String[] { "java.lang.String" };

		_methodName79 = "getSubjectsByCurriculumId";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "getSubjectsByCurriculumId";

		_methodParameterTypes80 = new String[] { "long", "int", "int" };

		_methodName81 = "getSubjectsCountByCurriculumId";

		_methodParameterTypes81 = new String[] { "long" };

		_methodName82 = "isSubjectExistsWithCode";

		_methodParameterTypes82 = new String[] { "java.lang.String" };

		_methodName83 = "addSubject";

		_methodParameterTypes83 = new String[] {
				"java.lang.String", "java.lang.String", "int", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName84 = "deleteSubject";

		_methodParameterTypes84 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName85 = "updateSubject";

		_methodParameterTypes85 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SubjectLocalServiceUtil.addSubject((hu.unideb.inf.model.Subject)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SubjectLocalServiceUtil.createSubject(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SubjectLocalServiceUtil.deleteSubject(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SubjectLocalServiceUtil.deleteSubject((hu.unideb.inf.model.Subject)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SubjectLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SubjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SubjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SubjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SubjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SubjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SubjectLocalServiceUtil.fetchSubject(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubject(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SubjectLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjects(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjectsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SubjectLocalServiceUtil.updateSubject((hu.unideb.inf.model.Subject)arguments[0]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return SubjectLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			SubjectLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjects();
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjectByCode((java.lang.String)arguments[0]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SubjectLocalServiceUtil.fetchSubjectByCode((java.lang.String)arguments[0]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjectsByCurriculumId(((Long)arguments[0]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjectsByCurriculumId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SubjectLocalServiceUtil.getSubjectsCountByCurriculumId(((Long)arguments[0]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SubjectLocalServiceUtil.isSubjectExistsWithCode((java.lang.String)arguments[0]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SubjectLocalServiceUtil.addSubject((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SubjectLocalServiceUtil.deleteSubject(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SubjectLocalServiceUtil.updateSubject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
}