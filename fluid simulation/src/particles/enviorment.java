package particles;

import main.videopanel;
public class enviorment {
    videopanel vp;
    public int numberOfElement;
    public int spacingBetweenParticles;
    public final int rightBoundry;
    final int downBoundry;
    final int upBoundry;
    final int leftBoundry;
    public enviorment(videopanel vp){
        this.vp = vp;
        leftBoundry = 0;
        rightBoundry = vp.ScreenWidth;
        upBoundry = 0;
        downBoundry = vp.ScreenHeight;
        numberOfElement=400;//400;
        spacingBetweenParticles=20;//20;
    }
    
}
