import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client chat system 
using Socket programming using TCP 
		by Aniruddha */

class Client
{
	public static void main(String args[]) throws IOException
	{	
		Socket sock = new Socket("localhost",8080);
		System.out.println("Connected to "+sock.getRemoteSocketAddress());
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		Scanner scan = new Scanner(System.in);
		
		String snd,rcv;
		byte buffer[];
		
		System.out.println("Start chatting &  Enter # for exit");
		while(true)
		{
			System.out.print("Client : ");
			snd = scan.nextLine();
			out.write(snd.getBytes());
			if(snd.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			
			buffer = new byte[1024];
			in.read(buffer);
			rcv = new String(buffer).trim();
			if(rcv.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			System.out.println("Server : "+rcv);
			
			
		}
		
		sock.close();
	}
}

/*

Connected to localhost/127.0.0.1:8080
Start chatting &  Enter # for exit
Client : Hi
Server : Hlo
Client : bye?
Server : ok bye
Client : #
GOODBYE

*/
