package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author WIN 10
 */
public class StudentServletListener implements ServletContextListener {
    
    Connection con;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String db = sc.getInitParameter("db_name");
        String tb = sc.getInitParameter("tb_name");
        
        try {
            // You will need to explicitly load this driver in a web app
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + db, "root", "root");
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);
        }//try
        
        sc.setAttribute("con", con);
        sc.setAttribute("table", tb);

    }
    
    

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            con.close();
        }
        catch (SQLException e) {
            System.err.println("Error: " + e);
        }//try
    }
}
