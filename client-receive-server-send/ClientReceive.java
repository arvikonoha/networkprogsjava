import java.io.InputStream;
import java.net.*;
import java.util.*;

class ClientReceive {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("127.0.0.1", 3333);
        InputStream is = s.getInputStream();
        Scanner scan = new Scanner(is);
        System.out.println(scan.nextLine());
        scan.close();
        s.close();
    }
}