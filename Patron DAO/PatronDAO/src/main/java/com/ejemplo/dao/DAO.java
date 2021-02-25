/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.dao;

import java.util.List;

/**
 *
 * @author RENZO
 */
public interface DAO<T> {
    List<T> listar();
    void crear(T t);
    T obtener(int id);
    void eliminar(int id);
    void actualizar(T t);
}
