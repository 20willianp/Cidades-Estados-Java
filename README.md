# CidadesEstados-Java
Código escrito em Java para cadastrar cidades e estados do Brasil em uma base de dados.

Na pasta do projeto possui um arquivo chamado "CidadeEstados.txt" com as cidades e estados.
O programa realiza a leitura do arquivo e inseri as informaçôes no banco de dados.

O programa está preparado para uma base de dados que contém as tabelas cidade e estado da seguinte maneira:

         cidade
  
  - cod_cidade INTEGER pk
  - nome_cidade VARCHAR
  - cod_estado INTEGER fk
   
          estado
   
   - cod_estado INTEGER pk
   - nome_estado VARCHAR
   
  # Configuração 
  
  Na Classe Conect é necessario informar:
  
        Driver do SGBD, endereço do servidor e nome do banco de dados.
        Usuário.
        Senha.
   
