/**
 *  TEAM MEMBERS - Group 1
 * Nico Derilo
 * Aidan Goguen
 * Sai Shalini Karaikatte Venugopal
 * Stan Abana
 */

package com.example.workshop6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1125, 684);
        stage.setTitle("Travel Experts");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}