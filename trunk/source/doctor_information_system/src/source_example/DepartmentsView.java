/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DepartmentsView.java
 *
 * Created on 19-01-2011, 15:17:02
 */

package views;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinhbien
 */
public class DepartmentsView extends javax.swing.JFrame {
Vector columnsName;
    public DepartmentsView() {
        initComponents();
        columnsName = new Vector();
        columnsName.add("Order");
        columnsName.add("Departments Name");
        columnsName.add("Leader");
        columnsName.add("Status");
        columnsName.add("ID");
        columnsName.add("LeaderID");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmdSearch = new javax.swing.JButton();
        cmdShowall = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContent = new javax.swing.JTable();
        cmdAdd = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdRestore = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        cmdEdit = new javax.swing.JButton();
        cboEmployee = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manage Department");

        jLabel1.setText("Department Search:");

        txtSearch.setToolTipText("Only accept alphabet chars, numeric chars and spacebar char");

        cmdSearch.setText("Search");

        cmdShowall.setText("Show All");

        tblContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblContent.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblContent);

        cmdAdd.setText("Add");

        cmdDelete.setText("Delete");

        cmdRestore.setText("Restore");

        cmdClose.setText("Close");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel2.setText("Id");

        jLabel3.setText("Name");

        jLabel4.setText("Leader");

        txtId.setEnabled(false);

        txtName.setToolTipText("Only accept alphabet chars, numeric chars and spacebar char");

        cmdEdit.setText("Update");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addGap(384, 384, 384))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(cmdEdit)
                .addGap(300, 300, 300))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(cmdEdit))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdAdd)
                        .addGap(37, 37, 37)
                        .addComponent(cmdDelete)
                        .addGap(41, 41, 41)
                        .addComponent(cmdRestore)
                        .addGap(41, 41, 41)
                        .addComponent(cmdClose))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdShowall))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSearch)
                    .addComponent(cmdShowall)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAdd)
                    .addComponent(cmdDelete)
                    .addComponent(cmdRestore)
                    .addComponent(cmdClose))
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEmployee;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdRestore;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JButton cmdShowall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContent;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
public String getSearch(){
        return this.txtSearch.getText().trim();
    }
public void setSearch(String value){
        this.txtSearch.setText(value);
    }
public String getId(){
        return this.txtId.getText().trim();
}
public void setId(String id){
        this.txtId.setText(id);
    }
 public String getName(){
        return this.txtName.getText().trim();
    }
 public void setName(String name){
        this.txtName.setText(name);
    }
public void setDataTable(Vector vData){

        this._initTable(vData);

    }
