package SimSamuSimIntegrado.Main;

import java.awt.Graphics;
import java.io.File;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Ambulância extends DisplayObject implements Runnable {

    Thread runner;
    Queue<DisplayObject> targets;
    boolean leoPrange = false;

    public Ambulância(Display display, Base base) {
        super.setH(50);
        super.setW(50);
        super.setIsAmbDireita(true);

        super.setDisplay(display);
        super.setX(base.getX());
        super.setY(base.getY());

        targets = new LinkedList<DisplayObject>();

        try {
            this.setImgR(ImageIO.read(new File("src/SimSamuSimIntegrado/Images/ambuR.jpg")));
            this.setImgL(ImageIO.read(new File("src/SimSamuSimIntegrado/Images/ambuL.jpg")));
        } catch (Exception ex) {
            Logger.getLogger(Ambulância.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void moveTo(DisplayObject obj) {
        targets.add(obj);
        this.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(this.getImg(), this.getX(), this.getY(), this.getH(), this.getW(), this);
    }

    public void start() {
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        leoPrange = true;
        DisplayObject target;
        while (!targets.isEmpty()) {
            target = targets.peek();

            while (this.getX() <= target.getX() || this.getY() <= target.getY()) {
                if(this.getX() <= target.getX())this.setX(this.getX() + 5);
                if(this.getY() <= target.getY())this.setY(this.getY() + 5);
                this.getDisplay().repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }

            while (this.getX() <= target.getX() || this.getY() > target.getY()) {
                if(this.getX() <= target.getX())this.setX(this.getX() + 5);
                if(this.getY()  > target.getY())this.setY(this.getY() - 5);
                this.getDisplay().repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }

            while (this.getX() > target.getX() || this.getY() <= target.getY()) {
                if(this.getX()  > target.getX())this.setX(this.getX() - 5);
                if(this.getY() <= target.getY())this.setY(this.getY() + 5);
                this.getDisplay().repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }

            while (this.getX() > target.getX() || this.getY() > target.getY()) {
                if(this.getX() > target.getX())this.setX(this.getX() - 5);
                if(this.getY() > target.getY())this.setY(this.getY() - 5);
                this.getDisplay().repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
            target.kill();
            targets.poll();
        }
        leoPrange = false;
        this.stop();
//        }
    }

    public void stop() {
        if (runner != null) {
            runner = null;
        }
    }

}
