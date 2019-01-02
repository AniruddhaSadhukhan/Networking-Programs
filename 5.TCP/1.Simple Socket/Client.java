import java.io.*;
import java.net.*;

/*Program to implement basic Server Client system 
using Socket programming using TCP 
		by Aniruddha */
		
class Client
{
	public static void main(String args[]) throws IOException
	{
		Socket sock = new Socket("localhost",8080);
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		byte buffer[] = new byte[1024];
		
		out.write("Hello from Client".getBytes());
		
		in.read(buffer);
		System.out.println("Server: "+new String(buffer).trim());
		
		sock.close();
		
	}
}

/*Sample Output

Server: Hello from Server

*/
