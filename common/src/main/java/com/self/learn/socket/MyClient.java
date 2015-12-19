package com.self.learn.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by aaronl on 10/11/2015.
 */
public class MyClient {
    private static final Logger LOG = LoggerFactory.getLogger(MyClient.class);
    private static Socket server;

    public static void main(String[] args) throws Exception {
        server = new Socket(InetAddress.getLocalHost(), 5678);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream());

        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = wt.readLine();
            out.println(str);
            out.flush();
            if (str.equals("end")) {
                break;
            }
            LOG.info("Client: {}", str);
            LOG.info("Server: {}", in.readLine());
        }
        out.close();
        in.close();
        server.close();
    }
}
