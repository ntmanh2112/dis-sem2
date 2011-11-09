package models;


import java.sql.*;
import libs.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Calvin
 */
public class Query{
     protected Connection con = null;
     protected Statement st;
     protected ResultSet rs;
     protected static String databaseName = "";
     protected static String user = "";
     protected static String password = "";

     /*
      * construct
      */
     public Query(){
          try {
              
          } catch (Exception ex) {
               System.out.println(ex);
          }
     }

     /*
      * open connection
      */
     private void _openConnection(){
         try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String connection = this._getConnectionUrl(false);
             con = DriverManager.getConnection(connection);
         } catch (Exception ex) {
            System.out.println(ex);
         }
     }

     /*
      * close connection
      */
     private void _closeConnection(){
         try{
             //st.close();
             //rs.close();
             con.close();
         } catch (Exception ex) {
            System.out.println(ex);
         }
     }

     /*
      * function query data
      */
     public ResultSet queryData(String sql){
         try{
             if(!sql.isEmpty()){
                 //open connection
                 this._openConnection();

                 st = con.createStatement();
                 rs = st.executeQuery(sql);
                 //this._closeConnection();
                 return rs;
             }
         } catch (Exception ex) {
            System.out.println(ex);
         }
         return null;
     }

     /*
      * function excute query
      * @return: true if success otherwise return false
      */
     public boolean queryUpdate(String sql){
         try{
             if(!sql.isEmpty()){
                 //open connection
                 this._openConnection();

                 st = con.createStatement();
                 boolean status = st.execute(sql);
                 int updatedRow = st.getUpdateCount();
                 //System.out.println("Num row is affected is: " + Integer.toString(updatedRow));
                 status = false;
                 if(updatedRow > 0){
                     status = true;
                 }
                this._closeConnection();
                return status;
             }
         } catch (Exception ex) {
            System.out.println(ex);
         }
         return false;
     }

     /*
      * function init database
      */
     private boolean _createDatabase(){
         boolean result = false;
         try{
             if(!this.databaseName.isEmpty() & this.con != null){
                this.st = this.con.createStatement();
                String sql = "if db_id('" + this.databaseName + "') is null "
                        + "begin "
                        + "select 1; "
                        + "end";
                boolean resultCheck = st.execute(sql);
                if(resultCheck){
                    sql = "create database " + this.databaseName + ";";
                    st.executeUpdate(sql);
                }
                System.out.printf("Init database done. Create database %s => %s.\n",this.databaseName,resultCheck?"Added":"Existed");
                result = true;
             }
         } catch (Exception e){
             System.out.println(e.getMessage());
         }
         return result;
     }

     /*
      * function check data had been initialized or not
      *
      * @return: true if initialized, false if not
      */
     private boolean _checkDataHadBeenInitialized(){
         boolean check = false;
         try{
             this.st = this.con.createStatement();
             String sql = "SELECT status FROM tblInitData";
             ResultSet rsTest = this.st.executeQuery(sql);
             while(rsTest.next()){
                 int status = rsTest.getInt("status");
                 if(status == 1){
                     check = true;
                 }
             }
         } catch(Exception e){

         }
         return check;
     }

     /*
      * function init data
      */
     private boolean _initData(){
         boolean result = false;
         //check data had been initialized or not
        if(this._checkDataHadBeenInitialized()){
            result = true;
        }
        else{
             try{
                 //create and assign value for table status init data
                 String sql = "CREATE TABLE [dbo].[tblInitData](status int)";
                 st.execute(sql);
                 sql = "INSERT INTO [dbo].[tblInitData] VALUES(1);";
                 st.execute(sql);
                 //read content of file sql install
                 String content = clsFile.readFromFile("src/sql/create.sql");
                 if(!content.isEmpty()){
                     //split into single sql commands
                     String[] contentSplit = content.split("\nGO\n");
                     boolean runSuccessAll = true;
                     //try run for each sql command
                     for(int i=0;i<contentSplit.length;i++){
                         try{
                             String singleSql = contentSplit[i];
                             System.out.print("\nDebug sql: " + singleSql);
                             this.st.execute(singleSql);
                             System.out.print(" ---> success");
                         } catch (Exception e){
                             runSuccessAll = false;
                             System.out.print(" ---> fail");
                         }
                     }
                     //all sql commands run success -> add user login
                     if(runSuccessAll){
                        result = true;
                        //create password encrypted for users
                        String passwordEncrypted = clsPopulateFunctions.encryptPassword("123456");

                        sql = "INSERT INTO user_login([user_name],[pass_word],[role_id]) VALUES('admin','"+passwordEncrypted+"',1)";
                        try{
                            this.st.executeUpdate(sql);
                            System.out.print("\nCreate account admin success");
                        } catch (Exception e){
                            System.out.print("\nCreate account admin fail");
                            result = false;
                        }

                        sql = "INSERT INTO user_login([user_name],[pass_word],[role_id]) VALUES('employee','"+passwordEncrypted+"',2)";
                        try{
                            this.st.executeUpdate(sql);
                            System.out.print("\nCreate account employee success");
                        } catch (Exception e){
                            System.out.print("\nCreate account employee fail");
                            result = false;
                        }
                     }
                 }
             }
             catch(Exception e){System.out.println(e.getMessage()); }
        }
        if(result){
            System.out.println("\nInit data sample success");
        }
        else{
            System.out.println("\nInit data sample fail");
        }
        return result;
     }

     public String getDatabaseName(){
         return this.databaseName;
     }

     public void setDatabaseName(String databaseName){
         this.databaseName = databaseName;
     }

     public String getUser(){
         return this.user;
     }

     public void setUser(String user){
         this.user = user;
     }

     public String getPassword(){
         return this.password;
     }

     public void setPassword(String password){
         this.password = password;
     }

     public boolean testConnection(){
         boolean result = false;
         if(!this.databaseName.isEmpty() & !this.user.isEmpty() & !this.password.isEmpty()){
             try{
                 //create connection
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 String connectionUrl = this._getConnectionUrl(true);
                 this.con = DriverManager.getConnection(connectionUrl);
                 if(this.con != null){
                     //init database
                     if(this._createDatabase()){
                         //close all
                         this.st.close();
                         this.con.close();
                         //make connection string again with database name
                         connectionUrl = this._getConnectionUrl(false);
                         //create connection again with new connection string
                         this.con = DriverManager.getConnection(connectionUrl);
                         //init data
                         if(this._initData()){
                             result = true;
                             
                         }
                        else{
                            System.out.println("Init database fail.");
                        }
                     }
                    else{
                        System.out.println("Init database fail.");
                    }
                 }
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         }
         
         try{
             st.close();
            con.close();
         } catch (Exception e) {
            
         }

         return result;
     }

     private String _getConnectionUrl(boolean excludeDatabase){
         String connectionUrl = "jdbc:sqlserver://localhost:1433;";
         if(!this.databaseName.isEmpty() & !excludeDatabase){
             connectionUrl += "databaseName=" + this.databaseName + ";";
         }
         if(!this.user.isEmpty()){
             connectionUrl += "user=" + this.user + ";";
         }
         if(!this.password.isEmpty()){
             connectionUrl += "password=" + this.password + ";";
         }
         return connectionUrl;
     }

     
    public boolean checkUserIsSuperAdmin(String userLogged){
        return false;
    }

    /*
     * function check perms valid on user logged
     *
     * @param : String emp ID of user logged
     * @param : String function name
     * @return : true if valid, false if not
     */
    public boolean checkAccessValid(String userLogged, String funcName){
        boolean result = false;
        try{
            if(!userLogged.isEmpty() && !funcName.isEmpty()){
                //if user logged is super admin -> alway valid
                if(this.checkUserIsSuperAdmin(userLogged)){
                    result = true;
                }
                //else -> check valid on user ID and function name
                else{
                    String sqlCheck = String.format("SELECT count(func.*) AS total FROM (((functions AS func INNER JOIN roles_functions AS frole ON func.id = frole.function_id) INNER JOIN roles ON roles.id = frole.role_id) INNER JOIN user_login AS accs ON accs.role_id = roles.role_id) WHERE accs.user_name LIKE '%s' AND func.name LIKE '%s' AND accs.active = %d",userLogged,funcName,1);
                    ResultSet rsCheck = this.queryData(sqlCheck);
                    while(rsCheck.next()){
                        int total = rsCheck.getInt("total");
                        if(total > 0){
                            result = true;
                        }
                    }
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}