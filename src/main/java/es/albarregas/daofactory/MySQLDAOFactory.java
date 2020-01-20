package es.albarregas.daofactory;


import es.albarregas.dao.GenericDAO;
import es.albarregas.dao.IGenericDAO;



public class MySQLDAOFactory extends DAOFactory{


    @Override
    public IGenericDAO getGenericDAO() {
        return new GenericDAO();
    }

}
