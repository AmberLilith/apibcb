package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.SerieRate;
import com.br.momento.aprendizado.momento.aprendizado.services.SeriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-bcb/v2")
@CrossOrigin(origins = "*")
@Api(value = "API REST - Consumindo API Dados Abertos Banco Central do Brasil")
public class SerieController {

    @Autowired
    SeriesService ratesService;

    @PostMapping("{initialDate}/{finalDate}")
    @ApiOperation(value = "Retorna relação de taxas todas as taxas informadas no body da requisição dentro do período informado (Data inicial e data final). As respostas dos enpoints no BCB deve retornar resultados por mês.")
    public ResponseEntity<Map<String, List<Map<String, Double>>>> getSeveralsSeries(@RequestBody List<SerieRate> series, @PathVariable String initialDate, @PathVariable String finalDate) {
        Map<String, List<Map<String, Double>>> maps = ratesService.getSeries(series, initialDate, finalDate);
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

}
