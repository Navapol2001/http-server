package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class HttpServer {
    public void start() throws IOException {
        System.out.println("HttpServer start");
            // A(socker:22) -----> B(socker:80)
        ServerSocket serverSocket = new ServerSocket(8080);
        //multi thread
        while(true) {
            Socket socket = serverSocket.accept();  // ----> for build thread from each socket clients
            //server side
            new Thread (() -> {
                try {
                    System.out.println("aacepted 1 client");
                    BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter outputStreamWriter1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String line = inputStreamReader.readLine();
                    String method = line.split(" ")[0];
                    String resourceUrl = line.split(" ")[1];
                    String word = line.split(" ")[2];
                    System.out.println("method: " + method);
                    System.out.println("resourceUrl: " + resourceUrl);
                    System.out.println("wirding: " + word);
                    //response back to client


                    //servlet side
                    outputStreamWriter1.write("HTTP/1.1 400");
                    outputStreamWriter1.newLine();
                    outputStreamWriter1.newLine();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputStreamWriter1.write("<html><body><h1>Hell Yeah</h1></body></html>");
                    //outputStreamWriter.write(line + " : " + LocalDate.now() );
                    outputStreamWriter1.flush();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
