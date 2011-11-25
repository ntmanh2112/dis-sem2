/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import models.DoctorModel;
import views.Doctor;
import libs.*;

/**
 *
 * @author congnguyentan
 */
public class DoctorController extends ParentController {
    private DoctorModel _doctorModel;
    private Doctor _doctorView;

    private Vector _doctors;
    private Vector _countries;
    private Vector _citiesSearch;
    private Vector _citiesEdit;
    private Vector _qualification;
    private Vector _professional;

    private String _idDoctorView;
    private String _idHistoryView;

    private boolean _isAdding;
    private boolean _isAddingSchedule;


    /*
     * constructor
     */
    public DoctorController(){
        this._init();
    }

    /*
     * constructor -> used to test controller
     */
    public DoctorController(String userLogged){
        this.userLogged = userLogged;
        this._init();
    }

    private void _init(){
        //init model and view
        this._doctorModel = new DoctorModel();
        this._doctorView = new Doctor();
        this._doctors = new Vector();
        //there is place to enter information connect to database. Note: this block only used to test controller
        /*this._doctorModel.setDatabaseName("doctor_system");
        this._doctorModel.setUser("sa");
        this._doctorModel.setPassword("dinhtoiyeuem");*/
        //end
        //check access valid
        if(this._doctorModel.checkAccessValid(this.userLogged, "Manage Doctor") | this._doctorModel.checkAccessValid(this.userLogged, "Search")){
            //load data on view
            this._loadDataOnView();
            //load action on view
            this._loadActionOnView();
            //show view
            this._doctorView.setLocationRelativeTo(null);
            this._doctorView.setVisible(true);
        }
        //else -> show warning and exit
        else{
            clsPopulateFunctions.showNotice("Access Denied", "warning", null);
            System.exit(0);
        }
    }

    private void _loadDataOnView(){
        //get countries
        this._countries = this._doctorModel.getListCountries();
        //get cities
        this._citiesSearch = new Vector();
        this._citiesEdit = new Vector();
        //get qualification
        this._qualification = this._doctorModel.getListSpecializations();
        this._professional = this._doctorModel.getListProfessionals();
        //get doctors
        this._doctors = this._doctorModel.getListDoctorsRenderTable(null);
        //set datas on table
        this._doctorView.setDataTableListDoctor(this._doctors);
        this._doctorView.setSpecializationEdit(this._qualification);
        this._doctorView.setProfessionalEdit(this._professional);
        this._doctorView.setCountryEdit(this._countries);
        //reset data on form edit and form search
        this._resetDataFormEdit();
        this._resetDataFormSearch();
        //this._resetDataSearchOnView();
        //reset status of buttons on view
        this._resetStatusOnView();
        //reset ids of rows selected
        this._idDoctorView = "";
        
        _loadDataScheduleOnView();
    }

    private void _loadDataScheduleOnView(){
        this._doctorView.setStatusAddDoctorButton(true);
        if(!this._idDoctorView.isEmpty()){
            this._doctorView.setStatusDeleteDoctorButton(true);
            if(this._idDoctorView.indexOf(",") == -1){
                Vector conditions = new Vector();
                String condition = String.format("doctor_id IN (%s)", this._idDoctorView);
                conditions.add(condition);
                Vector listHistory = this._doctorModel.getHistoryVisiting(conditions);
                this._doctorView.setDataTableHistoryVisiting(listHistory);
                //disable button add schedule and delete schedule
                this._doctorView.setStatusAddScheduleButton(true);

                this._doctorView.setStatusEditDoctorButton(true);
                this._doctorView.setStatusViewArchivementButton(true);
            }
            else{
                this._doctorView.setDataTableHistoryVisiting(null);
                this._doctorView.setStatusAddScheduleButton(false);
            }
        }
        else{
            //disable button add schedule and delete schedule
            this._doctorView.setStatusAddScheduleButton(false);
            this._doctorView.setDataTableHistoryVisiting(null);
        }
        //restore label of button add schedule and delete schedule
        this._doctorView.setLabelAddScheduleButton("Add Schedule");
        this._doctorView.setLabelDeleteScheduleButton("Delete Schedule");
        this._doctorView.setStatusDeleteScheduleButton(false);

        this._doctorView.setStatusTableHistoryVisiting(true);
        this._doctorView.setStatusTableListDoctor(true);

        this._idHistoryView = "";
        
        this._isAdding = false;
        this._isAddingSchedule = false;
    }

