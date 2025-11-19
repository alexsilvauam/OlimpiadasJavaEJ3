// src/main/java/Models/Lector.java
package Models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lector extends Usuario {

    private final Set<String> temasFavoritos = new HashSet<>();

    public Lector(int id, String nombre, String email, Set<String> temasIniciales) {
        super(id, nombre, email);
        if (temasIniciales != null) {
            temasFavoritos.addAll(temasIniciales);
        }
    }

    public Set<String> getTemasFavoritos() {
        return Collections.unmodifiableSet(temasFavoritos);
    }

    public void agregarTemaFavorito(String tema) {
        if (tema != null && !tema.isBlank()) {
            temasFavoritos.add(tema);
        }
    }

    public void eliminarTemaFavorito(String tema) {
        temasFavoritos.remove(tema);
    }

    @Override
    public String rol() {
        return "LECTOR";
    }

    @Override
    public String toString() {
        return super.toString() + ", temasFavoritos=" + temasFavoritos;
    }
}
