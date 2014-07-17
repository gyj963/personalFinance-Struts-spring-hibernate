package com.pf.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-17
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDAO<T extends Serializable> {
    @SuppressWarnings("rawtypes")
    Class getEntityClass();

    @SuppressWarnings("rawtypes")
    void setEntityClass(Class entityClass);

    /**
     * 获取主键名称
     * @return
     */
    String getPkname();

    /**
     * 保存实例
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    void save(T t);

    void persist(T t);

    void saveOrUpdate(T t);

    /**
     * 修改实例
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    void update(T t);

    /**
     * 删除实例
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    void delete(T t);

    /**
     * 删除实例通过ID
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    void deleteById(Class<T> t, Serializable id);

    /**
     * 获取实例
     *
     *
     * @param id
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    T get(Serializable id);

    /**
     * 查询全部
     *
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    List<T> findAll();

    /**
     * 查询总数
     *
     * @throws org.hibernate.HibernateException
     */
    Integer findAllCount();

    /**
     * QBC查询
     *
     *
     * @param criteria
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    List<T> findByCriteria(Criteria criteria);

    /**
     * QBE查询
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    List<T> findByExample(T t);

    /**
     * HQL查询
     *
     *
     * @param hql
     * @param objects
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    List<Object[]> findByHql(String hql, Object... objects);

    /**
     * SQL查询
     *
     * @param sql
     * @param objects
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    List<Object[]> findBySql(String sql, Object... objects);


}
