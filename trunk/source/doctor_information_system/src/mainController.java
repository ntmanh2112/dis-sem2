/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
//import models from package models
import models.*;
//import views from package views
import views.*;
//import controllers from package controllers
import controllers.*;
//import libs from package libs
import libs.*;

/**
 *
 * @author congnguyentan
 */
public class mainController extends ParentController {
    modelConfig mConfig = new modelConfig();
    viewConfig vConfig;

    LoginModel mLogin;

    //config path to file configuration
    private String _path_store_file_config = "congnguyentan_javadb";
    private String _file_config = "configuration_db.txt";

    public mainController() {
        super();
        boolean installation = false;
        this.userLogged = "";

        //check and create directory if not exits
        int resultDirectory = clsFile.createDirectory(_path_store_file_config);
        if(resultDirectory == 0){
            System.out.printf("Create directory store file config fail\n");
        }
        else if(resultDirectory == 1)
        {
            System.out.printf("Create directory store file config success\n");
        }
        else if(resultDirectory == 2)
        {
            System.out.printf("Directory store file config existed\n");
        }
        this._file_config = this._path_store_file_config + "/" + this._file_config;

        //try read file config
        String contentFile = clsFile.readFromFile(this._file_config);

        //File exists and has content
        if(!contentFile.isEmpty()){
            //try use content of file config to connect database
            //format of file config is : three line (line 1: database name, line 2: user, line 3: pass)
            String[] temp = contentFile.split("\n");
            String databaseName = temp[0];
            String userLog = temp[1];
            String passEncrypted = temp[2];

            //decrypt pass
            String passOriginal = clsPopulateFunctions.decryptPassword(passEncrypted);
            //test connection
            boolean test = this._testConnection(databaseName, userLog, passOriginal);
            if(test){
                System.out.printf("Use file config to init app success.\n");
                installation = true;
            }
            else{
                System.out.printf("Use file config to init app fail. Please re enter information to connect database server\n");
            }
        }
        else{
            System.out.printf("File config is not exists or is empty.\n");
        }

        //connect and init data fail
        if(!installation){
            vConfig = new viewConfig();
            //load action for buttons on view config
            this._loadActionOnViewConfig();
            //show view config
            vConfig.setLocationRelativeTo(null);
            vConfig.setVisible(true);
        }
        else{
            //doesn't log in -> show form login
            if(this.userLogged.equalsIgnoreCase("")){
                this._initFormLogin();
            }
            //logged in -> show form home
            else{
                this._initHome();
            }
        }
    }

    /*
     * function try test connection on database server with data entered from user
     *
     * @return: true if test success, false if test fail
     */
    private boolean _testConnection(String databaseName, String userlog, String password){
        boolean installation = false;
        if(!databaseName.isEmpty() & !userlog.isEmpty() & !password.isEmpty()){
            //set data connect
            mConfig.setDatabaseName(databaseName);
            mConfig.setUser(userlog);
            mConfig.setPassword(password);
            //test and init data
            if(mConfig.testConnection()){
                System.out.printf("Init data success.\n");
                installation = true;
            }
            else{
                System.out.printf("Init data fail.\n");
            }
        }
        return installation;
    }

    /*
     * function reset data on view config
     */
    private void _resetViewConfig(){
        vConfig.setDatabaseName("");
        vConfig.setUsername("");
        vConfig.setPassword("");
    }

    /*
     * function load action to buttons on view config
     */
    private void _loadActionOnViewConfig(){
        vConfig.setActionButtonOk(new actionButtonOkConfig());
        vConfig.setActionButtonCancel(new actionButtonCancelConfig());
        vConfig.setActionButtonReset(new actionButtonClearConfig());
    }

    /*
     * function init form Login
     */
    private void _initFormLogin(){
        //load model
        this.mLogin = new LoginModel();
        //load view
        this.vLogin = new LoginView();
        //load action on view
        this._loadActionOnViewLogin();
        //show view
        this.vLogin.setLocationRelativeTo(null);
        this.vLogin.setVisible(true);
    }

