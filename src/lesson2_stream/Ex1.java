package lesson2_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class Ex1 {

    public static void main(String[] args) {
        String file = "C:\\jnp\\2019\\n9\\in.txt";
        byte[] data;
        String copyFile = "C:\\jnp\\2019\\n9\\out.txt";
        try (FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(copyFile)) {
            data = new byte[(int) fis.getChannel().size()];
            while (fis.available() > 0) {
                fis.read(data);
            }
            fos.write(data);
            System.out.println(new String(data, "UTF-8"));
        } catch (Exception e) {
            System.out.println("err: " + e.getMessage());
        }
    }
    
}
