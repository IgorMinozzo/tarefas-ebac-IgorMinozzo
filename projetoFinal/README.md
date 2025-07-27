# MEMELÂNDIA - Arquitetura de Microserviços

## Visão Geral

Este projeto implementa a migração da aplicação monolítica MEMELÂNDIA para uma arquitetura de microserviços, seguindo os princípios dos 12 fatores e boas práticas de desenvolvimento.

## Arquitetura

A aplicação foi desmembrada em 3 microserviços independentes:

### 1. Usuario Service (Porta 8081)
- **Responsabilidade**: Gerenciamento de usuários
- **Endpoints**:
  - `GET /usuarios` - Listar todos os usuários
  - `GET /usuarios/{id}` - Buscar usuário por ID
  - `GET /usuarios/email/{email}` - Buscar usuário por email
  - `POST /usuarios` - Criar novo usuário
  - `PUT /usuarios/{id}` - Atualizar usuário
  - `DELETE /usuarios/{id}` - Deletar usuário

### 2. Categoria Meme Service (Porta 8082)
- **Responsabilidade**: Gerenciamento de categorias de memes
- **Endpoints**:
  - `GET /categorias` - Listar todas as categorias
  - `GET /categorias/{id}` - Buscar categoria por ID
  - `GET /categorias/usuario/{usuarioId}` - Buscar categorias por usuário
  - `POST /categorias` - Criar nova categoria
  - `PUT /categorias/{id}` - Atualizar categoria
  - `DELETE /categorias/{id}` - Deletar categoria

### 3. Meme Service (Porta 8083)
- **Responsabilidade**: Gerenciamento de memes
- **Endpoints**:
  - `GET /memes` - Listar todos os memes
  - `GET /memes/{id}` - Buscar meme por ID
  - `GET /memes/usuario/{usuarioId}` - Buscar memes por usuário
  - `GET /memes/categoria/{categoriaId}` - Buscar memes por categoria
  - `GET /memes/meme-do-dia` - Obter meme aleatório do dia
  - `POST /memes` - Criar novo meme
  - `PUT /memes/{id}` - Atualizar meme
  - `DELETE /memes/{id}` - Deletar meme

## Tecnologias Utilizadas

- **Spring Boot 2.7.7**: Framework principal
- **Spring Data JPA**: Persistência de dados
- **H2 Database**: Banco de dados em memória
- **Spring Cloud OpenFeign 3.1.8**: Comunicação entre microserviços
- **Spring Boot Actuator**: Monitoramento e métricas
- **Micrometer**: Métricas customizadas
- **SLF4J**: Sistema de logs

## Funcionalidades Implementadas

### Observabilidade
- **Logs estruturados**: Todos os endpoints possuem logs informativos
- **Métricas customizadas**: Contadores de requisições por serviço
- **Métricas de tempo**: Medição de tempo de resposta dos endpoints
- **Health checks**: Endpoints de saúde via Actuator
- **Métricas Prometheus**: Exposição de métricas para monitoramento

### Comunicação entre Microserviços
- **Feign Clients**: Comunicação síncrona entre serviços
- **Validação de dependências**: Verificação de existência de usuários e categorias
- **Tratamento de erros**: Handling adequado de falhas de comunicação

### Funcionalidades Especiais
- **Meme do Dia**: Endpoint que retorna um meme aleatório
- **CORS habilitado**: Permite acesso de qualquer origem
- **Validações de negócio**: Verificação de emails únicos, nomes de categorias únicos

## Como Executar

### Pré-requisitos
- Java 11+
- Maven 3.6+

### Executando os Microserviços

1. **Usuario Service**:
```bash
cd usuario-service
mvn spring-boot:run
```

2. **Categoria Meme Service**:
```bash
cd categoria-meme-service
mvn spring-boot:run
```

3. **Meme Service**:
```bash
cd meme-service
mvn spring-boot:run
```

### Acessando os Serviços

- **Usuario Service**: http://localhost:8081
- **Categoria Meme Service**: http://localhost:8082
- **Meme Service**: http://localhost:8083

### Consoles H2 (Desenvolvimento)
- **Usuario Service**: http://localhost:8081/h2-console
- **Categoria Meme Service**: http://localhost:8082/h2-console
- **Meme Service**: http://localhost:8083/h2-console

### Métricas e Monitoramento
- **Usuario Service**: http://localhost:8081/actuator
- **Categoria Meme Service**: http://localhost:8082/actuator
- **Meme Service**: http://localhost:8083/actuator

## Exemplo de Uso

### 1. Criar um usuário
```bash
curl -X POST http://localhost:8081/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@email.com"
  }'
```

### 2. Criar uma categoria
```bash
curl -X POST http://localhost:8082/categorias \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Memes Engraçados",
    "descricao": "Categoria para memes divertidos",
    "usuarioId": 1
  }'
```

### 3. Criar um meme
```bash
curl -X POST http://localhost:8083/memes \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Meme Clássico",
    "descricao": "Um meme muito engraçado",
    "url": "https://exemplo.com/meme.jpg",
    "usuarioId": 1,
    "categoriaMemeId": 1
  }'
```

### 4. Obter meme do dia
```bash
curl http://localhost:8083/memes/meme-do-dia
```

## Estrutura do Projeto

```
workspace/
├── usuario-service/
│   ├── src/main/java/br/com/ebac/memelandia/usuario/
│   │   ├── entities/Usuario.java
│   │   ├── repositories/UsuarioRepository.java
│   │   ├── services/UsuarioService.java
│   │   ├── controllers/UsuarioController.java
│   │   └── UsuarioServiceApplication.java
│   └── src/main/resources/application.properties
├── categoria-meme-service/
│   ├── src/main/java/br/com/ebac/memelandia/categoria/
│   │   ├── entities/CategoriaMeme.java
│   │   ├── repositories/CategoriaMemeRepository.java
│   │   ├── services/CategoriaMemeService.java
│   │   ├── controllers/CategoriaMemeController.java
│   │   ├── clients/UsuarioClient.java
│   │   └── CategoriaMemeServiceApplication.java
│   └── src/main/resources/application.properties
└── meme-service/
    ├── src/main/java/br/com/ebac/memelandia/meme/
    │   ├── entities/Meme.java
    │   ├── repositories/MemeRepository.java
    │   ├── services/MemeService.java
    │   ├── controllers/MemeController.java
    │   ├── clients/UsuarioClient.java
    │   ├── clients/CategoriaMemeClient.java
    │   └── MemeServiceApplication.java
    └── src/main/resources/application.properties
```

## Considerações de Design

### Consistência
- **Consistência eventual**: Os microserviços mantêm referências por ID
- **Validação de integridade**: Verificação de existência via Feign Clients
- **Tratamento de falhas**: Respostas adequadas quando dependências não existem

### Escalabilidade
- **Bancos independentes**: Cada microserviço possui sua própria base de dados
- **Comunicação assíncrona**: Preparado para implementação de mensageria
- **Stateless**: Serviços sem estado para facilitar escalabilidade horizontal

### Observabilidade
- **Logs estruturados**: Facilita análise e debugging
- **Métricas de negócio**: Contadores e timers para monitoramento
- **Health checks**: Verificação de saúde dos serviços

## Próximos Passos

1. **Service Discovery**: Implementar Eureka ou Consul
2. **API Gateway**: Centralizar acesso aos microserviços
3. **Circuit Breaker**: Implementar Hystrix para resiliência
4. **Mensageria**: Adicionar RabbitMQ ou Kafka para comunicação assíncrona
5. **Containerização**: Dockerizar os microserviços
6. **Testes de integração**: Expandir cobertura de testes

