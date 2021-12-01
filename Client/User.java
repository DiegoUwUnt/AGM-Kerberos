/*
 * User Object Setters, Getters and Saving
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * @author Paulina Maldonado
 */
public class User {
    private String TGT;
    private String Ticket;
    
     /*TGT*/
    //Setter for the TGT
    public void setTGT(String TGT) {
        this.TGT = TGT;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\info\\Tickets\\TGT.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.TGT);
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

    /*Ticket*/
    //Setter for the Ticket
    public void setTicket(String Ticket) {
        this.Ticket = Ticket;
        try {
            FileOutputStream file = new FileOutputStream("C:\\AGM-Kerberos\\info\\Tickets\\Ticket.dat");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(this.Ticket);
            file.close();
            object.close();    
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    //Getter for the Ticket
    public String getTicket() {
        try {
            FileInputStream file = new FileInputStream("C:\\AGM-Kerberos\\info\\Tickets\\Ticket.dat");
            ObjectInputStream object = new ObjectInputStream(file);
            this.Ticket = object.readObject().toString();
            file.close();
            object.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return this.Ticket;  
    }


}