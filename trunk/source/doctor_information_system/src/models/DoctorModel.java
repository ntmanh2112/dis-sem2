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
            String sqlGet = "SELECT doctor.*, convert(varchar(10),birthday,103) AS doctor_birthday, city_name, professional_name, qualification_name, city.city_id, professional.professional_id, qualification.qualification_id FROM ((doctor LEFT OUTER JOIN city ON doctor.city_id = city.city_id) LEFT OUTER JOIN qualification ON qualification.qualification_id = doctor.qualification_id) LEFT OUTER JOIN professional ON professional.professional_id = doctor.professional_id";
            String strConditions = this._buildWhereCondition(conditions);
            if(!strConditions.isEmpty()){
                sqlGet += " WHERE " + strConditions;
            }
            sqlGet += " ORDER BY first_name, last_name";
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
            String sqlGet = "SELECT doctor.*, convert(varchar(10),birthday,103) AS doctor_birthday, city_name, country_name, professional_name, qualification_name, city.city_id, city.country_id, professional.professional_id, qualification.qualification_id FROM ((doctor LEFT OUTER JOIN (city LEFT OUTER JOIN country ON city.country_id = country.country_id) ON doctor.city_id = city.city_id) LEFT OUTER JOIN qualification ON qualification.qualification_id = doctor.qualification_id) LEFT OUTER JOIN professional ON professional.professional_id = doctor.professional_id";
            String strConditions = this._buildWhereCondition(conditions);
            if(!strConditions.isEmpty()){
                sqlGet += " WHERE " + strConditions;
            }
            sqlGet += " ORDER BY first_name, last_name";
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
                dataSet.add(rsGet.getString("country_name"));
                dataSet.add(rsGet.getString("professional_name"));
                dataSet.add(rsGet.getString("qualification_name"));
                dataSet.add(rsGet.getInt("city_id"));
                dataSet.add(rsGet.getInt("country_id"));
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
     * get list doctors
     *
     * @param: Vector conditions. Default is null
     * @result: Vector listHistory
     */
    public Vector getHistoryVisiting(Vector conditions){
        Vector listHistory = new Vector();
        try{
            String sqlGet = "SELECT history_id, convert(varchar(10),from_date,103) AS history_fromdate, convert(varchar(10),to_date,103) AS history_todate FROM history_doctor";
            String strConditions = this._buildWhereCondition(conditions);
            if(!strConditions.isEmpty()){
                sqlGet += " WHERE " + strConditions;
            }
            sqlGet += " ORDER BY from_date DESC, to_date DESC";
            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(order);
                dataSet.add(rsGet.getString("history_fromdate"));
                dataSet.add(rsGet.getString("history_todate"));
                dataSet.add(rsGet.getString("history_id"));

                listHistory.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listHistory;
    }

    /*
     * get list qualification
     *
     * @result: Vector listQualifications
     */
    public Vector getListSpecializations(){
        Vector listQualifications = new Vector();
        try{
            String sqlGet = "SELECT * FROM qualification ORDER BY qualification_name";

            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(rsGet.getInt("qualification_id"));
                dataSet.add(rsGet.getString("qualification_name"));

                listQualifications.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listQualifications;
    }

    /*
     * get list professional
     *
     * @result: Vector listProfessionals
     */
    public Vector getListProfessionals(){
        Vector listProfessionals = new Vector();
        try{
            String sqlGet = "SELECT * FROM professional ORDER BY professional_name";

            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                Vector dataSet = new Vector();
                dataSet.add(rsGet.getInt("professional_id"));
                dataSet.add(rsGet.getString("professional_name"));

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

    /*
     * update data into table
     *
     * @param: Vector datas, Vector columns, Vector typesColumn, String action, int idEdit (default = 0)
     * @result: boolean result update
     */
    public boolean updateDataDoctor(Vector datas, Vector columns, Vector typesColumn, String action, String idEdit){
        boolean result = false;
        if(datas.size() > 0){
            String sqlUpdate = "";
            String listColumns = clsPopulateFunctions.joinVector(columns, ",");
            Vector dataColumns = new Vector();
            String strDataColumns = "";
            if(action.equalsIgnoreCase("add")){
                sqlUpdate = "INSERT INTO doctor(" + listColumns + ")";
                for(int i=0; i<datas.size(); i++){
                    String type = typesColumn.get(i).toString();
                    if(type.equalsIgnoreCase("numeric")){
                        dataColumns.add(datas.get(i).toString());
                    }
                    else{
                        dataColumns.add("'" + datas.get(i).toString() + "'");
                    }
                }
                strDataColumns = clsPopulateFunctions.joinVector(dataColumns, ",");
                sqlUpdate += " VALUES(" + strDataColumns + ")";
            }
            else{
                sqlUpdate = "UPDATE doctor SET";
                for(int i=0; i<datas.size(); i++){
                    String type = typesColumn.get(i).toString();
                    String column = columns.get(i).toString();

                    if(type.equalsIgnoreCase("numeric")){
                        dataColumns.add(column + "=" + datas.get(i).toString());
                    }
                    else{
                        dataColumns.add(column + "=" + "'" + datas.get(i).toString() + "'");
                    }
                }
                strDataColumns = clsPopulateFunctions.joinVector(dataColumns, ",");
                sqlUpdate += " " + strDataColumns;
                sqlUpdate += " WHERE doctor_id IN (" + idEdit + ")";
            }
            System.out.println(sqlUpdate);
            result = this.queryUpdate(sqlUpdate);
        }
        return result;
    }

    public boolean deleteDoctor(Vector conditions){
        boolean result = false;
        if(conditions.size() > 0){
            String strCondition = clsPopulateFunctions.joinVector(conditions, " AND ");
            //System.out.println(strCondition);
            //delete archivement
            String sqlDelete = String.format("DELETE FROM achievement WHERE %s", strCondition);
            this.queryUpdate(sqlDelete);
            //delete history visiting
            sqlDelete = String.format("DELETE FROM history_doctor WHERE %s", strCondition);
            this.queryUpdate(sqlDelete);
            //delete doctor
            sqlDelete = String.format("DELETE FROM doctor WHERE %s", strCondition);
            this.queryUpdate(sqlDelete);
            result = true;
        }
        return result;
    }

    public boolean checkTimeSpanValid(String doctorIds, String fromDate, String toDate){
        boolean result = false;
        try{
            String sql = "SELECT count(*) AS row_count FROM history_doctor WHERE doctor_id IN (%s) AND ";
            sql += "("
                    + String.format("(from_date = '%s' OR from_date = '%s') OR ",fromDate, toDate)
                    + String.format("((from_date <= '%s' AND '%s' <= to_date) OR (from_date <= '%s' AND '%s' <= to_date)) OR ",fromDate, fromDate, toDate, toDate)
                    + String.format("(from_date <= '%s' AND '%s' <= to_date) OR ",fromDate, toDate)
                    + String.format("(from_date >= '%s' AND '%s' >= to_date)",fromDate, toDate);
            sql += ")";
            sql = String.format(sql,doctorIds);
            System.out.println(sql);
            ResultSet rs = this.queryData(sql);
            while(rs.next()){
                int count = rs.getInt("row_count");
                if(count == 0){
                    result = true;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean addschedule(String doctorIds, String fromDate, String toDate){
        boolean result = false;
        if(!doctorIds.isEmpty()){
            String sqlInsert = String.format("INSERT INTO history_doctor(doctor_id,from_date,to_date) VALUES(%d,'%s','%s')", Integer.parseInt(doctorIds), fromDate, toDate);
            result = this.queryUpdate(sqlInsert);
        }
        return result;
    }
}
