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

import java.util.List;



public class ResgistroEstudianteService {
    
    private final List<Estudiante> estudiantes = new ArrayList<>(); // ✅ persistente

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
        System.out.println("Estudiante agregado: " + e.getNombre());
    }

    public List<Estudiante> listarEstudiantes() {
        System.out.println("Total estudiantes: " + estudiantes.size());
        return estudiantes;
    }

    public double calcularPromedioGeneral() {
        return estudiantes.stream()
                .flatMap(e -> e.getNotas().stream())
                .mapToDouble(n -> n.getValor())
                .average()
                .orElse(0.0);
    }

    public java.util.Optional<Estudiante> mejorEstudiante() {
        return estudiantes.stream()
                .max((e1, e2) -> Double.compare(
                        e1.getNotas().stream().mapToDouble(n -> n.getValor()).average().orElse(0),
                        e2.getNotas().stream().mapToDouble(n -> n.getValor()).average().orElse(0)
                ));
    }

    public long contarAprobados() {
        return estudiantes.stream()
                .filter(e -> e.getNotas().stream().mapToDouble(n -> n.getValor()).average().orElse(0) >= 3.0)
                .count();
    }

    public long contarReprobados() {
        return estudiantes.stream()
                .filter(e -> e.getNotas().stream().mapToDouble(n -> n.getValor()).average().orElse(0) < 3.0)
                .count();
    }

    public void reemplazar(List<Estudiante> estudiantes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
