/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import libs.clsPopulateFunctions;

/**
 *
 * @author congnguyentan
 */
public class DoctorModel extends Query {
    /*
     * constructor
     */
    public DoctorModel(){
        super();
    }

    /*
     * build where condition of view doctor sql
     *
     * @param: Vector conditions
     * @return: String strConditions processed
     */
    private String _buildWhereCondition(Vector conditions){
        String strConditions = "";
        if(conditions != null){
            strConditions = clsPopulateFunctions.joinVector(conditions, " AND ");
        }
        return strConditions;
    }

    /*
     * get list doctors
     *
     * @param: Vector conditions. Default is null
     * @result: Vector listDoctors
     */
    public Vector getListDoctorsRenderTable(Vector conditions){
        Vector listDoctors = new Vector();
        try{
            String sqlGet = "SELECT doctor.*, convert(varchar(10),birthday,103) AS doctor_birthday, city_name, professional_name, qualification_name, city.city_id, professional.professional_id, qualification.qualification_id FROM ((doctor LEFT OUTER JOIN city ON doctor.city_id = city.city_id) LEFT OUTER JOIN qualification ON qualification.qualification_id = doctor.qualification_id) LEFT OUTER JOIN professional ON professional.professional_id = doctor.professional_id ORDER BY first_name, last_name";
            String strConditions = this._buildWhereCondition(conditions);
            if(!strConditions.isEmpty()){
                sqlGet += " WHERE " + strConditions;
            }
            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(order);
                dataSet.add(rsGet.getString("first_name"));
                dataSet.add(rsGet.getString("last_name"));
                dataSet.add(rsGet.getString("add_ress"));
                dataSet.add(rsGet.getString("phone_number"));
                dataSet.add(rsGet.getString("doctor_birthday"));
                dataSet.add(rsGet.getString("sex"));
                dataSet.add(rsGet.getString("city_name"));
                dataSet.add(rsGet.getString("qualification_name"));
                dataSet.add(rsGet.getString("professional_name"));
                dataSet.add(rsGet.getInt("doctor_id"));

                listDoctors.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listDoctors;
    }

    /*
     * get list doctors
     *
     * @param: Vector conditions. Default is null
     * @result: Vector listDoctors
     */
    public Vector getListDoctorsGlobal(Vector conditions){
        Vector listDoctors = new Vector();
        try{
            String sqlGet = "SELECT doctor.*, convert(varchar(10),birthday,103) AS doctor_birthday, city_name, professional_name, qualification_name, city.city_id, professional.professional_id, qualification.qualification_id FROM ((doctor LEFT OUTER JOIN city ON doctor.city_id = city.city_id) LEFT OUTER JOIN qualification ON qualification.qualification_id = doctor.qualification_id) LEFT OUTER JOIN professional ON professional.professional_id = doctor.professional_id ORDER BY first_name, last_name";
            String strConditions = this._buildWhereCondition(conditions);
            if(!strConditions.isEmpty()){
                sqlGet += " WHERE " + strConditions;
            }
            ResultSet rsGet = this.queryData(sqlGet);
            while(rsGet.next()){
                Vector dataSet = new Vector();
                dataSet.add(rsGet.getInt("doctor_id"));
                dataSet.add(rsGet.getString("first_name"));
                dataSet.add(rsGet.getString("last_name"));
                dataSet.add(rsGet.getString("add_ress"));
                dataSet.add(rsGet.getString("email"));
                dataSet.add(rsGet.getString("phone_number"));
                dataSet.add(rsGet.getString("doctor_birthday"));
                dataSet.add(rsGet.getString("sex"));
                dataSet.add(rsGet.getInt("experience"));
                dataSet.add(rsGet.getString("city_name"));
                dataSet.add(rsGet.getString("professional_name"));
                dataSet.add(rsGet.getString("qualification_name"));
                dataSet.add(rsGet.getInt("city_id"));
                dataSet.add(rsGet.getInt("professional_id"));
                dataSet.add(rsGet.getInt("qualification_id"));

                listDoctors.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listDoctors;
    }

    /*
     * get list professional
     *
     * @result: Vector listProfessionals
     */
    public Vector getListSpecializations(){
        Vector listProfessionals = new Vector();
        try{
            String sqlGet = "SELECT * FROM qualification ORDER BY qualification_name";

            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(rsGet.getInt("qualification_id"));
                dataSet.add(rsGet.getString("qualification_name"));

                listProfessionals.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listProfessionals;
    }

    /*
     * get list country
     *
     * @result: Vector listCountries
     */
    public Vector getListCountries(){
        Vector listCountries = new Vector();
        try{
            String sqlGet = "SELECT * FROM country ORDER BY country_name";

            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(rsGet.getInt("country_id"));
                dataSet.add(rsGet.getString("country_name"));

                listCountries.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listCountries;
    }

    /*
     * get list cities
     *
     * @param: Vector conditions
     * @result: Vector listCountries
     */
    public Vector getListCities(Vector conditions){
        Vector listCities = new Vector();
        try{
            String sqlGet = "SELECT * FROM city";
            if(conditions != null){
                String strCondition = clsPopulateFunctions.joinVector(conditions, " AND ");
                sqlGet += " WHERE " + strCondition;
            }
            sqlGet += " ORDER BY city_name";
            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(rsGet.getInt("city_id"));
                dataSet.add(rsGet.getString("city_name"));

                listCities.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listCities;
    }
}
