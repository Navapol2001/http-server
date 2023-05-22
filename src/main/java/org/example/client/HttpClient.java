package org.example.client;

import java.io.*;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);  //localhost(loopback address)ip
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        outputStreamWriter.write("GET / HTTP/2.1\r\n");
        outputStreamWriter.newLine();
        outputStreamWriter.flush();
        String line = inputStreamReader.readLine();
        System.out.println(line);
        socket.close();
    }
}
