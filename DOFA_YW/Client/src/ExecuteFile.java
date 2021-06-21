import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExecuteFile {
	private String rootAddress;
	private String[] programList;
	private String usrID;
	
	ExecuteFile(){
		rootAddress = System.getProperty("user.dir")+"\\files\\";
		programList = new String[0];
		usrID = "defaultUsr";
	}
	ExecuteFile(String usrID){
		rootAddress = System.getProperty("user.dir")+"\\files\\";
		programList = new String[0];
		this.usrID = usrID;
	}
	
	public void setRoot(String rootAddress) {
		rootAddress = System.getProperty("user.dir")+"\\files\\";
	}
	
	public void setFiles(String[] programList) {
		this.programList = new String[programList.length];
		for(int i = 0; i < programList.length; i++)
			this.programList[i] = programList[i];
	}
	
	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}
	
	public void startInstall() {
		String dirPath ="./files/";
		String serverIP = "192.168.0.59"; //String serverIP = args[0];
    	int port = 8080; //int port = Integer.parseInt(args[1]);
        
		FileClient fc = new FileClient(serverIP, port);

		for(int i = 0; i< programList.length; i++)
			fc.getFile(dirPath + programList[i]);
		
		
		PS1Handler ph = new PS1Handler(rootAddress, programList);
		
		if(ph.makePS1()) { // ps1���� ���� ����
			ExeMsi exePS1 = new ExeMsi(rootAddress, "programInstall.ps1");
			exePS1.run();
			
			//�ڽ��� ID�� ��ġ ���α׷�����Ʈ �ۼ� ���� ���ε��. ID�� Ư���� ������� defaultUsr
			File file = new File("./files/usrList/"+usrID+"_sysList.txt");
			
			ArrayList<String> fileContext = new ArrayList<String>();
			
			try {
				//�Է� ��Ʈ�� ����
				FileReader filereader = new FileReader(file);
				BufferedReader bufReader = new BufferedReader(filereader);
				String line = "";
				while((line = bufReader.readLine()) != null){
	                fileContext.add(line);
	            }
				bufReader.close();
				
				for(int i = 0; i < programList.length; i++) {
					if(!fileContext.contains(programList[i]))
						fileContext.add(programList[i]);
				}
				String[] fileContextArray = fileContext.toArray(new String[fileContext.size()]);

	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

	            if(file.isFile() && file.canWrite()){
	                //����
	                for(int i = 0; i < fileContextArray.length; i++) { // ��ġ ���α׷� ����Ʈ ���Ϸ� �ۼ�   	
	                	bufferedWriter.write(fileContextArray[i]);
	                	bufferedWriter.newLine();
	                }

	                bufferedWriter.close();
	                fc.sendFile("./files/usrList/"+usrID+"_sysList.txt"); // ������ ���� ����
	            }
			}catch (FileNotFoundException e) { // ���� ã�� �Ұ���, ������ DOFA�� ������� �ʾҴٴ� ��. ���� ó�� ���� ����
	            System.out.println("your syncFile not found\ncreating new......");
	            try {
	            	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            	fileContext.add(usrID);
	            	for(int i = 0; i < programList.length; i++)
						fileContext.add(programList[i]);
	            	String[] fileContextArray = fileContext.toArray(new String[fileContext.size()]);

		            if(file.isFile() && file.canWrite()){
		                //����
		                for(int i = 0; i < fileContextArray.length; i++) { // ���� �����ϴ� ���α׷� ����Ʈ �߰�   	
		                	bufferedWriter.write(fileContextArray[i]);
		                	bufferedWriter.newLine();
		                }

		                bufferedWriter.close();
		                fc.sendFile("./files/usrList/"+usrID+"_sysList.txt"); // ������ ���� ����
		            }
	            	
	            }catch(FileNotFoundException e1) {
	            	
	            } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }catch(IOException e){
	            System.out.println(e);
	        }
			
		}
		else // ps1���� ���� ���� 
			System.out.println("ps1���� ���� ���� ");
	}
	

}
