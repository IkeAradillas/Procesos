package T2.TCP.Ejemplo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPSocketServer {
    static final int PORT = 9090;
    private boolean end = false;

    public void listen(){
        ServerSocket serverSocket;
        Socket clientSocket;
        try {
            serverSocket = new ServerSocket(PORT);
            while(!end){
                clientSocket = serverSocket.accept();
                System.out.println("Connexió amb: " + clientSocket.getInetAddress());
                TCPThreadServer th = new TCPThreadServer(clientSocket);
                th.start();
            }
            //tanquem el sòcol principal
            if(!serverSocket.isClosed()){
                serverSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void main(String[] args) {
        TCPSocketServer tcpSocketServer = new TCPSocketServer();
        tcpSocketServer.listen();
    }
}
