
# Projeto Receitas

Um sistema simples de cadastro de receitas, desenvolvido como parte de estudos com Kotlin e PostgreSQL.

## 📋 Funcionalidades

- Cadastro de receitas com título, ingredientes e modo de preparo.
- Consulta das receitas já cadastradas.
- Atualização e remoção de receitas existentes.
- Integração com banco de dados PostgreSQL para armazenamento e gerenciamento das receitas.

## 🚀 Tecnologias Utilizadas

- **Kotlin**: Linguagem principal para o desenvolvimento da aplicação.
- **PostgreSQL**: Banco de dados utilizado para persistência dos dados.
- **Gradle**: Ferramenta de build para gerenciamento de dependências e configuração do projeto.

## 🛠️ Como Executar o Projeto

### Pré-requisitos
1. **PostgreSQL**: Certifique-se de ter o banco de dados instalado e configurado.
2. **JDK 11 ou superior**: Para compilar e executar o projeto.
3. **Gradle**: Para rodar o build do projeto.

### Passos
1. Clone este repositório:
   ```bash
   git clone https://github.com/GabrielSMedina/projetoReceitas.git
   ```
2. Configure o banco de dados PostgreSQL:
   - Crie um banco de dados.
   - Atualize o arquivo de configuração da aplicação com as credenciais do seu banco de dados.
3. Compile e execute o projeto usando Gradle:
   ```bash
   ./gradlew run
   ```
4. Acesse a aplicação no endereço fornecido pelo terminal após iniciar o servidor.

## 📄 Estrutura do Projeto

- **`src/main`**: Contém o código-fonte da aplicação.
  - **`models`**: Classes que representam os dados das receitas.
  - **`services`**: Lógica de negócio para manipulação de receitas.
  - **`controllers`**: Controladores que gerenciam as rotas e endpoints.
- **`resources`**: Arquivos de configuração e scripts SQL.

## 📚 Próximos Passos

- Adicionar autenticação de usuários.
- Implementar interface gráfica para facilitar o uso.
- Melhorar a documentação interna do código.
