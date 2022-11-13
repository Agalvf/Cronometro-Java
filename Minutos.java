/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Minutos extends Thread {

    public Horas horas;
    private int contador;

    public Minutos(Horas horas) {
        this.horas = horas;
        this.contador = 0;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.wait();
                    contador++;
                    if (contador == 60) {
                        contador = 0;
                        synchronized (horas) {
                            horas.notify();
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Horas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public int getContador() {
        return contador;
    }
}
