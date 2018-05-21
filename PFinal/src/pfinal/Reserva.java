/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinal;

/**
 *
 * @author Alex Recacha
 */
public class Reserva {
    
    private int horaI;
    private int horaF;
    private Alumno alumno;
    private Profesor profesor;
    private boolean completada;

    public Reserva(int horaI, int horaF, Alumno alumno, Profesor profesor) {
        this.horaI = horaI;
        this.horaF = horaF;
        this.alumno = alumno;
        this.profesor = profesor;
        this.completada = false;
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
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
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
        return "Hora Inicio: " + horaI + "h, Hora Fin: " + horaF + "h, Alumno: " + alumno.getNombre() + ", Profesor: " + profesor.getNombre() + ", Completada:" + completar();
    }
            
    
}
