package SimSamuSimIntegrado.Main;

import SimSamuSimIntegrado.Data.AmostraSAMU;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Engine implements Runnable {

    Thread engThread;
    LinkedList<AmostraSAMU> amostras;
    Display display;
    JFrame frame;
    JTable jTable;

    public Engine(LinkedList<AmostraSAMU> amostras, Display display, JFrame frame, JTable jTable) {
        this.amostras = amostras;
        this.display = display;
        this.frame = frame;
        this.jTable = jTable;
    }

    public void start() {

        engThread = new Thread(this);
        engThread.start();
    }

    public void run() {

        LinkedList<AmostraSAMU> itens = amostras;
        int cont = 0;
        while (!itens.isEmpty()) {
            
            jTable.setRowSelectionInterval(cont,cont++);
            
            jTable.repaint();
            display.getAmbu().moveTo(display.getPac());

            if (itens.peek().isFoiHospital()) {
                display.getPac().kill();
                display.getAmbu().moveTo(display.getHosp());
            }

            display.getAmbu().moveTo(display.getBase());

            itens.remove();

            jTable.clearSelection();
            
            this.display.reset();
        }
        this.stop();
    }

    public void stop() {
        if (engThread != null) {
            engThread = null;
        }
    }
}
