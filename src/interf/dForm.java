package interf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import codes.DBconnect;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class dForm extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs=null;

    public dForm() {
        initComponents();
        conn =DBconnect.connect();
        tableLoad();
    }
    
    public void tableLoad(){
        try{
            String sql = "SELECT id AS ID,sname AS NAME,sage AS AGE,sgrade AS GRADE FROM students";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tableData(){
        int tRow = table1.getSelectedRow();
        String id = table1.getValueAt(tRow,0).toString();
        String name = table1.getValueAt(tRow,1).toString();
        String age = table1.getValueAt(tRow,2).toString();
        String grade = table1.getValueAt(tRow,3).toString();
        
        idBox.setText(id);
        nameBox.setText(name);
        ageBox.setText(age);
        gradeBox.setSelectedItem(grade);
    }
    
    public void update(){
        String id = idBox.getText();
        String name = nameBox.getText();
        String age = ageBox.getText();
        String grade = gradeBox.getSelectedItem().toString();
        
        try{
            String sql = "UPDATE students SET sname='"+name+"',sage='"+age+"',sgrade='"+grade+"' WHERE id ='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated...!!");
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void search(){
        String srch = seachBox.getText();
        
        try{
            String sql = "SELECT * FROM students WHERE sname LIKE '%"+srch+"%' OR sage LIKE '%"+srch+"%' OR sgrade LIKE '%"+srch+"%' OR id LIKE '%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        seachBox.setText("");
        idBox.setText("");
        nameBox.setText("");
        ageBox.setText("");
        gradeBox.setSelectedIndex(0);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        seachBox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameBox = new javax.swing.JTextField();
        ageBox = new javax.swing.JTextField();
        gradeBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        idBox = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Students Data Operating System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seachBox.setToolTipText("Search data");
        seachBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seachBoxKeyReleased(evt);
            }
        });
        jPanel2.add(seachBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 60));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Age");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Grade");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        nameBox.setToolTipText("Enter Your Name");
        jPanel3.add(nameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, -1));

        ageBox.setToolTipText("Enter Your Age");
        jPanel3.add(ageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, -1));

        gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        gradeBox.setToolTipText("Select The Grade");
        jPanel3.add(gradeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Student ID");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        idBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idBox.setText("ID");
        jPanel3.add(idBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 200));

        jPanel4.setBackground(new java.awt.Color(204, 255, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        jPanel4.add(insertBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel4.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel4.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel4.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel4.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 260, 110));

        table1.setBackground(new java.awt.Color(255, 204, 153));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 420, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 450));

        setSize(new java.awt.Dimension(754, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        
        String name;
        int age;
        int grade;
        
        name = nameBox.getText();
        age = Integer.parseInt(ageBox.getText());
        grade = Integer.parseInt(gradeBox.getSelectedItem().toString());
        
        try {
            String sql = "INSERT INTO students (sname,sage,sgrade) VALUES ('"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully Add...!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        tableLoad();
        
    }//GEN-LAST:event_insertBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clear();
        tableLoad();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        
        update();
        tableLoad();
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
        
        if (check == 0){
            String id = idBox.getText();
            try{
                String sql = "DELETE FROM students WHERE id='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted!!");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        tableLoad();
        clear();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        tableData();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tableData();
    }//GEN-LAST:event_table1KeyReleased

    private void seachBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachBoxKeyReleased
        search();
    }//GEN-LAST:event_seachBoxKeyReleased


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageBox;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JComboBox<String> gradeBox;
    private javax.swing.JLabel idBox;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameBox;
    private javax.swing.JTextField seachBox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
