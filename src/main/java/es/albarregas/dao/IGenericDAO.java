/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IGenericDAO {

    public void add(Object object);

    public List<Object> get(String entidad);

    public <T> T get(Class clase,Serializable pk);
    
    public void update(Object object);

    public void delete(Object object);
}
