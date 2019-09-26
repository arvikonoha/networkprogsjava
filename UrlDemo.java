import java.net.*;

class UrlDemo{
    public static void main(String args[]) throws Exception{
        URL url = new URL("https://localhost:8080");
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getProtocol());
        System.out.println(url.getFile());
    }
}