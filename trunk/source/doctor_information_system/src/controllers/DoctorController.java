/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.util.Vector;
import models.DoctorModel;
import views.DoctorView;
import views.HomeView;
import libs.*;

/**
 *
 * @author congnguyentan
 */
public class DoctorController extends ParentController {
    private DoctorModel _doctorModel;
    private DoctorView _doctorView;

    private Vector _doctors;
    private Vector _countries;
    private Vector _cities;
    private Vector _professional;

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
        this._doctorView = new DoctorView();
        this._doctors = new Vector();
        //there is place to enter information connect to database. Note: this block only used to test controller
        this._doctorModel.setDatabaseName("doctor_information_system");
        this._doctorModel.setUser("sa");
        this._doctorModel.setPassword("dinhtoiyeuem");
        //end
        //check access valid
        if(this._doctorModel.checkAccessValid(this.userLogged, "Manage Doctor")){
            //load data on view
            this._loadDataOnView();
            //load action on view
            //this._loadActionOnView();
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
        //this._cities = this._doctorModel.getListCities(null);
        //get professional
        this._professional = this._doctorModel.getListSpecializations();
        //get doctors
        this._doctors = this._doctorModel.getListDoctorsRenderTable(null);
        //set datas on table
        this._doctorView.setDataTableListDoctor(this._doctors);
        this._doctorView.setDataTableHistoryVisiting(null);
        this._doctorView.setSpecialization(this._professional);
        this._doctorView.setCountry(this._countries);
        this._doctorView.setOperationExp();
        //reset data on form edit and form search
        //this._resetDataEditOnView();
        //this._resetDataSearchOnView();
        //reset ids of rows selected
        //this._idsDelete = "";
    }

    /*
     * this function only used to test controller
     */
    public static void main(String[] args){
        DoctorController doctorController = new DoctorController("admin");
    }
}
