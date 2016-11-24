package Data;


import java.util.Random;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 5686563
 */
public class Util {
    
    public static int geraRandom(int de, int ate)
    {
        Random gerador = new Random();
        
        int valor;
        
        valor = gerador.nextInt((ate - de) + 1) + de;
        
        return valor;
    }
    
}
