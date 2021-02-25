/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.prueba;

import com.ejemplo.dao.EmpresaDAO;
import com.ejemplo.fabrica.Fabrica;
import com.ejemplo.model.Empresa;
import java.util.List;

/**
 *
 * @author RENZO
 */
public class EmpresaPrueba01 {
    public static void main(String[] args) {
        Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.ORACLE);
        EmpresaDAO dao = subFabrica.getEmpresaDAO();
        
        List<Empresa> listaEmpresas = dao.listar();
        Empresa empresa = new Empresa();
        for(Empresa obj : listaEmpresas){
            empresa.setIdEmpresa(obj.getIdEmpresa());
            empresa.setNombre(obj.getNombre());
            empresa.setTelefono(obj.getTelefono());
            empresa.setUbicacion(obj.getUbicacion());
            System.out.println(empresa.getIdEmpresa() + " | " +
                               empresa.getNombre() + " | " +
                               empresa.getTelefono() + " | " +
                               empresa.getUbicacion());
        }    
    }
}
