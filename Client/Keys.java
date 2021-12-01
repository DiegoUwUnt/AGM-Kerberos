import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Keys {
    private String publicKeyC;
    private String privateKeyC;
    private String secretKeyASC;
    private String numberNC;

    /* Public Key */
    // Setter for the Public Key
    public void setPublicKeyC(String publicKeyC) {
        this.publicKeyC = publicKeyC;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\Client\\Keys\\publicKeyC.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.publicKeyC);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Public Key
    public String getPublicKeyC() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\Client\\Keys\\publicKeyC.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.publicKeyC = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.publicKeyC;
    }
    /* Private Key */
    // Setter for the Private Key
    public void setPrivateKeyC(String privateKeyC) {
        this.privateKeyC = privateKeyC;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\Client\\Keys\\privateKeyC.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.privateKeyC);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Private Key
    public String getPrivateKeyC() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\Client\\Keys\\privateKeyC.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.privateKeyC = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.privateKeyC;
    }
    /* Number n */
    // Setter for the Number NC
    public void setNumberNC(String numberNC) {
        this.numberNC = numberNC;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\Client\\Keys\\numberNC.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.numberNC);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    // Getter for the Number NC
    public String getNumberNC() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\Client\\Keys\\numberNC.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.numberNC = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.numberNC;
    }

    /* Secret Key */
    // Setter for the Secret Key
    public void setSecretKeyASC(String secretKeyASC) {
        this.secretKeyASC = secretKeyASC;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\Client\\Keys\\secretKeyASC.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.secretKeyASC);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Secret Key
    public String getSecretKeyASC() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\Client\\Keys\\secretKeyASC.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKeyASC = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKeyASC;
    }
}
