## Instalação:
    
Para iniciar a instalação, realizei um clone do repositório em algum repositório de sua máquina com o comando git clone.
```sh
git clone https://github.com/GussAlves/dsmovie-sds.git
```

Após instalar em sua máquina, é necessário baixar as dependencias do projeto, para isso vamos utilizar o Maven, abra seu terminal e navegue até o reposítorio do projeto e rode o seguinte comando: 
```sh
mvn clean install
```
> Após rodar esse comando o maven deve baixar todas as dependências do projeito, em seguida você irá receber uma mensagem de _*BULD SUCCESS*_.

Para prosseguir temos que subir nosso banco de dados *Postgree*, para isso vamos utilizar o docker-compose assim não vamos perder tempo configurando o banco de dados. Para começar vamos rodar o comando de start conforme apresentado abaixo: 
```sh
docker-compose up -d
```
> Ele irá subir o banco de dados junto com um adiministrador, você pode consultar na url http://localhost:5432

> *Usuário: postgre | Senha: 1234567*

Com o banco de dados operacional vamos iniciar nosso projeto em spring boot com o maven, podemos realizar essa ação com o comando: 
```sh
mvn spring-boot:run
```
> Após o maven subir nosso projeto vamos acessa-lo através da url http://localhost:8080/movies . Se estiver tudo funcionando corretamente você irá ver os retornos das animações em Json.

Parabéns!! :zap: Você finalizou a instalação!! :zap:
