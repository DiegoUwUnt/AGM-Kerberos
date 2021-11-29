

import java.net.*;
import java.math.BigInteger;
import java.util.Random;
import java.io.*;
import java.util.Scanner;


public class Methods {

    private int publicKey;
    private BigInteger privateKey;
    private BigInteger bigNumber_publicKey;
    private BigInteger cipherVal;
    private BigInteger bigNumber_n;

    public int genKeys() {
        Random random1;
        Random random2;
        BigInteger bigNumber_p;
        BigInteger bigNumber_q;
        BigInteger bigNumber_p_1;
        BigInteger bigNumber_q_1;
        BigInteger bigNumber_p_1_q_1;
        String mensaje;
        //Creamos dos numeros aleatorios dados por el tiempo actual en milisegundos del sistema
        random1 = new Random(System.currentTimeMillis());
        random2 = new Random(System.currentTimeMillis() * 10);
        //El usuario introduce un número el cual funcionara como la llave publica
        publicKey = 2;
        //Se emplean aleatoriamente dos numeros enteros primos grandes a los que llamaremos p y q*/
        bigNumber_p = BigInteger.probablePrime(32, random1);
        bigNumber_q = BigInteger.probablePrime(32, random2);
        //Se calcula n como el valor del producto de p y q (p*q)
        bigNumber_n = bigNumber_p.multiply(bigNumber_q);
        //System.out.println("Numero p: " + bigNumber_p);
        //System.out.println("Numero q: " + bigNumber_q);
        //Se calcula fi de la siguiente forma: fi(n)= (p-1)(q-1)
        bigNumber_p_1 = bigNumber_p.subtract(new BigInteger("1"));//(p-1)
        bigNumber_q_1 = bigNumber_q.subtract(new BigInteger("1"));//(q-1)
        bigNumber_p_1_q_1 = bigNumber_p_1.multiply(bigNumber_q_1);//(p-1)*(q-1)
        /*Se genera la llave publica correcta dada por el usuario y se calcula un número natural e
        de manera que MCD(e, fi(n)) = 1, es decir, e debe ser primo relativo de fi(n).*/
        while (true) {
            BigInteger bigNumber_MCD = bigNumber_p_1_q_1.gcd(new BigInteger("" + publicKey));
            if (bigNumber_MCD.equals(BigInteger.ONE)) {
                break;
            }
            publicKey++;
        }
        bigNumber_publicKey = new BigInteger("" + publicKey);
        privateKey = bigNumber_publicKey.modInverse(bigNumber_p_1_q_1);
        /*
        -El par de numeros (e, n) son la clave publica
        -El par de numeros (d, n) son la clave privada
         */
        System.out.println("La clave publica es: " + publicKey + " ," + bigNumber_n);
        //System.out.println("Clave privada: " + privateKey + " ," + bigNumber_n);
        int sendPublicKey = publicKey;
        return sendPublicKey;
    }

    public String cifrar(String txt) {
        System.out.println("El mensaje a cifrar es: " + txt);
        byte[] bufferEmisor = txt.getBytes();
        String cifrado = "";
        for (int i = 0; i < txt.length(); i++) {
            int asciiVal = bufferEmisor[i];
            BigInteger val = new BigInteger("" + asciiVal);
            cipherVal = val.modPow(bigNumber_publicKey, bigNumber_n);
            if (i != txt.length() - 1) {
                cifrado += cipherVal + "/-/:/-/";
            } else {
                cifrado += cipherVal;
            }

        }
        return cifrado;
    }

    public String descifrar(String txt) {
        String descifrado = "";
        BigInteger cipherVal = new BigInteger(txt);

        BigInteger plainVal = cipherVal.modPow(privateKey, bigNumber_n);
        int i_plainVal = plainVal.intValue();
        descifrado = (Character.toString((char) i_plainVal));
        return descifrado;
    }

    public int getPublicKey() {
        return publicKey;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public BigInteger getBigNumber_publicKey() {
        return bigNumber_publicKey;
    }

    public BigInteger getCipherVal() {
        return cipherVal;
    }

    public BigInteger getBigNumber_n() {
        return bigNumber_n;
    }

    public void setPublicKey(int publicKey) {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

    public void setBigNumber_publicKey(BigInteger bigNumber_publicKey) {
        this.bigNumber_publicKey = bigNumber_publicKey;
    }

    public void setCipherVal(BigInteger cipherVal) {
        this.cipherVal = cipherVal;
    }

    public void setBigNumber_n(BigInteger bigNumber_n) {
        this.bigNumber_n = bigNumber_n;
    }

}
