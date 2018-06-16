/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinal;

import IOBD.Conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Recacha
 */
public class VentanaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdmin
     *
     * @param vAdmin Recibe el vector de Admins
     * @param vAlumnos Recibe el vector de Alumnos
     * @param vProfesor Recibe el vector de Profesores
     */
    public VentanaAdmin(ArrayList<Admin> vAdmin, ArrayList<Alumno> vAlumnos, ArrayList<Profesor> vProfesor) {
        this.c = new Conexion();
        initComponents();
        this.vProfesor = vProfesor;
        this.vAdmin = vAdmin;
        this.vAlumnos = vAlumnos;
        jTextFieldVehiculo.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsuarioNombre = new javax.swing.JTextField();
        jPasswordFieldClave = new javax.swing.JPasswordField();
        jPasswordFieldClaveRepetir = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jRadioButtonAlumno = new javax.swing.JRadioButton();
        jRadioButtonProfesor = new javax.swing.JRadioButton();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldVehiculo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Usuario:");

        jLabel2.setText("Clave:");

        jLabel3.setText("Repetir Clave:");

        jButtonCrear.setText("Crear Usuario");
        jButtonCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCrearMouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButtonAlumno);
        jRadioButtonAlumno.setSelected(true);
        jRadioButtonAlumno.setText("Alumno");
        jRadioButtonAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlumnoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonProfesor);
        jRadioButtonProfesor.setText("Profesor");
        jRadioButtonProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProfesorActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setText("Administrador");
        jRadioButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdminActionPerformed(evt);
            }
        });

        jButton1.setText("Desconectar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel4.setText("Matrícula Vehículo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldUsuarioNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPasswordFieldClaveRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButtonAlumno)
                                .addGap(32, 32, 32)
                                .addComponent(jRadioButtonProfesor)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonAdmin)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsuarioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldClaveRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonProfesor)
                    .addComponent(jRadioButtonAlumno)
                    .addComponent(jRadioButtonAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrear)
                    .addComponent(jButton1))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCrearMouseClicked
        String clave = "";
        String clave2 = "";
        jTextFieldVehiculo.setEnabled(false);
        for (int i = 0; i < jPasswordFieldClave.getPassword().length; i++) {
            clave += Character.toString(jPasswordFieldClave.getPassword()[i]);
        }
        for (int i = 0; i < jPasswordFieldClaveRepetir.getPassword().length; i++) {
            clave2 += Character.toString(jPasswordFieldClaveRepetir.getPassword()[i]);
        }
        if (clave.equals(clave2) && !jTextFieldUsuarioNombre.getText().equals("") && !jPasswordFieldClave.getPassword().equals("") && !jPasswordFieldClaveRepetir.equals("")) {
            if (jRadioButtonAdmin.isSelected()) {

                c.insertarAdmin(jTextFieldUsuarioNombre.getText(), clave, true);

            } else if (jRadioButtonAlumno.isSelected()) {

                c.insertarAlumno(jTextFieldUsuarioNombre.getText(), clave);

            } else if (jRadioButtonProfesor.isSelected() && !jTextFieldVehiculo.getText().equalsIgnoreCase("")) {

                c.insertarProfesor(jTextFieldUsuarioNombre.getText(), clave, jTextFieldVehiculo.getText());

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos");
            }
        }
        jTextFieldUsuarioNombre.setText("");
        jTextFieldVehiculo.setText("");
        jPasswordFieldClave.setText("");
        jPasswordFieldClaveRepetir.setText("");
    }//GEN-LAST:event_jButtonCrearMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        Autoescuela a = new Autoescuela();
        a.setLocationRelativeTo(this);
        a.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1MouseClicked

    private void jRadioButtonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProfesorActionPerformed
        jTextFieldVehiculo.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonProfesorActionPerformed

    private void jRadioButtonAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAlumnoActionPerformed
        jTextFieldVehiculo.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonAlumnoActionPerformed

    private void jRadioButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdminActionPerformed
        jTextFieldVehiculo.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonAdminActionPerformed

    private Conexion c;
    private ArrayList<Profesor> vProfesor;
    private ArrayList<Alumno> vAlumnos;
    private ArrayList<Admin> vAdmin;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldClave;
    private javax.swing.JPasswordField jPasswordFieldClaveRepetir;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonAlumno;
    private javax.swing.JRadioButton jRadioButtonProfesor;
    private javax.swing.JTextField jTextFieldUsuarioNombre;
    private javax.swing.JTextField jTextFieldVehiculo;
    // End of variables declaration//GEN-END:variables
}
