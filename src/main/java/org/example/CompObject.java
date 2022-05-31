package org.example;

import java.util.Arrays;

public class CompObject implements Comparable<CompObject>{
    private static Generator<Integer> gen = CountingGenerator.makeRandomIntegerGenerator(100);
    private int value = gen.next();

    @Override
    public int compareTo(CompObject rv) {
        return (this.value==rv.value) ? 0 : ((this.value>rv.value)?1:-1);
    }

    @Override
    public String toString() {
        return "CompObject{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        CompObject[] arr = new CompObject[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new CompObject();
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
