package br.alisson.hellowolrd.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author alisson
 */
public interface InterfaceDAO<T> {
    
    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void merge(T entity);
    
    T getEntity(Serializable id);
    T getEntity(DetachedCriteria dc);
    List<T> getEntities();
    List<T> getEntities(DetachedCriteria dc);
    
}
