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
    private int course;
    private int user;
    private String path;

    public Video() {
    }
    
    
    public Video(String name, byte[] video, int course, int user, String path) {
        this.name = name;
        this.video = video;
        this.course = course;
        this.user = user;
        this.path = path;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
    
}
