/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
//import libs
import libs.*;
//import model
import models.DepartmentsModel;
//import view
import views.DepartmentsView;
import views.HomeView;

/**
 *
 * @author congnguyentan
 */
public class DepartmentsController extends ParentController {

    private DepartmentsModel _mDepartments;
    private DepartmentsView _vDepartments;

    private String _idsDelete = "";

    private Vector _employees;

    /*
     * constructor
     */
    public DepartmentsController(){
        this._init();
    }

    /*
     * constructor
     */
    public DepartmentsController(String userLogged){
        this.userLogged = userLogged;
        this._init();
    }

    private void _init(){
        //init model and view
        _mDepartments = new DepartmentsModel();
        _vDepartments = new DepartmentsView();
        _employees = new Vector();
        //there is place to enter information connect to database. Note: this block only used to test controller
        /*_mDepartments.setDatabaseName("employee");
        _mDepartments.setUser("sa");
        _mDepartments.setPassword("dinhtoiyeuem");*/
        //end
        //check access valid
        if(_mDepartments.checkAccessValid(userLogged, "Manage Departments")){
            //load data on view
            this._loadDataOnView();
            //load action on view
            this._loadActionOnView();
            //show view
            _vDepartments.setLocationRelativeTo(null);
            _vDepartments.setVisible(true);
        }
        //else -> show warning and exit
        else{
            clsPopulateFunctions.showNotice("Access Denied", "warning", null);
            System.exit(0);
        }
    }

