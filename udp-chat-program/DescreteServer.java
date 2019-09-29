import java.net.*;
import java.util.*;

class DescreteServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(4444);
        DatagramPacket dp;
        Scanner scan = new Scanner(System.in);
        String server = "";
        byte arr[] = new byte[1024];
        while (true) {
            System.out.println("WRITE A MESSAGE TO CLIENT");
            server = scan.next();
            dp = new DatagramPacket(server.getBytes(), server.length(), InetAddress.getLocalHost(), 3333);
            ds.send(dp);
            System.out.println("WAITING FOR CLIENT MESSAGE : ");
            dp = new DatagramPacket(arr, 1024);
            ds.receive(dp);
            server = new String(dp.getData(), 0, dp.getLength());
            if (server.equals("stop")) {
                dp = new DatagramPacket("stop".getBytes(), "stop".length(), InetAddress.getLocalHost(), 3333);
                ds.send(dp);
                break;
            }
            System.out.println("CLIENT SAYS");
            System.out.println(server);
        }
        ds.close();
        scan.close();
    }
}