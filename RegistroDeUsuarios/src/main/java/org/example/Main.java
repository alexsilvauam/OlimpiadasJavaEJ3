package org.example;

import Models.Administrador;
import Models.Editor;
import Models.Lector;
import Models.Usuario;
import Services.GestorUsuarios;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        GestorUsuarios gestor = new GestorUsuarios();

        // Crear usuarios de ejemplo
        Administrador admin1 = new Administrador(1, "Carlos", "carlos@uamv.edu.ni", 5);
        Editor editor1 = new Editor(2, "Ana", "ana@uamv.edu.ni",
                Arrays.asList("Deportes", "Tecnologia"));
        Lector lector1 = new Lector(3, "Bruno", "bruno@uamv.edu.ni",
                new HashSet<>(Arrays.asList("Calculo", "Programacion")));

        // Agregar usuarios al gestor
        gestor.agregarUsuario(admin1);
        gestor.agregarUsuario(editor1);
        gestor.agregarUsuario(lector1);

        // Buscar por ID
        System.out.println("Buscar ID 2:");
        Usuario u = gestor.buscarUsuario(2);
        System.out.println(u);

        // Eliminar por ID
        System.out.println("\nEliminar ID 3:");
        boolean eliminado = gestor.eliminarUsuario(3);
        System.out.println("Eliminado: " + eliminado);

        // Listar ordenados por nombre
        System.out.println("\nUsuarios ordenados por nombre:");
        List<Usuario> usuariosOrdenados = gestor.listarOrdenadosPorNombre();
        for (Usuario usuario : usuariosOrdenados) {
            System.out.println(usuario);
        }

        // Reporte por tipo
        System.out.println("\nReporte de usuarios por tipo:");
        Map<String, Long> reporte = gestor.reportePorTipo();
        for (Map.Entry<String, Long> entry : reporte.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
