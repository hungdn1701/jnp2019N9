/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class UDPClient {
    DatagramSocket client;
    DatagramPacket sendPacket, receivePacket;
    byte[] sendBuff, receiveBuff;

    public UDPClient() {
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String _str){
        try {
            sendBuff = _str.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            sendPacket = new DatagramPacket(sendBuff, sendBuff.length
                    , address, 1107);
            client.send(sendPacket);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void reiceve() {

        try {
            receiveBuff = new byte[1024];
            receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);
            client.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()).trim());
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }

                
    }
}
