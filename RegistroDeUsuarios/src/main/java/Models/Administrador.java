// src/main/java/Models/Administrador.java
package Models;

public class Administrador extends Usuario {

    private int nivelDeAcceso;
// Constructor
    public Administrador(int id, String nombre, String email, int nivelDeAcceso) {
        super(id, nombre, email);
        this.nivelDeAcceso = nivelDeAcceso;
    }

    public int getNivelDeAcceso() {
        return nivelDeAcceso;
    }

    public void setNivelDeAcceso(int nivelDeAcceso) {
        this.nivelDeAcceso = nivelDeAcceso;
    }
// Override (Metodos)
    @Override
    public String rol() {
        return "ADMINISTRADOR";
    }

    @Override
    public String toString() {
        return super.toString() + ", nivelDeAcceso=" + nivelDeAcceso;
    }
}
