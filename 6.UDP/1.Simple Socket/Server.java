import java.io.*;
import java.net.*;

/*Program to implement basic Server Client system 
using Socket programming using UDP 
		by Aniruddha */
class Server
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket sock = new DatagramSocket (8080);
		
		//Recieve
		DatagramPacket rPacket = new DatagramPacket(new byte[1024],1024);
		sock.receive(rPacket);
		System.out.println("Client["+rPacket.getAddress()+" : "+rPacket.getPort()+"] : "+new String(rPacket.getData()).trim());
		
		//Send
		String snd = "Hi this is Server";
		byte msg[] = snd.getBytes();
		DatagramPacket sPacket = new DatagramPacket(msg,msg.length,rPacket.getAddress(),rPacket.getPort());
		sock.send(sPacket);
		
		sock.close();
	}
}

/*Sample Output

Client[/127.0.0.1 : 37076] : Hi this is Client

*/
