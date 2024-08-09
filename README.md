# ToolsChallenge - API de Pagamentos

## Descrição

O **ToolsChallenge** é uma API de pagamentos desenvolvida para simular operações de pagamento e estorno de transações. O sistema foi construído utilizando Java e Spring Boot e oferece endpoints para realizar pagamentos, estornar transações e consultar transações existentes.

## Funcionalidades

- **Processar Pagamento:** Permite realizar um pagamento e retorna os detalhes da transação.
- **Estornar Pagamento:** Permite estornar um pagamento existente utilizando o ID da transação.
- **Consultar Pagamento:** Permite consultar detalhes de uma transação por ID.
- **Consultar Todos os Pagamentos:** Retorna todas as transações realizadas.

## Endpoints

### Processar Pagamento

- **URL:** `/pagamentos`
- **Método:** `POST`
- **Corpo da Requisição:**
  ```json
  {
    "cartao": "4444********1234",
    "valor": "500.50",
    "dataHora": "01/05/2021 18:30:00",
    "estabelecimento": "PetShop Mundo cão",
    "tipo": "AVISTA",
    "parcelas": 1
  }

Resposta:
{
  "id": "100023568900001",
  "cartao": "4444********1234",
  "valor": "500.50",
  "dataHora": "01/05/2021 18:30:00",
  "estabelecimento": "PetShop Mundo cão",
  "nsu": "1234567890",
  "codigoAutorizacao": "147258369",
  "status": "AUTORIZADO",
  "tipo": "AVISTA",
  "parcelas": 1
}

Estornar Pagamento
URL: /estornos/{id}
Método: POST
Resposta:
{
  "id": "100023568900001",
  "cartao": "4444********1234",
  "valor": "500.50",
  "dataHora": "01/05/2021 18:30:00",
  "estabelecimento": "PetShop Mundo cão",
  "nsu": "1234567890",
  "codigoAutorizacao": "147258369",
  "status": "CANCELADO",
  "tipo": "AVISTA",
  "parcelas": 1
}

Consultar Pagamento
URL: /pagamentos/{id}
Método: GET
Resposta:
{
  "id": "100023568900001",
  "cartao": "4444********1234",
  "valor": "500.50",
  "dataHora": "01/05/2021 18:30:00",
  "estabelecimento": "PetShop Mundo cão",
  "nsu": "1234567890",
  "codigoAutorizacao": "147258369",
  "status": "AUTORIZADO",
  "tipo": "AVISTA",
  "parcelas": 1
}

Consultar Todos os Pagamentos
URL: /pagamentos
Método: GET
Resposta:
{
    "id": "100023568900001",
    "cartao": "4444********1234",
    "valor": "500.50",
    "dataHora": "01/05/2021 18:30:00",
    "estabelecimento": "PetShop Mundo cão",
    "nsu": "1234567890",
    "codigoAutorizacao": "147258369",
    "status": "AUTORIZADO",
    "tipo": "AVISTA",
    "parcelas": 1
}


Tecnologias Utilizadas
Java 17
Spring Boot 3.2.2
JUnit 5
