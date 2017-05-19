/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videows.model;

/**
 *
 * @author lirodrig
 */
public class Video {
    
    private String name;
    private byte[] video;
    private String course;
    private String user;

    public Video(String name, byte[] video, String course, String user) {
        this.name = name;
        this.video = video;
        this.course = course;
        this.user = user;
    }   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
