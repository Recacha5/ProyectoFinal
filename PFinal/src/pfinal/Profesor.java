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
public class Profesor extends Persona{
    
    private String vehiculo;

    /**Constructor del objeto Profesor, descendiente de la clase Persona
     *
     * @param vehiculo recibe la matricula de un vehiculo
     * @param nombre recibe el nombre de Profesor
     * @param clave recibe la clave
     */
    public Profesor(String vehiculo, String nombre, String clave) {
        super(nombre, clave);
        this.vehiculo = vehiculo;
    }

    

    /**
     * @return the vehiculo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    
}
