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

public class ServerScheduleSlot {

    private int Day; 
    private String Time; 
    private int Duration; 
    
    
    public ServerScheduleSlot(int D, String T, int Dur){
        Day = D; 
        Time = T; 
        Duration = Dur;
    }
    
    public String toString(){
        
        JSONObject json = new JSONObject();
        try {
			json.put("Day", Day).put("Time",Time).put("Duration",Duration);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return json.toString();
        
    }
    
}
