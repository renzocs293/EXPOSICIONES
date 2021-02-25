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
public class EmpresaPrueba02 {
    public static void main(String[] args) {
        try {
            Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
            EmpresaDAO dao = subFabrica.getEmpresaDAO();
            Empresa empresa = new Empresa();
            empresa.setIdEmpresa(2);
            empresa.setNombre("EMPRESA-02");
            empresa.setTelefono("968342327");
            empresa.setUbicacion("AREQUIPA");
            dao.crear(empresa);
            System.out.println(empresa.getIdEmpresa()+ " | "
                    + empresa.getNombre() + " | "
                    + empresa.getTelefono()+ " | "
                    + empresa.getUbicacion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
