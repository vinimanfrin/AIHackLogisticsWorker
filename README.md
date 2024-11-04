# 🏥 AI Hack Logistcs Worker para notificações

## Descrição: 
Este é o Worker do RabbitMQ que simula notificações enviadas para os médidos no AIHackLogistcs principal: https://github.com/vinimanfrin/AIHackLogistics

## Como Executar

### Pré-requisitos

- Java 17
- Maven
- Docker

### Passos para execução

1. Clone o repositório:

   ```bash
   https://github.com/vinimanfrin/AIHackLogisticsWorker

2. Acesse o diretório do projeto:
    ```bash
    cd seu-diretório

3. Baixe as dependências e compile o projeto:
    ```bash
    mvn clean install

4. Entre na pasta Docker e execute os comandos necessários
    ```bash
    cd docker
    docker-compose up
    
5. Acesse no navegador o caminho para o RabbitMQ que estará rodando localmente após o passo 4:
    ```bash
    http://localhost:15672/
    logue com usuário e senha padrão "guest":

![imagem](https://github.com/user-attachments/assets/645be598-2b3d-4456-8a07-e5fe6ceaa08b)


    
6. Crie as Exchanges necessárias:
   ```bash
   notificar-request-exchange
   notificar-response-erro-exchange
   notificar-response-sucesso-exchange
![imagem](https://github.com/user-attachments/assets/accdd761-c70c-4dd9-a578-760a5b196fdf)





6. Crie as Queues necessárias:
   ```bash
   notificar-request-queue
   notificar-response-erro-queue
   notificar-response-sucesso-queue
![imagem](https://github.com/user-attachments/assets/3e537836-4d29-4997-a438-4f5558856211)

7. Vincule as exchanges com as queues:
   ```bash
   notificar-request-exchange -> notificar-request-queue
   notificar-response-erro-exchange -> notificar-response-erro-queue
   notificar-response-sucesso-exchange -> notificar-response-sucesso-queue

   Vá até a aba exchanges, clique em uma por uma para fazer essa configuração e logo após clicar em bind:
   obs: a key precisa obrigatoriamente ser a mesma demonstrada na imagem.
![imagem](https://github.com/user-attachments/assets/bc798e02-e067-4b51-9924-932b1bfdbf36)


8. Agora basta rodar a aplicação e esse Worker está pronto para ser consumido pela aplicação principal!
   ```bash
   mvn spring-boot:run
