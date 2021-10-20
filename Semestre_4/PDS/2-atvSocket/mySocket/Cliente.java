import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
       Socket socket = null;
       InputStreamReader in = null;
       OutputStreamWriter out = null;
       BufferedReader buffReader = null;
       BufferedWriter buffWriter = null;

       try{
           socket = new Socket("localhost", 5555);

           in = new InputStreamReader(socket.getInputStream());
           out = new OutputStreamWriter(socket.getOutputStream());

           buffReader = new BufferedReader(in);
           buffWriter = new BufferedWriter(out);

           Scanner scan = new Scanner(System.in);

           while(true){
               String msg = scan.nextLine();

               // mandando msg pro server
               buffWriter.write(msg);
               buffWriter.newLine();
               buffWriter.flush();

               // esperando resp
               System.out.println("server:" + buffReader.readLine());

               if(msg.equalsIgnoreCase(".bye")) break;
           }
        
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
