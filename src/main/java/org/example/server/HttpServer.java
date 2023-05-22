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
                    BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String line = inputStreamReader.readLine();
                    String method = line.split(" ")[0];
                    String resourceUrl = line.split(" ")[1];
                    System.out.println("method: " + method);
                    System.out.println("resourceUrl: " + resourceUrl);
                    //response back to client


                    //servlet side
                    outputStreamWriter.write("HTTP/1.1 200");
                    outputStreamWriter.newLine();
                    outputStreamWriter.newLine();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputStreamWriter.write("<html><body><h1>Hello World</h1></body></html>");
                    //outputStreamWriter.write(line + " : " + LocalDate.now() );
                    outputStreamWriter.flush();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
