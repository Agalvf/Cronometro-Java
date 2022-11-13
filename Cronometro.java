/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class Cronometro {

    private static int corredor = 0;
    
    public static void main(String[] args) {
        int filas = 10000;
        Horas hora = new Horas();
        Minutos minuto = new Minutos(hora);
        Segundos segundo = new Segundos(minuto);
        
        JFrame ventana = new JFrame("Cronometro");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.setVisible(true);

        JLabel label = new JLabel("00:00:00");
        label.setBounds(150, 150, 100, 100);
        ventana.add(label);

        JButton boton = new JButton("Iniciar");
        boton.setBounds(150, 250, 100, 50);
        ventana.add(boton);

        JButton agregar = new JButton("Agregar");
        agregar.setBounds(150, 300, 100, 50);
        ventana.add(agregar);

        int tiempoCorredores [][] = new int[filas][3];
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hora.start();
                minuto.start();
                segundo.start();
            }
        });

        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoCorredores[corredor][0] = hora.getContador();
                tiempoCorredores[corredor][1] = minuto.getContador();
                tiempoCorredores[corredor][2] = segundo.getContador();
                corredor++;
                for(int i = 0; i < corredor; i++){
                    for (int j = 0; j < 3; j++) {
                        System.out.println("Corredor: "  + i +  " Tiempo: " + tiempoCorredores[i][j]);
                    }
                    System.out.println("\n");
                }
            }
        });

   
        while (true) {
            label.setText(hora.getContador() + ":" + minuto.getContador() + ":" + segundo.getContador());
        }
    }
}
