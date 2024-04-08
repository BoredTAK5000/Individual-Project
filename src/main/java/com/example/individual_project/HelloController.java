package com.example.individual_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import java.sql.*;

public class HelloController {


    //------------------------------------------------------------------------------------------------------------
    //-- Misc ----------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    String[] Usernames;

    Stop_Clock Request_Clock;

    private Stage Stage;

    private Scene Scene;

    private Parent Root;

    String Currently_Signed_In_Username;

    String Currently_Signed_In_Password;

    String Currently_Signed_In_Role;

    Game g;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Welcome Screen ------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    @FXML
    private Label welcomeText;

    @FXML
    private TextField Entered_Username;

    @FXML
    private PasswordField Entered_Password;

    @FXML
    private Button Go_To_Create_Account_Button;

    @FXML
    private Button Sign_In_Button;

    //------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------
    //-- Create Account Screen -----------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Create_Account_Button;

    @FXML
    private PasswordField New_Account_Entered_Confirm_Password;

    @FXML
    private PasswordField New_Account_Entered_Password;

    @FXML
    private TextField New_Account_Entered_Username;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Join Game -----------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Go_To_Host_Game_Button;

    @FXML
    private Button Join_Game_Button;

    @FXML
    private TextField Join_Game_Code;

    @FXML
    private Button Sign_Out_Button;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Host Game -----------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Label Game_Code;

    @FXML
    private Button Host_Game_Back_Button;

    @FXML
    private CheckBox Biomancer_There;

    @FXML
    private CheckBox Inquisitor_There;

    @FXML
    private CheckBox Vampire_There;

    @FXML
    private static Label Player1;

    @FXML
    private static Label Player10;

    @FXML
    private static Label Player11;

    @FXML
    private static Label Player12;

    @FXML
    private static Label Player13;

    @FXML
    private static Label Player14;

    @FXML
    private static Label Player15;

    @FXML
    private static Label Player16;

    @FXML
    private static Label Player17;

    @FXML
    private static Label Player18;

    @FXML
    private static Label Player19;

    @FXML
    private static Label Player2;

    @FXML
    private static Label Player20;

    @FXML
    private static Label Player3;

    @FXML
    private static Label Player4;

    @FXML
    private static Label Player5;

    @FXML
    private static Label Player6;

    @FXML
    private static Label Player7;

    @FXML
    private static Label Player8;

    @FXML
    private static Label Player9;

    @FXML
    private Button Start_Game_Button;

    //------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------
    //-- Werewolf night Voting Screen ----------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton Werewolf_Night_Button1;

    @FXML
    private RadioButton Werewolf_Night_Button10;

    @FXML
    private RadioButton Werewolf_Night_Button11;

    @FXML
    private RadioButton Werewolf_Night_Button12;

    @FXML
    private RadioButton Werewolf_Night_Button13;

    @FXML
    private RadioButton Werewolf_Night_Button14;

    @FXML
    private RadioButton Werewolf_Night_Button15;

    @FXML
    private RadioButton Werewolf_Night_Button16;

    @FXML
    private RadioButton Werewolf_Night_Button17;

    @FXML
    private RadioButton Werewolf_Night_Button18;

    @FXML
    private RadioButton Werewolf_Night_Button19;

    @FXML
    private RadioButton Werewolf_Night_Button2;

    @FXML
    private RadioButton Werewolf_Night_Button20;

    @FXML
    private RadioButton Werewolf_Night_Button3;

    @FXML
    private RadioButton Werewolf_Night_Button4;

    @FXML
    private RadioButton Werewolf_Night_Button5;

    @FXML
    private RadioButton Werewolf_Night_Button6;

    @FXML
    private RadioButton Werewolf_Night_Button7;

    @FXML
    private RadioButton Werewolf_Night_Button8;

    @FXML
    private RadioButton Werewolf_Night_Button9;

    @FXML
    private ToggleGroup Werewolf_Night_Vote;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username1;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username10;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username11;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username12;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username13;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username14;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username15;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username16;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username17;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username18;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username19;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username2;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username20;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username3;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username4;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username5;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username6;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username7;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username8;

    @FXML
    private static Label Werewolf_Night_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Werewolf Day Voting Screen ------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton Werewolf_Day_Button1;

    @FXML
    private RadioButton Werewolf_Day_Button10;

    @FXML
    private RadioButton Werewolf_Day_Button11;

    @FXML
    private RadioButton Werewolf_Day_Button12;

    @FXML
    private RadioButton Werewolf_Day_Button13;

    @FXML
    private RadioButton Werewolf_Day_Button14;

    @FXML
    private RadioButton Werewolf_Day_Button15;

    @FXML
    private RadioButton Werewolf_Day_Button16;

    @FXML
    private RadioButton Werewolf_Day_Button17;

    @FXML
    private RadioButton Werewolf_Day_Button18;

    @FXML
    private RadioButton Werewolf_Day_Button19;

    @FXML
    private RadioButton Werewolf_Day_Button2;

    @FXML
    private RadioButton Werewolf_Day_Button20;

    @FXML
    private RadioButton Werewolf_Day_Button3;

    @FXML
    private RadioButton Werewolf_Day_Button4;

    @FXML
    private RadioButton Werewolf_Day_Button5;

    @FXML
    private RadioButton Werewolf_Day_Button6;

    @FXML
    private RadioButton Werewolf_Day_Button7;

    @FXML
    private RadioButton Werewolf_Day_Button8;

    @FXML
    private RadioButton Werewolf_Day_Button9;

    @FXML
    private ToggleGroup Werewolf_Day_Vote;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username1;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username10;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username11;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username12;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username13;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username14;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username15;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username16;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username17;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username18;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username19;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username2;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username20;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username3;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username4;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username5;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username6;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username7;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username8;

    @FXML
    private static Label Werewolf_Day_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Villager Day Voting Screen ------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton Villager_Day_Button1;

    @FXML
    private RadioButton Villager_Day_Button10;

    @FXML
    private RadioButton Villager_Day_Button11;

    @FXML
    private RadioButton Villager_Day_Button12;

    @FXML
    private RadioButton Villager_Day_Button13;

    @FXML
    private RadioButton Villager_Day_Button14;

    @FXML
    private RadioButton Villager_Day_Button15;

    @FXML
    private RadioButton Villager_Day_Button16;

    @FXML
    private RadioButton Villager_Day_Button17;

    @FXML
    private RadioButton Villager_Day_Button18;

    @FXML
    private RadioButton Villager_Day_Button19;

    @FXML
    private RadioButton Villager_Day_Button2;

    @FXML
    private RadioButton Villager_Day_Button20;

    @FXML
    private RadioButton Villager_Day_Button3;

    @FXML
    private RadioButton Villager_Day_Button4;

    @FXML
    private RadioButton Villager_Day_Button5;

    @FXML
    private RadioButton Villager_Day_Button6;

    @FXML
    private RadioButton Villager_Day_Button7;

    @FXML
    private RadioButton Villager_Day_Button8;

    @FXML
    private RadioButton Villager_Day_Button9;

    @FXML
    private ToggleGroup Villager_Day_Vote;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username1;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username10;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username11;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username12;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username13;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username14;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username15;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username16;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username17;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username18;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username19;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username2;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username20;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username3;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username4;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username5;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username6;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username7;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username8;

    @FXML
    private static Label Villager_Day_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Bimancer Swap Screen ------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Label Biomancer_Swap_Error_Message;

    @FXML
    private static Label Biomancer_Swap_Screen_Username1;

