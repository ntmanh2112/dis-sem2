/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

//import model
import Views.AchivementView;
import Views.ProfessionalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import models.HomeModel;
//import view
import views.*;

/**
 *
 * @author congnguyentan
 */
public class HomeController extends ParentController {
    HomeModel mHome;

    JMenuBar topMenu;
    JMenu[] menu;
    JMenuItem[][] menuItem;
    //build parent menu on top menu
    String[] parentMenuTitle = new String[4];
    String[][] childMenuElement = new String[4][10];
    String[] parentMenuMemonic = new String[4];


    /*
     * constructor
     */
    public HomeController(){
        //init model and view
        mHome = new HomeModel();
        vHome = new HomeView();
        

        //assign title of parent menu
        parentMenuTitle[0] = "System";
        parentMenuTitle[1] = "General Manage";
        parentMenuTitle[2] = "Doctor Manage";
        parentMenuTitle[3] = "User Manage";
        //asign title of each child menu
        childMenuElement[0][0] = "Change Pass";
        childMenuElement[0][1] = "Logout";
        childMenuElement[1][0] = "Manage Achievement";
        childMenuElement[1][1] = "Manage City";
        childMenuElement[1][2] = "Manage Country";
        childMenuElement[1][3] = "Manage Professional";
        childMenuElement[1][4] = "Manage Qualification";
        childMenuElement[2][0] = "Manage Doctor";
        childMenuElement[2][1] = "Search History Visiting";
        childMenuElement[3][0] = "Manage User";
        //assign memonic key of parent menu
        parentMenuMemonic[0] = "S";
        parentMenuMemonic[1] = "G";
        parentMenuMemonic[2] = "D";
        parentMenuMemonic[3] = "U";

        topMenu = new JMenuBar();
        menu = new JMenu[4];
        menuItem = new JMenuItem[4][10];

        //call function init view
        this._initView();
    }

