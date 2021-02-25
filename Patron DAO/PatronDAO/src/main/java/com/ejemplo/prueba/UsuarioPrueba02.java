/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.prueba;

import com.ejemplo.dao.UsuarioDAO;
import com.ejemplo.fabrica.Fabrica;
import com.ejemplo.model.Usuario;
import java.util.List;

/**
 *
 * @author RENZO
 */
public class UsuarioPrueba02 {

    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            UsuarioDAO dao = subFabrica.getUsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setId(4);
            usuario.setNombre("Rodrigo");
            usuario.setApePaterno("Ramirez");
            usuario.setApeMaterno("Casas");
            usuario.setEdad(33);
            dao.crear(usuario);
            System.out.println(usuario.getId() + " | "
                    + usuario.getNombre() + " | "
                    + usuario.getApePaterno() + " | "
                    + usuario.getApeMaterno() + " | "
                    + usuario.getEdad());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
