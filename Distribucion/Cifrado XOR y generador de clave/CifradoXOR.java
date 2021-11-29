
public class CifradoXOR {
    
    public static String cifrar(String texto, String clave){
        byte[] claveB = clave.getBytes();
        
        byte[] textoB = texto.getBytes();
        byte[] cifrado = new byte[texto.length()];
        
         int j = 0;
         for (int i = 0; i < texto.length(); i++) {
            if (j == claveB.length -1) j = 0;
            
            cifrado[i] = (byte) (textoB[i] ^ claveB[j]);
            
            j++;
        }
         
         String textoCifrado = new String(cifrado);
         
         return textoCifrado;
    }
}
