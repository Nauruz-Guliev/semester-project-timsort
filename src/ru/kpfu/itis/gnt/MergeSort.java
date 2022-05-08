package ru.kpfu.itis.gnt;

public class MergeSort {
    public static void sort(int[] arr, int start, int stop) {
        if (start>=stop) {
            return;
        }
        int middle = start + (stop - start)/2;
        sort(arr, start, middle);
        sort(arr, middle+1, stop);
        Merging.merge(arr, start, middle, stop);
    }
}
