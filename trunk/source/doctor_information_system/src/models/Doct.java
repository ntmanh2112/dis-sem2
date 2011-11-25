/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Control.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author De
 */
public class Doct {
    private String doctor_id;
    private String first_name;
    private String last_name;
    private String add_ress;
    private String email;
    private String phone_number;
    private String birthday;
    private String sex;
    private String experience;
    private String city_id;
    private String qualification_id;
    private String professional_id;

    public Doct() {
    }

    public String getAdd_ress() {
        return add_ress;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCity_id() {
        return city_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getEmail() {
        return email;
    }

    public String getExperience() {
        return experience;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getProfessional_id() {
        return professional_id;
    }

    public String getQualification_id() {
        return qualification_id;
    }

    public String getSex() {
        return sex;
    }

    public void setAdd_ress(String add_ress) {
        this.add_ress = add_ress;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setProfessional_id(String professional_id) {
        this.professional_id = professional_id;
    }

    public void setQualification_id(String qualification_id) {
        this.qualification_id = qualification_id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static Vector getAllDoctor() throws SQLException {
        Vector v=new Vector();
        try {
            ResultSet rs=DBHelper.executeQuery("spGetAllDoctor");
            while(rs.next()) {
                Doct dt=new Doct();
                dt.setDoctor_id(rs.getString(1));
                dt.setLast_name(rs.getString(2));
                dt.setAdd_ress(rs.getString(3));
                dt.setEmail(rs.getString(4));
                dt.setPhone_number(rs.getString(5));
                dt.setBirthday(rs.getString(6));
                dt.setSex(rs.getString(7));
                dt.setExperience(rs.getString(8));
                dt.setCity_id(rs.getString(9));
                dt.setQualification_id(rs.getString(10));
                dt.setProfessional_id(rs.getString(11));
                v.add(dt);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();

        }
        return v;
    }
}
