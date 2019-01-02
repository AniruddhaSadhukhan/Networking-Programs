import java.io.*;
import java.net.*;

/*Program to implement basic Server Client system 
using Socket programming using UDP 
		by Aniruddha */
class Client
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket sock = new DatagramSocket ();
		
		//Send
		String snd = "Hi this is Client";
		byte msg[] = snd.getBytes();
		DatagramPacket sPacket = new DatagramPacket(msg,msg.length,InetAddress.getLocalHost(),8080);
		sock.send(sPacket);
		
		//Recieve
		DatagramPacket rPacket = new DatagramPacket(new byte[1024],1024);
		sock.receive(rPacket);
		System.out.println("Server["+rPacket.getAddress()+" : "+rPacket.getPort()+"] : "+new String(rPacket.getData()).trim());
		
		
		sock.close();
	}
}

/*Sample Output
Server[/127.0.0.1 : 8080] : Hi this is Server


*/
