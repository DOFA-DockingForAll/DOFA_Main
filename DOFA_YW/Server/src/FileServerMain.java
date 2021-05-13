
public class FileServerMain {
	public static void main(String[] args) {     
		int port = 8080;
		FileServer fs = new FileServer(port);
		
		fs.startServer();
		
		
	}
}
