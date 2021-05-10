package javaChecklist;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Checklist extends JFrame {
	
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
		
		a = new JLabel("");
		
		for(int i = 0; i < arr.length; i++) {
			c[i] = new JCheckBox(arr[i].getMsiFilename());
			c[i].setBorderPainted(true);
			c[i].addItemListener(new CheckItemListener());
			this.add(c[i]);
		}
		this.add(a);
		this.setVisible(true);
		
	}
	class CheckItemListener implements ItemListener{

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
}
