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

public class ServerSchedule {
    
    private String Auth;
    private String Error;
    private ArrayList<ServerScheduleResponse> Current = new ArrayList<ServerScheduleResponse>();
    
    public ServerSchedule(String auth){
        this.Auth = auth;
    }
    
    public boolean create() throws Exception{
        
       APICall Request = new APICall("POST","/schedule/create");
       Request.SetUser(Auth);
       APIResponse Response = Request.exec();
       if(Response.isSuccess()){
           return true;
       } else {
           Error = Response.getError();
           return false;
       }       
        
    }
    
     public boolean current() throws Exception{
        
       APICall Request = new APICall("GET","/schedule/current");
       Request.SetUser(Auth);
       APIResponse Response = Request.exec();
       if(Response.isSuccess()){
                      
           JSONArray array = (JSONArray)Response.getJson().getJSONArray("schedule");
           for(int i = 0; i < array.length(); i++)
           {
             ServerScheduleResponse scheduleresponse = new ServerScheduleResponse();  
             JSONObject element = array.getJSONObject(i);
             
             scheduleresponse.Day = element.getInt("Day");
             scheduleresponse.Startime = element.getString("StartTime");
             scheduleresponse.Workout = element.getInt("Workout");
             
             this.Current.add(scheduleresponse);
           }
           
           return true;
       } else {
           Error = Response.getError();
           return false;
       }       
        
    }
    
    
    public ArrayList<ServerScheduleResponse> getCurrent(){
        return Current;
    }
    
    // Getters/Setters
    
    public String getError(){
        return Error;
    }
    
    
    
}
