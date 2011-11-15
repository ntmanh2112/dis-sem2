/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DoctorView.java
 *
 * Created on Nov 15, 2011, 10:18:28 AM
 */

package views;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author congnguyentan
 */
public class DoctorView extends javax.swing.JFrame {
    Vector columnsListDoctor;
    Vector columnsHistoryVisiting;
    Vector listOperation;

    /** Creates new form DoctorView */
    public DoctorView() {
        initComponents();

        columnsListDoctor = new Vector();
        columnsListDoctor.add("Order");
        columnsListDoctor.add("First Name");
        columnsListDoctor.add("Last Name");
        columnsListDoctor.add("Address");
        columnsListDoctor.add("Phone");
        columnsListDoctor.add("Birthday");
        columnsListDoctor.add("Sex");
        columnsListDoctor.add("City");
        columnsListDoctor.add("Qualification");
        columnsListDoctor.add("Professional");
        columnsListDoctor.add("doctor_id");

        listOperation = new Vector();
        listOperation.add("greater than");
        listOperation.add("greater than or equal");
        listOperation.add("equal");
        listOperation.add("not equal");
        listOperation.add("less than or equal");
        listOperation.add("less than");

        columnsHistoryVisiting = new Vector();
        columnsHistoryVisiting.add("Order");
        columnsHistoryVisiting.add("From Date");
        columnsHistoryVisiting.add("To Date");
    }

