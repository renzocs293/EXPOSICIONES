/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.dao.oracle;

import com.ejemplo.conexion.OracleConexion;
import com.ejemplo.dao.EmpresaDAO;
import com.ejemplo.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RENZO
 */
public class OracleEmpresaDAO implements EmpresaDAO{

    @Override
    public List<Empresa> listar() {
        List<Empresa> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = OracleConexion.getConnection();
            String sql = "select idEmpresa, nombre, telefono, "
                    + "ubicacion "
                    + "from EMPRESA ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setUbicacion(rs.getString("ubicacion"));
                lista.add(empresa);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error de acceso a la tabla Cliente.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public void crear(Empresa t) {
        Empresa empresa = t;
        Connection cn = null;
        try {
            // Variables
            String sql;
            PreparedStatement pstm;
            cn = OracleConexion.getConnection();
            // Insertar
            sql = "insert into EMPRESA(idEmpresa, nombre, telefono,"
                    + "ubicacion) values(?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, empresa.getIdEmpresa());
            pstm.setString(2, empresa.getNombre());
            pstm.setString(3, empresa.getTelefono());
            pstm.setString(4, empresa.getUbicacion());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en proceso de creación de cuenta.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public Empresa obtener(int id) {
        Empresa empresa = null;
        Connection cn = null;
        try {
            cn = OracleConexion.getConnection();
            String sql = "select idEmpresa, nombre, telefono, "
                    + "ubicacion "
                    + "from EMPRESA "
                    + "where idEmpresa = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setUbicacion(rs.getString("ubicacion"));
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error de acceso a la tabla Cliente.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return empresa;
    }

    @Override
    public void eliminar(int id) {
        Connection cn = null;
        try {
            String sql;
            PreparedStatement pstm;
            cn = OracleConexion.getConnection();
            sql = "delete from EMPRESA where idEmpresa = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en proceso de creación de cuenta.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void actualizar(Empresa t) {
        Empresa empresa = t;
        Connection cn = null;
        try {
            String sql;
            PreparedStatement pstm;
            cn = OracleConexion.getConnection();
            sql = "UPDATE EMPRESA SET nombre = ? WHERE idEmpresa = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, empresa.getNombre());
            pstm.setInt(2, empresa.getIdEmpresa());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en proceso de creación de cuenta.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
    
}
