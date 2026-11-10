package T2.Sockets;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        DatagramSocketClient dsc = new DatagramSocketClient();
        dsc.init("192.168.23.115", 6767);
        dsc.runClient();
    }

}
