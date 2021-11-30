import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Keys {
    private String publicKeyAS;
    private String privateKeyAS;
    private String secretKey;
    private String numberNAS;

    /* Public Key */
    // Setter for the Public Key
    public void setPublicKeyAS(String publicKeyAS) {
        this.publicKeyAS = publicKeyAS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\AS\\Keys\\publicKeyAS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.publicKeyAS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Public Key
    public String getPublicKeyAS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\AS\\Keys\\publicKeyAS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.publicKeyAS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.publicKeyAS;
    }
    /* Private Key */
    // Setter for the Private Key
    public void setPrivateKeyAS(String privateKeyAS) {
        this.privateKeyAS = privateKeyAS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\AS\\Keys\\privateKeyAS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.privateKeyAS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Private Key
    public String getPrivateKeyAS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\AS\\Keys\\privateKeyAS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.privateKeyAS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.privateKeyAS;
    }
    /* Secret Key */
    // Setter for the Secret Key
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\AS\\Keys\\secretKey.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.secretKey);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Secret Key
    public String getSecretKey() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\AS\\Keys\\secretKey.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKey = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKey;
    }






    /* Number NAS */
    // Setter for the Number NAS
    public void setNumberNAS(String numberNAS) {
        this.numberNAS = numberNAS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\AS\\Keys\\numberNAS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.numberNAS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Number NC
    public String getNumberNAS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\AS\\Keys\\numberNAS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.numberNAS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.numberNAS;
    }
}
