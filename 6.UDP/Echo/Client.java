import java.io.*;
import java.net.*;
import java.util.Scanner;

/*Echo Server Client Socket programming using UDP
		by Aniruddha */
		
class Client
{
	
	public static void main(String args[]) throws IOException
	{	
		DatagramSocket sock = new DatagramSocket();
				
		DatagramPacket sPacket,rPacket;
		
		
		String snd,recv;
		byte msg[];
		Scanner scan = new Scanner(System.in);

		System.out.println("Start chatting &  Enter # for exit");
		
		while(true)
		{
			System.out.print("Client: ");
			snd = scan.nextLine();
			msg = snd.getBytes();
			sPacket = new DatagramPacket(msg,msg.length,InetAddress.getLocalHost(),8080);
			sock.send(sPacket);
			if (snd.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			}
			
			rPacket = new DatagramPacket(new byte[1024],1024);
			sock.receive(rPacket);
			recv = new String(rPacket.getData()).trim();
			System.out.println("Server["+rPacket.getAddress()+":"+rPacket.getPort()+"] : "+recv);
			
		}
		sock.close();
		
	}
}

/*Sample Output
Start chatting &  Enter # for exit
Client: hi
Server[/127.0.0.1:8080] : hi
Client: bye
Server[/127.0.0.1:8080] : bye
Client: #
GOODBYE
*/
