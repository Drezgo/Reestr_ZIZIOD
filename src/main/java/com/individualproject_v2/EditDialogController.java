package com.individualproject_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialogController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtMODEL;

    @FXML
    private TextField txtNUM;

    @FXML
    private TextField txtPIP;

    @FXML
    private TextField txtPRESS;
    private Reyestr reyestr;

    public Reyestr getPerevirka() {
        return reyestr;
    }

    public void setPerevirka(Reyestr reyestr) {
        this.reyestr = reyestr;
        txtPIP.setText(reyestr.getPIP());
        txtPRESS.setText(reyestr.getPRESS());
        txtMODEL.setText(reyestr.getMODEL());
        txtNUM.setText(reyestr.getNUM());
    }

    @FXML
    void actionSave(ActionEvent event) {
        reyestr.setPIP(txtPIP.getText());
        reyestr.setPRESS(txtPRESS.getText());
        reyestr.setMODEL(txtMODEL.getText());
        reyestr.setNUM(txtNUM.getText());
        actionClose(event);
    }

    @FXML
    void actionClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
