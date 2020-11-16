package com.mycompany.autocarro;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

public class Autocarro extends JPanel implements Runnable{
    Thread thread;
    int movimentX = 0;
    int insideObjectMovement = 0;
    float angle = 0;
    boolean flagInsideObjectMovement = true;
    AffineTransform at;
    
    
    public Autocarro() {
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        at = new AffineTransform();
        
        at.translate(movimentX, 0);
        g2.setTransform(at);
        g2.setColor(Color.ORANGE);
        
        g2.fillRect(100, 45, 165, 75);
        g2.fillRect(100, 120, 200, 75);
        
        g2.setColor(Color.WHITE);
        g2.fillRect(120, 65, 45, 45);
        g2.fillRect(200, 65, 45, 45);
        
        g2.setColor(Color.red);
        g2.fillOval(130 + insideObjectMovement, 75, 20, 20);
        
        g2.setColor(Color.BLUE);
        g2.fillOval(220, 75 + insideObjectMovement, 20, 20);
        
        
        g2.setColor(Color.BLACK);
        float dash1[] = {10.0f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        g2.setStroke(dashed);
    
        at = new AffineTransform();
        
        g2.fillOval(140, 185, 20, 20);
        at.translate(movimentX, 0);
        at.rotate(Math.toRadians(angle), 150, 195);
        g2.setTransform(at);
        g2.drawOval(120, 165, 60, 60);
        
        
        
        at = new AffineTransform();
        
        
        
        
        at.translate(movimentX, 0);
        at.rotate(Math.toRadians(angle), 230, 195);
        g2.setTransform(at);
        g2.drawOval(200, 165, 60, 60);
        
        at = new AffineTransform();
        
        at.translate(movimentX, 0);
        at.rotate(Math.toRadians(angle), 230, 195);
        g2.setTransform(at);
        g2.fillOval(220, 185, 20, 20);
        
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.movimentX += 1;
                
                if (this.movimentX > getSize().width) {
                    this.movimentX = -200;
                }
                
                if (flagInsideObjectMovement) {
                    this.insideObjectMovement = this.insideObjectMovement + 1;
                    if (this.insideObjectMovement > 10) {
                        this.flagInsideObjectMovement = false;
                    }
                } else {
                    this.insideObjectMovement = this.insideObjectMovement - 1;
                    if (this.insideObjectMovement < 0) {
                        this.flagInsideObjectMovement = true;
                    }
                }
                angle += 1;
                super.repaint();
                thread.sleep(20);
            }
        } catch (Exception e) {
            System.err.println("S");
        }
    }
}
