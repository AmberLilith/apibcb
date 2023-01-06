package com.br.momento.aprendizado.momento.aprendizado;

import com.br.momento.aprendizado.momento.aprendizado.utils.Merger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Test {

    @org.junit.jupiter.api.Test
    public void teste(){
        Object[] obj1 = {1,3,5} ;
        Object[] obj2 = {2,4,6};
        System.out.println(Arrays.toString(Merger.mergerArraySameLength(obj1, obj2)));
    }
}
