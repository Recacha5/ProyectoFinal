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
public class Alumno extends Persona {

    private int horas;

    /**Constructor del objeto Alumno, descendiente de la clase Persona.
     *
     * @param horas recibe las horas realizadas
     * @param nombre recibe el nombre
     * @param clave recibe la clave
     */
    public Alumno(int horas, String nombre, String clave) {
        super(nombre, clave);
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
    public void setHoras(int horas) {
        this.horas = horas;
    }

}
