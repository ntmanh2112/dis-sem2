/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import Control.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import models.Query;

/**
 *
 * @author De
 */
public class ProfessionalModel extends Query {
    private String professional_id;
    private String professional_name;

    public ProfessionalModel() {
        super();
    }

    public String getProfessional_id() {
        return professional_id;
    }

    public String getProfessional_name() {
        return professional_name;
    }

    public void setProfessional_id(String professional_id) {
        this.professional_id = professional_id;
    }

    public void setProfessional_name(String professional_name) {
        this.professional_name = professional_name;
    }
    /**
     *Method getAllProfessional()
     *@return Vector
     *@throws java.sql.SQLException
     */
    public Vector getAllProfessional() throws SQLException {
        Vector v = new Vector();
        try {
            ResultSet rs = this.executeProcedure("spGetAllProfessional");
            while (rs.next()) {
                ProfessionalModel objProfessional = new ProfessionalModel();
                objProfessional.setProfessional_id(rs.getString(1));
                objProfessional.setProfessional_name(rs.getString(2));
                v.add(objProfessional);

            }
        } catch (SQLException sql) {
            System.out.println(sql);
            sql.printStackTrace();
        }
        return v;
    }
    /**
     *Method getProfessionalID()
     *@param pid
     *@ /**
     *Method getProfessionalID()
     *return Vector
     *@throws SQLException
     */
    /*public static Vector getProfessionalID(String p_id) throws SQLException {
        Vector v = new Vector();
        try {
            Vector paramList = new Vector();
            paramList.add(p_id);
            ResultSet rs = DBHelper.executeQuery("spGetCountryByRegion", paramList);
            while (rs.next()) {
                ProfessionalModel objProfessional = new ProfessionalModel();
                objProfessional.setProfessional_id(rs.getString(1));
                objProfessional.setProfessional_name(rs.getString(2));
                v.add(objProfessional);
            }
        } catch (SQLException sql) {
            System.out.println("sql");
            sql.printStackTrace();
        }
        return v;
    }
    /**
     * Method getProfessionalName()
     * @param p_name
     * @return
     * @throws SQLException
     */
    /*public static Vector getProfessionalName(String p_name) throws SQLException {
        Vector v = new Vector();
        try {
            Vector paramList = new Vector();
            paramList.add(p_name);
            ResultSet rs = DBHelper.executeQuery("spGetProfessionalName", paramList);
            while (rs.next()) {
                ProfessionalModel objProfessional = new ProfessionalModel();
                objProfessional.setProfessional_id(rs.getString(1));
                objProfessional.setProfessional_name(rs.getString(2));
                v.add(objProfessional);
            }
        } catch (SQLException sql) {
            System.out.println("sql");
            sql.printStackTrace();
        }
        return v;
    }
    /**
     * Method insertProfessional()
     * @param objCountry
     * @return
     * @throws SQLException
     */
    public int insertProfessional(ProfessionalModel objProfessional) {
        int i = 0;
        try {
            Vector paramList = new Vector();
           // paramList.add(objProfessional.professional_id);
            paramList.add(objProfessional.professional_name);
            i = this.executeProcedureUpdate("spInsertProfessional", paramList);
        } catch (Exception sql) {
            //System.out.println(sql);
            sql.printStackTrace();
        }
        return i;
    }
    /**
     * Method updateProfessional()
     * @param objProfessional
     * @return
     * @throws SQLException
     */
    public int updateProfessional(ProfessionalModel objProfessional) {
        int i = 0;
        try {
            Vector paramList = new Vector();
            paramList.add(objProfessional.professional_id);
            paramList.add(objProfessional.professional_name);
            i = this.executeProcedureUpdate("spUpdateProfessional", paramList);
        } catch (Exception sql) {
            //System.out.println(sql);
            sql.printStackTrace();
        }
        return i;
    }
    /**
     * Method deleteProfessional()
     * @param pfsnl
     * @return
     * @throws SQLException
     */
    public int deleteProfessional(String pfsnl) {
        int i = 0;
        try {
            Vector paramList = new Vector();
            paramList.add(pfsnl);
            i = this.executeProcedureUpdate("spDeleteProfessional", paramList);
        } catch (Exception sql) {
            System.out.println(sql);
            sql.printStackTrace();
        }
        return i;
    }
}
