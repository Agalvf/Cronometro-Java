/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class Segundos extends Thread {

    private final Minutos minuto;
    private int contador;

    public Segundos(Minutos minuto) {
        this.minuto = minuto;
        this.contador = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Segundos.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            contador++;
            if (contador == 60) {
                this.contador = 0;
                synchronized (minuto) {
                    try {
                        minuto.notify();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }
            }
        }
    }

    public int getContador() {
        return contador;
    }
}
