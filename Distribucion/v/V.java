/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v.kv.tgs;

import java.math.BigInteger;

/**
 *
 * @author DIEGO
 */
public class V {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String llaveSecreta = "LlaveSecretaV";
        Sockets UDP = new Sockets();
        UDP.Emisor("Claves");
        Methods metodos = new Methods();
        String llavePublica = UDP.Receptor();
        String publicKey = "";
        String bigNumber_n = "";
        System.out.println(llavePublica);
        publicKey = llavePublica.split("/-/:/-/")[0];
        bigNumber_n = llavePublica.split("/-/:/-/")[1];
        metodos.setBigNumber_publicKey(new BigInteger(publicKey));
        metodos.setBigNumber_n(new BigInteger(bigNumber_n));
        String llaveCifrada = metodos.cifrar(llaveSecreta);
        UDP.Emisor(llaveCifrada);
        Serializacion archivo = new Serializacion();
        archivo.setClave(llaveSecreta);
        archivo.guardar();
    }

}
