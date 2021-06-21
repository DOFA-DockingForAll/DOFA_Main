package javaChecklist;

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

public class Checklist extends JFrame {
	String[] exe = new String[2];
	String[] msi = new String[2];
	String[] file = new String[2];
	ArrayList<InstFile> list = new ArrayList<InstFile>();
	ArrayList<JCheckBox> cblist = new ArrayList<JCheckBox>();
	
	JFrame frame;
	Checklist(){
		
//		InstFile[] arr = new InstFile[];
		list.add(new InstFile("atom.exe", "atom.msi"));
		list.add(new InstFile("firefox.exe", "firefox.msi"));
		list.add(new InstFile("Devcpp.exe", "Devcpp.msi"));
		
		setTitle("DOFA testmode");
		setSize(300, 300);	
		
		createChBox();
		
		//������Ʈ ��ġ ���ϱ�
		
		Button btnDL = new Button("download");
		btnDL.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] result = retChecklist(list);
				//���� �ٿ�ε� �Լ�ȣ��(result);
				System.exit(0);
				//dispose();�� �����Ӹ� ����
			}
		});
		
		Button btnExefile = new Button("exe���� ����");
		btnExefile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChoose();
				exe[0] = file[0];
				exe[1] = file[1];
			}
		});
		
		Button btnMsifile = new Button("msi���� ����");
		btnMsifile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChoose();
				msi[0] = file[0];
				msi[1] = file[1];
			}
		});
		
		Button btnAddfile = new Button("���� �߰��ϱ�");
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
				
				copyFile(exe[1], System.getProperty("user.dir")+"\\file\\"+exe[0]);
				copyFile(msi[1], System.getProperty("user.dir")+"\\file\\"+msi[0]);
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
//		String copyPath = "C:\\Users\\user\\Desktop\\DOFA_GY\\file\\" + exe[0]; //�������ϰ��
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
//			System.out.println("���Ϻ���Ϸ�");
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
			JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
			System.out.println(false);
		}
		else {
			String filename = chooser.getSelectedFile().getName(); //���� �̸� �޴°����θ� ����
//			int pos = filename.lastIndexOf(".");
//			file[0] = filename.substring(0, pos);
			file[0] = filename;
			file[1] = chooser.getSelectedFile().toString();
			
			System.out.println(file[0]);
		}
		
//		System.out.println(path);
//		System.out.println(list.size());
//		System.out.println(cblist.size());
		
		//lb.setText(ext + ".exe");
	}
	public String[] retChecklist(ArrayList<InstFile> list) {
		String[] check = new String[list.size()];
		int cnt = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).select == "checked") {
				check[cnt] = list.get(i).getMsiFilename();
				System.out.print(check[cnt]);
				cnt++;
			}
		}
		return check;
	}
	class CheckItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem() == cblist.get(0)) {
				list.get(0).select(e.getStateChange() == 1 ? "checked" : "unchecked");
			}
			else if(e.getItem() == cblist.get(1)) {
				list.get(1).select(e.getStateChange() == 1 ? "checked" : "unchecked");
			}
			else if(e.getItem() == cblist.get(2)) {
				list.get(2).select(e.getStateChange() == 1 ? "checked" : "unchecked");
			}
			else {
				return;
			}
			//retChecklist(arr);
		}
	}
	
}
