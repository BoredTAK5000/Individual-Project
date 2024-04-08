package com.example.individual_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Game {

    int Number_of_Minions;

    String[] Werewolves;

    Parent Root;

    Stage Stage;

    Scene Scene;

    String[] Villagers;

    String Vampire;

    String[] Vampire_Minions;

    boolean Vampire_alive;

    boolean Inquisitor_alive;

    boolean Biomancer_alive;

    boolean Troublemaker_alive = true;

    String In_Game_Role;

    String Username;

    String Game_Code;

    boolean Odd_night;

    String[] Usernames;

    String Inquisitor_Guesses1;

    String Inquisitor_Guesses2;

    String Inquisitor_Guesses3;

    String Inquisitor_Guesses4;

    String Inquisitor_Guesses5;

    String Tracker;

    int Tracker_Number;


    //----------------------------------------------------------------------------------------------------------
    //-- Constructor -------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------
    Game(boolean Host, String[] Players_Usernames, boolean vamp, String Player_Username, String game_Code, Parent root, Scene scene, Stage stage, boolean biomancer, boolean inquisitor) throws SQLException, InterruptedException, IOException {

        Root = root;
        Scene = scene;
        Stage = stage;

        Number_of_Minions = 0;

        Usernames = Players_Usernames;

        Username = Player_Username;
        Game_Code = game_Code;
        if (Host){
            Initalise(Players_Usernames, vamp, biomancer, inquisitor);
        }

        Odd_night = true;

        Start();
    }

    //----------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------
    //-- Initalise ---------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    void Initalise(String[] Players_Usernames, boolean vamp, boolean Biomancer, boolean inquisitor) throws SQLException {
        int Werewolf1 = 0;
        int Werewolf2 = 0;
        int Werewolf3 = 0;

        int Vampire_i = -1;
        int Inquisitor = -1;
        int Bio = -1;

        Random r = new Random();


        //Set the Vampire
        if (vamp){
            Vampire_alive = true;
            Vampire_i = r.nextInt(Players_Usernames.length);
            Vampire = Players_Usernames[Vampire_i];
        }
        else{
            Vampire_alive = false;
        }

        if (inquisitor){
            Inquisitor = r.nextInt(Players_Usernames.length);
            while (!(Inquisitor == Vampire_i)){
                Inquisitor = r.nextInt(Players_Usernames.length);
                Inquisitor_alive = true;
            }
        }
        else {
            Inquisitor_alive = false;
        }

        if(Biomancer){
            Bio = r.nextInt(Players_Usernames.length);
            while (!(Bio == Vampire_i || Bio == Inquisitor)){
                Inquisitor = r.nextInt(Players_Usernames.length);
                Biomancer_alive = true;
            }
        }
        else{
            Biomancer_alive = false;
        }


        // Set the werewolves
        if (Players_Usernames.length < 10){
            while (Werewolf1 == Werewolf2 || Werewolf1 == Vampire_i || Werewolf2 == Vampire_i || Werewolf1 == Bio || Werewolf2 == Bio || Werewolf1 == Inquisitor || Werewolf2 == Inquisitor){
                Werewolf1 = r.nextInt(Players_Usernames.length);
                Werewolf2 = r.nextInt(Players_Usernames.length);
            }
        }
        else{
            while (Werewolf1 == Werewolf2 || Werewolf1 == Werewolf3 || Werewolf2 == Werewolf3 || Werewolf1 == Vampire_i || Werewolf2 == Vampire_i || Werewolf3 == Vampire_i || Werewolf1 == Bio || Werewolf2 == Bio || Werewolf3 == Bio || Werewolf1 == Inquisitor || Werewolf2 == Inquisitor || Werewolf3 == Inquisitor){
                Werewolf1 = r.nextInt(Players_Usernames.length);
                Werewolf2 = r.nextInt(Players_Usernames.length);
                Werewolf3 = r.nextInt(Players_Usernames.length);
            }
        }

        // puts the roles into the database so that are available to all computers
        SQL_Controller s = new SQL_Controller();
        String q;
        if (Players_Usernames.length < 10){
            q = "UPDATE "+ Game_Code + "_Players SET Role = WEREWOLF WHERE Username = '"+ Players_Usernames[Werewolf1] + "' OR Username = '"+ Players_Usernames[Werewolf2] + "';";
        }
        else{
            q = "UPDATE "+ Game_Code + "_Players SET Role = 'WEREWOLF' WHERE Username = '"+ Players_Usernames[Werewolf1] + "' OR Username = '"+ Players_Usernames[Werewolf2] + "' OR Username = '"+ Players_Usernames[Werewolf3]+ "';";
        }
        s.Write_Data(q);

        if (vamp){
            q = "UPDATE "+ Game_Code + "_Players SET Role = 'VAMPIRE' WHERE Username = '"+ Players_Usernames[Vampire_i] + "';";
            s.Write_Data(q);
        }

        if (Biomancer){
            q = "UPDATE "+ Game_Code + "_Players SET Role = 'BIOMANCER' WHERE Username = '"+ Players_Usernames[Bio] + "';";
            s.Write_Data(q);
        }

        if (inquisitor){
            q = "UPDATE "+ Game_Code + "_Players SET Role = 'INQUISITOR' WHERE Username = '"+ Players_Usernames[Inquisitor] + "';";
            s.Write_Data(q);
        }

    }

    //----------------------------------------------------------------------------------------------------------
    //-- Vote --------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    void Vote(String Players_Username) throws SQLException {
        String q = "SELECT Vote_Count FROM "+ Game_Code + "_Players WHERE Username = " + Players_Username + ";";
        SQL_Controller s = new SQL_Controller();
        ResultSet rs = s.Get_Data(q);
        rs.next();
        int Vote_Count = rs.getInt("Vote_Cout");
        Vote_Count++;
        q = "UPDATE "+ Game_Code + "_Player\nSET Vote_Count = "+ Vote_Count + ", Voted = 1\nWHERE Username = "+ Players_Username +";";
        s.Write_Data(q);

    }

    //----------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------
    //-- Kill --------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    void Kill(String Players_Username) throws SQLException {

        SQL_Controller s = new SQL_Controller();
        String q = "UPDATE "+ Game_Code +"_Players \nSET Role = 'DEAD' WHERE Username = '" + Players_Username +"';";
        String q2 = "SELECT * FROM"+ Game_Code +"_Players WHERE Username = '"+ Players_Username +"';";
        ResultSet rs = s.Get_Data(q2);
        rs.next();
        if (rs.getString("Role").equals("VAMPIRE")){
            for (int i = 0; i < Vampire_Minions.length; i++){
                Kill(Vampire_Minions[i]);
                Vampire_alive = false;
            }
        }
        else if (rs.getString("Role").equals("WEREWOLF")){
            String[] New_Werewolves;
            if (Werewolves.length == 3){
                if (Werewolves[0].equals(rs.getString("Role"))){
                    New_Werewolves = new String[]{Werewolves[1], Werewolves[2]};
                }
                else if (Werewolves[1].equals(rs.getString("Role"))){
                    New_Werewolves = new String[]{Werewolves[0], Werewolves[2]};
                }
                else{
                    New_Werewolves = new String[]{Werewolves[0], Werewolves[1]};
                }
                Werewolves = New_Werewolves;
            }
            else if (Werewolves.length == 2){
                New_Werewolves = new String[]{""};
                if (!(Werewolves[0].equals(rs.getString("Role")))){
                    New_Werewolves[0] = Werewolves[0];
                }
                else{
                    New_Werewolves[0] = Werewolves[1];
                }
                Werewolves = New_Werewolves;
            }
        }
        else if (rs.getString("Role").equals("BIOMANCER")){
            Biomancer_alive = false;
        }
        else if (rs.getString("Role").equals("INQUISITOR")){
            Inquisitor_alive = false;
        }
        else if (rs.getString("Role").equals("INQUISITOR")){
            Troublemaker_alive = false;
        }

        s.Write_Data(q);
    }

    //----------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------
    //-- Start Game --------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------
    void Start() throws SQLException, InterruptedException, IOException {

        Set_In_Game_Role(Get_Role());

        String file = "";
        if (Get_Local_Role().equals("VILLAGER")){
            // Go to Villager Intro Screen
            file = "Villager-Role-Screen"; // Done
        }
        else if (Get_Local_Role().equals("VAMPIRE")){
            // Go to Vampire Intro screen
            file = "Vampire-Role-Screen"; // Done
        }
        else if (Get_Local_Role().equals("WEREWOLF")){
            // Go to Werewolf Intro screen
            file = "Werewolf-Role-Screen"; // Done
        }
        else if (Get_Local_Role().equals("INQUISITOR")) {
            // Go to Inquisitor Intro screen
            file = "Inquisitor-Role-Screen"; // Done
        }
        else if (Get_Local_Role().equals("BIOMANCER")) {
            // Go to Biomancer Intro screen
            file = "Biomancer-Role-Screen";
        }
        else if (Get_Local_Role().equals("TROUBLEMAKER")) {
            // Go to Troublemaker Intro screen
            file = "Troublemaker-Role-Screen"; // Done
        }
        else{
            file = "Villager-Role-Screen";
        }

        Change_Scene(new ActionEvent(), file);

        Thread.sleep(10000);


        night();


        if (Vampire_alive){
            //Switch the screen to vampire winning
        }
        else if (Werewolves.length == 0){
            //Switch the screen to the villagers winning
        }
        else if (Werewolves.length >= Villagers.length){
            //Switch the screen to the werewolves winning
        }
    }

    //----------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------
    //-- Day ---------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    void day() throws SQLException, IOException {
        // Get their new roles
        // Change screen to the voting screen depending on role
        // Once everyone has voted kill the player that's been voted

        Set_In_Game_Role(Get_Role()); // Gets the new roles

        if (Get_Local_Role().contains("MINION")){
            // Go to Minion day voting screen
            Change_Scene(new ActionEvent(), "Vampire-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "VAMPIRE DAY");

        }
        else if (Get_Local_Role().contains("VILLAGER")){
            // Go to Villager day voting Screen
            Change_Scene(new ActionEvent(), "Villager-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "VILLAGER DAY"); // change
        }
        else if (Get_Local_Role().contains("VAMPIRE")){
            // Go to Vampire day voting screen
            Change_Scene(new ActionEvent(), "Vampire-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "VAMPIRE DAY");
        }
        else if (Get_Local_Role().contains("WEREWOLF")){
            // Go to Werewolf day voting screen
            Change_Scene(new ActionEvent(), "Werewolf-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "WEREWOLF DAY");
        }
        else if (Get_Local_Role().contains("INQUISITOR")) {
            // Go to Inquisitor day voting screen
            Change_Scene(new ActionEvent(), "Inquisitor-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "INQUISITOR DAY");
        }
        else if (Get_Local_Role().contains("BIOMANCER")) {
            // Go to Biomancer day voting screen
            Change_Scene(new ActionEvent(), "Biomancer-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "BIOMANCER DAY");
        }
        else if (Get_Local_Role().contains("TROUBLEMAKER")) {
            // Go to Troublemaker day voting screen
            Change_Scene(new ActionEvent(), "Troublemaker-Day-Voting-Screen.fxml");
            Label_Getter l = new Label_Getter(Usernames, "TROUBLEMAKER DAY");
        }
        else{
            // Change the screen to show that they are dead
            Change_Scene(new ActionEvent(), "Dead-Screen.fxml");
        }

        Wait_For_Everyone();


        String count = Get_Most_Votes();
        Kill(count);
        if (!((!Vampire_alive && Werewolves.length >= Villagers.length) || (Werewolves.length == 0 && !Vampire_alive) || (Werewolves.length >= Villagers.length && Werewolves.length == 0))){
            night();
        }
    }

    //----------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------
    //-- Night -------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    void night() throws IOException, SQLException {
        //go to Werewolf screen done
        //go to Inquisitor screen done
        //go to Biomancer screen done
        //go to Vampire screen done


        //-- Werewolves and Troublemaker vote ----------------------------------------------------------------------
        if (Get_Local_Role().contains("WEREWOLF") || Get_Local_Role().contains("TROUBLEMAKER")){
            // Go to Werewolf screen
            Label_Getter l = new Label_Getter(Usernames, "WEREWOLF NIGHT");
            if (Get_Local_Role().equals("WEREWOLF")){
                Change_Scene(new ActionEvent(), "Werewolf-Night-Voting-Screen.fxml");
                //Clock c = new Clock(1);
                Chat c = new Chat(Game_Code, HelloController.Get_Chat());
            }
            else{
                // Go to Troublemaker screen

                Change_Scene(new ActionEvent(), "Troublemaker-Night-Voting-Screen.fxml");
                Chat c = new Chat(Game_Code, HelloController.Get_Chat());
            }

        }
        else if (Get_Local_Role().contains("INQUISITOR")){
            // Wait until the werewolves have voted on their screen
            SQL_Controller s = new SQL_Controller();
            String q = "SELECT * WHERE Role = 'WEREWOLF' OR Role = 'TROUBLEMAKER'";
            ResultSet rs = s.Get_Data(q);
            rs.next();

            int Werewolf1_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf2_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf3_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf4_Voted = rs.getInt("Voted");

            while (Werewolf1_Voted == 0 || Werewolf2_Voted == 0 || Werewolf3_Voted == 0 || Werewolf4_Voted == 0){
                rs = s.Get_Data(q);
                rs.next();

                Werewolf1_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf2_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf3_Voted = rs.getInt("Voted");
            }
        }
        else if (Get_Local_Role().contains("VILLAGER")){
            // Wait until the werewolves have voted on their screen
            // Go to the Villager waiting screen
            Change_Scene(new ActionEvent(), "Villager-Night-Waiting-Screen.fxml");
            SQL_Controller s = new SQL_Controller();
            String q = "SELECT * WHERE Role = WEREWOLF";
            ResultSet rs = s.Get_Data(q);
            rs.next();

            int Werewolf1_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf2_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf3_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf4_Voted = rs.getInt("Voted");

            while (Werewolf1_Voted == 0 || Werewolf2_Voted == 0 || Werewolf3_Voted == 0 || Werewolf4_Voted == 0){
                rs = s.Get_Data(q);
                rs.next();

                Werewolf1_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf2_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf3_Voted = rs.getInt("Voted");
            }
        }
        else if (Get_Local_Role().contains("VAMPIRE")){
            // Wait until the werewolves have voted on their screen
            Change_Scene(new ActionEvent(), "Vampire-Night-Wait-Screen.fxml");
            SQL_Controller s = new SQL_Controller();
            String q = "SELECT * WHERE Role = WEREWOLF";
            ResultSet rs = s.Get_Data(q);
            rs.next();

            int Werewolf1_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf2_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf3_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf4_Voted = rs.getInt("Voted");

            while (Werewolf1_Voted == 0 || Werewolf2_Voted == 0 || Werewolf3_Voted == 0 || Werewolf4_Voted == 0){
                rs = s.Get_Data(q);
                rs.next();

                Werewolf1_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf2_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf3_Voted = rs.getInt("Voted");
            }
        }
        else if (Get_Local_Role().contains("MINION")){
            // Wait until the werewolves have voted on their screen
            SQL_Controller s = new SQL_Controller();
            String q = "SELECT * WHERE Role = WEREWOLF";
            ResultSet rs = s.Get_Data(q);
            rs.next();

            int Werewolf1_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf2_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf3_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf4_Voted = rs.getInt("Voted");

            while (Werewolf1_Voted == 0 || Werewolf2_Voted == 0 || Werewolf3_Voted == 0 || Werewolf4_Voted == 0){
                rs = s.Get_Data(q);
                rs.next();

                Werewolf1_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf2_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf3_Voted = rs.getInt("Voted");
            }
        }
        else if (Get_Local_Role().contains("BIOMANCER")){
            // Wait until the werewolves have voted on their screen
            Change_Scene(new ActionEvent(), "Biomancer-Night-Wait-Screen.fxml");
            SQL_Controller s = new SQL_Controller();
            String q = "SELECT * WHERE Role = WEREWOLF";
            ResultSet rs = s.Get_Data(q);
            rs.next();

            int Werewolf1_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf2_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf3_Voted = rs.getInt("Voted");
            rs.next();
            int Werewolf4_Voted = rs.getInt("Voted");

            while (Werewolf1_Voted == 0 || Werewolf2_Voted == 0 || Werewolf3_Voted == 0 || Werewolf4_Voted == 0){
                rs = s.Get_Data(q);
                rs.next();

                Werewolf1_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf2_Voted = rs.getInt("Voted");
                rs.next();
                Werewolf3_Voted = rs.getInt("Voted");
            }
        }

        SQL_Controller s = new SQL_Controller();
        String q = "UPDATE "+Game_Code+"_Players \nSET Voted = 0 WHERE 1=1;";
        String q2 = "UPDATE "+Game_Code+"_Chat \nSET Chat = '' WHERE 1=1;";
        s.Write_Data(q);
        s.Write_Data(q2);

        String Max_Username = Get_Most_Votes();

        Kill(Max_Username);

        //----------------------------------------------------------------------------------------------------------



        //-- Inquisitor plays --------------------------------------------------------------------------------------

        if(Inquisitor_alive){
            if (Get_Local_Role().contains("INQUISITOR")){
                // Go to Inquisitor screen
                Change_Scene(new ActionEvent(), "Inquisitor-Select-Hangman-Screen.fxml");
            }
            else if (Get_Local_Role().contains("WEREWOLF")){
                // Wait until the Inquisitor has finished
                Change_Scene(new ActionEvent(), "Werewolf-Night-Wait-Screen.fxml");
                Wait_For_Single("INQUISITOR");
            }
            else if (Get_Local_Role().contains("VILLAGER")){
                // Wait until the Inquisitor has finished
                Change_Scene(new ActionEvent(), "Villager-Night-Waiting-Screen.fxml");
                Wait_For_Single("INQUISITOR");
            }
            else if (Get_Local_Role().contains("VAMPIRE")){
                // Wait until the Inquisitor has finished
                Change_Scene(new ActionEvent(), "Vampire-Night-Wait-Screen.fxml");
                Wait_For_Single("INQUISITOR");
            }
            else if (Get_Local_Role().contains("MINION")){
                // Wait until the Inquisitor has finished
                Change_Scene(new ActionEvent(), "Vampire-Night-Wait-Screen.fxml");
                Wait_For_Single("INQUISITOR");
            }
            else if (Get_Local_Role().contains("BIOMANCER")){
                // Wait until the Inquisitor has finished
                Change_Scene(new ActionEvent(), "Biomancer-Night-Wait-Screen.fxml");
                Wait_For_Single("INQUISITOR");
            }
            else if (Get_Local_Role().contains("TROUBLEMAKER")){
                // Wait until the Inquisitor has finished
                Change_Scene(new ActionEvent(), "Troublemaker-Night-Wait-Screen.fxml");
                Wait_For_Single("INQUISITOR");
            }
            q = "UPDATE "+Game_Code+"_Players \nSET Voted = 0 WHERE 1=1;";
            q2 = "UPDATE "+Game_Code+"_Chat \nSET Chat = '' WHERE 1=1;";
            s.Write_Data(q);
            s.Write_Data(q2);
        }

        //----------------------------------------------------------------------------------------------------------



        //-- Biomancer Swaps ---------------------------------------------------------------------------------------

        if (Odd_night && Biomancer_alive){
            if (Get_Local_Role().contains("BIOMANCER")){
                // Go to Biomancer screen
                Change_Scene(new ActionEvent(), "Biomancer-Role-Swap-Screen.fxml");// change
                Label_Getter l = new Label_Getter(Usernames, "BIOMANCER NIGHT");
            }
            else if (Get_Local_Role().contains("WEREWOLF")){
                // Wait until the Biomancer has finished
                Change_Scene(new ActionEvent(), "Werewolf-Night-Wait-Screen.fxml");
                Wait_For_Single("BIOMANCER");
            }
            else if (Get_Local_Role().contains("VILLAGER")){
                // Wait until the Biomancer has finished
                Change_Scene(new ActionEvent(), "Villager-Night-Waiting-Screen.fxml");
                Wait_For_Single("BIOMANCER");
            }
            else if (Get_Local_Role().contains("VAMPIRE")){
                // Wait until the Biomancer has finished
                Change_Scene(new ActionEvent(), "Vampire-Night-Wait-Screen.fxml");
                Wait_For_Single("BIOMANCER");
            }
            else if (Get_Local_Role().contains("MINION")){
                // Wait until the Biomancer has finished
                Change_Scene(new ActionEvent(), "Vampire-Night-Wait-Screen.fxml");
                Wait_For_Single("BIOMANCER");
            }
            else if (Get_Local_Role().contains("INQUISITOR")){
                // Wait until the Biomancer has finished
                Change_Scene(new ActionEvent(), "Inquisitor-Waiting-Screen.fxml");
                Wait_For_Single("BIOMANCER");
            }
            else if (Get_Local_Role().contains("TROUBLEMAKER")){
                // Wait until the Biomancer has finished
                Change_Scene(new ActionEvent(), "Troublemaker-Night-Wait-Screen.fxml");
                Wait_For_Single("BIOMANCER");
            }
            Odd_night = !Odd_night;
            q = "UPDATE "+Game_Code+"_Players \nSET Voted = 0 WHERE 1=1;";
            q2 = "UPDATE "+Game_Code+"_Chat \nSET Chat = '' WHERE 1=1;";
            s.Write_Data(q);
            s.Write_Data(q2);
        }

        //----------------------------------------------------------------------------------------------------------



        //-- Vampire and minions -----------------------------------------------------------------------------------

        if(Vampire_alive){
            if (Get_Local_Role().contains("MINION") || Get_Local_Role().contains("VAMPIRE")){ //
                // Go to Vampire and Minion screen
                Change_Scene(new ActionEvent(), "Vampire-Night-Voting-Screen.fxml");
                // VAMPIRE NIGHT
                Label_Getter l = new Label_Getter(Usernames, "VAMPIRE NIGHT");
                Chat c = new Chat(Game_Code, HelloController.Get_Chat());
            }
            else if (Get_Local_Role().contains("WEREWOLF")){
                // Wait until the Vampire and Minions has finished
                Change_Scene(new ActionEvent(), "Werewolf-Night-Wait-Screen.fxml");
                Wait_For_Vampire();
            }
            else if (Get_Local_Role().contains("VILLAGER")){
                // Wait until the Vampire and Minions has finished
                Change_Scene(new ActionEvent(), "Villager-Night-Waiting-Screen.fxml");
                Wait_For_Vampire();
            }
            else if (Get_Local_Role().contains("BIOMANCER")){
                // Wait until the Vampire and Minions has finished
                Change_Scene(new ActionEvent(), "Biomancer-Night-Wait-Screen.fxml");
                Wait_For_Vampire();
            }
            else if (Get_Local_Role().contains("INQUISITOR")){
                // Wait until the Vampire and Minions has finished
                Change_Scene(new ActionEvent(), "Villager-Night-Waiting-Screen.fxml");
                Wait_For_Vampire();
            }
            else if (Get_Local_Role().contains("TROUBLEMAKER")){
                // Wait until the Vampire and Minions has finished
                Change_Scene(new ActionEvent(), "Troublemaker-Night-Wait-Screen.fxml");
                Wait_For_Vampire();
            }

            s = new SQL_Controller();
            q = "UPDATE "+Game_Code+"_Players \nSET Voted = 0 WHERE 1=1;";
            s.Write_Data(q);
            s.Write_Data(q2);

            Max_Username = Get_Most_Votes();

            Convert_To_Minion(Max_Username);
        }

        if (!((!Vampire_alive && Werewolves.length >= Villagers.length) || (Werewolves.length == 0 && !Vampire_alive) || (Werewolves.length >= Villagers.length && Werewolves.length == 0))){
            day();
        }

        //----------------------------------------------------------------------------------------------------------
    }

    //----------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------
    //-- Misc --------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    String Get_Role() throws SQLException {
        String Query = "SELECT Role WHERE Username = "+ Get_Username() +";";
        SQL_Controller s = new SQL_Controller();
        ResultSet rs = s.Get_Data(Query);
        rs.next();
        String role = rs.getString("Role");
        return role;
    }

    String Get_Username(){
        String username = Username;
        return username;
    }

    void Set_In_Game_Role(String role){
        In_Game_Role = role;
    }

    String Get_Local_Role(){
        String role = In_Game_Role;
        return role;
    }

    public void Change_Scene(ActionEvent event, String File) throws IOException { // Changes the scene based off of the File name given
        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(File)));
        Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    void Swap_Roles(String Username1, String Username2) throws SQLException {
        String q1 = "SELECT * FROM "+Game_Code+"_Players WHERE Username = '"+Username1+"';";
        String q2 = "SELECT * FROM "+Game_Code+"_Players WHERE Username = '"+Username2+"';";
        SQL_Controller s = new SQL_Controller();

        ResultSet rs1 = s.Get_Data(q1);
        ResultSet rs2 = s.Get_Data(q2);

        String Role1 = rs1.getString("Role");
        String Role2 = rs2.getString("Role");

        String q3 = "UPDATE "+Game_Code+"_Players\nSET Role = '"+Role2+"'\n WHERE Username = '"+Username1+"';";
        String q4 = "UPDATE "+Game_Code+"_Players\nSET Role = '"+Role1+"'\n WHERE Username = '"+Username2+"';";

        s.Write_Data(q3);
        s.Write_Data(q4);
    }

    void Convert_To_Minion(String Username) throws SQLException {
        String q1 = "SELECT Role FROM "+ Game_Code+"_Players WHERE Username = '"+ Username + "';";
        SQL_Controller s = new SQL_Controller();
        ResultSet rs = s.Get_Data(q1);
        rs.next();
        String role = rs.getString("Role");
        if (!role.contains("MINION")){
            role = role + " MINION";
            String q2 = "UPDATE "+Game_Code+"_Players \nSET Role = '"+ role + "' \nWHERE Username = '"+ Username +"';";
            s.Write_Data(q2);
            Number_of_Minions++;
        }
    }

    //----------------------------------------------------------------------------------------------------------

    public String Get_Most_Votes() throws SQLException {
        SQL_Controller s = new SQL_Controller();
        String q = "SELECT * FROM "+Game_Code+"_Players";

        ResultSet rs = s.Get_Data(q);
        rs.next();
        String Max_Username = "";
        int Most_Votes = 0;

        try{
            while (true){
                if (rs.getInt("Votes") > Most_Votes){
                    Most_Votes = rs.getInt("Votes");
                    Max_Username = rs.getString("Username");
                }
                rs.next();
            }

        }
        catch (Exception e){
            if(e.toString().equals("java.sql.SQLException: Illegal operation on empty result set.")){
                return Max_Username;
            }
        }
        return Max_Username;
    }

    void Hangman(int j, Label Guesses, Label Targets_Username_Displayed) throws SQLException, IOException {

        Tracker_Number = j;

        SQL_Controller s = new SQL_Controller();
        String q1;

        q1 = "SELECT * FROM "+ Game_Code +"_Players WHERE Role = 'WEREWOLF' OR Role = 'VAMPIRE' OR Role = 'VAMPIRE';";
        ResultSet rs = s.Get_Data(q1);
        rs.next();

        String[] Night_Usernames;

        if (Werewolves.length == 2){
            Night_Usernames = new String[]{"", "", "", "", ""};
            Night_Usernames[0] = rs.getString("Username");
            rs.next();
            Night_Usernames[1] = rs.getString("Username");
            rs.next();
            Night_Usernames[2] = rs.getString("Username");
            rs.next();
            Night_Usernames[3] = rs.getString("Username");
            rs.next();
            Night_Usernames[4] = rs.getString("Username");
        }
        else{
            Night_Usernames = new String[]{"", "", "", ""};
            Night_Usernames[0] = rs.getString("Username");
            rs.next();
            Night_Usernames[1] = rs.getString("Username");
            rs.next();
            Night_Usernames[2] = rs.getString("Username");
            rs.next();
            Night_Usernames[3] = rs.getString("Username");
        }

        String Inquisitor_Current = "";

        if (j == 1){
            Guesses.setText(Inquisitor_Guesses1);
            Inquisitor_Current = Inquisitor_Guesses1;
        }
        else if (j == 2){
            Guesses.setText(Inquisitor_Guesses2);
            Inquisitor_Current = Inquisitor_Guesses2;
        }
        else if (j == 3){
            Guesses.setText(Inquisitor_Guesses3);
            Inquisitor_Current = Inquisitor_Guesses3;
        }
        else if (j == 4){
            Guesses.setText(Inquisitor_Guesses4);
            Inquisitor_Current = Inquisitor_Guesses4;
        }
        else if (j == 5){
            Guesses.setText(Inquisitor_Guesses5);
            Inquisitor_Current = Inquisitor_Guesses5;
        }

        if (!(j < Night_Usernames.length)){
            j = Night_Usernames.length - 2;
        }
        else{
            j = j - 1;
        }



        Tracker = Usernames[j];

        String message = "";

        for (int i = 0; i < Tracker.length(); i++){
            for (int x = 0; x < Inquisitor_Current.length(); x++){
                if (Tracker.charAt(i) == Inquisitor_Current.charAt(x)){
                    message = message + Tracker.charAt(i);
                }
                else message = message + "-";
            }
        }

        Targets_Username_Displayed.setText(message);

        Change_Scene(new ActionEvent(), "Inquisitor-Choose-Character-Screen.fxml");
    }

    void Hangman_Guess(String Guess){

        String guess2 = String.valueOf(Guess.charAt(0));

        // It's right
        if (Tracker_Number == 1){
            Inquisitor_Guesses1 = Inquisitor_Guesses1 + guess2;
        }
        else if (Tracker_Number == 2){
            Inquisitor_Guesses2 = Inquisitor_Guesses2 + guess2;
        }
        else if (Tracker_Number == 3){
            Inquisitor_Guesses3 = Inquisitor_Guesses3 + guess2;

        }
        else if (Tracker_Number == 4){
            Inquisitor_Guesses4 = Inquisitor_Guesses4 + guess2;

        }
        else if (Tracker_Number == 5){
            Inquisitor_Guesses5 = Inquisitor_Guesses5 + guess2;

        }
    }

    void Wait_For_Single(String role) throws SQLException {
        SQL_Controller s = new SQL_Controller();
        String q = "SELECT * WHERE Role = '"+role+"';";


        ResultSet rs = s.Get_Data(q);
        rs.next();

        while (rs.getInt("Voted") == 1){
            rs = s.Get_Data(q);
            rs.next();
        }
    }

    void Wait_For_Vampire() throws SQLException {
        SQL_Controller s = new SQL_Controller();
        String q = "SELECT * FROM "+Game_Code+"_Players WHERE Role = 'VAMPIRE'";

        ResultSet rs = s.Get_Data(q);
        rs.next();

        while (true) {
            int j = 0;

            for (int i = 0; i <= Number_of_Minions; i++) {
                j = j + rs.getInt("Voted");
                rs.next();
            }
            if (j == Number_of_Minions) {
                break;
            }
            else{
                rs = s.Get_Data(q);
                rs.next();
            }
        }


    }

    void Wait_For_Everyone() throws SQLException {
        SQL_Controller s = new SQL_Controller();
        String q = "SELECT * FROM "+Game_Code+"_Players WHERE NOT Role = 'DEAD';";

        ResultSet rs = s.Get_Data(q);
        rs.next();

        while (true){
            int j = 0;

            for (int i = 0; i < Usernames.length; i++){
                j = j + rs.getInt("Voted");
                rs.next();
            }

            if(j == Usernames.length){
                break;
            }
            else{
                rs = s.Get_Data(q);
                rs.next();
            }
        }
    }
}

