package T2.Sockets;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        DatagramSocketServer dss = new DatagramSocketServer();
        dss.init(6767);
        dss.runServer();
    }
}
