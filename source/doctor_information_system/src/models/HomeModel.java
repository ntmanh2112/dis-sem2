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
public class HomeModel extends Query {

    /*
     * constructor
     */
    public HomeModel(){
        super();
    }

    /*
     * function used to get functions exists in system and had been allowed access by a specific user
     *
     * @param: String userLogged -> get functions that are granted to user logged
     * @param: string menuName -> get functions by name
     * @return: ResultSet store functions
     */
    public ResultSet getMenuByName(String userLogged,String menuName){
        ResultSet result;
        String sqlGet;
        
        sqlGet = String.format("SELECT count(*) AS total FROM functions WHERE function_id IN (SELECT func.function_id FROM ((functions AS func INNER JOIN roles_functions AS frole ON func.function_id = frole.function_id) INNER JOIN roles ON roles.role_id = frole.role_id) INNER JOIN user_login AS accs ON accs.role_id = roles.role_id WHERE accs.user_name LIKE '%s' AND func.function_name LIKE '%s')",userLogged,menuName);
        
        result = this.queryData(sqlGet);
        return result;
    }
}