    /*
     * build menu of home corresponding to user logged
     *
     * @param: String userLogged -> uID of user logged
     * @return: true if build success, false if fail
     */
    private boolean _buildMenu(String userLogged){
        boolean buildResult = false;
        try{
            /*
             * steps on process menu
             *
             * step 1 : get all functions that had been allowed access by user logged
             * step 2 : if not found any functions then hide parent menu
             * step 3 : if found functions then assign functions into parent menu and show parent menu on top menu
             */
            for(int i=0; i<this.parentMenuTitle.length; i++){
                String parentTitle = this.parentMenuTitle[i];
                boolean found = false;
                boolean buildMenuNoNeedCheck = false;
                if(i == 0){
                    buildMenuNoNeedCheck = true;
                }

                for(int j = 0; j < this.childMenuElement[i].length; j++){
                    boolean checkMenuValid = buildMenuNoNeedCheck;
                    String childTitle = this.childMenuElement[i][j];
                    if(childTitle != null){
                        if(!checkMenuValid){
                            ResultSet functions = mHome.getMenuByName(userLogged, childTitle);
                            while(functions.next()){
                                int total = functions.getInt("total");
                                if(total > 0){
                                    checkMenuValid = true;
                                }
                                else if(childTitle.equalsIgnoreCase("manage doctor")){
                                    functions = mHome.getMenuByName(userLogged, "Search");
                                    while(functions.next()){
                                        total = functions.getInt("total");
                                        if(total > 0){
                                            checkMenuValid = true;
                                        }
                                    }
                                }
                            }
                        }

                        if(checkMenuValid){
                            found = true;
                            if(j == 0){
                                this.menu[i] = new JMenu(parentTitle);
                            }
                            this.menuItem[i][j] = new JMenuItem(childTitle);
                            //set memonic for child menu
                            int countSpacebar = this._countSpacebarInString(childTitle);
                            String[] temp = new String[countSpacebar+1];
                            temp = childTitle.split(" ");
                            String lastWord = temp[countSpacebar];
                            Character memonicChildMenu = lastWord.charAt(0);
                            this.menuItem[i][j].setMnemonic(memonicChildMenu);
                            //assign child menu into parent menu
                            this.menu[i].add(this.menuItem[i][j]);
                            //set memonic for parent menu
                            this.menu[i].setMnemonic(this.parentMenuMemonic[i].charAt(0));
                            //add event for menu item
                            this._loadActionForMenus(this.menuItem[i][j]);
                        }
                    }
                    else{
                        break;
                    }
                }
                //fount functions -> show parent menu on top menu
                if(found){
                    this.topMenu.add(this.menu[i]);
                    buildResult = true;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return buildResult;
    }

    /*
     * function used to init view home
     */
    private void _initView(){
        //first : build top menu, if build success then set top menu on view
        //second : add action for child item on top menu
        if(this._buildMenu(this.userLogged)){
            vHome.setJMenuBar(this.topMenu);
        }
        //final : show view
        vHome.setLocationRelativeTo(null);
        vHome.setVisible(true);
    }

    /*
     * function used to add action for child menu
     */


    private int _countSpacebarInString(String stringCount){
        String separator = " ";
        int counter = 0;

        for (int i = 0; i < stringCount.length(); i++) {
            Character element = stringCount.charAt(i);
            if (element.toString().equalsIgnoreCase(separator)){
                counter++;
            }
        }

        return counter;
    }
    
    private void _loadActionForMenus(JMenuItem menuItem){
        //action on menu logout
        if(menuItem.getLabel().equalsIgnoreCase("logout")){
            menuItem.addActionListener(new actionOnMenuLogout());
        }
        //action on menu change pass
        else if(menuItem.getLabel().equalsIgnoreCase("change pass")){
            menuItem.addActionListener(new actionOnMenuChangePass());
        }
        //action on menu manage Achievement
        else if(menuItem.getLabel().equalsIgnoreCase("manage achievement")){
            menuItem.addActionListener(new actionOnMenuManageAchievement());
        }
        //action on menu Manage City
        else if(menuItem.getLabel().equalsIgnoreCase("manage city")){
            menuItem.addActionListener(new actionOnMenuManageCity());
        }
        //action on menu Manage Country
        else if(menuItem.getLabel().equalsIgnoreCase("manage country")){
            menuItem.addActionListener(new actionOnMenuManageCountry());
        }
        //action on menu Manage Professional
        else if(menuItem.getLabel().equalsIgnoreCase("manage professional")){
            menuItem.addActionListener(new actionOnMenuManageProfessional());
        }
        //action on menu Manage Qualification
        else if(menuItem.getLabel().equalsIgnoreCase("manage qualification")){
            menuItem.addActionListener(new actionOnMenuManageQualification());
        }
        //action on menu Manage Doctor
        else if(menuItem.getLabel().equalsIgnoreCase("manage doctor")){
            menuItem.addActionListener(new actionOnMenuManageDoctor());
        }
        //action on menu Manage User
        else if(menuItem.getLabel().equalsIgnoreCase("manage user")){
            menuItem.addActionListener(new actionOnMenuManageUser());
        }
        //action on menu Search History Visiting
        else if(menuItem.getLabel().equalsIgnoreCase("search history visiting")){
            menuItem.addActionListener(new actionOnMenuManageHistoryVisiting());
        }
    }

    /*classes actions for menus*/

    class actionOnMenuLogout implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //reset data on view login
            vLogin.setUsername("");
            vLogin.setPassword("");
            //clear infor of user logged
            userLogged = "";
            //hide view home
            vHome.setVisible(false);
            //show view login
            vLogin.setVisible(true);
        }

    }

    class actionOnMenuChangePass implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
        }

    }

    class actionOnMenuManageAchievement implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
            vHome.setEnabled(false);
            AchivementView vQualification = new AchivementView(vHome);
        }

    }

    class actionOnMenuManageCity implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
        }

    }

    class actionOnMenuManageCountry implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
            vHome.setEnabled(false);
            CoutryView vCountry = new CoutryView(vHome);
        }

    }

    class actionOnMenuManageQualification implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
            vHome.setEnabled(false);
            QualificationView vQualification = new QualificationView(vHome);
        }

    }

    class actionOnMenuManageProfessional implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
            vHome.setEnabled(false);
            ProfessionalView vCountry = new ProfessionalView(vHome);
        }

    }

    class actionOnMenuManageDoctor implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
            //hide view home
            vHome.setEnabled(false);
            //show view login
            DoctorController docController = new DoctorController();
        }

    }

    class actionOnMenuManageUser implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
        }

    }

    class actionOnMenuManageHistoryVisiting implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //do action here
        }

    }

    /*end classes*/
}