    private void _initTableListDoctor(Vector vData){
        this.tblListDoctors.setModel(new DefaultTableModel(vData, this.columnsListDoctor){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class, java.lang.String.class,
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false,false,false, false, false, false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this._repainTableListDoctor();
        this.tblListDoctors.setFillsViewportHeight(true);
    }

    private int[] _getRowsSelectedOnTableListDoctor(){
        int[] row = this.tblListDoctors.getSelectedRows();
        return row;
    }

    private void _removeAllValuesOnTableListDoctor(){
        Vector nullValue = null;
        this._initTableListDoctor(nullValue);
    }

    private void _repainTableListDoctor(){
        for(int j=0;j<this.tblListDoctors.getColumnCount();j++){
            int preferedWidth = 0;
            int minWidth = 0;
            int maxWidth = 0;
            //order column
            if(j==0){
                preferedWidth = minWidth = maxWidth = 50;
            }
            //first name column
            else if(j==1){
                preferedWidth = minWidth = maxWidth = 75;
            }
            //last name column
            else if(j==2){
                preferedWidth = minWidth = maxWidth = 110;
            }
            //address column
            else if(j==3){
                preferedWidth = minWidth = maxWidth = 150;
            }
            //phone column
            else if(j==4){
                preferedWidth = minWidth = maxWidth = 90;
            }
            //birthday column
            else if(j==5){
                preferedWidth = minWidth = maxWidth = 70;
            }
            //sex column
            else if(j==6){
                preferedWidth = minWidth = maxWidth = 50;
            }
            //city column
            else if(j==7){
                preferedWidth = minWidth = maxWidth = 98;
            }
            //qualification column
            else if(j==8){
                preferedWidth = minWidth = maxWidth = 109;
            }
            //professional column
            else if(j==9){
                preferedWidth = minWidth = maxWidth = 145;
            }
            //doctor id column
            else{
                preferedWidth = minWidth = maxWidth = 0;
            }
            //set width of column
            this.tblListDoctors.getColumnModel().getColumn(j).setPreferredWidth(preferedWidth);
            this.tblListDoctors.getColumnModel().getColumn(j).setMinWidth(minWidth);
            this.tblListDoctors.getColumnModel().getColumn(j).setMaxWidth(maxWidth);
            //align content of column is center
        }
    }

    public void setDataTableListDoctor(Vector vData){
        this._initTableListDoctor(vData);
    }

    private void _initTableHistoryVisiting(Vector vData){
        this.tblHistoryVisiting.setModel(new DefaultTableModel(vData, this.columnsHistoryVisiting){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this._repainTableHistoryVisiting();
        this.tblHistoryVisiting.setFillsViewportHeight(true);
    }

    private int[] _getRowsSelectedOnTableHistoryVisiting(){
        int[] row = this.tblHistoryVisiting.getSelectedRows();
        return row;
    }

    private void _removeAllValuesOnTableHistoryVisiting(){
        Vector nullValue = null;
        this._initTableListDoctor(nullValue);
    }

    private void _repainTableHistoryVisiting(){
        for(int j=0;j<this.tblHistoryVisiting.getColumnCount();j++){
            int preferedWidth = 0;
            int minWidth = 0;
            int maxWidth = 0;
            //order column
            if(j==0){
                preferedWidth = minWidth = maxWidth = 50;
            }
            //from date column
            else if(j==1){
                preferedWidth = minWidth = maxWidth = 120;
            }
            //to date column
            else if(j==2){
                preferedWidth = minWidth = maxWidth = 120;
            }
            //history id column
            else{
                preferedWidth = minWidth = maxWidth = 0;
            }
            //set width of column
            this.tblHistoryVisiting.getColumnModel().getColumn(j).setPreferredWidth(preferedWidth);
            this.tblHistoryVisiting.getColumnModel().getColumn(j).setMinWidth(minWidth);
            this.tblHistoryVisiting.getColumnModel().getColumn(j).setMaxWidth(maxWidth);
            //align content of column is center
        }
    }

    public void setDataTableHistoryVisiting(Vector vData){
        this._initTableHistoryVisiting(vData);
    }

    public void setOperationExp(){
        this.cboOperation.removeAllItems();
        this.cboOperation.addItem("--Operation--");
        for(int i = 0;i<this.listOperation.size();i++){
            String label = this.listOperation.get(i).toString();
            this.cboOperation.addItem(label);
        }
    }

    public String getOperationExp(){
        return this.cboOperation.getSelectedItem().toString();
    }

    public void setCountry(Vector countries){
        this.cboCountry.removeAllItems();
        this.cboCountry.addItem("--Select Country--");
        for(int i = 0;i<countries.size();i++){
            Vector element = (Vector) countries.get(i);
            String label = element.get(1).toString();
            this.cboCountry.addItem(label);
        }
    }

    public String getCountry(){
        return this.cboCountry.getSelectedItem().toString();
    }

    public void setCity(Vector cities){
        this.cboCity.removeAllItems();
        this.cboCity.addItem("--Select City--");
        for(int i = 0;i<cities.size();i++){
            Vector element = (Vector) cities.get(i);
            String label = element.get(1).toString();
            this.cboCity.addItem(label);
        }
    }

    public String getCity(){
        return this.cboCity.getSelectedItem().toString();
    }

    public void setSpecialization(Vector specialization){
        this.cboSpecialization.removeAllItems();
        this.cboSpecialization.addItem("--Select Specialization--");
        for(int i = 0;i<specialization.size();i++){
            Vector element = (Vector) specialization.get(i);
            String label = element.get(1).toString();
            this.cboSpecialization.addItem(label);
        }
    }

    public String getSpecialization(){
        return this.cboSpecialization.getSelectedItem().toString();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValueSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboCountry = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cboOperation = new javax.swing.JComboBox();
        txtExperience = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboCity = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboSpecialization = new javax.swing.JComboBox();
        cmdSearch = new javax.swing.JButton();
        cmdShowAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListDoctors = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistoryVisiting = new javax.swing.JTable();
        cmdAddDoctor = new javax.swing.JButton();
        cmdEditDoctor = new javax.swing.JButton();
        cmdDeleteDoctor = new javax.swing.JButton();
        cmdAddVisiting = new javax.swing.JButton();
        cmdDeleteVisiting = new javax.swing.JButton();
        cmdViewAchievement = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFirstNameEdit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLastNameEdit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmailEdit = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboSexEdit = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        spinnerBirthdayEdit = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        txtPhoneEdit = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboCountryEdit = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        cmdClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Doctor");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/top-banner.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("List of Doctors");

        jLabel3.setText("Value Search:");

        jLabel4.setText("Country:");

        jLabel5.setText("Experience:");

        jLabel6.setText("City:");

        jLabel7.setText("Specialization:");

        cmdSearch.setText("Search");

        cmdShowAll.setText("Show All");

        tblListDoctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListDoctors.setFillsViewportHeight(true);
        tblListDoctors.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblListDoctors.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblListDoctors);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("History Visiting");

        tblHistoryVisiting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblHistoryVisiting.setFillsViewportHeight(true);
        tblHistoryVisiting.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblHistoryVisiting.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblHistoryVisiting);

        cmdAddDoctor.setText("Add Doctor");

        cmdEditDoctor.setText("Edit Doctor");

        cmdDeleteDoctor.setText("Delete Doctor");

        cmdAddVisiting.setText("Add Visiting Schedule");

        cmdDeleteVisiting.setText("Delete Visiting Schedule");

        cmdViewAchievement.setText("View Achievement");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Add/Edit Doctor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel9.setText("First Name:");

        jLabel10.setText("Last Name:");

        jLabel11.setText("Email:");

        jLabel12.setText("Sex:");

        cboSexEdit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabel13.setText("Birthday:");

        spinnerBirthdayEdit.setModel(new javax.swing.SpinnerDateModel());
        spinnerBirthdayEdit.setEditor(new javax.swing.JSpinner.DateEditor(spinnerBirthdayEdit, "dd/MM/yyyy"));

        jLabel14.setText("Phone:");

        jLabel15.setText("Experience:");

        jLabel16.setText("Country:");

        jLabel17.setText("City:");

        jLabel18.setText("Professional:");

        jLabel19.setText("Specialization:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCountryEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerBirthdayEdit)
                    .addComponent(txtFirstNameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhoneEdit)
                            .addComponent(txtLastNameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFirstNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtLastNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmailEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cboSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerBirthdayEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txtPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboCountryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdClose.setText("Close Form");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Add Visiting Schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel20.setText("From Date:");

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "dd/MM/yyyy"));

        jLabel21.setText("To Date:");

        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner2, "dd/MM/yyyy"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAddDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdEditDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDeleteDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdViewAchievement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdAddVisiting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDeleteVisiting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValueSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboCity, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdShowAll))))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValueSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExperience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSearch)
                    .addComponent(cmdShowAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAddDoctor)
                    .addComponent(cmdEditDoctor)
                    .addComponent(cmdDeleteDoctor)
                    .addComponent(cmdViewAchievement)
                    .addComponent(cmdAddVisiting)
                    .addComponent(cmdDeleteVisiting)
                    .addComponent(cmdClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCity;
    private javax.swing.JComboBox cboCountry;
    private javax.swing.JComboBox cboCountryEdit;
    private javax.swing.JComboBox cboOperation;
    private javax.swing.JComboBox cboSexEdit;
    private javax.swing.JComboBox cboSpecialization;
    private javax.swing.JButton cmdAddDoctor;
    private javax.swing.JButton cmdAddVisiting;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDeleteDoctor;
    private javax.swing.JButton cmdDeleteVisiting;
    private javax.swing.JButton cmdEditDoctor;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JButton cmdShowAll;
    private javax.swing.JButton cmdViewAchievement;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spinnerBirthdayEdit;
    private javax.swing.JTable tblHistoryVisiting;
    private javax.swing.JTable tblListDoctors;
    private javax.swing.JTextField txtEmailEdit;
    private javax.swing.JTextField txtExperience;
    private javax.swing.JTextField txtFirstNameEdit;
    private javax.swing.JTextField txtLastNameEdit;
    private javax.swing.JTextField txtPhoneEdit;
    private javax.swing.JTextField txtValueSearch;
    // End of variables declaration//GEN-END:variables

}
