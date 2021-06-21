import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramUpdate {
	
	public boolean changeTargetUSR(String sharerID) {
		File file = new File("./files/usrList/syncFile.txt");
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			if(file.isFile() && file.canWrite()){
	            //쓰기
				bufferedWriter.write(sharerID); // 공유하는 사용자 ID기록
				bufferedWriter.close();
	            return true;
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	private static String[] fileToArray(String fileName) {
		ArrayList<String> fileContext = new ArrayList<String>();
		try{
            //파일 객체 생성
            File file = new File("./files/usrList/"+fileName);
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                fileContext.add(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
        }catch (FileNotFoundException e) { // 파일 찾기 불가시, 이전에 DOFA를 사용하지 않았다는 것. 따라서 업데이트 안함
            System.out.println("syncFile not found");
        }catch(IOException e){
            System.out.println(e);
        }
		return fileContext.toArray(new String[fileContext.size()]);
	}
	
	
	public static String[] getUpdateFileNames() {
		ArrayList<String> updateTargetFiles = new ArrayList<String>();
		String[] SyncFilearr = fileToArray("syncFile.txt");
		System.out.println("installed files" + (SyncFilearr.length - 1));
		if(SyncFilearr.length == 0) // syncFile안에 데이터가 없을 경우. 동기화할 설치파일 목록 상실
			System.out.println("SyncFile data loss");
		else {
			FileClient FC = new FileClient();
			String dirPath ="./files/usrList/";
			FC.getFile(dirPath+SyncFilearr[0]+"_sysList.txt", dirPath+"newestList.txt");
			String[] NewestFilearr = fileToArray("newestList.txt");
			for(int i = 0; i < NewestFilearr.length; i++)
				if(Arrays.asList(SyncFilearr).contains(NewestFilearr[i]))
					continue;
				else {
					updateTargetFiles.add(NewestFilearr[i]);
				}
		}
		
		return updateTargetFiles.toArray(new String[updateTargetFiles.size()]);

	}
	
	public void startUpdate() {
		String[] updateTargetFiles = getUpdateFileNames();
		if(updateTargetFiles.length != 0) {
			ExecuteFile ef = new ExecuteFile();
			System.out.println("update found");
			for(int i = 0; i < updateTargetFiles.length; i++)
				System.out.println(updateTargetFiles[i]);
			System.out.println("start update? (y,n)");
			Scanner sc = new Scanner(System.in);
			String response = sc.next();
			sc.close();
			if(response.equals("n") || response.equals("N")) {
				System.out.println("terminating update....");
				return;
			}
			ef.setFiles(updateTargetFiles);
			ef.startInstall();
			//업데이트를 완료하면 클라이언트쪽에서 syncfile새로 작성 필요
			String[] SyncFilearr = fileToArray("syncFile.txt");
			String sharerID = SyncFilearr[0];
			File file = new File("./files/usrList/syncFile.txt");
			try {
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            
	            if(file.isFile() && file.canWrite()){
	                //쓰기
	                bufferedWriter.write(sharerID); // 공유하는 사용자 ID기록
	                
	                for(int i = 1; i < SyncFilearr.length; i++) { // 원래 존재하던 프로그램 리스트 추가
	                	//개행문자쓰기
	                	bufferedWriter.newLine();
	                	bufferedWriter.write(SyncFilearr[i]);
	                }
	                for(int i = 0; i < updateTargetFiles.length; i++) { // 새로 추가된 프로그램 리스트 추가 
	                	bufferedWriter.newLine();
	                	bufferedWriter.write(updateTargetFiles[i]);
	                }
	                
	                bufferedWriter.close();
	            }
			}catch (FileNotFoundException e) { // 파일 찾기 불가시, 이전에 DOFA를 사용하지 않았다는 것. 따라서 업데이트 안함
	            System.out.println("syncFile not found");
	        }catch(IOException e){
	            System.out.println(e);
	        }

			
		}
		else {
			System.out.println("Nothing to update!!!");
		}
		
	}
	
}
