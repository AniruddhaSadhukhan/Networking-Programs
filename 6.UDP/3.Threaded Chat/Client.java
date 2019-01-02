import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client threaded chat system 
using Socket programming using UDP
		by Aniruddha */

class Client_Send extends Thread
{
	DatagramSocket sock;
	
	public Client_Send(DatagramSocket s)
	{
		sock = s;
		this.start();
	}
	
	public void run()
	{
		try
		{
			DatagramPacket sPacket;
			
			Scanner scan = new Scanner(System.in);
			
			String snd;
			byte msg[];
			
			while(true)
			{
				snd = scan.nextLine();
				msg = snd.getBytes();
				sPacket = new DatagramPacket(msg,msg.length,InetAddress.getLocalHost(),8080);
				sock.send(sPacket);
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
	DatagramSocket sock;
	
	public Client_Recieve(DatagramSocket s)
	{
		sock = s;
		this.start();
	}
	
	public void run()
	{
		try
		{
			DatagramPacket rPacket;
		
			String rcv;
			
			while(true)
			{
				rPacket = new DatagramPacket(new byte[1024],1024);
				sock.receive(rPacket);
				rcv = new String(rPacket.getData()).trim();
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
		DatagramSocket sock = new DatagramSocket (8081);
		
		System.out.println("Start chatting &  Enter # for exit");
		
		new Client_Recieve(sock);
		new Client_Send(sock);
	}
}
/*

Start chatting &  Enter # for exit
hi
Server : hlw
Server : how r u
fine
thank u 
bye
GOODBYE
*/
