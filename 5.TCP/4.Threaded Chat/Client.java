import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client threaded chat system 
using Socket programming using TCP 
		by Aniruddha */

class Client_Send extends Thread
{
	Socket sock;
	
	public Client_Send(Socket s)
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

class Client_Recieve extends Thread
{
	Socket sock;
	
	public Client_Recieve(Socket s)
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
				System.out.println("Server : "+rcv);
			}
		}
		catch(IOException e){}
		
	}
}


class Client
{
	public static void main(String args[]) throws IOException
	{	
		Socket sock = new Socket("localhost",8080);
		System.out.println("Connected to "+sock.getRemoteSocketAddress());
		
		System.out.println("Start chatting &  Enter # for exit");
		
		new Client_Recieve(sock);
		new Client_Send(sock);
	}
}

/*
Connected to localhost/127.0.0.1:8080
Start chatting &  Enter # for exit
Server : hi i am server
and i am client
Server : ou...good to know u
same 2 u
see you next time
Server : yeah
Server : take care
Server : bye
GOODBYE


*/
