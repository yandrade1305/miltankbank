## MiltankBank
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![Badge Java](http://img.shields.io/static/v1?label=JAVA&message=11.0.13&color=yellow&style=for-the-badge)
![Badge Spring](http://img.shields.io/static/v1?label=SPRING&message=2.6.2&color=GREEN&style=for-the-badge)
![Badge PostgreSQL](http://img.shields.io/static/v1?label=POSTGRESQL&message=13.4&color=blue&style=for-the-badge)
<p align="center">
  <img src="https://user-images.githubusercontent.com/48693812/152577973-e5bd1259-456a-4506-9953-db3311c03da5.png" />
</p>



## Índice 

* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Métodos](#métodos)
* [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras)
* [Conclusão](#conclusão)

## Descrição do Projeto
Miltankbank é uma API Rest para controle de orçamento familiar desenvolvido por causa do Alura Challenge Back-end.

O nome foi pensado para aqueles que são assim como eu "mão-de-vaca", fazendo referência ao Pokémon Miltank.

## Funcionalidades
As funcionalidades foram divididas por [Receita](#receita), [Despesa](#despesa) e [Resumo](#resumo).

As Receitas são todos os ganhos como renda fixa ou variável.

As Despesas são todos os gastos e são divididos em 7 categorias. Que são elas:
* Alimentação;
* Saúde;
* Moradia;
* Transporte;
* Educação;
* Lazer;
* Imprevistos;
* Outras.

O resumo do mês contêm as seguintes informações:
* Valor total das receitas no mês
* Valor total das despesas no mês
* Saldo final no mês
* Valor total gasto no mês em cada uma das categorias



### Receita [/receitas]
* [Cadastrar Receita](#cadastrar-receita)
* [Listar Receita](#listar-receita)
* [Detalhar Receita](#detalhar-receita)
* [Atualizar Receita](#atualizar-receita)
* [Excluir Receita](#excluir-receita)
* [Busca de Receita pela Descrição](#buscar-receita-por-descrição)
* [Listar Receita por Mês](#listar-receita-por-mês)

### Despesa [/despesas]
* [Cadastrar Despesa](#cadastrar-despesa)
* [Listar Despesa](#listar-despesa)
* [Detalhar Despesa](#detalhar-despesa)
* [Atualizar Despesa](#atualizar-despesa)
* [Excluir Despesa](#excluir-despesa)
* [Busca de Despesa pela Descrição](#buscar-despesa-por-descrição)
* [Listar Despesa por Mês](#listar-despesa-por-mês)

### Resumo [/resumo]
* [Detalhar Resumo do Mês](#detalhar-resumo-por-mês)

## Métodos
&emsp;&emsp; As requisições para a API devem seguir os padrões:

<center>
  
| Método   | Descrição                                             |
|:---------|-------------------------------------------------------|
| `GET`    | Retorna informações de um ou mais registros.          |
| `POST`   | Utilizado para criar unm novo registro.               |
| `PUT`    | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema.                        |

</center>

### Cadastrar Receita
* Método HTTP
  * POST
* API Endpoint
  * receita
* Response 201 (application/json)
  ```json
  {
      "descricaoReceita": "Descrição da receita cadastrada.",
      "valorReceita": "Valor da receita cadastrada.",
      "dataReceita": "data da receita cadastrada."
  }
  ```
* Response 400 (application/json)
  * Não pode ter duas receitas com a mesma descrição no mesmo mês.

### Listar Receita
* Método HTTP
  * GET
* API Endpoint
  * receitas
* Response 200 (application/json)
  ```json
  [
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    },
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    }
  ]
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Detalhar Receita
* Método HTTP
  * GET
* API Endpoint
  * receita/{id}
* Response 200 (application/json)
  ```json
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    }
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Atualizar Receita
* Método HTTP
  * PUT
* API Endpoint
  * receita/{id}
* Response 200 (application/json)
  ```json
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    }
  ```
* Response 400 (application/json)
  * Não pode ter duas receitas com a mesma descrição no mesmo mês.

### Excluir Receita
* Método HTTP
  * DELETE
* API Endpoint
  * receita/{id}
* Response 200 (application/json)
  * O body da resposta retornada é vazia.

### Buscar Receita por Descrição
* Método HTTP
  * GET
* API Endpoint
  * /receitas/?descricaoReceita=descricaoBuscada
* Response 200 (application/json)
  ```json
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    }
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.


### Listar Receita por Mês
* Método HTTP
  * GET
* API Endpoint
  * /receitas/{ano}/{mes}
* Response 200 (application/json)
  ```json
  [
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    },
    {
        "idReceita": "Id da receita.",
        "descricaoReceita": "Descrição da receita.",
        "valorReceita": "Valor da receita.",
        "dataReceita": "data da receita."
    }
  ]
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Cadastrar Despesa
* Método HTTP
  * POST
* API Endpoint
  * despesa
* Response 201 (application/json)
  ```json
  {
      "descricaoDespesa": "Descrição da despesa cadastrada.",
      "valorDespesa": "Valor da despesa cadastrada.",
      "dataDespesa": "data da despesa cadastrada.",
      "idCategoria": "Id da categoria"
  }
  ```
* Response 400 (application/json)
  * Não pode ter duas despesas com a mesma descrição no mesmo mês.

### Listar Despesa
* Método HTTP
  * GET
* API Endpoint
  * despesas
* Response 200 (application/json)
  ```json
  [
    {
        "idDespesa": "Id da despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa.",
        "descricaoCategoria": "Descrição da categoria"
    },
    {
        "idDespesa": "Id da despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa.",
        "descricaoCategoria": "Descrição da categoria"
    }
  ]
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Detalhar Despesa
* Método HTTP
  * GET
* API Endpoint
  * despesa/{id}
* Response 200 (application/json)
  ```json
    {
        "idDespesa": "Id da despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa.",
        "categoriaDTO": {
		    "idCategoria": "Id da categoria",
		    "descricaoCategoria": "Descrição da categoria"
        }
    }
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Atualizar Despesa
* Método HTTP
  * PUT
* API Endpoint
  * despesa/{id}
* Response 200 (application/json)
  ```json
    {
        "idDespesa": "Id da despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa.",
        "idCategoria": "Id da categoria"
    }
  ```
* Response 400 (application/json)
  * Não pode ter duas despesas com a mesma descrição no mesmo mês.

### Excluir Despesa
* Método HTTP
  * DELETE
* API Endpoint
  * despesa/{id}
* Response 200 (application/json)
  * O body da resposta retornada é vazia.

### Buscar Despesa por Descrição
* Método HTTP
  * GET
* API Endpoint
  * /despesas/?descricaoDespesa=descricaoBuscada
* Response 200 (application/json)
  ```json
    {
        "idDespesa": "Id da despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa.",
		"descricaoCategoria": "Descrição da categoria"
    }
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.


### Listar Despesa por Mês
* Método HTTP
  * GET
* API Endpoint
  * /despesas/{ano}/{mes}
* Response 200 (application/json)
  ```json
  [
    {
        "idDespesa": "Id da despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa."
    },
    {
        "idDespesa": "Id da Despesa.",
        "descricaoDespesa": "Descrição da despesa.",
        "valorDespesa": "Valor da despesa.",
        "dataDespesa": "data da despesa."
    }
  ]
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Detalhar Resumo por Mês
* Método HTTP
  * GET
* API Endpoint
  * /resumo/{ano}/{mes}
* Response 200 (application/json)
  ```json
    {
        "valorTotalReceita": "Valor total de receitas",
        "valorTotalDespesa": "Valor total de despesas",
        "saldoFinal": "Valor total de receitas - Valor total de despesas",
        "valorTotalGastoEmAlimentacao": "Valor total gasto em Alimentação",
        "valorTotalGastoEmSaude": "Valor total gasto em Saúde",
        "valorTotalGastoEmMoradia": "Valor total gasto em Moradia",
        "valorTotalGastoEmTransporte": "Valor total gasto em Transporte",
        "valorTotalGastoEmEducacao": "Valor total gasto em Educação",
        "valorTotalGastoEmLazer": "Valor total gasto em Lazer",
        "valorTotalGastoEmImprevistos": "Valor total gasto em Imprevistos",
        "valorTotalGastoEmOutras": "Valor total gasto em Outras"
    }
  ```
* Response 204 (application/json)
  * O body da resposta retornada é vazia.

### Pessoas Desenvolvedoras

[<p align="center"><img src="https://avatars.githubusercontent.com/u/48693812?s=400&u=e3b46f180b450fc7e0bdc65bbbf68e4a77f8d121&v=4" width=115 ><br><sub>Yan Andrade de Sena</sub>](https://github.com/yandrade1305)</p>

### Conclusão

Quando recebi o e-mail da Alura falando que iriam lançar uma segunda edição do desafio Back-end eu fiquei com receio de participar pois estava recentemente entrando no mundo
do desenvolvimento Web... Porém decidi arriscar e dizer "sim". Com planejamento e muitas horas de estudo e desenvolvendo consegui chegar no resultado satisfatório tão esperado, o começo foi tranquilo e com o dercorrer das semans o nível foi subindo. Mas consegui chegar do outro lado, o meu mais sincero obrigado a toda equipe do Alura e a dois profissionais que admiro que são eles: <a href="https://www.linkedin.com/in/ivan-santos-37289436/">Ivan Santos</a> e Welder
