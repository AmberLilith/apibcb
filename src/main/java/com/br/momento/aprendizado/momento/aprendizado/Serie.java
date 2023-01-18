package com.br.momento.aprendizado.momento.aprendizado;

import lombok.Data;

@Data
public class Serie {

    private String serie;

    private String name;

    public void setName(String name) {
        this.name = name.replace(" ", "");
    }
}
