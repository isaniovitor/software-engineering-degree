import java.io.*;
import java.net.*;
import java.util.Scanner;

// Cliente manda msg primeiro

public class Cliente {
    Socket socket = null;
    InputStreamReader in = null;
    OutputStreamWriter out = null;
    BufferedReader buffReader = null;
    BufferedWriter buffWriter = null;
    Scanner scan = new Scanner(System.in);
    String msg;

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.startClient();
    }

    public void startClient(){
       

       try{
           socket = new Socket("localhost", 5555);
           System.out.println("Conexao estabelecida!");

           in = new InputStreamReader(socket.getInputStream());
           out = new OutputStreamWriter(socket.getOutputStream());

           buffReader = new BufferedReader(in);
           buffWriter = new BufferedWriter(out);

           while(true){
               msg = scan.nextLine();

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
