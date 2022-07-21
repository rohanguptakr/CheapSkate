package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class homepage implements Initializable{

    @FXML
    private PieChart expenditure;
    
    @FXML
    private Button profile;
    
    @FXML
    private Label display;
    
    @FXML
    private Label username;
    
    @FXML
    private Label currbal;
    
    @FXML
    private Label expenses;
    
    @FXML
    private Button manage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	username.setText(DBUtils.username);
    	ObservableList<PieChart.Data> piechartdata = FXCollections.observableArrayList(
    			new PieChart.Data("Food", 45),
    			new PieChart.Data("Entertainment", 25),
    			new PieChart.Data("Transport", 15),
    			new PieChart.Data("Shopping", 10),
    			new PieChart.Data("Miscellaneous", 5)
    			);
    	expenditure.setData(piechartdata);
    	
    	for(final PieChart.Data data : expenditure.getData()) {
    		data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
    				new EventHandler<MouseEvent>() {
    					public void handle(MouseEvent e) {
    						display.setText(String.valueOf(data.getPieValue())+"%");
    					}
    			});
    		}
    			
    }

    @FXML
    void userProfile(ActionEvent event) throws Exception {
    	Main m = new Main();
    	m.changeScene("profile.fxml");
    }
    
    @FXML
    void manageExpenses(ActionEvent event) throws Exception {
    	Main m =new Main();
    	m.changeScene("Expenditures.fxml");
    }
    

}

