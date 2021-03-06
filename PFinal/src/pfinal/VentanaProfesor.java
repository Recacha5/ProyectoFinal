/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinal;

import IOBD.Conexion;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Alex Recacha
 */
public class VentanaProfesor extends javax.swing.JFrame {

    /**
     * Creates new form VentanaProfesor
     * @param usuario recibe el nombre del usuario.
     * @param reservas recibe un HashMap de Reserva.
     */
    public VentanaProfesor(String usuario, HashMap reservas) {
        initComponents();
        c = new Conexion();
        this.reservas = reservas;
        this.usuario = usuario;
        jLabel2.setText(usuario);
        modelo = new DefaultListModel();
        jListReservas.setModel(modelo);
        crearLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListReservas = new javax.swing.JList<>();
        jButtonBorrar = new javax.swing.JButton();
        jButtonCompletada = new javax.swing.JButton();
        jButtonDesconectar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jListReservas);

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBorrarMouseClicked(evt);
            }
        });

        jButtonCompletada.setText("Completada");
        jButtonCompletada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCompletadaMouseClicked(evt);
            }
        });

        jButtonDesconectar.setText("Desconectar");
        jButtonDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDesconectarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("BIENVENID@, ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCompletada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBorrar)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCompletada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDesconectar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Borrar una reserva
     * @param evt 
     */
    private void jButtonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBorrarMouseClicked
        
        if (modelo.getSize()>0) {
            
            int n = jListReservas.getSelectedIndex();
            Reserva r = (Reserva) modelo.getElementAt(n);
            int codigo = c.consultarCodigoReserva(r.getAlumno(), r.getProfesor(), r.getHoraI(), r.getHoraF());
            c.eliminarReserva(codigo);
            crearLista();
        }
        
    }//GEN-LAST:event_jButtonBorrarMouseClicked

    /**
     * Cierra la ventana y vuelve a pedir usuario y contraseña para logearte
     * @param evt 
     */
    private void jButtonDesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDesconectarMouseClicked
        Autoescuela a = new Autoescuela();
        a.setLocationRelativeTo(this);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonDesconectarMouseClicked

    /**
     * Completa una practica y suma las horas realizadas.
     * @param evt 
     */
    private void jButtonCompletadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCompletadaMouseClicked
        
        if (modelo.getSize()>0) {
            
            int n = jListReservas.getSelectedIndex();
            Reserva r = (Reserva) modelo.getElementAt(n);
            int codigo = c.consultarCodigoReserva(r.getAlumno(), r.getProfesor(), r.getHoraI(), r.getHoraF());
            c.completarReserva(codigo);
            c.sumarHoras(r.getAlumno(), (r.getHoraF()-r.getHoraI()));
            crearLista();
        }
        
    }//GEN-LAST:event_jButtonCompletadaMouseClicked
    /**
     * Método para crear un modelo para JList
     */
    private void crearLista() {
        modelo.removeAllElements();
        reservas = c.cargarReservasProfesor(usuario);
        Collection aux = reservas.values();
        Iterator it = aux.iterator();
        while (it.hasNext()) {
            Reserva re = (Reserva) it.next();
            modelo.addElement(re);
        }

    }
    private DefaultListModel modelo;
    private Conexion c;
    private HashMap<Integer, Reserva> reservas;
    private String usuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonCompletada;
    private javax.swing.JButton jButtonDesconectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListReservas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
