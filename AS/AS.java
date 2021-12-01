/*
 * Authentication Server Class
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author Gerardo Zamora
 */
public class AS {
    public static void main(String[] args) throws SocketException, IOException {
        Scanner data = new Scanner(System.in);
        //User user = new User();
        Keys keys = new Keys();
        TCipher cipher = new TCipher();
        System.out.println("Escribe el ID del Cliente:");
        String clientID = data.next();
        System.out.println("Escribe el ID del TGS:");
        String tgsID = data.next();
        //Socket instance to accept the connection
        ServerSocket serverSocket = new ServerSocket(6578);
        System.out.println("Preparando para aceptar una conexion...");
        //Wait until an user connection, then it accept the connection 
        Stream stream = new Stream(serverSocket.accept());
        System.out.println("Conexion aceptada");
        //It receives the message
        String message = stream.receiveMessage();
        //Get the username and password then it makes the TGT
        System.out.println("Generando TGT ...");
        String secretKeyASC;
        String TGT;
        if(message.equals(clientID + " /-/:/-/ " + tgsID)) {
            //Get for the client key
            secretKeyASC = keys.getSecretKeyASC();
            //Made of a key between the client and tge TGS
            String kCTGS =  keys.genSecretKey();
            //Made of the TicketTGS
            String ticketTGS = kCTGS + " /-/:/-/ " + clientID + " /-/:/-/ " + String.valueOf(stream.getInetAddress()) + " /-/:/-/ " + tgsID;
            //Cipher of the TicketTGS with the TGS secret key
            long secretKeyASTGS = Long.parseLong(keys.getSecretKeyASTGS());
            System.out.println(String.valueOf(secretKeyASTGS));
            cipher.setMensaje(ticketTGS);
            String cipherTicketTGS = cipher.Cifrar(secretKeyASTGS);
            //We made the TGT and then we cipher it
            TGT = kCTGS + " /-/:/-/ " + tgsID + " /-/:/-/ " + cipherTicketTGS;
            cipher.setMensaje(TGT);
            String cipherTGT = cipher.Cifrar(Long.parseLong(secretKeyASC)); 
            System.out.println("TGT decifrado = " + TGT);
            System.out.println("TGT cifrado = " + cipherTGT);
            System.out.println("TGT enviado");
            stream.sendMessage(cipherTGT);
        } else {
            System.err.println("ID de Cliente o TGS no coinciden");
        }
        //Close the sockets
        stream.close();
        serverSocket.close();
    }    
}