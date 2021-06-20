package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RottController implements Initializable {
	@FXML
	private CheckBox checkBoxAtom, checkBoxDevCpp;
	int btnCtn = 3;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	@FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    public void Login(ActionEvent event) throws Exception{
    	Stage stage = (Stage)txtUserName.getScene().getWindow();
    	
        if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){//어디서 갖고오기
            lblStatus.setText("Login Success");
            Parent main = FXMLLoader.load(getClass().getResource("/application/checklist.fxml"));
            
            Scene scene = new Scene(main);
            stage.setScene(scene);
            stage.show();
        }else{
            lblStatus.setText("Login Failed");
        }
    }
	
	public void handledownloadBtn() {
		List<String> CBList = new ArrayList<String>();
		String checkname;
		if(checkBoxAtom.isSelected()) {
			checkname = checkBoxAtom.getText().toString()+".msi";
			CBList.add(checkname);
		}
		if(checkBoxDevCpp.isSelected()) {
			checkname = checkBoxDevCpp.getText().toString()+".msi";
			CBList.add(checkname);
		}
		
		for(String check: CBList) {
			System.out.println(check);
		}
		//list.clear(리스트로 바꾸기..)
	}

}

