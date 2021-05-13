public class ExecuteFile {
	public static void main(String [] args) {
		
		String rootAddress =System.getProperty("user.dir")+"\\files\\"; 
		String[] programList = new String[1];
		programList[0] = "Firefox Setup 14.0.1.msi";
		//programList[1] = "Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi";
		//programList[2] = "AtomSetup-x64.msi";
		
		String dirPath ="./files/";
		String serverIP = "192.168.0.59"; //String serverIP = args[0];
    	int port = 8080; //int port = Integer.parseInt(args[1]);
        
		FileClient fc = new FileClient(serverIP, port);

		for(int i = 0; i< programList.length; i++)
			fc.getFile(dirPath + programList[i]);
		
		
		PS1Handler ph = new PS1Handler(rootAddress, programList);
		
		if(ph.makePS1()) { // ps1颇老 积己 己傍
			ExeMsi exePS1 = new ExeMsi(rootAddress, "programInstall.ps1");
			exePS1.run();
		}
		else // ps1颇老 积己 角菩 
			System.out.println("ps1颇老 积己 角菩 ");
	}
}
