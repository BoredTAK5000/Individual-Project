package com.example.individual_project;

import java.util.Timer;
import java.util.TimerTask;

import java.sql.*;

public class Stop_Clock { // Stop clock is used to get the usernames of the players

    int i;

    String Query;

    Timer timer = new Timer();

    SQL_Controller s = new SQL_Controller();

    ResultSet rs;

    String[] Username = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println(i);
            i++;
            try {
                rs = s.Get_Data(Query);
                rs.next();
                for(int i = 0; i < Username.length; i++){
                    try{
                        Username[i] = rs.getString("Usernames");
                        rs.next();
                    }
                    catch (Exception e){
                        if (e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                            for (int j = 0; j < Username.length; j++){
                                if ((Username[j].equals(""))){
                                    Username[j] = "________";
                                }
                            }
                        }
                        else{
                            System.out.println(e);
                        }
                    }
                }

                HelloController.Set_Players_List_Lables(Username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public void Start(String query){
        Query = query;
        set_i(0);
        timer.schedule(task, 0 , 1);
    }

    public void Stop(){
        timer.cancel();
    }

    void set_i(int j){
        i = j;
    }
}
