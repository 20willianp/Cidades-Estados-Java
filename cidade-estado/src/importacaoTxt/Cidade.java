
package importacaoTxt;

public class Cidade {
    private int codCidade;
    private int codEstado;
    private String nomeCidade;
    
    /*
    recebe uma linha com os dados: codigo, marcador(!) e nome. EX: 121212!Nome Da Cidade
    indexOf percorre o vetor ate encontrar o marcador, para conseguir fatiar os dados
    */
    public void cadastraCidade(String linha){
        int indice;
        String str;
        
        indice = linha.indexOf('!');
        str = linha.substring(0,indice);
        codCidade = Integer.valueOf(str);
        
        linha = linha.substring(indice+1);
        str = linha.trim();
        nomeCidade = str;
    }
    
    public String exibeMensagem(){
        return    " Cod Cidade:  [ "+codCidade
                + " ]   Cidade: [ "+nomeCidade
                + " ]   Cod Estado: [ "+codEstado+" ]";  
    }
    
    
    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }
    
    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}