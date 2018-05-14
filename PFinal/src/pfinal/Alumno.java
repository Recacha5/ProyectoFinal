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
public class Alumno extends Persona{
    
    private double horas;

    public Alumno(double horas, String nombre) {
        super(nombre);
        this.horas = horas;
    }

    /**
     * @return the horas
     */
    public double getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(double horas) {
        this.horas = horas;
    }
    
    
    
}
