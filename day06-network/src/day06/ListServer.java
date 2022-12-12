package day06;

import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListServer {

    public static void main(String[] args) throws Exception {

        // Get the port
        Integer port = Integer.parseInt(args[0]);

        // Random number generator
        Random rnd = new SecureRandom();

        // Create a ServerSocket and bind to the port
        ServerSocket server = new ServerSocket(port) ;
        System.out.printf("Listening on port %d\n", port);

        // Server loop
        while (true) {
            // Wait for a connection
            System.out.println("Waiting for connections...");
            Socket socket = server.accept();

            System.out.printf("New connection on port %d\n", socket.getPort());

            String payload = IOUtils.read(socket);
            String[] values = payload.split(" ");

            Integer count = Integer.parseInt(values[0]);
            Integer range = Integer.parseInt(values[1]);

            List<Integer> randNums = new LinkedList<>();
            for (Integer i = 0; i < count; i++)
                randNums.add(rnd.nextInt(range));

            String response = randNums.stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(":"));

            IOUtils.write(socket, response);

            socket.close();
        }

    }


}