    private void _resetStatusOnView(){
        //reset status of button
        this._doctorView.setStatusAddDoctorButton(true);
        this._doctorView.setStatusEditDoctorButton(false);
        this._doctorView.setStatusDeleteDoctorButton(false);
        this._doctorView.setStatusAddScheduleButton(false);
        this._doctorView.setStatusDeleteScheduleButton(false);
        this._doctorView.setStatusViewArchivementButton(false);
        this._doctorView.setStatusTableListDoctor(true);
        this._doctorView.setStatusAddScheduleButton(false);
        this._doctorView.setStatusDeleteScheduleButton(false);
        //reset label of button
        this._doctorView.setLabelAddDoctorButton("Add Doctor");
        this._doctorView.setLabelEditDoctorButton("Edit Doctor");
    }

    private void _loadActionOnView(){
        //define action on list country search
        this._doctorView.setActionOnListCountrySearch(new ActionListCountrySearch());
        //define action on list country edit
        this._doctorView.setActionOnListCountryEdit(new ActionListCountryEdit());
        //this._doctorView.setActionClickOnListCountryEdit(new ActionClickListCountryEdit());
        //define action on button search
        this._doctorView.setActionOnButtonSearch(new ActionOnButtonSearch());
        //define action on button show all
        this._doctorView.setActionOnButtonShowAll(new ActionOnButtonShowAll());
        //define action on table list doctors and history visiting
        this._doctorView.addMouseListenerOnTableListDoctor(new MouseListenerForTableListDoctor());
        this._doctorView.addKeyListenerOnTableListDoctor(new KeyListenerForTableListDoctor());
        this._doctorView.addMouseListenerOnTableListSchedule(new MouseListenerForTableHistoryVisiting());
        this._doctorView.addKeyListenerOnTableListSchedule(new KeyListenerForTableHistoryVisiting());
        //define action on button add,edit and delete doctor
        this._doctorView.setActionOnButtonAddDoctor(new ActionOnButtonAddDoctor());
        this._doctorView.setActionOnButtonEditDoctor(new ActionOnButtonEditDoctor());
        this._doctorView.setActionOnButtonDeleteDoctor(new ActionOnButtonDeleteDoctor());
        //define action on button close form
        this._doctorView.setActionOnButtonCloseForm(new ActionOnButtonClose());
        //define action on button add and delete schedule
        this._doctorView.setActionOnButtonAddSchedule(new ActionOnButtonAddSchedule());
        this._doctorView.setActionOnButtonDeleteSchedule(new ActionOnButtonDeleteSchedule());
    }

    private void _resetDataFormEdit(){
        this._doctorView.setFirstName("");
        this._doctorView.setLastName("");
        this._doctorView.setAddress("");
        this._doctorView.setEmail("");
        this._doctorView.setPhone("");
        this._doctorView.setExpEdit("");
        this._doctorView.setCityEdit(new Vector());
        this._doctorView.setCountryEditSelected("--Select Country--");
        this._doctorView.setProfessionalEditSelected("--Select Professional--");
        this._doctorView.setSpecializationEditSelected("--Select Specialization--");
    }

    private void _resetDataFormAddSchedule(){
        String currentDate = clsDateTime.getCurrentDate("dd/MM/yyyy");
        Date objCurrentDate = clsDateTime.convertStringToDate(currentDate, "");
        this._doctorView.setFromDateAdd(objCurrentDate);
        this._doctorView.setToDateAdd(objCurrentDate);
    }

    private void _resetDataFormSearch(){
        //reset data
        this._doctorView.setValueSearch("");
        this._doctorView.setExpValueSearch("");
        this._doctorView.setCountrySearch(this._countries);
        this._doctorView.setCitySearch(new Vector());
        this._doctorView.setOperationExpSearch();
        this._doctorView.setSpecializationSearch(this._qualification);

        //reset status button
        this._doctorView.setStatusSearchButton(true);
        this._doctorView.setStatusShowAllButton(true);
    }
    
    private int _getCountryIdFromName(String countryName){
        int countryId = -1;
        for(int i = 0;i<this._countries.size();i++){
            Vector element = (Vector) this._countries.get(i);
            String label = element.get(1).toString();
            if(label.equalsIgnoreCase(countryName)){
                countryId = Integer.parseInt(element.get(0).toString());
                break;
            }
        }
        return countryId;
    }

