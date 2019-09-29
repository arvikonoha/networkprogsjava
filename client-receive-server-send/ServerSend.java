import java.io.*;
import java.net.*;

class ServerSend {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();

        PrintWriter pw = new PrintWriter(s.getOutputStream());

        pw.println("Hello world");

        pw.flush();
        pw.close();

        ss.close();
    }
}