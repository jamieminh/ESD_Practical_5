/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dbHandler;

/**
 *
 * @author Jamie
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBBean {

    private Connection con;
    private Statement state;
    private ResultSet rs;

    public void connect(Connection c) {
        con = c;
    }

    public String doQuery(String query, String table) {
        StringBuilder sb = new StringBuilder();

        try {
            // You will need to explicitly load this driver in a web app
            state = con.createStatement();
            rs = state.executeQuery("SELECT * from APP." + table);
            while (rs.next()) {
                sb.append(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                sb.append("\n<br>");
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            rs.close();
            state.close();
    //        con.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try
        return sb.toString();
      }
  
    public int addRecord(String data, String table) {
        int isSuccess = 0;
        try {
            
            state = con.createStatement();

            isSuccess = state.executeUpdate("INSERT INTO app." + table + " VALUES (" + data + ")");

            state.close();
//            con.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }//try

        return isSuccess;
    }
} //class

