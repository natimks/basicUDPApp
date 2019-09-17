import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(1234);
			byte buffer[] = new byte[1000];
			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(request);
			String msg = new String(request.getData());
			msg = msg.substring(0,request.getLength());
			msg += " -> OK";
			DatagramPacket reply = new DatagramPacket(msg.getBytes(), msg.getBytes().length, request.getAddress(),
					request.getPort());
			datagramSocket.send(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
