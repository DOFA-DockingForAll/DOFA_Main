import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread extends Thread{
	public static final int DEFAULT_BUFFER_SIZE = 10000;
	private Socket socket;
	
	FileServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
	        InputStream input = socket.getInputStream();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	        String FileName =reader.readLine();//String FileName = args[2];  
	        System.out.println("FileName: "+FileName);
	        File file = new File(FileName);
	        if (!file.exists()) {
	            System.out.println("File not Exist.");
	            socket.close();
	        }
	        long fileSize = file.length();
	        
	        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	        int readBytes;
	        long totalReadBytes = 0;
	        double startTime = 0;
	        FileInputStream fis = new FileInputStream(file);
	        OutputStream os = socket.getOutputStream();
	        
	        startTime = System.currentTimeMillis();
	        
	        while ((readBytes = fis.read(buffer)) > 0) {
	            os.write(buffer, 0, readBytes);
	            totalReadBytes += readBytes;
	            System.out.println("In progress: " + totalReadBytes + "/"
	                    + fileSize + " Byte(s) ("
	                    + (totalReadBytes * 100 / fileSize) + " %)");
	        }
	        
	        fis.close();
	        os.close();
	   
	        double endTime = System.currentTimeMillis();
	        double diffTime = (endTime - startTime)/ 1000;;
	        
	        System.out.println("time: " + diffTime+ " second(s)");
		}catch(IOException e) {
            e.printStackTrace();
		}
	}
}
