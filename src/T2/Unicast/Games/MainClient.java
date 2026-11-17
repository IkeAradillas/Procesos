package T2.Unicast.Games;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        DatagramSocketClient dsc = new DatagramSocketClient();
        dsc.init("127.0.0.1", 6767);
        dsc.runClient();
    }

}
