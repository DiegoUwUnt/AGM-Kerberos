import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Keys {
    private String publicKeyV;
    private String privateKeyV;
    private String secretKey;
    private String numberNV;

    /* Public Key */
    // Setter for the Public Key
    public void setPublicKeyV(String publicKeyV) {
        this.publicKeyV = publicKeyV;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\publicKeyV.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.publicKeyV);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Public Key
    public String getPublicKeyV() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\publicKeyV.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.publicKeyV = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.publicKeyV;
    }
    /* Private Key */
    // Setter for the Private Key
    public void setPrivateKeyV(String privateKeyV) {
        this.privateKeyV = privateKeyV;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\privateKeyV.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.privateKeyV);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Private Key
    public String getPrivateKeyV() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\privateKeyV.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.privateKeyV = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.privateKeyV;
    }
    /* Secret Key */
    // Setter for the Secret Key
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\secretKey.dat");
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
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\secretKey.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKey = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKey;
    }
    /* Number n */
    // Setter for the Number NC
    public void setNumberNV(String numberNV) {
        this.numberNV = numberNV;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\numberNV.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.numberNV);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Number NC
    public String getNumberNV() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\ServerV\\Keys\\numberNV.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.numberNV = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.numberNV;
    }
}
