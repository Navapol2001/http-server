package org.example.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();  //localhost(loopback address)ip
        socket.connect(new InetSocketAddress("192.168.31.197", 8080));
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        outputStreamWriter.write("GET http://localhost:8080 HOHO");
        outputStreamWriter.newLine();
//        outputStreamWriter.write("Host: localhost\r\n");
//        outputStreamWriter.newLine();
        outputStreamWriter.flush();
        String line = inputStreamReader.readLine();
        System.out.println(line);
        socket.close();
    }
}
