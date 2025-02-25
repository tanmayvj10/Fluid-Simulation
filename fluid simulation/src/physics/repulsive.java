package physics;

import particles.element;

public class repulsive {
    public float repulsiveConst;
    public float dist;
    public repulsive(){
        repulsiveConst =200f;//200
        dist = 40f;
    }

    public void updateRepulsiveForce(element element1, element element2) {
        float dx = element2.postionX - element1.postionX;
        float dy = element2.postionY - element1.postionY;
        float distanceSquared = dx * dx + dy * dy;
        float distance = (float) Math.sqrt(distanceSquared);
    
        // Minimum distance to trigger repulsion (avoid self-interaction or overlap)
        float minDistance = element1.diameter;
    
        // Check if the particles are within the interaction range
        if (distance < dist && distance > minDistance) {
            // Calculate the magnitude of the repulsive force
            float forceMagnitude = (this.repulsiveConst * element1.mass * element2.mass) / distanceSquared;
    
            // Normalize the direction vector (dx, dy) and scale by the force
            float forceX = forceMagnitude * (dx / distance);
            float forceY = forceMagnitude * (dy / distance);
    
            // Apply forces (equal and opposite)
            element1.speedX -= forceX / element1.mass; // Subtract because force is repelling
            element1.speedY -= forceY / element1.mass;
    
            element2.speedX += forceX / element2.mass; // Add because force is repelling
            element2.speedY += forceY / element2.mass;
        }
    }
}

