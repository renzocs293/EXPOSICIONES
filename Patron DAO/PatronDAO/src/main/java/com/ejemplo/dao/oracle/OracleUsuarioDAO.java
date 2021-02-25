/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.dao.oracle;

import com.ejemplo.conexion.OracleConexion;
import com.ejemplo.dao.UsuarioDAO;
import com.ejemplo.model.Usuario;
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
public class OracleUsuarioDAO implements UsuarioDAO {

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = OracleConexion.getConnection();
            String sql = "select idUsuario, nombre, apePaterno, "
                    + "apeMaterno, edad "
                    + "from USUARIO ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApePaterno(rs.getString("apePaterno"));
                usuario.setApeMaterno(rs.getString("apeMaterno"));
                usuario.setEdad(rs.getInt("edad"));
                lista.add(usuario);
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
    public void crear(Usuario t) {
        Usuario usuario = t;
        Connection cn = null;
        try {
            // Variables
            String sql;
            PreparedStatement pstm;
            cn = OracleConexion.getConnection();
            // Insertar
            sql = "insert into USUARIO(idUsuario,nombre,apePaterno,"
                    + "apeMaterno,edad) values(?,?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, usuario.getId());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApePaterno());
            pstm.setString(4, usuario.getApeMaterno());
            pstm.setInt(5, usuario.getEdad());
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
    public Usuario obtener(int id) {
        Usuario usuario = null;
        Connection cn = null;
        try {
            cn = OracleConexion.getConnection();
            String sql = "select idUsuario, nombre, apePaterno, "
                    + "apeMaterno, edad "
                    + "from USUARIO "
                    + "where idUsuario = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApePaterno(rs.getString("apePaterno"));
                usuario.setApeMaterno(rs.getString("apeMaterno"));
                usuario.setEdad(rs.getInt("edad"));
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
        return usuario;
    }

    @Override
    public void eliminar(int id) {
        Connection cn = null;
        try {
            String sql;
            PreparedStatement pstm;
            cn = OracleConexion.getConnection();
            sql = "delete from USUARIO where idUsuario = ?";
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
    public void actualizar(Usuario t) {
        Usuario usuario = t;
        Connection cn = null;
        try {
            String sql;
            PreparedStatement pstm;
            cn = OracleConexion.getConnection();
            sql = "UPDATE USUARIO SET nombre = ? WHERE idUsuario = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario.getNombre());
            pstm.setInt(2, usuario.getId());
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
