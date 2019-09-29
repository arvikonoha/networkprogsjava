import java.net.*;
import java.util.*;

class DescreteClient {
    public static void main(String args[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(3333);
        Scanner scan = new Scanner(System.in);
        byte arr[] = new byte[1024];
        DatagramPacket dp;
        String msg = "";
        while (true) {
            System.out.println("WAITING FOR SERVER MESSAGE : ");
            dp = new DatagramPacket(arr, 1024);
            ds.receive(dp);
            msg = new String(dp.getData(), 0, dp.getLength());
            if (msg.equals("stop")) {
                dp = new DatagramPacket("stop".getBytes(), "stop".length(), InetAddress.getLocalHost(), 4444);
                ds.send(dp);
                break;
            }
            System.out.println("SERVER SAYS");
            System.out.println(msg);
            System.out.println("WRITE A MESSAGE TO SERVER");
            msg = scan.next();
            dp = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 4444);
            ds.send(dp);
        }
        scan.close();
        ds.close();
    }
}