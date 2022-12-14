package day06;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedListServer {

    public static void main(String[] args) throws Exception {

        // Get the port
        Integer port = Integer.parseInt(args[0]);


        // Create a thread pool
        ExecutorService thrPool = Executors.newFixedThreadPool(2);

        // Create a ServerSocket and bind to the port
        ServerSocket server = new ServerSocket(port) ;
        System.out.printf("Listening on port %d\n", port);

        // Server loop
        while (true) {
            // Wait for a connection
            System.out.println("Waiting for connections...");
            Socket socket = server.accept();

            // Create a HandleClient to handle the client socket
            HandleClient client = new HandleClient(socket);
            // Do not do this. THIS IS NOT A THREAD
            // client.run();
            
            // Submit the Runnable to the threadpool
            thrPool.submit(client);

        }

    }


}