/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5_thread;

/**
 *
 * @author mam
 */
public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintNameThread("A")).start();
        new Thread(new PrintNameThread("B")).start();
        new Thread(new PrintNameThread("C")).start();
        
    }
}

class PrintNameThread implements Runnable{
    private String name;
    public PrintNameThread(String name) {
        this.name  = name;
    }

    
    @Override
    public void run() {
        for(int i =0; i<5; i++)
            System.out.print(this.name + " ");
    }
    
}
