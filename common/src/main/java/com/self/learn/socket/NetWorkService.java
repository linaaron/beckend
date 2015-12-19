package com.self.learn.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aaronl on 10/11/2015.
 */
public class NetWorkService {
    private static final Logger LOG = LoggerFactory.getLogger(NetWorkService.class);
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetWorkService(int port, int poolSize) throws IOException{
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    public void start() {
        try {
            while (true) {
                LOG.info("NetWorkService star...");
                pool.execute(new HanderRequest(serverSocket.accept()));
            }
        } catch (IOException e) {
            LOG.error("Error: ");
        } finally {
            LOG.info("pool shutdown");
            pool.shutdown();
        }
    }

    /*@Override
    public void run() {
        try {
            while (true) {
                LOG.info("NetWorkService star...");
                pool.execute(new HanderRequest(serverSocket.accept()));
            }
        } catch (IOException e) {
            LOG.error("Error: ");
        } finally {
            pool.shutdown();
        }
    }*/

    class HanderRequest implements Runnable {
        private final Socket socket;

        HanderRequest(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                LOG.info("Begin HanderRequest ....");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {
                    String inStr = in.readLine();
                    LOG.info("Client input is: {}", inStr);
                    out.println("has received... thank you!!!");
                    out.flush();
                    if("bey".equalsIgnoreCase(inStr)) {
                        break;
                    }
                }
                LOG.info("socket close");
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                LOG.error("ERROR : hander");
            }
        }
    }

    public static void main(String[] args) throws IOException {
           NetWorkService netWorkService = new NetWorkService(5678, 1);
           netWorkService.start();
    }
}
