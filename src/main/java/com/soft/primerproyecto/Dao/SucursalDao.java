/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soft.primerproyecto.Dao;

import com.soft.primerproyecto.Entidades.Sucursal;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface SucursalDao {
    public List<Sucursal> findAll();
    public List<Sucursal> findById(Integer id);
    public List<Sucursal> findByNombre(String nombre);
    public List<Sucursal> findByTelefono(String tel);
    public List<Sucursal> findByDireccion(String direccion);
    
    
    
    
    
}
