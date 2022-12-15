package day09;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpClientConnection implements Runnable {

	private final Socket socket;

	public HttpClientConnection(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			System.out.printf(">>> line: %s\n", line);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { socket.close(); } catch (Exception ex) { }
		}
	}
}
