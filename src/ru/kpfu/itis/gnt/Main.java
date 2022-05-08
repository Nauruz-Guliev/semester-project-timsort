package ru.kpfu.itis.gnt;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arrRandom = random.ints(10000, 1,1000).toArray();
        Integer [] arr = Arrays.stream(arrRandom).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));
        //InsertionSort.sort(arr, 0, arr.length-1);
        //TimSort.sort(arr);
        MergeSort.sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
