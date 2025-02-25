package particles;


import main.videopanel;

public class elementManager {
    videopanel vp;
    public element[] Element;
    public elementManager(videopanel vp){
        this.vp = vp;
        Element = new element[vp.env.numberOfElement];
        createElements();
    }


    public void createElements(){
        for(int i=0;i<vp.env.numberOfElement;i++){
            Element[i] = new element(vp);
        }
    }

}
