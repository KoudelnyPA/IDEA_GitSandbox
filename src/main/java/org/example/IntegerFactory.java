package org.example;

import java.util.Iterator;
import java.util.Random;

public class IntegerFactory {
    public static Iterable<Integer> createIntegerArray(final int size){
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int[] arr = new int[size];
                    static final Random rand = new Random();
                    {
                        for(int i = 0; i<arr.length; i++){
                            arr[i] = rand.nextInt();
                        }
                    }
                    int current = 0;
                    @Override
                    public boolean hasNext() {
                        return current < arr.length;
                    }

                    @Override
                    public Integer next() {
                        if(hasNext()){
                            return arr[current++];
                        }
                        else{
                            throw new ArrayIndexOutOfBoundsException();
                        }
                    }
                };
            }
        };
    }


}
