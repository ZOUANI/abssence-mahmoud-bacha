/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.absenteisme.etudiants.ejb.service;

import com.gestion.absenteisme.etudiants.ejb.entity.Semestre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author t3500
 */
@Stateless
public class SemestreFacade extends AbstractFacade<Semestre> {

    @PersistenceContext(unitName = "abssencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SemestreFacade() {
        super(Semestre.class);
    }
    
}
