/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinal;

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
        initComponents();
        this.vProfesor = vProfesor;
        this.vAdmin = vAdmin;
        this.vAlumnos = vAlumnos;
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
        jTextFieldUsuarioProfe = new javax.swing.JTextField();
        jPasswordFieldClave = new javax.swing.JPasswordField();
        jPasswordFieldClaveRepetir = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jRadioButtonAlumno = new javax.swing.JRadioButton();
        jRadioButtonProfesor = new javax.swing.JRadioButton();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

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
        jRadioButtonAlumno.setText("Alumno");

        buttonGroup1.add(jRadioButtonProfesor);
        jRadioButtonProfesor.setText("Profesor");

        buttonGroup1.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setText("Administrador");

        jButton1.setText("Desconectar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jRadioButtonAlumno, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldUsuarioProfe, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPasswordFieldClaveRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonProfesor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonAdmin)))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsuarioProfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldClaveRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonProfesor)
                    .addComponent(jRadioButtonAlumno)
                    .addComponent(jRadioButtonAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrear)
                    .addComponent(jButton1))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCrearMouseClicked

        if (jPasswordFieldClave.getPassword().equals(jPasswordFieldClaveRepetir.getPassword()) && !jTextFieldUsuarioProfe.getText().equals("") && !jPasswordFieldClave.getPassword().equals("") && !jPasswordFieldClaveRepetir.equals("")) {
            String clave = "";
            for (int i = 0; i < jPasswordFieldClave.getPassword().length; i++) {
                clave += Character.toString(jPasswordFieldClave.getPassword()[i]);
            }
            if (jRadioButtonAdmin.isSelected()) {
                Admin admin = new Admin(true, jTextFieldUsuarioProfe.getText(), clave);
                vAdmin.add(admin);

            } else if (jRadioButtonAlumno.isSelected()) {
                Alumno a = new Alumno(0, jTextFieldUsuarioProfe.getText(), clave);

            } else if (jRadioButtonProfesor.isSelected()) {

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos");
            }

        }

    }//GEN-LAST:event_jButtonCrearMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        Autoescuela a = new Autoescuela();
        a.setLocationRelativeTo(this);
        a.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1MouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldClave;
    private javax.swing.JPasswordField jPasswordFieldClaveRepetir;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonAlumno;
    private javax.swing.JRadioButton jRadioButtonProfesor;
    private javax.swing.JTextField jTextFieldUsuarioProfe;
    // End of variables declaration//GEN-END:variables
}
