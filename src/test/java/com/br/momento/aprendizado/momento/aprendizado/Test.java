package com.br.momento.aprendizado.momento.aprendizado;

import java.util.HashMap;
import java.util.Map;

/*class Tipos {

    @Getter
    static class MediaJuros{
        private static final String SERIE = "20744";
        private static final AverageInterestRate TAXA_MEDIA_JUROS = new AverageInterestRate();
    }


    @Getter
    static class Inadimplencia{
         static final String SERIE = "21116";
         static final DefaultRate TAXA_INADIMPLENCIA = new DefaultRate();
    }
}*/


public class Test {

    @org.junit.jupiter.api.Test
    public void teste() {
        Map<String, Integer> map = new HashMap<>();
        map.put("um", 1);
        map.put("dois",2);
        map.put("dois",24);
        System.out.println(map);
    }
}