    /*
     * function load action to buttons on view login
     */
    private void _loadActionOnViewLogin(){
        this.vLogin.setActionOnButtonLogin(new ActionButtonLogin());
        this.vLogin.setActionOnButtonCancel(new ActionButtonCancel());
    }

    /*
     * function init home controller
     */
    private void _initHome(){
        HomeController cHome = new HomeController();
    }

    private String _getCurrentDate(){
        String format = "MM/dd/yyyy";
        String currentDate = clsDateTime.getCurrentDate(format);
        return currentDate;
    }

    /*all classes action on view config*/
    class actionButtonClearConfig implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            _resetViewConfig();
        }

    }

    class actionButtonCancelConfig implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            vConfig.dispose();
            System.exit(0);
        }

    }

    class actionButtonOkConfig implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String databaseName = vConfig.getDatabaseName().trim();
            String userlog = vConfig.getUsername().trim();
            String password = vConfig.getPassword().trim();

            //use class Validator to validate data entered
            String[] datas = new String[3];
            datas[0] = databaseName;
            datas[1] = userlog;
            datas[2] = password;

            boolean[] required = new boolean[3];
            required[0] = true;
            required[1] = true;
            required[2] = true;

            String[] regex = new String[3];
            regex[0] = "";
            regex[1] = "";
            regex[2] = "";

            String[] alerts = new String[3];
            alerts[0] = "Database name is invalid";
            alerts[1] = "Username log is invalid";
            alerts[2] = "Password is invalid";

            String validate = clsValidator.makeValidate(datas, required, regex, alerts);

            //enter valid data
            if(validate.isEmpty()){
                //test connection and init data with value entered
                boolean test = _testConnection(databaseName, userlog, password);
                //success
                if(test){
                    //close view config
                    vConfig.setVisible(false);
                    vConfig.dispose();
                    //write to file config
                    String passEncrypt = clsPopulateFunctions.encryptPassword(password);
                    String content = databaseName + "\n" + userlog + "\n" + passEncrypt;
                    boolean testWrite = clsFile.writeToFile(_file_config, content);
                    if(testWrite){
                        System.out.println("Write to file config success.");
                    }
                    else{
                        System.out.println("Write to file config fail.");
                    }
                    //dispose view config
                    vConfig.setVisible(false);
                    vConfig.dispose();
                    //init form Login
                    _initFormLogin();
                }
            }
            else{
                //show warning
                clsPopulateFunctions.showNotice(validate,"warning",vConfig);
            }
        }
    }
    /*end actions on view config*/

    /*all classes action on view login*/

    /*
     * class define action on button Login
     */
    class ActionButtonLogin implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String username = vLogin.getUsername().trim();
            String password = vLogin.getPassword().trim();

            //use class Validator to validate data entered
            String[] datas = new String[2];
            datas[0] = username;
            datas[1] = password;

            boolean[] required = new boolean[2];
            required[0] = true;
            required[1] = true;

            String[] regex = new String[2];
            regex[0] = "^[a-zA-Z0-9]+$";
            regex[1] = "^[a-zA-Z0-9 ]+$";

            String[] alerts = new String[2];
            alerts[0] = "Username is invalid";
            alerts[1] = "Password is invalid";

            String validate = clsValidator.makeValidate(datas, required, regex, alerts);

            //enter valid data
            if(validate.isEmpty()){
                //encrypt password
                password = clsPopulateFunctions.encryptPassword(password);
                //try login
                if(mLogin.login(username, password)){
                    //store id of user logged
                    userLogged = username;
                    vLogin.setVisible(false);
                    //init home controller
                    _initHome();
                }
                else{
                    //show warning
                    clsPopulateFunctions.showNotice("Login fail. Please try again","warning",vLogin);
                }
            }
            else{
                //show warning
                clsPopulateFunctions.showNotice(validate,"warning",vLogin);
            }
        }

    }

    /*
     * class define action on button Cancel
     */
    class ActionButtonCancel implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            vLogin.dispose();
            System.exit(0);
        }

    }
    /*end actions on view login*/

    public static void main(String[] args){
        mainController objStu = new mainController();
    }
}
