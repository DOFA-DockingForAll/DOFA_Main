import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PS1Handler {
	private String root;
	private String[] programList;
	
	PS1Handler(){
		root = "";
		programList = new String[0];
	}
	
	PS1Handler(String root, String[] programList){
		this.root = root;
		this.programList = new String[programList.length];
		for(int i = 0; i < programList.length; i++)
			this.programList[i] = programList[i]; 
	}
	
	public boolean setRoot(String root) {
		File f = new File(root);
		if(f.isDirectory()) { // ���丮 ��� ���� Ȯ��
			this.root = root;
			return true;
		}
		else
			return false; // ���丮 ���� ����
	}
	
	public int setProgramList(String[] programList) {
		this.programList = new String[programList.length];
		
		for(int i = 0; i < programList.length; i++)
			this.programList[i] = this.programList[i]; 
		return this.programList.length; // ����� ������ ���� ����
	}
	
	public boolean makePS1() {
		if(this.root == "")
			return false; // ���丮 ��� ����
		if(this.programList.length == 0)
			return false; // ��ġ ��� ���α׷� ����
		
		try {
			FileOutputStream output = new FileOutputStream(this.root + "programInstall.ps1");
			String data = "cd " + root +"\n\n";
			String temp = "";
			for(int i = 0; i < this.programList.length; i++) {
				temp = "Start-Process -FilePath \"msiexec\" -Wait -ArgumentList '/quiet /i \"";
				temp += programList[i];
				temp += "\" WRAPPED_ARGUMENTS=\"/S\"'";
				data += temp + "\n\n";
			}
			System.out.println(data);
			try {
				output.write(data.getBytes());
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
//	public static void main(String [] args) {
//		String[] arr = new String[2];
//		arr[0] = "Firefox Setup 14.0.1.msi";
//		arr[1] = "AtomSetup-x64.msi";
//		PS1Handler ph = new PS1Handler("D:/RohYounwoo/javaCode/Basic/src/", arr);
//		if(ph.makePS1())
//			System.out.println("�ۼ��Ϸ�");
//		else
//			System.out.println("�ۼ�����");
//		
//	}
	
	
}
