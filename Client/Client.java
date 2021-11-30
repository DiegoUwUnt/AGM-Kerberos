/*
 * Client 
 */
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

/** 
 * @author Alexander Sanchez 
 */
public class Client {
    public static void main(String[] args) throws SocketException, IOException {
        User user = new User();
        Scanner data = new Scanner(System.in);
        String option = "";

        System.out.println("---- M E N U ----");
        System.out.println("1) Registro");
        System.out.println("2) Peticion del TGT");
        System.out.println("3) Peticion del Ticket");
        System.out.println("4) Peticion del Servicio");
        System.out.println("5) Salir");
        

        do {
            System.out.println("Escribe el numero de opcion:");
            option = data.next();
            switch(option) {
                //Register option
                case "1" -> {
                    System.out.println("-- REGISTRO --");
                    System.out.println("Escribe un usuario:");
                    String username = data.next();
                    System.out.println("Escribe una contrasena:");
                    String password = data.next();
                    //Set and save de username and password
                    user.setUsername(username); 
                    user.setPassword(password);
                    break;
                }
                //Request TGT option
                case "2" -> {
                    System.out.println("-- Solicitud de TGT --");
                    //String message;
                    System.out.println("Escribe tu usuario:");
                    String username = data.next();
                    //System.out.println("TGS ID:");
                    //String tgsID = data.next();
                    //message = username + tgsID;
                    //Instance of a data socket to send the username
                    Stream stream = new Stream("localhost", 6578);
                    //Send the message, then the server accepts the connection
                    stream.sendMessage(username);
                    System.out.println("Solicitud de conexion aceptada");
                    //Accept the TGT from the AS and the client save it
                    String TGT = stream.receiveMessage();
                    user.setTGT(TGT);
                    System.out.println("TGT recibido y guardado");
                    System.out.println(TGT);
                    //Close the data socket
                    stream.close();
                    break;
                }
                //Request Ticket option
                case "3" -> {
                    break;
                }
                //Service request option
                case "4" -> {
                    break;
                }
                //Exit option
                case "5" -> {
                    option = "5";
                    break;
                }
                //Default option
                default -> {
                    break;
                }
            }
        } while(option != "5"); 
        
        

    }
}