/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinal;

import java.util.ArrayList;
import java.util.HashMap;
import IOBD.Conexion;

/**
 *
 * @author Alex Recacha
 */
public class Autoescuela extends javax.swing.JFrame {

    /**
     * Creates new form Autoescuela
     */
    public Autoescuela() {
        c = new Conexion();
        vAlumnos = c.cargarAlumnos();
        vProfesor = c.cargarProfesor();
        vAdmins = c.cargarAdmins();
        //reservas = c.cargarReservas();
        crearPruebas();
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jCheckBoxAdmin = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseClicked(evt);
            }
        });

        jCheckBoxAdmin.setText("Soy Admin");

        jLabel2.setText("Clave:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBoxAdmin)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEntrar)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldClave))
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jCheckBoxAdmin)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseClicked
        String clave="";
        for (int i = 0; i < jPasswordFieldClave.getPassword().length; i++) {
                clave += Character.toString(jPasswordFieldClave.getPassword()[i]);
            }
        if (jCheckBoxAdmin.isSelected()) {
            for (int i = 0; i < vAdmins.size(); i++) {
                if (jTextFieldUsuario.getText().equalsIgnoreCase(vAdmins.get(i).getNombre()) && clave.equals(vAdmins.get(i).getClave())) {
                    VentanaAdmin v = new VentanaAdmin(vAdmins, vAlumnos, vProfesor);
                    v.setLocationRelativeTo(this);
                    v.setVisible(true);
                    this.dispose();
                }
            }
        } else {

            for (int i = 0; i < vAlumnos.size(); i++) {
                if (jTextFieldUsuario.getText().equalsIgnoreCase(vAlumnos.get(i).getNombre()) && clave.equals(vAlumnos.get(i).getClave())) {
                    reservas = c.cargarReservasAlumno(jTextFieldUsuario.getText());
                    VentanaAlumno v = new VentanaAlumno(jTextFieldUsuario.getText(), reservas, vAlumnos.get(i), vProfesor);
                    v.setLocationRelativeTo(this);
                    v.setVisible(true);
                    this.dispose();
                }
            }
            for (int i = 0; i < vProfesor.size(); i++) {
                if (jTextFieldUsuario.getText().equalsIgnoreCase(vProfesor.get(i).getNombre()) && clave.equals(vProfesor.get(i).getClave())) {
                    reservas = c.cargarReservasProfesor(jTextFieldUsuario.getText());
                    VentanaProfesor v = new VentanaProfesor(jTextFieldUsuario.getText(), reservas);
                    v.setLocationRelativeTo(this);
                    v.setVisible(true);
                    this.dispose();
                }
            }
        }

    }//GEN-LAST:event_jButtonEntrarMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Autoescuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autoescuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autoescuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autoescuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autoescuela().setVisible(true);
            }
        });
    }

    private void crearPruebas(){
        p = new Profesor("Seat", "Alex", "1234");
        a = new Alumno(2, "Marcos", "1234");
        //admin = new Admin(true, "Admin", "1234");
        vAlumnos.add(a);
        vProfesor.add(p);
        //vAdmins.add(admin);
        
    }
    
    
    //private Admin admin;
    Conexion c;
    private Profesor p;
    private Alumno a;
    private HashMap<Integer, Reserva> reservas;
    private ArrayList<Admin> vAdmins;
    private ArrayList<Alumno> vAlumnos;
    private ArrayList<Profesor> vProfesor;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordFieldClave;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