    @FXML
    private static Label Biomancer_Swap_Screen_Username10;

    @FXML
    private static Label Biomancer_Swap_Screen_Username11;

    @FXML
    private static Label Biomancer_Swap_Screen_Username12;

    @FXML
    private static Label Biomancer_Swap_Screen_Username13;

    @FXML
    private static Label Biomancer_Swap_Screen_Username14;

    @FXML
    private static Label Biomancer_Swap_Screen_Username15;

    @FXML
    private static Label Biomancer_Swap_Screen_Username16;

    @FXML
    private static Label Biomancer_Swap_Screen_Username17;

    @FXML
    private static Label Biomancer_Swap_Screen_Username18;

    @FXML
    private static Label Biomancer_Swap_Screen_Username19;

    @FXML
    private static Label Biomancer_Swap_Screen_Username2;

    @FXML
    private static Label Biomancer_Swap_Screen_Username20;

    @FXML
    private static Label Biomancer_Swap_Screen_Username3;

    @FXML
    private static Label Biomancer_Swap_Screen_Username4;

    @FXML
    private static Label Biomancer_Swap_Screen_Username5;

    @FXML
    private static Label Biomancer_Swap_Screen_Username6;

    @FXML
    private static Label Biomancer_Swap_Screen_Username7;

    @FXML
    private static Label Biomancer_Swap_Screen_Username8;

    @FXML
    private static Label Biomancer_Swap_Screen_Username9;

    @FXML
    private CheckBox Biomancer_Swap_Username1;

    @FXML
    private CheckBox Biomancer_Swap_Username10;

    @FXML
    private CheckBox Biomancer_Swap_Username11;

    @FXML
    private CheckBox Biomancer_Swap_Username12;

    @FXML
    private CheckBox Biomancer_Swap_Username13;

    @FXML
    private CheckBox Biomancer_Swap_Username14;

    @FXML
    private CheckBox Biomancer_Swap_Username15;

    @FXML
    private CheckBox Biomancer_Swap_Username16;

    @FXML
    private CheckBox Biomancer_Swap_Username17;

    @FXML
    private CheckBox Biomancer_Swap_Username18;

    @FXML
    private CheckBox Biomancer_Swap_Username19;

    @FXML
    private CheckBox Biomancer_Swap_Username2;

    @FXML
    private CheckBox Biomancer_Swap_Username20;

    @FXML
    private CheckBox Biomancer_Swap_Username3;

    @FXML
    private CheckBox Biomancer_Swap_Username4;

    @FXML
    private CheckBox Biomancer_Swap_Username5;

    @FXML
    private CheckBox Biomancer_Swap_Username6;

    @FXML
    private CheckBox Biomancer_Swap_Username7;

    @FXML
    private CheckBox Biomancer_Swap_Username8;

    @FXML
    private CheckBox Biomancer_Swap_Username9;

    @FXML
    private Button Swap_Button;

    //------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------
    //-- Vampire Night Voting Screen -----------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton Vampire_Night_Button1;

    @FXML
    private RadioButton Vampire_Night_Button10;

    @FXML
    private RadioButton Vampire_Night_Button11;

    @FXML
    private RadioButton Vampire_Night_Button12;

    @FXML
    private RadioButton Vampire_Night_Button13;

    @FXML
    private RadioButton Vampire_Night_Button14;

    @FXML
    private RadioButton Vampire_Night_Button15;

    @FXML
    private RadioButton Vampire_Night_Button16;

    @FXML
    private RadioButton Vampire_Night_Button17;

    @FXML
    private RadioButton Vampire_Night_Button18;

    @FXML
    private RadioButton Vampire_Night_Button19;

    @FXML
    private RadioButton Vampire_Night_Button2;

    @FXML
    private RadioButton Vampire_Night_Button20;

    @FXML
    private RadioButton Vampire_Night_Button3;

    @FXML
    private RadioButton Vampire_Night_Button4;

    @FXML
    private RadioButton Vampire_Night_Button5;

    @FXML
    private RadioButton Vampire_Night_Button6;

    @FXML
    private RadioButton Vampire_Night_Button7;

    @FXML
    private RadioButton Vampire_Night_Button8;

    @FXML
    private RadioButton Vampire_Night_Button9;

    @FXML
    private ToggleGroup Vampire_Night_Vote;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username1;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username10;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username11;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username12;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username13;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username14;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username15;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username16;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username17;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username18;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username19;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username2;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username20;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username3;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username4;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username5;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username6;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username7;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username8;

    @FXML
    private static Label Vampire_Night_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------
    //-- Vampire Day Voting Screen -------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton Vampire_Day_Button1;

    @FXML
    private RadioButton Vampire_Day_Button10;

    @FXML
    private RadioButton Vampire_Day_Button11;

    @FXML
    private RadioButton Vampire_Day_Button12;

    @FXML
    private RadioButton Vampire_Day_Button13;

    @FXML
    private RadioButton Vampire_Day_Button14;

    @FXML
    private RadioButton Vampire_Day_Button15;

    @FXML
    private RadioButton Vampire_Day_Button16;

    @FXML
    private RadioButton Vampire_Day_Button17;

    @FXML
    private RadioButton Vampire_Day_Button18;

    @FXML
    private RadioButton Vampire_Day_Button19;

    @FXML
    private RadioButton Vampire_Day_Button2;

    @FXML
    private RadioButton Vampire_Day_Button20;

    @FXML
    private RadioButton Vampire_Day_Button3;

    @FXML
    private RadioButton Vampire_Day_Button4;

    @FXML
    private RadioButton Vampire_Day_Button5;

    @FXML
    private RadioButton Vampire_Day_Button6;

    @FXML
    private RadioButton Vampire_Day_Button7;

    @FXML
    private RadioButton Vampire_Day_Button8;

    @FXML
    private RadioButton Vampire_Day_Button9;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username1;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username10;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username11;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username12;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username13;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username14;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username15;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username16;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username17;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username18;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username19;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username2;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username20;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username3;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username4;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username5;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username6;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username7;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username8;

    @FXML
    private static Label Vampire_Day_Voting_Screen_Username9;

    @FXML
    private ToggleGroup Vampire_Day_Vote;

    //------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------
    //-- Inquisitor Day Voting -----------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Label Inquisitor_Day_Error_Message;

    @FXML
    private RadioButton Inquisitor_Day_Button1;

    @FXML
    private RadioButton Inquisitor_Day_Button10;

    @FXML
    private RadioButton Inquisitor_Day_Button11;

    @FXML
    private RadioButton Inquisitor_Day_Button12;

    @FXML
    private RadioButton Inquisitor_Day_Button13;

    @FXML
    private RadioButton Inquisitor_Day_Button14;

    @FXML
    private RadioButton Inquisitor_Day_Button15;

    @FXML
    private RadioButton Inquisitor_Day_Button16;

    @FXML
    private RadioButton Inquisitor_Day_Button17;

    @FXML
    private RadioButton Inquisitor_Day_Button18;

    @FXML
    private RadioButton Inquisitor_Day_Button19;

    @FXML
    private RadioButton Inquisitor_Day_Button2;

    @FXML
    private RadioButton Inquisitor_Day_Button20;

    @FXML
    private RadioButton Inquisitor_Day_Button3;

    @FXML
    private RadioButton Inquisitor_Day_Button4;

    @FXML
    private RadioButton Inquisitor_Day_Button5;

    @FXML
    private RadioButton Inquisitor_Day_Button6;

