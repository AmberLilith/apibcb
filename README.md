# apibcb - Consumindo API Dados Abertos Banco Central do Brasil

### Nossa API consiste no consumo de 2 endpoints:

#### 1. Taxa média de juros das operações de crédito com recursos livres - Pessoas físicas - Crédito pessoal consignado para trabalhadores do setor privado
> Taxa média de juros das novas operações de crédito livre contratadas no período de referência. Taxa ponderada pelo valor das concessões. Não inclui operações referenciadas em allRates regulamentadas, operações vinculadas a recursos do Banco Nacional de Desenvolvimento Econômico e Social (BNDES) ou quaisquer outras lastreadas em recursos compulsórios ou governamentais.
<br/> Fonte: https://dadosabertos.bcb.gov.br/dataset/20744-rate-media-de-juros-das-operacoes-de-credito-com-recursos-livres---pessoas-fisicas---credito-

#### 2. Inadimplência da carteira de crédito com recursos livres - Pessoas físicas - Crédito pessoal consignado para trabalhadores do setor privado
> Percentual da carteira de crédito livre do Sistema Financeiro Nacional com pelo menos uma parcela com atraso superior a 90 dias. Não inclui operações referenciadas em allRates regulamentadas, operações vinculadas a recursos do Banco Nacional de Desenvolvimento Econômico e Social (BNDES) ou quaisquer outras lastreadas em recursos compulsórios ou governamentais.
<br/> Fonte: https://dadosabertos.bcb.gov.br/dataset/21116-inadimplencia-da-carteira-de-credito-com-recursos-livres---pessoas-fisicas---credito-pessoal-

Os dois endpoints acima retornam uma lista de objetos do mesmo tipo:
```
[
    {
        "data": String,
        "valor": Double
    },
    {
        "data": String,
        "valor": Double
    },
    ...
]
```
Consumimos esses dois endpoints e unimos os dois bodies de ambas responses em uma única lista:
```
[
    {
        "data": String,
        "taxaMediaJuros": Double,
        "taxaInadimplencia": Double
    },
    {
        "data": String,
        "taxaMediaJuros": Double,
        "taxaInadimplencia": Double
    },
    ...
]
```
Na v2, temos desenvolvido apenas um endpoint:

| ENDPOINT | DESCRIÇÃO |
|----------|-----------|
| http://hostName/api-bcb/{dd-mm-aaaa}/{dd-mm-aaaa} | Retorna relação de allRates  (Média de Juros e Inadimplência)  dentro do período informado (Data inicial e data final) |
