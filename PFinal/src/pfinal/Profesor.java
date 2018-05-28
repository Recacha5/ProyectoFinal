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
