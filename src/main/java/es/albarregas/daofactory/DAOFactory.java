package es.albarregas.daofactory;


import es.albarregas.dao.IGenericDAO;

public abstract class DAOFactory {

    

  
    public abstract IGenericDAO getGenericDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
