/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Pais;
import es.albarregas.beans.Presidente;
import es.albarregas.daofactory.DAOFactory;

import es.albarregas.dao.IGenericDAO;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/eleccion"})
public class Eleccion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericDAO gdao = daof.getGenericDAO();

        List<Object> listaObj = null;
        List<Presidente> listaPre = null;
        List<Pais> listaPais = null;
        
        switch (request.getParameter("op")) {
            case "add":
                url = "JSP/formularioAlta.jsp";
                break;
            case "listPais":
                listaObj = gdao.get("Pais");
                listaPais = new ArrayList<>();
                for (Object i : listaObj) {

                    listaPais.add((Pais) i);

                    request.setAttribute("listado", listaPais);

                }
                break;
            case "delete":
            case "update":
            case "listPre":

                listaObj = gdao.get("Presidente");
                listaPre = new ArrayList<>();
                for (Object i : listaObj) {

                    listaPre.add((Presidente) i);

                    request.setAttribute("listado", listaPre);

                }
        }
        if (request.getParameter("op").equals("add") || (listaPre != null && !listaPre.isEmpty()) || (listaPais != null && !listaPais.isEmpty())) {
            switch (request.getParameter("op")) {
                case "listPais":
                    url = "JSP/listadoPais.jsp";
                    break;
                case "delete":
                    url = "JSP/borrado.jsp";
                    break;
                case "update":
                    url = "JSP/actual.jsp";
                    break;
                case "listPre":
                    url = "JSP/listadoPresidente.jsp";
                    break;
            }
        } else {
            url = "JSP/error.jsp";
            request.setAttribute("error", "No existen datos actualmente");
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
