/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import javax.persistence.EntityManager;
import com.src.frugalinnovationlab.Entity.*;
import javax.persistence.TypedQuery;

import java.util.List;

/**
 *
 * @author Sony
 */
public class SearchProjectService {

    private EntityManager manager;

    public SearchProjectService(EntityManager manager) {
        this.manager = manager;
    }

    public List<ProjectView> readAll(String searchvalue) {
        String text;
        TypedQuery<ProjectView> query = manager.createQuery("SELECT    NEW  com.src.frugalinnovationlab.Entity.ProjectView(p.name, p.shortdesc, p.description,  p.startDate,   p.endDate,  s.status, p.outcome, p.scope)   from  Project p JOIN  p.projectStatusSet s  where p.name like :text or p.description like :text or p.shortdesc like :text", ProjectView.class);
        query.setParameter("text", "%" + searchvalue + "%");
        List<ProjectView> result = query.getResultList();
        return result;
    }
}
