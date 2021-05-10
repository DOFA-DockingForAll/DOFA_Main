import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class ExecuteFile {
	public static void main(String [] args) {
		String rootAddress ="D:\\RohYounwoo\\javaCode\\Basic\\src\\"; 
		
		String[] programList = new String[2];
		programList[0] = "Firefox Setup 14.0.1.msi";
		programList[1] = "AtomSetup-x64.msi";
		PS1Handler ph = new PS1Handler(rootAddress, programList);
		
		if(ph.makePS1()) { // ps1颇老 积己 己傍
			ExeMsi exePS1 = new ExeMsi(rootAddress, "programInstall.ps1");
			exePS1.run();
		}
		else // ps1颇老 积己 角菩 
			System.out.println("ps1颇老 积己 角菩 ");
	}
}
