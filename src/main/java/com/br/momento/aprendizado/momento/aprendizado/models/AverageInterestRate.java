package com.br.momento.aprendizado.momento.aprendizado.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageInterestRate {

    private String date;

    @JsonAlias({"valor"})
    private Double averageInterestRate;

}
