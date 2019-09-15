/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mam
 */
public class SServer {

    public static void main(String[] args) {
        InputStream in;
        byte[] b = new byte[1024];
        try {
            ServerSocket server = new ServerSocket(1107);
            System.out.println("server started ... ");
            while(true){
                Socket conn = server.accept();
                System.out.format("new connection connected. {%s,remote port: %d, localport: %d}\n",
                        conn.getInetAddress().getHostName(), conn.getPort(), conn.getLocalPort());
                in = conn.getInputStream();
                in.read(b);
                
                System.out.println(new String(b).toUpperCase().trim());
                in.close();
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("ERR. " + ex.getMessage());
        }
    }
}
