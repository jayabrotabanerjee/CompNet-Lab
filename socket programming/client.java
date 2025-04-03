import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        String serverAddress = "localhost";  // Server address (localhost or IP)
        int port = 12345;  // Server port

        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to the server");

            // Get the input and output streams for communication
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read user input and send it to the server
            String message;
            while (true) {
                System.out.print("Enter message to send to the server (type 'exit' to quit): ");
                message = userInput.readLine();

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                // Send the message to the server
                output.println(message);

                // Receive the server's response
                String serverResponse = input.readLine();
                System.out.println("Server: " + serverResponse);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
