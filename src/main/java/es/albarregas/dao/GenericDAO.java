/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.persistencia.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class GenericDAO implements IGenericDAO{
     @Override
    public void add(Object object) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(object);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
    }

    @Override
    public List<Object> get(String entidad) {
        List<Object> listado = null;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            listado = sesion.createQuery(" from " + entidad).list();
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
        return listado;
    }

    @Override
    public <T> T get(Class clase,Serializable pk) {
         T generico = null;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            generico = (T) sesion.get(clase, pk);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
        return generico;
    }
    
    
    @Override
    public void delete(Object object) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(object);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
    }
    
    @Override
    public void update(Object object) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(object);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
    }
}
