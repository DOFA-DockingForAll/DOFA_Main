import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class FileClient {
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
}
