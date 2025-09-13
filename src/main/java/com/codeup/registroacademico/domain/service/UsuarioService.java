/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.registroacademico.domain.service;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Coder
 */
public class UsuarioService {
    
     private final Map<String, String> usuarios = new HashMap<>();

    public UsuarioService() {
        usuarios.put("admin", "1234"); // usuario: admin, pass: 1234
        usuarios.put("coder", "abcd"); // otro ejemplo
    }

    public boolean autenticar(String user, char[] pass) {
        String clave = new String(pass);
        return usuarios.containsKey(user) && usuarios.get(user).equals(clave);
    }
}
