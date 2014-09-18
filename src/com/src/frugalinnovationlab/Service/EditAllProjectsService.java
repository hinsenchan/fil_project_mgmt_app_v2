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
import javax.persistence.Query;

/**
 *
 * @author Sony
 */
public class EditAllProjectsService {

    private EntityManager manager;

    public EditAllProjectsService(EntityManager manager) {

        this.manager = manager;


    }

    public List<ProjectView> readAll() {



        TypedQuery<ProjectView> query = manager.createQuery("SELECT    NEW  com.src.frugalinnovationlab.Entity.ProjectView(p.name, p.shortdesc, p.description,  p.startDate, p.endDate, s.status, p.outcome, p.scope)   from  Project p JOIN p.projectStatusSet s order by p.name", ProjectView.class);

        List<ProjectView> result = query.getResultList();

        return result;



    }
    
    public boolean deleteProject(String projectName){
        boolean success = false;
        //Query query = manager.createQuery("DELETE FROM Project p where p.name = :pname");
        Query query = manager.createQuery("UPDATE Project p SET p.archive = 'yes' where p.name = :pname");
        query.setParameter("pname", projectName);
        int count = query.executeUpdate();
        System.out.println("delete project : " +count);
        success = true;
        return success;
    }
    
    public boolean activateProject(String projectName){
        boolean success = false;
        //Query query = manager.createQuery("DELETE FROM Project p where p.name = :pname");
        Query query = manager.createQuery("UPDATE Project p SET p.archive = 'no' where p.name = :pname");
        query.setParameter("pname", projectName);
        int count = query.executeUpdate();
        System.out.println("delete project : " +count);
        success = true;
        return success;
    }
}
