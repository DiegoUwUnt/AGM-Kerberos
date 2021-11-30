/*
 * Distribution between AS and Client
 */
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Scanner;
/**
 * @author Diego Zarza
 */

public class KeyASC {

    public static void main (String[] args) throws IOException, SocketException {
        Scanner data = new Scanner(System.in);
        RSACipher cipher = new RSACipher();
        Keys key = new Keys();
        String option = "0";
        System.out.println("---- M E N U ---- ");
        System.out.println("1: Generador de claves");
        System.out.println("2: Generador de clave secreta");
        System.out.println("3: Salir");
        do {
            System.out.println("Escoge la opcion: ");
            option = data.next();
            switch (option) {
                //Public & Private Keys Register
                case "1" -> {
                    System.out.println("Escribe un numero: ");
                    int number = data.nextInt();
                    String[] keys = cipher.genKeys(number);
                    key.setPublicKeyAS(keys[0]);
                    key.setPrivateKeyAS(keys[1]);
                    key.setNumberNAS(keys[2]);
                    System.out.println("Llaves generadas y guardadas");
                    break;
                }
                case "2" -> {
                    System.out.println("Generado clave ...");
                    String secretKey = cipher.genSecretKey();
                    System.out.println(secretKey);
                    key.setSecretKey(secretKey);
                    System.out.println("Preparando para aceptar solicitud ...");
                    ServerSocket serverSocket = new ServerSocket(6578);
                    Stream stream = new Stream(serverSocket.accept());
                    String message1 = stream.receiveMessage();
                    String message2 = stream.receiveMessage();
                    System.out.println("Llave publica recibida :)");
                    BigInteger publicKey = new BigInteger(message1);
                    BigInteger numberNC = new BigInteger(message2);
                    System.out.println("Cifrando clave secreta, dios ayudanos");
                    String cipherSecretKey = cipher.cifrar(secretKey, publicKey, numberNC);
                    System.out.println("Enviando clave secreta");
                    stream.sendMessage(cipherSecretKey);
                    break;
                }
                case "3" -> {
                    System.exit(0);
                    break;
                }
            }
        } while (option != "3");

        
        //ServerSocket serverSocket = new ServerSocket(6578);
        //System.out.println("Preparando para aceptar conexiones...");
        //Stream stream = new Stream(serverSocket.accept());
    }
}
