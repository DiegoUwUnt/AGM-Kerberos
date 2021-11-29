
public class TransformadorClave {
    
    public static String transformar(String contrasena){
        
        int mitad = (contrasena.length()%2 == 0)? contrasena.length()/2 : (int) (contrase�a.length()/2) + 1;
        
        String parte1 = contrasena.substring(0, mitad-1);
        String parte2 = contrasena.substring(mitad, contrasena.length()-1);
        
        if(contrasena.length() % 2 != 0) parte2 += " ";
        
        byte[] parte1B = parte1.getBytes();
        byte[] parte2B = parte2.getBytes();
        
        byte[] cifrado = new byte[mitad];
        
        for (int i = 0; i < mitad-1; i++) {
            cifrado[i] = (byte) (parte1B[i] ^ parte2B[i]);
        }
        
        String clave = new String(cifrado);
         
        return clave;
    }

}
