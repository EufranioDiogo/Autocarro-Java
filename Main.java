/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autocarro;
import javax.swing.JFrame;

/**
 *
 * @author ed
 */
public class Main extends JFrame {
    public Main() {
        setSize(500, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Autocarro());
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
