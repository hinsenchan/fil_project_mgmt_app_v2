/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

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
import com.src.frugalinnovationlab.Service.EditProjectMultimediaService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jaishreeganesh
 */
public class EditProjectMultimediaModel {

    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private EditProjectMultimediaService editProjectMultimediaService;

    public EditProjectMultimediaModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        editProjectMultimediaService = new EditProjectMultimediaService(manager);
    }

    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editProjectMultimediaService.fetchProjects();
        return projectList;
    }

    public List<MediaAdobe> fetchAdobeFiles(String projectId) {
        List<MediaAdobe> adobeFilesList = editProjectMultimediaService.fetchAdobeFiles(projectId);
        return adobeFilesList;
    }

    public List<MediaCad> fetchCadFiles(String projectId) {
        List<MediaCad> cadFilesList = editProjectMultimediaService.fetchCadFiles(projectId);
        return cadFilesList;
    }

    public List<MediaCode> fetchCodeFiles(String projectId) {
        List<MediaCode> cadFilesList = editProjectMultimediaService.fetchCodeFiles(projectId);
        return cadFilesList;
    }

    public List<MediaPdf> fetchPdfFiles(String projectId) {
        List<MediaPdf> pdfFilesList = editProjectMultimediaService.fetchPdfFiles(projectId);
        return pdfFilesList;
    }

    public List<MediaPhotos> fetchPhotosFiles(String projectId) {
        List<MediaPhotos> photosFilesList = editProjectMultimediaService.fetchPhotosFiles(projectId);
        return photosFilesList;
    }

    public List<MediaPlaintext> fetchPlainTextFiles(String projectId) {
        List<MediaPlaintext> plainTextFilesList = editProjectMultimediaService.fetchPlainTextFiles(projectId);
        return plainTextFilesList;
    }

    public List<MediaSpreadsheet> fetchSpreadsheetFiles(String projectId) {
        List<MediaSpreadsheet> spreadSheetFilesList = editProjectMultimediaService.fetchSpreadsheetFiles(projectId);
        return spreadSheetFilesList;
    }

    public List<MediaVideo> fetchVideoFiles(String projectId) {
        List<MediaVideo> videoFilesList = editProjectMultimediaService.fetchVideoFiles(projectId);
        return videoFilesList;
    }

    public List<MediaWord> fetchWordFiles(String projectId) {
        List<MediaWord> wordFilesList = editProjectMultimediaService.fetchWordFiles(projectId);
        return wordFilesList;
    }

    public boolean updateAdobeFiles(String projectId, List<MediaAdobe> adobeFilesList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updateAdobeFiles(projectId, adobeFilesList);
        usertransaction.commit();
        return success;
    }

    public boolean updateCadFiles(String projectId, List<MediaCad> cadFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updateCadFiles(projectId, cadFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updateCodeFiles(String projectId, List<MediaCode> CodeFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updateCodeFiles(projectId, CodeFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updatePdfFiles(String projectId, List<MediaPdf> PdfFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updatePdfFiles(projectId, PdfFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updatePhotoFiles(String projectId, List<MediaPhotos> PhotoFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updatePhotoFiles(projectId, PhotoFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updatePlainTextFiles(String projectId, List<MediaPlaintext> plainTextFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updatePlainTextFiles(projectId, plainTextFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updateSpreadSheetFiles(String projectId, List<MediaSpreadsheet> spreadFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updateSpreadSheetFiles(projectId, spreadFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updateVideoFiles(String projectId, List<MediaVideo> videoFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updateVideoFiles(projectId, videoFileList);
        usertransaction.commit();
        return success;
    }

    public boolean updateWordFiles(String projectId, List<MediaWord> wordFileList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectMultimediaService.updateWordFiles(projectId, wordFileList);
        usertransaction.commit();
        return success;
    }
}
