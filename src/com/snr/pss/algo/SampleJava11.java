package com.snr.pss.algo;

import java.util.Arrays;

public class SampleJava11 {
    public static void main(String[] args){
        int[] values = new int[] {1,2,3};
        Arrays.stream(values).forEach(value -> System.out.println(value));
    }
}
