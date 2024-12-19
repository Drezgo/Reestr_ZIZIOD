package com.individualproject_v2;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;


public class SecondController implements Initializable {


    @FXML
    private void goTo1() throws Exception {
        // Перехід на друге вікно
        MainApplication.changeScene("main-scene-view.fxml", true);
    }

    @FXML
    private void goTo3() throws Exception {
        // Перехід на друге вікно
        MainApplication.changeScene("third-scene-view.fxml", true);
    }



    @FXML
    private void openHyperlink() {
        MainApplication.hyperlink();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
