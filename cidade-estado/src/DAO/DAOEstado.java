/*
Classe responsavel pela inserção dos dados na tabela Estado.
Banco de dados deve conter a seguinte tabela:
 ________________________
|_______estado___________|
| integer cod_estado pk  |
| varchar nome_estado    |
|________________________| 

*/

package DAO;

import InterfaceDAO.IDAOEstado;
import importacaoTxt.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEstado implements IDAOEstado{
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    @Override
    public boolean inserir(Estado estado) {
        conexao = Conexao.Conect.getConnection();
        
        sql = "INSERT INTO estado(nome_estado, cod_estado) VALUES (?,?)";
        
        try {
            ps = conexao.prepareStatement(sql);
            /*
                Obrigatorio a sequencia numerica dos campos de acordo com o comando SQL acima
                pode-se optar em substituir o numero pelo nome dos campos (
                EX: 1 / nome_estado, 2 /cod_estado)
            */
            
            ps.setString(1, estado.getNomeEstado());
            ps.setInt(2, estado.getCodEstado());
            
            ps.execute();
            
            ps.close();
            conexao.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao executar inserção: "+ex.getMessage());
            System.out.println("Error Code : "+ex.getErrorCode());
            return false;
        }
    }
}
