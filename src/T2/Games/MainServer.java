package T2.Games;


import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        SecretNum sn = new SecretNum(20);
        DatagramSocketServer dss = new DatagramSocketServer();
        dss.init(6767, sn);
        dss.runServer();
    }
}
