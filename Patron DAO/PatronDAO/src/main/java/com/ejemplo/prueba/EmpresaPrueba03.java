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
public class EmpresaPrueba03 {
    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            EmpresaDAO dao = subFabrica.getEmpresaDAO();
            try {
                Empresa obj = dao.obtener(1);
                if (obj == null) {
                    System.out.println("No existe.");
                } else {
                    System.out.println("Codigo: " + obj.getIdEmpresa());
                    System.out.println("Nombre: " + obj.getNombre());
                    System.out.println("Telefono: " + obj.getTelefono());
                    System.out.println("Ubicacion: " + obj.getUbicacion());
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
