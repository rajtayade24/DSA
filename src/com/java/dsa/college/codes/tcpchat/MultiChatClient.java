//package com.java.dsa.college.codes.tcpchat;
//import java.io.IOException;
//import java.net.Socket;
//
//public class MultiChatClient {
//
//    public static void main(String[] args) throws IOException {
//
//        if (args.length != 2) {
//            System.out.println(
//                "Usage: java MultiChatClient <server-IP> <port>");
//            return;
//        }
//
//        String serverIP = args[0];
//        int port = Integer.parseInt(args[1]);
//
//        Socket socket = new Socket(serverIP, port);
//
//        System.out.print("Enter your username: ");
//
//        java.io.BufferedReader keyboard =
//            new java.io.BufferedReader(
//                new java.io.InputStreamReader(System.in));
//
//        String userName = keyboard.readLine();
//
//        PeerChat.chat(socket, userName);
//    }
//}
