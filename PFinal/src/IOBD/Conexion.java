/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import pfinal.Admin;
import pfinal.Alumno;
import pfinal.Profesor;
import pfinal.Reserva;

/**
 *
 * @author Alex Recacha
 */
public class Conexion {

    private String db = "proyecto";
    private String url = "jdbc:mysql://localhost:3307/" + db;
    private String user = "root";
    private String pass = "usbw";
    private Connection conexion;

    public Conexion() {
    }

    private void conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Fallo al desconectar");
        }
    }

    public void insertarAlumno(String nombre, String clave) {
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("insert into alumno values(0,?,?,?)");
            //ps.setInt(1, 0);
            ps.setString(1, nombre);
            ps.setString(2, clave);
            ps.setInt(3, 0);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Error al insertar Alumno");
        }
        desconectar();
    }

    public HashMap<Integer, Reserva> cargarReservasAlumno(String nombre) {
        HashMap<Integer, Reserva> reservas = new HashMap<>();
        int codigo = consultarCodigoAlumno(nombre);
        int contador = 0;
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from reservas where cod_alumno = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
                reservas.put(contador, r);
                contador++;
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return reservas;
    }
    
    public HashMap<Integer, Reserva> cargarReservasProfesor(String nombre) {
        HashMap<Integer, Reserva> reservas = new HashMap<>();
        int codigo = consultarCodigoProfesor(nombre);
        int contador = 0;
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from reservas where cod_profesor = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
                reservas.put(contador, r);
                contador++;
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return reservas;
    }
    public HashMap<Integer, Reserva> cargarTodasLasReservas() {
        HashMap<Integer, Reserva> reservas = new HashMap<>();
        int contador = 0;
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from reservas");
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
                reservas.put(contador, r);
                contador++;
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return reservas;
    }

    public ArrayList<Alumno> cargarAlumnos() {
        ArrayList<Alumno> vAlumnos = new ArrayList<>();
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from alumno");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno(rs.getInt(4), rs.getString(2), rs.getString(3));
                vAlumnos.add(a);

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return vAlumnos;
    }

    public ArrayList<Admin> cargarAdmins() {
        ArrayList<Admin> vAdmins = new ArrayList<>();
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from admin");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Admin a = new Admin(rs.getBoolean(4), rs.getString(2), rs.getString(3));
                vAdmins.add(a);

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return vAdmins;
    }

    public ArrayList<Profesor> cargarProfesor() {
        ArrayList<Profesor> vProfesores = new ArrayList<>();
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from admin");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Profesor p = new Profesor(rs.getString(2), rs.getString(3), rs.getString(4));
                vProfesores.add(p);

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return vProfesores;
    }

    public void insertarReserva(int horai, int horaf, int alumno, int profesor) {
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("insert into reservas values(0,?,?,?,?,0)");
            ps.setInt(1, horai);
            ps.setInt(2, horaf);
            ps.setInt(3, alumno);
            ps.setInt(4, profesor);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al insertar la reserva");
        }
        desconectar();
    }

    /*public void insertarAlumno2(String nombre, String clave, int horas){
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("insert into alumno values(0,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, clave);
            ps.setInt(3, horas);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al insertar el alumno");
        }
        desconectar();
    }*/
    public void insertarProfesor(String nombre, String clave, String vehiculo) {
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("insert into profesor values(0,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, clave);
            ps.setString(3, vehiculo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al insertar el profesor");
        }
        desconectar();
    }

    public void insertarAdmin(String nombre, String clave, Boolean admin) {
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("insert into admin values(0,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, clave);
            ps.setBoolean(3, admin);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al insertar el Administrador");
        }
        desconectar();
    }

    public int consultarCodigoAlumno(String nombre) {
        int codigo = 0;
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from alumno where nombre = ?");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return codigo;
    }

    public int consultarCodigoProfesor(String nombre) {
        int codigo = 0;
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select cod_profesor from profesor where nombre = ?");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return codigo;
    }

    public String consultarNombreProfesor(int codigo) {
        String nombre = "";
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from profesor where cod_profesor = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString(2);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return nombre;
    }
    
    public String consultarNombreAlumno(int codigo) {
        String nombre = "";
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from alumno where cod_alumno = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString(2);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return nombre;
    }

}
