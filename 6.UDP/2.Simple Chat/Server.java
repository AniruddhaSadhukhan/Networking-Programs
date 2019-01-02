import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Program to implement basic Server Client chat system 
using Socket programming using UDP 
		by Aniruddha */

class Server
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket sock = new DatagramSocket (8080);
		DatagramPacket sPacket,rPacket;
		Scanner scan = new Scanner(System.in);
		
		String snd,rcv;
		byte msg[];
		
		System.out.println("Start chatting &  Enter # for exit");
		while(true)
		{
			rPacket = new DatagramPacket(new byte[1024],1024);
			sock.receive(rPacket);
			rcv = new String(rPacket.getData()).trim();
			if(rcv.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			System.out.println("Client : "+rcv);
			
			System.out.print("Server : ");
			snd = scan.nextLine();
			msg = snd.getBytes();
			sPacket = new DatagramPacket(msg,msg.length,rPacket.getAddress(),rPacket.getPort());
			sock.send(sPacket);
			if(snd.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
		}
		
		sock.close();
	}
}
/*
Start chatting &  Enter # for exit
Client : Hi
Server : Hlw
Client : Bye
Server : ok bye
GOODBYE


*/
