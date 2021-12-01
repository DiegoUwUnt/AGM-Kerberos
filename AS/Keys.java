import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Keys {
    private String publicKeyAS;
    private String privateKeyAS;
    private String secretKeyASC;
    private String numberNAS;
    private String secretKeyASTGS;

    //Key generator
    public String genSecretKey() {
        ArrayList<String> keyNumbers = new ArrayList<>();
        Random random = new Random();
        String key = "";
        keyNumbers.add("0");
        keyNumbers.add("1");
        keyNumbers.add("2");
        keyNumbers.add("3");
        keyNumbers.add("4");
        keyNumbers.add("5");
        keyNumbers.add("6");
        keyNumbers.add("7");
        keyNumbers.add("8");
        keyNumbers.add("9");
        while (keyNumbers.size() > 0) {
            int randomIndex = random.nextInt(keyNumbers.size());
            key = key + keyNumbers.get(randomIndex);
            keyNumbers.remove(randomIndex);
        }
        return key;
    }

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
    public void setSecretKeyASC(String secretKeyASC) {
        this.secretKeyASC = secretKeyASC;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\AS\\Keys\\secretKeyASC.dat");
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
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\AS\\Keys\\secretKeyASC.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKeyASC = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKeyASC;
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


/* Secret Key */
    // Setter for the Secret Key
    public void setSecretKeyASTGS(String secretKeyASTGS) {
        this.secretKeyASTGS = secretKeyASTGS;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\AS\\Keys\\secretKeyASTGS.dat");
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
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\AS\\Keys\\secretKeyASTGS.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.secretKeyASTGS = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.secretKeyASTGS;
    }
}
