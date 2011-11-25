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
public class AchievementModel extends Query {
    private String achievement_id;
    private String desciption;
    private String doctor_id;

    public AchievementModel() {
        super();
    }

    public String getAchievement_id() {
        return achievement_id;
    }

    public String getDesciption() {
        return desciption;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setAchievement_id(String achievement_id) {
        this.achievement_id = achievement_id;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }
    /**
     * Method getAllAchievement()
     * @return
     * @throws SQLException
     */
    public Vector getAllAchievement() {
        Vector v = new Vector();
        try {
            ResultSet rs = this.executeProcedure("spAllAchievement");
            while (rs.next()) {
                AchievementModel objAchievement = new AchievementModel();
                objAchievement.setAchievement_id(rs.getString(1));
                objAchievement.setDesciption(rs.getString(2));
                objAchievement.setDoctor_id(rs.getString(3));
                v.add(objAchievement);
            }
        } catch (SQLException sql) {
            System.out.println(sql);
            sql.printStackTrace();
        }
        return v;
    }
    /**
     *
     * @param achievement_id
     * @return
     * @throws SQLException
     */
    public int deleteAchievement(String achievement_id) {
        int i = 0;
        try {
            Vector paramList = new Vector();
            paramList.add(achievement_id);
            i = this.executeProcedureUpdate("spDeleteAchievement", paramList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
    /**
     *
     * @param objAchivement
     * @return
     * @throws SQLException
     */
    public int updateAchievement(AchievementModel objAchivement) {
        int i = 0;
        try {
            Vector paramList = new Vector();
            paramList.add(objAchivement.achievement_id);
            paramList.add(objAchivement.desciption);
            paramList.add(objAchivement.doctor_id);
            i = this.executeProcedureUpdate("spUpdateAchievement", paramList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
    /**
     * 
     * @param objAchivement
     * @return
     * @throws SQLException
     */
    public int insertAchievement(AchievementModel objAchivement) throws SQLException {
        int i = 0;
        try {
            Vector paramList = new Vector();
           // paramList.add(objAchivement.achievement_id);
            paramList.add(objAchivement.desciption);
            paramList.add(objAchivement.doctor_id);
            i = this.executeProcedureUpdate("spInsertAchievement", paramList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
    /**
     * 
     * @param args
     */
    public static void main(String [] args){
        new AchievementModel();
        System.out.println("go to school by bus");
    }
}
