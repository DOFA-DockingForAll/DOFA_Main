
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;



public class Checklist extends JFrame{
	private static String[] exe = new String[2];
	private static String[] msi = new String[2];
	private static String[] file = new String[2];
	private static  ArrayList<InstFile> list = new ArrayList<InstFile>();
	private static ArrayList<JCheckBox> cblist = new ArrayList<JCheckBox>();
	private static String[] result;
	private static boolean selected;
	
	Checklist(){
		selected = false;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public String[] getFileList() {
		return result;
	}
	
	JFrame frame;
	
	public void addFile(String exeFileName, String msiFileName) {
		list.add(new InstFile(exeFileName, msiFileName));
	}
	
	
	public void run(){
		
//		InstFile[] arr = new InstFile[];

		setTitle("DOFA testmode");
		setSize(500, 500);
		
		createChBox();
		
		//컴포넌트 위치 정하기
		
		Button btnDL = new Button("download");
		btnDL.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				result = retChecklist(list);
				//파일 다운로드 함수호출(result);
				selected = true;
				ExecuteFile ef = new ExecuteFile();
				ef.setFiles(result);
				ef.startInstall();
				System.exit(0);
				//return;
				//dispose();한 프레임만 삭제
			}
		});
		
		Button btnExefile = new Button("exe파일 선택");
		btnExefile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChoose();
				exe[0] = file[0];
				exe[1] = file[1];
			}
		});
		
		
		Button btnMsifile = new Button("msi파일 선택");
		btnMsifile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChoose();
				msi[0] = file[0];
				msi[1] = file[1];
			}
		});
		
		
		Button btnAddfile = new Button("파일 추가하기");
		btnAddfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InstFile newInstFile = new InstFile();
//				int count = InstFile.getCount();
				newInstFile.setExeFilename(exe[0]);
				newInstFile.setMsiFilename(msi[0]);
				//System.out.print(count);
				list.add(newInstFile);
				cblist.add(new JCheckBox(list.get(list.size()-1).getExeFilename()));
				
				copyFile(exe[1], System.getProperty("user.dir")+"\\files\\"+exe[0]);
				copyFile(msi[1], System.getProperty("user.dir")+"\\files\\"+msi[0]);
//				System.out.println(exe[1]);
//				System.out.print(list.get(list.size()-1).getExeFilename());
//				System.out.println(", " + list.get(list.size()-1).getMsiFilename());
//				arr[counter] = newInstFile;
				createChBox();
				setVisible(true);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		add(btnExefile);
		add(btnMsifile);
		add(btnAddfile);
		add(btnDL);
		setVisible(true);
	}
	public void copyFile(String oriPath, String copyPath){
//		String copyPath = "C:\\Users\\user\\Desktop\\DOFA_GY\\files\\" + exe[0]; //복사파일경로
		File oriFile = new File(oriPath);
		File copyFile = new File(copyPath);
		
		try {
			FileInputStream fis = new FileInputStream(oriFile);
			FileOutputStream fos = new FileOutputStream(copyFile);
			
			int fileByte = 0;
			while((fileByte = fis.read()) != -1){
				fos.write(fileByte);
			}
			fis.close();
			fos.close();
//			System.out.println("파일복사완료");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void createChBox() {
		for(int i = 0; i < list.size(); i++) {
			cblist.add(new JCheckBox(list.get(i).getExeFilename()));
			cblist.get(i).setBorderPainted(true);
			cblist.get(i).addItemListener(new CheckItemListener());
			add(cblist.get(i));
		}
	}
	
	public void fileChoose() {
		//JLabel lb = new JLabel();
		file[0] = "";
		file[1] = "";
		JFileChooser chooser = new JFileChooser();
		int ret = chooser.showOpenDialog(null);
		
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			System.out.println(false);
		}
		else {
			String filename = chooser.getSelectedFile().getName(); //파일 이름 받는것으로만 수정
//			int pos = filename.lastIndexOf(".");
//			file[0] = filename.substring(0, pos);
			file[0] = filename;
			file[1] = chooser.getSelectedFile().toString();
			
			System.out.println(file[0]);
			System.out.println(file[1]);
		}
		
//		System.out.println(path);
//		System.out.println(list.size());
//		System.out.println(cblist.size());
		
		//lb.setText(ext + ".exe");
	}
	private String[] retChecklist(ArrayList<InstFile> list) {
		int cnt = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).select == "checked") {
				cnt++;
			}
		}
		
		String[] check = new String[cnt];
		cnt=0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).select == "checked") {
				check[cnt] = list.get(i).getMsiFilename();
				//System.out.print(check[cnt]);
				cnt++;
			}
		}
		return check;
	}
	class CheckItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			for(int i= 0; i < list.size(); i++) {
				if(e.getItem() == cblist.get(i)) {
					list.get(i).select(e.getStateChange() == 1 ? "checked" : "unchecked");
				}
			}
			
			//retChecklist(arr);
		}
	}
	
}
