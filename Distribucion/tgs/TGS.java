

import java.math.BigInteger;


public class TGS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String llaveSecreta = args[0];
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
