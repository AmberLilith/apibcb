package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TaxasService {
    public List<TaxaMediaJuros> obtemTaxaMediaJurosPorPeriodo(String dataInicial, String dataFinal) {
        RestTemplate restTemplate = new RestTemplate();

        TaxaMediaJuros[] taxaMediaJuros = restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.20744/dados?formato=json&" +
                        "dataInicial=" + dataInicial + "&" +
                        "dataFinal=" + dataFinal,
                TaxaMediaJuros[].class);
        return Arrays.asList(taxaMediaJuros);

    }

    public List<TaxaInadimplencia> obtemTaxasInadimplenciaPorPeriodo(String dataInicial, String dataFinal) {
        RestTemplate restTemplate = new RestTemplate();

        TaxaInadimplencia[] taxaInadimplencias = restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.21116/dados?formato=json&" +
                        "dataInicial=" + dataInicial + "&" +
                        "dataFinal=" + dataFinal,
                TaxaInadimplencia[].class);
        return Arrays.asList(taxaInadimplencias);

    }

    public List<TaxaMediaJuros> obtemTaxaMediaJurosPorQuantidadeMeses(Integer quantidadeMeses) {
        RestTemplate restTemplate = new RestTemplate();
        TaxaMediaJuros[] taxaMediaJuros = restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.20744/dados/ultimos/" +
                        quantidadeMeses + "?formato=json",
                TaxaMediaJuros[].class);
        return Arrays.asList(taxaMediaJuros);
    }

    public List<TaxaInadimplencia> obtemTaxasInadimplenciaPorQuantidadeMeses(Integer quantidadeMeses) {
        RestTemplate restTemplate = new RestTemplate();
        TaxaInadimplencia[] taxaInadimplencias = restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.21116/dados/ultimos/" +
                        quantidadeMeses + "?formato=json",
                TaxaInadimplencia[].class);
        return Arrays.asList(taxaInadimplencias);
    }

    public List<TaxaMediaJuros> obtemTaxaMediaJurosUltimosOnzeAnos() {
        RestTemplate restTemplate = new RestTemplate();
        TaxaMediaJuros[] taxaMediaJuros = restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.20744/dados?formato=json",
                TaxaMediaJuros[].class);
        return Arrays.asList(taxaMediaJuros);
    }

    public List<TaxaInadimplencia> obtemTaxasInadimplenciaUltimosOnzeAnos() {
        RestTemplate restTemplate = new RestTemplate();
        TaxaInadimplencia[] taxaInadimplencias = restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.21116/dados?formato=json",
                TaxaInadimplencia[].class);
        return Arrays.asList(taxaInadimplencias);
    }
}
