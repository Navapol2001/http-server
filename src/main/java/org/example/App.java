package org.example;


import org.example.server.HttpServer;

import java.io.IOException;

public class App
{
    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer();
        try {
            server.start();
            System.out.println("WebSocket server started on port 8080");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main( String[] args )
//    {
//        System.out.println("Start" + Thread.currentThread().getName());
//        new Thread(() -> doLong()).start();
//        new Thread(() -> doLong()).start();
//        new Thread(() -> doLong()).start();
//        System.out.println(Thread.currentThread().getName());
//        System.out.println("End" + Thread.currentThread().getName());
//    }
//
//    private static void doLong() {
//        for(int i = 0; i < 10; i++) {
//            System.out.println("doLong" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
