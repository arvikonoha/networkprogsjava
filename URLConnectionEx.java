import java.io.*;
import java.net.*;
import java.net.URLConnection;
import java.util.Scanner;

class URLConnectionEx{
    public static void main(String args[]) throws Exception{
        URL url = new URL("http://google.com");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        Scanner scan = new Scanner(is);
        while(scan.hasNext())
            System.out.println(scan.next());
        scan.close();
    }
}