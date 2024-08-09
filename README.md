Aqui está o conteúdo para o `README.md` em um arquivo `.txt`. Você pode copiar o texto abaixo e salvar em um arquivo `README.txt`:

```plaintext
# Tools Challenge

## Descrição

Este é um projeto de exemplo para a prova prática de um desenvolvedor Java. O objetivo do projeto é implementar uma API de Pagamentos com as seguintes funcionalidades:

- Realização de pagamentos.
- Estorno de pagamentos.
- Consulta de pagamentos.
- Consulta de todos os pagamentos.

A API foi desenvolvida usando Spring Boot e está configurada para rodar em um servidor embutido. As respostas da API seguem o padrão JSON e utilizam conceitos REST e HTTP.

## Funcionalidades

### Pagamento

- **Endpoint:** `/pagamento`
- **Método:** `POST`
- **Request Body:**
  ```json
  {
    "cartao": "4444********1234",
    "valor": "500.50",
    "dataHora": "01/05/2021 18:30:00",
    "estabelecimento": "PetShop Mundo cão",
    "tipo": "AVISTA",
    "parcelas": "1"
  }
  ```
- **Response Body:**
  ```json
  {
    "transacao": {
      "cartao": "4444********1234",
      "id": "100023568900001",
      "descricao": {
        "valor": "500.50",
        "dataHora": "01/05/2021 18:30:00",
        "estabelecimento": "PetShop Mundo cão"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      },
      "nsu": "1234567890",
      "codigoAutorizacao": "147258369",
      "status": "AUTORIZADO"
    }
  }
  ```

### Estorno

- **Endpoint:** `/estorno/{id}`
- **Método:** `POST`
- **Response Body:**
  ```json
  {
    "transacao": {
      "cartao": "4444********1234",
      "id": "100023568900001",
      "descricao": {
        "valor": "500.50",
        "dataHora": "01/05/2021 18:30:00",
        "estabelecimento": "PetShop Mundo cão"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      },
      "nsu": "1234567890",
      "codigoAutorizacao": "147258369",
      "status": "CANCELADO"
    }
  }
  ```

### Consulta de Pagamentos

- **Endpoint:** `/pagamento/{id}`
- **Método:** `GET`
- **Response Body:**
  ```json
  {
    "transacao": {
      "cartao": "4444********1234",
      "id": "100023568900001",
      "descricao": {
        "valor": "500.50",
        "dataHora": "01/05/2021 18:30:00",
        "estabelecimento": "PetShop Mundo cão"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      },
      "nsu": "1234567890",
      "codigoAutorizacao": "147258369",
      "status": "AUTORIZADO"
    }
  }
  ```

### Consulta de Todos os Pagamentos

- **Endpoint:** `/pagamento`
- **Método:** `GET`
- **Response Body:**
  ```json
  {
    "transacoes": [
      {
        "cartao": "4444********1234",
        "id": "100023568900001",
        "descricao": {
          "valor": "500.50",
          "dataHora": "01/05/2021 18:30:00",
          "estabelecimento": "PetShop Mundo cão"
        },
        "formaPagamento": {
          "tipo": "AVISTA",
          "parcelas": "1"
        },
        "nsu": "1234567890",
        "codigoAutorizacao": "147258369",
        "status": "AUTORIZADO"
      }
    ]
  }
  ```
