/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.triangle.Triangle;

/**
 *
 * @author Jamie
 */
public class TriangleServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int side_1 = Integer.parseInt(request.getParameter("side_1").trim());
            int side_2 = Integer.parseInt(request.getParameter("side_2").trim());
            int side_3 = Integer.parseInt(request.getParameter("side_3").trim());

            Triangle triangle = new Triangle(side_1, side_2, side_3);
            String type = triangle.evalTriangle();
            
            request.setAttribute("side1", side_1);    
            request.setAttribute("side2", side_2); 
            request.setAttribute("side3", side_3); 
            request.setAttribute("type", type); 
            request.getRequestDispatcher("/viewer/triangleView.jsp").forward(request, response);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
