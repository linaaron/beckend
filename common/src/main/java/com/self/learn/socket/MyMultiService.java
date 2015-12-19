package com.self.learn.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by aaronl on 10/11/2015.
 */
public class MyMultiService extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(MyMultiService.class);
    private Socket client;

    public MyMultiService(Socket c) {
        this.client = c;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            // Mutil User but can't parallel

            while (true) {
                String str = in.readLine();
                LOG.info("Client: {}", str);
                out.println("has receive....");
                out.flush();
                if (str.equals("end"))
                    break;
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            LOG.error("Error: {}", ex);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        while (true) {
            MyMultiService mc = new MyMultiService(server.accept());
            mc.start();
        }
    }
}
