/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.dto;

/**
 *
 * @author lian
 */
public class VideoDTO {
    private boolean status;
    private String id;

    public VideoDTO() {
    }

    public VideoDTO(boolean status, String id) {
        this.status = status;
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
