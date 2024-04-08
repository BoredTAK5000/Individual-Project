package com.example.individual_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    Timer timer = new Timer();

    SQL_Controller s = new SQL_Controller();

    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            String q = "SELECT * WHERE Role = WEREWOLF";
            try {
                ResultSet rs = s.Get_Data(q);
                rs.next();
                boolean Cont = true;

                try{

                    while(true){
                        if (rs.getInt("Voted") == 0){
                            Cont = false;
                        }
                        rs.next();
                    }

                }
                catch (Exception e){
                    if(e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                        if (Cont){
                            timer.cancel();
                        }
                    }
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };


    public void runTimer(){
        timer.schedule(task1, 0, 1);
    }

    Clock(int option){
        if (option == 1){
            runTimer();
        }
    }
}
