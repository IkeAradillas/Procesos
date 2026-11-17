package T2.Games;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class DatagramSocketServer {
    DatagramSocket socket;
    InetAddress clientIP;
    SecretNum sn;

    public void init(int port, SecretNum sn) throws SocketException {
        socket = new DatagramSocket(port);
        this.sn = sn;
    }

    public void runServer() throws IOException {
        byte [] receivingData = new byte[1024];
        byte [] sendingData;

        int clientPort;

        //creació del paquet per rebre les dades
        DatagramPacket packet = new DatagramPacket(receivingData, 1024);
        //espera de les dades
        socket.receive(packet);
        //processament de les dades rebudes i obtenció de la resposta
        sendingData = processDataInicial(packet.getData(), packet.getLength());
        //obtenció de l'adreça del client
        clientIP = packet.getAddress();
        //obtenció del port del client
        clientPort = packet.getPort();
        //creació del paquet per enviar la resposta
        packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);
        //enviament de la resposta
        socket.send(packet);

        //el servidor atén el port indefinidament
        while(true){
            //creació del paquet per rebre les dades
            packet = new DatagramPacket(receivingData, 4);
            //espera de les dades
            socket.receive(packet);
            //processament de les dades rebudes i obtenció de la resposta
            sendingData = processData(packet.getData(), packet.getLength());
            //obtenció de l'adreça del client
            clientIP = packet.getAddress();
            //obtenció del port del client
            clientPort = packet.getPort();
            //creació del paquet per enviar la resposta
            packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);
            //enviament de la resposta
            socket.send(packet);
        }
    }

    private byte[] processDataInicial(byte[] data, int lenght){
        String msg = new String(data, 0, lenght);
        msg = msg.toUpperCase();
        System.out.printf("(%s) %s%n",clientIP,msg);

        return msg.getBytes();
    }

    private byte[] processData(byte[] data, int lenght) {
        // Mejorable: Mirar como pasar de byte a int, ademas de comprobar que entre un int y no un string / float / etc

        String msg = new String(data, 0, lenght);
        int num = Integer.parseInt(msg);
        int res = sn.comprova(num);
        if (res == 1) return (num + " es MAYOR que el numero secret").getBytes();
        else if (res == 2) return (num + " es MENOR que el numero secret").getBytes();
        else return "Has endevinat el numero!".getBytes();

    }
}
