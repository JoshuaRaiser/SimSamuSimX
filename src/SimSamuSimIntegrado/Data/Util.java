package SimSamuSimIntegrado.Data;

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

    public static LinkedList<AmostraSAMU> processaAtendimento(LinkedList<AmostraSAMU> amostras) {

        LinkedList<AmostraSAMU> retorno = new LinkedList<AmostraSAMU>();
        int ultimoFim = 0;
        ultimoFim = amostras.peek().getHoraOcorrencia();
        while (!amostras.isEmpty()) {

            LinkedList<AmostraSAMU> ordenar = new LinkedList<AmostraSAMU>();

            AmostraSAMU amostraAtual;
            amostraAtual = amostras.peek();
            amostraAtual.setTermino(
                    ultimoFim
                    + amostraAtual.getTempoAtendimento()
                    + amostraAtual.getTempoDeslocamento()
                    + amostraAtual.getTempoDeslHospital()
                    + amostraAtual.getTempoRetorno()
            );
            
            if (amostraAtual.getHoraOcorrencia() <= ultimoFim) {
                amostraAtual.setFila(ultimoFim - amostraAtual.getHoraOcorrencia());
            } else {
                amostraAtual.setFila(0);
            }
            
            ultimoFim = amostraAtual.getTermino();

            retorno.add(amostraAtual);
            amostras.remove();
        }
        retorno.peek().setFila(0);
        return retorno;
    }

}
