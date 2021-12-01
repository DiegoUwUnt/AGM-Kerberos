import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Keys {
    private String publicKeyTGS;
    private String privateKeyTGS;
    private String secretKeyASTGS;
    private String secretKeyTGSV;
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
    public void setSecretKeyASTGS(String secretKeyASTGS) {
        this.secretKeyASTGS = secretKeyASTGS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\TGS\\Keys\\secretKeyASTGS.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.secretKeyASTGS);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Secret Key
    public String getSecretKeyASTGS() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\TGS\\Keys\\secretKeyASTGS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKeyASTGS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKeyASTGS;
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


    /* Secret Key */
    // Setter for the Secret Key
    public void setSecretKeyTGSV(String secretKeyTGSV) {
        this.secretKeyTGSV = secretKeyTGSV;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\TGS\\Keys\\secretKeyTGSV.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.secretKeyTGSV);
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Getter for the Secret Key
    public String getSecretKeyTGSV() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\TGS\\Keys\\secretKeyTGSV.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKeyTGSV = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKeyTGSV;
    }
}
