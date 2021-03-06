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
public class Admin extends Persona{
    
    private boolean isAdmin;

    /**Constructor del objeto Admin, descendiente de la clase Persona.
     *
     * @param isAdmin recibe un booleano true si es admin
     * @param nombre recibe un nombre
     * @param clave recibe una clave
     */
    public Admin(boolean isAdmin, String nombre, String clave) {
        super(nombre, clave);
        this.isAdmin = isAdmin;
    }

    

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
