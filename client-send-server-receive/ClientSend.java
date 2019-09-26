import java.io.*;
import java.net.*;

class ClientSend{
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("127.0.0.1",4444);

        OutputStream oo = s.getOutputStream();
        PrintWriter pw = new PrintWriter(oo);

        pw.println("Hello world");

        pw.flush();
        pw.close();

    }
}