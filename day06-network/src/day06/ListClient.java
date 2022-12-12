package day06;

import java.net.Socket;

//import static day06.IOUtils.*;

public class ListClient {

    public static void main(String[] args) throws Exception {

        // Get the list size
        Integer nums = Integer.parseInt(args[0]);

        // Get the number range
        Integer range = Integer.parseInt(args[1]);

        // Get the host
        String host = args[2];

        // Get the port
        Integer port = Integer.parseInt(args[3]);

        // Create the socket to the server
        Socket socket = new Socket(host, port);

        System.out.printf("Connected to %s:%d\n", host, port);

        IOUtils.write(socket, "%d %d".formatted(nums, range));

        String response = IOUtils.read(socket);

        // Process response - calculate the average

        socket.close();
    }
    
}
