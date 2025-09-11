/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.registroacademico.domain;

/**
 *
 * @author Coder
 */

import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Objects;



public class Estudiante {
    
    private final String id;
    private String nombre;
    private int edad;
    private List<nota> notas;//exactamente 3
    
 

    public Estudiante(String nombre, int edad, List<nota> notas, java.lang.String id){
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id es obligatorio");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre es obligatorio");
        if (edad <= 0) throw new IllegalArgumentException("La edad debe ser mayor que cero");
        if (notas == null || notas.size() != 3) throw new IllegalArgumentException("Se requieren exactamente 3 notas");
        
        this.nombre = nombre.trim();
        this.edad = edad;
        this.notas = notas;
        this.id = id;
    
    }
    
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre es obligatorio");
        this.nombre = nombre.trim();
    }
        
    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad <= 0) throw new IllegalArgumentException("La edad debe ser mayor que cero");
        this.edad = edad;
    }
    public List<nota> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante e = (Estudiante) o;
        return Objects.equals(id, e.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
  
   
  