    private int _getCitySearchIdFromName(String cityName){
        int cityId = -1;
        for(int i = 0;i<this._citiesSearch.size();i++){
            Vector element = (Vector) this._citiesSearch.get(i);
            String label = element.get(1).toString();
            if(label.equalsIgnoreCase(cityName)){
                cityId = Integer.parseInt(element.get(0).toString());
                break;
            }
        }
        return cityId;
    }

    private int _getCityEditIdFromName(String cityName){
        int cityId = -1;
        for(int i = 0;i<this._citiesEdit.size();i++){
            Vector element = (Vector) this._citiesEdit.get(i);
            String label = element.get(1).toString();
            if(label.equalsIgnoreCase(cityName)){
                cityId = Integer.parseInt(element.get(0).toString());
                break;
            }
        }
        return cityId;
    }

    private int _getSpecializationIdFromName(String specializationName){
        int specializationId = -1;
        for(int i = 0;i<this._qualification.size();i++){
            Vector element = (Vector) this._qualification.get(i);
            String label = element.get(1).toString();
            if(label.equalsIgnoreCase(specializationName)){
                specializationId = Integer.parseInt(element.get(0).toString());
                break;
            }
        }
        return specializationId;
    }

    private int _getProfessionalIdFromName(String professionalName){
        int professionalId = -1;
        for(int i = 0;i<this._professional.size();i++){
            Vector element = (Vector) this._professional.get(i);
            String label = element.get(1).toString();
            if(label.equalsIgnoreCase(professionalName)){
                professionalId = Integer.parseInt(element.get(0).toString());
                break;
            }
        }
        return professionalId;
    }

    private String _getOperationCharFromName(String operationName){
        String operationChar = "";
        if(operationName.equalsIgnoreCase("greater than")){
            operationChar = ">";
        }
        else if(operationName.equalsIgnoreCase("greater than or equal")){
            operationChar = ">=";
        }
        else if(operationName.equalsIgnoreCase("equal")){
            operationChar = "=";
        }
        else if(operationName.equalsIgnoreCase("not equal")){
            operationChar = "<>";
        }
        else if(operationName.equalsIgnoreCase("less than or equal")){
            operationChar = "<=";
        }
        else if(operationName.equalsIgnoreCase("less than")){
            operationChar = "<";
        }
        return operationChar;
    }

    private void _processRowsSelectedOnTableDoctors(){
        if(!this._isAdding){
            //step 1 : get rows selected on table
            Vector rowsSelected = this._doctorView.getIdsDoctorSelectedOnTableListDoctor();
             //step 2 : if rows selected is greater than or equal one -> show detail of doctor selected on form edit and detail history visiting on table history visiting
            if(rowsSelected.size() >= 1){
                //store ids of rows selected
                this._idDoctorView = "";
                for(int i=0;i<rowsSelected.size();i++){
                    String doctorId = rowsSelected.get(i).toString();
                    this._idDoctorView += this._idDoctorView.isEmpty()?doctorId:","+doctorId;
                }

                if(rowsSelected.size() == 1){
                    //get information of doctor view
                    Vector conditions = new Vector();
                    String condition = String.format("doctor.doctor_id IN (%s)", this._idDoctorView);
                    conditions.add(condition);
                    Vector doctors = this._doctorModel.getListDoctorsGlobal(conditions);
                    Vector doctorView = (Vector) doctors.get(0);
                    //set information on form edit
                    this._doctorView.setFirstName(doctorView.get(1).toString());
                    this._doctorView.setLastName(doctorView.get(2).toString());
                    this._doctorView.setAddress(doctorView.get(3).toString());
                    this._doctorView.setEmail(doctorView.get(4).toString());
                    this._doctorView.setPhone(doctorView.get(5).toString());

                    String format = "dd/MM/yyyy";
                    Date birthDaySet = clsDateTime.convertStringToDate(doctorView.get(6).toString(), format);
                    this._doctorView.setBirthdayEdit(birthDaySet);

                    this._doctorView.setSexEditSelected(doctorView.get(7).toString());
                    this._doctorView.setExpEdit(doctorView.get(8).toString());

                    this._doctorView.setCountryEditSelected(doctorView.get(10).toString());
                    /*int countryIdEdit = Integer.parseInt(doctorView.get(14).toString());
                    conditions.removeAllElements();
                    condition = String.format("city.country_id = %d", countryIdEdit);
                    conditions.add(condition);
                    Vector listCityEdit = this._doctorModel.getListCities(conditions);
                    this._doctorView.setCityEdit(listCityEdit);*/
                    this._doctorView.setCityEditSelected(doctorView.get(9).toString());
                    this._doctorView.setProfessionalEditSelected(doctorView.get(11).toString());
                    this._doctorView.setSpecializationEditSelected(doctorView.get(12).toString());

                    //enable button edit doctor and button view archivement
                    this._doctorView.setStatusEditDoctorButton(true);
                    this._doctorView.setStatusViewArchivementButton(true);

                    //load data history visiting of doctor viewing
                    conditions.removeAllElements();
                    condition = String.format("doctor_id IN (%s)", this._idDoctorView);
                    conditions.add(condition);
                    Vector listHistory = this._doctorModel.getHistoryVisiting(conditions);
                    this._doctorView.setDataTableHistoryVisiting(listHistory);
                    this._doctorView.setStatusAddScheduleButton(true);
                }
                else{
                    //reset data on form edit
                    this._resetDataFormEdit();
                    //disable button edit doctor and button view archivement
                    this._doctorView.setStatusEditDoctorButton(false);
                    this._doctorView.setStatusViewArchivementButton(false);
                    //clear data in table history visiting
                    this._doctorView.setDataTableHistoryVisiting(null);
                    this._doctorView.setStatusAddScheduleButton(false);
                    this._idHistoryView = "";
                }

                //enable button delete doctor
                this._doctorView.setStatusDeleteDoctorButton(true);

                //disable delete schedule
                this._doctorView.setStatusDeleteScheduleButton(false);
            }
            else{
                //reset data on form edit
                this._resetDataFormEdit();
                //disable button edit doctor and button view archivement
                this._doctorView.setStatusEditDoctorButton(false);
                this._doctorView.setStatusViewArchivementButton(false);
                //disable button delete doctor
                this._doctorView.setStatusDeleteDoctorButton(false);
                //clear data in table history visiting
                this._doctorView.setDataTableHistoryVisiting(null);
                this._doctorView.setStatusAddScheduleButton(false);
                this._doctorView.setStatusDeleteScheduleButton(false);
                this._idHistoryView = "";
                //reset id doctor viewing
                this._idDoctorView = "";
            }
        }
    }

