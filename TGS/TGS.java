/*
 * Ticket Granting Server Class
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author Alexander Sanchez
 */
public class TGS {
    public static void main(String[] args) throws SocketException, IOException {
        Scanner data = new Scanner(System.in);
        Keys keys = new Keys();
        TCipher cipher = new TCipher();
        System.out.println("Escribe el ID del ServidorV");
        String serverVID = data.next();
        //Socket instance to accept the connection
        ServerSocket serverSocket = new ServerSocket(6578);
        System.out.println("Preparando para aceptar una conexion...");
        //Wait until an user connection, then it accept the connection 
        Stream stream = new Stream(serverSocket.accept());
        System.out.println("Conexion aceptada");
        //It receives the message
        String message = stream.receiveMessage();
        String[] splitMessage = message.split(" /-/:/-/ ", 3);
        //Decrypt the TicketTGS
        long secretKeyASTGS = Long.parseLong(keys.getSecretKeyASTGS());
        System.out.println(String.valueOf(secretKeyASTGS));
        System.out.println(splitMessage[1]);
        cipher.setMensaje(splitMessage[1].trim());
        String ticketTGS = cipher.Descifrar(secretKeyASTGS); 
        System.out.println(ticketTGS);
        String[] splitTicketTGS = ticketTGS.split(" /-/:/-/ ", 4);
        //Decrypt the authenticator
        cipher.setMensaje(splitMessage[2].trim());
        String authenticator = cipher.Descifrar(Long.parseLong(splitTicketTGS[0]));
        System.out.println(authenticator);
        String[] splitAuthenticator = authenticator.split(" /-/:/-/ ", 2);

        System.out.println("Generando TicketV ...");
        if(splitTicketTGS[1].contains(splitAuthenticator[0]) && splitTicketTGS[2].trim().contains(splitAuthenticator[1].trim()) && serverVID.contains(splitMessage[0])) {
            //Generate a new key fot the client and the server v
            String kCV = keys.genSecretKey();
            //Made the ticket V
            String ticketV = kCV + " /-/:/-/ " + splitAuthenticator[0] + " /-/:/-/ " + splitAuthenticator[1] + " /-/:/-/ " + serverVID;
            //Get the secret key of the TGS and Server V
            String secretKeyTGSV = keys.getSecretKeyTGSV();
            //Encrypt the ticket v with the tgs and server v secret key
            cipher.setMensaje(ticketV);
            String cipherTicketV = cipher.Cifrar(Long.parseLong(secretKeyTGSV));
            System.out.println(cipherTicketV);
            //We made the package
            String packageV = kCV + " /-/:/-/ " + serverVID +  " /-/:/-/ " + cipherTicketV;
            System.out.println("Mensaje: " + packageV);
            cipher.setMensaje(packageV);
            String cipherPackageV = cipher.Cifrar(Long.parseLong(splitTicketTGS[0]));
            System.out.println("Mensaje cifrado: " + cipherPackageV);
            stream.sendMessage(cipherPackageV);
            System.out.println("TicketV enviado"); 
        } else {
            System.err.println("ID Cliente, Direccion o ID ServidorV no coincide");
        }
        //Close the sockets
        stream.close();
        serverSocket.close();
    }
}

