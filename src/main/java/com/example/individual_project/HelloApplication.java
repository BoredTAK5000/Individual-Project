package com.example.individual_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import java.sql.*;

public class HelloApplication extends Application {

    private Scene Scene;

    private Parent Root;

    @Override
    public void start(Stage stage) throws IOException {

        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Werewolf-Title-Screen.fxml")));
        stage.setFullScreen(true); // I don't understand why it works but if I remove these 2 lines things get wonky
        stage.setFullScreen(false);// Praise the omnissiah I guess...
        Scene = new Scene(Root);
        stage.setTitle("WEREWOLF");
        stage.setScene(Scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}