    private void _loadDataOnView(){
        ResultSet employees = this._mDepartments.getAllEmployees();
        this._employees.removeAllElements();
        try{
            while(employees.next()){
                String employeeNumber = employees.getString("employee_number");
                String employeeName = employees.getString("employee_name");

                Vector child = new Vector();
                child.add(employeeNumber);
                child.add(employeeName);

                this._employees.add(child);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        this._vDepartments.setLeaderEdit(this._employees);
        //get datas
        Vector datas = this._mDepartments.getAlldepartments();
        //set datas on table
        this._vDepartments.setDataTable(datas);
        //reset data on form edit and form search
        this._resetDataEditOnView();
        this._resetDataSearchOnView();
        //reset ids of rows selected
        this._idsDelete = "";
    }

    private String _getIdOfElement(String label, Vector vData){
        String result = "";
        for(int i=0;i<vData.size();i++){
            Vector element = (Vector) vData.get(i);
            String idFound = element.get(0).toString();
            String labelFound = element.get(1).toString();

            if(labelFound.equalsIgnoreCase(label)){
                result = idFound;
                break;
            }
        }
        return result;
    }

    private void _loadActionOnView(){
        this._vDepartments.addMouseListenerOnTable(new mouseListenerForTable());
        this._vDepartments.addKeyListenerOnTable(new keyListenerForTable());
        this._vDepartments.addActionOnButtonSearch(new actionOnButtonSearch());
        this._vDepartments.addActionOnButtonShowAll(new actionOnButtonShowAll());
        this._vDepartments.addActionOnButtonAdd(new actionOnButtonAdd());
        this._vDepartments.addActionOnButtonEdit(new actionOnButtonEdit());
        this._vDepartments.addActionOnButtonDelete(new actionOnButtonDelete());
        this._vDepartments.addActionOnButtonRestore(new actionOnButtonRestore());
        this._vDepartments.addActionOnButtonClose(new actionOnButtonClose());
    }

    private void _resetDataSearchOnView(){
        this._vDepartments.setSearch("");
    }

    private void _resetDataEditOnView(){
        this._vDepartments.setId("");
        this._vDepartments.setName("");
        this._vDepartments.setLeaderByIndex(0);
    }

    private void _jumbStepAdd2(){
        _vDepartments.setLabelButton("add", "Ok");
        _vDepartments.setLabelButton("delete", "Cancel");

        _vDepartments.setStatusButton("edit", false);
        _vDepartments.setStatusButton("restore", false);
        _vDepartments.setStatusButton("close", false);
        _vDepartments.setStatusButton("search", false);
        _vDepartments.setStatusButton("showall", false);
    }

    private void _revertStepAdd(){
        _vDepartments.setLabelButton("add", "Add");
        _vDepartments.setLabelButton("delete", "Delete");

        _vDepartments.setStatusButton("edit", true);
        _vDepartments.setStatusButton("restore", true);
        _vDepartments.setStatusButton("close", true);
        _vDepartments.setStatusButton("search", true);
        _vDepartments.setStatusButton("showall", true);

        _loadDataOnView();
    }

    class mouseListenerForTable implements MouseInputListener{

        /*
         * process mouse click followed by steps:
         * 
         * step 1 : get rows selected on table
         * step 2 : if rows selected is equal one -> show detail of location selected on form edit, else clear all value on form edit
         * step 3 : store ids of rows selected
         */
        public void mouseClicked(MouseEvent e) {
            //step 1 : get rows selected on table
            Vector rowsSelected = _vDepartments.getValueSelectedOnTable();
            //step 2 : if rows selected is equal one -> show detail of location selected on form edit
            if(rowsSelected.size() == 1){
                Vector element = (Vector) rowsSelected.get(0);
                String id = element.get(0).toString();
                String name = element.get(1).toString();
                String leader = element.get(2).toString();
                leader = leader.isEmpty()?"--Select Employee--":leader;

                _vDepartments.setId(id);
                _vDepartments.setName(name);
                _vDepartments.setLeader(leader);
            }
            //else clear all value on form edit
            else{
                _resetDataEditOnView();
            }
            //step 3 : store ids of rows selected
            _idsDelete = "";
            for(int i=0; i<rowsSelected.size(); i++){
                Vector element = (Vector) rowsSelected.get(i);
                String id = element.get(0).toString();

                if(_idsDelete.isEmpty()){
                    _idsDelete += id;
                }
                else{
                    _idsDelete += "," + id;
                }
            }
        }

        public void mousePressed(MouseEvent e) {

        }

        /*
         * process mouse click followed by steps:
         *
         * step 1 : get rows selected on table
         * step 2 : if rows selected is equal one -> show detail of location selected on form edit, else clear all value on form edit
         * step 3 : store ids of rows selected
         */
        public void mouseReleased(MouseEvent e) {
            //step 1 : get rows selected on table
            Vector rowsSelected = _vDepartments.getValueSelectedOnTable();
            //step 2 : if rows selected is equal one -> show detail of location selected on form edit
            if(rowsSelected.size() == 1){
                Vector element = (Vector) rowsSelected.get(0);
                String id = element.get(0).toString();
                String name = element.get(1).toString();
                String leader = element.get(2).toString();

                _vDepartments.setId(id);
                _vDepartments.setName(name);
                _vDepartments.setLeader(leader);
            }
            //else clear all value on form edit
            else{
                _resetDataEditOnView();
            }
            //step 3 : store ids of rows selected
            _idsDelete = "";
            for(int i=0; i<rowsSelected.size(); i++){
                Vector element = (Vector) rowsSelected.get(i);
                String id = element.get(0).toString();

                if(_idsDelete.isEmpty()){
                    _idsDelete += id;
                }
                else{
                    _idsDelete += "," + id;
                }
            }
        }

        public void mouseEntered(MouseEvent e) {
            //move mouse into table
        }

        public void mouseExited(MouseEvent e) {
            //move mouse get out table
        }

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }

    }

    class keyListenerForTable implements KeyListener{

        public void keyTyped(KeyEvent e) {

        }


        public void keyPressed(KeyEvent e) {

        }

        /*
         * process mouse click followed by steps:
         *
         * step 1 : get rows selected on table
         * step 2 : if rows selected is equal one -> show detail of location selected on form edit, else clear all value on form edit
         * step 3 : store ids of rows selected
         */
        public void keyReleased(KeyEvent e) {
            //step 1 : get rows selected on table
            Vector rowsSelected = _vDepartments.getValueSelectedOnTable();
            //step 2 : if rows selected is equal one -> show detail of location selected on form edit
            if(rowsSelected.size() == 1){
                Vector element = (Vector) rowsSelected.get(0);
                String id = element.get(0).toString();
                String name = element.get(1).toString();
                String leader = element.get(2).toString();

                _vDepartments.setId(id);
                _vDepartments.setName(name);
                _vDepartments.setLeader(leader);
            }
            //else clear all value on form edit
            else{
                _resetDataEditOnView();
            }
            //step 3 : store ids of rows selected
            _idsDelete = "";
            for(int i=0; i<rowsSelected.size(); i++){
                Vector element = (Vector) rowsSelected.get(i);
                String id = element.get(0).toString();

                if(_idsDelete.isEmpty()){
                    _idsDelete += id;
                }
                else{
                    _idsDelete += "," + id;
                }
            }
        }

    }

    class actionOnButtonSearch implements ActionListener{

        /*
         * process search followed by steps:
         *
         * step 1 : get value of text box search
         * step 2 : validate value search using class Validator
         * step 3 : if value search valid -> search and assign new datas on table, else show warning
         */
        public void actionPerformed(ActionEvent e) {
            //step 1 : get value of text box search
            String valueSearch = _vDepartments.getSearch();
            //step 2 : validate value search using class Validator
            String[] datas = new String[1];
            datas[0] = valueSearch;

            boolean[] required = new boolean[1];
            required[0] = true;

            String[] regex = new String[1];
            regex[0] = "^[a-zA-Z0-9 ]+$";

            String[] alerts = new String[1];
            alerts[0] = "Value search is invalid";

            String validate = clsValidator.makeValidate(datas, required, regex, alerts);
            //step 3 : if value search valid -> search and assign new datas on table
            if(validate.isEmpty()){
                //get datas search
                Vector datasGet = _mDepartments.getDepartmentsByName(valueSearch);
                //reset data on view edit
                _resetDataEditOnView();
                //assign data on table
                _vDepartments.setDataTable(datasGet);
                //reset ids of rows selected
                _idsDelete = "";
            }
            //else -> show warning
            else{
                clsPopulateFunctions.showNotice(validate, "warning", _vDepartments);
            }
        }

    }

    class actionOnButtonShowAll implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //step 1 : reset data on form edit and form search
            //step 2 : load all datas and assign datas on table
            _loadDataOnView();
        }

    }

    class actionOnButtonAdd implements ActionListener{

        /*
        
         */
        public void actionPerformed(ActionEvent e) {
            String label = _vDepartments.getLabelButton("add");
            if(label.equalsIgnoreCase("add")){
                _jumbStepAdd2();

                _resetDataEditOnView();
            }
            else{
                String name = _vDepartments.getName();
                String leader = _vDepartments.getLeaderEdit();
                String leaderID = _getIdOfElement(leader, _employees);
                leaderID = leaderID.equalsIgnoreCase("--Select Employee--")?"":leaderID;

                //step 2 : validate on value edit
                String[] datas = new String[1];
                datas[0] = name;

                boolean[] required = new boolean[1];
                required[0] = true;

                String[] regex = new String[1];
                regex[0] = "^[a-zA-Z0-9 ]+$";

                String[] alerts = new String[1];
                alerts[0] = "Department name is invalid";

                String validate = clsValidator.makeValidate(datas, required, regex, alerts);

                //If valid -> edit
                if(validate.isEmpty()){
                    if(name.length() > 50){
                        clsPopulateFunctions.showNotice("Length of name must less than or equal fifty chars", "warning", _vDepartments);
                    }
                    else{
                        //step 3 : check name exists
                        boolean nameExists = _mDepartments.checkNameExists(name, 0);
                        //If valid -> store
                        if(!nameExists){
                            if(_mDepartments.updatedepartments(name, 0,leaderID)){
                                clsPopulateFunctions.showNotice("Add Departments success", "notice", _vDepartments);
                                _revertStepAdd();
                                //reload data
                                _loadDataOnView();
                            }
                            else{
                                clsPopulateFunctions.showNotice("SQL error. Please try again", "warning", _vDepartments);
                            }
                        }
                        //else -> show warning
                        else{
                            clsPopulateFunctions.showNotice(String.format("Deoartment name %s is exists. Please enter another name",name), "warning", _vDepartments);
                        }
                    }
                    
                }
                //else -> show warning
                else{
                    clsPopulateFunctions.showNotice(validate, "warning", _vDepartments);
                }
            }
            /*//step 1 : check value in form search is not empty
            String name = _vDepartments.getSearch();
            //If empty -> show warning
            if(name.isEmpty()){
                clsPopulateFunctions.showNotice("Departments name is invalid", "warning", _vDepartments);
            }
            //else -> begin add
            else{
                //step 2 : validate on value add
                String[] datas = new String[1];
                datas[0] = name;

                boolean[] required = new boolean[1];
                required[0] = true;

                String[] regex = new String[1];
                regex[0] = "^[a-zA-Z0-9\\. ]+$";

                String[] alerts = new String[1];
                alerts[0] = "Departments name is invalid";

                String validate = clsValidator.makeValidate(datas, required, regex, alerts);

                //If valid -> add
                if(validate.isEmpty()){
                    //step 3 : check name exists
                    boolean nameExists = _mDepartments.checkNameExists(name, 0);
                    //If valid -> store
                    if(!nameExists){
                        if(_mDepartments.updatedepartments(name, 0)){
                            clsPopulateFunctions.showNotice("Add Deparments success", "notice", _vDepartments);
                            //reload data
                            _loadDataOnView();
                        }
                        else{
                            clsPopulateFunctions.showNotice("SQL error. Please try again", "warning", _vDepartments);
                        }
                    }
                    //else -> show warning
                    else{
                        clsPopulateFunctions.showNotice(String.format("Departments %s is exists. Please enter another name",name), "warning", _vDepartments);
                   }
                }
                //else -> show warning
                else{
                    clsPopulateFunctions.showNotice(validate, "warning", _vDepartments);
                }
            }*/

        }
        }
    class actionOnButtonEdit implements ActionListener{

        /*
         * process edit followed by steps:
         *
         * step 1 : check id in form edit is not empty. If empty -> show warning, else -> begin edit
         * step 2 : validate on value edit. If valid -> edit, else -> show warning
         * step 3 : check name exists. If valid -> store, else -> show warning
         */
        public void actionPerformed(ActionEvent e) {
            String id = _vDepartments.getId();
            String name = _vDepartments.getName();
            String leader = _vDepartments.getLeaderEdit();
            String leaderID = _getIdOfElement(leader, _employees);

            // step 1 : check id in form edit is not empty. If empty -> show warning
            if(id.isEmpty()){
                clsPopulateFunctions.showNotice("You must choose record to edit", "warning", _vDepartments);
            }
            //else -> begin edit
            else{
                //step 2 : validate on value edit
                String[] datas = new String[2];
                datas[0] = id;
                datas[1] = name;

                boolean[] required = new boolean[2];
                required[0] = true;
                required[1] = true;

                String[] regex = new String[2];
                regex[0] = "^[0-9]+$";
                regex[1] = "^[a-zA-Z0-9 ]+$";

                String[] alerts = new String[2];
                alerts[0] = "ID is invalid";
                alerts[1] = "Department name is invalid";

                String validate = clsValidator.makeValidate(datas, required, regex, alerts);

                //If valid -> edit
                if(validate.isEmpty()){
                    if(name.length() > 50){
                        clsPopulateFunctions.showNotice("Length of name must less than or equal fifty chars", "warning", _vDepartments);
                    }
                    else{
                    //step 3 : check name exists
                    boolean nameExists = _mDepartments.checkNameExists(name, Integer.valueOf(id));
                        //If valid -> store
                        if(!nameExists){
                            if(_mDepartments.updatedepartments(name, Integer.valueOf(id),leaderID)){
                                clsPopulateFunctions.showNotice("Update Department success", "notice", _vDepartments);
                                //reload data
                                _loadDataOnView();
                            }
                            else{
                                clsPopulateFunctions.showNotice("SQL error. Please try again", "warning", _vDepartments);
                            }
                        }
                        //else -> show warning
                        else{
                            clsPopulateFunctions.showNotice(String.format("Deoartment name %s is exists. Please enter another name",name), "warning", _vDepartments);
                        }
                    }
                }
                //else -> show warning
                else{
                    clsPopulateFunctions.showNotice(validate, "warning", _vDepartments);
                }
            }
        }

    }

    class actionOnButtonDelete implements ActionListener{

        /*
         * process delete followed by steps:
         *
         * step 1 : check id of rows selected if rows selected is greater than zero -> perform login delete on rows selected, else show warning
         */
        public void actionPerformed(ActionEvent e) {
            String label = _vDepartments.getLabelButton("delete");
            if(!label.equalsIgnoreCase("delete")){
                _revertStepAdd();
            }
            else{
                //step 1 : check id of rows selected if rows selected is not empty -> perform login delete on rows selected
                if(!_idsDelete.isEmpty()){
                    int isAllow = JOptionPane.showConfirmDialog(_vDepartments, "Do you want delete departments selected", "Confirm from user", JOptionPane.OK_CANCEL_OPTION);
                    if(isAllow == JOptionPane.OK_OPTION){
                        //if delete success -> load new datas, assign datas on table, reset data on form edit and form search, reset ids of rows selected
                        if(_mDepartments.applydepartments(_idsDelete,1)){
                            //reload data
                            _loadDataOnView();
                        }
                        //else -> show warning
                        else{
                            clsPopulateFunctions.showNotice("Function delete is error. Please try again", "warning", _vDepartments);
                        }
                    }
                }
                //else -> show warning
                else{
                    clsPopulateFunctions.showNotice("You must choose at least one row to delete", "warning", _vDepartments);
                }
            }
        }

    }

    class actionOnButtonRestore implements ActionListener{

        /*
         * process restore followed by steps:
         *
         * step 1 : check id of rows selected if rows selected is greater than zero -> perform restore on rows selected, else show warning
         */
        public void actionPerformed(ActionEvent e) {
            //step 1 : check id of rows selected if rows selected is not empty -> perform restore on rows selected
            if(!_idsDelete.isEmpty()){
                int isAllow = JOptionPane.showConfirmDialog(_vDepartments, "Do you want restore departments selected", "Confirm from user", JOptionPane.OK_CANCEL_OPTION);
                if(isAllow == JOptionPane.OK_OPTION){
                    //if restore success -> load new datas, assign datas on table, reset data on form edit and form search, reset ids of rows selected
                    if(_mDepartments.applydepartments(_idsDelete,0)){
                        //reload data
                        _loadDataOnView();
                    }
                    //else -> show warning
                    else{
                        clsPopulateFunctions.showNotice("Function restore is error. Please try again", "warning", _vDepartments);
                    }
                }
            }
            //else -> show warning
            else{
                clsPopulateFunctions.showNotice("You must choose at least one row to restore", "warning", _vDepartments);
            }
        }

    }

    class actionOnButtonClose implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            vHome.setEnabled(true);
            _vDepartments.setVisible(false);
        }

    }

    /*
     * this function only used to test controller
     */
    public static void main(String[] args){
        DepartmentsController cDepartments = new DepartmentsController("emp0000001");
    }
}
