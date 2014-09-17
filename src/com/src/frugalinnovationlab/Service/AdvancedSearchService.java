/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Entity.ProjectView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sony
 */
public class AdvancedSearchService {

    private EntityManager manager;

    public AdvancedSearchService(EntityManager manager) {
        this.manager = manager;
    }

    public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }

    public List<ProjectStatus> fetchProjectStatus() {
        TypedQuery<ProjectStatus> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ProjectStatus(p.status, p.statusDescription) "
                + "FROM ProjectStatus p", ProjectStatus.class);
        List<ProjectStatus> result = query.getResultList();
        return result;
    }

    public List<ProjectView> fetchAdvancedResults(Map<String, String> advSearchInputs, Map<String, String> advSearchCatInputs) {
        List<ProjectView> result = null;
        String queryStr = "SELECT  DISTINCT  NEW  com.src.frugalinnovationlab.Entity.ProjectView(p.name, p.shortdesc, "
                + "p.description,  p.startDate,   p.endDate, s.status, p.outcome, p.scope )   "
                + "from  Project p  LEFT JOIN p.projectCategories r JOIN p.projectStatusSet s where ";
        //queryStr = queryStr.concat(" p.name like :text");
        if (!advSearchInputs.get("search_text").equals("") && advSearchInputs.get("search_text") != null) {
            queryStr = queryStr.concat(" p.name like :text");
        }

        if (!advSearchInputs.get("short_desc").equals("") && advSearchInputs.get("short_desc") != null) {
            if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ")) {
                queryStr = queryStr.concat(" and ");
            }
            queryStr = queryStr.concat(" p.shortdesc like :shorttext");
        }

        if (!advSearchInputs.get("scope").equals("") && advSearchInputs.get("scope") != null) {
            if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ")) {
                queryStr = queryStr.concat(" and ");
            }
            queryStr = queryStr.concat(" p.scope like :scopetext");
        }

        if (!advSearchInputs.get("project_status").equalsIgnoreCase("Choose Status") && advSearchInputs.get("project_status") != null) {
            if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ")) {
                queryStr = queryStr.concat(" and ");
            }
            queryStr = queryStr.concat(" s.status = :statustext");
        }

        if (!advSearchInputs.get("startdate").equals("") && advSearchInputs.get("startdate") != null) {
            if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ")) {
                queryStr = queryStr.concat(" and ");
            }
            queryStr = queryStr.concat(" p.startDate > :startdate");
        }

        if (!advSearchInputs.get("enddate").equals("") && advSearchInputs.get("enddate") != null) {
            if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ")) {
                queryStr = queryStr.concat(" and ");
            }
            queryStr = queryStr.concat(" p.endDate < :enddate");
        }
        System.out.println("size of advSearchCatInputs : " + advSearchCatInputs.size());
        boolean flag = false;
        for (Map.Entry<String, String> entry : advSearchCatInputs.entrySet()) {
            if (entry.getValue().equals("yes")) {
                flag = true;
                break;
            }
        }
        if (flag) {
            if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ")) {
                queryStr = queryStr.concat(" and ");
            }
            queryStr = queryStr.concat(" ( ");
            if (advSearchCatInputs.get("computerengineering").equals("yes")) {
                queryStr = queryStr.concat(" r.name = :comptext ");
            }
            if (advSearchCatInputs.get("civilengineering").equals("yes")) {
                if (!queryStr.endsWith("where ") && !queryStr.endsWith("and ") 
                        && !queryStr.endsWith("or ") && !queryStr.endsWith("( ")) {
                    queryStr = queryStr.concat(" or ");
                }
                queryStr = queryStr.concat(" r.name = :civiltext ");
            }
            if (advSearchCatInputs.get("bioengineering").equals("yes")) {
                if (!queryStr.endsWith("where ") && !queryStr.endsWith("or ") && !queryStr.endsWith("and ") && !queryStr.endsWith("( ")) {
                    queryStr = queryStr.concat(" or ");
                }
                queryStr = queryStr.concat(" r.name = :biotext ");
            }
            if (advSearchCatInputs.get("electricalengineering").equals("yes")) {
                if (!queryStr.endsWith("where ") && !queryStr.endsWith("or ") && !queryStr.endsWith("and ") && !queryStr.endsWith("( ")) {
                    queryStr = queryStr.concat(" or ");
                }
                queryStr = queryStr.concat(" r.name = :electext ");
            }
            if (advSearchCatInputs.get("mechanicalengineering").equals("yes")) {
                if (!queryStr.endsWith("where ") && !queryStr.endsWith("or ") && !queryStr.endsWith("and ") && !queryStr.endsWith("( ")) {
                    queryStr = queryStr.concat(" or ");
                }
                queryStr = queryStr.concat(" r.name = :mechtext ");
            }
            queryStr = queryStr.concat(" )");
        }
        System.out.println("Query is : " +queryStr);
        if (queryStr.length() == 247) {
            queryStr = queryStr.substring(0, queryStr.length() - 6);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        TypedQuery<ProjectView> query = manager.createQuery(queryStr, ProjectView.class);
        if (!advSearchInputs.get("search_text").equals("") && advSearchInputs.get("search_text") != null) {
            query.setParameter("text", "%" + advSearchInputs.get("search_text") + "%");
        }
        if (!advSearchInputs.get("short_desc").equals("") && advSearchInputs.get("short_desc") != null) {
            query.setParameter("shorttext", "%" + advSearchInputs.get("short_desc") + "%");
        }
        if (!advSearchInputs.get("scope").equals("") && advSearchInputs.get("scope") != null) {
            query.setParameter("scopetext", "%" + advSearchInputs.get("scope") + "%");
        }
        if (!advSearchInputs.get("project_status").equalsIgnoreCase("Choose Status") && advSearchInputs.get("project_status") != null) {
            query.setParameter("statustext", advSearchInputs.get("project_status"));
        }
        if (!advSearchInputs.get("startdate").equals("") && advSearchInputs.get("startdate") != null) {
            try {
                query.setParameter("startdate", formatter.parse(advSearchInputs.get("startdate")));
            } catch (ParseException ex) {
                Logger.getLogger(AdvancedSearchService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!advSearchInputs.get("enddate").equals("") && advSearchInputs.get("enddate") != null) {
            try {
                query.setParameter("enddate", formatter.parse(advSearchInputs.get("enddate")));
            } catch (ParseException ex) {
                Logger.getLogger(AdvancedSearchService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (flag) {
            if (advSearchCatInputs.get("computerengineering").equals("yes")) {
                query.setParameter("comptext", "Computer Engineering");
            }
            if (advSearchCatInputs.get("civilengineering").equals("yes")) {
                query.setParameter("civiltext", "Civil Engineering");
            }
            if (advSearchCatInputs.get("bioengineering").equals("yes")) {
                query.setParameter("biotext", "Bio Engineering");
            }
            if (advSearchCatInputs.get("electricalengineering").equals("yes")) {
                query.setParameter("civiltext", "Electrical Engineering");
            }
            if (advSearchCatInputs.get("mechanicalengineering").equals("yes")) {
                query.setParameter("mechtext", "Mechanical Engineering");
            }
        }


        result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            ProjectView projectView = result.get(i);
            System.out.println("name of project : " + projectView.getProjectName());
        }
        return result;
    }
}
