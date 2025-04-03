import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        int port = 12345;  // Port number
        try {
            // Create a server socket that listens on port 12345
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Get the input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Read data from the client
            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client: " + clientMessage);

                // Send a response to the client
                output.println("Server received: " + clientMessage);
            }

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
