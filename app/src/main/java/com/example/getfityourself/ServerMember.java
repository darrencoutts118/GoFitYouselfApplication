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

import java.util.ArrayList;
import org.json.*;

import API.APICall;
import API.APIResponse;

public class ServerMember {
    
    private String Error;
    private String Auth; 
    
    public ServerMember(){
    	;
    }
    
    public ServerMember(String Userhash){
        Auth = Userhash;
    }
    
    
    public boolean setSlots(ArrayList<ServerScheduleSlot> slots) throws Exception{
        
        JSONArray array = new JSONArray();
        
        for(int i = 0; i < slots.size(); i++)
           {
               array.put(slots.get(i));
           }
        
       APICall Request = new APICall("POST","/members/me/slots");
       Request.SetUser(Auth);
       Request.addParameter("Slots", array.toString());
       APIResponse Response = Request.exec();
       if(Response.isSuccess()){
           return true;
       } else {
           Error = Response.getError();
           return false;
       }       
        
    }
    
    public boolean create(String Username, String Firstname, String Lastname, String Password, String Email) throws Exception{

    	APICall Request = new APICall("POST","/members");
        Request.addParameter("Username", Username);
        Request.addParameter("Firstname", Firstname);
        Request.addParameter("Lastname", Lastname);
        Request.addParameter("Password", Password);
        Request.addParameter("Email", Email);
        APIResponse Response = Request.exec();

        System.out.println(Response);

        if(Response.isSuccess()){
            return true;
        } else {
            Error = Response.getError();
            return false;
        }       
    	
    	
    }
    
    public boolean updateTargets(){
    	return true;
    }
    
    public String getError(){
    	return Error;
    }
    
    
}
