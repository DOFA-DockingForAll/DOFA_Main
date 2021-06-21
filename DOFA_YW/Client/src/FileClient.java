import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class FileClient extends Thread{
    private static final int DEFAULT_BUFFER_SIZE = 10000;  
    private static String serverIP;
    private static int port;
    
    FileClient(){
    	serverIP = "127.0.0.1"; //String serverIP = args[0];
    	port = 8080; //int port = Integer.parseInt(args[1]);
    }
    
    FileClient(String serverIP, int port){
    	this.serverIP = serverIP;
    	this.port = port;
    }
    
    void setServerIP(String serverIP){
    	this.serverIP = serverIP;
    }
    
    void setPort(int port){
    	this.port = port;
    }
    
    String getServerIP() {
    	return serverIP;
    }
    
    int getPort() {
    	return port;
    }
    
    boolean sendFile(String FileName) { // 서버로 파일 업로드
    	File file = new File(FileName);
    	if (!file.exists()) {
            System.out.println("File not Exist.");
            System.exit(0);
        }
         
        long fileSize = file.length();
        long totalReadBytes = 0;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int readBytes;
        double startTime = 0;
         
        try {
            FileInputStream fis = new FileInputStream(file);
            Socket socket = new Socket(serverIP, port);
            if(!socket.isConnected()){
                System.out.println("Socket Connect Error.");
                System.exit(0);
            }
            System.out.println(file);
            startTime = System.currentTimeMillis();
            OutputStream os = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(os, true);
            writer.println("POSTFILE");
            writer.println(FileName);
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            while ((readBytes = fis.read(buffer)) > 0) {
                os.write(buffer, 0, readBytes);
                totalReadBytes += readBytes;
                System.out.println("In progress: " + totalReadBytes + "/"
                        + fileSize + " Byte(s) ("
                        + (totalReadBytes * 100 / fileSize) + " %)");
            }
             
            System.out.println("File transfer completed.");
            fis.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        double endTime = System.currentTimeMillis();
        double diffTime = (endTime - startTime)/ 1000;;
        double transferSpeed = (fileSize / 1000)/ diffTime;
         
        System.out.println("time: " + diffTime+ " second(s)");
        System.out.println("Average transfer speed: " + transferSpeed + " KB/s");

    	return true;
    }
    
    boolean getFile(String FileName){
    	double startTime = System.currentTimeMillis(); 
    	  
        try {
            
            Socket socket = new Socket(serverIP, port);
            if(!socket.isConnected()){
                System.out.println("Socket Connect Error.");
                return false;
            }
            
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(FileName);
            
            FileOutputStream fos = new FileOutputStream(FileName);
            InputStream is = socket.getInputStream();
            
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int readBytes;
            
            while ((readBytes = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readBytes);
 
            }
            
            is.close();
            fos.close();
            System.out.println("File transfer completed.");
            
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        double endTime = System.currentTimeMillis();
        double diffTime = (endTime - startTime)/ 1000;;
        //double transferSpeed = (fileSize / 1000)/ diffTime;
         
        System.out.println("time: " + diffTime+ " second(s)");
        //System.out.println("Average transfer speed: " + transferSpeed + " KB/s");
    	
    	return true;
    }
    
    
    boolean getFile(String FileName, String TargetName){
    	double startTime = System.currentTimeMillis(); 
    	  
        try {
            
            Socket socket = new Socket(serverIP, port);
            if(!socket.isConnected()){
                System.out.println("Socket Connect Error.");
                return false;
            }
            
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(FileName);
            
            FileOutputStream fos = new FileOutputStream(TargetName);
            InputStream is = socket.getInputStream();
            
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int readBytes;
            
            while ((readBytes = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readBytes);
 
            }
            
            is.close();
            fos.close();
            System.out.println("File transfer completed.");
            
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        double endTime = System.currentTimeMillis();
        double diffTime = (endTime - startTime)/ 1000;;
        //double transferSpeed = (fileSize / 1000)/ diffTime;
         
        System.out.println("time: " + diffTime+ " second(s)");
        //System.out.println("Average transfer speed: " + transferSpeed + " KB/s");
    	
    	return true;
    }
}
