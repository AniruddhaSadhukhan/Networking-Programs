import java.io.*;
import java.net.*;

/*Program to implement threaded Server Client system 
using Socket programming using TCP 
		by Aniruddha */
		
class Server extends Thread
{
	Socket sock;
	
	public Server(Socket s)
	{
		sock = s;
	}
	
	public void run()
	{
		try
		{
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
		
			byte buffer[] = new byte[1024];
			in.read(buffer);
			System.out.println("Client["+sock.getRemoteSocketAddress()+"] : "+new String(buffer).trim());
		
			out.write("Goodbye".getBytes());
		
			sock.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		ServerSocket serSocket = new ServerSocket(8080);
		serSocket.setSoTimeout(30000);
		
		try
		{
			while(true)
			{
				System.out.println("Waiting for client on port "+serSocket.getLocalPort()+" ...");
				Socket sock = serSocket.accept();
				System.out.println("Just connected to "+sock.getRemoteSocketAddress());
				new Server(sock).start();
			}
		}
		catch(SocketTimeoutException a)
		{
			System.out.println("Server timed out...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.exit(0);
		
	}
}
/*Sample Output

Waiting for client on port 8080 ...
Just connected to /127.0.0.1:42928
Waiting for client on port 8080 ...
Client[/127.0.0.1:42928] : Hi
Just connected to /127.0.0.1:42930
Waiting for client on port 8080 ...
Client[/127.0.0.1:42930] : hello
*/
