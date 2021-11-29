
import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;


public class Sockets {

    public boolean Emisor(String mensaje) {
        try {
            InetAddress receptor = InetAddress.getByName("26.3.74.147");
            DatagramSocket socketEmisor = new DatagramSocket();
            byte[] bufferEmisor = mensaje.getBytes();
            DatagramPacket datagramaEmisor = new DatagramPacket(bufferEmisor, bufferEmisor.length, receptor, 45982);
            socketEmisor.send(datagramaEmisor);
            return true;
        } catch (SocketException e) {
            System.out.println("Excepcion Socket:" + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println("Excepcion IO:" + e.getMessage());
            return false;
        }
    }

    public String Receptor() {
        try {
            DatagramSocket socketReceptor = new DatagramSocket(45982);
            int tamanioBuffer = 1000;
            byte[] bufferReceptor = new byte[tamanioBuffer];
            DatagramPacket datagramaReceptor = new DatagramPacket(bufferReceptor, bufferReceptor.length);
            socketReceptor.receive(datagramaReceptor);
            int tamanioMensajeRecibido = datagramaReceptor.getLength();
            String mensajeRecibido = new String(datagramaReceptor.getData(), 0, tamanioMensajeRecibido);
            System.out.println("Mensaje: " + mensajeRecibido);
            System.out.println("En la dirección: " + datagramaReceptor.getAddress());
            System.out.println("En el puerto: " + datagramaReceptor.getPort());
            socketReceptor.close();
            return mensajeRecibido;
        } catch (SocketException e) {
            System.out.println("Excepcion Socket:" + e.getMessage());
            return "";
        } catch (IOException e) {
            System.out.println("Excepcion IO:" + e.getMessage());
            return "";
        }
    }
}
