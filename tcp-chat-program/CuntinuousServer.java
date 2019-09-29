import java.io.*;
import java.net.*;

class CuntinuousServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        DataOutputStream pw = new DataOutputStream(s.getOutputStream());
        DataInputStream scan = new DataInputStream(s.getInputStream());
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("WAITING FOR CLIENT MESSAGE");
            String clientMsg = scan.readUTF();
            System.out.println("Client says : " + clientMsg);
            if (clientMsg.equals("stop")) {
                pw.writeUTF("stop");
                break;
            }
            System.out.println("Enter server message : ");
            pw.flush();
            clientMsg = input.readLine();
            pw.writeUTF(clientMsg);
        } while (true);
        scan.close();
        input.close();
        pw.flush();
        pw.close();
        ss.close();
    }
}