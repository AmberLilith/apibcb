package com.br.momento.aprendizado.momento.aprendizado.utils;

public class Merger {

    public static Object[] mergerArraySameLength(Object[]objs1, Object[] objs2){
        Object[] mergedArrays = new Object[objs1.length * 2];
        int i = 0;
        int j = 0;
        while (i < mergedArrays.length){
                   mergedArrays[i] = objs1[j];
                   mergedArrays[i+ 1] = objs2[j];
                   j++;
                   i+=2;
        }
        return mergedArrays;
    }
}
