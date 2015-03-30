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
import java.util.ArrayList;

import API.APICall;
import API.APIResponse;

 public class ServerWorkout {
    
    private String Auth;
    private String Error;
    private ArrayList<ServerWorkoutResponse> WorkoutObj = new ArrayList<ServerWorkoutResponse>();
    
    public ServerWorkout(String auth){
        this.Auth = auth;
    }
    
    
    public boolean workout(int workout) throws Exception{
        
       APICall Request = new APICall("GET","/workout/"+workout);
       Request.SetUser(Auth);
       APIResponse Response = Request.exec();
       if(Response.isSuccess()){
           
           
                      
           JSONArray array = (JSONArray)Response.getJson().getJSONArray("workout");
           for(int i = 0; i < array.length(); i++)
           {
             ServerWorkoutResponse workoutresponse = new ServerWorkoutResponse();  
             JSONObject element = array.getJSONObject(i);
             
             workoutresponse.Exercise = element.getInt("Exercise");
             workoutresponse.Reps = element.getInt("Reps");
             workoutresponse.Sets = element.getInt("Sets");
             
             this.WorkoutObj.add(workoutresponse);
           
           }
           
           return true;
       } else {
           Error = Response.getError();
           return false;
       }     
        
    }
    
    public boolean complete(int workout) throws Exception {
        
        APICall Request = new APICall("POST","/workout/"+workout+"/complete");
       Request.SetUser(Auth);
       APIResponse Response = Request.exec();
       if(Response.isSuccess()){
           return true;
       } else {
           Error = Response.getError();
           return false;
       }     
        
    }
    
     // Getters/Setters
    
    public String getError(){
        return Error;
    }
    
    public ArrayList<ServerWorkoutResponse> getWorkout(){
        return WorkoutObj;
    }
    
    
    
}
