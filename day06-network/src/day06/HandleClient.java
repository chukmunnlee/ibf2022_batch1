package day06;

import java.io.IOException;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.imageio.IIOException;

public class HandleClient implements Runnable {

    private Socket socket;

    public HandleClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        // Random number generator
        Random rnd = new SecureRandom();

        System.out.printf("New connection on port %d\n", socket.getPort());

        try {
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

            // Delay for 2 sec
            Thread.sleep(2000);

            IOUtils.write(socket, response);
        } catch (Exception ex) {
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
            }
        }

    }
    
}
