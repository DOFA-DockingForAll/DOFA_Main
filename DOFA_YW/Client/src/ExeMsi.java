import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class ExeMsi extends Thread{
	String root;
	String fileName;
	
	ExeMsi(String root, String fileName){
		this.root = root;
		this.fileName = fileName;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
			//ExeByAdmin.runProgramAsAdmin(root+fileName, "");//관리자 권한으로 실행
			open(root+fileName); // ps1실행
			Thread.sleep(1000);
		} catch (IOException e) {
			System.out.println("could not open");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("could not sleep");
			e.printStackTrace();
		}
	}
	

	public static void open(String targetFilePath) throws IOException
	{
	    Desktop desktop = Desktop.getDesktop();

	    desktop.open(new File(targetFilePath));
	}
	
}