    private void _processRowsSelectedOnTableHistoryVisiting(){
        if(!this._isAddingSchedule){
            this._idHistoryView = "";
            //step 1 : get rows selected on table
            Vector rowsSelected = this._doctorView.getIdsDoctorSelectedOnHistoryVisiting();
             //step 2 : if rows selected is greater than or equal one -> show detail of doctor selected on form edit and detail history visiting on table history visiting
            if(rowsSelected.size() >= 1){
                //store ids of rows selected
                for(int i=0;i<rowsSelected.size();i++){
                    String historyId = rowsSelected.get(i).toString();
                    this._idHistoryView += this._idHistoryView.isEmpty()?historyId:","+historyId;
                }

                //enable button delete history
                this._doctorView.setStatusDeleteScheduleButton(true);
            }
            else{
                this._doctorView.setStatusDeleteScheduleButton(false);
            }
        }
    }

    private void _processFormUpdateDoctor(String action){
        boolean result = false;
        /* get data update */
        String firstNameEdit = this._doctorView.getFirstName();
        String lastNameEdit = this._doctorView.getLastName();
        String email = this._doctorView.getEmail();
        String address = this._doctorView.getAddress();
        String phone = this._doctorView.getPhone();
        String exp = this._doctorView.getExpEdit();
        String birthday = this._doctorView.getBirthdayEdit();
        String country = this._doctorView.getCountryEditSelected();
        int countryEdit = this._getCountryIdFromName(country);
        String city = this._doctorView.getCityEditSelected();
        int cityEdit = this._getCityEditIdFromName(city);
        String professional = this._doctorView.getProfessionalEditSelected();
        int professionalEdit = this._getProfessionalIdFromName(professional);
        String specialization = this._doctorView.getSpecializationEditSelected();
        int specializationEdit = this._getSpecializationIdFromName(specialization);
        String sexEdit = this._doctorView.getSexEditSelected();
        /* end get data update */

        /* validate data update */
        String[] datas = new String[7];
        boolean[] required = new boolean[7];
        String[] regex = new String[7];
        String[] alerts = new String[7];
        //first name
        datas[0] = firstNameEdit;
        required[0] = true;
        regex[0] = "";
        alerts[0] = "First name is invalid";
        //last name
        datas[1] = lastNameEdit;
        required[1] = true;
        regex[1] = "";
        alerts[1] = "Last name is invalid";
        //email
        datas[2] = email;
        required[2] = true;
        regex[2] = "^[^@]+@[^@]+$";
        alerts[2] = "Email is invalid";
        //address
        datas[3] = address;
        required[3] = true;
        regex[3] = "";
        alerts[3] = "Address is invalid";
        //phone
        datas[4] = phone;
        required[4] = true;
        regex[4] = "^[0-9\\-]+$";
        alerts[4] = "Phone number is invalid";
        //experience
        datas[5] = exp;
        required[5] = true;
        regex[5] = "^[0-9]+$";
        alerts[5] = "Experience is invalid";
        //birthday
        datas[6] = birthday;
        required[6] = true;
        regex[6] = "^[0-9\\/]+$";
        alerts[6] = "Birthday is invalid";

        String validate = clsValidator.makeValidate(datas, required, regex, alerts);
        if(validate.isEmpty()){
            String warning = "";
            //check birthday valid
            String[] birthdaySplit = birthday.split("/");
            if(Integer.parseInt(birthdaySplit[2]) > 1990){
                warning = "Year of birthday must less than or equal 1990";
            }
            //check choose country
            if(countryEdit == -1 && warning.isEmpty()){
                warning = "You must choose country";
            }
            //check choose city
            if(cityEdit == -1 && warning.isEmpty()){
                warning = "You must choose city";
            }
            //check choose professional
            if(professionalEdit == -1 && warning.isEmpty()){
                warning = "You must choose professional";
            }
            //check choose specialization
            if(specializationEdit == -1 && warning.isEmpty()){
                warning = "You must choose specialization";
            }

            //show warning
            if(!warning.isEmpty()){
                clsPopulateFunctions.showNotice(warning,"warning",_doctorView);
            }
            else{
                //all datas valid -> update data into table
                Vector datasUpdate = new Vector();
                Vector columnsUpdate = new Vector();
                Vector typesColumnUpdate = new Vector();

                //add first name
                datasUpdate.add(firstNameEdit);
                columnsUpdate.add("first_name");
                typesColumnUpdate.add("string");
                //add last name
                datasUpdate.add(lastNameEdit);
                columnsUpdate.add("last_name");
                typesColumnUpdate.add("string");
                //add email
                datasUpdate.add(email);
                columnsUpdate.add("email");
                typesColumnUpdate.add("string");
                //add address
                datasUpdate.add(address);
                columnsUpdate.add("add_ress");
                typesColumnUpdate.add("string");
                //add phone
                datasUpdate.add(phone);
                columnsUpdate.add("phone_number");
                typesColumnUpdate.add("string");
                //add birthday
                String temp = birthdaySplit[1];
                birthdaySplit[1] = birthdaySplit[0];
                birthdaySplit[0] = temp;
                birthday = clsPopulateFunctions.joinArray(birthdaySplit, "/");
                datasUpdate.add(birthday);
                columnsUpdate.add("birthday");
                typesColumnUpdate.add("date");
                //add experience
                datasUpdate.add(exp);
                columnsUpdate.add("experience");
                typesColumnUpdate.add("numeric");
                //add sex
                datasUpdate.add(sexEdit);
                columnsUpdate.add("sex");
                typesColumnUpdate.add("string");
                //add city
                datasUpdate.add(cityEdit);
                columnsUpdate.add("city_id");
                typesColumnUpdate.add("numeric");
                //add professional
                datasUpdate.add(professionalEdit);
                columnsUpdate.add("professional_id");
                typesColumnUpdate.add("numeric");
                //add specilaziation
                datasUpdate.add(specializationEdit);
                columnsUpdate.add("qualification_id");
                typesColumnUpdate.add("numeric");

                //add doctor
                if(action.equalsIgnoreCase("add")){
                    result = this._doctorModel.updateDataDoctor(datasUpdate, columnsUpdate, typesColumnUpdate, action, "");
                }
                //edit doctor
                else if(action.equalsIgnoreCase("edit")){
                    result = this._doctorModel.updateDataDoctor(datasUpdate, columnsUpdate, typesColumnUpdate, action, this._idDoctorView);
                }
                if(result){
                    clsPopulateFunctions.showNotice("Update doctor success","notice",_doctorView);
                    this._loadDataOnView();
                }
                else{
                    clsPopulateFunctions.showNotice("Update doctor fail","warning",_doctorView);
                }
            }
        }
        else{
            //show warning
            clsPopulateFunctions.showNotice(validate,"warning",_doctorView);
        }
        /* end validate data update */
    }

