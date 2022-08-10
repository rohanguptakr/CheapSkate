package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Initialdeposit implements Initializable {

	    @FXML
	    private TextField balamount;

	    @FXML
	    private ComboBox<String> bankname;

	    @FXML
	    private Button submit;
	    
	    @FXML
	    private Label wronginfo;

	    @FXML
	    void userlogin(ActionEvent event) throws Exception{
	    	if(balamount.getText().isEmpty()&&bankname.getValue()==null) {
	    		wronginfo.setText("Enter the inital amount in your account!");
	    	}
	    	else {
	    		String bank_name = bankname.getValue();
	    		double bal_amount=Double.parseDouble(balamount.getText());
	    		DBUtils.setinfo(bank_name,bal_amount);
	    		Main m = new Main();
	    		m.changeScene("Homepage.fxml");
	    	}
	    }

		@Override
		public void initialize(URL url, ResourceBundle rb) {
			bankname.setItems(FXCollections.observableArrayList("Axis","ICICI","Kotak","SBI","HDFC","Bank of Baroda","Others"));
		}

}