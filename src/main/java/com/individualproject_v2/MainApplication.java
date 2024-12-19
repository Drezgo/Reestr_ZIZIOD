package com.individualproject_v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class MainApplication extends Application {
    private static Stage primaryStage;
    private static Scene previousScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/individualproject_v2/main-scene-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        primaryStage = stage;

        Image image = new Image(MainApplication.class.getResourceAsStream("/images/dsns.png"));
        stage.getIcons().add(image);

        stage.setTitle("Єдиний реєстр ЗІЗІОД");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setResizable(true);
        stage.show();
    }

    public static void changeScene(String fxmlFile, boolean savePrevious) throws Exception {
        if (savePrevious) {
            previousScene = primaryStage.getScene();
        }
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(loader.load(),900, 600);
        primaryStage.setScene(scene);
    }

    public static void goBack() {
        if (previousScene != null) {
            primaryStage.setScene(previousScene);
            previousScene = null; // Очистити попередню сцену після повернення
        }
    }

    public static void hyperlink() {
        String url = "https://moz.gov.ua/uk/garjachi-linii-psihologichnoi-dopomogi"; // посилання

        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.err.println("Відкриття браузера не підтримується.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}