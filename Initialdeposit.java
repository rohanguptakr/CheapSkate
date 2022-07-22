package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Initialdeposit implements Initializable {

	    @FXML
	    private TextField balamount;

	    @FXML
	    private ComboBox<String> bankname;

	    @FXML
	    private Button submit;

	    @FXML
	    void userlogin(ActionEvent event) {
	    		
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			bankname.setItems(FXCollections.observableArrayList("Axis","ICICI","Kotak","SBI","HDFC","Bank of Baroda","Others"));
		}

}
