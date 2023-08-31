package uenp.trabalholp;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Leitor {
    public static ArrayList<Integer[]> lerDados() {
         try {
            String strFile = "C:\\Users\\devma\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoLP\\src\\main\\java\\uenp\\trabalholp\\resultados.csv";
            
            CSVReader reader = new CSVReader(new FileReader(strFile));
            List<String[]> entrada = reader.readAll();
            ArrayList<String> dados = new ArrayList<>();
            
            for (String[] linhas : entrada) {
                for (String linha : linhas) {
                    dados.add(linha);
                }
            }
            
            ArrayList<Integer[]> dadosFiltrados = new ArrayList<Integer[]>();
            for (int i = 1; i < dados.size(); i++) {
                String[] splitLine = dados.get(i).split(";");
                Integer[] intArray = new Integer[splitLine.length - 2];
                for (int j = 2; j < splitLine.length; j++) {
                    intArray[j-2] = Integer.parseInt(splitLine[j]);
                }
                dadosFiltrados.add(intArray);            
            }
            
            return dadosFiltrados; 
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
  
    
}