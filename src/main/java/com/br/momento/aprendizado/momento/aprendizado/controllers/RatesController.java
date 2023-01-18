package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.Serie;
import com.br.momento.aprendizado.momento.aprendizado.services.RatesService;
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
public class RatesController {

    @Autowired
    RatesService ratesService;

    @PostMapping("{dataInicial}/{dataFinal}")
    @ApiOperation(value = "Retorna relação de taxas todas as taxas informadas no body da requisição dentro do período informado (Data inicial e data final)")
    public ResponseEntity<Map<String, List<Map<String, Double>>>> obtemXTaxas(@RequestBody List<Serie> series, @PathVariable String dataInicial, @PathVariable String dataFinal) {
        Map<String, List<Map<String, Double>>> maps = ratesService.getSeries(series, dataInicial, dataFinal);
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

}
