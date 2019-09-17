import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			int port = 1234;
			InetAddress addr = InetAddress.getByName("localhost");
			String msg = "Olá! Eu sou o cliente!";
			DatagramPacket request = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);
			// envia request
			datagramSocket.send(request);
			
			// Recebendo uma resposta
			byte buffer[] = new byte[1000];
			DatagramPacket resposta = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(resposta);
			
			System.out.println("Cliente recebeu: "+new String(resposta.getData()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
