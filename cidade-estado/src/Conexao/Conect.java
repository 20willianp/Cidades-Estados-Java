package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    /*
    driver: driver,endereço do servidor e nome do banco.
    user: usuario do banco
    password: senha do banco.
    */
    
    public static Connection getConnection(){
        String driver = "";
        String user = "";
        String password = "";
        
        try {
            return DriverManager.getConnection(driver,user, password);
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: "+ex.getMessage());
            System.out.println("Error Code : "+ex.getErrorCode());
            throw new RuntimeException(ex);
        }
    }
}
