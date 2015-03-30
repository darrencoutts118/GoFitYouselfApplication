package com.example.getfityourself;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import API.APICall;
import API.APIResponse;

/**
 *
 * @author darren
 */


public class ServerAuthentication {
    
    public String AuthorizationKey;
    private String Error;
    
    // Public Call Methods
    
    public boolean login(String username, String password) throws Exception{
        
       APICall Request = new APICall("POST","/auth/login");
       Request.addParameter("username", username);
       Request.addParameter("password", password);
       
       APIResponse Response = Request.exec();
       if(Response.isSuccess()){
           AuthorizationKey = Response.getJson().getString("UserHash");
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
    
}
