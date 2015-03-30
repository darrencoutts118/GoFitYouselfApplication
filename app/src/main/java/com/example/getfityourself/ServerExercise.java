package com.example.getfityourself;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darren
 */

import org.json.*;

import API.APICall;
import API.APIResponse;

public class ServerExercise {
    
    private String Error; 
    private String Auth; 
    private ServerExerciseResponse Current = new ServerExerciseResponse();
    
    public ServerExercise(String AuthHash){
        Auth = AuthHash;
    }
    
    public boolean exercise(int excersiseID) throws Exception{
        
       APICall Request = new APICall("GET","/excercise/"+excersiseID);
       Request.SetUser(Auth);
       APIResponse Response = Request.exec();
       
       if(Response.isSuccess()){
           
           JSONObject json = Response.getJson();
           Current.Name = json.getString("Name");
           Current.Description = json.getString("Description");
           Current.ImageURL = json.getString("ImageURL");
           
           return true; 
       } else {
           Error = Response.getError();
           return false;
       }
        
    }
    
    public boolean rate(int excersiseID, int rating) throws Exception{
        
       APICall Request = new APICall("POST","/excercise/"+excersiseID+"/rate");
       Request.SetUser(Auth);
       Request.addParameter("Rating", Integer.toString(rating));
       APIResponse Response = Request.exec();
       
       if(Response.isSuccess()){
           return true; 
       } else {
           Error = Response.getError();
           return false;
       }
        
    }
    
    
    public ServerExerciseResponse getExercise(){
        return Current;
    }
    
    public String getError(){
        return Error;
    }
    
}
