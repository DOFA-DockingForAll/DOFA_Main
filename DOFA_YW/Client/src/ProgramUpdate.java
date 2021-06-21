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
	            //����
				bufferedWriter.write(sharerID); // �����ϴ� ����� ID���
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
            //���� ��ü ����
            File file = new File("./files/usrList/"+fileName);
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                fileContext.add(line);
            }
            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
            bufReader.close();
        }catch (FileNotFoundException e) { // ���� ã�� �Ұ���, ������ DOFA�� ������� �ʾҴٴ� ��. ���� ������Ʈ ����
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
		if(SyncFilearr.length == 0) // syncFile�ȿ� �����Ͱ� ���� ���. ����ȭ�� ��ġ���� ��� ���
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
			//������Ʈ�� �Ϸ��ϸ� Ŭ���̾�Ʈ�ʿ��� syncfile���� �ۼ� �ʿ�
			String[] SyncFilearr = fileToArray("syncFile.txt");
			String sharerID = SyncFilearr[0];
			File file = new File("./files/usrList/syncFile.txt");
			try {
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            
	            if(file.isFile() && file.canWrite()){
	                //����
	                bufferedWriter.write(sharerID); // �����ϴ� ����� ID���
	                
	                for(int i = 1; i < SyncFilearr.length; i++) { // ���� �����ϴ� ���α׷� ����Ʈ �߰�
	                	//���๮�ھ���
	                	bufferedWriter.newLine();
	                	bufferedWriter.write(SyncFilearr[i]);
	                }
	                for(int i = 0; i < updateTargetFiles.length; i++) { // ���� �߰��� ���α׷� ����Ʈ �߰� 
	                	bufferedWriter.newLine();
	                	bufferedWriter.write(updateTargetFiles[i]);
	                }
	                
	                bufferedWriter.close();
	            }
			}catch (FileNotFoundException e) { // ���� ã�� �Ұ���, ������ DOFA�� ������� �ʾҴٴ� ��. ���� ������Ʈ ����
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
