
/*
 * Distribution between Client and AS
 */
import java.io.IOException;
import java.math.BigInteger;
import java.net.SocketException;
import java.util.Scanner;
/**
 * @author Diego Zarza
 */

public class KeyV {
    public static void main(String[] args) throws IOException, SocketException {
        Scanner data = new Scanner(System.in);
        RSACipher cipher = new RSACipher();
        Keys key = new Keys();
        String option = "0";
        System.out.println("---- M E N U ---- ");
        System.out.println("1: Generador de claves");
        System.out.println("2: Distribucion de clave secreta");
        System.out.println("3: Salir");
        do {
            System.out.println("Escoge la opcion: ");
            option = data.next();
            switch (option) {
                // Public & Private Keys Register
                case "1" -> {
                    System.out.println("Escribe un numero: ");
                    int number = data.nextInt();
                    String[] keys = cipher.genKeys(number);
                    key.setPublicKeyV(keys[0]);
                    key.setPrivateKeyV(keys[1]);
                    key.setNumberNV(keys[2]);
                    System.out.println("Llaves generadas y guardadas");
                    break;
                }
                case "2" -> {
                    System.out.println("Enviando clave publica...");
                    Stream stream = new Stream("localhost", 6578);
                    String publicKeyV = key.getPublicKeyV();
                    String numberN = key.getNumberNV();
                    stream.sendMessage(publicKeyV);
                    stream.sendMessage(numberN);
                    System.out.println("Recibiendo y descifrando clave secreta...");
                    BigInteger privateKeyV = new BigInteger(key.getPrivateKeyV());
                    BigInteger numberNV = new BigInteger(numberN);
                    String cipherSecretKey = stream.receiveMessage();
                    String[] decrypt = cipherSecretKey.split("/-/:/-/");
                    String secretKey = "";
                    for (int i = 0; i < decrypt.length; i++) {
                        secretKey += cipher.descifrar(decrypt[i], privateKeyV, numberNV);
                    }
                    System.out.println(secretKey);
                    key.setSecretKeyTGSV(secretKey);
                    System.out.println("Clave secreta guardada");
                    stream.close();
                    break;

                }
                case "3" -> {
                    System.exit(0);
                    break;
                }
            }
        } while (option != "3");
    }
}
