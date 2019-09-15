/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class SClient {
    public static void main(String[] args) {
        OutputStream out;
        try {
            Socket client = new Socket("127.0.0.1", 1107);
            out = client.getOutputStream();
            out.write("hungdn".getBytes());
            out.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
