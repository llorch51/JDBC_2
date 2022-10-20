
package registro_mysql;


import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class windowApp extends javax.swing.JFrame {

    private static final String user = "root";
    private static final String password = "root";
    private static final String db = "registry_javaproject2";
    private static final String url = "jdbc:mysql://localhost:3306/" + db + "?serverTimezone=UTC&useSSL=false";
    
    int columnas, i, id, deleteItem;
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public windowApp() {
        initComponents();
        updateDB();
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private void limpiarTXT(){
        txtStudent.setText("");
        txtFirst.setText("");
        txtLast.setText("");
        txtAddress.setText("");
        txtPostCode.setText("");
        txtTel.setText("");
        
        txtStudent.requestFocus();
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    public void updateDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            ps = conn.prepareStatement("select * from registry");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            DefaultTableModel dfTable = (DefaultTableModel)table.getModel();//casteamos la JTable de nuestro diseño para q se guarde en la instancia 
                dfTable.setRowCount(0);
            
           while(rs.next()){
               Vector datos_de_columna = new Vector();
               
               for (int j = 0; j < columnas; j++) {
//                   datos_de_columna.add(rs.getString("id"));
//                   datos_de_columna.add(rs.getString("student_id"));
//                   datos_de_columna.add(rs.getString("first_name"));
//                   datos_de_columna.add(rs.getString("last_name"));
//                   datos_de_columna.add(rs.getString("address"));
//                   datos_de_columna.add(rs.getString("post_code"));
//                   datos_de_columna.add(rs.getString("telephone"));
                   
                   datos_de_columna.add(rs.getString(j + 1));
               }
               dfTable.addRow(datos_de_columna);
           }
           
           limpiarTXT();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtStudent = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFirst = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLast = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPostCode = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(925, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel1.setText("CONEXIÓN A MYSQL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 0, 250, 60);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("ACTIONS"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 109, 152, 53));

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 180, 152, 53));

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 251, 152, 53));

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 331, 152, 53));

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 152, 53));

        btnNew.setText("NEW  REGISTRY");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 38, 152, 53));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(710, 70, 190, 470);

        txtStudent.setText("jTextField1");
        getContentPane().add(txtStudent);
        txtStudent.setBounds(160, 70, 170, 30);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("STUDENT ID:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 110, 40);

        txtFirst.setText("jTextField1");
        getContentPane().add(txtFirst);
        txtFirst.setBounds(160, 110, 170, 30);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("FIRST NAME:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 120, 110, 22);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("LAST NAME:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 150, 103, 40);

        txtLast.setText("jTextField1");
        getContentPane().add(txtLast);
        txtLast.setBounds(160, 150, 170, 30);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("ADDRESS:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 80, 83, 16);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("POST CODE:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 120, 99, 16);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("TELEPHONE:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(350, 160, 104, 16);

        txtAddress.setText("jTextField1");
        getContentPane().add(txtAddress);
        txtAddress.setBounds(480, 70, 208, 30);

        txtPostCode.setText("jTextField1");
        txtPostCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPostCodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtPostCode);
        txtPostCode.setBounds(480, 150, 208, 30);

        txtTel.setText("jTextField1");
        getContentPane().add(txtTel);
        txtTel.setBounds(480, 110, 208, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "StudentID", "First Name", "Last Name", "Address", "Post Code", "Telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 670, 330);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás segurísimo de esto?", "Warning", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_NO_OPTION){
            this.setVisible(false);
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        limpiarTXT();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            ps = conn.prepareStatement("insert into registry(student_id, first_name, last_name, address, post_code, telephone) values(?,?,?,?,?,?)");
            ps.setString(1, txtStudent.getText());
            ps.setString(2, txtFirst.getText());
            ps.setString(3, txtLast.getText());
            ps.setString(4, txtAddress.getText());
            ps.setString(5, txtPostCode.getText());
            ps.setString(6, txtTel.getText());
            
            ps.executeUpdate();
            
           JOptionPane.showMessageDialog(this, "Registro añadido");
           updateDB();
           limpiarTXT();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        int seleccionRegistro = table.getSelectedRow();
        try {
            int id = Integer.parseInt(df.getValueAt(seleccionRegistro, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            ps = conn.prepareStatement("update registry set student_id = ?, first_name = ?, last_name = ?, address = ?, post_code = ?, telephone = ? where id = ?");
            ps.setString(1, txtStudent.getText());
            ps.setString(2, txtFirst.getText());
            ps.setString(3, txtLast.getText());
            ps.setString(4, txtAddress.getText());
            ps.setString(5, txtPostCode.getText());
            ps.setString(6, txtTel.getText());
            ps.setInt(7, id);
            
            ps.executeUpdate();
            
           JOptionPane.showMessageDialog(this, "Registro updated");
           updateDB();
           limpiarTXT();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        int selectedRow = table.getSelectedRow();
        
        txtStudent.setText(df.getValueAt(selectedRow, 1).toString());
        txtFirst.setText(df.getValueAt(selectedRow, 2).toString());
        txtLast.setText(df.getValueAt(selectedRow, 3).toString());
        txtAddress.setText(df.getValueAt(selectedRow, 4).toString());
        txtPostCode.setText(df.getValueAt(selectedRow, 5).toString());
        txtTel.setText(df.getValueAt(selectedRow, 6).toString());
        
    }//GEN-LAST:event_tableMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
        
        try {
            table.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (Exception e) {
            System.err.format("No printer found", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String query = "delete from registry where id = ?";
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        int selectedRow = table.getSelectedRow();
        
        try {
            int id = Integer.parseInt(df.getValueAt(selectedRow, 0).toString());
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás segurísimo de esto?", "Warning", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);

                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Registro Eliminado");
            }
            updateDB();
            limpiarTXT();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(windowApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(windowApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtPostCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPostCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPostCodeActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(windowApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(windowApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(windowApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(windowApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
            // select Look and Feel
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            UIManager.setLookAndFeel(new HiFiLookAndFeel());
            // start application
            //new MinFrame();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
                new windowApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtPostCode;
    private javax.swing.JTextField txtStudent;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
