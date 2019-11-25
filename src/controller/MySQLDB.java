
package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico Munasatya
 */
public class MySQLDB {
    private static Connection con;
    
    private MySQLDB()
    {
        
    }
    
    public static Connection getConnection()
    {
        if(con == null)
        {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbmhs","root","");
                System.out.println("Koneksi Berhasil...");
            } catch (SQLException ex) {
                Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    
    public static void disconnect()
    {
        if(con != null)
        {
            con = null;
            System.out.println(con);
        }
    }
}
