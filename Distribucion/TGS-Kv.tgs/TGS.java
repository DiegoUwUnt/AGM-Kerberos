
public class TGS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sockets UDP = new Sockets();
        String mensaje = UDP.Receptor();
        if (mensaje.equals("Claves")) {
            Methods clave = new Methods();
            clave.genKeys();
            String llavePublica = (clave.getPublicKey() + "/-/:/-/" + clave.getBigNumber_n());
            UDP.Emisor(llavePublica);
            System.out.println(clave.getPublicKey());
            System.out.println(clave.getBigNumber_n());
            String llaveCifrada = UDP.Receptor();
            
            String[] llaveCifradaA = llaveCifrada.split("/-/:/-/");
            String llaveDescifrada ="";
            for (int i = 0; i < llaveCifradaA.length; i++) {
                llaveDescifrada += clave.descifrar(llaveCifradaA[i]);
            }
            System.out.println(llaveDescifrada);
            
            Serializacion archivo = new Serializacion();
            archivo.setClave(llaveDescifrada);
            archivo.guardar();
        }
    }

}
