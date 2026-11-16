package T2.Games;


import javax.xml.crypto.Data;
import java.net.DatagramSocket;

public class MainServer {
    SecretNum s = new SecretNum();
    DatagramSocketServer dss = new DatagramSocketServer();
    dss.init(6767);
    dss.runServer();
}
