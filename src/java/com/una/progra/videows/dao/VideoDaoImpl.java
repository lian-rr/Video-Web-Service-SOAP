/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videows.dao;

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

    @Override
    public void saveVideo(Video video) {
        String filePath = "c:/repository" + File.separator + video.getName();
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(video.getVideo());
            outputStream.close();

            System.out.println("File saved in: " + filePath);

        } catch (IOException ex) {
            Logger.getLogger(VideoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }

    @Override
    public Video getVideo(String fileName) {
        String filePath = "c:/repository" + File.separator + fileName;
        System.out.println("Sending file: " + filePath);
        try {
            //lee el archivo del repositorio
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
                       
            return new Video(fileName,fileBytes,"xxx","yyy");
            
        } catch (IOException ex) {
            Logger.getLogger(VideoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }

}
