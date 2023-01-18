package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.models.Series;
import com.br.momento.aprendizado.momento.aprendizado.services.SerieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-bcb/v2")
@CrossOrigin(origins = "*")
@Api(value = "API REST - Consumindo API Dados Abertos Banco Central do Brasil")
public class SerieController {

    @Autowired
    SerieService taxasService;

    @GetMapping("{initialDate}/{finalDate}")
    @ApiOperation(value = "Retorna relação de taxas (Média de Juros e Inadimplência) dentro do período informado (Data inicial e data final)")
    public ResponseEntity<List<Series>> getSeries(@PathVariable String initialDate, @PathVariable String finalDate) {
        List<Series> taxas = taxasService.getSeries(initialDate, finalDate);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }
}
