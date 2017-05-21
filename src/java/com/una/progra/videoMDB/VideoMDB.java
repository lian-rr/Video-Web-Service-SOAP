/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.progra.videoMDB;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.una.progra.dto.VideoDTO;
import com.una.progra.videows.model.Video;
import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

public class VideoMDB {
    
    
    private MongoClient mongo;
    
    private MongoDatabase db;
    
    private MongoCollection<Document> videos;
    
    private static VideoMDB instance;

    

    public static VideoMDB getInstance(){
        if(instance == null)
            instance = new VideoMDB();        
        return instance;
    }
    
    public VideoDTO saveVideo(String path, Video video){
        mongo = new MongoClient("localhost",27017);
        db = mongo.getDatabase("elearning");
        videos = db.getCollection("video");
        Document document = new Document();
        try{
            document.put("name", video.getName());
            document.put("path", path);
            document.put("course", video.getCourse());
            document.put("user", video.getUser());
            this.videos.insertOne(document);
            return new VideoDTO(true, document.get("_id").toString());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            mongo.close();
        }
    }
    
    public Video readVideo(String videoId){
        mongo = new MongoClient("localhost",27017);
        db = mongo.getDatabase("elearning");
        videos = db.getCollection("video");        
        
        ObjectId id = new ObjectId(videoId);
        
        BasicDBObject searchQuery = new BasicDBObject();
        Video video = new Video();
        try{
            
            searchQuery.put("_id", id);
            Document myDoc = videos.find(searchQuery).first();
            video.setName(myDoc.get("name").toString());
            video.setPath(myDoc.get("path").toString());
            return video;
            
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            mongo.close();
        }
    }
    
    
}
