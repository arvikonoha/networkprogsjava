import java.net.*;
import java.util.*;
import java.io.*;

class ServerReceive{
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        Scanner scan = new Scanner(is);
        System.out.println(scan.next());
        scan.close();
    }
}