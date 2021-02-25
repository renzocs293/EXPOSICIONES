/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.fabrica;

import com.ejemplo.dao.EmpresaDAO;
import com.ejemplo.dao.oracle.OracleUsuarioDAO;
import com.ejemplo.dao.UsuarioDAO;
import com.ejemplo.dao.oracle.OracleEmpresaDAO;
import com.ejemplo.fabrica.Fabrica;

/**
 *
 * @author RENZO
 */
public class SubFabricaOracle extends Fabrica{

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new OracleUsuarioDAO();
    }

    @Override
    public EmpresaDAO getEmpresaDAO() {
        return new OracleEmpresaDAO();
    }
    
}
