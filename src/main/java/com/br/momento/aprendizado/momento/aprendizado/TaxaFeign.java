package com.br.momento.aprendizado.momento.aprendizado;

import com.br.momento.aprendizado.momento.aprendizado.models.Taxa;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "obtem-taxas", url = "https://api.bcb.gov.br/dados/serie")
public interface TaxaFeign {

    @GetMapping("/bcdata.sgs.{serie}/dados?formato=json&dataInicial={dataInicial}&dataFinal={dataFinal}")
    List<Taxa> obtemJsonTaxa(@PathVariable String serie, @PathVariable String dataInicial, @PathVariable String dataFinal);

}
