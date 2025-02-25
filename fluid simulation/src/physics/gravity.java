package physics;

import particles.element;

public class gravity {
    public float gravityConst;
    public float repulsiveDist;

    public gravity(){
        gravityConst = 5f;//5
        repulsiveDist = 60f; //60
    }

    public void updategravity(element element1,element element2){
        float distx = element1.postionX - element2.postionX;
        float disty = element1.postionY - element2.postionY;
        
        if(distx>repulsiveDist){
            element1.speedX += -1*(this.gravityConst * element1.mass)/(distx*distx);
            element2.speedX += 1*(this.gravityConst * element1.mass)/(distx*distx);
        }else if (distx<-repulsiveDist){
            element1.speedX += 1*(this.gravityConst * element1.mass)/(distx*distx);
            element2.speedX += -1*(this.gravityConst * element1.mass)/(distx*distx);
        }
        
        if(disty>repulsiveDist){
            element1.speedY += -1*(this.gravityConst*element1.mass)/(disty*disty);
            element2.speedY += 1*(this.gravityConst*element1.mass)/(disty*disty);
        }else if(disty<-repulsiveDist){
            element1.speedY += 1*(this.gravityConst*element1.mass)/(disty*disty);
            element2.speedY += -1*(this.gravityConst*element1.mass)/(disty*disty);
            
        }
    }
}
