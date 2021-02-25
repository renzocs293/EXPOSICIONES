/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.prueba;

import com.ejemplo.dao.UsuarioDAO;
import com.ejemplo.fabrica.Fabrica;

/**
 *
 * @author RENZO
 */
public class UsuarioPrueba04 {

    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            UsuarioDAO dao = subFabrica.getUsuarioDAO();
            dao.eliminar(1);
            System.out.println("SE ELIMINO EL USUARIO SELECCIONADO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
