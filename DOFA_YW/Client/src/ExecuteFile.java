public class ExecuteFile {
	private String rootAddress;
	private String[] programList;
	
	ExecuteFile(){
		rootAddress = System.getProperty("user.dir")+"\\files\\";
		programList = new String[0];
	}
	
	public void setRoot(String rootAddress) {
		rootAddress = System.getProperty("user.dir")+"\\files\\";
	}
	
	public void setFiles(String[] programList) {
		this.programList = new String[programList.length];
		for(int i = 0; i < programList.length; i++)
			this.programList[i] = programList[i];
	}
	
	public void startInstall() {
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
