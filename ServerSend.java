import java.io.*;
import java.net.*;

class ServerSend{
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();

        OutputStream oo = s.getOutputStream();
        PrintWriter pw = new PrintWriter(oo);

        pw.println("Hello world");

        pw.flush();
        pw.close();

    }
}