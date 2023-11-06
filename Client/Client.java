/*
 * Client 
 */
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

/** 
 * @author Paulina Maldonado
 */
public class Client {
    public static void main(String[] args) throws SocketException, IOException {
        User user = new User();
        TCipher cipher = new TCipher();
        Keys keys = new Keys();
        Scanner data = new Scanner(System.in);
        String option = "";
        String clientID = "";
        String kCTGS = "";
        String kCV = "";
e
        System.out.println("---- M E N U ----");
        System.out.println("1) Peticion del TGT");
        System.out.println("2) Peticion del TicketV");
        System.out.println("3) Peticion del Servicio");
        System.out.println("4) Salir");
        

        do {
            System.out.println("Escribe el numero de opcion:");
            option = data.next();
            switch(option) {
               
                //Request TGT option
                case "1" -> {
                    System.out.println("-- Solicitud de TGT --");
                    String message;
                    System.out.println("Escribe ID del cliente:");
                    clientID = data.next();
                    System.out.println("Escribe el ID del TGS:");
                    String tgsID = data.next();
                    message = clientID + " /-/:/-/ " + tgsID;
                    //Instance of a data socket to send the username
                    Stream stream = new Stream("26.162.31.246", 6578);
                    //Send the message, then the server accepts the connection
                    stream.sendMessage(message);
                    System.out.println("Solicitud de conexion aceptada");
                    //Accept the TGT from the AS and the client save it
                    String TGT = stream.receiveMessage();
                    System.out.println("TGT recibido y guardado");
                    //Decrypt the TGT from the AS
                    String secretKeyASC = keys.getSecretKeyASC();
                    cipher.setMensaje(TGT);
                    String decryptTGT = cipher.Descifrar(Long.parseLong(secretKeyASC));
                    String[] splitTGT = decryptTGT.split(" /-/:/-/ " , 3);
                    //Saved the keyClientTGS
                    kCTGS = splitTGT[0];
                    //Print the TGT encrypt, decrypt and the Ticket TGS
                    System.out.println("TGT cifardo: " + TGT);
                    System.out.println("TGT descifrado: " + decryptTGT);
                    System.out.println("Ticket TGS: " + splitTGT[2]);
                    user.setTGT(splitTGT[2]);
                    //Close the data socket
                    stream.close();
                    break;
                }
                //Request TicketV option
                case "2" -> {
                    System.out.println("-- Solicitud del TicketV --");
                    String message;
                    System.out.println("Escribe ID del servidorV");
                    String serverVID = data.next();
                    //
                    String ticketTGS = user.getTGT();
                    //Generate the authenticator with the client ID and the client AD
                    String authenticator = clientID + " /-/:/-/ " + "26.74.77.221";
                    //Enrypt the authenticator
                    cipher.setMensaje(authenticator.trim());
                    String cAuthenticator = cipher.Cifrar(Long.parseLong(kCTGS));
                    //Generate the message with the ServerV ID, the Ticket TGS and the Autheticator encrypted 
                    message = serverVID + " /-/:/-/ " + ticketTGS + " /-/:/-/ " + cAuthenticator;
                    //Instance of a data socket to send the username
                    Stream stream = new Stream("26.163.30.166", 6578);
                    stream.sendMessage(message);
                    //Receive the message V and print the message
                    String cipherPackageV = stream.receiveMessage();
                    cipher.setMensaje(cipherPackageV.trim());
                    System.out.println("Ticket cifrado: " + cipherPackageV);
                    //Decrypt the TicketV
                    String packageV = cipher.Descifrar(Long.parseLong(kCTGS));
                    String[] splitPackageV = packageV.split(" /-/:/-/ ", 3);
                    //Saved the key
                    kCV = splitPackageV[0];
                    user.setTicket(splitPackageV[2]);
                    System.out.println("Ticket descifrado: " + packageV);
                    stream.close();
                    break;
                }
                //Service request option
                case "3" -> {
                    System.out.println("-- Solicitud del Servicio --");
                    String message;
                    System.out.println("Escribe ID del servidorS");
                    String serverSID = data.next();
                    //
                    String ticketV = user.getTicket();
                    //Generate the authenticator with the client ID and the client AD
                    String authenticator = clientID + " /-/:/-/ " + "26.74.77.221";
                    //Enrypt the authenticator
                    cipher.setMensaje(authenticator.trim());
                    String cAuthenticator = cipher.Cifrar(Long.parseLong(kCV));
                    //Generate the message with the ServerV ID, the Ticket TGS and the Autheticator encrypted
                    message = serverSID + " /-/:/-/ " + ticketV + " /-/:/-/ " + cAuthenticator;
                    //Instance of a data socket to send the username
                    Stream stream = new Stream(stream.sendMessage(message));
                    //Receive the message V and print the message
                    String cipherPackageS = stream.receiveMessage();
                    cipher.setMensaje(cipherPackageS.trim());
                    System.out.println("Ticket cifrado: " + cipherPackageS);
                    //Decrypt the TicketV
                    String packageS = cipher.Descifrar(Long.parseLong(kCV));
                    String[] splitPackageS = packageS.split(" /-/:/-/ ", 3);
                    //Saved the key
                    kCV = splitPackageS[0];
                    user.setTicket(splitPackageS[2]);
                    System.out.println("Ticket descifrado: " + packageS);
                    stream.close();

                    break;
                }
                //Exit option
                case "4" -> {
                    System.exit(0);
                    break;
                }
                //Default option
                default -> {
                    break;
                }
            }
        } while(option != "4");    

    }
}