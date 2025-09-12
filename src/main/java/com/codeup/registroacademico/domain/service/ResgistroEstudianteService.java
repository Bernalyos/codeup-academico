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

    // Agregar estudiante (no sincronizo por simplicidad; para GUI local no es necesario)}
    
    public void agregarEstudiante(Estudiante e ){
        if (e == null) throw new IllegalArgumentException("El estudiante no puede ser nulo");
        
        estudiantes.add(e);
     
    }
    
    //metodo para listar los estudiantes
    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>(estudiantes); // copia defensiva
    }

    // metodo para calcular promedio 
    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) return 0.0;
        return estudiantes.stream()
                .mapToDouble(s -> calculoService.promedio(s.getNotas()))
                .average()
                .orElse(0.0);
    }

    //metodo para obtener el mejor estdudiante 
    public Optional<Estudiante> mejorEstudiante() {
        return estudiantes.stream()
                .max(Comparator.comparingDouble(s -> calculoService.promedio(s.getNotas())));
    }
   
    //metodo para contar estudinates 
    public long contarAprobados() {
        return estudiantes.stream()
                .filter(s -> calculoService.aprobado(calculoService.promedio(s.getNotas())))
                .count();
    }

    //metodo para contar aprobados y reprobados 
    public long contarReprobados() {
        return estudiantes.size() - contarAprobados();
    }

}
