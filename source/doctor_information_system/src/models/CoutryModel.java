/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.CoutryView;

/**
 *
 * @author aptech
 */
public class CoutryModel extends Query{

    public CoutryModel() {
        super();
    }
    int id;
    String coutry;

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void add(){
       try {
           CoutryView vQua = new CoutryView();
            String name = getCoutry();
           
            PreparedStatement pre = this.con.prepareStatement("insert into country values(?)");
            pre.setString(1, name);
           
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CoutryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
    public void  del(int row){
    CoutryView v = new CoutryView();   
        if (row != -1) {
            try {
           int id = Integer.parseInt(v.tblData.getValueAt(row, 0).toString());
                String sql ="delete country where country_id=?";
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
    
   
      
}
