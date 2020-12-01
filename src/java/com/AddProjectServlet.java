/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dbHandler.DBBean;

/**
 *
 * @author WIN 10
 */
public class AddProjectServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String stdID = request.getParameter("studentID");
            String stdName = request.getParameter("studentName");
            String projectTt = request.getParameter("projectTitle");
            out.println("<h2>" + stdID + stdName + projectTt +"</h2>");

            DBBean db = new DBBean();
            Connection con = (Connection) getServletContext().getAttribute("con");
            db.connect(con);
//            
            String tb = (String) getServletContext().getAttribute("table");
            out.println("<h2>" + tb +"</h2>");
            String insert = "'" + stdID + "','" + stdName + "','" + projectTt + "'";            
            out.println("<h2>" + insert +"</h2>");
            
            int success = db.addRecord(insert, tb);

            request.setAttribute("data", success+ " project is added");
            RequestDispatcher view = request.getRequestDispatcher("/index_db.html");
            view.forward(request, response);
        }
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
