
package Control;

//import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Properties;
import java.util.Vector;


public class DBHelper 
{    
   String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
          "databaseName=DBHoangDe;user=sa;password=admin_99;";
    private static Connection conn = null;    
    
    /** Creates a new instance of DBHelper */
    public DBHelper() 
    {
        if(conn == null)
        {
            try{
               // @SuppressWarnings("static-access")
               // String url = this.getSQLServerUrlConString();
             
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                  
                conn = DriverManager.getConnection(connectionUrl);
                // System.out.println("jbbkjbkjbkjb");
                 if (conn != null) {
                    System.out.println("SQL2005 database connection has been established!.");
               }
               
            }catch (ClassNotFoundException e){
                System.out.println(e);
            }catch (SQLException sql){
                System.out.println(sql);
            }            
        }
    }
    
    /**
     * Method executes a non-parameter selecting querry
     * @return ResultSet cs.executeQuery()
     * @param spName 
     * @throws java.sql.SQLException 
     */
    public static ResultSet executeQuery(String spName) throws SQLException
    {
        if(conn != null)
        {

            CallableStatement cs = conn.prepareCall("{call " + spName + "}");            
            return cs.executeQuery();
            //return cs.executeQuery();
        }
        return null;
    }
    
    /**
     * Method executes multi-parameter selecting querry
     * @return ResultSet cst.executeQuery()
     * @param spName 
     * @param paramList 
     * @throws java.sql.SQLException 
     */
   public static ResultSet executeQuery(String spName, Vector paramList) throws SQLException
    {
        if(conn != null)
        {
            String strQ = "{call " + spName + "(";
            int t =0;
            for(Object obj : paramList)
            {
                if(t != 0)
                    strQ += ",";
                if(obj instanceof Integer)
                {
                    Integer i = (Integer)obj;
                    strQ += i.toString();
                }else if(obj instanceof String)
                {
                    String s = (String)obj;
                    strQ += "'" + s + "'";
                }
                t++;
            }
            strQ += ")}";
            
            CallableStatement cst = conn.prepareCall(strQ);
            return cst.executeQuery();
        }
        return null;
    }    
        
    /**
     * Method to update and delete one record in table
     * @return int cst.executeUpdate()
     * @param spName 
     * @param paramList 
     * @throws java.sql.SQLException 
     */
    public static int executeUpdate(String spName, Vector paramList) throws SQLException
    {
        if(conn != null)
        {
            String strQ = "{call " + spName + "(";
            
            int t = 0;
            for(Object obj : paramList)
            {
                if(t != 0)
                    strQ += ",";
                if(obj instanceof Integer)
                {
                    Integer i = (Integer)obj;
                    strQ += i.toString();
                }
                else if(obj instanceof Float)
                {
                    Float f = (Float)obj;
                    strQ += f.toString();
                }
                else if(obj instanceof String)
                {
                    String s = (String)obj;
                    strQ += "'" + s + "'";
                }
                t++;
            }
            strQ += ")}";
            
            CallableStatement cst = conn.prepareCall(strQ);
            return cst.executeUpdate();
        }
        return -1;
    }
    
    /**
     * 
     * @param a 
     */
    public static void main(String[] args)
    {
        new DBHelper();
    }
}


