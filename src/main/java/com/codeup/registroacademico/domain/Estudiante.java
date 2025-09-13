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
import java.util.UUID;



public class Estudiante {
    
    //atributos 
    private final UUID id;
    private String nombre;
    private int edad;
    private List<nota> notas;//exactamente 3
    
    //constructor
    public Estudiante(String nombre, int edad, List<nota> notas, UUID id){
        if (id== null) throw new IllegalArgumentException("EL id es obligatorio");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre es obligatorio");
        if (edad <= 0) throw new IllegalArgumentException("La edad debe ser mayor a 0");
        if (notas == null || notas.size() !=3) throw new IllegalArgumentException("Se requieren exactamente 3 notas ");
        
         this.nombre = nombre.trim();
         this.edad = edad;
         this.notas = notas;
         this.id = id;
    }

    public Estudiante(String nombre, int edad, double nota1, double nota2, double nota3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Estudiante(String toString, String nombre, int edad, List<nota> of) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
       //metodos de acceso y validación getters y setters ó
    
    public UUID getId() { return id; } 
    
    public String getNombre() { return nombre; }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) 
            throw new IllegalArgumentException("El nombre es obligatorio");
        
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
   
    
    public void addNota(nota valor) {
        this.notas.add(valor);
    }

}
  
   
  

