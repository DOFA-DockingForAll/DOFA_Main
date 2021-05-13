package javaChecklist;

import java.awt.*;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> origin/main
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Checklist extends JFrame {
<<<<<<< HEAD
	JFrame frame;
	InstFile f1 = new InstFile("atom", "atom");
	InstFile f2 = new InstFile("firefox", "firefox");
	InstFile f3 = new InstFile("DevC", "DevC");
	InstFile[] arr = {f1, f2, f3};
	JLabel a;
	JCheckBox[] c = new JCheckBox[arr.length];
	Button btnDL = new Button("download");
	
	Checklist(){
		setTitle("DOFA testmode");
		setSize(300, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
=======
	
	InstFile f1 = new InstFile("atom", "atom");
	InstFile f2 = new InstFile("firefox", "firefox");
	InstFile f3 = new InstFile("python", "python");
	InstFile[] arr = {f1, f2, f3};
	JLabel a;
	JCheckBox[] c = new JCheckBox[arr.length];
	String result = "";
	
	Checklist(){
		this.setTitle("DOFA testmode");
		this.setSize(300, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
>>>>>>> origin/main
		
		a = new JLabel("");
		
		for(int i = 0; i < arr.length; i++) {
			c[i] = new JCheckBox(arr[i].getMsiFilename());
			c[i].setBorderPainted(true);
			c[i].addItemListener(new CheckItemListener());
			this.add(c[i]);
		}
<<<<<<< HEAD
		add(a);
		add(btnDL);
		setVisible(true);
		
	}
	public String[] retChecklist(InstFile[] arr) {
		String[] check = new String[arr.length];
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].select == "checked") {
				check[cnt] = arr[i].getMsiFilename();
				cnt++;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(check[i]);
		}
		return check;
	}
	class CheckItemListener implements ItemListener{
=======
		this.add(a);
		this.setVisible(true);
		
	}
	class CheckItemListener implements ItemListener{

>>>>>>> origin/main
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem() == c[0]) {
				arr[0].select(e.getStateChange() == 1 ? "checked" : "unchecked");
			}
			else if(e.getItem() == c[1]) {
				arr[1].select(e.getStateChange() == 1 ? "checked" : "unchecked");
			}
			else if(e.getItem() == c[2]) {
				arr[2].select(e.getStateChange() == 1 ? "checked" : "unchecked");
			}
<<<<<<< HEAD
			else if(e.getItem() == btnDL) {
				frame.setVisible(false);
				//list넘겨주는 명령어 실행
				//명령어(retChecklist(arr));
			}
			else {
				return;
			}
			//retChecklist(arr);
		}
	}
	
=======
			else {
				return;
			}
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].select == "checked") {
					a.setText(arr[i].getMsiFilename());
					//result = result + "\n" + arr[i].getMsiFilename();
				}
			}
			a.setText(result);
		}
		
	}
>>>>>>> origin/main
}
