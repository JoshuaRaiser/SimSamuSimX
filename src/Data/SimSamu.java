package Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SimSamu {

    public static LinkedList<AmostraSAMU> geraValores() {
        LinkedList<AmostraSAMU> amostras = new LinkedList<AmostraSAMU>();

        String conteudo = "Hora da Ocorrência;"
                + "Nível de Urgência;"
                + "Tempo de Descolamento*;"
                + "Tempo de Atendimento*;"
                + "Foi para Hospital;"
                + "Tempo Deslocamento Hospital*;"
                + "Tempo de Retorno*\n";

        for (int i = 0; i < 100; i++) {
            AmostraSAMU amostraTeste = new AmostraSAMU();
            amostraTeste = (AmostraSAMU) amostraTeste.geraAmostra();
            amostras.add(amostraTeste);
            //retorno += "\nHora da Ocorrência: \t"+this.horaOcorrencia/60+":"+this.horaOcorrencia%60;
            int minutos = amostraTeste.getHoraOcorrencia() % 60;
            if (minutos < 10) {
                minutos *= 10;
            }
            String foi;
            if (amostraTeste.isFoiHospital()) {
                foi = "Sim";
            } else {
                foi = "Não";
            }
            conteudo += amostraTeste.getHoraOcorrencia() / 60 + ":" + amostraTeste.getHoraOcorrencia() % 60 + ";"
                    + amostraTeste.getNivelOcorrencia() + ";"
                    + amostraTeste.getTempoDeslocamento() + ";"
                    + amostraTeste.getTempoAtendimento() + ";"
                    + foi + ";"
                    + amostraTeste.getTempoDeslHospital() + ";"
                    + amostraTeste.getTempoRetorno() + "\n";
        }

        conteudo += "\n*= tempo em minutos\n";
        CSVExport csv = new CSVExport();
        csv.createCsvFile(conteudo);

        Collections.sort(amostras, new Comparator<AmostraSAMU>() {
            @Override
            public int compare(AmostraSAMU fruit2, AmostraSAMU fruit1) {
                return Integer.compare(fruit2.getHoraOcorrencia(),fruit1.getHoraOcorrencia());
            }
        });
        Collections.sort(amostras, new Comparator<AmostraSAMU>() {
            @Override
            public int compare(AmostraSAMU fruit2, AmostraSAMU fruit1) {
                return Integer.compare(fruit2.getNivelOcorrencia(), fruit1.getNivelOcorrencia());
            }
        });

        return amostras;
    }
}
