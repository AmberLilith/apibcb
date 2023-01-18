package com.br.momento.aprendizado.momento.aprendizado;

import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "get-rates", url = "https://api.bcb.gov.br/dados/serie")
public interface SerieFeign {

    @GetMapping("/bcdata.sgs.{serie}/dados?formato=json&dataInicial={initialDate}&dataFinal={finalDate}")
    List<Serie> getSerie(@PathVariable String serie, @PathVariable String initialDate, @PathVariable String finalDate);

}
