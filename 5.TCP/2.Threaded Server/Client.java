import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement threaded Server Client system 
using Socket programming using TCP 
		by Aniruddha */

class Client
{
	public static void main(String args[]) throws IOException
	{
		Socket sock = new Socket("localhost",8080);
		
		System.out.println("Just connected to "+sock.getRemoteSocketAddress()+" ...");
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		String msg;
		Scanner scan = new Scanner(System.in);
		msg = scan.nextLine();
		
		out.write(msg.getBytes());
		
		byte buffer[] = new byte[1024];
		in.read(buffer);
		System.out.println("Server : "+new String(buffer).trim());
		
		sock.close();
		 
	}
	
	
	
}

/*Sample Output

Just connected to localhost/127.0.0.1:8080 ...
Hi
Server : Goodbye


Just connected to localhost/127.0.0.1:8080 ...
hello
Server : Goodbye
*/
