package com.example.individual_project;

import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Chat {

    Timer t = new Timer();

    SQL_Controller s = new SQL_Controller();

    String q;

    Label L;

    TimerTask task = new TimerTask() {
        @Override
        public void run() {// get chat and set a label to be the chat
            try {
                ResultSet rs = s.Get_Data(q);
                rs.next();
                String s = rs.getString("Chat");
                L.setText(s);
            } catch (SQLException e) {
                if(!e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                    throw new RuntimeException(e);
                }
            }
        }
    };

    Chat(String Game_Code, Label l){
        q = "SELECT * FROM " +Game_Code+ "_Chat";
        L = l;
        Start();
    }

    void Start(){
        t.schedule(task, 0, 1);
    }

}
