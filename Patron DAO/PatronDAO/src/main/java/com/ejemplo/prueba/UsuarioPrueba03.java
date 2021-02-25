/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.prueba;

import com.ejemplo.dao.UsuarioDAO;
import com.ejemplo.fabrica.Fabrica;
import com.ejemplo.model.Usuario;

/**
 *
 * @author RENZO
 */
public class UsuarioPrueba03 {

    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            UsuarioDAO dao = subFabrica.getUsuarioDAO();
            try {
                Usuario obj = dao.obtener(2);
                if (obj == null) {
                    System.out.println("No existe.");
                } else {
                    System.out.println("Codigo: " + obj.getId());
                    System.out.println("Paterno: " + obj.getApePaterno());
                    System.out.println("Materno: " + obj.getApeMaterno());
                    System.out.println("Nombre: " + obj.getNombre());
                    System.out.println("Edad: " + obj.getEdad());

                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
