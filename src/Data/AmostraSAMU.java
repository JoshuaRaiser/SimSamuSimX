package Data;

import java.sql.Time;
import java.util.Random;

public class AmostraSAMU implements IAmostra {

    private int horaOcorrencia;    // minutos 
    private int nivelOcorrencia;   // 1 Urg. 2 Bas.

    private int tempoDeslocamento; // Minutos

    private int tempoAtendimento;  // Minutos
    private boolean foiHospital;   // Foi pro Hospital?
    private int tempoDeslHospital; // 

    private int tempoRetorno;      // Minutos

    static final int tempoPreparo = 5; // Minutos   

    static int ultimaOcorrência = 0;

    @Override
    public IAmostra geraAmostra() {
        AmostraSAMU newAmostra = new AmostraSAMU();

        newAmostra.setHoraOcorrencia(Util.geraRandom(0, 1440));
        newAmostra.setNivelOcorrencia(Util.geraRandom(1, 2));
        if (newAmostra.nivelOcorrencia == 1) {
            newAmostra.setTempoDeslocamento(Util.geraRandom(4, 10));
            newAmostra.setTempoAtendimento(Util.geraRandom(5, 15));
        } else {
            newAmostra.setTempoDeslocamento(Util.geraRandom(10, 18));
            newAmostra.setTempoAtendimento(Util.geraRandom(10, 20));
        }
        newAmostra.setFoiHospital(Util.geraRandom(1, 100));
        if (newAmostra.foiHospital) {
            newAmostra.setTempoDeslHospital(newAmostra.getTempoDeslocamento() + Util.geraRandom(2, 4));
        }
        newAmostra.setTempoRetorno(newAmostra.getTempoDeslocamento() + Util.geraRandom(1, 2));
        return newAmostra;
    }

    public int getNivelOcorrencia() {
        return nivelOcorrencia;
    }

    public void setNivelOcorrencia(int nivelOcorrencia) {
        this.nivelOcorrencia = nivelOcorrencia;
    }

    public int getTempoDeslocamento() {
        return tempoDeslocamento;
    }

    public void setTempoDeslocamento(int tempoDeslocamento) {
        this.tempoDeslocamento = tempoDeslocamento;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoAtendimento(int tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public boolean isFoiHospital() {
        return foiHospital;
    }

    public void setFoiHospital(boolean foiHospital) {
        this.foiHospital = foiHospital;
    }

    public void setFoiHospital(int valor) {
        if (this.nivelOcorrencia == 1) {
            if (valor > 30) {
                this.foiHospital = false;
            } else {
                this.foiHospital = true;
            }
        } else {
            if (valor > 15) {
                this.foiHospital = false;
            } else {
                this.foiHospital = true;
            }
        }
    }

    public int getTempoDeslHospital() {
        return tempoDeslHospital;
    }

    public void setTempoDeslHospital(int tempoDeslHospital) {
        this.tempoDeslHospital = tempoDeslHospital;
    }

    public int getTempoRetorno() {
        return tempoRetorno;
    }

    public void setTempoRetorno(int tempoRetorno) {
        this.tempoRetorno = tempoRetorno;
    }

    public int getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(int horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
        AmostraSAMU.ultimaOcorrência = horaOcorrencia;
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += "\nHora da Ocorrência: \t" + this.horaOcorrencia / 60 + ":" + this.horaOcorrencia % 60;
        retorno += "\nNivel: \t\t\t" + this.nivelOcorrencia;
        retorno += "\nTempo de Deslocamento: \t" + this.tempoDeslocamento;
        retorno += "\nTempo de Atendimento: \t" + this.tempoAtendimento;
        retorno += "\nFoi pro Hospital? \t" + this.foiHospital;
        retorno += "\nTempo Desl. Hospital: \t" + this.tempoDeslHospital;
        retorno += "\nTempo de Retorno: \t" + this.tempoRetorno;
        retorno += "\nTempo de Preparo: \t" + this.tempoPreparo;

        return retorno;
    }

    
    public String[] toArray()
    {
        String[] retorno = {"0",
            Integer.toString(this.getHoraOcorrencia()),
            Integer.toString(this.getNivelOcorrencia()),
            Integer.toString(this.getTempoAtendimento()),
            Integer.toString(this.getTempoDeslHospital()),
            Integer.toString(this.getTempoDeslocamento()),
            Integer.toString(this.getTempoRetorno())};
        
        return retorno;
    }
}
