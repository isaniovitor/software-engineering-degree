import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader in = null;
        OutputStreamWriter out = null;
        BufferedReader buffReader = null;
        BufferedWriter buffWriter = null;

        ServerSocket server = new ServerSocket(5555);

        while(true){
            try{
                socket = server.accept();

                in = new InputStreamReader(socket.getInputStream());
                out = new OutputStreamWriter(socket.getOutputStream());

                buffReader = new BufferedReader(in);
                buffWriter = new BufferedWriter(out);

                Scanner scan = new Scanner(System.in);

                // qunado esse while é quebrado o servidor fica a espera de outra chamada
                while(true){
                    // pegando a msg do cliente
                    String msgCliente = buffReader.readLine();
                    System.out.println("client: " + msgCliente);

                    // pegando resposta do servidor
                    String msgServer = scan.nextLine();

                    // mandando msg pro clinete
                    buffWriter.write(msgServer);
                    buffWriter.newLine();
                    buffWriter.flush();

                    if(msgCliente.equalsIgnoreCase(".bye")) break;
                }

                socket.close();
                in.close();
                out.close();
                buffReader.close();
                buffWriter.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

   
    }


    
}