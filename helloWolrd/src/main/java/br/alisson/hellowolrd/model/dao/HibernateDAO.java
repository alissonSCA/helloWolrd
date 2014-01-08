package br.alisson.hellowolrd.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author alisson
 */
public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Class<T> c;
    private Session session;

    public HibernateDAO(Class<T> c, Session session) {
        super();
        this.c = c;
        this.session = session;
    }        

    @Override
    public void save(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) {
         session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T)session.get(c,id);
        return entity;
    }

    @Override
    public T getEntity(DetachedCriteria dc) {
        return (T)dc.getExecutableCriteria(session).uniqueResult();
    }

    @Override
    public List<T> getEntities() {
        return (List<T>) session.createCriteria(c).list();
    }

    @Override
    public List<T> getEntities(DetachedCriteria dc) {
        return dc.getExecutableCriteria(session).list();
    }
    
}
