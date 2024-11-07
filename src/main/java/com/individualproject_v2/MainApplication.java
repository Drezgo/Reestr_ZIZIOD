package com.individualproject_v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/individualproject_v2/main-scene-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        MainController mainController = fxmlLoader.getController();
        mainController.setStage(stage);
        SecondController secondController = fxmlLoader.getController();
        secondController.setStage(stage);

        Image image = new Image(MainApplication.class.getResourceAsStream("/images/dsns.png"));
        stage.getIcons().add(image);

        stage.setTitle("Єдиний реєстр ЗІЗІОД");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}