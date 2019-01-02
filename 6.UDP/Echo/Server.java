import java.io.*;
import java.net.*;

/*Echo Server Client Socket programming using UDP
		by Aniruddha */

class Server 
{
	
	public static void main(String args[]) throws IOException
	{	
		DatagramSocket sock = new DatagramSocket(8080);
				
		DatagramPacket sPacket,rPacket;
		
		
		String snd,recv;
		byte msg[];
		
		while(true)
		{
			rPacket = new DatagramPacket(new byte[1024],1024);
			sock.receive(rPacket);
			recv = new String(rPacket.getData()).trim();
			if (recv.equals("#"))
			{
				System.out.println("GOODBYE");
				break;
			} 
			System.out.println("Client["+rPacket.getAddress()+":"+rPacket.getPort()+"] : "+recv);
			
			msg = rPacket.getData();
			sPacket = new DatagramPacket(msg,msg.length,rPacket.getAddress(),rPacket.getPort());
			sock.send(sPacket);
			
		}
		sock.close();
		
	}
}

/*Sample Output
Client[/127.0.0.1:58259] : hi
Client[/127.0.0.1:58259] : bye
GOODBYE
*/
