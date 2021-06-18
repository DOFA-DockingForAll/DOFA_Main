import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
 
public class FileServer{
    public static final int DEFAULT_BUFFER_SIZE = 10000;
    private static int port;
    
    FileServer(){
    	port = 8080;
    }
    
    FileServer(int port){
    	this.port = port;
    }
    void setPort(int port){
    	this.port = port;
    }
    
    public void startServer() {    
        try {
        	ServerSocket server = new ServerSocket(port);
            while(true) {
            	
                System.out.println("This server is listening... (Port: " + port  + ")");
	            Socket socket = server.accept();  //货肺款 楷搬 家南 积己 棺 accept措扁
	            InetSocketAddress isaClient = (InetSocketAddress) socket.getRemoteSocketAddress();
	             
	            System.out.println("A client("+isaClient.getAddress().getHostAddress()+
	                    " is connected. (Port: " +isaClient.getPort() + ")");
	            
	            FileServerThread fst = new FileServerThread(socket);
	            fst.run();
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

