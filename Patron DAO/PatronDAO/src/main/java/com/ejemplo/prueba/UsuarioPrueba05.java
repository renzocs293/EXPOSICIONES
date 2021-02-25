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
public class UsuarioPrueba05 {
    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            UsuarioDAO dao = subFabrica.getUsuarioDAO();
            Usuario empresa = new Usuario();
            empresa.setId(2);
            empresa.setNombre("RENZO");
            dao.actualizar(empresa);
            System.out.println(empresa.getId()+ " | "
                    + empresa.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
