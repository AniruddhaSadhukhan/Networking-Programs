import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client system 
using Socket programming using TCP 
		by Aniruddha */

class Client
{
	public static void main(String args[]) throws IOException
	{		
		System.out.println("Connecting to server...");
		Socket sock = new Socket("localhost",8080);
		System.out.println("Just connected to "+sock.getRemoteSocketAddress());
		
		InputStream  in  = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		byte buffer[] = null;
		String msg,recv;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[*] Enter # for exit");
		while(true)
		{
			System.out.print("Client: ");
			msg = scan.nextLine();
			out.write(msg.getBytes());
			if (msg.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			
			buffer = new byte[1024];
			in.read(buffer);
			recv=new String(buffer).trim();
			if (recv.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			System.out.println("Server : "+recv);
		}
		sock.close();	
	}
}

/*Sample Output

*/
