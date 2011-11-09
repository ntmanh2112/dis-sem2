/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;

/**
 *
 * @author congnguyentan
 */
public class LoginModel extends Query {

    /*
     * constructor
     */
    public LoginModel(){
        super();
    }

    /*
     * function login
     *
     * @param: String username
     * @param: String password
     * @return: true if login success, false if login fail
     */
    public boolean login(String username, String password){
        boolean result = false;
        try{
            //String sqlLogin = "SELECT count(*) AS total FROM accounts WHERE employee_number LIKE '"+username+"' AND password LIKE '"+password+"'";
            String sqlLogin = String.format("SELECT count(*) AS total FROM user_login WHERE user_name LIKE '%s' AND pass_word LIKE '%s' AND active = %d",username,password,1);
            ResultSet rs = this.queryData(sqlLogin);
            while(rs.next()){
                int total = rs.getInt("total");
                if(total > 0){
                    result = true;
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
