import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client threaded chat system 
using Socket programming using TCP 
		by Aniruddha */

class Server_Send extends Thread
{
	Socket sock;
	
	public Server_Send(Socket s)
	{
		sock = s;
		this.start();
	}
	
	public void run()
	{
		try
		{
			OutputStream out = sock.getOutputStream();
		
			Scanner scan = new Scanner(System.in);
		
			String snd;

			while(true)
			{
				snd = scan.nextLine();
				out.write(snd.getBytes());
				if(snd.equals("#"))
				{
					System.out.println("GOODBYE");
					sock.close();
					System.exit(0);
				}
			}
		}
		catch(IOException e){}
		
	}
}

class Server_Recieve extends Thread
{
	Socket sock;
	
	public Server_Recieve(Socket s)
	{
		sock = s;
		this.start();
	}
	
	public void run()
	{
		try
		{
			InputStream in = sock.getInputStream();
		
			String rcv;
			byte buffer[];
			
			while(true)
			{
				buffer = new byte[1024];
				in.read(buffer);
				rcv = new String(buffer).trim();
				if(rcv.equals("#"))
				{
					System.out.println("GOODBYE");
					sock.close();
					System.exit(0);
				}
				System.out.println("Client : "+rcv);
			}
		}
		catch(IOException e){}
		
	}
}


class Server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket serSocket = new ServerSocket(8080);
		System.out.println("Waiting on port "+serSocket.getLocalPort()+"...");
		
		Socket sock = serSocket.accept();
		System.out.println("Just connected to "+sock.getRemoteSocketAddress());
		
		new Server_Recieve(sock);
		new Server_Send(sock);
	}
}
/*

Waiting on port 8080...
Just connected to /127.0.0.1:42938
hi i am server
Client : and i am client
ou...good to know u
Client : same 2 u
Client : see you next time
yeah
take care
bye
#
GOODBYE

*/
