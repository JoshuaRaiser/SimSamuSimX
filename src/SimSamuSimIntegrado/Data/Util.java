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

    public static LinkedList<AmostraSAMU> ordenaAtendimento(LinkedList<AmostraSAMU> amostras) {

        LinkedList<AmostraSAMU> retorno = new LinkedList<AmostraSAMU>();
        int ultimoFim = 0;

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
            amostraAtual.setFila(amostraAtual.getHoraOcorrencia() - ultimoFim);

            ultimoFim = amostraAtual.getTermino();

            retorno.add(amostraAtual);
            amostras.remove();

            for (AmostraSAMU amostraSAMU : amostras) {
                if (amostraSAMU.getHoraOcorrencia() <= ultimoFim) {
                    ordenar.add(amostraSAMU);
                } else {
                    break;
                }
            }
            if (!ordenar.isEmpty()) {
//                Collections.sort(amostras, new Comparator<AmostraSAMU>() {
//                    @Override
//                    public int compare(AmostraSAMU int1, AmostraSAMU int2) {
//                        return Integer.compare(int1.getNivelOcorrencia(), int2.getNivelOcorrencia()) * -1;
//                    }
//                });

                System.out.println("-----");
                int pos = 0;
                for (AmostraSAMU amostraSAMU : ordenar) {
                    System.out.println(amostraSAMU.getHoraOcorrencia() + " ~~~~ " + amostraSAMU.getNivelOcorrencia());

                    amostras.set(pos, amostraSAMU);
                    pos++;
                }
                System.out.println("-----");

                Collections.sort(ordenar, new Comparator<AmostraSAMU>() {
                    @Override
                    public int compare(AmostraSAMU fruit2, AmostraSAMU fruit1) {
                        return Integer.compare(fruit2.getHoraOcorrencia(), fruit1.getHoraOcorrencia());
                    }
                });

            }

        }

        return retorno;
    }

}
