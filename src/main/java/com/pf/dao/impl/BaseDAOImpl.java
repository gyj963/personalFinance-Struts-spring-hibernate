package com.pf.dao.impl;

import com.pf.dao.BaseDAO;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * 基于hibernate的BaseDao
 *
 * @param <T>
 */
public abstract class BaseDAOImpl<T extends Serializable> extends HibernateDaoSupport implements BaseDAO<T> {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    //当前泛型类
    @SuppressWarnings("rawtypes")
    private Class entityClass;
    //当前主键名称
    private String pkname;
    private final String HQL_LIST_ALL;
    private final String HQL_COUNT_ALL;
    @Override
    @SuppressWarnings("rawtypes")
    public Class getEntityClass() {
        return entityClass;
    }
    @Override
    @SuppressWarnings("rawtypes")
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("rawtypes")
    public BaseDAOImpl() {
        //获取当前泛型类
        Type type = this.getClass().getGenericSuperclass();
        if (type.toString().indexOf("BaseDAOImpl") != -1) {
            ParameterizedType type1 = (ParameterizedType) type;
            Type[] types = type1.getActualTypeArguments();
            setEntityClass((Class) types[0]);
        }else{
            type = ((Class)type).getGenericSuperclass();
            ParameterizedType type1 = (ParameterizedType) type;
            Type[] types = type1.getActualTypeArguments();
            setEntityClass((Class) types[0]);
        }
        getPkname();
        HQL_LIST_ALL="from "+this.entityClass.getSimpleName()+" order by "+pkname+" desc";
        HQL_COUNT_ALL="select count(*) from "+this.entityClass.getSimpleName();
    }
    /**
     * 获取主键名称
     * @return
     */
    @Override
    public String getPkname() {
        Field[] fields = this.entityClass.getDeclaredFields();//反射类字段
        for (Field field : fields) {
            field.isAnnotationPresent(Id.class);
            this.pkname=field.getName();
            break;
        }
        return pkname;
    }
    /**
     * 保存实例
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }
    @Override
    public void persist(T t) {
        getHibernateTemplate().persist(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }

    /**
     * 修改实例
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    @Override
    public void update(T t) {
       getHibernateTemplate().update(t);
    }

    /**
     * 删除实例
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    @Override
    public void delete(T t) {

        getHibernateTemplate().delete(t);
    }
    @Override
    public void deleteById(Class<T> t,Serializable id){
        T obj = this.getHibernateTemplate().get(t, id);
        this.getHibernateTemplate().delete(obj);
    }
    /**
     * 获取实例
     *
     *
     * @param id
     * @throws org.hibernate.HibernateException
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return (T)getHibernateTemplate().get(this.entityClass, id);
    }
    /**
     * 查询全部
     *
     * @throws org.hibernate.HibernateException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {

        return getHibernateTemplate().find(HQL_LIST_ALL);
    }
    /**
     * 查询总数
     *
     * @throws org.hibernate.HibernateException
     */
    @Override
    public Integer findAllCount() {
        Session session=getSession();
        Integer count=0;
        session.beginTransaction();
        Query query = session.createQuery(HQL_COUNT_ALL);
        List<?> list = query.list();
        session.getTransaction().commit();
        if(list!=null&&!list.isEmpty()){
            count=((Integer) list.get(0)).intValue();
        }
        return count;
    }
    /**
     * QBC查询
     *
     *
     * @param criteria
     * @throws org.hibernate.HibernateException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criteria criteria) {
        return null;
//        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * QBE查询
     *
     *
     * @param t
     * @throws org.hibernate.HibernateException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByExample(T t) {
        return getHibernateTemplate().findByExample(t);
        /*List<T> list=null;
        Session session=null;
        Example example = Example.create(t);
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(getEntityClass());
            criteria.add(example);
            list = criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return list;*/
    }
    /**
     * HQL查询
     *
     *
     * @param hql
     * @param objects
     * @throws org.hibernate.HibernateException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findByHql(String hql, Object... objects) {
        List<Object[]> list=getHibernateTemplate().find(hql,objects);
        return list;
    }
    /**
     * SQL查询
     *
     * @param sql
     * @param objects
     * @throws org.hibernate.HibernateException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findBySql(final String sql, final Object... objects){
        HibernateTemplate tmpl = getHibernateTemplate();
        return tmpl.execute(new HibernateCallback<List<Object[]>>() {
            @SuppressWarnings("unchecked")
            @Override
            public List<Object[]> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery(sql);
                for (int i = 0; i < objects.length; i++) {
                    query.setParameter(i, objects[i]);
                }
                List results = query.list();
                return (List<Object[]>)results;
            }
        });
    }
}
