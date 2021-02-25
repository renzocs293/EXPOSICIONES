/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.prueba;

import com.ejemplo.fabrica.Fabrica;
import com.ejemplo.dao.UsuarioDAO;
import com.ejemplo.model.Usuario;
import java.util.List;

/**
 *
 * @author RENZO
 */
public class UsuarioPrueba01 {
    
    public static void main(String[] args) {
        Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
        UsuarioDAO dao = subFabrica.getUsuarioDAO();
        
        List<Usuario> listaUsuarios = dao.listar();
        Usuario usuario = new Usuario();
        for(Usuario obj : listaUsuarios){
            usuario.setId(obj.getId());
            usuario.setApePaterno(obj.getApePaterno());
            usuario.setApeMaterno(obj.getApeMaterno());
            usuario.setNombre(obj.getNombre());
            usuario.setEdad(obj.getEdad());
            System.out.println(usuario.getId() + " | " +
                               usuario.getNombre() + " | " +
                               usuario.getApePaterno() + " | " +
                               usuario.getApeMaterno() + " | " +
                               usuario.getEdad());
        }
    }
    
}
