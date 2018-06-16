/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinal;

import IOBD.Conexion;
import com.sun.jndi.ldap.Connection;

/**
 *
 * @author Alex Recacha
 */
public class Reserva {
    
    private int horaI;
    private int horaF;
    private int alumno;
    private int profesor;
    private boolean completada;
    private Conexion c = new Conexion();

    public Reserva(int horaI, int horaF, int alumno, int profesor) {
        this.horaI = horaI;
        this.horaF = horaF;
        this.alumno = alumno;
        this.profesor = profesor;
        this.completada = false;
        
    }

    public Reserva(int horaI, int horaF, int alumno, int profesor, boolean completada) {
        this.horaI = horaI;
        this.horaF = horaF;
        this.alumno = alumno;
        this.profesor = profesor;
        this.completada = completada;
        
    }
    

    /**
     * @return the horaI
     */
    public int getHoraI() {
        return horaI;
    }

    /**
     * @param horaI the horaI to set
     */
    public void setHoraI(int horaI) {
        this.horaI = horaI;
    }

    /**
     * @return the horaF
     */
    public int getHoraF() {
        return horaF;
    }

    /**
     * @param horaF the horaF to set
     */
    public void setHoraF(int horaF) {
        this.horaF = horaF;
    }

    /**
     * @return the alumno
     */
    public int getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the profesor
     */
    public int getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the completada
     */
    public boolean isCompletada() {
        return completada;
    }

    /**
     * @param completada the completada to set
     */
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
    public String completar(){
        if (completada) {
            return "Sí";
        }else{
            return "No";
        }
    }

    @Override
    public String toString() {
        return "Hora Inicio: " + horaI + "h, Hora Fin: " + horaF + "h, Alumno: " + c.consultarNombreAlumno(alumno) + ", Profesor: " + c.consultarNombreProfesor(profesor) + ", Completada:" + completar();
    }
            
    
}
