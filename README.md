## MiltankBank
![Badge Concluído](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)
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
As funcionalidades foram divididas por [Autenticação](#autenticação), [Receita](#receita), [Despesa](#despesa) e [Resumo](#resumo).

Antes de acessar qualquer Endpoint da API, você precisa se autenticar.

Utilizando o Nome de Usuário "ashKetchum" e a Senha "Pikachu@123" vai gerar um JWT Token com duração de 1 dia

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

### Autenticação
* [/auth]
  * [Autenticar Usuário](#autenticar-usuário)
### Receita
* [/receitas]
  * [Cadastrar Receita](#cadastrar-receita)
  * [Listar Receita](#listar-receita)
  * [Detalhar Receita](#detalhar-receita)
  * [Atualizar Receita](#atualizar-receita)
  * [Excluir Receita](#excluir-receita)
  * [Busca de Receita pela Descrição](#buscar-receita-por-descrição)
  * [Listar Receita por Mês](#listar-receita-por-mês)

### Despesa
* [/despesas]
  * [Cadastrar Despesa](#cadastrar-despesa)
  * [Listar Despesa](#listar-despesa)
  * [Detalhar Despesa](#detalhar-despesa)
  * [Atualizar Despesa](#atualizar-despesa)
  * [Excluir Despesa](#excluir-despesa)
  * [Busca de Despesa pela Descrição](#buscar-despesa-por-descrição)
  * [Listar Despesa por Mês](#listar-despesa-por-mês)

### Resumo
* [/resumo]
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

### Autenticar Usuário
* Método HTTP
  * POST
* API Endpoint
  * /auth
* Response 200 (application/json)
  ```json
    {
        "nomeUsuario": "ashKetchum",
	    "senha": "Pikachu@123"
    }
  ```
* Response 400 (application/json)
  * O body da resposta é vazio.

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
* Response 400 (application/json)
  * O body da resposta retornada é: "Não existe receitas cadastradas".

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
* Response 400 (application/json)
  * O body da resposta retornada é: "Receita não foi encontrada para o id: {id}".

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
  * O body da resposta retornada é o id da receita.
* Response 400 (application/json)
  * O body da resposta retornada é: "A receita de id: {id} já foi excluída anteriormente".

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
* Response 400 (application/json)
  * O body da resposta retornada é: "Não existe despesas para a descrição: ?descricaoReceita=descricaoBuscada".


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
* Response 400 (application/json)
  * O body da resposta retornada é: "Não existe receitas para o mês {mes} do ano de {ano}".

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
* Response 400 (application/json)
  * O body da resposta retornada é: "Não existe despesas cadastradas".

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
* Response 400 (application/json)
  * O body da resposta retornada é: "Despesa não foi encontrada para o id: {id}".

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
  * O body da resposta retornada é o id da despesa.
* Response 400 (application/json)
  * O body da resposta retornada é: "A despesa de id: {id} já foi excluída anteriormente".

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
* Response 400 (application/json)
  * O body da resposta é: "Não existe despesas para a descrição: ?descricaoDespesa=descricaoBuscada".


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
* Response 400 (application/json)
  * O body da resposta é: "Não existe despesas para o mês {mes} do ano de {ano}".

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
* Response 400 (application/json)
  * O body da resposta é: "Não existe resumo para o mês {mes} do ano de {ano}".
### Pessoas Desenvolvedoras

[<p align="center"><img src="https://avatars.githubusercontent.com/u/48693812?s=400&u=e3b46f180b450fc7e0bdc65bbbf68e4a77f8d121&v=4" width=115 ><br><sub>Yan Andrade de Sena</sub>](https://github.com/yandrade1305)</p>

### Conclusão

Quando recebi o e-mail da Alura falando que iriam lançar uma segunda edição do desafio Back-end eu fiquei com receio de participar, pois tinha entrado recentemente no mundo do desenvolvimento Web e começava no mesmo dia das aulas da UnB... Porém, decidi arriscar e dizer "sim".

Com planejamento e muitas horas de estudo e desenvolvendo consegui chegar ao tão esperado resultado satisfatório, o começo foi tranquilo e, no decorrer das semanas, o nível foi subindo. Mas, ao longo do desenvolvimento do projeto, eu me sentia muito feliz e realizado, pois sabia o que estava programando, sabia a parte lógica que estava por detrás de cada Endpoint da API, e via que o conteúdo que havia estudado anteriormente, tanto no incrível Hyper Training 2.0 da <a href="https://www.linkedin.com/company/mirante-tecnologia/">Mirante Tecnologia</a> quanto nos cursos da <a href="https://www.alura.com.br/">Alura</a>, estava sendo diretamente aplicado.

Tive diversas adversidades (principalmente esta última semana que não consegui fazer o deploy, foi o único requisito que não consegui implementar) mas isso não invalida todo o aprendizado que consegui quando "sai do outro lado", é aquela famosa frase <i>"Feito é melhor do que perfeito"<i>.

O meu mais sincero obrigado a toda equipe do Alura e a dois profissionais que admiro que são eles: <a href="https://www.linkedin.com/in/ivan-santos-37289436/">Ivan Santos</a> e Welder Pinheiro Luz (E-mail: <a href="wweellddeerr@gmail.com">wweellddeerr@gmail.com</a>)
