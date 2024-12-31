# Acme Project

Este projeto é uma demonstração para fins de R&S.

## Arquitetura

A arquitetura deste projeto segue a literatura [The Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html),
implementando simplificadamente 3 camadas (application/core/domain), representadas de maneira bem definida como _subprojects_ em um projeto [Gradle multi-project](https://docs.gradle.org/current/userguide/multi_project_builds.html), conforme diagrama simplificado abaixo.

![clean-arch-diagram.png](docs%2Fclean-arch-diagram.png)

## Especificações e Frameworks utilizados
* Spring Boot 3 (Java 17)
* OpenAPI
* Swagger;
* Logback;
* Micrometer Tracing;
* Lombok;
* MapStruct;
* Spring Cloud OpenFeign;
* JPA;
* OAuth;
* SonarQube;
* WireMock;
* H2 Database Engine;
* Rest Assured;
* ArchUnit;
* Checkstyle;
* PMD;

## Considerações

#### Fluxo de Negócio implementado como exemplo:
Este projeto possui um fluxo de Negócio implementado como exemplo, que consiste num CRUD de 
Clientes (modelo de domínio em questão), integrando com uma API de Bureau externo e gerando
[Eventos de Domínio](https://microservices.io/patterns/data/domain-event.html) via Kafka utilizando o
_pattern_ [Transactional outbox](https://microservices.io/patterns/data/transactional-outbox.html).

#### Dependências externas:
Um diretório com Docker Compose foi disponibilizado para emular dependências externas no ambiente de desenvolvimento, 
permitindo que o desenvolvedor trabalhe mesmo sem acesso à internet/VPN.

#### Testes integrados:
Um _subproject_ específico ("application-layer:**integration-test**") para testes integrados foi implementado, com um mecanismo facilitador para emular 
dependências Web externas, utilizando o _framework_ [WireMock](https://wiremock.org/), garantindo assim mais produtividade e uma cobertura de testes mais eficaz.

#### Testes de Arquitetura:
Este projeto utiliza a biblioteca [ArchUnit](https://www.archunit.org/) para garantir que as boas práticas e os 
princípios arquiteturais não sejam quebrados.


## Como utilizar
Basta copiar este projeto para o repositório do seu projeto, renomeando algumas referências e ajustando apropriadamente as configurações de ambiente.

#### Executando localmente:

```bash
  sudo docker-compose -f docker-compose/docker-compose.yml up
  ./gradlew run  
```

## Requisições

### Criar novo cliente
```bash
curl --location 'http://localhost:8080/customers' \
--header 'Content-Type: application/json' \
--data '{
    "document": "42123773816",
    "firstName": "Gabriel",
    "lastName": "Wolf"
}'
```

### Pesquisar cliente pelo id
```bash
curl --location 'http://localhost:8080/customers/a9b03fd3-ddea-46d4-bc60-47fafc1be7dd'
```

### Remover cliente pelo id
```bash
curl --location --request DELETE 'http://localhost:8080/customers/a9b03fd3-ddea-46d4-bc60-47fafc1be7dd'
```