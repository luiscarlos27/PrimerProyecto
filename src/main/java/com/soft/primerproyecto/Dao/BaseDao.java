/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soft.primerproyecto.Dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Usuario
 */
public interface BaseDao<T extends Serializable, E> {
    public void deleteAll(Collection<T> instances) throws Exception;
    public void update(String query) throws Exception;
    public E save(T instance) throws Exception;
    public void saveAll(Collection<T> instances) throws Exception;
    public void persist(T transientInstance) throws Exception;
    public void delete(T persistentInstance) throws Exception;
    public T search(T instance) throws Exception;
    public List<T> search(String query) throws Exception;
    public List<T> search(DetachedCriteria criteria) throws Exception;
    public void update(T detachedInstance) throws Exception;
    public List searchAny(final String queryString) throws Exception;
    public void merge(T instance) throws Exception;
    public void mergeAll(Collection<T> collection) throws Exception;
    public void flushSession() throws Exception;
    public SessionFactory getSessionFactory();
    public void setSessionFactory(SessionFactory sessionFactory);
    public List<T> executeNamedQuery(Method method, final Object[] queryArgs);
    public Class getType();
    public void setType(Class type);
    public void truncate(String table) throws Exception;
}
