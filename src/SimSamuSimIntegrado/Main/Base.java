/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimSamuSimIntegrado.Main;

import java.awt.Graphics;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author matheus
 */
public class Base extends DisplayObject{

    @Override
    public void moveTo(DisplayObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public Base(Display display) {
        
        super.setH(80);
        super.setW(80);
        super.setIsAmbDireita(true);
        
        super.setDisplay(display);
        super.setX(50);
        super.setY(150);
        
        try {
            this.setImgR(ImageIO.read(new File("src/Images/samuicon.png")));
            this.setImgL(ImageIO.read(new File("src/Images/samuicon.png")));
        } catch (Exception ex) {
            Logger.getLogger(Ambulancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(this.getImg(), this.getX(), this.getY(), this.getH(), this.getW(), this);
    }
    
}
