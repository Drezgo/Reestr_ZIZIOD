package com.individualproject_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class SecondController {

    @FXML
    private Button help_btn;

    @FXML
    private HBox main;

    @FXML
    private Button side_btn1;

    @FXML
    private Button side_btn2;

    @FXML
    private Button side_btn3;

    @FXML
    private AnchorPane side_panel;

    @FXML
    private ImageView title_image;

    @FXML
    private Label title_label;

    @FXML
    private Pane title_pane;

    private Stage stage;

    // Ініціалізуємо stage для подальшого доступу
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public void switchToScene1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/individualproject_v2/main-scene-view.fxml"));
        Parent root = loader.load();

        MainController mainSceneController = loader.getController();
        mainSceneController.setStage(stage);

        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }
}
