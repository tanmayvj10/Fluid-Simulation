package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import UI.UI;
import particles.elementManager;
import particles.enviorment;


public class videopanel extends JPanel implements Runnable{
    // Screen Size
    public final int ScreenWidth = 1280;
    public final int ScreenHeight = 720;

    // Environment
    public enviorment env = new enviorment(this);
    // Element Manager
    public elementManager elementManager = new elementManager(this);

    // Collision Physics
    public collision collision = new collision(this,env,elementManager);

    // UI
    public UI UI = new UI(this);

    // Key Handler
    public keyHandler keyH =new keyHandler(this);
    public mouseHandler mouseH = new mouseHandler(this);
    
    // title Screen Settings
        // 0 => title screen
        // 1 => simulation screen
    public int titleScreen =0;

    // Videopanel Constructor
    public videopanel(){
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);

    }
    
    // Set All Parameters (Element Position)
    public void setAllParameter(){
        int y=100;
        int x=100;
        for(int i=0;i<env.numberOfElement;i++){
            if(x<env.rightBoundry-100){
                x+=env.spacingBetweenParticles;
            }else{
                x=100;
                y+=env.spacingBetweenParticles;
            }
            elementManager.Element[i].setParameter(x,y);
        }
        // elementManager.Element[0].setParameter(100,100);
        // elementManager.Element[0].speedX = 5f;
        // elementManager.Element[1].setParameter(200,100);
        // elementManager.Element[1].speedX = -5f;
        // elementManager.Element[2].setParameter(150,200);
        // elementManager.Element[2].speedX = 0f;
        
    }
    
    // Game Thread
    Thread gamThread;
    public void startGameThread(){
        gamThread = new Thread(this);
        gamThread.start();
    }
    
    @Override
    // Run Method
    public void run(){
        double DrawInterval = 1000000000/60;//60 => FPS
        double nextDrawTime = System.nanoTime() + DrawInterval;
        System.out.println("game is running");
        while(gamThread != null){
            update();
            repaint();
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime = nextDrawTime + DrawInterval;
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // Update Method
        // Timing settings
    double currentTime = System.nanoTime();
    double nextTime = currentTime;
    
    @SuppressWarnings("static-access")
    public void update(){
        currentTime = System.nanoTime();
        try{
            gamThread.sleep(32);
            // System.out.println("sleep");  DEBUG
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        if(titleScreen==1){
            for(int i=0;i<env.numberOfElement;i++){
                collision.updateCollistionsAndGravity(i);
                elementManager.Element[i].update(currentTime,nextTime);
            }
        }
        nextTime=System.nanoTime();
    }

    // Paint Component
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        
        if(titleScreen==1){
            for(int i=0;i<env.numberOfElement;i++){
                elementManager.Element[i].draw(g2);
            }
        }else if(titleScreen==0){
            UI.draw(g2);;
        }
    }
}
