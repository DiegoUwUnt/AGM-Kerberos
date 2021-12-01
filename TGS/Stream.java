/*
 * Streams Class 
 */
import java.net.*;
import java.io.*;

/**
 * @author Alexander Sanchez
 */
public class Stream extends Socket {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    Stream(String serverAddress, int serverPort) throws SocketException, IOException {
        socket = new Socket(serverAddress, serverPort);
        setStream();
    }
    Stream(Socket socket) throws IOException {
        this.socket = socket;
        setStream();
    }

    //A method to set the streams output and input
    private void setStream() throws IOException {
        //Get a output stream to be able to read the data socket
        InputStream inputStream = socket.getInputStream();
        input = new BufferedReader(new InputStreamReader(inputStream));
        //Create an PrintWriter object to be able to write
        OutputStream outputStream = socket.getOutputStream();
        output = new PrintWriter(new OutputStreamWriter(outputStream));
    }

    //Method to send a message
    public void sendMessage(String message) throws IOException {
        output.println(message);
        //This calls the flush() method to write on the socket stream
        //before it close
        output.flush();
    }

    //Method to receive a message
    public String receiveMessage() throws IOException {
        //Read a line of a data stream
        String message = input.readLine();
        return message;
    }

    //A method to close the socket
    public void close() throws IOException {
        socket.close();
    }
    
}