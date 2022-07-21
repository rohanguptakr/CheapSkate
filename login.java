package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class login {
	
    @FXML
    private Button button;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label wronglogin;
    
    @FXML
    private Button signup;
    
    @FXML
    private ImageView image;
    
    @FXML
    private ProgressBar progressbar;
	
    public login(){
    	
    }
    
    class progressb implements Runnable{
    	Thread t;
    	progressb(){
    		t = new Thread(this);
    		t.start();
    	}
    	public void run() {
			try {
    		for(int i=1;i<100;i++) {
    			progressbar.setProgress(i/100.0);
    			Thread.sleep(10);
    		}
    		}catch(InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    @FXML
    void userLogin(ActionEvent event) throws Exception {
    	progressb pb = new progressb();
    	try {
    		pb.t.join();
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    	checkLogin();
    }
    
    @FXML
    void userSignup(ActionEvent event) throws Exception{
    	Main m = new Main();
    	m.changeScene("Signup.fxml");
    }
    
    private void checkLogin() throws Exception{
    	String uname;
    	String pass;
    	int f=0;
    	if(username.getText().isEmpty()&&password.getText().isEmpty()) {
    		wronglogin.setText("Enter the required information");
    		return;
    	}
    	uname=username.getText().toString();
    	pass=password.getText().toString();
    	f = DBUtils.Checkinfo(uname, pass);
    	if(f==1) {
    		wronglogin.setText("Username does not exist");
    		return;
    	}
    	if(f==2) {
    		wronglogin.setText("Incorrect Password!");
    		return;
    	}   	
    }
}