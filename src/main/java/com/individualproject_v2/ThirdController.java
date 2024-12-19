package com.individualproject_v2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdController implements Initializable {



    @FXML
    private void goTo1() throws Exception {
        // Перехід на друге вікно
        MainApplication.changeScene("main-scene-view.fxml", true);
    }

    @FXML
    private void goTo2() throws Exception {
        // Перехід на друге вікно
        MainApplication.changeScene("second-scene-view.fxml", true);
    }

    @FXML
    private void openHyperlink() {
        MainApplication.hyperlink();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
