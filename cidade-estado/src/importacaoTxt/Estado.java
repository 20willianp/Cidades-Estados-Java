package importacaoTxt;

public class Estado {
    private int codEstado;
    private String nomeEstado;
   
    /*
    recebe uma linha com os dados: codigo, marcador(#),estado, marcador(*),
    cod, marcador(!) e cidade.EX: 12#Nome Do Estado*121212!nome da cidade
    indexOf percorre o vetor ate encontrar os marcadores, para conseguir fatiar os dados
    */    
    public String cadastrarEstado(String linha){
        int indice;
        String str;
        
        indice = linha.indexOf('#');
        str = linha.substring(0,indice);
        codEstado = Integer.valueOf(str);
        
        linha = linha.substring(indice+1);
      
        indice = linha.indexOf('*');
        nomeEstado = linha.substring(0,indice);
        
        return linha.substring(indice+1);
     
    }
    
    public String exibeMensagem(){
        return    ">>>>>>>>>>>>>>>>>> Cod Estado: [ "+codEstado
                + " ] Nome Estado: [ "+nomeEstado
                + " ] <<<<<<<<<<<<<<<<<<"; 
    }
    
    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
}
