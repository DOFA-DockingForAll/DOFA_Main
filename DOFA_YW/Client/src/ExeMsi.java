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
			open(root+fileName);
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
