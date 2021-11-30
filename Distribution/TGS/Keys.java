import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Keys {
    private String publicKeyTGS;
    private String privateKeyTGS;
    private String secretKey;
    private String numberNTGS;

    /* Public Key */
    // Setter for the Public Key
    public void setPublicKeyTGS(String publicKeyTGS) {
        this.publicKeyTGS = publicKeyTGS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\TGS\\Keys\\publicKeyTGS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.publicKeyTGS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Public Key
    public String getPublicKeyTGS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\TGS\\Keys\\publicKeyTGS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.publicKeyTGS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.publicKeyTGS;
    }

    /* Private Key */
    // Setter for the Private Key
    public void setPrivateKeyTGS(String privateKeyTGS) {
        this.privateKeyTGS = privateKeyTGS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\TGS\\Keys\\privateKeyTGS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.privateKeyTGS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Private Key
    public String getPrivateKeyTGS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\TGS\\Keys\\privateKeyTGS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.privateKeyTGS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.privateKeyTGS;
    }

    /* Secret Key */
    // Setter for the Secret Key
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\TGS\\Keys\\secretKey.dat");
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
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\TGS\\Keys\\secretKey.dat");
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
    // Setter for the Number TGS
    public void setNumberNTGS(String numberNTGS) {
        this.numberNTGS = numberNTGS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\TGS\\Keys\\numberNTGS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.numberNTGS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Number NC
    public String getNumberNTGS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\TGS\\Keys\\numberNTGS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.numberNTGS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.numberNTGS;
    }
}
