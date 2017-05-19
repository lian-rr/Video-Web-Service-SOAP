/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videows.dao;

import com.una.progra.videows.model.Video;

/**
 *
 * @author lirodrig
 */
public interface VideoDao {
    
    public void saveVideo(Video video);
    
    public Video getVideo(String fileName);    
}
