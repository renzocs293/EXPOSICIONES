/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.fabrica;

import com.ejemplo.dao.EmpresaDAO;
import com.ejemplo.dao.UsuarioDAO;

/**
 *
 * @author RENZO
 */
public abstract class Fabrica {
    public static final int ORACLE = 1;
    public static final int SQL_SERVER = 2;
    
    public abstract  UsuarioDAO getUsuarioDAO();
    public abstract EmpresaDAO getEmpresaDAO();
    
    public static Fabrica getSubFabrica(int tipo){
        switch(tipo){
            case ORACLE:
                return new SubFabricaOracle();
            case SQL_SERVER:
//                return new SubFabricaSqlServer();
                return null;
        }
        return null;
    }
}
