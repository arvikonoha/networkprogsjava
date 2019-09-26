import java.net.*;

class IPAddress{
    public static void main(String args[]) throws Exception{
        InetAddress ip = InetAddress.getByName("www.google.com");
        System.out.println(ip.getHostAddress());
    }
}