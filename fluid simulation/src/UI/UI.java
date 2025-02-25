package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.videopanel;

public class UI {
    videopanel vp;
    public int hCounter=0;
    public int SMhCounter =0;
    public int vCounter=0;
    public boolean pause = false;
    public boolean SMcursor = false;
    public BufferedImage image;
    public UI(videopanel vp){
        this.vp = vp;
    }

    public void draw(Graphics2D g2){
        int x = 200;
        int y = 100;
        g2.setColor(Color.decode("#18181c"));
        g2.fillRect(0, 0, vp.ScreenWidth, vp.ScreenHeight);
        String imagePath = "./FluidSimulator.png";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("./FluidSimulator.png"));
        } catch (IOException e) {
            System.out.println("Error loading image:");
        }
        if (image != null) {
            int newWidth = image.getWidth() * 2;  // Increase width by 2x
            int newHeight = image.getHeight() * 2; // Increase height by 2x
            g2.drawImage(image, 200, 75,newWidth,newHeight, null);
        }
        //title
        int marginTitleX = 125;
        int marginTitleY = 75;
        g2.setColor(Color.decode("#ffffff"));
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,72));
        String text ="FLUID SIMULATION";
        g2.drawString(text, x+marginTitleX, y+marginTitleY);

        int increment = 40;
        //content
        x = 550; 
        y+=150;
        g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,24));
        text = "About How it Works";
        g2.drawString(text, x, y);
        y+=increment;
        text = "Element Configuration";
        g2.drawString(text, x, y);
        y+=increment;
        text = "Environment Configuration";
        g2.drawString(text, x, y);
        y+=increment;
        text = "Future Upgrades";
        g2.drawString(text, x, y);
        y+=increment;
        text = "Credits";
        g2.drawString(text, x, y);


        int helper = y;
        //start
        int startX = x+100;
        int startY= helper+40;
        g2.setFont(g2.getFont().deriveFont(Font.ROMAN_BASELINE,32));
        if(pause){
            text="RESUME";
        }else{
            text = "START"; 
        }
        g2.drawString(text, startX, startY);
        g2.drawRect(startX-40,startY-30,190,40);
        //main menu cursor
        String cursor= "*";
        if(!SMcursor){
            int marginStartX = 30;
            int marginStartY = 0; 
            g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,24));
            y=255;
            x-=20;
            if(hCounter==5){
                //g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,32));
                g2.fillRect(startX-40,startY-30,190,40);
                g2.setColor(Color.BLACK);
                g2.setFont(g2.getFont().deriveFont(Font.ROMAN_BASELINE,32));
                if(pause){
                    text="RESUME";
                }else{
                    text = "START"; 
                }
                g2.drawString(text, startX, startY);
                g2.setColor(Color.WHITE);
                //g2.drawString(cursor, startX-marginStartX, startY-marginStartY);
            }else{
                g2.drawString(cursor, x, y+hCounter*increment);
            }
        }

        //sidemenu
        g2.setColor(Color.decode("#3333cc"));
        int sideM_X = x;
        int sideM_Y = 475;
        int sideM_width = 400;
        int sideM_height = 200;
        g2.fillRect(sideM_X, sideM_Y, sideM_width, sideM_height);
            //border
        g2.setColor(Color.decode("#c9c9ff"));
        g2.drawRect(sideM_X, sideM_Y, sideM_width, sideM_height);
            //side menu content
        g2.setFont(g2.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT,15));
        g2.setColor(Color.WHITE);
        int SMincrement =40;
        x = sideM_X+SMincrement-20;
        y = sideM_Y+SMincrement;
        String SMtext="";
        switch (hCounter) {
            case 0:
                SMtext="Q: Cursor Up";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="A: Cursor Down";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="ENTER: Start/Resume Simulation(Only works at Start)";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                
                SMtext="SPACEBAR: Pause Simulation";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
            case 1:
                SMtext="DIAMETER: 15px";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="ELATICITY: 0.4";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="MASS: 5 units";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="INITIAL SPEED: 0i + 0j";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
            case 2:
                SMtext="NO. OF PARTICLE: 400";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="GRAVITY: 5 units";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="CONTAINER X: 720px";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="CONTAINER Y: 1280px";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
            case 3:
                SMtext="> Adjustable Configurations";
                g2.drawString(SMtext, x, y);
                y+=SMincrement-10;
                SMtext="> Better UI";
                g2.drawString(SMtext, x, y);
                y+=SMincrement-10;
                SMtext="> Increase Particle Count for better Simulation";
                g2.drawString(SMtext, x, y);
                y+=SMincrement-10;
                SMtext="> Variable Container Size";
                g2.drawString(SMtext, x, y);
                y+=SMincrement-10;
                SMtext="> Obsticles and Mouse Interaction";
                g2.drawString(SMtext, x, y);
                y+=SMincrement-10;
                SMtext="> Option to select rigid vs Fluid type";
                g2.drawString(SMtext, x, y);
                y+=SMincrement-10;
                break;
            case 4:
                SMtext="Tanmay Vijay";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="     GitHub: tanmayvj10";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="Tanmay Sharma";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                SMtext="     GitHub: centipede0708";
                g2.drawString(SMtext, x, y);
                y+=SMincrement;
                break;
        }

        //SMcursor
        int sideMmargin_X = 20;
        int sideMmargin_Y = 0;
        if(SMcursor){
            switch (hCounter) {
                case 0:
                    g2.drawString(cursor, x, y+SMhCounter*increment);
                    break;
            }
        }
    }
}
