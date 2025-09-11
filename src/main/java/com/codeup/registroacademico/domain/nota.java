/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.registroacademico.domain;

/**
 *
 * @author Coder
 */


public final class nota {

    private final double valor;

    public nota(double valor) {
        if (valor < 0.0 || valor > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }
        this.valor = valor;
    }

    public double getValor() { 
        return valor; 
    }
    
    @Override
    public String toString() {
        return String.valueOf(valor);
    }

}
