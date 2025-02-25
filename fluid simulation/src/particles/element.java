package particles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import main.videopanel;

public class element {
    videopanel vp;
    public float diameter;
    public float outerdiameter;
    float dt = 1f;
    public float mass = 5f; 
    public float speedX = 0f;
    public float speedY = 0f;
    public float postionX;
    public float postionY; 
    public float elasticity = 0.4f;
    public boolean collision=false;
    public Ellipse2D.Float circle;
    public Ellipse2D.Float outerCircle;
    

    public element(videopanel vp){
            outerdiameter = 150f;
            diameter = 15f;//15
            this.vp = vp;
            postionX = vp.ScreenWidth/2;
            postionY = 120f;
            circle  = new Ellipse2D.Float(postionX-diameter/2, postionY-diameter/2, diameter, diameter);
            outerCircle = new Ellipse2D.Float(postionX-diameter/2, postionY-diameter/2, outerdiameter, outerdiameter);
    }

    public void setParameter(int x,int y){
        this.postionX = x;
        this.postionY = y;
    }

    public void update(double currentTime,double nextTime){
        if(vp.titleScreen==1){

            //boundry collistions
            if (postionY + diameter / 2 >= vp.ScreenHeight) {
                postionY = vp.ScreenHeight - diameter / 2;
                speedY *= -elasticity;
            }else if (postionY - diameter / 2 <= 0) {
                postionY = diameter / 2;
                speedY *= -elasticity;
            }
            if (postionX + diameter / 2 >= vp.ScreenWidth) {
                postionX = vp.ScreenWidth - diameter / 2;
                speedX *= -elasticity;
            }else if (postionX - diameter / 2 <= 0) {
                postionX = diameter / 2;
                speedX *= -elasticity;
            }
        

            //gravity 
            speedY += 0.3f;//0.1
        

            //speed
            postionY +=speedY*dt;
            postionX +=speedX*dt;
        }
    }
    public void draw(Graphics2D g2){
        double s = Math.sqrt(speedX*speedX + speedY*speedY);
        Color customcolor= getColorBySpeed(s);
        //g2.setColor(customcolor);
        g2.setColor(new Color(0,0,255));
        
        // float relativeDiameter; 
        // relativeDiameter = postionY*outerdiameter/vp.ScreenHeight;
        // if (relativeDiameter<diameter){
        //     relativeDiameter = diameter;
        // }
        
        this.circle  = new Ellipse2D.Float(this.postionX-diameter/2, this.postionY-diameter/2, diameter, diameter);
        this.outerCircle = new Ellipse2D.Float(postionX-outerdiameter/2, postionY-outerdiameter/2, outerdiameter, outerdiameter);
        //this.outerCircle = new Ellipse2D.Float(postionX-relativeDiameter/2, postionY-relativeDiameter/2, relativeDiameter, relativeDiameter);
        //g2.fill(circle);
        g2.fill(outerCircle);

    }

    public static Color getColorBySpeed(double speed) {
        // Avoid negative or zero speed by clamping to a minimum threshold
        double effectiveSpeed = Math.max(speed, 1);

        // Normalize speed using a logarithmic scale
        double normalizedSpeed = Math.log(effectiveSpeed) / Math.log(100); // Base 100 log for scaling
        normalizedSpeed = Math.min(Math.max(normalizedSpeed, 0.0), 1.0); // Clamp between 0 and 1

        // Transition from blue to red through green
        int red = (int) (normalizedSpeed * 255);
        int green = (int) ((1 - Math.abs(normalizedSpeed - 0.5) * 2) * 255);
        int blue = (int) ((1 - normalizedSpeed) * 255);

        return new Color(red, green,blue);
    }

}
