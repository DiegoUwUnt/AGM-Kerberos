/* 
 * Transposition cipher class
 */
import java.util.Arrays;

/**
 * @author Paulina Maldonado
 */
public class TCipher {

    private int key;
    private int nColumnas = 5;

    private char[][] vector;
    private char[] mensaje;
    private int filas;

    public void setMensaje(String message) {

        int longitud = message.length();
        filas = (longitud % nColumnas == 0) ? longitud / nColumnas : (longitud / nColumnas) + 1;
        vector = new char[filas][nColumnas];
        mensaje = new char[nColumnas * filas];

        Arrays.fill(mensaje, ' ');

        for (int i = 0; i < longitud; i++) {
            mensaje[i] = message.charAt(i);
        }
    }

    public void Cifrar(int Key){
        this.key = Key;

        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < nColumnas; j++) {
                vector[i][j] = mensaje[index];
                index++;
            }
        }
        index = 0;
        int nKey;
        for (int i = 0; i < nColumnas; i++) {
            nKey = Character.getNumericValue(String.valueOf(key).charAt(i));
            for (int j = 0; j < filas; j++) {
                mensaje[index] = vector[j][nKey];
                index++;
            }
        }

        System.out.println("\nTexto cifrado: " + String.valueOf(mensaje));
        System.out.println("Key: " + key);
    }


    public void Descifrar(int key){
        this.key = key;
        int nKey, index = 0;
        try{
            for (int i = 0; i < nColumnas; i++) {
                nKey = Character.getNumericValue(String.valueOf(key).charAt(i));
                for (int j = 0; j < filas; j++) {
                    vector[j][nKey] = mensaje[index];
                    index++;
                }
            }

            index = 0;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < nColumnas; j++) {
                    mensaje[index] = vector[i][j];
                    index++;
                }
            }

            System.out.println("\nTexto descifrado: " + String.valueOf(mensaje));
        } catch(Exception e){
            System.out.println("\nClave incorrecta");
        }
    }
}

