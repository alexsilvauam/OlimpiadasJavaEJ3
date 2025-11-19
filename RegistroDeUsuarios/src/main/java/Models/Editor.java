package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Editor extends Usuario {

    private final List<String> seccionesAsignadas = new ArrayList<>();

    // Constructor
    public Editor(int id, String nombre, String email, List<String> seccionesIniciales) {
        super(id, nombre, email);
        if (seccionesIniciales != null) {
            seccionesAsignadas.addAll(seccionesIniciales);
        }
    }
    // Getters and Setters
    public List<String> getSeccionesAsignadas() {
        return Collections.unmodifiableList(seccionesAsignadas);
    }

    public void agregarSeccion(String seccion) {
        if (seccion != null && !seccion.isBlank()) {
            seccionesAsignadas.add(seccion);
        }
    }

    public void eliminarSeccion(String seccion) {
        seccionesAsignadas.remove(seccion);
    }

    // Override (Metodos)
    @Override
    public String rol() {
        return "EDITOR";
    }

    @Override
    public String toString() {
        return super.toString() + ", seccionesAsignadas=" + seccionesAsignadas;
    }
}
