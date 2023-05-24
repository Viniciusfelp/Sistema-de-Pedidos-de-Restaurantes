# Sistema de Pedidos de Restaurantes

O "Sistema de Pedidos de Restaurantes" é uma API REST desenvolvida em Spring Boot, criada para fins de estudos e aprendizado prático sobre o desenvolvimento de aplicações web.

## Recursos Principais

- Gerenciamento de pedidos: permite aos usuários fazerem pedidos, acompanhar o status e fornecer feedback.
- Menu do restaurante: exibe informações sobre os pratos disponíveis, preços e descrições.
- Pagamentos: integração com uma plataforma de pagamentos para processar transações seguras.
- Autenticação e autorização: recursos para garantir a segurança das transações e proteger informações sensíveis.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL (banco de dados)
- Docker

## Configuração do Ambiente

1. Clone o repositório: `git clone https://github.com/viniciusfelp/sistema-pedidos-restaurante.git`
2. Importe o projeto em sua IDE Java preferida.
3. Configure o banco de dados PostgreSQL e atualize as configurações de conexão no arquivo `application.properties`.
4. Execute o projeto e a API estará disponível em `http://localhost:8080`.

## Executando com Docker

1. Certifique-se de ter o Docker instalado em sua máquina.
2. No diretório raiz do projeto, execute o comando: `docker build -t sistema-pedidos-restaurante .`
3. Após a conclusão da criação da imagem Docker, execute o comando: `docker run -p 8080:8080 sistema-pedidos-restaurante`
4. A API estará disponível em `http://localhost:8080`.