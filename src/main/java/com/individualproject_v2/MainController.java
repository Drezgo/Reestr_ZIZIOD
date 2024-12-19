package com.individualproject_v2;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label labelCount;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnFind;

    @FXML
    private TextField searchField;

    private Stage newStage;
    private Stage editDialogStage;
    Scene scene;
    private EditDialogController editDialogController;
    private CollectionBook reyestrBookImpl = new CollectionBook();
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Parent root;

    @FXML
    private TableView<Reyestr> tableReyestrBook;

    ObservableList<Reyestr> filteredList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Reyestr, String> columnPIP;
    @FXML
    private TableColumn<Reyestr, String> columnPRESS;
    @FXML
    private TableColumn<Reyestr, String> columnNUM;
    @FXML
    private TableColumn<Reyestr, String> columnMODEL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fxmlLoader.setLocation(MainController.class.getResource("dialogWindow.fxml"));
            root = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
            scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        columnPIP.setCellValueFactory(new PropertyValueFactory<Reyestr, String>("PIP"));
        columnPRESS.setCellValueFactory(new PropertyValueFactory<Reyestr, String>("PRESS"));
        columnNUM.setCellValueFactory(new PropertyValueFactory<Reyestr, String>("NUM"));
        columnMODEL.setCellValueFactory(new PropertyValueFactory<Reyestr, String>("MODEL"));

        reyestrBookImpl.getReyestrList().addListener(new ListChangeListener<Reyestr>() {
            @Override
            public void onChanged(Change<? extends Reyestr> c) {
                updateCountLabel();
            }
        });

        tableReyestrBook.setItems(reyestrBookImpl.getReyestrList()); //оновлення після кожної дії
    }


    @FXML
    void showDialog() throws IOException {
        editDialogStage = new Stage();
        editDialogStage.setScene(scene);
        editDialogStage.setTitle("Вікно редагування");

        editDialogStage.setResizable(false);
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.initOwner(newStage);

        editDialogStage.showAndWait();
    }

    @FXML
    void openWindow(ActionEvent event) throws IOException, URISyntaxException {
        Button clickedButton = (Button) event.getSource();
        switch (clickedButton.getId()){
            case "btnAdd":
                editDialogController.setPerevirka(new Reyestr());
                showDialog();
                reyestrBookImpl.add(editDialogController.getPerevirka());
//                tableReyestrBook.refresh();
                break;
            case "btnEdit":
                Reyestr selectedPerson = tableReyestrBook.getSelectionModel().getSelectedItem();
                if (selectedPerson != null) {
                    editDialogController.setPerevirka(selectedPerson);
                    showDialog();
                    tableReyestrBook.refresh();
                } else {
                    showAlert("Помилка", "Виберіть запис для редагування!");
                }
                break;
            case "btnDel":
                conformationAlert();
                break;
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    void conformationAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення");
        alert.setContentText("Ви впевненні, що хочете видалити запис? ");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL); // Зберігаємо результат тут

        if (result == ButtonType.OK) {
            reyestrBookImpl.delete((Reyestr) tableReyestrBook.getSelectionModel().getSelectedItem());
            filteredList.remove((Reyestr) tableReyestrBook.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void showSearch(ActionEvent event) {
        String searchText = searchField.getText().toLowerCase();
        filteredList = FXCollections.observableArrayList();
        for (Reyestr person : reyestrBookImpl.getReyestrList()) {
            if (person.getPIP().toLowerCase().contains(searchText) || person.getNUM().contains(searchText) || person.getMODEL().contains(searchText)|| person.getPRESS().contains(searchText)) {
                filteredList.add(person);
            }
        }
        tableReyestrBook.setItems(filteredList);
    }

    private void updateCountLabel(){
        labelCount.setText("Кількість записів: " + reyestrBookImpl.getReyestrList().size());
    }

    @FXML
    private void goTo2() throws Exception {
        // Перехід на друге вікно
        MainApplication.changeScene("second-scene-view.fxml", true);
    }

    @FXML
    private void goTo3() throws Exception {
        // Перехід на друге вікно
        MainApplication.changeScene("third-scene-view.fxml", true);
    }

//    private void goBack() {
//        // Повернення до попереднього вікна
//        MainApplication.goBack();
//    }

    @FXML
    private void openHyperlink() {
        MainApplication.hyperlink();
    }
}