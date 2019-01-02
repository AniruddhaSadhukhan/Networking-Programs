import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client system 
using Socket programming using TCP 
		by Aniruddha */

class Server extends Thread
{
	
	public static void main(String args[]) throws IOException
	{	
		ServerSocket serSocket = new ServerSocket(8080);
		System.out.println("Waiting for client on port "+serSocket.getLocalPort()+"...");
		
		Socket sock = serSocket.accept();
		System.out.println("Just connected to "+sock.getRemoteSocketAddress());
				
		InputStream  in  = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		byte buffer[] = null;
		String msg,recv;
		Scanner scan = new Scanner(System.in);

		while(true)
		{
			buffer = new byte[1024];
			in.read(buffer);
			recv=new String(buffer).trim();
			if (recv.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			System.out.println("Client : "+recv);
			
			out.write(buffer);
			
			
		}
		sock.close();
		serSocket.close();
		
	}
}

/*Sample Output

*/
