/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author congnguyentan
 */
public class DepartmentsModel extends Query {

    /*
     * constructor
     */
    public DepartmentsModel(){
        super();
    }

    public Vector getAlldepartments(){
        Vector result = new Vector();
        try{
            String sqlGet = "SELECT id,name,leader,employee_name,departments.hidden FROM departments LEFT OUTER JOIN employees ON employees.employee_number = departments.leader ORDER BY name";
            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                int id = rsGet.getInt("id");
                String name = rsGet.getString("name");
                int hidden = rsGet.getInt("hidden");
                String hiddenString = "Existing";
                if(hidden == 1){
                    hiddenString = "Deleted";
                }
                String leader = rsGet.getString("leader");
                String employee_name = rsGet.getString("employee_name");

                Vector dataSet = new Vector();
                dataSet.add(order);
                dataSet.add(name);
                dataSet.add(employee_name);
                dataSet.add(hiddenString);
                dataSet.add(leader);
                dataSet.add(id);

                result.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
    public ResultSet getAllEmployees(){
        ResultSet vProject = null;
        try{
            String sql = "SELECT * FROM employees WHERE hidden = 0 ORDER BY employee_name";
            vProject = this.queryData(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return vProject;
    }

    public Vector getDepartmentsByName(String nameCondition){
        Vector result = new Vector();
        nameCondition = nameCondition.trim();
        try{
            String sqlGet;
            if(nameCondition.isEmpty()){
                sqlGet = "SELECT * FROM departments WHERE hidden = 0 ORDER BY name";
            }
            else{
                nameCondition = "'%" + String.format("%s", nameCondition) + "%'";
                sqlGet = String.format("SELECT * FROM departments WHERE name LIKE %s ORDER BY name",nameCondition);
            }
            ResultSet rsGet = this.queryData(sqlGet);
            int order = 0;
            while(rsGet.next()){
                order++;
                int id = rsGet.getInt("id");
                String name = rsGet.getString("name");
                int hidden = rsGet.getInt("hidden");
                String hiddenString = "Existing";
                if(hidden == 1){
                    hiddenString = "Deleted";
                }

                Vector dataSet = new Vector();
                dataSet.add(order);
                dataSet.add(name);
                dataSet.add(hiddenString);
                dataSet.add(id);

                result.add(dataSet);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean applydepartments(String idsdepartments, int status){
        boolean result = false;
        try{
            String sqlApply = "";
            if(!idsdepartments.isEmpty() && status >= 0){
                sqlApply = String.format("UPDATE departments SET hidden = %d WHERE id IN (%s)",status,idsdepartments);
            }

            if(!sqlApply.isEmpty()){
                result = this.queryUpdate(sqlApply);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkNameExists(String name, int id){
        boolean result = false;
        try{
            if(!name.isEmpty() && id >= 0){
                String sqlCheck = "SELECT count(*) AS total FROM departments WHERE name LIKE '%s'";
                if(id > 0){
                    sqlCheck += " AND id NOT IN (%d)";
                }
            sqlCheck = String.format(sqlCheck, name,id);
                ResultSet rsCheck = this.queryData(sqlCheck);
                while(rsCheck.next()){
                    int total = rsCheck.getInt("total");
                    if(total > 0){
                        result = true;
                    }
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean updatedepartments(String name, int id, String leader){
        boolean result = false;
        try{
            if(!name.isEmpty() && id >= 0){
                String sqlUpdate;
                if(id > 0){
                    if(!leader.isEmpty()){
                        sqlUpdate = String.format("UPDATE departments SET name = '%s', leader = '%s' WHERE id = %d",name,leader,id);
                    }
                    else{
                        sqlUpdate = String.format("UPDATE departments SET name = '%s', leader = NULL WHERE id = %d",name,id);
                    }
                }
                else{
                    if(!leader.isEmpty()){
                        sqlUpdate = String.format("INSERT INTO departments(name,leader) VALUES('%s','%s')",name,leader);
                    }
                    else{
                        sqlUpdate = String.format("INSERT INTO departments(name) VALUES('%s')",name);
                    }
                }
                System.out.println(sqlUpdate);
                result = this.queryUpdate(sqlUpdate);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
