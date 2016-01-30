/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soft.primerproyecto.Dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

/**
 *
 * @author Usuario
 */
public class BaseDaoHibernate <T extends Serializable, E> implements BaseDao<T, E> {

    private SessionFactory sessionFactory;
    private Class type;

    @Override
    public void deleteAll(Collection<T> instances) throws Exception {
        for (T o : instances) {
            getSessionFactory().getCurrentSession().delete(o);
        }
    }

    @Override
    public void update(String query) throws Exception {
        getSessionFactory().getCurrentSession().update(query);
    }

    @Override
    public E save(Serializable instance) throws Exception {
        return (E) getSessionFactory().getCurrentSession().save(instance);
    }

    @Override
    public void saveAll(Collection<T> instances) throws Exception {
        for (T o : instances) {
            getSessionFactory().getCurrentSession().save(o);
        }
    }

    @Override
    public void persist(T transientInstance) throws Exception {
        getSessionFactory().getCurrentSession().persist(transientInstance);
    }

    @Override
    public void delete(T persistentInstance) throws Exception {
        getSessionFactory().getCurrentSession().delete(persistentInstance);
    }

    @Override
    public T search(T instance) throws Exception {
        return (T) getSessionFactory().getCurrentSession().get(Serializable.class, instance);
    }

    @Override
    public List<T> search(String query) throws Exception {
        return getSessionFactory().getCurrentSession().createQuery(query).list();
    }

    @Override
    public List<T> search(DetachedCriteria criteria) throws Exception {
        Criteria critec = criteria.getExecutableCriteria(getSessionFactory().getCurrentSession());
        return critec.list();
    }

    @Override
    public void update(T detachedInstance) throws Exception {
        getSessionFactory().getCurrentSession().update(detachedInstance);
    }

    @Override
    public void merge(T instance) throws Exception {
        getSessionFactory().getCurrentSession().merge(instance);
    }

    @Override
    public void mergeAll(Collection<T> collection) throws Exception {
        for (T o : collection) {
            getSessionFactory().getCurrentSession().merge(o);
        }
    }

    @Override
    public List<T> searchAny(String queryString) throws Exception {
        return getSessionFactory().getCurrentSession().createQuery(queryString).list();
    }

    /**
     * @return the sessionFactory
     */
    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void flushSession() throws Exception {
        getSessionFactory().getCurrentSession().flush();
    }

    @Override
    public List<T> executeNamedQuery(final Method method, final Object[] queryArgs) {
        final String queryName = queryNameFromMethod(method);
        final Query namedQuery = getSessionFactory().getCurrentSession().getNamedQuery(queryName);
        //String[] namedParameters = namedQuery.getNamedParameters();
        if (queryArgs != null) {
            for (int i = 0; i < queryArgs.length; i++) {
                Object arg = queryArgs[i];
                if(arg instanceof String)
                    namedQuery.setParameter("param"+i, arg, StringType.INSTANCE);
                else if (arg instanceof Integer)
                    namedQuery.setParameter("param"+i, arg, IntegerType.INSTANCE);
                else if (arg instanceof Date)
                    namedQuery.setParameter("param"+i, arg, TimestampType.INSTANCE);
                else if (arg instanceof Long)
                    namedQuery.setParameter("param"+i, arg, LongType.INSTANCE);
                else if (arg instanceof Float)
                    namedQuery.setParameter("param"+i, arg, FloatType.INSTANCE);
                else
                    namedQuery.setParameter("param"+i, arg);
            }
        }
        return (List) namedQuery.list();
    }
    
    
    @Override
    public void truncate(String table) throws Exception {
        String hql = String.format("delete from %s",table);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    private String queryNameFromMethod(Method finderMethod) {
        return type.getSimpleName() + "." + finderMethod.getName();
    }

    /**
     * @return the type
     */
    @Override
    public Class getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    @Override
    public void setType(Class type) {
        this.type = type;
    }
}
