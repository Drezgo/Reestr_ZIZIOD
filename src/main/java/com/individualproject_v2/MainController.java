package com.individualproject_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ImageView add_btn;

    @FXML
    private Button del_btn;

    @FXML
    private ImageView edit_btn;

    @FXML
    private Button help_btn;

    @FXML
    private HBox main;

    @FXML
    private ImageView search_btn;

    @FXML
    private Button side_btn1;

    @FXML
    private Button side_btn2;

    @FXML
    private Button side_btn3;

    @FXML
    private AnchorPane side_panel;

    @FXML
    private Pane title_pane;


    // Інше поле stage
    private Stage stage;

    // Ініціалізуємо stage для подальшого доступу
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Метод для переходу на другу сцену
    @FXML
    public void switchToScene2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/individualproject_v2/second-scene-view.fxml"));
        Parent root = loader.load();
//
//        MainController mainSceneController = loader.getController();
//        mainSceneController.setStage(stage);

        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }

    // Метод для повернення на головну сцену
//    @FXML
//    public void switchToScene1() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/individualproject_v2/main-scene-view.fxml"));
//        Parent root = loader.load();
////
////        MainController mainSceneController = loader.getController();
////        mainSceneController.setStage(stage);
//
//        stage.setScene(new Scene(root, 900, 600));
//        stage.show();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Інші ініціалізації
    }

    // Виклик цього методу для встановлення початкової сцени
//    public void start(Stage primaryStage) throws IOException {
//        this.stage = primaryStage;
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/individualproject_v2/main-scene-view.fxml"));
//        Parent root = loader.load();
//
//        // Передаємо stage в головний контролер
//        MainController mainController = loader.getController();
//        mainController.setStage(primaryStage);
//
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
}