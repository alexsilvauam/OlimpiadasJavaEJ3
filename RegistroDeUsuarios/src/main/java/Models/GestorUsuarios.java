// src/main/java/Services/GestorUsuarios.java
package Services;

import Models.Usuario;

import java.util.*;
import java.util.stream.Collectors;

public class GestorUsuarios {

    private final Map<Integer, Usuario> usuarios = new HashMap<>();

    // Agregar usuario
    public boolean agregarUsuario(Usuario usuario) {
        if (usuario == null) return false;
        int id = usuario.getId();
        if (usuarios.containsKey(id)) {
            return false;
        }
        usuarios.put(id, usuario);
        return true;
    }

    // Eliminar por ID
    public boolean eliminarUsuario(int id) {
        return usuarios.remove(id) != null;
    }

    // Buscar por ID
    public Usuario buscarUsuario(int id) {
        return usuarios.get(id);
    }

    // Listar todos ordenados por nombre
    public List<Usuario> listarOrdenadosPorNombre() {
        return usuarios.values().stream()
                .sorted(Comparator.comparing(Usuario::getNombre, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    // Reporte: cantidad de usuarios por tipo (rol)
    public Map<String, Long> reportePorTipo() {
        return usuarios.values().stream()
                .collect(Collectors.groupingBy(
                        Usuario::rol,
                        Collectors.counting()
                ));
    }
}
