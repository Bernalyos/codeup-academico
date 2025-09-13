/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.registroacademico.domain.service;


import com.codeup.registroacademico.domain.Estudiante;
import com.codeup.registroacademico.domain.nota;

import java.io.*;
import java.util.*;
/**
 *
 * @author Coder
 */
public class ArchivoService {
    
    //guardar lista en el CSV
    public void guardarCSV(File archivo, List<Estudiante> estudiantes) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Estudiante e : estudiantes) {
                String linea = String.format("%s,%s,%d,%.2f,%.2f,%.2f",
                        e.getId(),
                        e.getNombre(),
                        e.getEdad(),
                        e.getNotas().get(0).getValor(),
                        e.getNotas().get(1).getValor(),
                        e.getNotas().get(2).getValor()
                );
                pw.println(linea);
            }
        }
    }

    // Cargar lista desde CSV
    public List<Estudiante> cargarCSV(File archivo) throws IOException {
        List<Estudiante> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length != 6) {
                    throw new IOException("Formato CSV inválido (se esperaban 6 columnas).");
                }
                String id = datos[0];
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                double n1 = Double.parseDouble(datos[3]);
                double n2 = Double.parseDouble(datos[4]);
                double n3 = Double.parseDouble(datos[5]);

                Estudiante e = new Estudiante(id, nombre, edad,
                        List.of(new nota(n1), new nota(n2), new nota(n3)));
                lista.add(e);
            }
        }
        return lista;
    }
    
}
