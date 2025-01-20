package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


   public void tryserver(){
       try {
           ServerSocket server=new ServerSocket(12345);

           while (true)
           {
               Socket someClient = server.accept();
               ObjectOutputStream output=new ObjectOutputStream(someClient.getOutputStream());
               ObjectInputStream input=new ObjectInputStream(someClient.getInputStream());
               String messageIn=(String)input.readObject();
               System.out.println("message from the client: "+messageIn);
               output.writeObject(messageIn);
               output.flush();
               output.close();
               input.close();
               someClient.close();
           }
       }
       catch (Exception e) {
           System.out.println("tiered of waiting for connection");
       }
   }

}
