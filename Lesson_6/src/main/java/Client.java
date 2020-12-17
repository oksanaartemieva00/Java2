import org.graalvm.compiler.hotspot.SymbolicSnippetEncoder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        new Client().start("localhost",8189);
    }
    public void start(String host, int port) throws IOException{
        Socket socket=null;
        Thread inputThread=null;
        try{
            socket=new Socket(host, port);
            System.out.println("Client starts");
            DataInputStream in=new DataInputStream(socket.getInputStream());
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            inputThread=runInputThread(in);
            runOutputLoop(out);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(inputThread!=null) inputThread.interrupt();
            if(socket!=null) socket.close();
        }
    }
    private void runOutputLoop (DataOutputStream out) throws IOException{
        Scanner scanner=new Scanner(System.in);
        while(true){
            String msg=scanner.next();
            out.writeUTF(msg);
            if(msg.equals("/end")){
                break;
            }
        }
    }
    private Thread runInputThread (DataInputStream in){
        Thread thread=new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
            try{
                String msg=in.readUTF();
                System.out.println("С сервера "+msg);
                if(msg.equals("/end")){
                    System.exit(0);
                }
            }catch(IOException e){
                System.out.println("Связь приостановлена");
                break;
            }
            }
        });
thread.start();
return thread;
    }
}
