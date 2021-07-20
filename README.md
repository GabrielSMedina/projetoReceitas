# projetoReceitas
O projeto se trata de uma API Rest que trabalha com o armazenamento de receitas.

- Funcionalidades:
  >Cadastrar um novo usuario para ter acesso aos servicos;
  >Adicionar receitas ao banco de dados;
  >Atualizar receitas no banco de dados;
  >Deletar receitas no banco de dados pelo id;
  >Listar todas as receitas do banco de dados;
  >Listar uma receita especifica pelo id.

- Preparando a API para o uso:
  >Abra o arquivo application.properties(receitasApiRest/src/main/resources) e adicionar os dados do banco de dados postgreSQL da sua maquina;
  >Deixe sua database aberta;
  >Execute a API para que ela crie as tabelas automaticamente e feche ela em seguida;
  >Abra seu postgreSQL, vá até a database definida como destino, abra a query e exeute o comando "GRANT ALL PRIVILEGES ON TABLE tb_receitas TO {nome_usuario};
  >Agora sua maquina esta pronta para executar a API sem erros esperados.

- Como utilizar:  
  >As funcionalidades trabalham através de requisições http, portanto use um programa como o Postman.  
  
  >Utilizando o Postman:  
   -Adicione a url(http://localhots:{port}) no Postman;  
    -Altere para o metodo POST;  
    -Na aba 'body' troque de 'none'para 'raw' e onde esta escrito 'text' troque para 'JSON'.  
    
  >Cadastro:  
    -Na url Utilize o metodo POST;  
    -Utilize (/api/cadastrar) ao final da url padrão;  
   -Vá em 'body' e passe as informações do usuario no formato:  
      {  
        "nome": "{Nome_usuario}",  
        "email": "{Email_usuario}",  
        "senha": "{Senha_usuario}"  
      }  
    -Clique em Send.  
    
  >Adicionar receita:  
    -Na url Utilize o metodo POST;  
    -utilize (/api/receitas/adicionar) ao final da url padrão;  
    -Vá em 'body' e passe as informações da receita no formato:  
      {  
        "nome": "{Nome_receita}",  
        "ingredientes": "{Ingredientes_receita}",  
        "modo_preparo": "{modo_praparo_receita}"  
      }  
    -Clique em Send.  
      
  >Atualizar receita:  
    -Na url Utilize o metodo PUT;  
    -utilize (/api/receitas/atualizar) ao final da url padrão;  
    -Vá em 'body' e passe as informações da receita no formato:  
      {  
        "nome": "{Nome_receita}",  
        "ingredientes": "{Ingredientes_receita}",  
        "modo_preparo": "{modo_praparo_receita}"  
      }  
    -Clique em Send.  
      
  >Deletar receita:  
    -Na url Utilize o metodo DELETE;  
    -utilize (/api/receitas/deletar/{id}) ao final da url padrão passando o id da receita que será deletada;  
    -Clique em Send.  
    
  >Listar todas as receitas:  
   -Na url Utilize o metodo GET;  
   -utilize (/api/receitas/listar) ao final da url padrão;  
   -Clique em Send.  
    
  >Buscar receita por id:  
    -Na url Utilize o metodo GET;  
   -utilize (/api/receitas/buscar/{id}) ao final da url padrão passando o id da receita que será mostrada;  
   -Clique em Send.  
