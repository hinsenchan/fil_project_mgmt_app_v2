/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.MediaAdobe;
import com.src.frugalinnovationlab.Entity.MediaCad;
import com.src.frugalinnovationlab.Entity.MediaCode;
import com.src.frugalinnovationlab.Entity.MediaPdf;
import com.src.frugalinnovationlab.Entity.MediaPhotos;
import com.src.frugalinnovationlab.Entity.MediaPlaintext;
import com.src.frugalinnovationlab.Entity.MediaSpreadsheet;
import com.src.frugalinnovationlab.Entity.MediaVideo;
import com.src.frugalinnovationlab.Entity.MediaWord;
import com.src.frugalinnovationlab.Entity.Project;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jaishreeganesh
 */
public class EditProjectMultimediaService {

    private EntityManager manager;

    public EditProjectMultimediaService(EntityManager manager) {
        this.manager = manager;
    }

    public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }

    public List<MediaAdobe> fetchAdobeFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaAdobe ma where ma.mediaAdobePK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);

        List<MediaAdobe> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            MediaAdobe mediaAdobe = result.get(i);
            System.out.println("file : " + mediaAdobe.getMediaAdobePK().getFilePath());
        }
        return result;
    }

    public List<MediaCad> fetchCadFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaCad ma where ma.mediaCadPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaCad> result = query.getResultList();
        return result;
    }

    public List<MediaCode> fetchCodeFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaCode ma where ma.mediaCodePK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaCode> result = query.getResultList();
        return result;
    }

    public List<MediaPdf> fetchPdfFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaPdf ma where ma.mediaPdfPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaPdf> result = query.getResultList();
        return result;
    }

    public List<MediaPhotos> fetchPhotosFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaPhotos ma where ma.mediaPhotosPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaPhotos> result = query.getResultList();
        return result;
    }

    public List<MediaPlaintext> fetchPlainTextFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaPlaintext ma where ma.mediaPlaintextPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaPlaintext> result = query.getResultList();
        return result;
    }

    public List<MediaSpreadsheet> fetchSpreadsheetFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaSpreadsheet ma where ma.mediaSpreadsheetPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaSpreadsheet> result = query.getResultList();
        return result;
    }

    public List<MediaVideo> fetchVideoFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaVideo ma where ma.mediaVideoPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaVideo> result = query.getResultList();
        return result;
    }

    public List<MediaWord> fetchWordFiles(String projectId) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "Select ma FROM MediaWord ma where ma.mediaWordPK.projectId = :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        List<MediaWord> result = query.getResultList();
        return result;
    }

    public boolean updateAdobeFiles(String projectId, List<MediaAdobe> adobeFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaAdobe> mediaAdobeSet = new HashSet<MediaAdobe>();
        MediaAdobe mediaAdobe = new MediaAdobe();
    
        for (int i = 0; i < adobeFilesList.size(); i++) {
            mediaAdobe = adobeFilesList.get(i);
            mediaAdobeSet.add(mediaAdobe);
        }
        
        for (MediaAdobe mediaAdobe1 : mediaAdobeSet) {
            
            System.out.println("adobe id : " +mediaAdobe1.getMediaAdobePK().getProjectId());
            System.out.println("adobe id : " +mediaAdobe1.getProjects().getId());
        }
        
        project.setAdobes(mediaAdobeSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updateCadFiles(String projectId, List<MediaCad> cadFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaCad> mediaCadSet = new HashSet<MediaCad>();
        MediaCad mediaCad = new MediaCad();
    
        for (int i = 0; i < cadFilesList.size(); i++) {
            mediaCad = cadFilesList.get(i);
            mediaCadSet.add(mediaCad);
        }
        project.setCads(mediaCadSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updateCodeFiles(String projectId, List<MediaCode> codeFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaCode> mediaCodeSet = new HashSet<MediaCode>();
        MediaCode mediaCode = new MediaCode();
    
        for (int i = 0; i < codeFilesList.size(); i++) {
            mediaCode = codeFilesList.get(i);
            mediaCodeSet.add(mediaCode);
        }
        project.setCodes(mediaCodeSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updatePdfFiles(String projectId, List<MediaPdf> pdfFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaPdf> mediaPdfSet = new HashSet<MediaPdf>();
        MediaPdf mediaPdf = new MediaPdf();
    
        for (int i = 0; i < pdfFilesList.size(); i++) {
            mediaPdf = pdfFilesList.get(i);
            mediaPdfSet.add(mediaPdf);
        }
        project.setPdfs(mediaPdfSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updatePhotoFiles(String projectId, List<MediaPhotos> photoFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaPhotos> mediaPhotoSet = new HashSet<MediaPhotos>();
        MediaPhotos mediaPhoto = new MediaPhotos();
    
        for (int i = 0; i < photoFilesList.size(); i++) {
            mediaPhoto = photoFilesList.get(i);
            mediaPhotoSet.add(mediaPhoto);
        }
        project.setPhotos(mediaPhotoSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updatePlainTextFiles(String projectId, List<MediaPlaintext> plainFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaPlaintext> mediaPlainSet = new HashSet<MediaPlaintext>();
        MediaPlaintext mediaPlainText = new MediaPlaintext();
    
        for (int i = 0; i < plainFilesList.size(); i++) {
            mediaPlainText = plainFilesList.get(i);
            mediaPlainSet.add(mediaPlainText);
        }
        project.setPlainTexts(mediaPlainSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updateSpreadSheetFiles(String projectId, List<MediaSpreadsheet> spreadFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaSpreadsheet> mediaSpreadSet = new HashSet<MediaSpreadsheet>();
        MediaSpreadsheet mediaSpread = new MediaSpreadsheet();
    
        for (int i = 0; i < spreadFilesList.size(); i++) {
            mediaSpread = spreadFilesList.get(i);
            mediaSpreadSet.add(mediaSpread);
        }
        project.setSpreadSheets(mediaSpreadSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updateVideoFiles(String projectId, List<MediaVideo> videoFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaVideo> mediaVideoSet = new HashSet<MediaVideo>();
        MediaVideo mediaVideo = new MediaVideo();
    
        for (int i = 0; i < videoFilesList.size(); i++) {
            mediaVideo = videoFilesList.get(i);
            mediaVideoSet.add(mediaVideo);
        }
        project.setVideos(mediaVideoSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
    public boolean updateWordFiles(String projectId, List<MediaWord> wordFilesList) {
        boolean success = false;
        int id = Integer.parseInt(projectId);
        Project project = manager.find(Project.class, id);
        System.out.println("project id : " + id);
        Set<MediaWord> mediaWordSet = new HashSet<MediaWord>();
        MediaWord mediaWord = new MediaWord();
    
        for (int i = 0; i < wordFilesList.size(); i++) {
            mediaWord = wordFilesList.get(i);
            mediaWordSet.add(mediaWord);
        }
        project.setWords(mediaWordSet);

        manager.merge(project);
        manager.persist(project);
        success = true;
        return success;
    }
    
}
