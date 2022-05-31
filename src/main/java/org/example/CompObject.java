package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class CompObject implements Comparable<CompObject>{
    private static Generator<Integer> gen = CountingGenerator.makeRandomIntegerGenerator(100);
    private int value = gen.next();

    @Override
    public int compareTo(CompObject rv) {
        return Integer.compare(this.value, rv.value);
    }

    @Override
    public String toString() {
        return "CompObject{" +
                "value=" + value +
                '}';
    }

    static class ReverseOrder implements Comparator<CompObject> {
        @Override
        public int compare(CompObject obj1, CompObject obj2) {
            return Integer.compare(obj2.value, obj1.value);
        }
    }

    public static void main(String[] args) {
        CompObject[] arr = new CompObject[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new CompObject();
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new ReverseOrder());
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,arr[arr.length-1],new ReverseOrder()));
    }


}
