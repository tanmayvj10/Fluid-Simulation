package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseHandler implements MouseListener {
    videopanel vp;
    public mouseHandler(videopanel vp){
        this.vp = vp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("Mouse Clicked at: " + e.getPoint());
        // if(vp.titleScreen==0){
        //     if(vp.UI.hCounter==5){
        //         vp.titleScreen=1;
        //     }else{
        //         vp.UI.SMcursor = true;
        //     }
        // }
        // else if(vp.titleScreen==1){
        //     vp.titleScreen=0;
        //     vp.UI.pause=true;
        // }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
