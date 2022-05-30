package org.example;

public class Statistics {
    private final int[] data;

    public static void main(String[] args) {
        Statistics stat = new Statistics(new int[]{5, 7, 12, 1});
        System.out.println(stat.getMax());
    }

    public Statistics(int[] data) {
        this.data = data;
    }

    public int getMax(){
        int max = data[0];
        for(int d : data){
            max = (d>max)?d:max;
        }
        return max;
    }
}
