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
 * @author 5686563
 */
public class Paciênte extends DisplayObject{

    public Paciênte(Display display) {
        
        super.setH(40);
        super.setW(40);
        super.setIsAmbDireita(true);
        
        super.setDisplay(display);
        super.setX(300);
        super.setY(60);
        
        try {
            this.setImgR(ImageIO.read(new File("src/SimSamuSimIntegrado/Images/paciente.jpg")));
            this.setImgL(ImageIO.read(new File("src/SimSamuSimIntegrado/Images/paciente.jpg")));
        } catch (Exception ex) {
            Logger.getLogger(Ambulância.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void moveTo(DisplayObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if(exists)
        g.drawImage(this.getImg(), this.getX(), this.getY(), this.getH(), this.getW(), this);
    }
    
}
