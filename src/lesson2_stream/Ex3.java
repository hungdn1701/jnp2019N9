/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author mam
 */
public class Ex3 {
    public static void main(String[] args) {
        String file = "C:\\jnp\\2019\\n9\\ex3.bin";
        Product p;
        try (FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos)) {
            p = (Product) oos.readObject();
            System.out.println(p);
        } catch (Exception e) {
            System.out.println("err " + e.getMessage());
        }
    }
}

class Product implements Serializable{
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.name, this.price, this.quantity); //To change body of generated methods, choose Tools | Templates.
    }
    
}
