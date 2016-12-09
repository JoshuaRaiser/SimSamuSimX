package SimSamuSimIntegrado.Main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Display extends JPanel implements Runnable {

    private Ambulância ambu;
    private Paciênte pac;
    private Hospital hosp;
    private Base base;
    Thread t;
    
    public Display() {
        
        inicia();
        
        base = new Base(this);
        ambu = new Ambulância(this,base);
        pac  = new Paciênte(this);
        hosp = new Hospital(this);
        
        this.add(ambu);
        this.add(pac);
        this.add(hosp);
        this.add(base);
    }

    private void inicia() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        
        super.paint(g); //To change body of generated methods, choose Tools | Templates.   
        
        pac.paintComponent(g);
        ambu.paintComponent(g);
        hosp.paintComponent(g);
        base.paintComponent(g);
        
        this.inicia();
    }   

    public Hospital getHosp() {
        return hosp;
    }

    public void setHosp(Hospital hosp) {
        this.hosp = hosp;
    }

    @Override
    public void run() {
       
            repaint();
            
    }

    public Ambulância getAmbu() {
        return ambu;
    }

    public void setAmbu(Ambulância ambu) {
        this.ambu = ambu;
    }

    public Paciênte getPac() {
        return pac;
    }

    public void setPac(Paciênte pac) {
        this.pac = pac;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
    
    public void reset()
    {
        ambu = new Ambulância(this,this.getBase());
        pac = new Paciênte(this);
        repaint();
    }
    
    public void pintaNice()
    {
        repaint();
    }
}
