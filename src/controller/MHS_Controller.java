/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MHS;

/**
 *
 * @author Nico Munasatya
 */
public class MHS_Controller {
    Statement st;
    
    public void insert(MHS m)
    {
        try {
            st = MySQLDB.getConnection().createStatement();
            String sql = "insert into tbmhs (idmhs, nim, nama, kota_asal) "
                    + "values('"+m.getIdMhs()+"', '"+m.getNim()+"', '"+m.getNama()+"', '"+m.getKota_asal()+"')";
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(MHS m)
    {
        try {
            st = MySQLDB.getConnection().createStatement();
            String sql = "update tbmhs set nim='"+m.getNim()+"', nama='"+m.getNama()+"', kota_asal='"+m.getKota_asal()+"' where idmhs='"+m.getIdMhs()+"'";
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String idMhs)
    {
        try {
            st = MySQLDB.getConnection().createStatement();
            String sql = "delete from tbmhs where idMhs='"+idMhs+"'";
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<MHS>getAllMhs()
    {
        ObservableList<MHS> lmhs = FXCollections.observableArrayList();
        try {
            st = MySQLDB.getConnection().createStatement();
            String sql = "select * from tbmhs";
            ResultSet rs = st.executeQuery(sql);
            rs.beforeFirst();
            
            while (rs.next()) {
                MHS m = new MHS();
                m.setIdMhs(Integer.parseInt(rs.getString(1)));
                m.setNim(rs.getString(2));
                m.setNama(rs.getString(3));
                m.setKota_asal(rs.getString(4));
                lmhs.add(m);
                System.out.println(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lmhs;
    }
    
    public ObservableList<MHS>searchMHS(String nama)
    {
        ObservableList<MHS> lmhs = FXCollections.observableArrayList();
        try {
            st = MySQLDB.getConnection().createStatement();
            String sql = "select * from tbmhs where nama like'%"+nama+"'%";
            ResultSet rs = st.executeQuery(sql);
            rs.beforeFirst();
            
            while (rs.next()) {
                MHS m = new MHS();
                m.setIdMhs(Integer.parseInt(rs.getString(1)));
                m.setNim(rs.getString(2));
                m.setNama(rs.getString(3));
                m.setKota_asal(rs.getString(4));
                lmhs.add(m);
                System.out.println(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lmhs;
    }
}
