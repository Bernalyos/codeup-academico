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
import java.util.Objects;

public class CalculoService {
    
    // Promedio (requerimos exactamente 3 notas; si cambias la regla, ajusta la validación)
    public double promedio(List<nota> notas) {
        Objects.requireNonNull(notas, "Lista de notas nula");
        if (notas.size() != 3) throw new IllegalArgumentException("Se requieren exactamente 3 notas");
        double suma = 0.0;
        for (nota n : notas) suma += n.getValor();
        return suma / notas.size();
    }

    // Nota máxima
    public nota notaMaxima(List<nota> notas) {
        Objects.requireNonNull(notas, "Lista de notas nula");
        if (notas.isEmpty()) throw new IllegalArgumentException("Lista de notas vacía");
        return notas.stream().max(Comparator.comparingDouble(nota::getValor)).orElseThrow();
    }

    // Regla de aprobado (puedes parametrizar el umbral)
    public boolean aprobado(double promedio) {
        final double UMBRAL = 3.0;
        return promedio >= UMBRAL;
    }
}

