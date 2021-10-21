import java.io.*;
import java.net.*;
import java.util.Scanner;

// Cliente manda msg primeiro

public class Servidor  {
    Socket socket = null;
    InputStreamReader in = null;
    OutputStreamWriter out = null;
    BufferedReader buffReader = null;
    BufferedWriter buffWriter = null;
    Scanner scan = new Scanner(System.in);
    String msgCliente;

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        servidor.startServer();
    }

    public void startServer() throws IOException{
        ServerSocket server = new ServerSocket(5555);

        while(true){
            try{
                socket = server.accept();
                System.out.println("Conexao estabelecida!");

                in = new InputStreamReader(socket.getInputStream());
                out = new OutputStreamWriter(socket.getOutputStream());

                buffReader = new BufferedReader(in);
                buffWriter = new BufferedWriter(out);

                // qunado esse while é quebrado o servidor fica a espera de outra chamada
                while(true){
                    // pegando a msg do cliente
                    msgCliente = buffReader.readLine();
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