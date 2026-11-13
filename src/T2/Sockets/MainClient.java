package T2.Sockets;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        DatagramSocketClient dsc = new DatagramSocketClient();
        dsc.init("localhost", 6767);
        dsc.runClient();
    }

}
