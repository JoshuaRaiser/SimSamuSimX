package SimSamuSimIntegrado.Main;

import java.awt.Graphics;
import java.io.File;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Ambulancia extends DisplayObject {

    Display pai;

    public Ambulancia(Display display, Base base) {
        super.setH(80);
        super.setW(80);
        super.setIsAmbDireita(true);

        super.setDisplay(display);
        super.setX(base.getX());
        super.setY(base.getY());
        pai = display;

        try {
            this.setImgR(ImageIO.read(new File("src/SimSamuSimIntegrado/Images/ambuR.png")));
            this.setImgL(ImageIO.read(new File("src/SimSamuSimIntegrado/Images/ambuL.png")));
        } catch (Exception ex) {
            Logger.getLogger(Ambulancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void moveTo(DisplayObject obj) {
        this.run(obj);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(this.getImg(), this.getX(), this.getY(), this.getH(), this.getW(), this);
    }

    public void run(DisplayObject target) {

        if (this.getX() > target.getX()) {
            super.setIsAmbDireita(false);
        } else {
            super.setIsAmbDireita(true);
        }

        while (this.getX() <= target.getX()) {
            if (this.getX() <= target.getX()) {
                this.setX(this.getX() + 5);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }

        while (this.getX() <= target.getX()) {
            if (this.getX() <= target.getX()) {
                this.setX(this.getX() + 5);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }

        while (this.getX() > target.getX()) {
            if (this.getX() > target.getX()) {
                this.setX(this.getX() - 5);
            }
            this.getDisplay().repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }

        while (this.getX() > target.getX()) {
            if (this.getX() > target.getX()) {
                this.setX(this.getX() - 5);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
