package SimSamuSimIntegrado.Data;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CSVExport {
    
    public void createCsvFile(String conteudo){ 
        try{

        //Cria o arquivo e nomeia
        BufferedWriter StrW = new BufferedWriter(new FileWriter("proto1081241_SC"+Util.geraRandom(200, 600)+"_SAMU_2016_2.csv"));

        //Escreve os dados no documento
        StrW.write(conteudo);
        
        StrW.close(); 
        }catch (FileNotFoundException ex)
        {
            // TODO: tratar exceções
            ex.printStackTrace(); 
        }
        catch (IOException e)
        {
            // TODO: tratar exceções
            e.printStackTrace(); 
        } 
    }
    
}
