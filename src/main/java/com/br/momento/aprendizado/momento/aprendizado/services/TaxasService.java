package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.TaxaFeign;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaxasService {

    @Autowired
    private TaxaFeign taxaFeign;

    public List obtemTaxa(String serie, String dataInicial, String dataFinal) throws JsonProcessingException {
        String json = taxaFeign.obtemJsonTaxa(serie, dataInicial, dataFinal);
        ObjectMapper mapper = new ObjectMapper();
        return switch (serie) {
            case "20744" -> Arrays.asList(mapper.readValue(json, TaxaMediaJuros[].class));
            case "21116" -> Arrays.asList(mapper.readValue(json, TaxaInadimplencia[].class));
            default -> null;
        };
    }
}
