##Prova de conceito abordando falha de conectividade

Spring Boot 2.4 com cache Redis


## Tecnologias utilizadas

- Java 11
- Docker
- Spring Boot 2.4
- Redis

## 🛠️ Execução projeto ##

<details>
    <summary><b>1. Executando a imagem Redis</b></summary>

    docker run -d -p 6379:6379 --name redis1 redis
</details>

<details>
    <summary><b>2. Interrompendo a execução do Redis</b></summary>

    docker stop redis1
</details>

<details>
    <summary><b>3. Acesso às interfaces OpenAPI</b></summary>

http://localhost:8080/swagger-ui/index.html
</details>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)