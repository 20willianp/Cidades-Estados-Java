package importacaoTxt;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    private int cont;
    
    public ArrayList<String> readFile(){
        ArrayList<String> array = new ArrayList<>();
        cont = 0;
        
        try {
            FileReader arq = new FileReader("CidadeEstados.txt"); // lê o arquivo
            
            System.out.println("Lendo arquivo.................OK");
            BufferedReader lerArq = new BufferedReader(arq); //cria um buffer para os dados
            String linha = lerArq.readLine();       //pega a primeira linha do buffer
            
            //enquanto estiver dados no buffer vai adicionado linha por linha no array
            while(linha != null){                    
                array.add(linha);
                linha = lerArq.readLine();
                cont ++;
            }
            
            System.out.println("INFO: linhas do arquivo >> "+cont);
        } catch (FileNotFoundException ex) {
            System.out.println("Não Foi Possivel ler o arquivo");
        } catch (IOException ex) {
            System.out.println("Não Foi Possivel ler o arquivo");
        }
        
        return array;
    }
}