    @FXML
    private RadioButton Inquisitor_Day_Button7;

    @FXML
    private RadioButton Inquisitor_Day_Button8;

    @FXML
    private RadioButton Inquisitor_Day_Button9;

    @FXML
    private ToggleGroup Inquisitor_Day_Vote;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username1;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username10;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username11;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username12;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username13;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username14;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username15;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username16;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username17;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username18;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username19;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username2;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username20;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username3;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username4;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username5;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username6;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username7;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username8;

    @FXML
    private static Label Inquisitor_Day_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------
    //-- Biomancer Vote Day --------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Label Biomancer_Day_Error_Message;

    @FXML
    private RadioButton Biomancer_Day_Button1;

    @FXML
    private RadioButton Biomancer_Day_Button10;

    @FXML
    private RadioButton Biomancer_Day_Button11;

    @FXML
    private RadioButton Biomancer_Day_Button12;

    @FXML
    private RadioButton Biomancer_Day_Button13;

    @FXML
    private RadioButton Biomancer_Day_Button14;

    @FXML
    private RadioButton Biomancer_Day_Button15;

    @FXML
    private RadioButton Biomancer_Day_Button16;

    @FXML
    private RadioButton Biomancer_Day_Button17;

    @FXML
    private RadioButton Biomancer_Day_Button18;

    @FXML
    private RadioButton Biomancer_Day_Button19;

    @FXML
    private RadioButton Biomancer_Day_Button2;

    @FXML
    private RadioButton Biomancer_Day_Button20;

    @FXML
    private RadioButton Biomancer_Day_Button3;

    @FXML
    private RadioButton Biomancer_Day_Button4;

    @FXML
    private RadioButton Biomancer_Day_Button5;

    @FXML
    private RadioButton Biomancer_Day_Button6;

    @FXML
    private RadioButton Biomancer_Day_Button7;

    @FXML
    private RadioButton Biomancer_Day_Button8;

    @FXML
    private RadioButton Biomancer_Day_Button9;

    @FXML
    private ToggleGroup Biomancer_Day_Vote;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username1;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username10;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username11;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username12;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username13;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username14;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username15;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username16;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username17;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username18;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username19;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username2;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username20;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username3;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username4;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username5;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username6;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username7;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username8;

    @FXML
    private static Label Biomancer_Day_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Troublemaker Day Voting Screen --------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton Troublemaker_Day_Button1;

    @FXML
    private RadioButton Troublemaker_Day_Button10;

    @FXML
    private RadioButton Troublemaker_Day_Button11;

    @FXML
    private RadioButton Troublemaker_Day_Button12;

    @FXML
    private RadioButton Troublemaker_Day_Button13;

    @FXML
    private RadioButton Troublemaker_Day_Button14;

    @FXML
    private RadioButton Troublemaker_Day_Button15;

    @FXML
    private RadioButton Troublemaker_Day_Button16;

    @FXML
    private RadioButton Troublemaker_Day_Button17;

    @FXML
    private RadioButton Troublemaker_Day_Button18;

    @FXML
    private RadioButton Troublemaker_Day_Button19;

    @FXML
    private RadioButton Troublemaker_Day_Button2;

    @FXML
    private RadioButton Troublemaker_Day_Button20;

    @FXML
    private RadioButton Troublemaker_Day_Button3;

    @FXML
    private RadioButton Troublemaker_Day_Button4;

    @FXML
    private RadioButton Troublemaker_Day_Button5;

    @FXML
    private RadioButton Troublemaker_Day_Button6;

    @FXML
    private RadioButton Troublemaker_Day_Button7;

    @FXML
    private RadioButton Troublemaker_Day_Button8;

    @FXML
    private RadioButton Troublemaker_Day_Button9;

    @FXML
    private ToggleGroup Troublemaker_Day_Vote;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username1;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username10;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username11;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username12;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username13;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username14;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username15;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username16;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username17;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username18;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username19;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username2;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username20;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username3;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username4;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username5;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username6;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username7;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username8;

    @FXML
    private static Label Troublemaker_Day_Voting_Screen_Username9;

    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------
    //-- Inquisitor Hangman Screen -------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Label Guesses;

    @FXML
    private TextField Letter_Guess;

    @FXML
    private Label Targets_Username_Displayed;

