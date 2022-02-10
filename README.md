# Teste Rodarte
> Sistema de manipulação de Excel e cálculo de estatísticas básicas

<i> * Necessário [Java 11+](https://www.oracle.com/java/technologies/downloads/), [MySql](https://mariadb.org/download/), [Git](https://git-scm.com/downloads), [NodeJs](https://nodejs.org/en/download/) </i>

App feito em
<h3>Java SpringBoot</h3>
    - Spring Data
    - Apache POI
    - Swagger
    - Lombok
    
## Instalação

```sh
git clone https://github.com/JoaoVitorOliMendes/TesteRodarte.git
cd TesteRodarte
```

## Iniciar App

```sh
Back-end:

  mvn spring-boot:run     *Configurar BD antes
  
Front-end:

  cd webapp/TesteRodarteFront
  npm start
```

Para acessar swagger-ui:
http://localhost:8080/swagger-ui.html

Para acessar front-end:
http://localhost:4200

Caso estiver testando a aplicacao localmente:
  - Criar Banco de dados MySql TesteRodarte
  - Mudar Application.properties para a configuracao do banco de dados

## Meta

JoaoVitor de Oliveira Mendes – [LinkedIn](https://www.linkedin.com/in/jo%C3%A3o-vitor-de-oliveira-mendes-6874b11b3/) – joaovitordeoliveiramendes@tutanota.com

[My Profile](https://github.com/JoaoVitorOliMendes)

[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki
