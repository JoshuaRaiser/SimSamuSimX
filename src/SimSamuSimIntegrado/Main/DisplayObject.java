package SimSamuSimIntegrado.Main;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

abstract class DisplayObject extends JComponent{

    boolean exists = true;
    
    public void setImgR(Image aImgR) {
        imgR = aImgR;
    }

    public void setImgL(Image aImgL) {
        imgL = aImgL;
    }

    private Display display;
    
    private Image imgR;
    private Image imgL;
    
    int x,y;
    int h,w;
    static boolean isAmbDireita;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public boolean isIsAmbDireita() {
        return isAmbDireita;
    }

    public void setIsAmbDireita(boolean isAmbDireita) {
        this.isAmbDireita = isAmbDireita;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Image getImg() {
        if (isAmbDireita)
        {
            return imgR;
        }else{
            return imgL;
        }
        
    }
    
    public void kill()
    {
        this.exists = false;
    };
    
    abstract public void moveTo(DisplayObject obj);

}