    private void _processDataAddSchedule(){
        String fromDate = this._doctorView.getFromDateAdd();
        String toDate = this._doctorView.getToDateAdd();
        String[] temp = new String[3];
        temp = fromDate.split("/");
        fromDate = temp[1] + "/" + temp[0] + "/" + temp[2];
        temp = toDate.split("/");
        toDate = temp[1] + "/" + temp[0] + "/" + temp[2];

        //validate from date and to date
        boolean validData = true;
        if(validData & clsDateTime.compareDate(fromDate, toDate) > 0){
            clsPopulateFunctions.showNotice("From date must less than or equal to date", "warning", _doctorView);
            validData = false;
        }
        //check valid time span
        if(validData){
            if(_doctorModel.checkTimeSpanValid(_idDoctorView, fromDate, toDate)){
                if(_doctorModel.addschedule(_idDoctorView, fromDate, toDate)){
                    clsPopulateFunctions.showNotice("Add schedule success","notice",_doctorView);
                    _loadDataScheduleOnView();
                }
                else{
                    clsPopulateFunctions.showNotice("Add schedule fail","warning",_doctorView);
                }
            }
            else{
                clsPopulateFunctions.showNotice("Time range is invalid", "warning", _doctorView);
            }
        }
    }

    private boolean _checkPermission(String functionCheck){
        return this._doctorModel.checkAccessValid(this.userLogged, functionCheck);
    }

