import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // todo: implement the scenario
        // Read message sent by the client
        String v=inServer.readLine();
        // Write message to the client
        String voyl="";
        String novol="";

        for(int i=0;i<v.length();i++)
        {
                if (v.toLowerCase().charAt(i)=='a'|| v.toLowerCase().charAt(i)=='e'||v.toLowerCase().charAt(i)=='i'||v.toLowerCase().charAt(i)=='u'||v.toLowerCase().charAt(i)=='o'||v.toLowerCase().charAt(i)=='y')
                { voyl += v.charAt(i);}
                else
                { novol += v.charAt(i);}


        }
        outServer.println(novol);

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
        serverSocket.close();
    }
}
