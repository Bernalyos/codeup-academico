/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.registroacademico.domain.service;

/**
 *
 * @author Coder
 */

import com.codeup.registroacademico.domain.nota;
import java.util.Comparator;
import java.util.List;

public class CalculoService {
    
    // Promedio (requerimos exactamente 3 notas; si cambias la regla, ajusta la validación)
    public double promedio(List<nota> notas) {
        if (notas == null || notas.isEmpty()){
            return 0.0;
        }
        return notas.stream()
                .mapToDouble(nota::getValor) 
                .average()
                .orElse(0.0);
        
    }

    //metodo para calcular la nota maxima 
    public nota notaMaxima(List<nota> notas) {
        if (notas.isEmpty()) throw new IllegalArgumentException("Lista de notas vacía");
        
        return notas.stream()
                .max(Comparator
                .comparingDouble(nota::getValor))
                .orElseThrow();
    }

    // Regla de aprobado (puedes parametrizar el umbral)
    public boolean aprobado(double promedio) {
        return promedio >=3.0;
    }
}

