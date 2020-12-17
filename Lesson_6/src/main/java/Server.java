import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int DEFAULT_PORT=8189;

    public static void main(String[] args) throws IOException {
        int port=DEFAULT_PORT;
        if (args.length != 0) {
            port=Integer.parseInt(args[0]);
        }
        new Server().start(port);
    }
    public void start(int port) throws IOException{
        ServerSocket socket=null;
        Socket clientSocket=null;
        Thread inputThread=null;
        try{
            socket=new ServerSocket(port);
            System.out.println("Server starts");
            clientSocket=socket.accept();
            System.out.println("Client works");
            DataInputStream in=new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
            inputThread=runInputThread(in);
            runOutputLoop(out);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(inputThread!=null) inputThread.interrupt();
            if(clientSocket!=null) clientSocket.close();
            if(socket!=null)socket.close();
        }
    }
    private void runOutputLoop(DataOutputStream out) throws IOException{
        Scanner scanner=new Scanner(System.in);
        while(true){
            String msg=scanner.next();
            out.writeUTF(msg);
            if(msg.equals("/end")){
                break;
            }
        }
    }
    private Thread runInputThread(DataInputStream in){
        Thread thread=new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                try{
                    String msg=in.readUTF();
                    System.out.println("С клиента "+msg);
                    if(msg.equals("/end")){
                        System.exit(0);
                    }
                }catch(IOException e){
                    System.out.println("Связь приостоновлена");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }
}
