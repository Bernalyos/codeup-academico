/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.registroacademico.domain.service;

/**
 *
 * @author Coder
 */

import com.codeup.registroacademico.domain.Estudiante;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class ResgistroEstudianteService {
    


    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final CalculoService calculoService = new CalculoService();

    // Agregar estudiante (no sincronizo por simplicidad; para GUI local no es necesario)
    public void agregarEstudiante(Estudiante e) {
        if (e == null) throw new IllegalArgumentException("Estudiante nulo");
        // Opcional: evitar duplicados por nombre
        boolean existe = estudiantes.stream()
                .anyMatch(s -> s.getNombre().equalsIgnoreCase(e.getNombre()));
        if (existe) {
            throw new IllegalArgumentException("Ya existe un estudiante con el mismo nombre");
        }
        estudiantes.add(e);
    }

    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>(estudiantes); // copia defensiva
    }

    // Promedio general (promedio de los promedios por estudiante)
    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) return 0.0;
        return estudiantes.stream()
                .mapToDouble(s -> calculoService.promedio(s.getNotas()))
                .average()
                .orElse(0.0);
    }

    public Optional<Estudiante> mejorEstudiante() {
        return estudiantes.stream()
                .max(Comparator.comparingDouble(s -> calculoService.promedio(s.getNotas())));
    }

    public long contarAprobados() {
        return estudiantes.stream()
                .filter(s -> calculoService.aprobado(calculoService.promedio(s.getNotas())))
                .count();
    }

    public long contarReprobados() {
        return estudiantes.size() - contarAprobados();
    }

    // Métodos adicionales: eliminar, editar, buscar por id...
    public boolean eliminarPorId(String id) {
        return estudiantes.removeIf(e -> e.getId().equals(id));
    }
}
