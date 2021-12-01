
/*
 * Distribution between Client and AS
 */
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Scanner;
/**
 * @author Diego Zarza
 */

public class KeyTGS {
    public static void main(String[] args) throws IOException, SocketException {
        Scanner data = new Scanner(System.in);
        RSACipher cipher = new RSACipher();
        Keys key = new Keys();
        String option = "0";
        System.out.println("---- M E N U ---- ");
        System.out.println("1: Generador de claves");
        System.out.println("2: Distribucion de clave AS-TGS");
        System.out.println("3: Distribucion de clave TGS-V");
        System.out.println("4: Salir");
        do {
            System.out.println("Escoge la opcion: ");
            option = data.next();
            switch (option) {
                // Public & Private Keys Register
                case "1" -> {
                    System.out.println("Escribe un numero: ");
                    int number = data.nextInt();
                    String[] keys = cipher.genKeys(number);
                    key.setPublicKeyTGS(keys[0]);
                    key.setPrivateKeyTGS(keys[1]);
                    key.setNumberNTGS(keys[2]);
                    System.out.println("Llaves generadas y guardadas");
                    break;
                }
                case "2" -> {
                    System.out.println("Enviando clave publica...");
                    Stream stream = new Stream("localhost", 6578);
                    String publicKeyTGS = key.getPublicKeyTGS();
                    String numberN = key.getNumberNTGS();
                    stream.sendMessage(publicKeyTGS);
                    stream.sendMessage(numberN);
                    System.out.println("Recibiendo y descifrando clave secreta...");
                    BigInteger privateKeyTGS = new BigInteger(key.getPrivateKeyTGS());
                    BigInteger numberNTGS = new BigInteger(numberN);
                    String cipherSecretKey = stream.receiveMessage();
                    String[] decrypt = cipherSecretKey.split("/-/:/-/");
                    String secretKey = "";
                    for (int i = 0; i < decrypt.length; i++) {
                        secretKey += cipher.descifrar(decrypt[i], privateKeyTGS, numberNTGS);
                    }
                    System.out.println(secretKey);
                    key.setSecretKeyASTGS(secretKey);
                    System.out.println("Clave secreta guardada");
                    stream.close();
                    break;

                }
                case "3" -> {
                    System.out.println("Generado clave ...");
                    String secretKey = cipher.genSecretKey();
                    System.out.println(secretKey);
                    key.setSecretKeyTGSV(secretKey);
                    System.out.println("Preparando para aceptar solicitud ...");
                    ServerSocket serverSocket = new ServerSocket(6578);
                    Stream stream = new Stream(serverSocket.accept());
                    String message1 = stream.receiveMessage();
                    String message2 = stream.receiveMessage();
                    System.out.println("Llave publica recibida");
                    BigInteger publicKey = new BigInteger(message1);
                    BigInteger numberNV = new BigInteger(message2);
                    System.out.println("Cifrando clave secreta...");
                    String cipherSecretKey = cipher.cifrar(secretKey, publicKey, numberNV);
                    System.out.println("Enviando clave secreta...");
                    stream.sendMessage(cipherSecretKey);
                    stream.close();
                    serverSocket.close();
                    break;
                }
                case "4" -> {
                    System.exit(0);
                    break;
                }
            }
        } while (option != "4");
    }
}

