package org.example;

import java.util.Arrays;

public class ArrayExample {
    private int[] arr;
    ArrayExample(int size){
        arr = new int[size];
    }
    ArrayExample(int size, int defValue){
        this(size);
        Arrays.fill(arr, defValue);
    }

    public void fillByGenerator(Generator<Integer> generator){
        for(int i=0; i< arr.length; i++){
            arr[i] = generator.next();
        }
    }

    public void fillByCounter(){
        fillByGenerator(CountingGenerator.makeIntegerGenerator());
    }

    public void fillByCounter(int startWith){
        fillByGenerator(CountingGenerator.makeIntegerGenerator(startWith));
    }

    @Override
    public String toString() {
        return "ArrayExample{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        ArrayExample arr = new ArrayExample(8);
        arr.fillByCounter(3);
        System.out.println(arr);
    }
}
