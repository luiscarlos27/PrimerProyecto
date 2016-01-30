/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soft.primerproyecto.Dao;

import com.soft.primerproyecto.Entidades.Sucursal;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Usuario
 */
@Repository("sucursalDao")
public class SucursalDaoImplementacion extends BaseDaoHibernate<Sucursal, Integer> implements SucursalDao {

    @Autowired
    public SucursalDaoImplementacion(SessionFactory sessionFactory) {
        this.setType(Sucursal.class);
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    public List<Sucursal> findAll() {
        class Local {};
        return executeNamedQuery(Local.class.getEnclosingMethod(), null);
    }

    @Override
    public List<Sucursal> findById(Integer id) {
        Object[] parameters = {id}; 
        class Local {};
        return executeNamedQuery(Local.class.getEnclosingMethod(), parameters);
    }

    @Override
    public List<Sucursal> findByNombre(String nombre) {
        Object[] parameters = {nombre}; 
        class Local {};
        return executeNamedQuery(Local.class.getEnclosingMethod(), parameters);
    }

    @Override
    public List<Sucursal> findByTelefono(String tel) {
        Object[] parameters = {tel}; 
        class Local {};
        return executeNamedQuery(Local.class.getEnclosingMethod(), parameters);
    }

    @Override
    public List<Sucursal> findByDireccion(String direccion) {
        Object[] parameters = {direccion}; 
        class Local {};
        return executeNamedQuery(Local.class.getEnclosingMethod(), parameters);
    }
    
}
