package ua.skillsup.chat.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AbstractDao<T> {
    private final Class PERSISTENT_CLASS;

    @Autowired
    private final SessionFactory SESSION_FACTORY;

    public AbstractDao(Class aClass, SessionFactory sessionFactory) {
        PERSISTENT_CLASS = aClass;
        SESSION_FACTORY = sessionFactory;
    }

    public Session getCurrentSession () {
        return SESSION_FACTORY.getCurrentSession();
    }

    public T getByKey(Serializable key) {
        return (T) getCurrentSession().get(PERSISTENT_CLASS, key);
    }

    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    public void remove(T entity) {
        getCurrentSession().delete(entity);
    }

    public List listAll() {
        return
                getCurrentSession()
                        .createQuery("from " + PERSISTENT_CLASS.getCanonicalName())
                        .list();
    }

    protected Criteria createCriteria() {
        return getCurrentSession().createCriteria(PERSISTENT_CLASS);
    }
}
