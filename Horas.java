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
public class Horas extends Thread {

    private int contador;

    public void run() {
        while (true) {
            synchronized (this) {  
                try {
                    this.wait();
                    contador++;
                } catch (Exception e) {
                }
            }
        }
    }
    public int getContador() {
        return contador;
    }
}
