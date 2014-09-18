/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

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
import com.src.frugalinnovationlab.Model.EditProjectMultimediaModel;
import com.src.frugalinnovationlab.view.EditProjectMultimedia;
import java.util.List;

/**
 *
 * @author Jaishreeganesh
 */
public class EditProjectMultimediaController {
    private EditProjectMultimedia gui;
    private EditProjectMultimediaModel editProjectMultimediaModel; 

    public EditProjectMultimediaController(EditProjectMultimedia gui) {
        this.gui = gui;
        editProjectMultimediaModel = new EditProjectMultimediaModel();
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editProjectMultimediaModel.getProjectsFromDatabase();
        return projectList;
    }
    
    public List<MediaAdobe> fetchAdobeFiles(String projectId){
        List<MediaAdobe> adobeFilesList = editProjectMultimediaModel.fetchAdobeFiles(projectId);
        return adobeFilesList;
    }
    
    public List<MediaCad> fetchCadFiles(String projectId){
        List<MediaCad> cadFilesList = editProjectMultimediaModel.fetchCadFiles(projectId);
        return cadFilesList;
    }
    
    public List<MediaCode> fetchCodeFiles(String projectId){
        List<MediaCode> cadFilesList = editProjectMultimediaModel.fetchCodeFiles(projectId);
        return cadFilesList;
    }
    
    public List<MediaPdf> fetchPdfFiles(String projectId){
        List<MediaPdf> pdfFilesList = editProjectMultimediaModel.fetchPdfFiles(projectId);
        return pdfFilesList;
    }
    
    public List<MediaPhotos> fetchPhotosFiles(String projectId){
        List<MediaPhotos> photosFilesList = editProjectMultimediaModel.fetchPhotosFiles(projectId);
        return photosFilesList;
    }
    
    public List<MediaPlaintext> fetchPlainTextFiles(String projectId){
        List<MediaPlaintext> plainTextFilesList = editProjectMultimediaModel.fetchPlainTextFiles(projectId);
        return plainTextFilesList;
    }
    
    public List<MediaSpreadsheet> fetchSpreadsheetFiles(String projectId){
        List<MediaSpreadsheet> spreadSheetFilesList = editProjectMultimediaModel.fetchSpreadsheetFiles(projectId);
        return spreadSheetFilesList;
    }
    
    public List<MediaVideo> fetchVideoFiles(String projectId){
        List<MediaVideo> videoFilesList = editProjectMultimediaModel.fetchVideoFiles(projectId);
        return videoFilesList;
    }
    
    public List<MediaWord> fetchWordFiles(String projectId){
        List<MediaWord> wordFilesList = editProjectMultimediaModel.fetchWordFiles(projectId);
        return wordFilesList;
    }
    
    public boolean updateAdobeFiles(String projectId, List<MediaAdobe> adobeFilesList){
        boolean success = false;
        success = editProjectMultimediaModel.updateAdobeFiles(projectId, adobeFilesList);
        return success;
    }
    
    public boolean updateCadFiles(String projectId, List<MediaCad> CadFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updateCadFiles(projectId, CadFileList);
        return success;
    }
    
    public boolean updateCodeFiles(String projectId, List<MediaCode> CodeFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updateCodeFiles(projectId, CodeFileList);
        return success;
    }
    
    public boolean updatePdfFiles(String projectId, List<MediaPdf> PdfFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updatePdfFiles(projectId, PdfFileList);
        return success;
    }
    
    public boolean updatePhotoFiles(String projectId, List<MediaPhotos> PhotoFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updatePhotoFiles(projectId, PhotoFileList);
        return success;
    }
    
    public boolean updatePlainTextFiles(String projectId, List<MediaPlaintext> plainTextFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updatePlainTextFiles(projectId, plainTextFileList);
        return success;
    }
    
    public boolean updateSpreadSheetFiles(String projectId, List<MediaSpreadsheet> spreadFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updateSpreadSheetFiles(projectId, spreadFileList);
        return success;
    }
    
    public boolean updateVideoFiles(String projectId, List<MediaVideo> videoFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updateVideoFiles(projectId, videoFileList);
        return success;
    }
    
    public boolean updateWordFiles(String projectId, List<MediaWord> wordFileList){
        boolean success = false;
        success = editProjectMultimediaModel.updateWordFiles(projectId, wordFileList);
        return success;
    }
    
}
