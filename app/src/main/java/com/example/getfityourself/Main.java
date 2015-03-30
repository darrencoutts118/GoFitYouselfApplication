package com.example.getfityourself;

import API.*;
import java.lang.System;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		
            ServerAuthentication auth = new ServerAuthentication();
            if(auth.login("Username123456","Password")){
                System.out.println(auth.AuthorizationKey);
            } else {
                System.out.println(auth.getError());
            }
            
            ServerSchedule schedule = new ServerSchedule("123456");
            if(schedule.current()){
                ArrayList<ServerScheduleResponse> CurrentSchedule = schedule.getCurrent();
            } else {
                System.out.println(schedule.getError());
            }
            
            ServerWorkout workout = new ServerWorkout("123456");
            if(workout.workout(123)){
                System.out.print(workout.getWorkout());
            }
            workout.complete(123);
            
            
            ServerExercise excercise = new ServerExercise("123456");
            if(excercise.exercise(12)){
                System.out.print(excercise.getExercise());
            } else {
                System.out.print(excercise.getError());
            }
            
            ServerMember member = new ServerMember("hello");
            ArrayList<ServerScheduleSlot> slots = new ArrayList<ServerScheduleSlot>();
            
            ServerScheduleSlot a = new ServerScheduleSlot(1,"12:00",60);
            ServerScheduleSlot b = new ServerScheduleSlot(5,"12:30",90);
            
            slots.add(a);
            slots.add(b);
            
            member.setSlots(slots);
            
            ServerMember member2 = new ServerMember();

            
            member2.create("darrencoutts","Darren","Coutts","password","darren.coutts@interhubdigital.com");
            
        }
	
}
