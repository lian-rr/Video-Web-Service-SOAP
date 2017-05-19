/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videows;

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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "upload")
    public boolean upload(@WebParam(name = "fileName") String fileName, @WebParam(name = "video") byte[] video, @WebParam(name = "course") String course, @WebParam(name = "user") String user) {
        
        byte[] testVideo = "this test is going to be an byte[]".getBytes();
                
        VideoDao videoDao = new VideoDaoImpl();
        try{
            Video newVideo = new Video(fileName, testVideo, course, user);            
            videoDao.saveVideo(newVideo);
            return true;
        }
        catch(Exception ex){
            System.err.println(ex);
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "download")
    public byte[] download(@WebParam(name = "fileName") String fileName) {
        VideoDao videoDao = new VideoDaoImpl();
        try{
            return videoDao.getVideo(fileName).getVideo();            
        }
        catch(Exception ex){
            System.err.println(ex);           
        }
        
        return null;
    }
}
