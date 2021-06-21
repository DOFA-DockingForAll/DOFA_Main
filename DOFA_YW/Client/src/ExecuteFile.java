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
		
		if(ph.makePS1()) { // ps1파일 생성 성공
			ExeMsi exePS1 = new ExeMsi(rootAddress, "programInstall.ps1");
			exePS1.run();
			
			//자신의 ID로 설치 프로그램리스트 작성 서버 업로드용. ID가 특별이 없을경우 defaultUsr
			File file = new File("./files/usrList/"+usrID+"_sysList.txt");
			
			ArrayList<String> fileContext = new ArrayList<String>();
			
			try {
				//입력 스트림 생성
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
	                //쓰기
	                for(int i = 0; i < fileContextArray.length; i++) { // 설치 프로그램 리스트 파일로 작성   	
	                	bufferedWriter.write(fileContextArray[i]);
	                	bufferedWriter.newLine();
	                }

	                bufferedWriter.close();
	                fc.sendFile("./files/usrList/"+usrID+"_sysList.txt"); // 서버로 파일 전송
	            }
			}catch (FileNotFoundException e) { // 파일 찾기 불가시, 이전에 DOFA를 사용하지 않았다는 것. 따라서 처음 파일 생성
	            System.out.println("your syncFile not found\ncreating new......");
	            try {
	            	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            	fileContext.add(usrID);
	            	for(int i = 0; i < programList.length; i++)
						fileContext.add(programList[i]);
	            	String[] fileContextArray = fileContext.toArray(new String[fileContext.size()]);

		            if(file.isFile() && file.canWrite()){
		                //쓰기
		                for(int i = 0; i < fileContextArray.length; i++) { // 원래 존재하던 프로그램 리스트 추가   	
		                	bufferedWriter.write(fileContextArray[i]);
		                	bufferedWriter.newLine();
		                }

		                bufferedWriter.close();
		                fc.sendFile("./files/usrList/"+usrID+"_sysList.txt"); // 서버로 파일 전송
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
		else // ps1파일 생성 실패 
			System.out.println("ps1파일 생성 실패 ");
	}
	

}