    //------------------------------------------------------------------------------------------------------------


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    //------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------
    //-- Werewolf Title Screen -----------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    void Go_To_Create_Account(ActionEvent event) throws IOException { // Goes to the Create Account Screen
        String file = "Create_Account.fxml"; //change this to the name of the path of the create account screen
        System.out.println("Create Account");
        Change_Scene(event, file);
    }

    @FXML
    private Label Title_Screen_Error_Message;

    @FXML
    void Sign_In(ActionEvent event) throws IOException, SQLException { // Signs the user in
        String username = Entered_Username.getText();
        String password = Entered_Password.getText();
        System.out.println("Sign In");
        SQL_Controller s = new SQL_Controller();

        if (s.Check_SQL_Injection(username) && s.Check_SQL_Injection(password)){
            String q = "SELECT * FROM Accounts WHERE Username = "+ username + "AND Password = "+ password +";";
            ResultSet r = s.Get_Data(q);
            r.next();
            if (r.getString("Username").equals("")){
                System.out.println("Username or Password is incorrect\n Please try again");
            }
            else if (r.getString("Username").equals(username) && r.getString("Password").equals(password)) {
                String role = r.getString("Role");
                Set_Currently_Signed_In_Big_3(username, password, role);
                if (role.equals("PLAYER")){
                    Change_Scene(event, "Join_Game.fxml");
                }
                else{
                    //Change to the System Admin Screen
                }
            }
            else {
                System.out.println();
                Title_Screen_Error_Message.setText("Username or Password is incorrect\n Please try again");
                Title_Screen_Error_Message.setOpacity(1.0);
            }
        }
        else{
            Title_Screen_Error_Message.setOpacity(1.0);
        }
    }

    //------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------
    //-- Create Account ------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    private Label Create_Account_Error_Message;

    @FXML
    void Create_Account(ActionEvent event) throws IOException, SQLException { // Creates an account
        String Confirm_Password = New_Account_Entered_Confirm_Password.getText();
        String Password = New_Account_Entered_Password.getText();
        String Username = New_Account_Entered_Username.getText();
        SQL_Controller s = new SQL_Controller();

        System.out.println(Confirm_Password);
        System.out.println(Password);
        System.out.println(Username);

        System.out.println(Confirm_Password.equals(Password));
        System.out.println(s.Check_SQL_Injection(Username));
        System.out.println(s.Check_SQL_Injection(Password));
        System.out.println(s.Check_SQL_Injection(Confirm_Password));

        if (Confirm_Password.equals(Password) && s.Check_SQL_Injection(Username) && s.Check_SQL_Injection(Password) && s.Check_SQL_Injection(Confirm_Password)){
            System.out.println("Generating ID");
            int ID = Generate_ID();
            String q = "SELECT * FROM Accounts WHERE Username = '"+Username+"';";
            ResultSet a = s.Get_Data(q);
            a.next();
            System.out.println("Got data");
            try{
                System.out.println(a.getString(1));
                Create_Account_Error_Message.setText("Username already exists");
                Create_Account_Error_Message.setOpacity(1.0);
            }
            catch (Exception e){
                if(e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                    System.out.println(ID);
                    System.out.println(Username);
                    System.out.println(Password);
                    String q2 = "INSERT INTO Accounts (ID, Username, Password, Role) VALUES ("+ID+", '"+Username+"', '"+Password+"', 'PLAYER' );";
                    s.Write_Data(q2);
                    String File = "Werewolf-Title-Screen.fxml";
                    System.out.println("Created account");
                    Change_Scene(event, File);
                }
                else{

                }
            }
        }
        else{
            Create_Account_Error_Message.setOpacity(1.0);
        }
    }

    //------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------
    //-- Join Game -----------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    @FXML
    void Go_To_Host_Game(ActionEvent event) throws IOException, SQLException { // Goes to the Host Game Screen and starts to collect players
        //How this method works:
        // 1. Changes the scene.
        // 2. Generates the Game Code
        // 3. Writes the names of all the people in the game on a database
        // 4. Waits 1 milisecond.
        // 5. Checks if anyone else has written their to the database.
        // 6. Checks if the start button has been pressed.
        // 7. Repeat steps 4-6.

        Change_Scene(event, "Host_Game.fxml");
        Game_Code.setText(Generate_Code());

        //Make sure that the code is unique

        SQL_Controller s = new SQL_Controller();
        String q1 = "CREATE TABLE " + Game_Code + "_Players ( Usernames varchar(255), \nRole varchar(255), \nStarted int(1), \nVoted int(1), \nVote_Count int(2));";
        s.Write_Data(q1);

        q1 = "INSERT INTO " + Game_Code + "_Players ( Usernames, Role , Started, Voted) VALUES (\'"+Currently_Signed_In_Username+"\',\'\', 0, 0, 0);";
        s.Write_Data(q1);

        String query = "SELECT Usernames FROM "+Game_Code+"_Players";
        Request_Clock.Start(query); // Starts a clock that at every time intervall it will publish an SQL request to get the usernames of the players that join
    }

    @FXML
    private Label Join_Game_Error_Message;

    @FXML
    void Join_Game(ActionEvent event) { // Puts the player into a game
        String Game_Code = Join_Game_Code.getText();
        SQL_Controller s = new SQL_Controller();
        //Find and join it.
        String q1 = "SELECT Username FROM " + Game_Code + "_Players WHERE Started= 1;";
        String q2 = "INSERT INTO " + Game_Code + "_Players ( Usernames, Role, Started, Voted ) VALUES (\'"+Currently_Signed_In_Username+"\',\'\', 0, 0, 0);";

        if(s.Check_SQL_Injection(Game_Code)){
            try{
                ResultSet a = s.Get_Data(q1);
                a.next();
                try{
                    a.getString(1);
                    s.Write_Data(q2);
                }
                catch (Exception e){
                    if (e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                        System.out.println("Game has already started");
                    }
                    else{
                        System.out.println(e);
                    }

                }
            }
            catch (Exception e){
                Join_Game_Error_Message.setText("No game found");
                Join_Game_Error_Message.setOpacity(1.0);
            }
        }
        else {
            Join_Game_Error_Message.setOpacity(1.0);
        }


    }

    @FXML
    void Sign_Out(ActionEvent event) throws IOException { // Signs out the user
        Set_Currently_Signed_In_Big_3("", "", "");
        Change_Scene(event, "Werewolf-Title-Screen.fxml");
    }

    //------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------
    //-- Host Game -----------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    @FXML
    void Host_Game_Back(ActionEvent event) throws IOException, SQLException { // Stops the requests and changes the
        Request_Clock.Stop();
        SQL_Controller s = new SQL_Controller();
        String Q = "DROP DATABASE "+Game_Code+"_Players;";
        s.Write_Data(Q);
        Change_Scene(event, "Join_Game.fxml");
    }

    @FXML
    void Start_Game(ActionEvent event) throws SQLException, InterruptedException, IOException { //Starts the Game
        //make a new game with the players that joined
        Request_Clock.Stop();
        SQL_Controller s = new SQL_Controller();
        String q = "SELECT Usernames FROM "+ Game_Code +"_Players";
        String q2 = "CREATE TABLE "+Game_Code+"_Chat (Chat VARCHAR (255));";
        s.Write_Data(q2);
        boolean biomancer = false;
        boolean Inquisitor = false;
        boolean Vampire = false;

        if (Biomancer_There.isSelected()){
            biomancer = true;
        }
        if (Inquisitor_There.isSelected()){
            Inquisitor = true;
        }
        if (Vampire_There.isSelected()){
            Vampire = true;
        }

        Usernames = Get_Usernames().split(", ");


        g = new Game(true, Usernames, Vampire, Currently_Signed_In_Username, Game_Code.getText(), Root, Scene, Stage, biomancer, Inquisitor);
        g.Start();
    }

    //------------------------------------------------------------------------------------------------------------




    //------------------------------------------------------------------------------------------------------------
    //-- Misc ----------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------

    public void Change_Scene(ActionEvent event, String File) throws IOException { // Changes the scene based off of the File name given
        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(File)));
        Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    void Set_Currently_Signed_In_Big_3(String Username, String Password, String Role){
        Set_Currently_Signed_In_Username(Username);
        Set_Currently_Signed_In_Password(Password);
        Set_Currently_Signed_In_Role(Role);
    }

    void Set_Currently_Signed_In_Username(String Username){
        Currently_Signed_In_Username = Username;
    }

    void Set_Currently_Signed_In_Password(String Password){
        Currently_Signed_In_Password = Password;
    }

    void Set_Currently_Signed_In_Role(String Role){
        Currently_Signed_In_Role = Role;
    }

    String Get_Currently_Signed_In_Username(){
        String Username = Currently_Signed_In_Username;
        return Username;
    }

    String Get_Currently_Signed_In_Password(){
        String Password = Currently_Signed_In_Password;
        return Password;
    }

    String Get_Currently_Signed_In_Role(){
        String Role = Currently_Signed_In_Role;
        return Role;
    }

    String Generate_Code(){ // Generates the game code
        String[] Characters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "u", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random r = new Random();
        String code = "";
        for (int i = 0; i < 6; i++){
            int index = 1000;
            while (!(index>=Characters.length)){
                index = r.nextInt();
            }
            code = code + Characters[index];
        }
        return code;
    }

    int Generate_ID() throws SQLException {
        boolean Valid;

        System.out.println("Inside ID");

        while (true){
            int ID;
            Random r = new Random();
            ID = r.nextInt(999999);

            System.out.println(ID);

            Valid = Check_ID(ID);
            System.out.println("Done check id");
            System.out.println("\n-------------------------------------------------------------------------------------------\n");
            System.out.println(Valid);
            if (Valid){
                System.out.println("Generated ID");
                return ID;
            }
        }
    }

    boolean Check_ID(int ID) throws SQLException {
        System.out.println("Inside check ID");
        SQL_Controller s = new SQL_Controller();
        String q = "SELECT * FROM Accounts WHERE ID = "+ ID +";";
        ResultSet a = s.Get_Data(q);
        System.out.println("Got data");
        a.next();
        System.out.println("Done next");
        try{
            System.out.println(a.getString(1));
            return false;
        }
        catch (Exception e){
            if(e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                System.out.println("Returning true");
                return true;
            }
            else{
                System.out.println(e);
                System.out.println("Returning true");
                return false;
            }
        }
    }

    public static void Set_Players_List_Lables(String[] Usernames){
        Player1.setText(Usernames[0]); //1

        Player2.setText(Usernames[1]); //2

        Player3.setText(Usernames[2]); //3

        Player4.setText(Usernames[3]); //4

        Player5.setText(Usernames[4]); //5

        Player6.setText(Usernames[5]); //6

        Player7.setText(Usernames[6]); //7

        Player8.setText(Usernames[7]); //8

        Player9.setText(Usernames[8]); //9

        Player10.setText(Usernames[9]); //10

        Player11.setText(Usernames[10]); //11

        Player12.setText(Usernames[11]); //12

        Player13.setText(Usernames[12]); //13

        Player14.setText(Usernames[13]); //14

        Player15.setText(Usernames[14]); //15

        Player16.setText(Usernames[15]); //16

        Player17.setText(Usernames[16]); //17

        Player18.setText(Usernames[17]); //18

        Player19.setText(Usernames[18]); //19

        Player20.setText(Usernames[19]); //20
    }

    String Get_Usernames(){
        String Usernames = Player1.getText()+ ", " + Player2.getText()+ ", " + Player3.getText()+ ", " + Player4.getText()+ ", " + Player5.getText()+ ", " + Player6.getText()+ ", " + Player7.getText()+ ", " + Player8.getText()+ ", " + Player9.getText()+ ", " + Player10.getText()+ ", " + Player11.getText()+ ", " + Player12.getText()+ ", " + Player13.getText()+ ", " + Player14.getText()+ ", " + Player15.getText()+ ", " + Player16.getText()+ ", " + Player17.getText()+ ", " + Player18.getText()+ ", " + Player19.getText()+ ", " + Player20.getText();
        return Usernames;
    }

    @FXML
    private Label Troublemaker_Night_Error_Message;

    @FXML
    void Werewolf_Night_Vote(ActionEvent event) throws SQLException {
        if(Werewolf_Night_Button1.isSelected()){
            if(Usernames[0].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[0]);
            }
        }
        else if(Werewolf_Night_Button2.isSelected()){
            if(Usernames[1].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[1]);
            }
        }
        else if(Werewolf_Night_Button3.isSelected()){
            if(Usernames[2].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[2]);
            }
        }
        else if(Werewolf_Night_Button4.isSelected()){
            if(Usernames[3].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[3]);
            }
        }
        else if(Werewolf_Night_Button5.isSelected()){
            if(Usernames[4].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[4]);
            }
        }
        else if(Werewolf_Night_Button6.isSelected()){
            if(Usernames[5].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[5]);
            }
        }
        else if(Werewolf_Night_Button7.isSelected()){
            if(Usernames[6].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[6]);
            }
        }
        else if(Werewolf_Night_Button8.isSelected()){
            if(Usernames[7].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[7]);
            }
        }
        else if(Werewolf_Night_Button9.isSelected()){
            if(Usernames[8].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[8]);
            }
        }
        else if(Werewolf_Night_Button10.isSelected()){
            if(Usernames[9].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[9]);
            }
        }
        else if(Werewolf_Night_Button11.isSelected()){
            if(Usernames[10].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[10]);
            }
        }
        else if(Werewolf_Night_Button12.isSelected()){
            if(Usernames[11].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[11]);
            }
        }
        else if(Werewolf_Night_Button13.isSelected()){
            if(Usernames[12].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[12]);
            }
        }
        else if(Werewolf_Night_Button14.isSelected()){
            if(Usernames[13].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[13]);
            }
        }
        else if(Werewolf_Night_Button15.isSelected()){
            if(Usernames[14].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[14]);
            }
        }
        else if(Werewolf_Night_Button16.isSelected()){
            if(Usernames[15].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[15]);
            }
        }
        else if(Werewolf_Night_Button17.isSelected()){
            if(Usernames[16].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[16]);
            }
        }
        else if(Werewolf_Night_Button18.isSelected()){
            if(Usernames[17].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[17]);
            }
        }
        else if(Werewolf_Night_Button19.isSelected()){
            if(Usernames[18].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[18]);
            }
        }
        else if(Werewolf_Night_Button20.isSelected()){
            if(Usernames[19].equals("________")){
                // Display Error message
                Troublemaker_Night_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[19]);
            }
        }
        else{
            Troublemaker_Night_Error_Message.setOpacity(1.0);
        }

        // Change to waiting screen
    }

    @FXML
    private Label Werewolf_Day_Error_Message;

    @FXML
    void Day_Vote(ActionEvent event) throws SQLException {
        if (Werewolf_Day_Button1.isSelected()){
            if (Usernames[0].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[0]);
            }
        }
        else if (Werewolf_Day_Button2.isSelected()){
            if (Usernames[1].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[1]);
            }
        }
        else if (Werewolf_Day_Button3.isSelected()){
            if (Usernames[2].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[2]);
            }
        }
        else if (Werewolf_Day_Button4.isSelected()){
            if (Usernames[3].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[3]);
            }
        }
        else if (Werewolf_Day_Button5.isSelected()){
            if (Usernames[4].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[4]);
            }
        }
        else if (Werewolf_Day_Button6.isSelected()){
            if (Usernames[5].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[5]);
            }
        }
        else if (Werewolf_Day_Button7.isSelected()){
            if (Usernames[8].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[8]);
            }
        }
        else if (Werewolf_Day_Button8.isSelected()){
            if (Usernames[7].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[7]);
            }
        }
        else if (Werewolf_Day_Button9.isSelected()){
            if (Usernames[8].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[8]);
            }
        }
        else if (Werewolf_Day_Button10.isSelected()){
            if (Usernames[9].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[9]);
            }
        }
        else if (Werewolf_Day_Button11.isSelected()){
            if (Usernames[10].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[10]);
            }
        }
        else if (Werewolf_Day_Button12.isSelected()){
            if (Usernames[11].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[11]);
            }
        }
        else if (Werewolf_Day_Button13.isSelected()){
            if (Usernames[12].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[12]);
            }
        }
        else if (Werewolf_Day_Button14.isSelected()){
            if (Usernames[13].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[13]);
            }
        }
        else if (Werewolf_Day_Button15.isSelected()){
            if (Usernames[14].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[14]);
            }
        }
        else if (Werewolf_Day_Button16.isSelected()){
            if (Usernames[15].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[15]);
            }
        }
        else if (Werewolf_Day_Button17.isSelected()){
            if (Usernames[16].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[16]);
            }
        }
        else if (Werewolf_Day_Button18.isSelected()){
            if (Usernames[17].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[17]);
            }
        }
        else if (Werewolf_Day_Button19.isSelected()){
            if (Usernames[18].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[18]);
            }
        }
        else if (Werewolf_Day_Button20.isSelected()){
            if (Usernames[19].equals("________")){
                Werewolf_Day_Error_Message.setOpacity(1.0);
                // error
            }
            else{
                g.Vote(Usernames[19]);
            }
        }
        else{
            Werewolf_Day_Error_Message.setOpacity(1.0);
        }
    }

    @FXML
    private Label Villager_Day_Error_Message;

    @FXML
    void Villager_Day_Vote(ActionEvent event) throws SQLException {
        if(Villager_Day_Button1.isSelected()){
            if(Usernames[0].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[0]);
            }
        }
        else if (Villager_Day_Button2.isSelected()){
            if(Usernames[1].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[1]);
            }
        }
        else if (Villager_Day_Button3.isSelected()){
            if(Usernames[2].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[2]);
            }
        }
        else if (Villager_Day_Button4.isSelected()){
            if(Usernames[3].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);
            }
            else{
                g.Vote(Usernames[3]);
            }
        }
        else if (Villager_Day_Button5.isSelected()){
            if(Usernames[4].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[4]);
            }
        }
        else if (Villager_Day_Button6.isSelected()){
            if(Usernames[5].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[5]);
            }
        }
        else if (Villager_Day_Button7.isSelected()){
            if(Usernames[6].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[6]);
            }
        }
        else if (Villager_Day_Button8.isSelected()){
            if(Usernames[7].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[7]);
            }
        }
        else if (Villager_Day_Button9.isSelected()){
            if(Usernames[8].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[8]);
            }
        }
        else if (Villager_Day_Button10.isSelected()){
            if(Usernames[9].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[9]);
            }
        }
        else if (Villager_Day_Button11.isSelected()){
            if(Usernames[10].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[10]);
            }
        }
        else if (Villager_Day_Button12.isSelected()){
            if(Usernames[11].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[11]);
            }
        }
        else if (Villager_Day_Button13.isSelected()){
            if(Usernames[12].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[12]);
            }
        }
        else if (Villager_Day_Button14.isSelected()){
            if(Usernames[13].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[13]);
            }
        }
        else if (Villager_Day_Button15.isSelected()){
            if(Usernames[14].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[14]);
            }
        }
        else if (Villager_Day_Button16.isSelected()){
            if(Usernames[15].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[15]);
            }
        }
        else if (Villager_Day_Button17.isSelected()){
            if(Usernames[16].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[16]);
            }
        }
        else if (Villager_Day_Button18.isSelected()){
            if(Usernames[17].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[17]);
            }
        }
        else if (Villager_Day_Button19.isSelected()){
            if(Usernames[18].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[18]);
            }
        }
        else if (Villager_Day_Button20.isSelected()){
            if(Usernames[19].equals("________")){
                Villager_Day_Error_Message.setOpacity(1.0);

            }
            else{
                g.Vote(Usernames[19]);
            }
        }
        else{
            Villager_Day_Error_Message.setOpacity(1.0);
        }
    }

    @FXML
    void Swap(ActionEvent event) throws SQLException {
        String Role_Swap_Username1;
        String Role_Swap_Username2;

        CheckBox[] Check_Boxes = {Biomancer_Swap_Username1,
        Biomancer_Swap_Username2,

        Biomancer_Swap_Username3,

        Biomancer_Swap_Username4,

        Biomancer_Swap_Username5,

        Biomancer_Swap_Username6,

        Biomancer_Swap_Username7,

        Biomancer_Swap_Username8,

        Biomancer_Swap_Username9,

        Biomancer_Swap_Username10,

        Biomancer_Swap_Username11,

        Biomancer_Swap_Username12,

        Biomancer_Swap_Username13,

        Biomancer_Swap_Username14,

        Biomancer_Swap_Username15,

        Biomancer_Swap_Username16,

        Biomancer_Swap_Username17,

        Biomancer_Swap_Username18,

        Biomancer_Swap_Username19,

        Biomancer_Swap_Username20
        };

        //Biomancer_Swap_Error_Message

        int box_Checked = 0;

        for (int i = 0; i < Check_Boxes.length; i++){
            if (Check_Boxes[i].isSelected()){
                box_Checked++;
            }
        }

        if(box_Checked == 2){
            int i = 0;
            int j;

            while (Check_Boxes[i].isSelected() ||i < Check_Boxes.length){
                i++;
            }
            j = i;
            while (Check_Boxes[j].isSelected() ||j < Check_Boxes.length){
                j++;
            }
            g.Swap_Roles(Usernames[i], Usernames[j]);
        }
        else{
            Biomancer_Swap_Error_Message.setOpacity(1.0);
        }
    }

    @FXML
    private Label Vampire_Night_Error_Message;

    @FXML
    void Vampire_Night_Vote(ActionEvent event) throws SQLException {
        RadioButton[] Buttons = {Vampire_Night_Button1, Vampire_Night_Button2, Vampire_Night_Button3, Vampire_Night_Button4, Vampire_Night_Button5, Vampire_Night_Button6,
                Vampire_Night_Button7, Vampire_Night_Button8, Vampire_Night_Button9, Vampire_Night_Button10, Vampire_Night_Button11, Vampire_Night_Button12,
                Vampire_Night_Button13, Vampire_Night_Button14, Vampire_Night_Button15, Vampire_Night_Button16, Vampire_Night_Button17, Vampire_Night_Button18,
                Vampire_Night_Button19, Vampire_Night_Button20};

        boolean button_Selected = false;

        for (int i = 0; i < Buttons.length; i++){
            if (Buttons[i].isSelected()){
                button_Selected = true;
            }
        }

        if (button_Selected){
            for (int i = 0; i < Usernames.length; i++){
                if(Buttons[i].isSelected()){
                    g.Vote(Usernames[i]);
                }
            }
        }
        else {
            Vampire_Night_Error_Message.setOpacity(1.0);
        }
    }


    @FXML
    private Label Troublemaker_Day_Error_Message;

    @FXML
    void Inquisitor_Day_Vote(ActionEvent event) throws SQLException {
        RadioButton[] Buttons = {Inquisitor_Day_Button1, Inquisitor_Day_Button2, Inquisitor_Day_Button3, Inquisitor_Day_Button4, Inquisitor_Day_Button5,
                Inquisitor_Day_Button6, Inquisitor_Day_Button7, Inquisitor_Day_Button8, Inquisitor_Day_Button9, Inquisitor_Day_Button10, Inquisitor_Day_Button11,
                Inquisitor_Day_Button12, Inquisitor_Day_Button13, Inquisitor_Day_Button14, Inquisitor_Day_Button15, Inquisitor_Day_Button16, Inquisitor_Day_Button17,
                Inquisitor_Day_Button18, Inquisitor_Day_Button19, Inquisitor_Day_Button20};

        boolean button_Selected = false;

        for (int i = 0; i < Buttons.length; i++){
            if (Buttons[i].isSelected()){
                button_Selected = true;
            }
        }

        if (button_Selected){
            for (int i = 0; i < Usernames.length; i++){
                if(Buttons[i].isSelected()){
                    g.Vote(Usernames[i]);
                }
            }
        }
        else {
            Inquisitor_Day_Error_Message.setOpacity(1.0);
        }
    }

    @FXML
    void Biomancer_Day_Vote(ActionEvent event) throws SQLException {
        RadioButton[] Buttons = {Biomancer_Day_Button1, Biomancer_Day_Button2, Biomancer_Day_Button3, Biomancer_Day_Button4, Biomancer_Day_Button5, Biomancer_Day_Button6,
                Biomancer_Day_Button7, Biomancer_Day_Button8, Biomancer_Day_Button9, Biomancer_Day_Button10, Biomancer_Day_Button11, Biomancer_Day_Button12,
                Biomancer_Day_Button13, Biomancer_Day_Button14, Biomancer_Day_Button15, Biomancer_Day_Button16, Biomancer_Day_Button17, Biomancer_Day_Button18,
                Biomancer_Day_Button19, Biomancer_Day_Button20};

        //Biomancer_Day_Error_Message

        boolean button_Selected = false;

        for (int i = 0; i < Buttons.length; i++){
            if (Buttons[i].isSelected()){
                button_Selected = true;
            }
        }

        if(button_Selected){
            for (int i = 0; i < Usernames.length; i++){
                if (Buttons[i].isSelected()){
                    g.Vote(Usernames[i]);
                }
            }
        }
        else{
            Biomancer_Day_Error_Message.setOpacity(1.0);
        }
    }

    @FXML
    void Troublemaker_Day_Vote(ActionEvent event) throws SQLException {
        RadioButton[] Buttons = {Troublemaker_Day_Button1, Troublemaker_Day_Button2, Troublemaker_Day_Button3, Troublemaker_Day_Button4,
                Troublemaker_Day_Button5, Troublemaker_Day_Button6, Troublemaker_Day_Button7, Troublemaker_Day_Button8,
                Troublemaker_Day_Button9, Troublemaker_Day_Button10, Troublemaker_Day_Button11, Troublemaker_Day_Button12,
                Troublemaker_Day_Button13, Troublemaker_Day_Button14, Troublemaker_Day_Button15, Troublemaker_Day_Button16,
                Troublemaker_Day_Button17, Troublemaker_Day_Button18, Troublemaker_Day_Button19, Troublemaker_Day_Button20};

        boolean button_Selected = false;

        for (int i = 0; i < Buttons.length; i++){
            if (Buttons[i].isSelected()){
                button_Selected = true;
            }
        }

        if (button_Selected){
            for (int i = 0; i < Usernames.length; i++){
                if(Buttons[i].isSelected()){
                    g.Vote(Usernames[i]);
                }
            }
        }
        else {
            Troublemaker_Day_Error_Message.setOpacity(1.0);
        }
    }

    @FXML
    private Label Vampire_Day_Error_Message;

    @FXML
    void Vampire_Day_Vote(ActionEvent event) throws SQLException {
        RadioButton[] Buttons = {Vampire_Day_Button1, Vampire_Day_Button2, Vampire_Day_Button3, Vampire_Day_Button4, Vampire_Day_Button5, Vampire_Day_Button6,
                Vampire_Day_Button7, Vampire_Day_Button8, Vampire_Day_Button9, Vampire_Day_Button10, Vampire_Day_Button11, Vampire_Day_Button12,
                Vampire_Day_Button13, Vampire_Day_Button14, Vampire_Day_Button15, Vampire_Day_Button16, Vampire_Day_Button17, Vampire_Day_Button18,
                Vampire_Day_Button19, Vampire_Day_Button20};
        int j = 0;
        while(j < Buttons.length){
            if (Buttons[j].isSelected()){
                break;
            }
            j++;
        }

        if(j == Buttons.length){
            for (int i = 0; i < Usernames.length; i++){
                if (Buttons[i].isSelected()){
                    g.Vote(Usernames[i]);
                }
            }
        }
        else{
            Vampire_Day_Error_Message.setOpacity(1.0);
        }
    }

    public static Label[] Get_Lables(String screen){
        Label[] Screen_Labels = new Label[0];
        if (screen.equals("INQUISITOR DAY")){
            Screen_Labels = new Label[]{
                    Inquisitor_Day_Voting_Screen_Username1, Inquisitor_Day_Voting_Screen_Username2, Inquisitor_Day_Voting_Screen_Username3, Inquisitor_Day_Voting_Screen_Username4,
                    Inquisitor_Day_Voting_Screen_Username5, Inquisitor_Day_Voting_Screen_Username6, Inquisitor_Day_Voting_Screen_Username7, Inquisitor_Day_Voting_Screen_Username8,
                    Inquisitor_Day_Voting_Screen_Username9, Inquisitor_Day_Voting_Screen_Username10, Inquisitor_Day_Voting_Screen_Username11, Inquisitor_Day_Voting_Screen_Username12,
                    Inquisitor_Day_Voting_Screen_Username13, Inquisitor_Day_Voting_Screen_Username14, Inquisitor_Day_Voting_Screen_Username15, Inquisitor_Day_Voting_Screen_Username16,
                    Inquisitor_Day_Voting_Screen_Username17, Inquisitor_Day_Voting_Screen_Username18, Inquisitor_Day_Voting_Screen_Username19, Inquisitor_Day_Voting_Screen_Username20
            };

        }

        else if (screen.equals("VILLAGER DAY")){
            Screen_Labels = new Label[]{
                    Villager_Day_Voting_Screen_Username1, Villager_Day_Voting_Screen_Username2, Villager_Day_Voting_Screen_Username3, Villager_Day_Voting_Screen_Username4,
                    Villager_Day_Voting_Screen_Username5, Villager_Day_Voting_Screen_Username6, Villager_Day_Voting_Screen_Username7, Villager_Day_Voting_Screen_Username8,
                    Villager_Day_Voting_Screen_Username9, Villager_Day_Voting_Screen_Username10, Villager_Day_Voting_Screen_Username11, Villager_Day_Voting_Screen_Username12,
                    Villager_Day_Voting_Screen_Username13, Villager_Day_Voting_Screen_Username14, Villager_Day_Voting_Screen_Username15, Villager_Day_Voting_Screen_Username16,
                    Villager_Day_Voting_Screen_Username17, Villager_Day_Voting_Screen_Username18, Villager_Day_Voting_Screen_Username19, Villager_Day_Voting_Screen_Username20
            };
        }

        else if (screen.equals("WEREWOLF DAY")){
            Screen_Labels = new Label[]{
                    Werewolf_Day_Voting_Screen_Username1, Werewolf_Day_Voting_Screen_Username2, Werewolf_Day_Voting_Screen_Username3, Werewolf_Day_Voting_Screen_Username4,
                    Werewolf_Day_Voting_Screen_Username5, Werewolf_Day_Voting_Screen_Username6, Werewolf_Day_Voting_Screen_Username7, Werewolf_Day_Voting_Screen_Username8,
                    Werewolf_Day_Voting_Screen_Username9, Werewolf_Day_Voting_Screen_Username10, Werewolf_Day_Voting_Screen_Username11, Werewolf_Day_Voting_Screen_Username12,
                    Werewolf_Day_Voting_Screen_Username13, Werewolf_Day_Voting_Screen_Username14, Werewolf_Day_Voting_Screen_Username15, Werewolf_Day_Voting_Screen_Username16,
                    Werewolf_Day_Voting_Screen_Username17, Werewolf_Day_Voting_Screen_Username18, Werewolf_Day_Voting_Screen_Username19, Werewolf_Day_Voting_Screen_Username20
            };
        }

        else if (screen.equals("VAMPIRE DAY")){
            Screen_Labels = new Label[]{
                    Vampire_Day_Voting_Screen_Username1, Vampire_Day_Voting_Screen_Username2, Vampire_Day_Voting_Screen_Username3, Vampire_Day_Voting_Screen_Username4,
                    Vampire_Day_Voting_Screen_Username5, Vampire_Day_Voting_Screen_Username6, Vampire_Day_Voting_Screen_Username7, Vampire_Day_Voting_Screen_Username8,
                    Vampire_Day_Voting_Screen_Username9, Vampire_Day_Voting_Screen_Username10, Vampire_Day_Voting_Screen_Username11, Vampire_Day_Voting_Screen_Username12,
                    Vampire_Day_Voting_Screen_Username13, Vampire_Day_Voting_Screen_Username14, Vampire_Day_Voting_Screen_Username15, Vampire_Day_Voting_Screen_Username16,
                    Vampire_Day_Voting_Screen_Username17, Vampire_Day_Voting_Screen_Username18, Vampire_Day_Voting_Screen_Username19, Vampire_Day_Voting_Screen_Username20
            };
        }

        else if (screen.equals("TROUBLEMAKER DAY")) {
            Screen_Labels = new Label[]{
                    Troublemaker_Day_Voting_Screen_Username1, Troublemaker_Day_Voting_Screen_Username2, Troublemaker_Day_Voting_Screen_Username3,
                    Troublemaker_Day_Voting_Screen_Username4, Troublemaker_Day_Voting_Screen_Username5, Troublemaker_Day_Voting_Screen_Username6,
                    Troublemaker_Day_Voting_Screen_Username7, Troublemaker_Day_Voting_Screen_Username8, Troublemaker_Day_Voting_Screen_Username9,
                    Troublemaker_Day_Voting_Screen_Username10, Troublemaker_Day_Voting_Screen_Username11, Troublemaker_Day_Voting_Screen_Username12,
                    Troublemaker_Day_Voting_Screen_Username13, Troublemaker_Day_Voting_Screen_Username14, Troublemaker_Day_Voting_Screen_Username15,
                    Troublemaker_Day_Voting_Screen_Username16, Troublemaker_Day_Voting_Screen_Username17, Troublemaker_Day_Voting_Screen_Username18,
                    Troublemaker_Day_Voting_Screen_Username19, Troublemaker_Day_Voting_Screen_Username20
            };
        }

        else if (screen.equals("BIOMANCER DAY")) {
            Screen_Labels = new Label[]{
                    Biomancer_Day_Voting_Screen_Username1, Biomancer_Day_Voting_Screen_Username2, Biomancer_Day_Voting_Screen_Username3, Biomancer_Day_Voting_Screen_Username4,
                    Biomancer_Day_Voting_Screen_Username5, Biomancer_Day_Voting_Screen_Username6, Biomancer_Day_Voting_Screen_Username7, Biomancer_Day_Voting_Screen_Username8,
                    Biomancer_Day_Voting_Screen_Username9, Biomancer_Day_Voting_Screen_Username10, Biomancer_Day_Voting_Screen_Username11, Biomancer_Day_Voting_Screen_Username12,
                    Biomancer_Day_Voting_Screen_Username13, Biomancer_Day_Voting_Screen_Username14, Biomancer_Day_Voting_Screen_Username15, Biomancer_Day_Voting_Screen_Username16,
                    Biomancer_Day_Voting_Screen_Username17, Biomancer_Day_Voting_Screen_Username18, Biomancer_Day_Voting_Screen_Username19, Biomancer_Day_Voting_Screen_Username20
            };
        }

        else if (screen.equals("WEREWOLF NIGHT")){
            Screen_Labels = new Label[]{
                    Werewolf_Night_Voting_Screen_Username1, Werewolf_Night_Voting_Screen_Username2, Werewolf_Night_Voting_Screen_Username3, Werewolf_Night_Voting_Screen_Username4,
                    Werewolf_Night_Voting_Screen_Username5, Werewolf_Night_Voting_Screen_Username6, Werewolf_Night_Voting_Screen_Username7, Werewolf_Night_Voting_Screen_Username8,
                    Werewolf_Night_Voting_Screen_Username9, Werewolf_Night_Voting_Screen_Username10, Werewolf_Night_Voting_Screen_Username11, Werewolf_Night_Voting_Screen_Username12,
                    Werewolf_Night_Voting_Screen_Username13, Werewolf_Night_Voting_Screen_Username14, Werewolf_Night_Voting_Screen_Username15, Werewolf_Night_Voting_Screen_Username16,
                    Werewolf_Night_Voting_Screen_Username17, Werewolf_Night_Voting_Screen_Username18, Werewolf_Night_Voting_Screen_Username19, Werewolf_Night_Voting_Screen_Username20
            };
        }

        else if (screen.equals("VAMPIRE NIGHT")){
            Screen_Labels = new Label[]{
                    Vampire_Night_Voting_Screen_Username1, Vampire_Night_Voting_Screen_Username2, Vampire_Night_Voting_Screen_Username3, Vampire_Night_Voting_Screen_Username4,
                    Vampire_Night_Voting_Screen_Username5, Vampire_Night_Voting_Screen_Username6, Vampire_Night_Voting_Screen_Username7, Vampire_Night_Voting_Screen_Username8,
                    Vampire_Night_Voting_Screen_Username9, Vampire_Night_Voting_Screen_Username10, Vampire_Night_Voting_Screen_Username11, Vampire_Night_Voting_Screen_Username12,
                    Vampire_Night_Voting_Screen_Username13, Vampire_Night_Voting_Screen_Username14, Vampire_Night_Voting_Screen_Username15, Vampire_Night_Voting_Screen_Username16,
                    Vampire_Night_Voting_Screen_Username17, Vampire_Night_Voting_Screen_Username18, Vampire_Night_Voting_Screen_Username19, Vampire_Night_Voting_Screen_Username20
            };
        }

        else if (screen.equals("BIOMANCER NIGHT")){
            Screen_Labels = new Label[]{
                    Biomancer_Swap_Screen_Username1, Biomancer_Swap_Screen_Username2, Biomancer_Swap_Screen_Username3, Biomancer_Swap_Screen_Username4,
                    Biomancer_Swap_Screen_Username5, Biomancer_Swap_Screen_Username6, Biomancer_Swap_Screen_Username7, Biomancer_Swap_Screen_Username8,
                    Biomancer_Swap_Screen_Username9, Biomancer_Swap_Screen_Username10, Biomancer_Swap_Screen_Username11, Biomancer_Swap_Screen_Username12,
                    Biomancer_Swap_Screen_Username13, Biomancer_Swap_Screen_Username14, Biomancer_Swap_Screen_Username15, Biomancer_Swap_Screen_Username16,
                    Biomancer_Swap_Screen_Username17, Biomancer_Swap_Screen_Username18, Biomancer_Swap_Screen_Username19, Biomancer_Swap_Screen_Username20
            };
        }
        
        return Screen_Labels;
    }

    @FXML
    private TextField Night_Message;

    @FXML
    private static Label Chat;

    @FXML
    void Send_Message(ActionEvent event) throws SQLException {
        SQL_Controller s = new SQL_Controller();
        String Message = Night_Message.getText();
        String q1 = "SELECT * FROM "+ Game_Code + "_Chat;";
        ResultSet rs = s.Get_Data(q1);
        rs.next();
        String chat = rs.getString("Chat");
        String chat2 = Currently_Signed_In_Username + ": " + chat + Message + "\n\n";
        if (s.Check_SQL_Injection(Message)){
            String q2 = "UPDATE "+Game_Code+"_Chat \nSET Chat = '"+chat2+"' \nWHERE 1=1";
            s.Write_Data(q2);
        }
    }

    public static Label Get_Chat(){
        return Chat;
    }

    @FXML
    void Night_Creature1_Selected(ActionEvent event) throws SQLException, IOException {
        g.Hangman(1, Guesses, Targets_Username_Displayed);
    }

    @FXML
    void Night_Creature2_Selected(ActionEvent event) throws SQLException, IOException {
        g.Hangman(2, Guesses, Targets_Username_Displayed);
    }

    @FXML
    void Night_Creature3_Selected(ActionEvent event) throws SQLException, IOException {
        g.Hangman(3, Guesses, Targets_Username_Displayed);
    }

    @FXML
    void Night_Creature4_Selected(ActionEvent event) throws SQLException, IOException {
        g.Hangman(4, Guesses, Targets_Username_Displayed);
    }

    @FXML
    void Night_Creature5_Selected(ActionEvent event) throws SQLException, IOException {
        g.Hangman(5, Guesses, Targets_Username_Displayed);
    }

    @FXML
    void Guess(ActionEvent event) {
        g.Hangman_Guess(Letter_Guess.getText());
    }

    @FXML
    void Quit(ActionEvent event) throws IOException {
        Change_Scene(event, "Join_Game.fxml");
    }
}

