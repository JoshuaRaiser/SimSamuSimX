package Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Util {

    public static int geraRandom(int de, int ate) {
        Random gerador = new Random();

        int valor;

        valor = gerador.nextInt((ate - de) + 1) + de;

        return valor;
    }

    public static void fazOrdenacao(LinkedList<AmostraSAMU> amostras) {
        Collections.sort(amostras, new Comparator<AmostraSAMU>() {
            @Override
            public int compare(AmostraSAMU fruit2, AmostraSAMU fruit1) {
                return Integer.compare(fruit2.getHoraOcorrencia(), fruit1.getHoraOcorrencia());
            }
        });
        Collections.sort(amostras, new Comparator<AmostraSAMU>() {
            @Override
            public int compare(AmostraSAMU fruit2, AmostraSAMU fruit1) {
                return Integer.compare(fruit2.getNivelOcorrencia(), fruit1.getNivelOcorrencia());
            }
        });
    }

    public static void ordenaAtendimento(LinkedList<AmostraSAMU> amostras) {
            
         
        
    }

}
