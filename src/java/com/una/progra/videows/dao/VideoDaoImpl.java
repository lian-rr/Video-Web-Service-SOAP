/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videows.dao;

import com.una.progra.dto.VideoDTO;
import com.una.progra.videoMDB.VideoMDB;
import com.una.progra.videows.model.Video;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author lirodrig
 */
public class VideoDaoImpl implements VideoDao {
    
    protected String OS = System.getProperty("os.name").toLowerCase();

    @Override
    public VideoDTO saveVideo(Video video) {
        
        String path = video.getName();
        
        String filePath = ((OS.indexOf("win") >= 0)?"c:/repository":"/var/www/html/repository") + File.separator + path;
        
        VideoDTO videoDTO = VideoMDB.getInstance().saveVideo(path, video);
            
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(video.getVideo());
            outputStream.close();

            System.out.println("File saved in: " + filePath);
            return videoDTO;

        } catch (IOException ex) {
            Logger.getLogger(VideoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }

    @Override
    public Video getVideo(String videoId) {
        
        Video video = VideoMDB.getInstance().readVideo(videoId);
        
        String filePath = ((OS.indexOf("win") >= 0)?"c:/repository":"/var/www/html/repository") + File.separator + video.getPath();
        
        System.out.println("Sending file: " + filePath);
        try {
            //lee el archivo del repositorio
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
            
            video.setVideo(fileBytes);
            return video;
            
        } catch (IOException ex) {
            Logger.getLogger(VideoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }

}
