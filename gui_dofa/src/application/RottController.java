package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
<<<<<<< HEAD
import java.lang.reflect.InvocationTargetException;
=======
>>>>>>> 2a298c61705671a47614d248860848388fdf54ac
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class RottController implements Initializable {
	private String filename, file;
	private List<String> DLlist = new ArrayList<String>();
	@FXML
	private CheckBox checkBoxAtom, checkBoxDevCpp;
<<<<<<< HEAD
	private String[] log = new String[4];
=======
	
>>>>>>> 2a298c61705671a47614d248860848388fdf54ac
	@FXML
    private BorderPane bp;
	@FXML
    private AnchorPane ap;
	@FXML
    private FlowPane list;
	@FXML
<<<<<<< HEAD
	private CheckBox checkbox1;
	@FXML
	private CheckBox checkbox2;
	@FXML
	private CheckBox checkbox3;
	@FXML
	private CheckBox checkbox4;
//	private CheckBox[] chids = {checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10};
//	private CheckBox[] chids = new CheckBox[4];
=======
	private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10;
	private CheckBox[] chids = {checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10};
>>>>>>> 2a298c61705671a47614d248860848388fdf54ac
	
//    @FXML
//    private List<CheckBox> checkBox = new ArrayList<CheckBox>();
//    
//	private List<String> log = new ArrayList<String>();//파일명들 제공
	
	@Override
    public void initialize(URL location, ResourceBundle resources) { //체크박스 만들기
    }
	@FXML
    private TextField txtUserName, txtPassword;
    
    @FXML
    private Label lblStatus;
    
	@FXML
	public void Login(ActionEvent event) throws Exception{
    	Stage stage = (Stage)txtUserName.getScene().getWindow();
    	
        if(txtUserName.getText().equals("chavi55") && txtPassword.getText().equals("pass")){//어디서 갖고오기
            lblStatus.setText("Login Success");
<<<<<<< HEAD
            Parent main = FXMLLoader.load(getClass().getResource("/application/SideBar.fxml"));
            
            Scene scene = new Scene(main);
            stage.setScene(scene);
            
            stage.show();
            
=======
            Parent main = FXMLLoader.load(getClass().getResource("SideBar.fxml"));
            
            Scene scene = new Scene(main);
            stage.setScene(scene);
            stage.show();
>>>>>>> 2a298c61705671a47614d248860848388fdf54ac
        }else{
            lblStatus.setText("Login Failed");
        }
    }
<<<<<<< HEAD
	public void update() {
		log[0] = "d";
		log[1] = "dd";
		log[2] = "ddd";
		log[3] = "DDDD";
    	checkbox1.setText(log[0]);
    	checkbox1.setVisible(true);
    	checkbox2.setText(log[1]);
    	checkbox2.setVisible(true);
    	checkbox3.setText(log[2]);
    	checkbox3.setVisible(true);
    	checkbox4.setText(log[3]);
    	checkbox4.setVisible(true);
	}
    public void downBtn() {
    	List<String> logSelect = new ArrayList<String>();
    	if(checkbox1.isSelected()) {
    		String checkedname = checkbox1.getText();
    		logSelect.add(checkedname);//다운로드 파일명 리스트
    	}
    	if(checkbox2.isSelected()) {
    		String checkedname = checkbox2.getText();
    		logSelect.add(checkedname);//다운로드 파일명 리스트
    	}
    	if(checkbox3.isSelected()) {
    		String checkedname = checkbox3.getText();
    		logSelect.add(checkedname);//다운로드 파일명 리스트
    	}
    	if(checkbox4.isSelected()) {
    		String checkedname = checkbox4.getText();
    		logSelect.add(checkedname);//다운로드 파일명 리스트
    	}
    }
    @FXML
    private void home(MouseEvent e) {
=======
	@FXML
	public void update() {
		String[] log= {"DD","D", "dddd"};
    	int cnt = 0;
    	for(String logfilename : log) {
    		System.out.println(logfilename);
    		chids[cnt].setText(logfilename);
    		chids[cnt].setVisible(true);
    		cnt++;
    	}
	}
    @FXML
    public void downBtn() {
    	List<String> logSelect = new ArrayList<String>();
    	for(CheckBox check: chids) {
    		
    		if(check.isSelected()) {
    			String checkedname = check.getText();
    			logSelect.add(checkedname);//다운로드 파일명 리스트
    		}
			System.out.println(check);
		}
    }
    @FXML
    private void home(MouseEvent e) {
    	checkbox1.setVisible(true);
>>>>>>> 2a298c61705671a47614d248860848388fdf54ac
    	loadPage("home");
    }
    @FXML
    private void checklist(MouseEvent e) {
    	loadPage("checklist");
    }
    @FXML
    private void person(MouseEvent e) {
    	loadPage("person");
    }
    @FXML
	private void loadPage(String page) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(page+".fxml"));
			bp.setCenter(root);
		}catch(IOException ex) {
		}
	}
	@FXML
	public void handledownloadBtn() {
		String checkedname;
	
		if(checkBoxAtom.isSelected()) {
			checkedname = checkBoxAtom.getText().toString()+".msi";
			DLlist.add(checkedname);
		}
		if(checkBoxDevCpp.isSelected()) {
			checkedname = checkBoxDevCpp.getText().toString()+".msi";
			DLlist.add(checkedname);
		}
		
		for(String check: DLlist) {
			System.out.println(check);
		}
	}
	@FXML
	public void handleOpenFileChoower() {
		JFileChooser chooser = new JFileChooser();
		int ret = chooser.showOpenDialog(null);
		
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			System.out.println(false);
		}
		else {
			file = chooser.getSelectedFile().getName();//확장자 포함 파일명
			int pos = file.lastIndexOf(".");
			filename = file.substring(0, pos);//확장자 제외 파일명만 따온 것
			
			Label label = new Label(file);
			label.setMinWidth(1000);
			label.setMinHeight(20);
			label.setFont(Font.font("Hancom Gothic Regular", FontWeight.BOLD, 20));
			list.getChildren().add(label);
			DLlist.add(file);
			
			String oriPath = chooser.getSelectedFile().getPath();
			String copyPath = "./src/file/" + file;//복사파일경로
			copyFile(oriPath, copyPath);
		}
	}
	
	public void copyFile(String oriPath, String copyPath) {
		File oriFile = new File(oriPath);
		File copyFile = new File(copyPath);
		
		try {
			FileInputStream fis = new FileInputStream(oriFile);
			FileOutputStream fos = new FileOutputStream(copyFile);
			
			int fileByte = 0;
			while((fileByte = fis.read()) != -1) {
				fos.write(fileByte);
			}
			fis.close();
			fos.close();
			System.out.println("파일복사완료");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
