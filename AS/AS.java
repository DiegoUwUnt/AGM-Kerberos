/*
 * Authentication Server Class
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

/**
 * @author Alexander Sanchez
 */
public class AS {
    public static void main(String[] args) throws SocketException, IOException {
        User user = new User();
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
        String username = user.getUsername();
        String password;
        String TGT;
        if(message.equals(username)) {
            password = user.getPassword();
            TGT = username + password;
            stream.sendMessage(TGT);
        } else {
            System.err.println("Usuario no existe");
        }
        //Close the sockets
        stream.close();
        serverSocket.close();
    }    
}