public String getLeaderEdit(){
        return this.cboEmployee.getSelectedItem().toString();
}
public void setLeaderEdit(Vector leader){
    this.cboEmployee.removeAllItems();
    this.cboEmployee.addItem("--Select Employee--");
    for(int i = 0;i<leader.size();i++){
            Vector job = (Vector) leader.get(i);
            String label = job.get(1).toString();
            this.cboEmployee.addItem(label);
        }
}
public Vector getValueSelectedOnTable(){
        Vector result = new Vector();
        int[] rowSelected = this._getRowsSelectedOnTable();
        for(int i=0; i<rowSelected.length; i++){
            int id = Integer.valueOf(this.tblContent.getValueAt(rowSelected[i], 5).toString());
            String name = this.tblContent.getValueAt(rowSelected[i], 1).toString();
            String leader;
            try{
                leader = this.tblContent.getValueAt(rowSelected[i], 2).toString();
            } catch(Exception e){
                leader = "";
            }

            Vector child = new Vector();
            child.add(id);
            child.add(name);
            child.add(leader);

            result.add(child);
        }
        return result;
    }

    private void _initTable(Vector vData){
        this.tblContent.setModel(new DefaultTableModel(vData, columnsName){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this._repainTable();
        this.tblContent.setFillsViewportHeight(true);
    }

    private int[] _getRowsSelectedOnTable(){
        int[] row = this.tblContent.getSelectedRows();
        return row;
    }

    private void _removeAllValuesOnTable(){
        Vector nullValue = null;
        this._initTable(nullValue);
    }
    public void setLeader(String optionSelected){
        this.cboEmployee.setSelectedItem(optionSelected);
    }
    public void setLeaderByIndex(int optionSelected){
        this.cboEmployee.setSelectedIndex(optionSelected);
    }

    private void _repainTable(){
        for(int j=0;j<this.tblContent.getColumnCount();j++){
            int preferedWidth = 0;
            int minWidth = 0;
            int maxWidth = 0;
            if(j==0){
                preferedWidth = minWidth = maxWidth = 80;
            }
            else if(j==1){
                preferedWidth = minWidth = maxWidth = 200;
            }
            else if(j==2){
                preferedWidth = minWidth = maxWidth = 200;
            }
            else if(j==3){
                preferedWidth = minWidth = maxWidth = 200;
            }
            else{
                preferedWidth = minWidth = maxWidth = 0;
            }
            //set width of column
            this.tblContent.getColumnModel().getColumn(j).setPreferredWidth(preferedWidth);
            this.tblContent.getColumnModel().getColumn(j).setMinWidth(minWidth);
            this.tblContent.getColumnModel().getColumn(j).setMaxWidth(maxWidth);
            //align content of column is center
        }
    }

    public void setLabelButton(String button,String label){
        if(button.equalsIgnoreCase("add")){
            this.cmdAdd.setText(label);
        }
        else if(button.equalsIgnoreCase("delete")){
            this.cmdDelete.setText(label);
        }
    }

    public String getLabelButton(String button){
        String result = "";
        if(button.equalsIgnoreCase("add")){
            result = this.cmdAdd.getText();
        }
        else if(button.equalsIgnoreCase("delete")){
            result = this.cmdDelete.getText();
        }
        return result;
    }

    public void setStatusButton(String button,boolean status){
        if(button.equalsIgnoreCase("add")){
            this.cmdAdd.setEnabled(status);
        }
        else if(button.equalsIgnoreCase("delete")){
            this.cmdDelete.setEnabled(status);
        }
        else if(button.equalsIgnoreCase("restore")){
            this.cmdRestore.setEnabled(status);
        }
        else if(button.equalsIgnoreCase("close")){
            this.cmdClose.setEnabled(status);
        }
        else if(button.equalsIgnoreCase("edit")){
            this.cmdEdit.setEnabled(status);
        }
        else if(button.equalsIgnoreCase("search")){
            this.cmdSearch.setEnabled(status);
        }
        else if(button.equalsIgnoreCase("showall")){
            this.cmdShowall.setEnabled(status);
        }
    }

    public void addMouseListenerOnTable(MouseInputListener mInput){
        this.tblContent.addMouseListener(mInput);
    }

    public void addKeyListenerOnTable(KeyListener kInput){
        this.tblContent.addKeyListener(kInput);
    }

    public void addActionOnButtonSearch(ActionListener aListener){
        this.cmdSearch.addActionListener(aListener);
    }

    public void addActionOnButtonShowAll(ActionListener aListener){
        this.cmdShowall.addActionListener(aListener);
    }

    public void addActionOnButtonAdd(ActionListener aListener){
        this.cmdAdd.addActionListener(aListener);
    }

    public void addActionOnButtonEdit(ActionListener aListener){
        this.cmdEdit.addActionListener(aListener);
    }
    public void addActionOnButtonDelete(ActionListener aListener){
        this.cmdDelete.addActionListener(aListener);
    }
    public void addActionOnButtonRestore(ActionListener aListener){
        this.cmdRestore.addActionListener(aListener);
    }
    public void addActionOnButtonClose(ActionListener aListener){
        this.cmdClose.addActionListener(aListener);
    }
}
