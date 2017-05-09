/*
Classe responsavel pela inserção dos dados na tabela Cidade.
Banco de dados deve conter a seguinte tabela:
 ________________________
|_______cidade___________|
| integer cod_cidade pk  |
| varchar nome_cidade    |
| integer cod_estado fk  |
|________________________| 

*/

package DAO;

import InterfaceDAO.IDAOCidade;
import importacaoTxt.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOCidade implements IDAOCidade{
    private Connection conexao;
    private PreparedStatement ps;
    private String sql;
    
    @Override
    public boolean inserir(Cidade cidade) {
        conexao = Conexao.Conect.getConnection();
        
        sql = "INSERT INTO cidade (cod_cidade, nome_cidade, estado_cod) VALUES (?,?,?)";
        
        try {
            ps = conexao.prepareStatement(sql);
            /*
                Obrigatorio a sequencia numerica dos campos de acordo com o comando SQL acima
                pode-se optar em substituir o numero pelo nome dos campos (
                EX: 1 / cod_cidade, 2 /nome_cidade, 3 /estado_cod )
            */
            
            ps.setInt(1, cidade.getCodCidade());
            ps.setString(2, cidade.getNomeCidade());
            ps.setInt(3, cidade.getCodEstado());
            
            ps.execute();
            
            ps.close();
            conexao.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao executar inserção" + ex.getMessage());
            System.out.println("Error Code : " + ex.getErrorCode());
            return false;
        }        
    }
    
}
