
import java.io.*;
import java.net.*;
import java.util.Scanner;

class CuntinuousClient {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("127.0.0.1", 5555);
        DataOutputStream pw = new DataOutputStream(s.getOutputStream());
        DataInputStream scan = new DataInputStream(s.getInputStream());
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter client message : ");
        String serverMsg = input.readLine();
        pw.writeUTF(serverMsg);
        do {
            System.out.println("WAITING FOR SERVER MESSAGE");
            serverMsg = scan.readUTF();
            if (serverMsg.equals("stop")) {
                pw.writeUTF("stop");
                break;
            }
            System.out.println("Server says : " + serverMsg);
            System.out.println("Enter client message : ");
            pw.flush();
            serverMsg = input.readLine();
            pw.writeUTF(serverMsg);
        } while (true);
        scan.close();
        input.close();
        pw.flush();
        pw.close();
        s.close();
    }
}