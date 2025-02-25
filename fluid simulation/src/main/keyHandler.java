package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{
    videopanel vp;
    public keyHandler(videopanel vp){
        this.vp = vp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Code = e.getKeyCode();
        if(vp.titleScreen==0){
            if(Code == KeyEvent.VK_ENTER){
                if(vp.UI.hCounter==5){
                    vp.titleScreen=1;
                }
                // }else{
                //     vp.UI.SMcursor = true;
                // }
            }
            else if(Code == KeyEvent.VK_ESCAPE){
                if(vp.UI.hCounter!=5 && vp.UI.SMcursor){
                    vp.UI.SMcursor = false;
                    vp.UI.SMhCounter=0;
                }
            }
            else if(Code == KeyEvent.VK_Q){
                System.out.println(vp.UI.hCounter);
                if(vp.UI.hCounter>0){
                    vp.UI.hCounter--;
                }
                if(vp.UI.SMcursor){
                    if(vp.UI.SMhCounter>0){
                        vp.UI.SMhCounter--;
                    }
                }
            }
            else if(Code == KeyEvent.VK_A){
                System.out.println(vp.UI.hCounter);
                if(vp.UI.hCounter <5){
                    vp.UI.hCounter++;
                }
            }
        }
        else if(vp.titleScreen==1){
            if(Code == KeyEvent.VK_SPACE){
                vp.titleScreen=0;
                vp.UI.pause=true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
