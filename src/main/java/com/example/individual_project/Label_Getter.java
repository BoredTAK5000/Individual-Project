package com.example.individual_project;

import javafx.scene.control.Label;

public class Label_Getter {

    Label_Getter(String[] Usernames, String Screen){
        Lable_Getter(Usernames, Screen);
    }

    void Lable_Getter(String[] Usernames, String Screen){
        Label[] Lables = HelloController.Get_Lables(Screen);
        for (int i = 0; i < Usernames.length; i++){
            Label j = Lables[i];
            j.setText(Usernames[i]);
        }
    }
}
