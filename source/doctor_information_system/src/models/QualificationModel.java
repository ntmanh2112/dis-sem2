/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.QualificationView;

/**
 *
 * @author PhucPro
 */
public class QualificationModel extends Query {


    public QualificationModel() {
        super();
    }

    int id ;
    String qualification;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public void add(){
       try {
           QualificationView vQua = new QualificationView();
            String name = getQualification();
           
            PreparedStatement pre = this.con.prepareStatement("insert into qualification values(?)");
            pre.setString(1, name);
           
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(QualificationModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
    public void  del(int row){
    QualificationView v = new QualificationView();   
        if (row != -1) {
            try {
           int id = Integer.parseInt(v.tblData.getValueAt(row, 0).toString());
                String sql ="delete qualification where qualification_id=?";
                PreparedStatement pre = this.con.prepareStatement(sql);
                pre.setInt(1, id);
                int //<editor-fold defaultstate="collapsed" desc="comment">
                        executeUpdate
                        //</editor-fold>
 = pre.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(QualificationModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select row");
                    }
    }
    
    public void  upd(int row){
       
              QualificationView v = new QualificationView(); 
        if (row != -1) {
            try {
                int id = Integer.parseInt(v.tblData.getValueAt(row, 0).toString());
                String name = v.tblData.getValueAt(row,1).toString();
                PreparedStatement pre = this.con.prepareStatement("update qualification(qualification_id,qualification_name) set values(?,?) where qualification_id=?");
                
                pre.setInt(1, id);
                pre.setString(2,name);
                pre.setString(3,name);
              
                pre.executeQuery();
                
            } catch (SQLException ex) {
                Logger.getLogger(QualificationModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Row");
        }
    }
}
