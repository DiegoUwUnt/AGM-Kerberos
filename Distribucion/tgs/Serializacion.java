

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion {

    private String clave;

    public String leer() {
        try {
            FileInputStream fis = new FileInputStream("C:\\codigos\\claveTGS.dat");
            ObjectInputStream entrada = new ObjectInputStream(fis);
            clave = entrada.readObject().toString();
            fis.close();
            entrada.close();
        } catch (IOException | ClassNotFoundException ex) {
            clave = null;
            System.out.println("Archivo no existe");
        }
        return clave;
    }

    public void guardar() {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\codigos\\claveTGS.dat");
            ObjectOutputStream salida = new ObjectOutputStream(fos);
            salida.writeObject(clave);
            fos.close();
            salida.close();
        } catch (Exception ex) {
            System.out.println("Error creando archivo");
        }
    }

    public void setClave(String clave_) {
        this.clave = clave_;
    }
}