    private void _showHome(){
        this.vHome.setEnabled(true);
    }

    /*all classes action on view doctor*/

    /*
     * class define action on list countr search
     */
    class ActionListCountrySearch implements ItemListener{

        public void itemStateChanged(ItemEvent e) {
            String countrySelected = e.getItem().toString();
            //get country id
            int countryId = _getCountryIdFromName(countrySelected);
            _citiesSearch.removeAllElements();
            if(countryId > -1){
                Vector conditions = new Vector();
                conditions.add(String.format("country_id = %d", countryId));
                _citiesSearch = _doctorModel.getListCities(conditions);
            }
            _doctorView.setCitySearch(_citiesSearch);
        }

    }

    /*
     * class define action on list countr search
     */
    class ActionListCountryEdit implements ItemListener{

        public void itemStateChanged(ItemEvent e) {
            String countrySelected = e.getItem().toString();
            //get country id
            int countryId = _getCountryIdFromName(countrySelected);
            _citiesEdit.removeAllElements();
            if(countryId > -1){
                Vector conditions = new Vector();
                conditions.add(String.format("country_id = %d", countryId));
                _citiesEdit = _doctorModel.getListCities(conditions);
            }
            _doctorView.setCityEdit(_citiesEdit);
        }

    }

    /*
     * class define action on button Search
     */
    class ActionOnButtonSearch implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //check access valid
            if(_checkPermission("Search")){
                String valueSearch = _doctorView.getValueSearch();
                String countrySearch = _doctorView.getCountrySearch();
                int countryId = _getCountryIdFromName(countrySearch);
                String citySearch = _doctorView.getCitySearch();
                int cityId = _getCitySearchIdFromName(citySearch);
                String expOperation = _doctorView.getOperationExpSearch();
                String operation = _getOperationCharFromName(expOperation);
                String expSearch = _doctorView.getExpValueSearch();
                String specializationSearch = _doctorView.getSpecializationSearch();
                int specializationId = _getSpecializationIdFromName(specializationSearch);

                String[] datas = new String[2];
                boolean[] required = new boolean[2];
                String[] regex = new String[2];
                String[] alerts = new String[2];

                //validate value search?
                if(!valueSearch.isEmpty()){
                    datas[0] = valueSearch;
                    required[0] = true;
                    regex[0] = "";
                    alerts[0] = "Value search is invalid";
                }
                else{
                    required[0] = false;
                }

                //validate exp search?
                if(!expSearch.isEmpty() | !operation.isEmpty()){
                    datas[1] = expSearch;
                    required[1] = true;
                    regex[1] = "^[0-9]+$";
                    alerts[1] = "Experience search is invalid";
                }
                else{
                    required[1] = false;
                }

                String validate = clsValidator.makeValidate(datas, required, regex, alerts);

                //enter valid data
                if(validate.isEmpty()){
                    //has exp search but don't choose exp operation
                    if(!expSearch.isEmpty() & operation.isEmpty()){
                        //show warning
                        clsPopulateFunctions.showNotice("Please choose experience operation search","warning",_doctorView);
                    }
                    else{
                        //begin search
                        Vector conditions = new Vector();
                        if(!valueSearch.isEmpty()){
                            conditions.add("(first_name LIKE '%" + valueSearch + "%' OR last_name LIKE '%" + valueSearch + "%' OR add_ress LIKE '%" + valueSearch + "%' OR email LIKE '%" + valueSearch + "%')");
                        }
                        if(!expSearch.isEmpty()){
                            conditions.add(String.format("experience %s %d", operation, Integer.parseInt(expSearch)));
                        }
                        if(countryId > -1){
                            conditions.add(String.format("city.country_id = %d", countryId));
                        }
                        if(cityId > -1){
                            conditions.add(String.format("city.city_id = %d", cityId));
                        }
                        if(specializationId > -1){
                            conditions.add(String.format("qualification.qualification_id = %d", specializationId));
                        }

                        _doctors = _doctorModel.getListDoctorsRenderTable(conditions);

                        _doctorView.setDataTableListDoctor(_doctors);
                        _doctorView.setDataTableHistoryVisiting(null);

                        _idDoctorView = "";
                        _idHistoryView = "";
                        _doctorView.setStatusEditDoctorButton(false);
                        _doctorView.setStatusDeleteDoctorButton(false);
                        _doctorView.setStatusViewArchivementButton(false);
                        _doctorView.setStatusAddScheduleButton(false);
                        _doctorView.setStatusDeleteScheduleButton(false);

                        _resetDataFormEdit();
                        _resetDataFormAddSchedule();
                    }
                }
                else{
                    //show warning
                    clsPopulateFunctions.showNotice(validate,"warning",_doctorView);
                }
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied","warning",_doctorView);
            }
        }

    }

    /*
     * class define action on button Cancel
     */
    class ActionOnButtonShowAll implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            _loadDataOnView();
        }

    }

    class MouseListenerForTableListDoctor implements MouseInputListener{

        public void mouseClicked(MouseEvent e) {
            _processRowsSelectedOnTableDoctors();
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {
            _processRowsSelectedOnTableDoctors();
        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }

    }

    class KeyListenerForTableListDoctor implements KeyListener{

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {
            _processRowsSelectedOnTableDoctors();
        }

    }

    class MouseListenerForTableHistoryVisiting implements MouseInputListener{

        public void mouseClicked(MouseEvent e) {
            _processRowsSelectedOnTableHistoryVisiting();
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {
            _processRowsSelectedOnTableHistoryVisiting();
        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }

    }

    class KeyListenerForTableHistoryVisiting implements KeyListener{

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {
            _processRowsSelectedOnTableHistoryVisiting();
        }

    }

    class ActionOnButtonAddDoctor implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //check access valid
            if(_checkPermission("Manage Doctor")){
                _isAdding = true;
                String label = _doctorView.getLabelAddDoctorButton();
                //step 1 : click on button add doctor to begin process add
                if(label.equalsIgnoreCase("add doctor")){
                    //reset form add/edit doctor
                    _resetDataFormEdit();
                    //change label of button add and edit doctor
                    _doctorView.setLabelAddDoctorButton("Ok");
                    _doctorView.setLabelEditDoctorButton("Cancel");
                    //change status of button
                    _doctorView.setStatusEditDoctorButton(true);
                    _doctorView.setStatusAddScheduleButton(false);
                    _doctorView.setStatusDeleteScheduleButton(false);
                    _doctorView.setStatusDeleteDoctorButton(false);
                    _doctorView.setStatusViewArchivementButton(false);
                    _doctorView.setStatusSearchButton(false);
                    _doctorView.setStatusShowAllButton(false);
                    //disable table list doctor and history visiting
                    _doctorView.setStatusTableListDoctor(false);
                    _doctorView.setStatusTableHistoryVisiting(false);
                }
                //step 2 : process add
                else{
                    _processFormUpdateDoctor("add");
                }
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied","warning",_doctorView);
            }
        }

    }

    class ActionOnButtonEditDoctor implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //check access valid
            if(_checkPermission("Manage Doctor")){
                String label = _doctorView.getLabelEditDoctorButton();
                //button edit doctor is using to process add doctor
                if(!label.equalsIgnoreCase("Edit Doctor")){
                    _loadDataOnView();
                }
                //normal -> process edit doctor
                else{
                    _processFormUpdateDoctor("edit");
                }
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied","warning",_doctorView);
            }
        }

    }

    class ActionOnButtonDeleteDoctor implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(_checkPermission("Manage Doctor")){
                if(!_idDoctorView.isEmpty()){
                    int isAllow = JOptionPane.showConfirmDialog(_doctorView, "Do you want delete doctors selected. WARNING: all datas of doctor will be deleted if you choose OK", "Confirm from user", JOptionPane.OK_CANCEL_OPTION);
                    //user accept delete -> perform delete function with doctors that marked
                    if(isAllow == JOptionPane.OK_OPTION){
                        Vector conditions = new Vector();
                        conditions.add("doctor_id IN (" + _idDoctorView + ")");
                        if(_doctorModel.deleteDoctor(conditions)){
                            clsPopulateFunctions.showNotice("Delete doctors success", "notice", _doctorView);
                            _loadDataOnView();
                        }
                        else{
                            clsPopulateFunctions.showNotice("Delete doctors fail", "warning", _doctorView);
                        }
                    }
                }
                else{
                    clsPopulateFunctions.showNotice("You must choose at least one doctor to delete", "warning", _doctorView);
                }
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied","warning",_doctorView);
            }
        }

    }

    class ActionOnButtonAddSchedule implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //check access valid
            if(_checkPermission("Manage Doctor")){
                _isAddingSchedule = true;
                _isAdding = true;
                String label = _doctorView.getLabelAddScheduleButton();
                //step 1 : click on button add doctor to begin process add
                if(label.equalsIgnoreCase("add schedule")){
                    //reset form add/edit doctor
                    _resetDataFormAddSchedule();
                    //change label of button add and delete schedule
                    _doctorView.setLabelAddScheduleButton("Ok");
                    _doctorView.setLabelDeleteScheduleButton("Cancel");
                    //change status of button
                    _doctorView.setStatusAddScheduleButton(true);
                    _doctorView.setStatusDeleteScheduleButton(true);
                    _doctorView.setStatusAddDoctorButton(false);
                    _doctorView.setStatusEditDoctorButton(false);
                    _doctorView.setStatusDeleteDoctorButton(false);
                    _doctorView.setStatusViewArchivementButton(false);
                    _doctorView.setStatusSearchButton(false);
                    _doctorView.setStatusShowAllButton(false);
                    //disable table list doctor and history visiting
                    _doctorView.setStatusTableHistoryVisiting(false);
                    _doctorView.setStatusTableListDoctor(false);
                }
                //step 2 : process add
                else{
                    _processDataAddSchedule();
                }
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied","warning",_doctorView);
            }
        }

    }

    class ActionOnButtonDeleteSchedule implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(_checkPermission("Manage Doctor")){
                String label = _doctorView.getLabelDeleteScheduleButton();
                //button edit doctor is using to process add doctor
                if(!label.equalsIgnoreCase("delete schedule")){
                    _loadDataScheduleOnView();
                }
                else if(!_idHistoryView.isEmpty())
                {
                    int isAllow = JOptionPane.showConfirmDialog(_doctorView, "Do you want delete history visiting selected. WARNING: all datas of history visiting will be deleted if you choose OK", "Confirm from user", JOptionPane.OK_CANCEL_OPTION);
                    //user accept delete -> perform delete function with doctors that marked
                    if(isAllow == JOptionPane.OK_OPTION){
                        Vector conditions = new Vector();
                        conditions.add("history_id IN (" + _idHistoryView + ")");
                        if(_doctorModel.deleteDoctor(conditions)){
                            clsPopulateFunctions.showNotice("Delete history visiting success", "notice", _doctorView);
                            _loadDataScheduleOnView();
                        }
                        else{
                            clsPopulateFunctions.showNotice("Delete history visiting fail", "warning", _doctorView);
                        }
                    }
                }
                else{
                    clsPopulateFunctions.showNotice("You must choose at least one history visiting to delete", "warning", _doctorView);
                }
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied","warning",_doctorView);
            }
        }

    }

    class ActionOnButtonClose implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(_checkPermission("Manage Doctor") | _checkPermission("Search")){
                _showHome();
                _doctorView.setVisible(false);
            }
            else{
                clsPopulateFunctions.showNotice("Access Denied", "warning", null);
                System.exit(0);
            }
        }

    }

    /*end actions on view login*/

    /*
     * this function only used to test controller
     */
    public static void main(String[] args){
        DoctorController doctorController = new DoctorController("admin");
    }
}
