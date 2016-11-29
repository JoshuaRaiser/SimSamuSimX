package SimSamuSimIntegrado.Main;

import Data.AmostraSAMU;
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

    public void vai() {
        this.start();
    }

    public void start()
    {
        if(engThread == null)
        {
            engThread = new Thread(this);
            engThread.start();
        }
    }
    
    @Override
    public void run() {

        while (!amostras.isEmpty()) {
            
            ((DefaultTableModel) jTable.getModel()).addRow(amostras.peek().toArray());

            //PROCESSA
            //atualiza Tabela
            //{{{{{{ QUEUE DE MOVIMENTO
            display.getAmbu().moveTo(display.getPac());
            display.getAmbu().moveTo(display.getHosp());
            display.getAmbu().moveTo(display.getBase());
            //}}}}}} QUEUE DE MOVIMENTO

            while (display.getAmbu().runner.isAlive()) {
                System.out.println("x");
            }
            amostras.remove();
        }
        this.stop();
    }
    
    public void stop() {
        if (engThread != null) {
            engThread = null;
        }
    }
}
