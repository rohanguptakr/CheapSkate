package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Expenditure {

    @FXML
    private Button home;

    @FXML
    private Button submit;

    @FXML
    void homepage(ActionEvent event) throws Exception {
    	Main m = new Main();
    	m.changeScene("Homepage.fxml");
    }

    @FXML
    void submitUpdate(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setContentText("Updated Expenses Successfully!");
    	alert.show();
    }

}