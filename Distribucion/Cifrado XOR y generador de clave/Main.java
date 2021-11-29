
public class Main {

    public static void main(String[] args) {
        String texto = "hello world";
        String contrasena = "hola12346";
        
        //Se crea una clave a partir de contrase�a 
        //(Esta clave solo es v�lida para cuando en Kerberos lo pida, si no, 
        //es necesario ocupar la guardada en el archivo de clave.dat
        String clave = TransformadorClave.transformar(contrasena);
        System.out.println("clave: "+clave);
        
        //Se cifra el texto con la clave generara en el paso anterior
        String textoCifrado = CifradoXOR.cifrar(texto, clave);
        
        //Se imprime el texto cifrado
        System.out.println("Texto cifrado: "+ textoCifrado);
        
        //Se descifra con el mismo metodo y clave el texto Cifrado
        System.out.println(CifradoXOR.cifrar(textoCifrado, clave));
        
    }

}
