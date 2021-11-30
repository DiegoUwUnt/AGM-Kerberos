/*
 * User Object Setters, Getters and Saving
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * @author Alexander Sanchez 
 */
public class User {
    private String username;
    private String password;
    private String TGT;
    private String Ticket;
    
    /*Username*/
    //Setter for the username
    public void setUsername(String username) {
        this.username = username;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\info\\User\\username.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.username);
            file.close();
            object.close();    
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    //Getter for the username
    public String getUsername() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\info\\User\\username.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.username = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.username;  
    }

    /*Password*/
    //Setter for the password
    public void setPassword(String password) {
        this.password = password;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\info\\User\\password.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.password);
            file.close();
            object.close();    
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    //Getter for the password
    public String getPassword() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\info\\User\\password.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.password = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.password;  
    }

     /*TGT*/
    //Setter for the TGT
    public void setTGT(String TGT) {
        this.TGT = TGT;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\info\\Tickets\\TGT.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.username);
            file.close();
            object.close();    
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    //Getter for the TGT
    public String getTGT() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\info\\Tickets\\TGT.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.TGT = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.TGT;  
    }

}
