package org.example;

import java.util.Arrays;
import java.util.Random;

public class CountingGenerator {
    // Заполнение массива с помощью генератора (
    public static <T> void fill(T[] arr, Generator<T> gen){
        for(int i = 0; i<arr.length; i++){
            arr[i] = gen.next();
        }
    }

    // Генератор последовательных целых значений
    public static Generator<Integer> makeIntegerGenerator(){
        return new IntegerGenerator();
    }

    public static Generator<Integer> makeIntegerGenerator(int startWith){
        return new IntegerGenerator(startWith);
    }

    // Генератор случайных целых чисел с использованием анонимного внутреннего класса
    public static Generator<Integer> makeRandomIntegerGenerator(final int maxValue){
        return new Generator<Integer>(){
            private static Random rand = new Random();
            @Override
            public Integer next() {
                return rand.nextInt(maxValue);
            }
        };
    }

    // TODO Сделать анонимным внутренним классом
    private static class IntegerGenerator implements Generator{
        private int value = 0;
        IntegerGenerator(){

        }
        IntegerGenerator(int startWith){
            this.value = startWith;
        }
        @Override
        public Object next() {
            return value++;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        fill(arr,makeRandomIntegerGenerator(100));
        System.out.println(Arrays.toString(arr));
    }
}
