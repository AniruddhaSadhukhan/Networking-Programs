import java.io.*;
import java.net.*;

/*Program to implement basic Server Client system 
using Socket programming using TCP 
		by Aniruddha */
class Server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket serSocket = new ServerSocket(8080);
		
		System.out.println("Waiting for Client...");
		
		Socket sock = serSocket.accept();
		System.out.println("Client accepted");
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		byte buffer[] = new byte[1024];
		
		in.read(buffer);
		System.out.println("Client: "+new String(buffer).trim());
		
		out.write("Hello from Server".getBytes());
		
		sock.close();
		serSocket.close();
	}
}

/*Sample Output

Waiting for Client...
Client accepted
Client: Hello from Client

*/
