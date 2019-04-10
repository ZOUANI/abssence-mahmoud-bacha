/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.absenteisme.etudiants.ejb.service;

import com.gestion.absenteisme.etudiants.ejb.entity.Plannification;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author t3500
 */
@Stateless
public class PlannificationFacade extends AbstractFacade<Plannification> {

    @PersistenceContext(unitName = "abssencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlannificationFacade() {
        super(Plannification.class);
    }
    
}
