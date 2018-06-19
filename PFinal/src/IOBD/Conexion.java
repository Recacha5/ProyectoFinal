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

    /**
     * Constructor vacío para poder crear un Objeto Conexion y trabajar con los
     * métodos de la clase.
     *
     */
    public Conexion() {

    }

    /**
     * Conecta con la base de datos.
     */
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

    /**
     *Desconexion de la base de datos.
     */
    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Fallo al desconectar");
        }
    }

    /**
     *  Insertar Alumno en la BD.
     * @param nombre recibe el nombre del alumno a insertar
     * @param clave recibe la clave del alumno a insertar
     */
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

    /**
     * Carga las reservas de un determinado Alumno de la base de datos a memoria
     * @param nombre recibe el nombre del Alumno
     * @return devuelve el HashMap de Reserva
     */
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

    /**
     * Carga las reservas de un determinado Profesor de la base de datos a memoria
     * @param nombre recibe el nombre del Profesor
     * @return devuelve el HasMap de Reserva
     */
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

    /**
     * Carga todas las reservas registradas en la base de datos
     * @return devuelve el HasMap de reserva
     */
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

    /**
     * Carga todos los alumnos de la base de datos a memoria
     * @return devuelve un ArrayList de Alumno
     */
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

    /**
     * Carga todos los admins de la base de datos a memoria
     * @return devuelve un ArrayList de Admin
     */
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

    /**
     * Carga todos los profesores de la base de datos a memoria
     * @return devuelve un ArrayList de Profesor
     */
    public ArrayList<Profesor> cargarProfesor() {
        ArrayList<Profesor> vProfesores = new ArrayList<>();
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select * from profesor");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Profesor p = new Profesor(rs.getString(4), rs.getString(2), rs.getString(3));
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

    /**
     * Insertar Reserva en la base de datos.
     * @param horai recibe la hora de inicio de la practica
     * @param horaf recibe la hora final de la practica
     * @param alumno recibe el codigo de alumno
     * @param profesor recibe el codigo de profesor
     */
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

    /**
     * Inserta un profesor a la base de datos
     * @param nombre recibe el nombre de Profesor
     * @param clave recibe la clave de Profesor
     * @param vehiculo recibe una matrícula del vehículo
     */
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

    /**
     * Insertar Admin en la base de datos.
     * @param nombre recibe la clave de Admin
     * @param clave recibe la clave de Admin
     * @param admin recibe un booleano true si es admin
     */
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

    /**
     * Consulta del codigo de alumno
     * @param nombre recibe el nombre del alumno
     * @return devuelve un int
     */
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

    /**
     * Consulta del codigo de profesor
     * @param nombre recibe el nombre del profesor
     * @return devuelve un int
     */
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

    /**
     * Consulta del codigo de reserva
     * @param alumno recibe el nombre del alumno
     * @param profesor recibe el nombre del profesor
     * @param horai recibe la hora de inicio de la reserva
     * @param horaf recibe la hora de fin de la reserva
     * @return devueve un int
     */
    public int consultarCodigoReserva(int alumno, int profesor, int horai, int horaf) {
        int codigo = 0;
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("select cod_reserva from reservas where cod_alumno = ? AND cod_profesor = ? AND hora_inicio = ? AND hora_fin = ?");
            ps.setInt(1, alumno);
            ps.setInt(2, profesor);
            ps.setInt(3, horai);
            ps.setInt(4, horaf);
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

    /**
     * Consulta a la BD del nombre de un profesor por su codigo
     * @param codigo recibe el codigo
     * @return devuelve un String
     */
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

    /**
     * Consulta a la BD del nombre de un alumno por su codigo
     * @param codigo recibe el codigo
     * @return devuelve un String
     */
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

    /**
     * Elimina una reserva de la BD
     * @param codigo recibe el codigo de reserva
     */
    public void eliminarReserva(int codigo) {
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("delete from reservas where cod_reserva = ?");
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar");
        }
        desconectar();
    }

    /**
     * Cambia el estado de completada a true
     * @param codigo recibe el codigo de la reserva
     */
    public void completarReserva(int codigo) {

        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("update reservas set completada = 1 where cod_reserva = ?");
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar reserva");
        }
        desconectar();
    }

    /**
     * Sumar horas a un alumno
     * @param codigo recibe el codigo de alumno
     * @param horas recibe las horas a sumar
     */
    public void sumarHoras(int codigo, int horas) {
        conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement("update alumno set horas=horas + ? where cod_alumno = ?");
            ps.setInt(1, horas);
            ps.setInt(2, codigo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al sumar horas");
        }
        desconectar();
    }

}
