import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client chat system 
using Socket programming using TCP 
		by Aniruddha */

class Server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket serSocket = new ServerSocket(8080);
		System.out.println("Waiting on port "+serSocket.getLocalPort()+"...");
		
		Socket sock = serSocket.accept();
		System.out.println("Just connected to "+sock.getRemoteSocketAddress());
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		Scanner scan = new Scanner(System.in);
		
		String snd,rcv;
		byte buffer[];
		
		System.out.println("Start chatting &  Enter # for exit");
		while(true)
		{
			buffer = new byte[1024];
			in.read(buffer);
			rcv = new String(buffer).trim();
			if(rcv.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			System.out.println("Client : "+rcv);
			
			System.out.print("Server : ");
			snd = scan.nextLine();
			out.write(snd.getBytes());
			if(snd.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
		}
		
		sock.close();
		serSocket.close();
	}
}
/*
Waiting on port 8080...
Just connected to /127.0.0.1:42936
Start chatting &  Enter # for exit
Client : Hi
Server : Hlo
Client : bye?
Server : ok bye 
GOODBYE

*/
