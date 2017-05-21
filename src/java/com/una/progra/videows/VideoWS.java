/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videows;

import com.una.progra.dto.VideoDTO;
import com.una.progra.videows.dao.VideoDao;
import com.una.progra.videows.dao.VideoDaoImpl;
import com.una.progra.videows.model.Video;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author lirodrig
 */
@WebService(serviceName = "VideoWS")
@Stateless()
public class VideoWS {   
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "upload")
    public VideoDTO upload(@WebParam(name = "fileName") String fileName, @WebParam(name = "video") byte[] video, @WebParam(name = "course") int course, @WebParam(name = "user") int user) {
        
//        byte[] testVideo = "this test is going to be an byte[]".getBytes();
                
        VideoDao videoDao = new VideoDaoImpl();
        try{
            Video newVideo = new Video(fileName, video, course, user, fileName);            
            return videoDao.saveVideo(newVideo);
            
        }
        catch(Exception ex){
            System.err.println(ex);
            return new VideoDTO(false, ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "download")
    public byte[] download(@WebParam(name = "fileName") String videoId) {
        VideoDao videoDao = new VideoDaoImpl();
        try{
            return videoDao.getVideo(videoId).getVideo();            
        }
        catch(Exception ex){
            System.err.println(ex);           
        }
        
        return null;
    }
}
