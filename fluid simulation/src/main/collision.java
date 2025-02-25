package main;

import particles.element;
import particles.elementManager;
import particles.enviorment;
import physics.gravity;
import physics.repulsive;

public class collision {
    videopanel vp ;
    enviorment env ;
    elementManager elementManager ;
    gravity gravity = new gravity();
    repulsive repulsive = new repulsive();
    public collision(videopanel vp,enviorment env,elementManager ekElementManager){
        this.vp = vp;
        this.env = env;
        this.elementManager = ekElementManager;
    }

    public int  counter = 0;
    public void collistionBetweenTwoElements(element element1,element element2){
        if (element1.circle.intersects(element2.circle.getBounds2D())) {

            double dx = element2.circle.getX() - element1.circle.getX();
            double dy = element2.circle.getY() - element1.circle.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
    
            if (distance == 0) {
                return;
            }
    
            double nx = dx / distance;
            double ny = dy / distance;
    
            double relativeVelX = element2.speedX - element1.speedX;
            double relativeVelY = element2.speedY - element1.speedY;
            double relativeVelocity = relativeVelX * nx + relativeVelY * ny;
    
            if (relativeVelocity > 0) {
                return;
            }
    
            // restitution
            double restitution = element1.elasticity;
            
            double mass1 = element1.mass > 0 ? element1.mass : 1.0;
            double mass2 = element2.mass > 0 ? element2.mass : 1.0;

            double impulse = -(1 + restitution) * relativeVelocity / (1 / mass1 + 1 / mass2);
    
            
            double impulseX = impulse * nx;
            double impulseY = impulse * ny;
    
            element1.speedX -= impulseX / mass1;
            element1.speedY -= impulseY / mass1;
    
            element2.speedX += impulseX / mass2;
            element2.speedY += impulseY / mass2;
    
            
            counter++;
            System.out.println(counter);
            // System.out.println("Collision detected with impulse: " + impulse);
        }
    }
    
    public void updateCollistionsAndGravity(int i){
        for(int j=i;j<env.numberOfElement;j++){
            if(i!=j){
                
                collistionBetweenTwoElements(elementManager.Element[i], elementManager.Element[j]);
                repulsive.updateRepulsiveForce(elementManager.Element[i], elementManager.Element[j]);
                gravity.updategravity(elementManager.Element[i], elementManager.Element[j]);
                
            }        
        }
    }
}
