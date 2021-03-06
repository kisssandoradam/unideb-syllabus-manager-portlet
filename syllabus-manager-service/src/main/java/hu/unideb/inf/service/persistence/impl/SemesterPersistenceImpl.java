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

package hu.unideb.inf.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.unideb.inf.exception.NoSuchSemesterException;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.impl.SemesterImpl;
import hu.unideb.inf.model.impl.SemesterModelImpl;
import hu.unideb.inf.service.persistence.SemesterPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the semester service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SemesterPersistence
 * @see hu.unideb.inf.service.persistence.SemesterUtil
 * @generated
 */
@ProviderType
public class SemesterPersistenceImpl extends BasePersistenceImpl<Semester>
	implements SemesterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SemesterUtil} to access the semester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SemesterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterModelImpl.FINDER_CACHE_ENABLED, SemesterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterModelImpl.FINDER_CACHE_ENABLED, SemesterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_B_E_D = new FinderPath(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterModelImpl.FINDER_CACHE_ENABLED, SemesterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByB_E_D",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			SemesterModelImpl.BEGINYEAR_COLUMN_BITMASK |
			SemesterModelImpl.ENDYEAR_COLUMN_BITMASK |
			SemesterModelImpl.DIVISION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_E_D = new FinderPath(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_E_D",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or throws a {@link NoSuchSemesterException} if it could not be found.
	 *
	 * @param beginYear the begin year
	 * @param endYear the end year
	 * @param division the division
	 * @return the matching semester
	 * @throws NoSuchSemesterException if a matching semester could not be found
	 */
	@Override
	public Semester findByB_E_D(int beginYear, int endYear, int division)
		throws NoSuchSemesterException {
		Semester semester = fetchByB_E_D(beginYear, endYear, division);

		if (semester == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("beginYear=");
			msg.append(beginYear);

			msg.append(", endYear=");
			msg.append(endYear);

			msg.append(", division=");
			msg.append(division);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSemesterException(msg.toString());
		}

		return semester;
	}

	/**
	 * Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beginYear the begin year
	 * @param endYear the end year
	 * @param division the division
	 * @return the matching semester, or <code>null</code> if a matching semester could not be found
	 */
	@Override
	public Semester fetchByB_E_D(int beginYear, int endYear, int division) {
		return fetchByB_E_D(beginYear, endYear, division, true);
	}

	/**
	 * Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beginYear the begin year
	 * @param endYear the end year
	 * @param division the division
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching semester, or <code>null</code> if a matching semester could not be found
	 */
	@Override
	public Semester fetchByB_E_D(int beginYear, int endYear, int division,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { beginYear, endYear, division };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_B_E_D,
					finderArgs, this);
		}

		if (result instanceof Semester) {
			Semester semester = (Semester)result;

			if ((beginYear != semester.getBeginYear()) ||
					(endYear != semester.getEndYear()) ||
					(division != semester.getDivision())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SEMESTER_WHERE);

			query.append(_FINDER_COLUMN_B_E_D_BEGINYEAR_2);

			query.append(_FINDER_COLUMN_B_E_D_ENDYEAR_2);

			query.append(_FINDER_COLUMN_B_E_D_DIVISION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(beginYear);

				qPos.add(endYear);

				qPos.add(division);

				List<Semester> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_B_E_D,
						finderArgs, list);
				}
				else {
					Semester semester = list.get(0);

					result = semester;

					cacheResult(semester);

					if ((semester.getBeginYear() != beginYear) ||
							(semester.getEndYear() != endYear) ||
							(semester.getDivision() != division)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_B_E_D,
							finderArgs, semester);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_B_E_D, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Semester)result;
		}
	}

	/**
	 * Removes the semester where beginYear = &#63; and endYear = &#63; and division = &#63; from the database.
	 *
	 * @param beginYear the begin year
	 * @param endYear the end year
	 * @param division the division
	 * @return the semester that was removed
	 */
	@Override
	public Semester removeByB_E_D(int beginYear, int endYear, int division)
		throws NoSuchSemesterException {
		Semester semester = findByB_E_D(beginYear, endYear, division);

		return remove(semester);
	}

	/**
	 * Returns the number of semesters where beginYear = &#63; and endYear = &#63; and division = &#63;.
	 *
	 * @param beginYear the begin year
	 * @param endYear the end year
	 * @param division the division
	 * @return the number of matching semesters
	 */
	@Override
	public int countByB_E_D(int beginYear, int endYear, int division) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_B_E_D;

		Object[] finderArgs = new Object[] { beginYear, endYear, division };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SEMESTER_WHERE);

			query.append(_FINDER_COLUMN_B_E_D_BEGINYEAR_2);

			query.append(_FINDER_COLUMN_B_E_D_ENDYEAR_2);

			query.append(_FINDER_COLUMN_B_E_D_DIVISION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(beginYear);

				qPos.add(endYear);

				qPos.add(division);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_B_E_D_BEGINYEAR_2 = "semester.beginYear = ? AND ";
	private static final String _FINDER_COLUMN_B_E_D_ENDYEAR_2 = "semester.endYear = ? AND ";
	private static final String _FINDER_COLUMN_B_E_D_DIVISION_2 = "semester.division = ?";

	public SemesterPersistenceImpl() {
		setModelClass(Semester.class);
	}

	/**
	 * Caches the semester in the entity cache if it is enabled.
	 *
	 * @param semester the semester
	 */
	@Override
	public void cacheResult(Semester semester) {
		entityCache.putResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterImpl.class, semester.getPrimaryKey(), semester);

		finderCache.putResult(FINDER_PATH_FETCH_BY_B_E_D,
			new Object[] {
				semester.getBeginYear(), semester.getEndYear(),
				semester.getDivision()
			}, semester);

		semester.resetOriginalValues();
	}

	/**
	 * Caches the semesters in the entity cache if it is enabled.
	 *
	 * @param semesters the semesters
	 */
	@Override
	public void cacheResult(List<Semester> semesters) {
		for (Semester semester : semesters) {
			if (entityCache.getResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
						SemesterImpl.class, semester.getPrimaryKey()) == null) {
				cacheResult(semester);
			}
			else {
				semester.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all semesters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SemesterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the semester.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Semester semester) {
		entityCache.removeResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterImpl.class, semester.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SemesterModelImpl)semester, true);
	}

	@Override
	public void clearCache(List<Semester> semesters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Semester semester : semesters) {
			entityCache.removeResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
				SemesterImpl.class, semester.getPrimaryKey());

			clearUniqueFindersCache((SemesterModelImpl)semester, true);
		}
	}

	protected void cacheUniqueFindersCache(SemesterModelImpl semesterModelImpl) {
		Object[] args = new Object[] {
				semesterModelImpl.getBeginYear(), semesterModelImpl.getEndYear(),
				semesterModelImpl.getDivision()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_B_E_D, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_B_E_D, args,
			semesterModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SemesterModelImpl semesterModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					semesterModelImpl.getBeginYear(),
					semesterModelImpl.getEndYear(),
					semesterModelImpl.getDivision()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_B_E_D, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_B_E_D, args);
		}

		if ((semesterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_B_E_D.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					semesterModelImpl.getOriginalBeginYear(),
					semesterModelImpl.getOriginalEndYear(),
					semesterModelImpl.getOriginalDivision()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_B_E_D, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_B_E_D, args);
		}
	}

	/**
	 * Creates a new semester with the primary key. Does not add the semester to the database.
	 *
	 * @param semesterId the primary key for the new semester
	 * @return the new semester
	 */
	@Override
	public Semester create(long semesterId) {
		Semester semester = new SemesterImpl();

		semester.setNew(true);
		semester.setPrimaryKey(semesterId);

		semester.setCompanyId(companyProvider.getCompanyId());

		return semester;
	}

	/**
	 * Removes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param semesterId the primary key of the semester
	 * @return the semester that was removed
	 * @throws NoSuchSemesterException if a semester with the primary key could not be found
	 */
	@Override
	public Semester remove(long semesterId) throws NoSuchSemesterException {
		return remove((Serializable)semesterId);
	}

	/**
	 * Removes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the semester
	 * @return the semester that was removed
	 * @throws NoSuchSemesterException if a semester with the primary key could not be found
	 */
	@Override
	public Semester remove(Serializable primaryKey)
		throws NoSuchSemesterException {
		Session session = null;

		try {
			session = openSession();

			Semester semester = (Semester)session.get(SemesterImpl.class,
					primaryKey);

			if (semester == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSemesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(semester);
		}
		catch (NoSuchSemesterException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Semester removeImpl(Semester semester) {
		semester = toUnwrappedModel(semester);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(semester)) {
				semester = (Semester)session.get(SemesterImpl.class,
						semester.getPrimaryKeyObj());
			}

			if (semester != null) {
				session.delete(semester);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (semester != null) {
			clearCache(semester);
		}

		return semester;
	}

	@Override
	public Semester updateImpl(Semester semester) {
		semester = toUnwrappedModel(semester);

		boolean isNew = semester.isNew();

		SemesterModelImpl semesterModelImpl = (SemesterModelImpl)semester;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (semester.getCreateDate() == null)) {
			if (serviceContext == null) {
				semester.setCreateDate(now);
			}
			else {
				semester.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!semesterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				semester.setModifiedDate(now);
			}
			else {
				semester.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (semester.isNew()) {
				session.save(semester);

				semester.setNew(false);
			}
			else {
				semester = (Semester)session.merge(semester);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SemesterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
			SemesterImpl.class, semester.getPrimaryKey(), semester, false);

		clearUniqueFindersCache(semesterModelImpl, false);
		cacheUniqueFindersCache(semesterModelImpl);

		semester.resetOriginalValues();

		return semester;
	}

	protected Semester toUnwrappedModel(Semester semester) {
		if (semester instanceof SemesterImpl) {
			return semester;
		}

		SemesterImpl semesterImpl = new SemesterImpl();

		semesterImpl.setNew(semester.isNew());
		semesterImpl.setPrimaryKey(semester.getPrimaryKey());

		semesterImpl.setSemesterId(semester.getSemesterId());
		semesterImpl.setGroupId(semester.getGroupId());
		semesterImpl.setCompanyId(semester.getCompanyId());
		semesterImpl.setUserId(semester.getUserId());
		semesterImpl.setUserName(semester.getUserName());
		semesterImpl.setCreateDate(semester.getCreateDate());
		semesterImpl.setModifiedDate(semester.getModifiedDate());
		semesterImpl.setBeginYear(semester.getBeginYear());
		semesterImpl.setEndYear(semester.getEndYear());
		semesterImpl.setDivision(semester.getDivision());

		return semesterImpl;
	}

	/**
	 * Returns the semester with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the semester
	 * @return the semester
	 * @throws NoSuchSemesterException if a semester with the primary key could not be found
	 */
	@Override
	public Semester findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSemesterException {
		Semester semester = fetchByPrimaryKey(primaryKey);

		if (semester == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSemesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return semester;
	}

	/**
	 * Returns the semester with the primary key or throws a {@link NoSuchSemesterException} if it could not be found.
	 *
	 * @param semesterId the primary key of the semester
	 * @return the semester
	 * @throws NoSuchSemesterException if a semester with the primary key could not be found
	 */
	@Override
	public Semester findByPrimaryKey(long semesterId)
		throws NoSuchSemesterException {
		return findByPrimaryKey((Serializable)semesterId);
	}

	/**
	 * Returns the semester with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the semester
	 * @return the semester, or <code>null</code> if a semester with the primary key could not be found
	 */
	@Override
	public Semester fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
				SemesterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Semester semester = (Semester)serializable;

		if (semester == null) {
			Session session = null;

			try {
				session = openSession();

				semester = (Semester)session.get(SemesterImpl.class, primaryKey);

				if (semester != null) {
					cacheResult(semester);
				}
				else {
					entityCache.putResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
						SemesterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
					SemesterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return semester;
	}

	/**
	 * Returns the semester with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param semesterId the primary key of the semester
	 * @return the semester, or <code>null</code> if a semester with the primary key could not be found
	 */
	@Override
	public Semester fetchByPrimaryKey(long semesterId) {
		return fetchByPrimaryKey((Serializable)semesterId);
	}

	@Override
	public Map<Serializable, Semester> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Semester> map = new HashMap<Serializable, Semester>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Semester semester = fetchByPrimaryKey(primaryKey);

			if (semester != null) {
				map.put(primaryKey, semester);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
					SemesterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Semester)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SEMESTER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Semester semester : (List<Semester>)q.list()) {
				map.put(semester.getPrimaryKeyObj(), semester);

				cacheResult(semester);

				uncachedPrimaryKeys.remove(semester.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SemesterModelImpl.ENTITY_CACHE_ENABLED,
					SemesterImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the semesters.
	 *
	 * @return the semesters
	 */
	@Override
	public List<Semester> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the semesters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of semesters
	 * @param end the upper bound of the range of semesters (not inclusive)
	 * @return the range of semesters
	 */
	@Override
	public List<Semester> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the semesters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of semesters
	 * @param end the upper bound of the range of semesters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of semesters
	 */
	@Override
	public List<Semester> findAll(int start, int end,
		OrderByComparator<Semester> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the semesters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of semesters
	 * @param end the upper bound of the range of semesters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of semesters
	 */
	@Override
	public List<Semester> findAll(int start, int end,
		OrderByComparator<Semester> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Semester> list = null;

		if (retrieveFromCache) {
			list = (List<Semester>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEMESTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEMESTER;

				if (pagination) {
					sql = sql.concat(SemesterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Semester>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Semester>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the semesters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Semester semester : findAll()) {
			remove(semester);
		}
	}

	/**
	 * Returns the number of semesters.
	 *
	 * @return the number of semesters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEMESTER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SemesterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the semester persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SemesterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SEMESTER = "SELECT semester FROM Semester semester";
	private static final String _SQL_SELECT_SEMESTER_WHERE_PKS_IN = "SELECT semester FROM Semester semester WHERE semesterId IN (";
	private static final String _SQL_SELECT_SEMESTER_WHERE = "SELECT semester FROM Semester semester WHERE ";
	private static final String _SQL_COUNT_SEMESTER = "SELECT COUNT(semester) FROM Semester semester";
	private static final String _SQL_COUNT_SEMESTER_WHERE = "SELECT COUNT(semester) FROM Semester semester WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "semester.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Semester exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Semester exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SemesterPersistenceImpl.class);
}