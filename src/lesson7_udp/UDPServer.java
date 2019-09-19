/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class UDPServer {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    int port;
    byte[] receiveBuff, sendBuff;
    int buffSize;

    public UDPServer() {
        port = 1107;
        buffSize = 1024;
        try {
            server = new DatagramSocket(port);
            System.out.println("server started ...");
            
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listening(){
        while(true){
            try {
                receiveBuff = new byte[1024];
                receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);
                server.receive(receivePacket); // nhận gói tin
                String _strTemp = new String(receivePacket.getData()).trim();
                System.out.println(_strTemp);
                String _strRes = StrUtil.reverse(_strTemp);
                sendBuff = _strRes.getBytes();
                sendPacket = new DatagramPacket(sendBuff, sendBuff.length
                        , receivePacket.getSocketAddress());
                server.send(sendPacket);
                
                
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
