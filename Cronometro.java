/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class Cronometro {
    public static void main(String[] args) {
        Horas hora = new Horas();
        Minutos minuto = new Minutos(hora);
        Segundos segundo = new Segundos(minuto);

        hora.start();
        minuto.start();
        segundo.start();
        
        JFrame ventana = new JFrame("Reloj");
        ventana.setSize(300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.setVisible(true);

        JLabel labelHora = new JLabel();
        labelHora.setBounds(10, 10, 100, 30);
        labelHora.setText(hora.getContador()+ ":" + minuto.getContador()+ ":" + segundo.getContador());
        ventana.add(labelHora);

        JButton boton = new JButton("Boton");
        boton.setBounds(10, 50, 100, 30);
        ventana.add(boton);
              
        while(true){
            labelHora.setText(hora.getContador()+ ":" + minuto.getContador()+ ":" + segundo.getContador());
        }
    }
}
