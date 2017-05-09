package importacaoTxt;

import DAO.DAOCidade;
import DAO.DAOEstado;
import InterfaceDAO.IDAOCidade;
import InterfaceDAO.IDAOEstado;
import java.util.ArrayList;

public class Importa {
    private Estado estado;
    private Estado temp;
    private IDAOEstado es;  
    private IDAOCidade ci;
    private ArrayList<String> array;
    private int contEst;
    private int contCid;
    
    public Importa(){
        
        initAtt();
        
        for(String linha : array){
            
            temp = new Estado(); 
            //inseri os dados no objeto temp e retorna os dados que contem cod e nome da cidade.
            linha = temp.cadastrarEstado(replace(linha)); 
            
            if(estado == null){
                cadEstado();
            }
            
            // verifica se ja existe um estado, para nao inserir duas vezes no banco de dados.
            if(temp.getCodEstado() != estado.getCodEstado()){
                cadEstado();
            }
                
            cadCidade(linha);
        }
        
        System.out.println(">>>>>>>>>>>>>>> Cadastro Finalizado <<<<<<<<<<<<<<<<<<<<<");
        System.out.println("INFO: Cidades cadastradas >> "+contCid);
        System.out.println("INFO: Estados cadastrados >> "+contEst);
    }
    // inicializa os atributos
    private void initAtt(){
        array = new File().readFile();
        es = new DAOEstado();
        ci = new DAOCidade();
        contCid = 0;
        contEst = 0;
        estado = null;
    }
    
    //retira os espaços em branco que contem no arquivo.
    private String replace(String linha){
        return linha.replace("	", "");
    } 
    
    //encerra o programa se algum erro acontecer na inserção dos dados.
    private void printError(){
        System.out.println(">>>>>>>>>>>>>>>> ATENÇÃO <<<<<<<<<<<<<<<<<<<"
                + "\nOcorreu um erro ao cadastrar os dados. "
                + "\nQuando iniciar o cadastro novamente, certifique-se de \n"
                + "apagar todos os dados da tabela (Cidade e Estado) ");
        System.exit(0);
    }
    
    //inseri dados do estado na base de dados
    private void cadEstado(){
        estado = temp;
        
        if(es.inserir(estado)){
            System.out.println(estado.exibeMensagem());
            contEst ++;
        }else{
            printError();
        }  
    }
    
    // inseri dados da cidade na base de dados.
    private void cadCidade(String linha){
        Cidade cidade = new Cidade();
    
        cidade.cadastraCidade(linha);
        cidade.setCodEstado(estado.getCodEstado());
        
        if(ci.inserir(cidade)){
            System.out.println(cidade.exibeMensagem());
            contCid ++;
        }else{
            printError();
        }
    }
}