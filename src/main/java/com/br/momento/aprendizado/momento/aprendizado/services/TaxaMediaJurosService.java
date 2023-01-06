package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaxaMediaJurosService {
    public TaxaMediaJuros[] obtemTaxaMediaJuros(String dataInicial, String dataFinal) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.20744/dados?formato=json&" +
                        "dataInicial=" + dataInicial + "&" +
                        "dataFinal=" + dataFinal,
                TaxaMediaJuros[].class );

    }

    public TaxaInadimplencia[] obtemTaxasInadimplencia(String dataInicial, String dataFinal) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "https://api.bcb.gov.br/dados/serie/bcdata.sgs.21116/dados?formato=json&" +
                        "dataInicial=" + dataInicial + "&" +
                        "dataFinal=" + dataFinal,
                TaxaInadimplencia[].class );

    }
}
