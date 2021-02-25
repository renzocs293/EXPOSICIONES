/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.prueba;

import com.ejemplo.dao.EmpresaDAO;
import com.ejemplo.fabrica.Fabrica;
import com.ejemplo.model.Empresa;

/**
 *
 * @author RENZO
 */
public class EmpresaPrueba04 {
    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            EmpresaDAO dao = subFabrica.getEmpresaDAO();
            dao.eliminar(1);
            System.out.println("SE ELIMINO LA EMPRESA SELECCIONADA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
