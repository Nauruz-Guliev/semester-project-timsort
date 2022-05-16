package ru.kpfu.itis.gnt;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Sort sort = new TimSort();

        int[] arr = new int[]{4, 100, 9, 2, 3, 1000, -19, 344, 6, 23, 8};
        for (int i : arr) { System.out.print(i + " "); }
        sort.sort(arr, 1, 5);
        System.out.println("\n");
        for (int i : arr) { System.out.print(i + " "); }
    }
}
